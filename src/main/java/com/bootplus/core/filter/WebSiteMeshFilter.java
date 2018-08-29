package com.bootplus.core.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * sitemesh的装饰过滤器的配置类
 * @author liulu
 *
 */
public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
	@Override   
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {     
//		logger.info("進入sitemeshfilter");
		builder.addDecoratorPath("/main", "/decorators/main") //设置模板装饰的请求，参数（请求，装饰该请求的装饰模板）
		.addDecoratorPath("/*/**", "/decorators/main")
		/*//可设置不同请求用不同模板装饰
		.addDecoratorPath("/例子1/**", "/decorators/blog/website")
	     .addDecoratorPath("/例子2/**", "/WEB-INF/views/decorators/decorator.jsp") */     
//		 .addExcludedPath("/")
	     .addExcludedPath("/auth/login") //白名单，不进行过滤           
	     .addExcludedPath("/**/noSitemesh/**")   //白名单，不进行过滤           
	     .addExcludedPath("/articals/**"); //白名单，不进行过滤   
//	   builder.addTagRuleBundles(new DivExtractingTagRuleBundle());  //用于添加自定义标签
	}
}
