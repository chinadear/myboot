package com.bootplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.core.base.BaseServiceImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.IBlogDao;
import com.bootplus.model.Blog;
import com.bootplus.service.IBlogService;

@Service
@Transactional
public class BlogService extends BaseServiceImpl implements IBlogService {

	@Autowired
	private IBlogDao blogDao;

	@Override
	public List<Blog> getBlogList(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.getBlogList(blog);
	}

	@Override
	public Page getBlogPage(Blog blog, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return blogDao.getBlogPage(blog, pageNo, pageSize);
	}

	@Override
	public void save(Blog blog) {
		// TODO Auto-generated method stub
		blogDao.save(blog);
	}

	@Override
	public void delete(Blog blog) {
		// TODO Auto-generated method stub
		blogDao.delete(blog);
	}

	@Override
	public void update(Blog blog) {
		// TODO Auto-generated method stub
		blogDao.update(blog);
	}

	@Override
	public Blog getBlogById(String id) {
		// TODO Auto-generated method stub
		return (Blog)blogDao.get(Blog.class, id);
	}

	@Override
	public void disabledAllDiscuss() {
		// TODO Auto-generated method stub
		blogDao.disabledAllDiscuss();
	}

	@Override
	public void enabledAllDiscuss() {
		// TODO Auto-generated method stub
		blogDao.enabledAllDiscuss();
	}

	@Override
	public void updateViewNum(String articalId) {
		// TODO Auto-generated method stub
		blogDao.updateViewNum(articalId);
	}
	
	@Override
	public Page getBlogSearchPage(List<String> words, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return blogDao.getBlogSearchPage(words, pageNo, pageSize);
	}
}
