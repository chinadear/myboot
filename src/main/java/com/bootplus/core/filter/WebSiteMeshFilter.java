package com.bootplus.core.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demon.controller.ViewController;
/**
 * sitemesh的装饰过滤器的配置类
 * @author liulu
 *
 */
public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
	private final Logger logger=LoggerFactory.getLogger(ViewController.class);
	@Override   
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {     
//		logger.info("進入sitemeshfilter");
		builder.addDecoratorPath("/*", "/decorators/main") //设置模板装饰的请求，参数（请求，装饰该请求的装饰模板）       
//	     .addDecoratorPath("/strategy/**", "/WEB-INF/views/decorators/decorator.jsp")//可设置不同请求用不同模板装饰           
	     .addExcludedPath("/auth/login") //白名单，不进行过滤           
	     .addExcludedPath("/*/noSitemesh/**");   //白名单，不进行过滤           
//	     .addExcludedPath("/popup/**"); //白名单，不进行过滤    
//	   builder.addTagRuleBundles(new DivExtractingTagRuleBundle());  //用于添加自定义标签
	}
}
