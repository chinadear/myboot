package com.bootplus.core.component;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * security,登录验证失败返回处理类
 * @author angle
 *
 */
@Component("authenticationFailure")
public class AuthenticationFailure implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String e=exception.getMessage();
		String meg="密码错误";
		if("no user".equals(e)) {
			meg="查无此用户！";
		}
		request.getRequestDispatcher("/auth/login?meg="+meg).forward(request, response);
//		new DefaultRedirectStrategy().sendRedirect(request, response, "/auth/login");
	}

}
