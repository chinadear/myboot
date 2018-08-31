package com.bootplus.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bootplus.Util.CompUtil;
import com.bootplus.Util.Constants;
import com.bootplus.core.base.BaseController;
import com.bootplus.core.base.UserSession;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Blog;
import com.bootplus.model.Category;
import com.bootplus.model.Comment;
import com.bootplus.model.SysConfig;
import com.bootplus.model.Tag;
import com.bootplus.model.TagBlog;
import com.bootplus.model.UFile;
import com.bootplus.model.User;
import com.bootplus.service.IBlogService;
import com.bootplus.service.ICategoryService;
import com.bootplus.service.ICommentService;
import com.bootplus.service.ILoginService;
import com.bootplus.service.ISysManageService;
import com.bootplus.service.ITagService;
/**
 * 评论管理
 * @author liulu
 *
 */
@Controller
public class CommentController extends BaseController {
	
	private final static String RESOURCE_MENU_PREFIX="/member/comment";
	
	@Autowired
	private IBlogService blogService;
	@Autowired
	private ILoginService loginService;
	@Autowired
	private ICommentService commentService;
	/**
	 * 进入我的博客管理页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/comment/blogs")
	public String myblogs(Model model, HttpServletRequest request) {
		UserSession us=(UserSession)request.getSession().getAttribute(UserSession.SESSION_USER_KEY);
		User user=loginService.findUserById(us.getUserId());
		Blog blog=new Blog();
		blog.setUser(user);
		Page page=blogService.getBlogPage(blog, 1, Page.DEFAULT_PAGE_SIZE);
		List<Blog> list=new ArrayList<Blog>();
		for(Blog b:(List<Blog>)page.getResult()) {
			//该文章的全部评论
			long num=commentService.queryCommentCountByArtical(b.getId());
			//该文章发布的评论
			long pnum=commentService.queryCommentCountByArticalPub(b.getId());
			if(num>pnum) {
				b.setIsNnPub("1");
			}else {
				b.setIsNnPub("0");
			}
			b.setCommentNum(num);
			list.add(b);
		}
		page.setResult(list);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/listblog";
	}
	/**
	 * 翻页刷新列表
	 * @param model
	 * @param request
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/comment/noSitemesh/loadblogstable")
	public String loadmembertable(Model model, HttpServletRequest request,String pageNo) {
		UserSession us=(UserSession)request.getSession().getAttribute(UserSession.SESSION_USER_KEY);
		User user=loginService.findUserById(us.getUserId());
		Blog blog=new Blog();
		blog.setUser(user);
		Page page=blogService.getBlogPage(blog,StringUtils.hasText(pageNo)?Integer.valueOf(pageNo):1, Page.DEFAULT_PAGE_SIZE);
		List<Blog> list=new ArrayList<Blog>();
		for(Blog b:(List<Blog>)page.getResult()) {
			//该文章的全部评论
			long num=commentService.queryCommentCountByArtical(b.getId());
			//该文章发布的评论
			long pnum=commentService.queryCommentCountByArticalPub(b.getId());
			if(num>pnum) {
				b.setIsNnPub("1");
			}else {
				b.setIsNnPub("0");
			}
			b.setCommentNum(num);
			list.add(b);
		}
		page.setResult(list);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/blogTable";
	}
	/**
	 * 进入评论列表
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/comment/comments/{id}")
	public String comments(Model model, HttpServletRequest request,@PathVariable String id) {
		Comment comment=new Comment();
		Blog blog=new Blog();
		blog.setId(id);
		comment.setArtical(blog);
		Page page=commentService.queryCommentPage(comment, 1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		model.addAttribute("blogid", id);
		return RESOURCE_MENU_PREFIX+"/listcomment"; 
		
	}
	/**
	 * 翻页刷新评论列表
	 * @param model
	 * @param request
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/comment/noSitemesh/loadcommenttable")
	public String loadcommenttable(Model model, HttpServletRequest request,String pageNo,String id) {
		Comment comment=new Comment();
		Blog blog=new Blog();
		blog.setId(id);
		comment.setArtical(blog);
		Page page=commentService.queryCommentPage(comment,StringUtils.hasText(pageNo)?Integer.valueOf(pageNo):1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/commentTable";
	}
	/**
	 * 发布与取消发布
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping(value="/comment/updateStatus",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String updateStatus(String id,String status) {
		Comment com=commentService.getCommentById(id);
		com.setStatus(status);
		commentService.update(com);
		return "t";
	}
	/**
	 * 一键发布
	 * @param id 文章ID
	 * @return
	 */
	@RequestMapping(value="/comment/publishAll",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String publishAll(String id) {
		Blog blog=new Blog();
		if(StringUtils.hasText(id)) {
			blog.setId(id);
		}
		commentService.publishAll(blog);
		return "t";
	}
	/**
	 * 删除评论
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/comment/delete",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String delete(String id) {
		Comment com=commentService.getCommentById(id);
		commentService.delete(com);
		return "t";
	}
}
