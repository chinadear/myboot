package com.bootplus.dao;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Blog;
import com.bootplus.model.Comment;

public interface ICommentDao extends IBaseDao{

	public Page queryCommentPage(Comment com, int pageNo, int pageSize);
	//发布状态的评论数量
	public long queryCommentCountByArticalPub(String blogId);
	//全部状态的评论数量
	public long queryCommentCountByArtical(String blogId);
	//一键发布
	public void publishAll(Blog blog);
}
