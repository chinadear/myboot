package com.bootplus.dao;

import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Category;

public interface ICategoryDao<T> extends IBaseDao{

	public List<Category> queryCategoryList();
	public List<Category> getCategoryByName(String name);
	public Page queryCategoryPage(Category cate, int pageNo, int pageSize);
}
