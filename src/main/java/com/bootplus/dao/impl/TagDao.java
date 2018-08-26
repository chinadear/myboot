package com.bootplus.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootplus.Util.Constants;
import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.ITagDao;
import com.bootplus.dao.IUserDao;
import com.bootplus.model.Blog;
import com.bootplus.model.Tag;
import com.bootplus.model.TagBlog;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;

@Repository
public class TagDao extends BaseDaoImpl implements ITagDao {

	@Override
	public Tag getTagByName(String name) {
		// TODO Auto-generated method stub
		return (Tag)this.queryUnique("from Tag where name=?", name);
	}

	@Override
	public List queryTagBlogList(TagBlog tagBlog) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from TagBlog where 1=1 ");
		Map paramMap = new HashMap();
		if(tagBlog.getBlog()!=null && StringUtils.hasText(tagBlog.getBlog().getId())) {
			sb.append(" and blog.id=:blogid");
			paramMap.put("blogid", tagBlog.getBlog().getId());
		}
		if(tagBlog.getTag()!=null && StringUtils.hasText(tagBlog.getTag().getId())) {
			sb.append(" and tag.id=:tagid");
			sb.append("and blog.status='1'");
			paramMap.put("tagid", tagBlog.getTag().getId());
		}
		sb.append(" order by createTime");
		return (List<Blog>)this.query(sb.toString(), paramMap);
	}

	@Override
	public Page queryTagBlogPage(TagBlog tagBlog, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from TagBlog where 1=1 ");
		Map paramMap = new HashMap();
		if(tagBlog.getBlog()!=null && StringUtils.hasText(tagBlog.getBlog().getId())) {
			sb.append(" and blog.id=:blogid");
			paramMap.put("blogid", tagBlog.getBlog().getId());
		}
		if(tagBlog.getTag()!=null && StringUtils.hasText(tagBlog.getTag().getId())) {
			sb.append(" and tag.id=:tagid");
			sb.append("and blog.status='1'");
			paramMap.put("tagid", tagBlog.getTag().getId());
		}
		sb.append(" order by createTime");
		return this.pagedQuery(sb.toString(), paramMap, pageSize, pageNo);
	}

}
