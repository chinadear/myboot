package com.bootplus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootplus.Util.CompUtil;
import com.bootplus.Util.Constants;
import com.bootplus.Util.TreeBean;
import com.bootplus.core.base.BaseController;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.ResRole;
import com.bootplus.model.Resource;
import com.bootplus.model.Role;
import com.bootplus.model.SysConfig;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.bootplus.model.UserRole;
import com.bootplus.service.IAuthService;
import com.bootplus.service.ILoginService;
import com.bootplus.service.IResourceService;
import com.bootplus.service.IRoleService;
import com.bootplus.service.ISysManageService;
/**
 * 权限管理
 * 判断是否有此权限，只需要查看权限字段中的字符串是否包含此菜单code
 * 菜单code要与mapping中的请求首位标识一直，如：菜单resource,用户account,成员member,角色role等等
 * 暂定一个用户只能分配一个角色
 * @author liulu
 *
 */
@Controller
public class AuthorizationController extends BaseController {
	private final static String RESOURCE_MENU_PREFIX="/member/authorization";
	@Autowired
	private IRoleService roleService;
	@Autowired 
	private IResourceService resourceService;
	@Autowired 
	private IAuthService authService;
	/**
	 * 角色管理
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/authorization/authmanage")
	public String authmanage(Model model, HttpServletRequest request) {
		Page page=roleService.queryRolePage(new Role(),1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("roleList", page);
		return RESOURCE_MENU_PREFIX+"/authManage";
	}
	/**
	 * 加载角色列表
	 * totalCount:200,//总记录数
	    showPage:5,//分页栏显示页数，其他页数...代替
	    limit:8,//每页显示记录数
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/authorization/noSitemesh/loadroletable")
	public String loadroletable(Model model, HttpServletRequest request,String pageNo) {
		Page page=roleService.queryRolePage(new Role(),StringUtils.hasText(pageNo)?Integer.valueOf(pageNo):1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("roleList", page);
		return RESOURCE_MENU_PREFIX+"/roleTable";
	}
	// 初始化树
	@RequestMapping(value = "/authorization/resource/initRoleMenuTreeAjax", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String initRoleMenuTree(String roleId){
		List<Resource> reslist = resourceService.queryResourceList(new Resource());
		Role role = new Role();
		role.setId(roleId);
		ResRole rr = new ResRole();
		rr.setRole(role);
		List<ResRole> roleMenuList = authService.queryResRoleList(rr);
		Map roleMenuMap = new HashMap();
		if (roleMenuList != null) {
			for (ResRole r : roleMenuList) {
				roleMenuMap.put(r.getResource().getId(), r);
			}
		}
		List<TreeBean> lstTree = new ArrayList<TreeBean>();
		for (Resource res : reslist) {
			TreeBean treebean = new TreeBean();
			treebean.setId(res.getId());
			if (roleMenuMap.get(res.getId()) != null) {
				treebean.setChecked("true");
				treebean.setOpen("true");
			}
			if (res.getParent() == null) {
				treebean.setName(Constants.ROOT_MENU_NAME);
				treebean.setpId("0");
				treebean.setOpen("true");
			} else {
				treebean.setName(res.getName());
				treebean.setpId(res.getParent().getId());
			}
			lstTree.add(treebean);

		}
		// 利用Json插件将Array转换成Json格式
		return CompUtil.treeSetValues(lstTree);
	}
	/**
	 * 设置菜单权限
	 * @param roleId
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/authorization/resource/setResAuth", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String setResAuth(String roleId,String ids) {
		Role role = new Role();
		role.setId(roleId);
		List<ResRole> rrList = new ArrayList<ResRole>();
		if (ids != null && ids.length() > 0) {
			String[] idss = ids.split(",");
			for (String menuId : idss) {
				if (menuId != null && menuId.length() > 0) {
					Resource resource = new Resource();
					resource.setId(menuId);
					ResRole rr=new ResRole();
					rr.setResource(resource);
					rr.setRole(role);
					rrList.add(rr);
				}
			}
		}
		authService.deleteResRolesByRoleId(roleId);
		authService.saveResRoles(rrList);
		return "TRUE";
	}
}
