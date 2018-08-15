package com.bootplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.core.base.BaseServiceImpl;
import com.bootplus.dao.IRoleDao;
import com.bootplus.model.Role;
import com.bootplus.service.IRoleService;

@Service
@Transactional
public class RoleService extends BaseServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Override
	public List<Role> queryRoleList(Role role) {
		// TODO Auto-generated method stub
		return roleDao.queryRoleList(role);
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		roleDao.save(role);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		roleDao.update(role);
	}

	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		roleDao.delete(role);
	}

	@Override
	public Role findRoleById(String id) {
		// TODO Auto-generated method stub
		return (Role)roleDao.get(Role.class, id);
	}

}
