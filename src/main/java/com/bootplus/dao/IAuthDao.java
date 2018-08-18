package com.bootplus.dao;

import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.ResRole;
import com.bootplus.model.Role;
import com.bootplus.model.UserRole;

public interface IAuthDao extends IBaseDao{

	public List<UserRole> queryUserRoleList(UserRole ur);
	
	public void deleteUserRolesByRoleId(String id);
	
	public void deleteUserRolesByUserId(String id);
	
	public List<ResRole> queryResRoleList(ResRole rr);
	/**
	 * 剔除该角色下全部关联的菜单
	 * @param id
	 */
	public void deleteResRolesByRoleId(String id);
	
}
