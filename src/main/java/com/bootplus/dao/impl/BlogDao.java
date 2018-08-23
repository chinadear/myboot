package com.bootplus.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootplus.Util.Constants;
import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.IBlogDao;
import com.bootplus.dao.IUserDao;
import com.bootplus.model.Blog;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;

@Repository
public class BlogDao extends BaseDaoImpl implements IBlogDao {

	@Override
	public List<Blog> getBlogList(Blog blog) {
		//status：0草稿，1发布，2封禁
		StringBuffer sb=new StringBuffer("from Blog where 1=1 ");
		Map paramMap = new HashMap();
		if(blog.getUser()!=null && StringUtils.hasText(blog.getUser().getId())) {
			sb.append(" and user.id=:userid");
			paramMap.put("userid", blog.getUser().getId());
		}
		if(StringUtils.hasText(blog.getStatus())) {
			sb.append(" and status=:status");
			paramMap.put("status", blog.getStatus());
		}
		sb.append(" order by createTime");
		return (List<Blog>)this.query(sb.toString(), paramMap);
	}

	@Override
	public Page getBlogPage(Blog blog, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from Blog where 1=1 ");
		Map paramMap = new HashMap();
		if(blog.getUser()!=null && StringUtils.hasText(blog.getUser().getId())) {
			sb.append(" and user.id=:userid");
			paramMap.put("userid", blog.getUser().getId());
		}
		if(StringUtils.hasText(blog.getStatus())) {
			sb.append(" and status=:status");
			paramMap.put("status", blog.getStatus());
		}
		sb.append(" order by createTime");
		return this.pagedQuery(sb.toString(), paramMap, pageSize, pageNo);
	}

}
