package com.bootplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.core.base.BaseServiceImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.IAuthDao;
import com.bootplus.dao.IRoleDao;
import com.bootplus.model.ResRole;
import com.bootplus.model.Role;
import com.bootplus.model.UserRole;
import com.bootplus.service.IAuthService;
import com.bootplus.service.IRoleService;

@Service
@Transactional
public class AuthService extends BaseServiceImpl implements IAuthService {

	@Autowired
	private IAuthDao authDao;

	@Override
	public List<UserRole> queryUserRoleList(UserRole ur) {
		// TODO Auto-generated method stub
		return authDao.queryUserRoleList(ur);
	}

	@Override
	public void deleteUserRolesByRoleId(String id) {
		// TODO Auto-generated method stub
		authDao.deleteUserRolesByRoleId(id);
	}

	@Override
	public void deleteUserRolesByUserId(String id) {
		// TODO Auto-generated method stub
		authDao.deleteUserRolesByUserId(id);
	}

	@Override
	public void saveUserRoles(List<UserRole> list) {
		// TODO Auto-generated method stub
		for(UserRole ur:list) {
			authDao.save(ur);
		}
	}

	@Override
	public List<ResRole> queryResRoleList(ResRole rr) {
		// TODO Auto-generated method stub
		return authDao.queryResRoleList(rr);
	}

	@Override
	public void deleteResRolesByRoleId(String id) {
		// TODO Auto-generated method stub
		authDao.deleteResRolesByRoleId(id);
	}

	@Override
	public void saveResRoles(List<ResRole> list) {
		// TODO Auto-generated method stub
		for(ResRole rr:list) {
			authDao.save(rr);
		}
	}

	@Override
	public void saveUserRole(UserRole ur) {
		// TODO Auto-generated method stub
		authDao.save(ur);
	}

}
