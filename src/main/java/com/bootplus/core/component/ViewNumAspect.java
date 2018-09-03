package com.bootplus.core.component;

import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.ProceedingJoinPoint;  
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;  
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bootplus.core.base.UserSession;
import com.bootplus.service.IBlogService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;  
  
/** 
 * 记录文章阅读量的AOP
 * @author liulu
 * 切面 
 */  
@Aspect  
@Component  
public class ViewNumAspect { 
	@Autowired
	private IBlogService blogService;
    @Pointcut("execution(public * com.bootplus.controller.WebSiteController.view(..))")  
    public void articalViewCount(){}  
  
    @Before("articalViewCount()")  
    public void deBefore(JoinPoint joinPoint) throws Throwable {  
        // 接收到请求，记录请求内容  
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
        HttpServletRequest request = attributes.getRequest();
        HttpSession session=request.getSession();
        Map<String,String> m=(Map<String,String>)session.getAttribute("user_space");
        if(m==null) {
        	m=new HashMap<String,String>();
        }
        String id=String.valueOf(joinPoint.getArgs()[2]);
        if(!StringUtils.hasText(m.get(id))) {
        	m.put(id,"1");
        	blogService.updateViewNum(id);
        }
        session.setAttribute("user_space", m);
    }  
}  
