package com.bootplus.dao;

import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.model.Role;

public interface IRoleDao extends IBaseDao{

	public List<Role> queryRoleList(Role role);
}
