package com.bootplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.core.base.BaseServiceImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.IUserDao;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.bootplus.service.ILoginService;

@Service
@Transactional
public class LoginService extends BaseServiceImpl implements ILoginService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public void save(UserLogin user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public UserLogin findUserLoginByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findUserLoginByName(name);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public User findUserById(String id) {
		// TODO Auto-generated method stub
		return (User)userDao.get(User.class, id);
	}

	@Override
	public List<UserLogin> queryUserLoginList() {
		// TODO Auto-generated method stub
		return userDao.queryUserLoginList();
	}

	@Override
	public void update(UserLogin ul) {
		// TODO Auto-generated method stub
		userDao.update(ul);
	}

	@Override
	public void delete(UserLogin ul) {
		// TODO Auto-generated method stub
		userDao.delete(ul);
	}

	@Override
	public List<User> queryUserList(User user) {
		// TODO Auto-generated method stub
		return userDao.queryUserList(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public UserLogin findUserLoginById(String id) {
		// TODO Auto-generated method stub
		return (UserLogin)userDao.get(UserLogin.class, id);
	}

	@Override
	public Page queryUserLoginPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.queryUserLoginPage(pageNo, pageSize);
	}

	@Override
	public Page queryUserPage(User user,int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.queryUserPage(user, pageNo, pageSize);
	}
}
