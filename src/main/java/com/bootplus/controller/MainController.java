package com.bootplus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootplus.Util.CompUtil;
import com.bootplus.Util.Constants;
import com.bootplus.Util.DateUtil;
import com.bootplus.core.base.BaseController;
import com.bootplus.core.base.UserSession;
import com.bootplus.model.Blog;
import com.bootplus.model.Category;
import com.bootplus.model.Resource;
import com.bootplus.model.Views;
import com.bootplus.service.IBlogService;
import com.bootplus.service.ICategoryService;
import com.bootplus.service.IResourceService;
import com.bootplus.service.ISysManageService;
/**
 * 主页面
 * @author liulu
 *
 */
@Controller
public class MainController extends BaseController {
	@Autowired 
	private IResourceService resourceService;
	@Autowired
	private ISysManageService sysManageService;
	@Autowired
	private IBlogService blogService;
	@Autowired
	private ICategoryService categoryService;
	private final static String TEMP_DATETIME="2018-09-08";
	/**
	 *  主页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/main")
	public String indexHome(Model model, HttpServletRequest request) {
		List<Resource> rlist=resourceService.queryResourceList(new Resource());
		List<Blog> blist=blogService.getBlogList(new Blog());
		List<Category> clist=categoryService.queryCategoryList(new Category());
		List<Category> c2list=new ArrayList<Category>();
		for(Category c:clist) {
			Blog b=new Blog();
			b.setCateId(c.getId());
			List<Blog> bl=blogService.getBlogList(b);
			c.setArticals(String.valueOf(bl.size()));
			c2list.add(c);
		}
		Views vc=sysManageService.getViewCount(TEMP_DATETIME);
		model.addAttribute("viewCount",vc!=null?vc.getViewnum():"0");
		model.addAttribute("blogCount",blist.size());
		model.addAttribute("catelist",c2list);//分类数量
		if(rlist.size()==0) {
			return "redirect:/resource/list";
		}else {
			return "/member/mainpage";
		}
		
	}
	/**
	 * 初始化系统数据
	 * @return
	 */
	@RequestMapping(value="/security/initsystem")
	public String initSystem() {
		Views vc=sysManageService.getViewCount(TEMP_DATETIME);
		if(vc==null) {
			vc=new Views();
			//当做日统计的时候需要在定时任务中定期执行创建任务
			vc.setDatetag(TEMP_DATETIME);//DateUtil.getDate(new Date())
			sysManageService.saveViewCount(vc);
		}
		//Constants.ai.set(vc.getViewnum());
		return "redirect:/main";
	}
	/**
	 * 菜单跳转
	 * @param request
	 * @param response
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping(value="/security/dispatcher/{id}/{status}")
	public String menuDispatch(HttpServletRequest request, HttpServletResponse response,@PathVariable String id,@PathVariable String status){
		UserSession userSession=(UserSession)request.getSession().getAttribute(UserSession.SESSION_USER_KEY);
		userSession.setCurMenuId(id);
		userSession.setSidebarStatus(status);//1展开，0收缩
		List<String> navList=new ArrayList<String>();
		List<String> temp=new ArrayList<String>();
		if("0".equals(id)) {//首页
			navList.add("不显示的根节点");
			navList.add("首页");
			userSession.setNavList(navList);
//			CompUtil.forward2Target(request, response, "/");
			return "redirect:/main";
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
//		CompUtil.forward2Target(request, response, link);
		return "redirect:" + link;
	}
	@RequestMapping(value="/security/initStatistics",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String initStatistics(){
		List<PieData> list=new ArrayList<PieData>();
		List<String> list2=new ArrayList<String>();
		List<Integer> list3=new ArrayList<Integer>();
		for(int i=1;i<7;i++) {
			PieData m1=new PieData();
			m1.setValue(i);
			m1.setName("name_"+i);
			list.add(m1);
		}
		for(int i=1;i<7;i++) {
			list2.add("name_"+i);
		}
		for(int i=1;i<7;i++) {
			list3.add(i);
		}
		StringBuffer sb=new StringBuffer();
		Map<String,String> map=new HashMap<String,String>();
		map.put("name", CompUtil.array2Json(list));
		map.put("name2", CompUtil.array2Json(list2));
		map.put("name3", CompUtil.array2Json(list3));
		return CompUtil.map2Json(map);
	}
	
	@RequestMapping(value="/security/noSitemesh/noauthority/error")
	public String error(HttpServletRequest request, HttpServletResponse response){
		return "/error/error";
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
class PieData{
	private int value;
	private String name;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}