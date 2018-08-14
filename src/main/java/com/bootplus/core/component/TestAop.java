package com.bootplus.core.component;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * AOP进入方法前与退出方法后执行
 * @author liulu
 *
 */
@Aspect
@Component
public class TestAop {
    
    private final static Logger logger = LoggerFactory.getLogger(TestAop.class);
    //设置切面的方法，public 返回值类型 包路径.方法名(..)接受全部参数；*代表全部
    //声明一个切面
    @Pointcut(value = "execution (public * com.bootplus.controller.ViewController.*(..))")
    public void log() {}
    
    @Before(value = "log()")//声明一个before建言，拦截方法执行前，采用pointcut定义的切面
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method =signature.getMethod();
        logger.info("注解式拦截："+method.getName());
    }
    //声明一个after建言，拦截方法执行后，采用直接设置拦截规则方式
    @After(value = "execution (public * com.bootplus.controller.ViewController.indexHome(..))")
    public void doAfter(JoinPoint joinPoint) {
        logger.info("AOP 后置拦截");
    }
}