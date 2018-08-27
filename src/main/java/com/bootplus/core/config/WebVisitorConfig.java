package com.bootplus.core.config;

import javax.annotation.Resource;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bootplus.core.filter.WebSiteMeshFilter;
import com.bootplus.core.interceptor.VisitorInterceptor;
/**
 * 访问拦截器的配置类
 * 拦截目录说明
 * 静态资源路径全部放行
 * "/security/**"：登陆后公共权限，所有人都可以调用的
	"/main"：首页链接
	"/decorators/main"：freemarker模板的请求
 * @author liulu
 *
 */
@Configuration
public class WebVisitorConfig implements WebMvcConfigurer{
	@Resource
	private VisitorInterceptor visitorInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub	
		registry.addInterceptor(visitorInterceptor).addPathPatterns("/**")
		.excludePathPatterns("/webjars/**", "/css/**",
				"/lib/**", "/img/**","/liulu/**", "/js/**","/error","/security/**",
				"/main","/decorators/main","/registerAdmin");
	}
}
