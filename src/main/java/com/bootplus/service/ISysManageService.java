package com.bootplus.service;

import java.util.List;

import com.bootplus.model.SysConfig;

public interface ISysManageService {

	public void saveSysConfig(SysConfig sc);
	/**
	 * 物理删除
	 * @param id
	 */
	public void delSysConfig(String id);
	
	public SysConfig getSysConfigById(String id);
	
	public void updateSysConfig(SysConfig sc);
	
	public List<SysConfig> querySysConfigList();
	
	public List<SysConfig> querySysConfigListByKey(String key);
}
