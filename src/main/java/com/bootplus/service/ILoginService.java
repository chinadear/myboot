package com.bootplus.service;

import java.util.List;

import com.bootplus.core.dao.page.Page;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;

public interface ILoginService {

	public void save(UserLogin user);
	public UserLogin findUserLoginByName(String name);
	public UserLogin findUserLoginById(String id);
	public List<UserLogin> queryUserLoginList();
	public Page queryUserLoginPage(int pageNo, int pageSize);
	public void	update(UserLogin ul);
	//账户可以物理删除
	public void delete(UserLogin ul);
	
	public void save(User user);
	public User findUserById(String id);
	public void update(User user);
	public List<User> queryUserList(User user);
	public Page queryUserPage(User user,int pageNo, int pageSize);
}
