package com.bootplus.core.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
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
		//首先请求链接需要是系统内的URL，非系统内的无法解析按照error处理，是系统url但是无权限按照跳转无权限页面处理
		//排除特殊请求，"/","","/xxx";正确的请求/模块标识/方法/...
		if(!StringUtils.hasText(requestUri)||"/".equals(requestUri)||requestUri.indexOf("/",1)<=0) {
			return false;
		}
		HttpSession session = request.getSession();
		UserSession userSession=(UserSession)session.getAttribute(UserSession.SESSION_USER_KEY);
		if (userSession == null) {
			return true;
		} else {
			if(userSession.isAdmin()) {
				return true;
			}
			Map<String,Boolean> m=userSession.getOwnMenuMap();
			/*int start=requestUri.indexOf("/",1);//去掉项目名/myboot/system/config/edit;只要system
			int end=requestUri.indexOf("/",start+1);
			String menucode=requestUri.substring(start+1,end);*/
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
