package com.bootplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.core.base.BaseServiceImpl;
import com.bootplus.core.dao.page.Page;
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

	@Override
	public Page queryRolePage(Role role, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return roleDao.queryRolePage(role, pageNo, pageSize);
	}

	@Override
	public Role findRoleByCode(String code) {
		// TODO Auto-generated method stub
		return roleDao.findRoleByCode(code);
	}

}
