package com.bootplus.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootplus.Util.CompUtil;
import com.bootplus.Util.Constants;
import com.bootplus.Util.TreeBean;
import com.bootplus.core.base.BaseController;
import com.bootplus.model.Resource;
import com.bootplus.service.IResourceService;

@Controller
public class ResourceController extends BaseController {
	@Autowired 
	private IResourceService resourceService;
	//页面目录根地址
	private static final String RESOURCE_MENU_PREFIX="/member/resource";
	/**
	 * 菜单管理页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/resource/list")
	public String resourceList(Model model, HttpServletRequest request) {
//		List<Resource> list=resourceService.queryResourceList(new Resource());
//		model.addAttribute("menuList", list);
		return RESOURCE_MENU_PREFIX+"/resourceManage";
	}
	/**
	 * 初始化树
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/resource/initMenuTree",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String initMenuTree(){
		List<Resource> reslist=resourceService.queryResourceList(new Resource());
		if(reslist.size()==0) {
			Resource resource=new Resource();
			resource.setParent(null);
			resource.setName(Constants.ROOT_MENU_NAME);
			resource.setCode(Constants.ROOT_MENU_BOOT_CODE);
			resource.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
			resource.setCreateTime(new Date());
			resource.setUpdateTime(new Date());
			resourceService.save(resource);
			reslist.add(resource);
		}
		List<TreeBean> lstTree = new ArrayList<TreeBean>();
		for(Resource res:reslist){
			TreeBean treebean=new TreeBean();
			treebean.setId(res.getId());
			if(res.getParent()==null){
				treebean.setName(Constants.ROOT_MENU_NAME);
				treebean.setpId("0");
				//treebean.setOpen("true");
			}else{
				treebean.setName(res.getName());
				treebean.setpId(res.getParent().getId());
			}
			lstTree.add(treebean);
		}
		return CompUtil.treeSetValues(lstTree);
	}
	/**
	 * 获取子菜单列表
	 * @param model
	 * @param pId
	 * @return
	 */
	@RequestMapping("/noSitemesh/resource/childlist")
	public String getChildMenuNodes(Model model, String pId, String level){
		Resource res=new Resource();
		res.setId(pId);
		List<Resource> listree= resourceService.getResourcesByParent(res);
		model.addAttribute("menuList", listree);
		model.addAttribute("level", level);
		return RESOURCE_MENU_PREFIX+"/menuchild";
	}
	/**
	 * 初始化编辑页面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/noSitemesh/resource/initEditMenu")
	public String initEditMenu(Model model,String id,String fatherMenu){
		Resource res = resourceService.getResourceById(id);
		model.addAttribute("res", res);
		if(!"".equals(fatherMenu)&&fatherMenu!=null){
			model.addAttribute("fatherMenu", fatherMenu);
		}else{
			model.addAttribute("fatherMenu", "");
		}
		return RESOURCE_MENU_PREFIX+"/editMenu";
	}
	/**
	 * 增加菜单
	 * @param model
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/resource/addMenu",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String addMenu(Model model,HttpServletRequest request,String fileId){
		String pId=request.getParameter("pId");
		String menuname=request.getParameter("menuname");
		String menucode=request.getParameter("menucode");
		String menulink=request.getParameter("menulink");
		String comments=request.getParameter("comments");
		String classCode=request.getParameter("classCode");
		Resource resource = new Resource();
		Resource parent = resourceService.getResourceById(pId);//获取父节点对象
		List<Resource> childs = resourceService.getResourcesByParent(parent);
		if(childs.size()==0){
			resource.setSeqNum(1);
		}else{
			resource.setSeqNum(childs.get(childs.size()-1).getSeqNum()+1);
		}
		resource.setParent(parent);
		resource.setName(menuname);
		resource.setCode(menucode);
		resource.setLink(formatLink(menulink));
		resource.setComments(comments);
		resource.setClassCode(classCode);
		resource.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		resource.setCreateTime(new Date());
		resource.setUpdateTime(new Date());
		resourceService.save(resource);
		return resource.getId();
	}
	/**
	 * 编辑菜单
	 * @param model
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/resource/editMenu",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String editMenu(Model model,HttpServletRequest request){
		String id=request.getParameter("id");
		String menuname=request.getParameter("menuname");
		String menulink=request.getParameter("menulink");
		String comments=request.getParameter("comments");
		String classCode=request.getParameter("classCode");
		String menucode=request.getParameter("menucode");
		Resource resource = resourceService.getResourceById(id);
		resource.setName(menuname);
		resource.setLink(formatLink(menulink));
		resource.setComments(comments);
		resource.setClassCode(classCode);
		resource.setCode(menucode);
		resourceService.update(resource);;
		return "";
	}
	/**
	 * 删除菜单（包括子菜单）
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/resource/deleteMenu",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String deleteMenu(String id){
		Resource resource = new Resource();
		resource.setId(id);
		resourceService.deleteResourcesByParent(resource);
		return "T";
	}
	/**
	 * 上移下移
	 * @param targetId
	 * @param sourceId
	 * @return
	 */
	@RequestMapping(value="/resource/upDownMenu",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String upDownMenu(String targetId,String sourceId){
		Resource targetRes = resourceService.getResourceById(targetId);
		Resource sourceRes = resourceService.getResourceById(sourceId);
		resourceService.swapSeqNum(sourceRes, targetRes);
		return "T";
	}
	/**
	 * 菜单同级名称重复校验
	 * @param name
	 * @param parent
	 * @param id
	 * @return
	 */
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
	/**
	 * 菜单code是否重复
	 * @param code
	 * @param id
	 * @return
	 */
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
	}
	/**
	 * 格式化菜单连接，去掉首字符“/”
	 * @param link
	 * @return
	 */
	public String formatLink(String link){
		if(!"".equals(link)){
			String firstChar = link.substring(0,1);
			if("/".equals(firstChar)||"\\".equals(firstChar)){
				link=link.substring(1);
			}
		}
		return link;
	}
	
}
