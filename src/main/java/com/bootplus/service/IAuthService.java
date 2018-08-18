package com.bootplus.service;

import java.util.List;

import com.bootplus.core.dao.page.Page;
import com.bootplus.model.ResRole;
import com.bootplus.model.Role;
import com.bootplus.model.UserRole;

public interface IAuthService {
	public List<UserRole> queryUserRoleList(UserRole ur);
	/**
	 * 剔除该角色下分配的全部用户
	 * @param id
	 */
	public void deleteUserRolesByRoleId(String id);
	/**
	 * 剔除该用户下分配的全部角色
	 * @param id
	 */
	public void deleteUserRolesByUserId(String id);
	
	public void saveUserRoles(List<UserRole> list);
	
	public void saveUserRole(UserRole ur);
	
	public List<ResRole> queryResRoleList(ResRole rr);
	/**
	 * 剔除该角色下全部关联的菜单
	 * @param id
	 */
	public void deleteResRolesByRoleId(String id);
	
	public void saveResRoles(List<ResRole> list);
	
	

}
