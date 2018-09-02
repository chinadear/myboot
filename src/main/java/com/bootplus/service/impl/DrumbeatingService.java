package com.bootplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.Util.Constants;
import com.bootplus.core.base.BaseServiceImpl;
import com.bootplus.dao.IDrumbeatingDao;
import com.bootplus.dto.StructModel;
import com.bootplus.model.Blog;
import com.bootplus.model.Category;
import com.bootplus.model.Drumbeating;
import com.bootplus.model.Tag;
import com.bootplus.model.TagBlog;
import com.bootplus.service.IBlogService;
import com.bootplus.service.ICategoryService;
import com.bootplus.service.IDrumbeatingService;
import com.bootplus.service.ITagService;

@Service
@Transactional
public class DrumbeatingService extends BaseServiceImpl implements IDrumbeatingService {

	@Autowired
	private IDrumbeatingDao drumbeatingDao;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private ITagService tagService;
	@Autowired
	private IBlogService blogService;
	
	@Override
	public List<Drumbeating> queryDrumbList(Drumbeating db) {
		// TODO Auto-generated method stub
		return drumbeatingDao.queryDrumbList(db);
	}

	@Override
	public void save(Drumbeating db) {
		// TODO Auto-generated method stub
		drumbeatingDao.save(db);
	}

	@Override
	public void delete(Drumbeating db) {
		// TODO Auto-generated method stub
		drumbeatingDao.delete(db);
	}

	@Override
	public void update(Drumbeating db) {
		// TODO Auto-generated method stub
		drumbeatingDao.update(db);
	}

	@Override
	public Drumbeating getDrumbeatingById(String id) {
		// TODO Auto-generated method stub
		return (Drumbeating)drumbeatingDao.get(Drumbeating.class, id);
	}

	@Override
	public StructModel getStructModel() {
		// TODO Auto-generated method stub
		Drumbeating db=new Drumbeating();
		db.setStatus("1");
		db.setType("0");
		List<Drumbeating> banner=drumbeatingDao.queryDrumbList(db);
		db.setType("1");
		List<Drumbeating> rightdrum=drumbeatingDao.queryDrumbList(db);
		StructModel sm=new StructModel();
		sm.setBanner(banner.size()>0?banner.get(0):null);
		sm.setRightdrum(rightdrum);
		Blog blog=new Blog();
		blog.setViewNum(2);
		blog.setStatus("1");
		List<Blog> hot=(List<Blog>)blogService.getBlogPage(blog, 1, 10).getResult();
		sm.setHot(hot);
		List<Tag> tag=(List<Tag>)tagService.queryTagPage(new Tag(), 1, 10).getResult();
		sm.setTag(tag);
		Category c=new Category();
		c.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		List<Category> cate=(List<Category>)categoryService.queryCategoryPage(c, 1, 10).getResult();
		sm.setCate(cate);
		return sm;
	}
}
