package com.bootplus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootplus.core.base.BaseController;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Blog;
import com.bootplus.model.TagBlog;
import com.bootplus.service.IBlogService;
import com.bootplus.service.ITagService;

@Controller
public class WebSiteController extends BaseController {
	private final static String RESOURCE_MENU_PREFIX="/website/blog";
	@Autowired
	private IBlogService blogService;
	@Autowired
	private ITagService tagService;
	//博文列表
	@RequestMapping("/liulu/blog")
	public String articials(Model model, HttpServletRequest request) {
		Blog blog=new Blog();
		blog.setStatus("1");
		Page page=blogService.getBlogPage(blog, 1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/articals";
	}
	//浏览博文
	@RequestMapping("/liulu/blog/{id}")
	public String view(Model model, HttpServletRequest request,@PathVariable String id) {
		Blog blog=blogService.getBlogById(id);
		TagBlog tb=new TagBlog();
		tb.setBlog(blog);
		List<TagBlog> tblist=tagService.queryTagBlogList(tb);
		if(tblist.size()>0) {
			List<String> s=new ArrayList<String>();
			for(TagBlog n:tblist) {
				s.add(n.getTag().getName()); 
			}
			blog.setTags(s.toString().substring(1,s.toString().length()-1));
			model.addAttribute("tags", tblist);
		}
		model.addAttribute("artical", blog);
		return RESOURCE_MENU_PREFIX+"/view";
	}
}
