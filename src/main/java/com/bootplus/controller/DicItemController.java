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
import com.bootplus.model.DicItem;
import com.bootplus.model.Role;
import com.bootplus.service.IDicService;
/**
 * 字典项管理
 * 物理删除，仅用于选择不用于代码植入，选择进引用其code的编码，不与字典对象关联
 * @author liulu
 *
 */
@Controller
public class DicItemController extends BaseController {
	@Autowired 
	private IDicService dicService;
	//页面目录根地址
	private static final String RESOURCE_MENU_PREFIX="/member/dic/item";
	/**
	 * 字典项管理页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/dicitem/list")
	public String dicList(Model model, HttpServletRequest request,String id) {
		Dic dic=dicService.getDicById(id);
		DicItem di=new DicItem();
		di.setDic(dic);
		List<DicItem> list=dicService.queryDicItemListInDic(di);
		Page page=dicService.queryDicitemPage(di, 1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("dic",dic);
		return RESOURCE_MENU_PREFIX+"/listDicitem";
	}
	/**
	 * 翻页加载
	 * @param model
	 * @param request
	 * dicId
	 * @return
	 */
	@RequestMapping("/dicitem/noSitemesh/loadDictable")
	public String load(Model model, HttpServletRequest request,String pageNo,String name,String dicId) {
		Dic dic=new Dic();
		dic.setId(dicId);
		DicItem di=new DicItem();
		di.setDic(dic);
		if(StringUtils.hasText(name)) {
			di.setName(name);
		}
		Page page=dicService.queryDicitemPage(di,StringUtils.hasText(pageNo)?Integer.valueOf(pageNo):1, Page.DEFAULT_PAGE_SIZE);
		model.addAttribute("page", page);
		return RESOURCE_MENU_PREFIX+"/tableDicitem";
	}
	/**
	 * 提交新增
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/dicitem/add")
	public String add(Model model, DicItem di) {
		dicService.save(di);
		return "redirect:/dicitem/list?id="+di.getDic().getId();
	}
	/**
	 * 进入编辑页面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/dicitem/noSitemesh/editDic")
	public String editDic(Model model,String id) {
		DicItem di=dicService.getDicItemById(id);
		model.addAttribute("di",di);
		return RESOURCE_MENU_PREFIX+"/editDicitem";
	}
	/**
	 * 提交修改
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dicitem/edit",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String edit(Model model,String id,String name,String code,String comments,String status) {
		DicItem d=dicService.getDicItemById(id);
		d.setCode(code);
		d.setName(name);
		d.setStatus(status);
		d.setComments(comments);
		dicService.update(d);
		return "t";
	}
	/**
	 * 删除字典项
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dicitem/delete",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String deletedic(String id){
		DicItem di=dicService.getDicItemById(id);
		dicService.deleteDicItem(di);
		return "T";
	}
	/**
	 * 更改发布状态
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dicitem/updateStatus",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String updateStatus(String id,String status){
		DicItem di=dicService.getDicItemById(id);
		di.setStatus(status);
		dicService.update(di);
		return status;
	}
	/** 
	 * 	字典项名称重复校验
	 * @param name
	 * @param parent
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/dicitem/isExsit/name",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String isExistMenuName(String name,String id,String dicId){
		String flag="true";
		Dic dic=new Dic();
		dic.setId(dicId);		
		DicItem di = new DicItem();
		di.setDic(dic);
		if(!StringUtils.hasText(id)){//新增
			di.setName(name);
			List<DicItem> dlist=dicService.queryDicItemListInDic(di);
			if(dlist.size()>0) {
				flag="false";
			}
		}else {//编辑
			di.setName(name);
			List<DicItem> dlist=dicService.queryDicItemListInDic(di);
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
	 * 字典项code是否重复
	 * @param code
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/dicitem/isExsit/code",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String isExistDicCode(String code,String id,String dicId){
		String flag="true";
		Dic dic=new Dic();
		dic.setId(dicId);		
		DicItem di = new DicItem();
		di.setDic(dic);
		if(!StringUtils.hasText(id)){//新增
			di.setCode(code);
			List<DicItem> dlist=dicService.queryDicItemListInDic(di);
			if(dlist.size()>0) {
				flag="false";
			}
		}else {//编辑
			di.setCode(code);
			List<DicItem> dlist=dicService.queryDicItemListInDic(di);
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
