package com.bootplus.core.component;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.bootplus.controller.LoginController;
import com.bootplus.core.base.UserSession;
import com.bootplus.dao.IResourceDao;
import com.bootplus.dao.IUserDao;
import com.bootplus.model.UserLogin;
import com.bootplus.service.ILoginService;
import com.bootplus.service.IResourceService;

/**
 * security,登录验证成功返回处理类
 * @author angle
 *
 */
@Component("authenticationSuccess")
public class AuthenticationSuccess implements AuthenticationSuccessHandler {
	private final Logger logger=LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private ILoginService loginService;
	@Autowired //加载service
	private IResourceService resourceService;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
/*		WebAuthenticationDetails u=(WebAuthenticationDetails)authentication.getDetails();
		UserDetails user=(UserDetails)authentication.getPrincipal();
		Collection<SimpleGrantedAuthority> c=(Collection<SimpleGrantedAuthority>)authentication.getAuthorities();
		for(SimpleGrantedAuthority g:c) {
			System.out.println(g.getAuthority());
		}*/
//		logger.info("登录成功"+authentication.getName()+":"+u.getRemoteAddress()+":"+u.getSessionId()+":"+user.getPassword());
        //如果是要跳转到某个页面的，重定向
		//下面方法也可以获取登录用户的信息
		/*UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();*/
		UserLogin ul=loginService.findUserByName(authentication.getName());
		UserSession userSession=new UserSession();
		userSession.setLoginName(ul.getUsername());
		userSession.setName(ul.getUserId().getName());
		userSession.setUserId(ul.getUserId().getId());
		userSession.setResource(resourceService.getSidebarMenu());
		request.getSession().setAttribute(userSession.SESSION_USER_KEY, userSession);
		System.out.println("=============="+userSession.getName());
        new DefaultRedirectStrategy().sendRedirect(request, response, "/");
	}

}
