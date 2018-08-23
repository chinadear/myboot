package com.bootplus.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.bootplus.model.UFile;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Blog;
import com.bootplus.model.SysConfig;

public interface IBlogService {
	public List<Blog> getBlogList(Blog blog);
	public Page getBlogPage(Blog blog,int pageNo, int pageSize);
	public void save(Blog blog);
	public void delete(Blog blog);
	public void update(Blog blog);
	public Blog getBlogById(String id);
}
