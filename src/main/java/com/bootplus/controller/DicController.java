package com.bootplus.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootplus.Util.CompUtil;
import com.bootplus.Util.Constants;
import com.bootplus.Util.TreeBean;
import com.bootplus.core.base.BaseController;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Dic;
import com.bootplus.model.Resource;
import com.bootplus.model.Role;
import com.bootplus.service.IDicService;
import com.bootplus.service.IResourceService;
/**
 * 字典管理
 * @author liulu
 *
 */
@Controller
public class DicController extends BaseController {
	@Autowired 
	private IDicService dicService;
	//页面目录根地址
	private static final String RESOURCE_MENU_PREFIX="/member/dic";
	/**
	 * 字典管理页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/dic/list")
	public String dicList(Model model, HttpServletRequest request) {
		List<Dic> list=dicService.queryDicList(new Dic());
		Page page=dicService.queryDicPage(new Dic(), 1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/listDic";
	}
	/**
	 * 翻页加载
	 * @param model
	 * @param request
	 * @return
	 *//*
	@RequestMapping("/dic/noSitemesh/load")
	public String load(Model model, HttpServletRequest request,String pageNo,String name) {
		Dic dic=new Dic();
		dic.setName(name);
		Page page=dicService.queryDicPage(dic,StringUtils.hasText(pageNo)?Integer.valueOf(pageNo):1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/tableDic";
	}
	*//**
	 * 删除菜单（包括子菜单）
	 * @param model
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value="/resource/deleteMenu",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String deleteMenu(String id){
		Resource resource = new Resource();
		resource.setId(id);
		resourceService.deleteResourcesByParent(resource);
		return "T";
	}
	*//**
	 * 上移下移
	 * @param targetId
	 * @param sourceId
	 * @return
	 *//*
	@RequestMapping(value="/resource/upDownMenu",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String upDownMenu(String targetId,String sourceId){
		Resource targetRes = resourceService.getResourceById(targetId);
		Resource sourceRes = resourceService.getResourceById(sourceId);
		resourceService.swapSeqNum(sourceRes, targetRes);
		return "T";
	}
	*//**
	 * 菜单同级名称重复校验
	 * @param name
	 * @param parent
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value="/resource/judgyName",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String isExistMenuName(String name,String parent,String id){
		String flag="true";
		if(!"".equals(name)){
			Resource res = new Resource();
			res.setId(parent);
			if(resourceService.isExistByParentAndName(res, name, id)){
				flag="false";
			}
		}
		return flag;
	}
	*//**
	 * 菜单code是否重复
	 * @param code
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value="/resource/judgyCode",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String isExistMenuCode(String code,String id){
		String flag="true";
		if(!"".equals(code)){
			Resource res = new Resource();
			res.setId(id);
			res.setCode(code);
			if(resourceService.isExistMenuByCode(code, id)){
				flag="false";
			}
		}
		return flag;
	}*/
}
