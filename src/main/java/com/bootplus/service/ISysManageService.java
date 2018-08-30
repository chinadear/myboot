package com.bootplus.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.bootplus.model.UFile;
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
	
	public SysConfig querySysConfigByKey(String key);
	/**
	 * 上传附件，返回附件ID
	 * @param file
	 * @param type type=1系统附件，=0博客图片
	 * @return
	 */
	public UFile uploadFile(MultipartFile file,String type,HttpServletRequest request);
	
	public UFile getUploadFileById(String id);
}
