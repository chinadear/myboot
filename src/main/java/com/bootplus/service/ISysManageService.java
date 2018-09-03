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
	 * @param type type=0附件
	 * 			   type=1自动-图片降低画质（画质由系统配置中设置）param=null
	 * 			   type=2自定义画质-（0-1）param=0-1
	 * 		       type=3自定义宽高-图片缩放（宽高自定义)param="width:height"
	 * 			   type=4以宽度为基准-等比缩小param=widht
	 * 			   type=5以高度为基准-等比缩小param=height
	 * @param param：
	 * @param request
	 * @return
	 */
	public UFile uploadFile(MultipartFile file,String type,String param,HttpServletRequest request);
	
	public UFile getUploadFileById(String id);
}
