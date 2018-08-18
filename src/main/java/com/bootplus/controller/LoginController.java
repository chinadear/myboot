package com.bootplus.controller;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootplus.Util.DateUtil;
import com.bootplus.core.base.BaseController;
import com.bootplus.model.Resource;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.bootplus.service.ILoginService;
import com.bootplus.service.IResourceService;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
/**
 * 登录
 * @author liulu
 *
 */
@Controller
public class LoginController extends BaseController{
	@Autowired
	private Producer captchaProducer;
	@Autowired
	private ILoginService loginService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private final Logger logger=LoggerFactory.getLogger(LoginController.class);
	/**
	 *  登录页面
	 *  登录验证交给spring security
	 * @param model
	 * @param request
	 * @param meg
	 * @return
	 */
	@RequestMapping("/auth/login")
	public String loginPage(Model model, HttpServletRequest request,String meg) {
		model.addAttribute("meg", meg);
		return "/login/login";
	}
	
	/**
	 * 添加管理员账号
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/registerAdmin")
	public String registerAdmin(Model model, HttpServletRequest request) {
		UserLogin userlogin=loginService.findUserLoginByName("admin");
		if(userlogin==null) {
			User user=new User();
			user.setBirthday(DateUtil.getDate(new Date()));
			user.setName("系统管理员");
			user.setStatus("1");
			user.setUserType("0");
			loginService.save(user);
			UserLogin u=new UserLogin();
			u.setUsername("admin");
			u.setPassword(passwordEncoder.encode("12345678"));
			u.setUserId(user);
			loginService.save(u);
		}
		return "redirect:/auth/login";
	}
	/**
	 * 刷新验证码
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/auth/noSecurity/getKaptchaImage")
    public void getKaptchaImage(Model model, HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = captchaProducer.createText();
        // store the text in the session
        //request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        //将验证码存到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        logger.info(capText);
        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
