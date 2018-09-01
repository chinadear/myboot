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
	 * @param type type=0图片降低画质（画质由系统配置中设置）
	 * 		       type=1图片缩放（宽高自定义)
	 * 			   type=2等比缩小，宽高取一个进行等比缩放
	 * 			   type=3附件
	 * @param width：按照宽度等比缩放，前提type=2,传入width，高度传入0
	 * @param height:按高度等比缩放，前提type=2，传入height,宽度传入0
	 * @param request
	 * @return
	 */
	public UFile uploadFile(MultipartFile file,String type,int width,int height,HttpServletRequest request);
	
	public UFile getUploadFileById(String id);
}
