package com.bootplus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootplus.core.base.BaseController;
import com.bootplus.core.base.UserSession;
import com.bootplus.model.Resource;
import com.bootplus.service.IResourceService;
/**
 * 主页面
 * @author liulu
 *
 */
@Controller
public class MainController extends BaseController {
	@Autowired 
	private IResourceService resourceService;
	/**
	 *  主页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/")
	public String indexHome(Model model, HttpServletRequest request) {
		List<Resource> list=resourceService.queryResourceList(new Resource());
		if(list.size()==0) {
			return "redirect:/resource/list";
		}else {
			return "/member/mainpage";
		}
		
	}
	@RequestMapping(value="/security/dispatcher/{id}")
	public String menuDispatch(HttpServletRequest request, HttpServletResponse response,@PathVariable String id){
		UserSession userSession=(UserSession)request.getSession().getAttribute(UserSession.SESSION_USER_KEY);
		userSession.setCurMenuId(id);
		List<String> navList=new ArrayList<String>();
		List<String> temp=new ArrayList<String>();
		if("0".equals(id)) {//首页
			navList.add("不显示的根节点");
			navList.add("首页");
			userSession.setNavList(navList);
			return "redirect:/";
		}
		Resource res=resourceService.getResourceById(id);
		if(res.getParent().getParent()!=null) {//当前点击的菜单必然都有父菜单，只不过需要的是除了根菜单以外的父菜单，需要将父菜单激活，处于展开状态
			userSession.setCurParentMenuId(res.getParent().getId());
		}else {
			userSession.setCurParentMenuId("");
		}
		temp=iterationRes(res, temp);
		for (int i = 1; i <= temp.size(); i++) {
			navList.add(temp.get(temp.size() - i));
		}
		userSession.setNavList(navList);
		String link = res.getLink();
		if (!link.startsWith("/")) {
			link ="/" + link;
		}
		return "redirect:" + link;
	}

	/**
	 * 迭代父菜单，但是包含了根菜单，根菜单无业务意义，因此在前端需要过滤掉根菜单
	 * @param parent
	 * @param list
	 * @return
	 */
	public List<String> iterationRes(Resource parent,List<String> list){
		list.add(parent.getName());
		if(parent.getParent()!=null&&StringUtils.hasText(parent.getParent().getId())) {
			iterationRes(parent.getParent(), list);
		}
		return list;
	}
}
