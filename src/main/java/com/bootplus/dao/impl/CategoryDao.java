package com.bootplus.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.ICategoryDao;
import com.bootplus.model.Blog;
import com.bootplus.model.Category;

@Repository
public class CategoryDao extends BaseDaoImpl implements ICategoryDao {

	@Override
	public List<Category> queryCategoryList(Category cate) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from Category where status='1' ");//逻辑删除标志
		Map paramMap = new HashMap();
		if(StringUtils.hasText(cate.getType())) {
			sb.append(" and type=:type");
			paramMap.put("type", cate.getType());
		}
		sb.append(" order by createTime");
		return (List<Category>)this.query(sb.toString(), paramMap);
	}

	@Override
	public Page queryCategoryPage(Category cate, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return this.pagedQuery("from Category where status='1' order by createTime", pageNo, pageSize);
	}

	@Override
	public List<Category> getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return (List<Category>)this.query("from Category where status='1' and name=? order by createTime",name);
	}

}
