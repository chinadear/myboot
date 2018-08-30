package com.bootplus.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.dao.ISysManageDao;
import com.bootplus.model.SysConfig;
@Repository
public class SysManageDao extends BaseDaoImpl implements ISysManageDao {

	@Override
	public List<SysConfig> querySysConfigList() {
		// TODO Auto-generated method stub
		return (List<SysConfig>)this.query("from SysConfig where status='1' order by key");
	}

	@Override
	public List<SysConfig> querySysConfigListByKey(String key) {
		// TODO Auto-generated method stub
		return (List<SysConfig>)this.query("from SysConfig where status='1' and key=? order by key",key);
	}

	@Override
	public SysConfig querySysConfigByKey(String key) {
		// TODO Auto-generated method stub
		return (SysConfig)this.queryUnique("from SysConfig where status='1' and key=? ", key);
	}

}
