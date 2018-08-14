package com.bootplus.core.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bootplus.core.filter.WebSiteMeshFilter;
/**
 * sitemesh的配置类
 * @author liulu
 *
 */
@Configuration
public class WebSiteMeshConfig implements WebMvcConfigurer{
	@Bean
	public FilterRegistrationBean<WebSiteMeshFilter> siteMeshFilter() {
		FilterRegistrationBean<WebSiteMeshFilter> fitler = new FilterRegistrationBean<WebSiteMeshFilter>();
		WebSiteMeshFilter siteMeshFilter = new WebSiteMeshFilter();
		fitler.setFilter(siteMeshFilter);
		return fitler;
	}
}
