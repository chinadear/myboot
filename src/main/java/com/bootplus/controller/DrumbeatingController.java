package com.bootplus.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bootplus.Util.CompUtil;
import com.bootplus.Util.Constants;
import com.bootplus.core.base.BaseController;
import com.bootplus.core.base.UserSession;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Blog;
import com.bootplus.model.Category;
import com.bootplus.model.Comment;
import com.bootplus.model.DicItem;
import com.bootplus.model.Drumbeating;
import com.bootplus.model.SysConfig;
import com.bootplus.model.Tag;
import com.bootplus.model.TagBlog;
import com.bootplus.model.UFile;
import com.bootplus.model.User;
import com.bootplus.service.IBlogService;
import com.bootplus.service.ICategoryService;
import com.bootplus.service.ICommentService;
import com.bootplus.service.IDicService;
import com.bootplus.service.IDrumbeatingService;
import com.bootplus.service.ILoginService;
import com.bootplus.service.ISysManageService;
import com.bootplus.service.ITagService;
/**
 * 推广管理
 * 负责banner 以及轮播图，版位等管理
 * @author liulu
 *
 */
@Controller
public class DrumbeatingController extends BaseController {
	
	private final static String RESOURCE_MENU_PREFIX="/member/drumbeating";
	
	@Autowired
	private IDrumbeatingService drumbeatingService;
	@Autowired
	private ISysManageService sysManageService;
	@Autowired 
	private IDicService dicService;
	/**
	 * 进入我的博客管理页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/drumbeating/list")
	public String myblogs(Model model, HttpServletRequest request,String type) {
		Drumbeating db=new Drumbeating();
		type=StringUtils.hasText(type)?type:"0";
		db.setType(type);
		List<Drumbeating> dblist = drumbeatingService.queryDrumbList(db);
		List<DicItem> dlist=dicService.queryDicItemListByDicCode("POSITION");
		model.addAttribute("dblist", dblist);
		model.addAttribute("dlist", dlist);
		model.addAttribute("type",type);
		return RESOURCE_MENU_PREFIX+"/listDrumbeating";
	}
	/**
	 * 刷新列表
	 * @param model
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping("/drumbeating/noSitemesh/loadDurmbeatingtable")
	public String loadDurmbeatingtable(Model model, HttpServletRequest request,String type) {
		Drumbeating db=new Drumbeating();
		db.setType(type);
		List<Drumbeating> dblist = drumbeatingService.queryDrumbList(db);
		model.addAttribute("dblist", dblist);
		return RESOURCE_MENU_PREFIX+"/tableDrumbeating";
	}
	/**
	 * 提交新增
	 * @param file
	 * @param request
	 * @param db
	 * @return
	 */
	@RequestMapping("/drumbeating/add")
	public String add(Model model,@RequestParam("ufile") MultipartFile ufile, HttpServletRequest request,Drumbeating db) {
		if(!ufile.isEmpty()) {
			UFile uf=sysManageService.uploadFile(ufile,"1",null,request);//type=0降低画质，1自定义宽高缩放，2等比缩放，3附件
			if(StringUtils.hasText(uf.getId())) {
				db.setFile(uf);
			}
		}
		drumbeatingService.save(db);
	
		return "redirect:/drumbeating/list?type="+db.getType();
	}
	/**
	 * 初始化编辑窗口
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/drumbeating/noSitemesh/editDrum")
	public String edit(Model model, HttpServletRequest request,String id) {
		Drumbeating drum=drumbeatingService.getDrumbeatingById(id);
		List<DicItem> dlist=dicService.queryDicItemListByDicCode("POSITION");
		model.addAttribute("dlist", dlist);
		model.addAttribute("drum",drum);
		return RESOURCE_MENU_PREFIX+"/editDrumbeating";
	}
	/**
	 * 提交修改
	 * @param ufile
	 * @param request
	 * @param db
	 * @return
	 */
	@RequestMapping("/drumbeating/edit")
	public String edit(@RequestParam("ufile") MultipartFile ufile, HttpServletRequest request,Drumbeating db) {
		Drumbeating drum=drumbeatingService.getDrumbeatingById(db.getId());
		drum.setStatus(db.getStatus());
		drum.setTitle(db.getTitle());
		drum.setSummary(db.getSummary());
		drum.setType(db.getType());
		drum.setUrl(db.getUrl());
		if(!ufile.isEmpty()) {
			UFile uf=sysManageService.uploadFile(ufile,"1",null,request);//type=0降低画质，1自定义宽高缩放，2等比缩放，3附件
			if(StringUtils.hasText(uf.getId())) {
				drum.setFile(uf);
			}
		}
		drumbeatingService.update(drum);
		return "redirect:/drumbeating/list?type="+drum.getType();
	}
	/**
	 * 更新发布状态
	 * @param status
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/drumbeating/updateStatus",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String updateStatus(String status,String id) {
		Drumbeating drum=drumbeatingService.getDrumbeatingById(id);
		drum.setStatus(status);
		drumbeatingService.update(drum);
		return "t";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/drumbeating/delete",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String delete(String id) {
		Drumbeating drum=drumbeatingService.getDrumbeatingById(id);
		drumbeatingService.delete(drum);
		return "t";
	}
}
