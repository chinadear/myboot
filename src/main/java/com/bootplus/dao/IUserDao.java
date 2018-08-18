package com.bootplus.dao;

import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;

public interface IUserDao<T> extends IBaseDao{

	public UserLogin findUserLoginByName(String name);
	public List<UserLogin> queryUserLoginList();
	public List<User> queryUserList(User user);
	public Page queryUserLoginPage(int pageNo, int pageSize);
	public Page queryUserPage(User user,int pageNo, int pageSize);
}
