package com.bootplus.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.ICommentDao;
import com.bootplus.model.Comment;

@Repository
public class CommentDao extends BaseDaoImpl implements ICommentDao {

	@Override
	public Page queryCommentPage(Comment com, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return this.pagedQuery("from Comment where artical.id=? order by createTime", pageNo, pageSize,com.getArtical().getId());
	}

	@Override
	public long queryCommentCountByArtical(String blogId) {
		// TODO Auto-generated method stub
		return this.queryCount("from Comment where artical.id=? ", blogId);
	}

	@Override
	public long queryCommentCountByArticalPub(String blogId) {
		// TODO Auto-generated method stub
		return this.queryCount("from Comment where status='1' and artical.id=? ", blogId);
	}

}
