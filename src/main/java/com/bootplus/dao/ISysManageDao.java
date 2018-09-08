package com.bootplus.dao;

import java.util.Date;
import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.model.SysConfig;
import com.bootplus.model.Views;

public interface ISysManageDao extends IBaseDao{
	public List<SysConfig> querySysConfigList();
	public List<SysConfig> querySysConfigListByKey(String key);
	public SysConfig querySysConfigByKey(String key);
	public void updateViewCount(String date);
	public Views getViewCount(String date);
}
