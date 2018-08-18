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
import com.bootplus.model.SysConfig;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.bootplus.service.ILoginService;
import com.bootplus.service.ISysManageService;
/**
 * 成员管理
 * @author liulu
 *
 */
@Controller
public class MemberController extends BaseController {
	private final static String RESOURCE_MENU_PREFIX="/member/member";
	@Autowired
	private ILoginService loginService;
	@Autowired
	private ISysManageService sysManageService;
	/**
	 * 成员管理
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/member/list")
	public String loginPage(Model model, HttpServletRequest request) {
		User user=new User();
		user.setUserType(Constants.SYSTEM_DIC_USERTYPE_MEMBER);
		Page page=loginService.queryUserPage(user,1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/memberList";
	}
	/**
	 * 翻页刷新列表
	 * @param model
	 * @param request
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/member/noSitemesh/loadmembertable")
	public String loadmembertable(Model model, HttpServletRequest request,String pageNo) {
		User user=new User();
		user.setUserType(Constants.SYSTEM_DIC_USERTYPE_MEMBER);
		Page page=loginService.queryUserPage(user,StringUtils.hasText(pageNo)?Integer.valueOf(pageNo):1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/memberTable";
	}
}
