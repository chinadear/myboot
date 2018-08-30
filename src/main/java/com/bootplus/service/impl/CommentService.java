package com.bootplus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.core.base.BaseServiceImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.ICommentDao;
import com.bootplus.model.Comment;
import com.bootplus.service.ICommentService;

@Service
@Transactional
public class CommentService extends BaseServiceImpl implements ICommentService {
	@Autowired
	private ICommentDao commentDao;

	@Override
	public void save(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.save(comment);
	}

	@Override
	public void update(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.update(comment);
	}

	@Override
	public void delete(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.delete(comment);
	}

	@Override
	public Comment getCommentById(String id) {
		// TODO Auto-generated method stub
		return (Comment)commentDao.get(Comment.class, id);
	}

	@Override
	public Page queryCommentPage(Comment com, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return commentDao.queryCommentPage(com, pageNo, pageSize);
	}

	@Override
	public long queryCommentCountByArtical(String blogId) {
		// TODO Auto-generated method stub
		return commentDao.queryCommentCountByArtical(blogId);
	}

	@Override
	public long queryCommentCountByArticalPub(String blogId) {
		// TODO Auto-generated method stub
		return commentDao.queryCommentCountByArticalPub(blogId);
	}
	
}
