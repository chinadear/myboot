package com.bootplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.core.base.BaseServiceImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.ICategoryDao;
import com.bootplus.dao.IRoleDao;
import com.bootplus.model.Category;
import com.bootplus.model.Role;
import com.bootplus.service.ICategoryService;
import com.bootplus.service.IRoleService;

@Service
@Transactional
public class CategoryService extends BaseServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;

	@Override
	public List<Category> queryCategoryList() {
		// TODO Auto-generated method stub
		return categoryDao.queryCategoryList();
	}

	@Override
	public Page queryCategoryPage(Category cate, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return categoryDao.queryCategoryPage(cate, pageNo, pageSize);
	}

	@Override
	public void save(Category cate) {
		// TODO Auto-generated method stub
		categoryDao.save(cate);
	}

	@Override
	public void update(Category cate) {
		// TODO Auto-generated method stub
		categoryDao.update(cate);
	}

	@Override
	public Category getCategoryById(String id) {
		// TODO Auto-generated method stub
		return (Category)categoryDao.get(Category.class, id);
	}

	@Override
	public List<Category> getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryByName(name);
	}

}
