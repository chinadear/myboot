package com.bootplus.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.ICommentDao;
import com.bootplus.model.Blog;
import com.bootplus.model.Comment;

@Repository
public class CommentDao extends BaseDaoImpl implements ICommentDao {

	@Override
	public Page queryCommentPage(Comment com, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from Comment where 1=1 ");
		Map paramMap = new HashMap();
		if(com.getArtical()!=null && StringUtils.hasText(com.getArtical().getId())) {
			sb.append(" and artical.id=:blogid");
			paramMap.put("blogid", com.getArtical().getId());
		}
		if(com.getStatus()!=null && StringUtils.hasText(com.getStatus())) {
			sb.append(" and status=:status");
			paramMap.put("status", com.getStatus());
		}
		return this.pagedQuery(sb.toString(),paramMap, pageSize, pageNo);
	}

	@Override
	public long queryCommentCountByArtical(String blogId) {
		// TODO Auto-generated method stub
		return this.queryCount("select count(*) from Comment where artical.id=? ", blogId);
	}

	@Override
	public long queryCommentCountByArticalPub(String blogId) {
		// TODO Auto-generated method stub
		return this.queryCount("select count(*) from Comment where status='1' and artical.id=? ", blogId);
	}

	@Override
	public void publishAll(Blog blog) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("update Comment set status='1' where 1=1 ");
		Map paramMap = new HashMap();
		if(StringUtils.hasText(blog.getId())) {
			sb.append(" and artical.id=:articalId");
			paramMap.put("articalId", blog.getId());
		}
		this.executeHql(sb.toString(), paramMap);
	}

}
