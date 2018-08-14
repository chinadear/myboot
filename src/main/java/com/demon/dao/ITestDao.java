package com.demon.dao;

import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.demon.model.Hb0101;

public interface ITestDao<T> extends IBaseDao{

	//-------------write data------------------------
//	public Serializable save(T object);
	public List<T> findAll();
	public Hb0101 getHbById(int id);
	public void deleteById(int id);
	public UserLogin findUserByName(String name);
}
