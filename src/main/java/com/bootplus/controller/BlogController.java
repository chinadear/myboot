package com.bootplus.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import com.bootplus.model.Blog;
import com.bootplus.model.SysConfig;
import com.bootplus.model.UFile;
import com.bootplus.model.User;
import com.bootplus.service.IBlogService;
import com.bootplus.service.ISysManageService;
/**
 * 博客管理
 * @author liulu
 * 规则：
 * 1.key增加后不可修改，只可修改value
 * 2.删除配置要加保护，不能随便删除，打开保护，启用删除功能
 * 
 */
@Controller
public class BlogController extends BaseController {
	
	private final static String RESOURCE_MENU_PREFIX="/member/blog";
	@Autowired
	private ISysManageService sysManageService;
	@Autowired
	private IBlogService blogService;
	//进入博客编辑页面
	@RequestMapping("/blog/write")
	public String configList(Model model, HttpServletRequest request) {
		return RESOURCE_MENU_PREFIX+"/edit";
	}
	//处理文件上传
    @RequestMapping(value="/blog/uploadimg",produces=MediaType.APPLICATION_JSON_VALUE)//text/plain,charset=UTF-8"
	@ResponseBody
    public Map<String,Object> uploadimg(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
//        response.setHeader("X-Frame-Options", "SAMEORIGIN");
        UFile uf=sysManageService.uploadFile(file,"2",request);
        resultMap.put("success", 1);
        resultMap.put("message", "上传成功！");
        resultMap.put("url",request.getContextPath()+"/blog/noSecurity/img/"+uf.getId());
        return resultMap;
    }
    //显示博客内容包含的图片
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
    @RequestMapping("/blog/save")
	public String saveBlog(Model model, HttpServletRequest request,Blog blog) {
    	blogService.save(blog);
    	return "redirect:/blog/write";
    }
}
