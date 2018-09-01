package com.bootplus.core.component;

import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.ProceedingJoinPoint;  
import org.aspectj.lang.annotation.*;  
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;  
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bootplus.core.base.UserSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;  
  
/** 
 * AOP进入方法前与退出方法后执行
 * @author liulu
 * 日志切面 
 */  
/*@Aspect  
@Component  */
public class LogAspect {  
    @Pointcut("execution(public * com.bootplus.controller.WebSiteController.view(..))")  
    public void webLog(){}  
  
    @Before("webLog()")  
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
        	System.out.println("=============第一次阅读：key="+id);
        }else {
        	System.out.println("=============第二次阅读：key="+id);
        }
        session.setAttribute("user_space", m);
        // 记录下请求内容  
        System.out.println("URL : " + request.getRequestURL().toString());  
        System.out.println("HTTP_METHOD : " + request.getMethod());  
        System.out.println("IP : " + request.getRemoteAddr());  
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());  
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));  
  
    }  
  
    @AfterReturning(returning = "ret", pointcut = "webLog()")  
    public void doAfterReturning(Object ret) throws Throwable {  
        // 处理完请求，返回内容  
        System.out.println("方法的返回值 : " + ret);  
    }  
  
    //后置异常通知  
    @AfterThrowing("webLog()")  
    public void throwss(JoinPoint jp){  
        System.out.println("方法异常时执行.....");  
    }  
  
    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行  
    @After("webLog()")  
    public void after(JoinPoint jp){  
        System.out.println("方法最后执行.....");  
    }  
  
    //环绕通知,环绕增强，相当于MethodInterceptor  
    @Around("webLog()")  
    public Object arround(ProceedingJoinPoint pjp) {  
        System.out.println("方法环绕start.....");  
        try {  
            Object o =  pjp.proceed();  
            System.out.println("方法环绕proceed，结果是 :" + o);  
            return o;  
        } catch (Throwable e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}  
