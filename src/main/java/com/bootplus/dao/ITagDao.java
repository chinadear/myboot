package com.bootplus.dao;

import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Tag;
import com.bootplus.model.TagBlog;

public interface ITagDao<T> extends IBaseDao{

	public Tag getTagByName(String name);
	public List<TagBlog> queryTagBlogList(TagBlog tagBlog);
	public Page queryTagBlogPage(TagBlog tagBlog, int pageNo, int pageSize);
}
