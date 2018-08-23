package com.bootplus.dao;

import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Blog;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;

public interface IBlogDao<T> extends IBaseDao{

	public List<Blog> getBlogList(Blog blog);
	public Page getBlogPage(Blog blog,int pageNo, int pageSize);
}
