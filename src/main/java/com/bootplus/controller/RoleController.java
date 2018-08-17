package com.bootplus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootplus.Util.Constants;
import com.bootplus.core.base.BaseController;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Resource;
import com.bootplus.model.Role;
import com.bootplus.model.SysConfig;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.bootplus.service.ILoginService;
import com.bootplus.service.IRoleService;
import com.bootplus.service.ISysManageService;
/**
 * 角色管理
 * 包含角色授权，授权采用一个字段存储格式为：菜单code1,菜单code2,菜单code3,菜单code4
 * 判断是否有此权限，只需要查看权限字段中的字符串是否包含此菜单code
 * 菜单code要与mapping中的请求首位标识一直，如：菜单resource,用户account,成员member,角色role等等
 * 暂定一个用户只能分配一个角色
 * @author liulu
 *
 */
@Controller
public class RoleController extends BaseController {
	private final static String RESOURCE_MENU_PREFIX="/member/role";
	@Autowired
	private IRoleService roleService;
	/**
	 * 角色管理
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/role/list")
	public String loginPage(Model model, HttpServletRequest request) {
		Page page=roleService.queryRolePage(new Role(),1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("roleList", page);
		return RESOURCE_MENU_PREFIX+"/roleList";
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
	@RequestMapping("/noSitemesh/role/loadroletable")
	public String loadroletable(Model model, HttpServletRequest request,String pageNo) {
		Page page=roleService.queryRolePage(new Role(),StringUtils.hasText(pageNo)?Integer.valueOf(pageNo):1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("roleList", page);
		return RESOURCE_MENU_PREFIX+"/roleTable";
	}
	/**
	 * 初始化编辑框
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/noSitemesh/role/editRole")
	public String editRole(Model model,String id){
		Role role=roleService.findRoleById(id);
		model.addAttribute("role", role);
		return RESOURCE_MENU_PREFIX+"/editRole";
	}
	/**
	 * 提交新增
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/role/add")
	public String add(Model model, String name_,String type_,String code_,String comments_) {
		Role role=new Role();
		role.setCode(code_);
		role.setComments(comments_);
		role.setName(name_);
		role.setType(type_);
		role.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		roleService.save(role);
		return "redirect:/role/list";
	}
	/**
	 * 提交修改
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/role/edit")
	public String edit(Model model,Role role){
		Role r=roleService.findRoleById(role.getId());
		r.setCode(role.getCode());
		r.setName(role.getName());
		r.setType(role.getType());
		r.setComments(role.getComments());
		roleService.update(r);
		return "redirect:/role/list";
	}
	/**
	 * 删除角色，逻辑删除
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/role/delete/{id}")
	public String edit(Model model,@PathVariable String id){
		Role role=roleService.findRoleById(id);
		role.setStatus(Constants.SYSTEM_DIC_DELETE_STATUS);
		roleService.update(role);
		return "redirect:/role/list";
	}
	/**
	 * 判断角色code是否重复
	 * @param username
	 * @return
	 */
	@RequestMapping(value="/role/isExsit/code",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String judgyAccount(String code,String id) {
		String flag="true";
		Role role=new Role();
		role.setCode(code);
		List<Role> rlist=roleService.queryRoleList(role);
		if(rlist.size()>0) {//=0直接返回true
			if(StringUtils.hasText(id)) {//编辑情况下要判断是否是自身的情况
				if(rlist.size()==1&&rlist.get(0).getId().equals(id)) {//有一个且是他自己
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
	/**
	 * 校验角色名称是否重复
	 * @param name
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/role/isExsit/name",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String judgyName(String name,String id) {
		String flag="true";
		Role role=new Role();
		role.setName(name);
		List<Role> rlist=roleService.queryRoleList(role);
		if(rlist.size()>0) {//=0直接返回true
			if(StringUtils.hasText(id)) {//编辑情况下要判断是否是自身的情况
				if(rlist.size()==1&&rlist.get(0).getId().equals(id)) {//有一个且是他自己
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
