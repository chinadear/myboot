package com.bootplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.bootplus.core.base.BaseServiceImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.IDicDao;
import com.bootplus.model.Dic;
import com.bootplus.model.DicItem;
import com.bootplus.model.Tag;
import com.bootplus.model.TagBlog;
import com.bootplus.service.IDicService;
import com.bootplus.service.ITagService;

@Service
@Transactional
public class DicService extends BaseServiceImpl implements IDicService {
	@Autowired
	private IDicDao dicDao;

	@Override
	public Page queryDicPage(Dic dic, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dicDao.queryDicPage(dic, pageNo, pageSize);
	}

	@Override
	public List<Dic> queryDicList(Dic dic) {
		// TODO Auto-generated method stub
		return dicDao.queryDicList(dic);
	}

	@Override
	public List<DicItem> queryDicItemListInDic(DicItem di) {
		// TODO Auto-generated method stub
		return dicDao.queryDicItemListInDic(di);
	}

	@Override
	public void save(Dic dic) {
		// TODO Auto-generated method stub
		dicDao.save(dic);
	}

	@Override
	public void save(DicItem di) {
		// TODO Auto-generated method stub
		dicDao.save(di);
	}

	@Override
	public void update(Dic dic) {
		// TODO Auto-generated method stub
		dicDao.update(dic);
	}

	@Override
	public void update(DicItem di) {
		// TODO Auto-generated method stub
		dicDao.update(di);
	}

	@Override
	public Dic getDicById(String id) {
		// TODO Auto-generated method stub
		return (Dic)dicDao.get(Dic.class, id);
	}

	@Override
	public DicItem getDicItemById(String id) {
		// TODO Auto-generated method stub
		return (DicItem)dicDao.get(DicItem.class, id);
	}

	@Override
	public void deleteDic(Dic dic) {
		// TODO Auto-generated method stub
		dicDao.delete(dic);
	}

	@Override
	public void deleteDicItem(DicItem di) {
		// TODO Auto-generated method stub
		dicDao.delete(di);
	}

	@Override
	public Dic getDicByCode(Dic dic) {
		// TODO Auto-generated method stub
		List<Dic> l=dicDao.queryDicList(dic);
		return l.size()>0?l.get(0):null;
	}

	@Override
	public DicItem getDicItemByCode(DicItem di) {
		//必须查某个字典的字典项，不支持查全部字典项，无意义
		List<DicItem> l=new ArrayList<DicItem>();
		if(di.getDic()!=null && StringUtils.hasText(di.getDic().getId())) {
			l=dicDao.queryDicItemListInDic(di);
		}
		return l.size()>0?l.get(0):null;
	}

	@Override
	public Page queryDicitemPage(DicItem dicitem, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dicDao.queryDicitemPage(dicitem, pageNo, pageSize);
	}
	
}
