package com.bootplus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootplus.Util.CompUtil;
import com.bootplus.core.base.BaseController;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Blog;
import com.bootplus.model.Tag;
import com.bootplus.model.TagBlog;
import com.bootplus.service.IBlogService;
import com.bootplus.service.ISysManageService;
import com.bootplus.service.ITagService;

@Controller
public class WebSiteController extends BaseController {
	private final static String RESOURCE_MENU_PREFIX="/website/blog";
	@Autowired
	private IBlogService blogService;
	@Autowired
	private ITagService tagService;
	@Autowired
	private ISysManageService sysManageService;
	
	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request) {
		return RESOURCE_MENU_PREFIX+"/search";
	}
	//博文列表
	@RequestMapping("/articals")
	public String articials(Model model, HttpServletRequest request) {
		Blog blog=new Blog();
		blog.setStatus("1");
		Page page=blogService.getBlogPage(blog, 1, 2);//Page.DEFAULT_PAGE_SIZE
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/articals";
	}
	//浏览博文
	@RequestMapping("/articals/{id}")
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
	//指定tag下的博文列表
	@RequestMapping("/articals/tags/{id}")
	public String articialsBytag(Model model, HttpServletRequest request,@PathVariable String id) {
		Tag tag = new Tag();
		tag.setId(id);
		Blog blog=new Blog();
		blog.setStatus("1");
		TagBlog tb=new TagBlog();
		tb.setBlog(blog);
		tb.setTag(tag);
		Page page=tagService.queryTagBlogPage(tb, 1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		model.addAttribute("tagid", id);
		return RESOURCE_MENU_PREFIX+"/articals4tag";
	}
	/**
	 * 文章加载更多
	 * @param model
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/articals/more",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String loadmore(Model model, HttpServletRequest request,int pageNum,int pageSize,String tagid,String cateid) {
		Blog blog=new Blog();
		blog.setStatus("1");
		List<Blog> list=new ArrayList<Blog>();
		if(StringUtils.hasText(tagid)) {//标签检索文章---的--加载更多
			Tag tag = new Tag();
			tag.setId(tagid);
			TagBlog tb=new TagBlog();
			tb.setBlog(blog);
			tb.setTag(tag);
			Page page=tagService.queryTagBlogPage(tb, pageNum, pageSize);
			List<TagBlog> l=(List<TagBlog>)page.getResult();
			for(TagBlog t:l) {
				list.add(t.getBlog());
			}
		}else if(StringUtils.hasText(cateid)) {//分类检索文章---的---加载更多
			
		}else {//文章的加载更多
			Page page=blogService.getBlogPage(blog, pageNum, pageSize);
			list=(List<Blog>)page.getResult();
		}
		return CompUtil.array2Json(list);
	}
}
