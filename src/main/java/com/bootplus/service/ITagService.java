package com.bootplus.service;

import java.util.List;

import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Tag;
import com.bootplus.model.TagBlog;

public interface ITagService {
	public Tag getTagByName(String name);
	public List<TagBlog> queryTagBlogList(TagBlog tagBlog);
	public Page queryTagBlogPage(TagBlog tagBlog, int pageNo, int pageSize);
	public void save(Tag tag);
	public void save(TagBlog tabBlog);
	public void update(Tag tag);
	public void update(TagBlog tagglog);
	public Page queryTagPage(Tag tag, int pageNo, int pageSize);
	public List<Tag> queryTagList(Tag tag);
}
