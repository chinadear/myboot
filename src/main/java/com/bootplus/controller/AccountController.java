package com.bootplus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootplus.core.base.BaseController;
import com.bootplus.model.UserLogin;
import com.bootplus.service.ILoginService;

@Controller
public class AccountController extends BaseController {
	private final static String RESOURCE_MENU_PREFIX="/member/account";
	@Autowired
	private ILoginService loginService;
	@RequestMapping("/account/list")
	public String loginPage(Model model, HttpServletRequest request) {
		List<UserLogin> ullist=loginService.queryUserLoginList();
		model.addAttribute("accountList", ullist);
		return RESOURCE_MENU_PREFIX+"/accountList";
	}
}
