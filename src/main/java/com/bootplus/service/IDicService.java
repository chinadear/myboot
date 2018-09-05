package com.bootplus.service;

import java.util.List;

import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Dic;
import com.bootplus.model.DicItem;

public interface IDicService {
	public Page queryDicPage(Dic dic,int pageNo, int pageSize);
	
	public List<Dic> queryDicList(Dic dic);
	/**
	 * 查询字典下的字典项
	 * @param di
	 * @return
	 */
	public List<DicItem> queryDicItemListInDic(DicItem di);
	public void save(Dic dic);
	public void save(DicItem di);
	public void update(Dic dic);
	public void update(DicItem di);
	public Dic getDicById(String id);
	public DicItem getDicItemById(String id);
	public void deleteDic(Dic dic);
	public void deleteDicItem(DicItem di);
	public Dic getDicByCode(Dic dic);
	public DicItem getDicItemByCode(DicItem di);
}
