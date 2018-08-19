package com.bootplus.service;

import java.util.List;
import java.util.Map;

import com.bootplus.model.ResRole;
import com.bootplus.model.Resource;

public interface IResourceService {

	public void save(Resource res);
	public List<Resource> queryResourceList(Resource resource);
	public List<Resource> getResourcesByParent(Resource parent);
	/**
	 * 获取菜单 by 菜单id
	 * @param id
	 * @return
	 */
	public Resource getResourceById(String id);
	public boolean isExistByParentAndName(Resource parent, String name, String id);
	public boolean isExistMenuByCode(String code,String id);
	public void deleteResourcesByParent(Resource parent);
	/**
	 * 获取sidebar菜单，带权限过滤，通过用户权限过滤有权限的菜单
	 * @param userId
	 * @return
	 */
	public Resource getSidebarMenu(String userId);
	public void update(Resource res);
	//交换资源序号
	public void swapSeqNum(Resource source,Resource target);
	/**
	 * 获取用户有权限的菜单map，用于访问权限判定
	 * @param userId
	 * @return
	 */
	public Map<String,Boolean> getOwnMenusMap(String userId);
}
