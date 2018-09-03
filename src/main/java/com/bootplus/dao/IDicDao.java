package com.bootplus.dao;

import java.util.List;
import com.bootplus.core.dao.IBaseDao;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Dic;
import com.bootplus.model.DicItem;

public interface IDicDao extends IBaseDao{

	public Page queryDicPage(Dic dic,int pageNo, int pageSize);
	
	public List<Dic> queryDicList(Dic dic);
	/**
	 * 查询字典下的字典项
	 * @param di
	 * @return
	 */
	public List<DicItem> queryDicItemListInDic(DicItem di);
	
}
