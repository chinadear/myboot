package com.bootplus.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootplus.Util.Constants;
import com.bootplus.core.base.BaseController;
import com.bootplus.model.SysConfig;
import com.bootplus.service.ISysManageService;
/**
 * 系统管理
 * @author liulu
 * 规则：
 * 1.key增加后不可修改，只可修改value
 * 2.删除配置要加保护，不能随便删除，打开保护，启用删除功能
 * 
 */
@Controller
public class SysManageController extends BaseController {
	
	private final static String RESOURCE_MENU_PREFIX="/member/sysmanage";
	@Autowired
	private ISysManageService sysManageService;
	@RequestMapping("/system/config")
	public String configList(Model model, HttpServletRequest request) {
		List<SysConfig> conflist=sysManageService.querySysConfigList();
		model.addAttribute("configList", conflist);
		return RESOURCE_MENU_PREFIX+"/sysconfig";
	}
	/**
	 * 增加
	 * @param model
	 * @param config_key
	 * @param config_value
	 * @param config_comment
	 * @return
	 */
	@RequestMapping("/system/config/add")
	public String addConfig(Model model,String config_key,String config_value,String config_comment) {
		SysConfig sc=new SysConfig();
		sc.setKey(config_key);
		sc.setValue(config_value);
		sc.setComments(config_comment);
		sc.setStatus(Constants.SYSTEM_DIC_NORMAL_STATUS);
		sc.setUpdateTime(new Date());
		sc.setCreateTime(new Date());
		sysManageService.saveSysConfig(sc);
		return "redirect:/system/config";
	}
	/**
	 * 删除（逻辑删除）
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/system/config/delete/{id}")
	public String configList(Model model, HttpServletRequest request,@PathVariable String id) {
		SysConfig sc=sysManageService.getSysConfigById(id);
		sc.setStatus(Constants.SYSTEM_DIC_DELETE_STATUS);
		sysManageService.updateSysConfig(sc);
		return "redirect:/system/config";
	}
	/**
	 * 初始化编辑页面
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/noSitemesh/system/config/initEdit")
	public String initEdit(Model model, HttpServletRequest request,String id) {
		SysConfig sc=sysManageService.getSysConfigById(id);
		model.addAttribute("sysconfig", sc);
		return RESOURCE_MENU_PREFIX+"/editConfiginnerPage";
	}
	/**
	 * 提交修改
	 * @param model
	 * @param sysconfig_id
	 * @param config_value_
	 * @param config_comment_
	 * @return
	 */
	@RequestMapping("/system/config/edit")
	public String editConfig(Model model,String sysconfig_id,String config_value_,String config_comment_) {
		SysConfig sc=sysManageService.getSysConfigById(sysconfig_id);
		sc.setValue(config_value_);
		sc.setComments(config_comment_);
		sc.setUpdateTime(new Date());
		sysManageService.updateSysConfig(sc);
		return "redirect:/system/config";
	}
	/**
	 * 校验key是否重复
	 * @param key
	 * @return
	 */
	@RequestMapping(value="/system/config/judgyKey",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String judgyKey(String key) {
		String flag="true";
		List<SysConfig> clist=sysManageService.querySysConfigListByKey(key);
		if(clist.size()>0) {
			flag="false";
		}
		return flag;
	}
}
