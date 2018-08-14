package com.bootplus.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.dao.IResourceDao;
import com.bootplus.model.Resource;
/**
 * @date 2013-08-16
 * @author liulu
 *
 */
@Repository
public class ResourceDao extends BaseDaoImpl implements IResourceDao {
	@Override
	public List<Resource> queryResourceList(Resource resource) {
		return (List<Resource>)this.query("from Resource where status='1' order by seqNum asc");
	}
	//根据父节点获取子节点
	@Override
	public List<Resource> getResourcesByParent(Resource parent) {
		return (List<Resource>)this.query("from Resource where parent.id = ? and status ='1'  order by seqNum asc", parent.getId());
	}
	//根据id获取资源
	@Override
	public Resource getResourceById(String id) {
		return (Resource) this.get(Resource.class, id);
	}
	//查询父节点下是否含有指定名称的资源
	@Override
	public List<Resource> getResourcesByParentAndName(Resource parent, Resource resource) {
		return (List<Resource>)this.query("from Resource where parent.id = ? and name = ? and status = '1' ", parent.getId(), resource.getName()); 
	}
	//获取资源，参数code
	@Override
	public List<Resource> getResourcesByCode(String code) {
		return (List<Resource>)this.query("from Resource where code = ? and status = '1' order by createTime desc", code);
	}
	//获取资源，参数resource传入status和type,code
	@Override
	public List<Resource> getResources(Resource resource) {
			return (List<Resource>)this.query("from Resource where status = '1'  order by seqNum asc");
	}
	//批量更新资源状态
	public void updateResourceStatus(List rl, Resource resource) {
		// TODO Auto-generated method stub
		List<Resource> resourceList= (List<Resource>)rl;
		Map paramMap = new HashMap();
		String [] resIds = new String[resourceList.size()];
		for (int i = 0; i < resourceList.size(); i++) {
			resIds[i] = resourceList.get(i).getId();
		}
		paramMap.put("resIds", resIds);
		paramMap.put("statusId", resource.getStatus());
		this.executeHql("update  Resource set status = :statusId where id in (:resIds)", paramMap);
	}
	
}
