package com.bootplus.service;

import java.util.List;

import com.bootplus.model.Role;

public interface IRoleService {

	public List<Role> queryRoleList(Role role);
	public void save(Role role);
	public void update(Role role);
	public void delete(Role role);
	public Role findRoleById(String id);
}
