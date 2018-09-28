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
@Aspect  
@Component  
public class LogAspect {  
	//创建一个切点，切面可以用通配符表示，
	//例如public *（*代表任意返回值类型） com.spring.controller.WebSiteController.*(..)//（..）表示任意参数:
	//也可以指定方法如：public * com.spring.controller.WebSiteController.view(..)
	//还可以任意类：public * com.spring.controller.*.*(..)都可以
    @Pointcut("execution(public * com.spring.controller.WebSiteController.view(..))")  
    public void webLog(){}  
    //执行方法前，根据切点规则拦截
    @Before("webLog()")  
    public void deBefore(JoinPoint joinPoint) throws Throwable {  
        // 接收到请求，记录请求内容  
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容  
        System.out.println("URL : " + request.getRequestURL().toString());  
        System.out.println("HTTP_METHOD : " + request.getMethod());  
        System.out.println("IP : " + request.getRemoteAddr());  
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());  
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));  
  
    }  
    //方法运行后执行
    @AfterReturning(returning = "r", pointcut = "webLog()")  
    public void doAfterReturning(Object r) throws Throwable {  
        // 处理完请求，返回内容  
        System.out.println("方法的返回值 : " + r);  
    }  
  
    //后置异常通知  
    @AfterThrowing("webLog()")  
    public void throwss(JoinPoint jp){  
        System.out.println("方法异常时执行.....");  
    }  
  
    //退出方法时执行  
    @After("webLog()")  
    public void after(JoinPoint jp){  
        System.out.println("方法最后执行.....");  
    }  
  
    //环绕通知,环绕增强，可以控制类中的方法是否可以执行，
	//也可以修改参数，修改返回内容 ，植入方法处理逻辑
    @Around("webLog()")  
    public Object arround(ProceedingJoinPoint pjp) {  
        System.out.println("方法环绕start.....");  
        try {  
        	//执行方法，环绕通知方法
            Object obj =  pjp.proceed(); 
            //由于环绕方法功能强大，干预能力强，因此慎用
            System.out.println("方法环绕proceed，结果是 :" + obj);  
            return obj;  
        } catch (Throwable e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}  
