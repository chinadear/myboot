package com.bootplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.core.base.BaseServiceImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.ICategoryDao;
import com.bootplus.dao.IRoleDao;
import com.bootplus.dao.ITagDao;
import com.bootplus.model.Role;
import com.bootplus.model.Tag;
import com.bootplus.model.TagBlog;
import com.bootplus.service.IRoleService;
import com.bootplus.service.ITagService;

@Service
@Transactional
public class TagService extends BaseServiceImpl implements ITagService {
	@Autowired
	private ITagDao tagDao;

	@Override
	public Tag getTagByName(String name) {
		// TODO Auto-generated method stub
		return tagDao.getTagByName(name);
	}

	@Override
	public List<TagBlog> queryTagBlogList(TagBlog tagBlog) {
		// TODO Auto-generated method stub
		return tagDao.queryTagBlogList(tagBlog);
	}

	@Override
	public Page queryTagBlogPage(TagBlog tagBlog, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return tagDao.queryTagBlogPage(tagBlog, pageNo, pageSize);
	}

	@Override
	public void save(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.save(tag);
	}

	@Override
	public void save(TagBlog tabBlog) {
		// TODO Auto-generated method stub
		tagDao.save(tabBlog);
	}

	@Override
	public void update(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.update(tag);
	}

	@Override
	public void update(TagBlog tabglog) {
		// TODO Auto-generated method stub
		tagDao.update(tabglog);
	}

	@Override
	public Page queryTagPage(Tag tag, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return tagDao.queryTagPage(tag, pageNo, pageSize);
	}

	@Override
	public List<Tag> queryTagList(Tag tag) {
		// TODO Auto-generated method stub
		return tagDao.queryTagList(tag);
	}
}
