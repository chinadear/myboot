package com.bootplus.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootplus.Util.CompUtil;
import com.bootplus.Util.Constants;
import com.bootplus.Util.GetRemoteIP;
import com.bootplus.Util.QRUtil;
import com.bootplus.Util.SplitWordUtil;
import com.bootplus.Util.GetRemoteIP;
import com.bootplus.core.base.BaseController;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dto.StructModel;
import com.bootplus.model.Blog;
import com.bootplus.model.Category;
import com.bootplus.model.Comment;
import com.bootplus.model.Drumbeating;
import com.bootplus.model.LeaveMsg;
import com.bootplus.model.SysConfig;
import com.bootplus.model.Tag;
import com.bootplus.model.TagBlog;
import com.bootplus.service.IBlogService;
import com.bootplus.service.ICategoryService;
import com.bootplus.service.ICommentService;
import com.bootplus.service.IDrumbeatingService;
import com.bootplus.service.ISysManageService;
import com.bootplus.service.ITagService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

@Controller
public class WebSiteController extends BaseController {
	private final static String RESOURCE_MENU_PREFIX="/website/blog";
	@Autowired
	private IBlogService blogService;
	@Autowired
	private ITagService tagService;
	@Autowired
	private ISysManageService sysManageService;
	@Autowired
	private ICommentService commentService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IDrumbeatingService drumbeatingService;
	/**
	 * 首页-待开发
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request) {
		Drumbeating db=new Drumbeating();
		db.setPlate("3");//板块类型，3：首页；从右到左分别为博客0，从0-1系列1，行业资讯2，首页3
		db.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		db.setType("0");
		List<Drumbeating> drumlist=drumbeatingService.queryDrumbList(db);
		if(drumlist.size()>0) {
			db=drumlist.get(0);
		}else {
			db=null;
		}
		HttpSession session=request.getSession();
		StructModel sm=(StructModel)session.getAttribute("structModel");
		sm.setBanner(db);
		session.setAttribute("structModel", sm);
		Category cate=new Category();
		cate.setType("1");//板块类型，1：从0-1板块
		List<Category> clist=categoryService.queryCategoryList(cate);
		model.addAttribute("clist", clist);
		return RESOURCE_MENU_PREFIX+"/index";
	}
	/**
	 * 从0-1系列
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/articals/series")
	public String series(Model model, HttpServletRequest request) {
		Category cate=new Category();
		cate.setType("1");//板块类型，1：从0-1板块
		List<Category> clist=categoryService.queryCategoryList(cate);
		Drumbeating db=new Drumbeating();
		db.setPlate("1");//板块类型，1：从0-1板块
		db.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		db.setType("0");
		List<Drumbeating> drumlist=drumbeatingService.queryDrumbList(db);
		if(drumlist.size()>0) {
			db=drumlist.get(0);
		}else {
			db=null;
		}
		HttpSession session=request.getSession();
		StructModel sm=(StructModel)session.getAttribute("structModel");
		sm.setBanner(db);
		session.setAttribute("structModel", sm);
		model.addAttribute("clist", clist);
		return RESOURCE_MENU_PREFIX+"/series";
	}
	/**
	 * 行业资讯
	 * Industry information
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/articals/news")
	public String news(Model model, HttpServletRequest request) {
		Blog blog=new Blog();
		blog.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		blog.setPlate("2");//行业资讯板块
		Page page=blogService.getBlogPage(blog, 1, Page.DEFAULT_PAGE_SIZE);
		Drumbeating db=new Drumbeating();
		db.setPlate("2");//板块类型，2：行业资讯
		db.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		db.setType("0");
		List<Drumbeating> drumlist=drumbeatingService.queryDrumbList(db);
		if(drumlist.size()>0) {
			db=drumlist.get(0);
		}else {
			db=null;
		}
		HttpSession session=request.getSession();
		StructModel sm=(StructModel)session.getAttribute("structModel");
		sm.setBanner(db);
		session.setAttribute("structModel", sm);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/news";
	}
	/**
	 * 行业资讯-加载更多
	 * @param model
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/articals/news/more",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String newsmore(Model model, HttpServletRequest request,int pageNum,int pageSize) {
		Blog blog=new Blog();
		blog.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		blog.setPlate("2");//行业资讯板块
		Page page=blogService.getBlogPage(blog,pageNum,pageSize);
		List<Blog> list=(List<Blog>)page.getResult();
		return CompUtil.array2Json(list);
	}
	/**
	 * 站内检索
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/articals/search")
	public String searcg(Model model, HttpServletRequest request,String words) {
		List<String> w=SplitWordUtil.split(words);
		Page page=blogService.getBlogSearchPage(w, 1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		model.addAttribute("words", words);
		model.addAttribute("count", page.getTotalCount());
		return RESOURCE_MENU_PREFIX+"/search";
	}
	/**
	 * 搜索更多-搜索结果的加载更多
	 * @param model
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @param words
	 * @return
	 */
	@RequestMapping(value="/articals/search/more",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String searchmore(Model model, HttpServletRequest request,int pageNum,int pageSize,String words) {
		List<Blog> list=new ArrayList<Blog>();
		List<String> w=SplitWordUtil.split(words);
		Page page=blogService.getBlogSearchPage(w, pageNum,pageSize);
		list=(List<Blog>)page.getResult();
		return CompUtil.array2Json(list);
	}
	/**
	 * 进入工具箱
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/articals/toolsbox")
	public String toolsbox(Model model, HttpServletRequest request) {
		Drumbeating db=new Drumbeating();
		db.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		db.setType(Constants.SYSTEM_DIC_DICITEM_FUNC_TOOLS);
		List<Drumbeating> tools=drumbeatingService.queryDrumbList(db);
		Drumbeating db2=new Drumbeating();
		db2.setPlate("5");//板块类型，5：首页；从右到左分别为博客0，从0-1系列1，行业资讯2，首页3
		db2.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		db2.setType("0");
		List<Drumbeating> drumlist=drumbeatingService.queryDrumbList(db2);
		if(drumlist.size()>0) {
			db2=drumlist.get(0);
		}else {
			db2=null;
		}
		HttpSession session=request.getSession();
		StructModel sm=(StructModel)session.getAttribute("structModel");
		sm.setBanner(db2);
		session.setAttribute("structModel", sm);
		model.addAttribute("tools", tools);
		return RESOURCE_MENU_PREFIX+"/toolsbox";
	}
	/**
	 * 刷新工具箱
	 * @param model
	 * @param request
	 * @param title
	 * @return
	 */
	@RequestMapping("/articals/flashToolsBox")
	public String flashToolsBox(Model model, HttpServletRequest request,String title) {
		Drumbeating db=new Drumbeating();
		db.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		db.setType(Constants.SYSTEM_DIC_DICITEM_FUNC_TOOLS);
		db.setTitle(title);
		List<Drumbeating> tools=drumbeatingService.queryDrumbList(db);
		model.addAttribute("tools", tools);
		return RESOURCE_MENU_PREFIX+"/innerpage/innertoolsbox";
	}
	/**
	 * 进入资源下载
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/articals/resdownload")
	public String resdownload(Model model, HttpServletRequest request) {
		Drumbeating db=new Drumbeating();
		db.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		db.setType(Constants.SYSTEM_DIC_DICITEM_FUNC_RESDOWNLOAD);
		List<Drumbeating> downloads=drumbeatingService.queryDrumbList(db);
		Drumbeating db2=new Drumbeating();
		db2.setPlate("6");//板块类型，5：首页；从右到左分别为博客0，从0-1系列1，行业资讯2，首页3
		db2.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		db2.setType("0");
		List<Drumbeating> drumlist=drumbeatingService.queryDrumbList(db2);
		if(drumlist.size()>0) {
			db2=drumlist.get(0);
		}else {
			db2=null;
		}
		HttpSession session=request.getSession();
		StructModel sm=(StructModel)session.getAttribute("structModel");
		sm.setBanner(db2);
		session.setAttribute("structModel", sm);
		model.addAttribute("downloads", downloads);
		return RESOURCE_MENU_PREFIX+"/resdownload";
	}
	/**
	 * 刷新资源下载
	 * @param model
	 * @param request
	 * @param title
	 * @return
	 */
	@RequestMapping("/articals/flashResDownload")
	public String flashResDownload(Model model, HttpServletRequest request,String title) {
		Drumbeating db=new Drumbeating();
		db.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		db.setType(Constants.SYSTEM_DIC_DICITEM_FUNC_RESDOWNLOAD);
		db.setTitle(title);
		List<Drumbeating> downloads=drumbeatingService.queryDrumbList(db);
		model.addAttribute("downloads", downloads);
		return RESOURCE_MENU_PREFIX+"/innerpage/innerresdownload";
	}
	/**
	 * tag以及分类的更多-内容导航
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/articals/tagAndcate/more")
	public String tagAndcateMore(Model model, HttpServletRequest request) {
		List<Category> clist=categoryService.queryCategoryList(new Category());
		List<Tag> tlist=tagService.queryTagList(new Tag());
		Drumbeating db2=new Drumbeating();
		db2.setPlate("4");//板块类型，4：首页；从右到左分别为博客0，从0-1系列1，行业资讯2，首页3
		db2.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		db2.setType("0");
		List<Drumbeating> drumlist=drumbeatingService.queryDrumbList(db2);
		if(drumlist.size()>0) {
			db2=drumlist.get(0);
		}else {
			db2=null;
		}
		HttpSession session=request.getSession();
		StructModel sm=(StructModel)session.getAttribute("structModel");
		sm.setBanner(db2);
		session.setAttribute("structModel", sm);
		model.addAttribute("clist", clist);
		model.addAttribute("tlist", tlist);
		return RESOURCE_MENU_PREFIX+"/tagandcate";
	}
	/**
	 * 博文列表
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/articals")
	public String articials(Model model, HttpServletRequest request) {
		Blog blog=new Blog();
		blog.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		blog.setPlate("0");//博客板块
		Page page=blogService.getBlogPage(blog, 1, Page.DEFAULT_PAGE_SIZE);
		Drumbeating db=new Drumbeating();
		db.setPlate("0");//板块类型，0：博客
		db.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		db.setType("0");
		List<Drumbeating> drumlist=drumbeatingService.queryDrumbList(db);
		if(drumlist.size()>0) {
			db=drumlist.get(0);
		}else {
			db=null;
		}
		HttpSession session=request.getSession();
		StructModel sm=(StructModel)session.getAttribute("structModel");
		sm.setBanner(db);
		session.setAttribute("structModel", sm);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/articals";
	}
	/**
	 * 浏览博文
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
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
		SysConfig sc=sysManageService.querySysConfigByKey(Constants.SYSTEM_DIC_SYSTEMCONFIG_SWITCH_COMMENT);
		Comment com=new Comment();
		com.setArtical(blog);
		com.setStatus("1");
		Page page=commentService.queryCommentPage(com, 1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("artical", blog);
		model.addAttribute("comment_switch", sc.getValue());
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/view";
	}
	/**
	 * 添加评论
	 * @param comment
	 * @param articalId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/articals/comment/add",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String addComment(String comment,String articalId,HttpServletRequest request) {
		SysConfig sc=sysManageService.querySysConfigByKey(Constants.SYSTEM_DIC_SYSTEMCONFIG_CHECK_COMMENT);
		Blog blog=new Blog();
		blog.setId(articalId);
		Comment com=new Comment();
		com.setComment(comment);
		com.setArtical(blog);
		com.setScreenname(GetRemoteIP.vague(request));
		com.setStatus("0".equals(sc.getValue())?"1":"0");
		commentService.save(com);
		return "t";
	}
	/**
	 * tag检索博文列表
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
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
	 * cate检索博文列表
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/articals/cate/{id}")
	public String articialsBycate(Model model, HttpServletRequest request,@PathVariable String id) {
		Blog blog=new Blog();
		blog.setStatus("1");
		blog.setCateId(id);
		Page page=blogService.getBlogPage(blog, 1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		model.addAttribute("cateid", id);
		return RESOURCE_MENU_PREFIX+"/articals4cate";
	}
	/**
	 * 文章加载更多
	 * 共用：包括tag,cat，文章，3块的加载更多
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
			blog.setCateId(cateid);
			Page page=blogService.getBlogPage(blog, pageNum, pageSize);
			list=(List<Blog>)page.getResult();
		}else {//文章的加载更多
			blog.setPlate("0");
			Page page=blogService.getBlogPage(blog, pageNum, pageSize);
			list=(List<Blog>)page.getResult();
		}
		return CompUtil.array2Json(list);
	}
	/**
	 * 弹出分享到微信的窗口
	 * @param model
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/articals/share2wx/{id}")
	public String share2wx(Model model,HttpServletResponse response,@PathVariable String id){
		model.addAttribute("id",id);
		return RESOURCE_MENU_PREFIX+"/innerpage/qrcode";
	}
	/**
	 * 分享到微信，显示二维码
	 * @param response
	 * @param id
	 */
	@RequestMapping("/articals/share2wx/QRcode/{id}")
	public void showQR(HttpServletResponse response,@PathVariable String id){
        int width = 300; 
        int height = 300;
        String text="https://www.bootplus.com.cn/articals/"+id;
        if(!StringUtils.hasText(id)) {
        	text="https://www.bootplus.com.cn";
        }
        String format = "jpg"; 
        Hashtable hints = new Hashtable(); 
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); 
        BitMatrix bitMatrix;
		try {
			text = new String(text.trim().getBytes("ISO-8859-1"),"UTF-8");
			bitMatrix = new MultiFormatWriter().encode(text, 
			        BarcodeFormat.QR_CODE, width, height, hints);
//			QRUtil.writeToFile(bitMatrix, format, outputFile); 
			QRUtil.writeToStream(bitMatrix, format, response.getOutputStream());
//			BufferedImage bi=QRUtil.toBufferedImage(bitMatrix);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/**
	 * 留言
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/articals/sendMsg",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String sendMsg(Model model, HttpServletRequest request,String msg) {
		HttpSession session=request.getSession();
		String flag=(String)session.getAttribute("user_send_message");
		if(StringUtils.hasText(flag)&&"1".equals(flag)) {
			return "S";//已经发送过了，一个session周期只能发送一次，防止高频发送
		}
		String ip=GetRemoteIP.getRequestUserIpAddr(request);
		LeaveMsg lm=new LeaveMsg();
		lm.setMessage(msg);
		lm.setIp(ip);
		blogService.saveLeaveMsg(lm);
		session.setAttribute("user_send_message", "1");
		return "T";
	}
}
