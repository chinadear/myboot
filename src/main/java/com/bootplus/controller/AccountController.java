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
import com.bootplus.model.Resource;
import com.bootplus.model.SysConfig;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.bootplus.service.ILoginService;
import com.bootplus.service.ISysManageService;

@Controller
public class AccountController extends BaseController {
	private final static String RESOURCE_MENU_PREFIX="/member/account";
	@Autowired
	private ILoginService loginService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ISysManageService sysManageService;
	
	@RequestMapping("/account/list")
	public String loginPage(Model model, HttpServletRequest request) {
		List<UserLogin> ullist=loginService.queryUserLoginList();
		model.addAttribute("accountList", ullist);
		return RESOURCE_MENU_PREFIX+"/accountList";
	}
	/**
	 * 重置密码
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/account/resetPassword",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String resetPassword(Model model, HttpServletRequest request,String id) {
		List<SysConfig> keys=sysManageService.querySysConfigListByKey(Constants.SYSTEM_DIC_DEFAULT_PASSWORD_KEY);
		String defaultpassword="12345678";
		if(keys.size()>0 && StringUtils.hasText(keys.get(0).getValue())) {
			defaultpassword=keys.get(0).getValue();
		}
		UserLogin ul=loginService.findUserLoginById(id);
		ul.setPassword(passwordEncoder.encode(defaultpassword));
		loginService.update(ul);
		return "t";
	}
	/**
	 * 初始化编辑框
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/noSitemesh/account/editAccount")
	public String editAccount(Model model,String id){
		UserLogin ul=loginService.findUserLoginById(id);
		model.addAttribute("userLogin", ul);
		return RESOURCE_MENU_PREFIX+"/accountEdit";
	}
	/**
	 * 初始化新增页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/account/addAccount")
	public String addAccount(Model model, HttpServletRequest request) {
		return RESOURCE_MENU_PREFIX+"/accountAdd";
	}
	/**
	 * 提交修改
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/account/edit")
	public String edit(Model model,User user){
		User u=loginService.findUserById(user.getId());
		u.setName(user.getName());
		u.setRealName(user.getRealName());
		u.setPhone(user.getPhone());
		u.setQq(user.getQq());
		u.setEmail(user.getEmail());
		loginService.update(u);
		return "redirect:/account/list";
	}
	/**
	 * 删除账户及关联的用户信息
	 * 账户物理删除，用户信息逻辑删除
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/account/delete/{id}")
	public String edit(Model model,@PathVariable String id){
		UserLogin ul=loginService.findUserLoginById(id);
		User user=ul.getUserId();
		user.setStatus(Constants.SYSTEM_DIC_DELETE_STATUS);
		loginService.update(user);
		loginService.delete(ul);
		return "redirect:/account/list";
	}
	
	/**
	 * 校验用户名是否重复
	 * @param name
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/account/isExsit/name",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String judgyName(String name,String id) {
		String flag="true";
		User user=new User();
		user.setName(name);
		List<User> ulist=loginService.queryUser(user);
		if(ulist.size()>0) {//=0直接返回true
			if(StringUtils.hasText(id)) {//编辑情况下要判断是否是自身的情况
				if(ulist.size()==1&&ulist.get(0).getId().equals(id)) {//有一个且是他自己
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
