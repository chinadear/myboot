package com.bootplus.service;

import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Comment;

public interface ICommentService {
	
	public void save(Comment comment);
	public void update(Comment comment);
	public void delete(Comment comment);
	public Comment getCommentById(String id);
	public Page queryCommentPage(Comment com, int pageNo, int pageSize);
	/**
	 * 获取某篇文章的全部评论包含未发布的评论数量
	 * @param blogId
	 * @return
	 */
	public long queryCommentCountByArtical(String blogId);
	/**
	 * 获取谋篇文章的已发布的评论数量
	 * @param blogId
	 * @return
	 */
	public long queryCommentCountByArticalPub(String blogId);
}
