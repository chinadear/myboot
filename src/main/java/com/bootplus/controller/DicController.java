package com.bootplus.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootplus.Util.Constants;
import com.bootplus.core.base.BaseController;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Dic;
import com.bootplus.model.Role;
import com.bootplus.service.IDicService;
/**
 * 字典管理
 * 物理删除，仅用于选择不用于代码植入，选择进引用其code的编码，不与字典对象关联
 * @author liulu
 *
 */
@Controller
public class DicController extends BaseController {
	@Autowired 
	private IDicService dicService;
	//页面目录根地址
	private static final String RESOURCE_MENU_PREFIX="/member/dic";
	/**
	 * 字典管理页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/dic/list")
	public String dicList(Model model, HttpServletRequest request) {
		List<Dic> list=dicService.queryDicList(new Dic());
		Page page=dicService.queryDicPage(new Dic(), 1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/listDic";
	}
	/**
	 * 翻页加载
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/dic/noSitemesh/loadDictable")
	public String load(Model model, HttpServletRequest request,String pageNo,String name) {
		Dic dic=new Dic();
		if(StringUtils.hasText(name)) {
			dic.setName(name);
		}
		Page page=dicService.queryDicPage(dic,StringUtils.hasText(pageNo)?Integer.valueOf(pageNo):1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/tableDic";
	}
	/**
	 * 提交新增
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/dic/add")
	public String add(Model model, Dic dic) {
		dicService.save(dic);
		return "redirect:/dic/list";
	}
	/**
	 * 进入编辑页面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/dic/noSitemesh/editDic")
	public String editDic(Model model,String id) {
		Dic d=dicService.getDicById(id);
		model.addAttribute("dic",d);
		return RESOURCE_MENU_PREFIX+"/editDic";
	}
	/**
	 * 提交修改
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dic/edit",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String edit(Model model,String id,String name,String code,String comments,String status) {
		Dic d=dicService.getDicById(id);
		d.setCode(code);
		d.setName(name);
		d.setStatus(status);
		d.setComments(comments);
		dicService.update(d);
		return "t";
	}
	/**
	 * 删除字典
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dic/delete",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String deletedic(String id){
		Dic d=dicService.getDicById(id);
		dicService.deleteDic(d);
		return "T";
	}
	/**
	 * 更改锁定状态
	 * 由于字典比较重要，防止误删除，因此平时就把删除编辑按钮屏蔽，处于锁定状态，锁定状态不影响使用
	 * 锁定唯一一个作用就是 屏蔽操作按钮，防止误操作
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dic/updateStatus",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String updateStatus(String id,String status){
		Dic d=dicService.getDicById(id);
		d.setStatus(status);
		dicService.update(d);
		return status;
	}
	/** 
	 * 	字典名称重复校验
	 * @param name
	 * @param parent
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/dic/isExsit/name",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String isExistMenuName(String name,String id){
		String flag="true";
		Dic dic = new Dic();
		if(!StringUtils.hasText(id)){//新增
			dic.setName(name);
			List<Dic> dlist=dicService.queryDicList(dic);
			if(dlist.size()>0) {
				flag="false";
			}
		}else {//编辑
			dic.setName(name);
			List<Dic> dlist=dicService.queryDicList(dic);
			if(dlist.size()<2) {
				if(dlist.size()==1) {
					if(dlist.get(0).getId().equals(id)) {
						flag="true";
					}else {
						flag="false";
					}
				}
			}else {
				flag="false";
			}
		}
		return flag;
	}
	/**
	 * 字典code是否重复
	 * @param code
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/dic/isExsit/code",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String isExistDicCode(String code,String id){
		String flag="true";
		Dic dic = new Dic();
		if(!StringUtils.hasText(id)){//新增
			dic.setCode(code);
			List<Dic> dlist=dicService.queryDicList(dic);
			if(dlist.size()>0) {
				flag="false";
			}
		}else {//编辑
			dic.setCode(code);
			List<Dic> dlist=dicService.queryDicList(dic);
			if(dlist.size()<2) {
				if(dlist.size()==1) {
					if(dlist.get(0).getId().equals(id)) {
						flag="true";
					}else {
						flag="false";
					}
				}
			}else {
				flag="false";
			}
		}
		return flag;
	}
}
