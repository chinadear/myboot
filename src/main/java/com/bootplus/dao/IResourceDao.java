package com.bootplus.dao;

import java.util.List;
import com.bootplus.core.dao.IBaseDao;
import com.bootplus.model.Resource;

public interface IResourceDao<T> extends IBaseDao{

	public List<Resource> queryResourceList(Resource resource);
	public List<Resource> getResourcesByParent(Resource parent);
	public Resource getResourceById(String id);
	public List<Resource> getResourcesByParentAndName(Resource parent, Resource resource);
	public List<Resource> getResourcesByCode(String code);
	public List<Resource> getResources(Resource resource);
	public void updateResourceStatus(List<Resource> resourceList, Resource resource);
}
