package com.bootplus.core.sitemeshController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 由于没有sitemesh3.xml中配置mapping了，
 * 所以要用一个controller来请求模板，请求路径和返回的模板路径一致
 * @author liulu
 *
 */
@Controller
@RequestMapping("/decorators")
public class DecoratorController {
	@RequestMapping("main")
    public String defaultDecorator() {
        return "/decorators/main";
    }
/*	@RequestMapping("blog/website")
    public String defaultWebDecorator() {
        return "/decorators/blog/website";
    }*/
}
