package com.bootplus.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.bootplus.model.Category;
import com.bootplus.model.DicItem;
import com.bootplus.model.Role;
import com.bootplus.model.SysConfig;
import com.bootplus.model.UFile;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.bootplus.model.UserRole;
import com.bootplus.service.IAuthService;
import com.bootplus.service.ICategoryService;
import com.bootplus.service.IDicService;
import com.bootplus.service.ILoginService;
import com.bootplus.service.IRoleService;
import com.bootplus.service.ISysManageService;
/**
 * 分类管理
 * 
 * @author liulu
 *
 */
@Controller
public class CategoryController extends BaseController {
	private final static String RESOURCE_MENU_PREFIX="/member/category";
	@Autowired
	private ICategoryService categoryService;
	@Autowired 
	private IDicService dicService;
	@Autowired
	private ISysManageService sysManageService;
	/**
	 * 分类管理
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/category/list")
	public String categoryPage(Model model, HttpServletRequest request) {
		Page page=categoryService.queryCategoryPage(new Category(),1, Page.DEFAULT_PAGE_SIZE);
		List<DicItem> list=dicService.queryDicItemListByDicCode("PLATE");
		model.addAttribute("list", list);
		model.addAttribute("cateList", page);
		return RESOURCE_MENU_PREFIX+"/categoryList";
	}
	/**
	 * 加载分类列表
	 * totalCount:200,//总记录数
	    showPage:5,//分页栏显示页数，其他页数...代替
	    limit:8,//每页显示记录数
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/category/noSitemesh/loadcatetable")
	public String loadcatetable(Model model, HttpServletRequest request,String pageNo) {
		Page page=categoryService.queryCategoryPage(new Category(),StringUtils.hasText(pageNo)?Integer.valueOf(pageNo):1, Page.DEFAULT_PAGE_SIZE);
		List<DicItem> list=dicService.queryDicItemListByDicCode("PLATE");
		model.addAttribute("list", list);
		model.addAttribute("cateList", page);
		return RESOURCE_MENU_PREFIX+"/categoryTable";
	}
	/**
	 * 初始化编辑框
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/category/noSitemesh/editCate")
	public String editCate(Model model,String id){
		Category category=categoryService.getCategoryById(id);
		List<DicItem> list=dicService.queryDicItemListByDicCode("PLATE");
		model.addAttribute("list", list);
		model.addAttribute("category", category);
		return RESOURCE_MENU_PREFIX+"/editCategory";
	}
	/**
	 * 提交新增
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/category/add")
	public String add(Model model,HttpServletRequest request,@RequestParam("ufile") MultipartFile ufile, String name_,String comments_,String type_) {
		Category cate=new Category();
		if(!ufile.isEmpty()) {
			UFile uf=sysManageService.uploadFile(ufile,"4","218",request);//type=0降低画质，1自定义宽高缩放，2等比缩放，3附件
			if(StringUtils.hasText(uf.getId())) {
				cate.setFile(uf);
			}
		}
		cate.setName(name_);
		cate.setComments(comments_);
		cate.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		cate.setType(type_);
		categoryService.save(cate);
		return "redirect:/category/list";
	}
	/**
	 * 提交修改
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/category/edit")
	public String edit(Model model,HttpServletRequest request,@RequestParam("ufile") MultipartFile ufile,Category cat){
		Category cate=categoryService.getCategoryById(cat.getId());
		cate.setName(cat.getName());
		cate.setComments(cat.getComments());
		cate.setType(cat.getType());
		if(!ufile.isEmpty()) {
			UFile uf=sysManageService.uploadFile(ufile,"4","218",request);//type=0降低画质，1自定义宽高缩放，2等比缩放，3附件
			if(StringUtils.hasText(uf.getId())) {
				cate.setFile(uf);
			}
		}
		categoryService.update(cate);
		return "redirect:/category/list";
	}
	/**
	 * 删除分类，逻辑删除
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/category/delete/{id}")
	public String edit(Model model,@PathVariable String id){
		Category cate=categoryService.getCategoryById(id);
		cate.setStatus(Constants.SYSTEM_DIC_DELETE_STATUS);
		categoryService.update(cate);
		return "redirect:/category/list";
	}
	/**
	 * 校验分类名称是否重复
	 * @param name
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/category/isExsit/name",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String judgyName(String name,String id) {
		String flag="true";
		Category cate=new Category();
		cate.setName(name);
		List<Category> catelist=categoryService.getCategoryByName(name);
		if(catelist.size()>0) {//=0直接返回true
			if(StringUtils.hasText(id)) {//编辑情况下要判断是否是自身的情况
				if(catelist.size()==1&&catelist.get(0).getId().equals(id)) {//有一个且是他自己
					flag="true";
				}else {//否则不是他自己则返回false
					flag="false";
				}
			}else {//保存情况下>0必然为false
				flag="false";
			}
		}
		return flag;
	}
}
