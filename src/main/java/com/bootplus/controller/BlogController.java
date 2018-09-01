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
import com.bootplus.model.SysConfig;
import com.bootplus.model.Tag;
import com.bootplus.model.TagBlog;
import com.bootplus.model.UFile;
import com.bootplus.model.User;
import com.bootplus.service.IBlogService;
import com.bootplus.service.ICategoryService;
import com.bootplus.service.ILoginService;
import com.bootplus.service.ISysManageService;
import com.bootplus.service.ITagService;
/**
 * 博客管理
 * @author liulu
 * 规则：
 * 1.key增加后不可修改，只可修改value
 * 2.删除配置要加保护，不能随便删除，打开保护，启用删除功能
 * ========
 * 博客状态变化图,0草稿；1发布；2未发布
 * 0->1；2->1；1->2
 * 发布状态变为1
 * 保存状态不变0/2
 */
@Controller
public class BlogController extends BaseController {
	
	private final static String RESOURCE_MENU_PREFIX="/member/blog";
	@Autowired
	private ISysManageService sysManageService;
	@Autowired
	private IBlogService blogService;
	@Autowired
	private ILoginService loginService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private ITagService tagService;
	/**
	 * 进入我的博客管理页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/blog/myblogs")
	public String myblogs(Model model, HttpServletRequest request) {
		UserSession us=(UserSession)request.getSession().getAttribute(UserSession.SESSION_USER_KEY);
		User user=loginService.findUserById(us.getUserId());
		Blog blog=new Blog();
		blog.setUser(user);
		Page page=blogService.getBlogPage(blog, 1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/listblog";
	}
	/**
	 * 进入写博客页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/blog/write")
	public String configList(Model model, HttpServletRequest request) {
		List<Category> clist=categoryService.queryCategoryList();
		model.addAttribute("clist",clist);
		return RESOURCE_MENU_PREFIX+"/writeblog";
	}
	/**
	* 博文新增保存
	* @param model
	* @param request
	* @param blog
	* @param blog.status：0草稿，1发布，2未发布
	* @return
	*/
	@RequestMapping("/blog/save")
	public String saveBlog(Model model, HttpServletRequest request,Blog blog) {
		UserSession us=(UserSession)request.getSession().getAttribute(UserSession.SESSION_USER_KEY);
		User user=loginService.findUserById(us.getUserId());
		blog.setUser(user);
		if(StringUtils.hasText(blog.getCateId())) {
			Category cate=new Category();
			cate.setId(blog.getCateId());
			blog.setCategory(cate);
		}
		blogService.save(blog);
		if("1".equals(blog.getStatus())) {//如果是发布 则还需要处理标签
			if(StringUtils.hasText(blog.getTags())) {
				String[] tags=blog.getTags().split(",");
				for(String s:tags) {
					Tag tag=tagService.getTagByName(s);
					if(tag==null || !StringUtils.hasText(tag.getId())) {//已经存在跳过
						tag=new Tag();
						tag.setName(s);
						tagService.save(tag);
					}
					TagBlog tagBlog=new TagBlog();
					tagBlog.setBlog(blog);
					tagBlog.setTag(tag);
					tagService.save(tagBlog);
				}
			}
		}
		return "redirect:/blog/myblogs";
	}
	/**
	 * 进入编辑博客页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/blog/editblog/{id}")
	public String editblog(Model model, HttpServletRequest request,@PathVariable String id) {
		Blog blog=blogService.getBlogById(id);
		List<Category> clist=categoryService.queryCategoryList();
		TagBlog tb=new TagBlog();
		tb.setBlog(blog);
		List<TagBlog> tblist=tagService.queryTagBlogList(tb);
		if(tblist.size()>0) {
			List<String> s=new ArrayList<String>();
			for(TagBlog n:tblist) {
				s.add(n.getTag().getName()); 
			}
			blog.setTags(s.toString().substring(1,s.toString().length()-1));
		}
		model.addAttribute("clist",clist);
		model.addAttribute("blog", blog);
		return RESOURCE_MENU_PREFIX+"/editblog";
	}
	/**
	 * 博文编辑保存
	 * @param model
	 * @param request
	 * @param prestatus 之前的状态，用于区别保存状态草稿0保存完还是草稿状态，未发布2保存完还是未发布状态
	 * 未发布和草稿发布后都为发布状态（1）
	 * 草稿状态只能变为发布状态，并且有草稿状态变为发布状态需要处理文章属性如分类标签等
	 * =====
	 * 0-1需要处理分类和标签，其他状态变更不需要处理
	 * @return
	 */
	@RequestMapping("/blog/modify")
	public String editblog(Model model, HttpServletRequest request,Blog blog,String prestatus) {
		Blog b = blogService.getBlogById(blog.getId());
		b.setContent(blog.getContent());
		b.setTitle(blog.getTitle());
		b.setSummary(blog.getSummary());
		b.setStatus(blog.getStatus());
		b.setDiscuss(blog.getDiscuss());
		//由0到1需要设置文章meta
		if("1".equals(blog.getStatus())) {
			if(StringUtils.hasText(blog.getCateId())) {
				Category cate=new Category();
				cate.setId(blog.getCateId());
				b.setCategory(cate);
			}else {
				b.setCategory(null);
			}
		}
		if("0".equals(prestatus)&&"1".equals(blog.getStatus())) {
			if(StringUtils.hasText(blog.getTags())) {
				String[] tags=blog.getTags().split(",");
				for(String s:tags) {
					Tag tag=tagService.getTagByName(s);
					if(tag==null || !StringUtils.hasText(tag.getId())) {//已经存在跳过
						tag=new Tag();
						tag.setName(s);
						tagService.save(tag);
					}
					TagBlog tagBlog=new TagBlog();
					tagBlog.setBlog(blog);
					tagBlog.setTag(tag);
					tagService.save(tagBlog);
				}
			}
		}
		blogService.update(b);
		return "redirect:/blog/myblogs";
	}
	/**
	 * 删除博客
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/blog/delete",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String deleteblog(Model model, HttpServletRequest request,String id) {
		Blog blog=blogService.getBlogById(id);
		blogService.delete(blog);
		return "t";
	}
	/**
	 * 发布与取消发布
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping(value="/blog/updateStatus",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String updateStatus(String id,String status) {
		Blog b = blogService.getBlogById(id);
		b.setStatus(status);
		blogService.update(b);
		return "t";
	}
	/**
	 * 一键启用/禁止评论
	 * @param status 0关闭，1开启
	 * @return
	 */
	@RequestMapping(value="/blog/togglediscuss",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String publishAll(String status) {
		if("1".equals(status)) {
			blogService.enabledAllDiscuss();
		}else {
			blogService.disabledAllDiscuss();
		}
		return "t";
	}
	/**
	 * 翻页刷新列表
	 * @param model
	 * @param request
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("/blog/noSitemesh/loadblogstable")
	public String loadmembertable(Model model, HttpServletRequest request,String pageNo) {
		UserSession us=(UserSession)request.getSession().getAttribute(UserSession.SESSION_USER_KEY);
		User user=loginService.findUserById(us.getUserId());
		Blog blog=new Blog();
		blog.setUser(user);
		Page page=blogService.getBlogPage(blog,StringUtils.hasText(pageNo)?Integer.valueOf(pageNo):1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/blogTable";
	}
	/**
	 * 处理文件上传
	 * @param file
	 * @param request
	 * @return
	 */
    @RequestMapping(value="/blog/uploadimg",produces=MediaType.APPLICATION_JSON_VALUE)//text/plain,charset=UTF-8"
	@ResponseBody
    public Map<String,Object> uploadimg(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
//        response.setHeader("X-Frame-Options", "SAMEORIGIN");
        UFile uf=sysManageService.uploadFile(file,"0",0,0,request);//type=0降低画质，1自定义宽高缩放，2等比缩放，3附件
        resultMap.put("success", 1);
        resultMap.put("message", "上传成功！");
        resultMap.put("url",request.getContextPath()+"/blog/noSecurity/img/"+uf.getId());
        return resultMap;
    }
    /**
     * 显示博客内容包含的图片
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/blog/noSecurity/img/{id}", method = RequestMethod.GET)
	public String IoheaderImage(@PathVariable String id,HttpServletRequest request,HttpServletResponse response){
		ServletOutputStream out = null;
		FileInputStream ips = null;
		String imgpath=null;//文件路径
			UFile ufile=sysManageService.getUploadFileById(id);
			//读取系统配置中的文件存储根路径
			List<SysConfig> sclist=sysManageService.querySysConfigListByKey(Constants.SYSTEM_DIC_SYSTEMCONFIG_UPLOADPATH_KEY);
			if(sclist.size()>0&&StringUtils.hasText(sclist.get(0).getValue())) {//存在
				imgpath=CompUtil.formatDir(sclist.get(0).getValue())+ufile.getPath()+ufile.getFileName();
			}
		try {
			if(imgpath==null) {//直接获取系统默认头像
				try {
					ips = new FileInputStream(ResourceUtils.getFile("classpath:static//lib//dist//img//user2-160x160.jpg"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				ips = new FileInputStream(imgpath);
			}
			response.setContentType("image/*"); 
			int i=ips.available();
			byte data[]=new byte[i];
			ips.read(data);
			out=response.getOutputStream();
			//输出数据
			out.write(data);
			out.flush();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				out.close();
				ips.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
