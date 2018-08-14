package com.demon.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.demon.model.Hb0101;
import com.demon.service.IHb0101Service;

@Controller
public class ViewController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private IHb0101Service hb0101Service;
	private final Logger logger=LoggerFactory.getLogger(ViewController.class);

	@RequestMapping("/test")
	public String indexHome(Model model, HttpServletRequest request) {
		return "/member/resource/resourceManage";
	}
	
	@RequestMapping("/test/add")
	public String save(Model model, HttpServletRequest request) {

		String d = round();
		Hb0101 hb0101 = new Hb0101();
		hb0101.setHb0101001("user" + d);
		hb0101.setHb0101002("大神" + "_" + d);
		hb0101.setHb0101003("13900" + "_" + d);
		hb0101.setHb0101004("Email" + "_" + d + "@hotmail.com");
		

		hb0101Service.save(hb0101);
		model.addAttribute("message", "新增用户成功,【"+hb0101.getHb0101002()+"】用户已创建");
		return "/member/index";

	}
	@RequestMapping("/test/registerAdmin")
	public String registerAdmin(Model model, HttpServletRequest request) {
		UserLogin user=hb0101Service.findUserByName("admin");
		if(user==null) {
			UserLogin u=new UserLogin();
			u.setUsername("admin");
			u.setPassword(passwordEncoder.encode("12345678"));
			hb0101Service.save(u);
		}
		return "redirect:/auth/login";
	}
	@RequestMapping("/test/addUser")
	public String saveUser(Model model, HttpServletRequest request) {
		String pwd=request.getParameter("pwd");
		if(!StringUtils.hasText(pwd)) {
			return "/member/hello";
		}
		UserLogin user = new UserLogin();
		user.setUsername("user"+System.currentTimeMillis());
		user.setPassword(passwordEncoder.encode(pwd));

		hb0101Service.save(user);
		return "redirect:/list";

	}
	@RequestMapping("/test/list")
	public String list(Model model, HttpServletRequest request) {
		String id=request.getParameter("id");
		List<Hb0101> list=new ArrayList<Hb0101>();
		if(StringUtils.hasText(id)) {
			Hb0101 hb=hb0101Service.getHbById(Integer.valueOf(id));
			list.add(hb);
		}else {
			list = hb0101Service.findAll();
		}
		model.addAttribute("hb0101s", list);
		return "/member/list";
	}

	@RequestMapping("/test/delete")
	public String delete(Model model, HttpServletRequest request) {
		String id=request.getParameter("id");
		id=id.replaceAll(",","");
		hb0101Service.deleteById(Integer.valueOf(id));
		return "redirect:/list";
	}
	
	public String round() {

		String sources = "0123456789"; 
		Random rand = new Random();
		StringBuffer flag = new StringBuffer();
		for (int j = 0; j < 6; j++) {
			flag.append(sources.charAt(rand.nextInt(9)) + "");
		}
		return flag.toString();

	}

}
