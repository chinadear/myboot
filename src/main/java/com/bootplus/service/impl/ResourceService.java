package com.bootplus.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.Util.Constants;
import com.bootplus.core.base.BaseServiceImpl;
import com.bootplus.dao.IAuthDao;
import com.bootplus.dao.IResourceDao;
import com.bootplus.dao.IUserDao;
import com.bootplus.model.ResRole;
import com.bootplus.model.Resource;
import com.bootplus.model.User;
import com.bootplus.model.UserRole;
import com.bootplus.service.IResourceService;

/**
 * 	@EnableCaching 启用缓存配置
	@Cacheable 指定某个方法的返回值是可以缓存的。在注解属性中指定缓存规则。
		参数：value、cacheNames：两个等同的参数
		key:#p0表示第一个参数，或者用#+第一个参数名与#p0等同，要使用SpEL表达式#fx.id
		condition：condition="#name.length() < 32"
		unless="#result.hardback"
	@Cacheput 将方法的返回值缓存到指定的key中
	@CacheEvict 删除指定的缓存数据
		参数：与@cacheable相同，多出2个参数：
		allEntries：非必需，默认为false。当为true时，会移除所有数据
		beforeInvocation：非必需，默认为false，会在调用方法之后移除数据。当为true时，会在调用
	@Cacheable和@Cacheput都会将方法的执行结果按指定的key放到缓存中，
	@Cacheable在执行时，会先检测缓存中是否有数据存在，如果有，直接从缓存中读取。
	如果没有，执行方法，将返回值放入缓存，而@Cacheput会先执行方法，然后再将执行结果写入缓存。
	使用@Cacheput的方法一定会执行
 * @author liulu
 *
 */
@Service
@Transactional
public class ResourceService extends BaseServiceImpl implements IResourceService {

	@Autowired
	private IResourceDao resourceDao;
	@Autowired
	private IAuthDao authDao;
	@Autowired
	private IUserDao userDao;
	@Override
	public void save(Resource res) {
		// TODO Auto-generated method stub
		resourceDao.save(res);
	}

	@Override
	public List<Resource> queryResourceList(Resource resource) {
		// TODO Auto-generated method stub
		return resourceDao.queryResourceList(resource);
	}
	//根据父节点获取子节点
	@Override
	public List<Resource> getResourcesByParent(Resource parent) {
		return resourceDao.getResourcesByParent(parent);
	}
	//根据id获取资源
	@Override
	public Resource getResourceById(String id) {
		//是否无效状态不返回？待修改
		return resourceDao.getResourceById(id);
	}
	//根据父节点递归删除子节点
	public void deleteResourcesByParent(Resource parent) {
		List<Resource> deleteList = new ArrayList();
		Resource resource = new Resource();
		resource.setType(null);
		List<Resource> allResourceList = resourceDao.getResources(resource);
		Resource p = resourceDao.getResourceById(parent.getId());
		deleteList.add(p);
		List<Resource> parentList = new ArrayList();
		parentList.add(p);
		//循环遍历需要删除的资源
		while (parentList != null && parentList.size() > 0) {
			List<Resource> tempList = new ArrayList<Resource>();
			for (Resource p2 : parentList) {
				for (Resource child : allResourceList) {
					if (child.getParent() != null && p2.getId().equals(child.getParent().getId())) {
						tempList.add(child);
						deleteList.add(child);
					}
				}
			}
			parentList = tempList;
		}
		if (deleteList.size() > 0) {
			Resource r = new Resource();
			r.setStatus(Constants.SYSTEM_DIC_DELETE_STATUS);//0删除，1正常
			resourceDao.updateResourceStatus(deleteList, r);
		}
		
	}
	//查询父节点下是否含有指定名称的资源
	@Override
	public boolean isExistByParentAndName(Resource parent, String name, String id) {
		Resource resource = new Resource();
		resource.setName(name);
		List<Resource> list = resourceDao.getResourcesByParentAndName(parent, resource);
		boolean b = false;
		if (list != null && list.size() > 0) {
			for (Resource res : list) {
				if (!res.getId().equals(id)) {
					b = true;
				}
			}
		}
		return b;
	}
	@Override
	public boolean isExistMenuByCode(String code,String id) {
		// TODO Auto-generated method stub
		List<Resource> list = resourceDao.getResourcesByCode(code);
		boolean b = false;
		if(list!=null && list.size()>0){
			for (Resource res : list) {
				if (!res.getId().equals(id)) {
					b = true;
				}
			}
		}
		return b;
	}
	
