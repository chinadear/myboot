package com.bootplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.dao.IUserDao;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.bootplus.service.ILoginService;

@Service
@Transactional
public class LoginService implements ILoginService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public void save(UserLogin user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public UserLogin findUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findUserByName(name);
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
	public List<User> queryUserList() {
		// TODO Auto-generated method stub
		return userDao.queryUserList();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

}
