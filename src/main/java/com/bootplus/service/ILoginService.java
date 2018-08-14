package com.bootplus.service;

import java.util.List;

import com.bootplus.model.User;
import com.bootplus.model.UserLogin;

public interface ILoginService {

	public void save(UserLogin user);
	public UserLogin findUserByName(String name);
	public List<UserLogin> queryUserLoginList();
	public void	update(UserLogin ul);
	//账户可以物理删除
	public void delete(UserLogin ul);
	
	public void save(User user);
	public User findUserById(String id);
	public List<User> queryUserList();
	public void update(User user);
}
