package com.bootplus.dao;

import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.model.SysConfig;

public interface ISysManageDao extends IBaseDao{
	public List<SysConfig> querySysConfigList();
	public List<SysConfig> querySysConfigListByKey(String key);
}
