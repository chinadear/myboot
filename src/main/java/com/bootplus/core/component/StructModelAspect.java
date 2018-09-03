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
import com.bootplus.dto.StructModel;
import com.bootplus.service.IBlogService;
import com.bootplus.service.ICategoryService;
import com.bootplus.service.IDrumbeatingService;
import com.bootplus.service.ITagService;

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
public class StructModelAspect { 
	@Autowired
	private IDrumbeatingService drumbeatingService;
    @Pointcut("execution(public * com.bootplus.controller.WebSiteController.*(..))")  
    public void structModel(){}  
  
    @Before("structModel()")  
    public void deBefore(JoinPoint joinPoint) throws Throwable {  
        // 接收到请求，记录请求内容  
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
        HttpServletRequest request = attributes.getRequest();
        HttpSession session=request.getSession();
        StructModel sm=(StructModel)session.getAttribute("structModel");
        if(sm==null) {
        	sm=drumbeatingService.getStructModel();
        	session.setAttribute("structModel", sm);
        }
    }  
}  
