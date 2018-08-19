package com.bootplus.dao;

import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Role;

public interface IRoleDao extends IBaseDao{

	public List<Role> queryRoleList(Role role);
	public Page queryRolePage(Role role, int pageNo, int pageSize);
	public Role findRoleByCode(String code);
}
