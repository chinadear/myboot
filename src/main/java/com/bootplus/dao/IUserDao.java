package com.bootplus.dao;

import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;

public interface IUserDao<T> extends IBaseDao{

	public UserLogin findUserByName(String name);
	public List<UserLogin> queryUserLoginList();
	public List<User> queryUserList();
}
