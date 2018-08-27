package com.bootplus.service;

import java.util.List;

import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Category;

public interface ICategoryService {

	public List<Category> queryCategoryList();
	
	public Page queryCategoryPage(Category cate, int pageNo, int pageSize);
	public void save(Category cate);
	public void update(Category cate);
	public Category getCategoryById(String id);
	public List<Category> getCategoryByName(String name);
	
	
}
