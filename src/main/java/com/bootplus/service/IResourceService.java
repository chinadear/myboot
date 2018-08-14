package com.bootplus.service;

import java.util.List;

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
	public Resource getSidebarMenu();
	public void update(Resource res);
	//交换资源序号
	public void swapSeqNum(Resource source,Resource target);
}
