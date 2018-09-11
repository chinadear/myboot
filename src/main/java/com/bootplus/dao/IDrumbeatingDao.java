package com.bootplus.dao;

import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Drumbeating;

public interface IDrumbeatingDao extends IBaseDao{

	public List<Drumbeating> queryDrumbList(Drumbeating db);
	public Page queryDrumbPage(Drumbeating db, int pageNo, int pageSize);
}
