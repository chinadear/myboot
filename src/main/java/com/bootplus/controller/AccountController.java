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
import com.bootplus.model.Role;
import com.bootplus.model.SysConfig;
import com.bootplus.model.UFile;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.bootplus.model.UserRole;
import com.bootplus.service.IAuthService;
import com.bootplus.service.ILoginService;
import com.bootplus.service.IRoleService;
import com.bootplus.service.ISysManageService;
/**
 * 账号管理
 * 系统用户
 * @author liulu
 *
 */
@Controller
public class AccountController extends BaseController {
	private final static String RESOURCE_MENU_PREFIX="/member/account";
	@Autowired
	private ILoginService loginService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ISysManageService sysManageService;
	@Autowired 
	private IAuthService authService;
	@Autowired
	private IRoleService roleService;
	/**
	 * 账号管理
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/account/list")
	public String loginPage(Model model, HttpServletRequest request) {
		Page page=loginService.queryUserLoginPage(1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/accountList";
	}
	/**
	 * 翻页刷新列表数据
	 * @param model
	 * @param request
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/account/noSitemesh/loadaccounttable")
	public String loadaccounttable(Model model, HttpServletRequest request,String pageNo) {
		Page page=loginService.queryUserLoginPage(StringUtils.hasText(pageNo)?Integer.valueOf(pageNo):1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/accountTable";
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
		List<SysConfig> keys=sysManageService.querySysConfigListByKey(Constants.SYSTEM_DIC_SYSTEMCONFIG_DEFAULT_PASSWORD_KEY);
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
	@RequestMapping("/account/noSitemesh/editAccount")
	public String editAccount(Model model,String id){
		UserLogin ul=loginService.findUserLoginById(id);
		UserRole ur=new UserRole();
		ur.setUser(ul.getUserId());
		List<UserRole> urlist=authService.queryUserRoleList(ur);
		if(urlist.size()>0) {
			ul.getUserId().setRoleId(urlist.get(0).getRole().getId());
		}
		List<Role> rl=roleService.queryRoleList(new Role());
		model.addAttribute("roles", rl);
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
		List<Role> rl=roleService.queryRoleList(new Role());
		model.addAttribute("roles", rl);
		return RESOURCE_MENU_PREFIX+"/accountAdd";
	}
	/**
	 * 提交新增
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/account/add")
	public String add(Model model,HttpServletRequest request,User user,UserLogin userLogin) {
		user.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		user.setUserType(Constants.SYSTEM_DIC_USERTYPE_USER);
		loginService.save(user);
		String pwd=userLogin.getPassword();
		userLogin.setUserId(user);
		userLogin.setPassword(passwordEncoder.encode(pwd));
		userLogin.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		loginService.save(userLogin);
		if(!"0".equals(user.getRoleId())) {//不等于0证明设置了角色
			Role role=new Role();
			role.setId(user.getRoleId());
			UserRole ur=new UserRole();
			ur.setUser(user);
			ur.setRole(role);
			authService.saveUserRole(ur);
		}
		return "redirect:/account/list";
	}
	/**
	 * 判断账号是否存在
	 * @param username
	 * @return
	 */
	@RequestMapping(value="/account/isExsit/account",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String judgyAccount(String username) {
		String flag="true";
		UserLogin ul=loginService.findUserLoginByName(username);
		if(ul!=null) {
			flag="false";
		}
		return flag;
	}
	/**
	 * 提交修改
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/account/edit")
	public String edit(Model model,User user,String flag){
		User u=loginService.findUserById(user.getId());
		u.setName(user.getName());
		u.setRealName(user.getRealName());
		u.setPhone(user.getPhone());
		u.setQq(user.getQq());
		u.setEmail(user.getEmail());
		loginService.update(u);
		if(StringUtils.hasText(user.getRoleId())) {//防止个人中心 修改过来的请求可能为空
			authService.deleteUserRolesByUserId(user.getId());
			if(!"0".equals(user.getRoleId())) {
				Role role = new Role();
				role.setId(user.getRoleId());
				UserRole ur = new UserRole();
				ur.setUser(u);
				ur.setRole(role);
				authService.saveUserRole(ur);
			}
		}
		if(StringUtils.hasText(flag)) {//不为空，表示是从个人中心修改个人信息处跳转过来的
			return "redirect:/security/account/persional/center";
		}else {
			return "redirect:/account/list";
		}
	}
	/**
	 * 个人中心
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/security/account/persional/center")
	public String persionalCenter(HttpServletRequest request,Model model) {
		UserSession us=(UserSession)request.getSession().getAttribute(Constants.SESSION_USER_KEY);
		List<String> navList=new ArrayList<String>();
		navList.add("个人中心");
		navList.add("个人中心");
		us.setNavList(navList);
		UserLogin userLogin=loginService.findUserLoginByName(us.getLoginName());
		UserRole ur=new UserRole();
		ur.setUser(userLogin.getUserId());
		List<UserRole> urlist=authService.queryUserRoleList(ur);
		if(urlist.size()>0) {
			userLogin.getUserId().setRoleId(urlist.get(0).getRole().getId());
			model.addAttribute("roleName", urlist.get(0).getRole().getName());
		}
		List<Role> rl=roleService.queryRoleList(new Role());
		model.addAttribute("roles", rl);
		model.addAttribute("userLogin", userLogin);
		return RESOURCE_MENU_PREFIX+"/persionalCenter";
	}
	/**
	 * 更换头像
	 * @param id
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping("/security/account/persional/headerimg/modify")
	public String modifyHeaderImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		UserSession us=(UserSession)request.getSession().getAttribute(Constants.SESSION_USER_KEY);
		User user=loginService.findUserById(us.getUserId());
		if(!file.isEmpty()) {
			UFile uf=sysManageService.uploadFile(file,"1",null,request);//自动降质
			if(StringUtils.hasText(uf.getId())) {
				user.setHeaderImg(uf);
				loginService.update(user);
			}
		}
		return "redirect:/security/account/persional/center";
	}
	/**
	 * 显示头像
	 * @param id 用户id
	 * @return
	 */
	@RequestMapping(value = "/security/account/headerimg/{id}", method = RequestMethod.GET)
	public String IoheaderImage(@PathVariable String id,HttpServletRequest request,HttpServletResponse response){
		ServletOutputStream out = null;
		FileInputStream ips = null;
		String imgpath=null;
		User user=loginService.findUserById(id);
		if(user.getHeaderImg()!=null) {
			UFile ufile=sysManageService.getUploadFileById(user.getHeaderImg().getId());
			List<SysConfig> sclist=sysManageService.querySysConfigListByKey(Constants.SYSTEM_DIC_SYSTEMCONFIG_UPLOADPATH_KEY);
			if(sclist.size()>0&&StringUtils.hasText(sclist.get(0).getValue())) {//存在
				imgpath=CompUtil.formatDir(sclist.get(0).getValue())+ufile.getPath()+ufile.getFileName();
			}
		}
		try {
			if(imgpath==null) {//直接获取系统默认头像
				try {
					ips = new FileInputStream(ResourceUtils.getFile("classpath:static//lib//dist//img//user2-160x160.jpg"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				ips = new FileInputStream(imgpath);
			}
			response.setContentType("image/*"); 
			int i=ips.available();
			byte data[]=new byte[i];
			ips.read(data);
			out=response.getOutputStream();
			//输出数据
			out.write(data);
			out.flush();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				out.close();
				ips.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 删除账户及关联的用户信息
	 * 账户，用户信息逻辑删除
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/account/delete/{id}")
	public String edit(Model model,@PathVariable String id){
		UserLogin ul=loginService.findUserLoginById(id);
		User user=ul.getUserId();
		user.setStatus(Constants.SYSTEM_DIC_DELETE_STATUS);
		ul.setStatus(Constants.SYSTEM_DIC_DELETE_STATUS);
		loginService.update(user);
		loginService.update(ul);
		return "redirect:/account/list";
	}
	/**
	 * 校验昵称是否重复
	 * @param name
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/security/account/isExsit/name",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String judgyName(String name,String id) {
		String flag="true";
		User user=new User();
		user.setName(name);
		List<User> ulist=loginService.queryUserList(user);
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