	@Override
	public void update(Resource res) {
		// TODO Auto-generated method stub
		resourceDao.update(res);
	}

	@Override
	public void swapSeqNum(Resource source, Resource target) {
		// TODO Auto-generated method stub
		int temp = target.getSeqNum();
		target.setSeqNum(source.getSeqNum());
		source.setSeqNum(temp);
		this.update(source);
		this.update(target);
	}

	@Override
	public Map<String, Boolean> getOwnMenusMap(String userId) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(userId);
		UserRole ur=new UserRole();
		ur.setUser(user);
		List<UserRole> urlist=authDao.queryUserRoleList(ur);
		if(urlist.size()>0) {//有角色
			ResRole rr=new ResRole();
			rr.setRole(urlist.get(0).getRole());
			List<ResRole> rrlist=authDao.queryResRoleList(rr);//角色权限
			return getOwnMenu2Map(rrlist);
		}else {//没有角色
			return new HashMap<String, Boolean>();
		}
	}

	/**
	 * 获取sidebar的菜单，需要遍历子菜单，渲染出菜单结构
	 * 包含了childList
	 */
	@Override
	public Resource getSidebarMenu(String userId) {
		// TODO Auto-generated method stub
		List<Resource> list = resourceDao.getResourcesByCode(Constants.ROOT_MENU_BOOT_CODE);
		if(list.size()==0) {//没有菜单
			return new Resource();
		}else {//有菜单
			User user=(User)userDao.get(User.class, userId);
			if(Constants.SYSTEM_DIC_USERTYPE_ADMIN.equals(user.getUserType())) {
				return iterationResource(list.get(0));//系统管理员看全部
			}else {//普通用户
				UserRole ur=new UserRole();
				ur.setUser(user);
				List<UserRole> urlist=authDao.queryUserRoleList(ur);
				if(urlist.size()>0) {
					ResRole rr=new ResRole();
					rr.setRole(urlist.get(0).getRole());
					List<ResRole> rrlist=authDao.queryResRoleList(rr);
					Map<String,Boolean> map=list2Map(rrlist);
					return iterationResource(list.get(0), map);
				}else {
					return new Resource();
				}
			}
		}
	}
	//迭代全部
	public Resource iterationResource(Resource parent){
		List<Resource> childList=this.getResourcesByParent(parent);
		parent.setChildList(childList);
		if(childList.size()>0) {
			for(Resource r:childList) {
				iterationResource(r);
			}
		}
		return parent;
	}
	//代权限迭代
	public Resource iterationResource(Resource parent,Map<String,Boolean> map){
		List<Resource> childList=this.getResourcesByParent(parent);
		List<Resource> childtemp= new ArrayList<Resource>();
		for(Resource res:childList) {
			if(map.get(res.getId())!=null &&map.get(res.getId())) {
				childtemp.add(res);
			}
		}
		parent.setChildList(childtemp);
		if(childtemp.size()>0) {
			for(Resource r:childtemp) {
				iterationResource(r,map);
			}
		}
		return parent;
	}
	/**
	 * list 转 map
	 * @param list
	 * @return
	 */
	public Map<String,Boolean> list2Map(List<ResRole> list){
		Map<String,Boolean> map=new HashMap<String,Boolean>();
		for(ResRole rr:list) {
			map.put(rr.getResource().getId(),true);
		}
		return map;
	}
	public Map<String,Boolean> getOwnMenu2Map(List<ResRole> list){
		Map<String,Boolean> map=new HashMap<String,Boolean>();
		for(ResRole rr:list) {
			map.put(rr.getResource().getCode().toUpperCase(),true);//key 均采用小写
		}
		return map;
	}
}
