package com.bootplus.core.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bootplus.core.base.UserSession;
@Component
public class VisitorInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
//		return HandlerInterceptor.super.preHandle(request, response, handler);
		String requestUri = request.getRequestURI();
		if("/error".equals(requestUri)) {
			return false;
		}
		HttpSession session = request.getSession();
		UserSession userSession=(UserSession)session.getAttribute(UserSession.SESSION_USER_KEY);
		if (userSession == null) {
			return true;
		} else {
			Map<String,Boolean> m=userSession.getOwnMenuMap();
			String menucode=requestUri.substring(1,requestUri.substring(1, requestUri.length()).indexOf("/")+1);
			if(m.get(menucode.toUpperCase())!=null && m.get(menucode.toUpperCase())) {
				return true;
			}else {
				response.sendRedirect(request.getContextPath()+"/security/noSitemesh/noauthority/error");
				return false;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
