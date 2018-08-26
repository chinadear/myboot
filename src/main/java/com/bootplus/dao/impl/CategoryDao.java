package com.bootplus.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;
import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.ICategoryDao;
import com.bootplus.model.Category;

@Repository
public class CategoryDao extends BaseDaoImpl implements ICategoryDao {

	@Override
	public List<Category> queryCategoryList() {
		// TODO Auto-generated method stub
		return (List<Category>)this.query("from Category where status='1' order by createTime");
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
