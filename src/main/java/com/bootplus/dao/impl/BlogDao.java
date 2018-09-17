package com.bootplus.dao.impl;

import java.util.ArrayList;
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
import com.bootplus.model.LeaveMsg;
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
		if(StringUtils.hasText(blog.getCateId())) {
			sb.append(" and category.id=:cateid");
			paramMap.put("cateid", blog.getCateId());
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
		if(StringUtils.hasText(blog.getCateId())) {
			sb.append(" and category.id=:cateid");
			paramMap.put("cateid", blog.getCateId());
		}
		if(StringUtils.hasText(blog.getPlate())) {
			sb.append(" and plate=:plate");
			paramMap.put("plate", blog.getPlate());
		}
		if(blog.getViewNum()>0) {//如果传过来浏览量任意值，那么代表要使用浏览量进行排序
			sb.append(" order by viewNum DESC");
		}else {
			sb.append(" order by createTime DESC");
		}
		return this.pagedQuery(sb.toString(), paramMap, pageSize, pageNo);
	}

	@Override
	public void disabledAllDiscuss() {
		// TODO Auto-generated method stub
		this.executeHql("update Blog set discuss='0'");
	}

	@Override
	public void enabledAllDiscuss() {
		// TODO Auto-generated method stub
		this.executeHql("update Blog set discuss='1'");
	}

	@Override
	public void updateViewNum(String articalId) {
		// TODO Auto-generated method stub
		this.executeHql("update Blog set viewNum=viewNum+1 where id=?",articalId);
	}

	@Override
	public Page getBlogSearchPage(List words, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from Blog where status='1' ");
//		Map paramMap = new HashMap();
		List<String> paramMap=new ArrayList<String>();
		if(words.size()>0) {
			for(int i=0;i<words.size();i++) {
				if(i==0) {
					sb.append(" and title like ?");
					paramMap.add("%"+words.get(i)+"%");
				}else {
					sb.append(" or title like ?");
					paramMap.add("%"+words.get(i)+"%");
				}
			}
		}else {
			sb.append(" and 1!=1");
		}
		sb.append(" order by createTime DESC");
		return this.pagedQuery(sb.toString(), pageNo, pageSize, paramMap.toArray());
	}

	@Override
	public Page queryLeaveMsgPage(LeaveMsg lm, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return this.pagedQuery("from LeaveMsg order by createTime DESC", pageNo, pageSize);
	}
	
}
