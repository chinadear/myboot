package com.demon.service;

import java.io.Serializable;
import java.util.List;

import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.demon.model.Hb0101;

public interface IHb0101Service {

	public void save(Hb0101 object);
	public List<Hb0101> findAll();
	public Hb0101 getHbById(int id);
	public void deleteById(int id);
	public void save(UserLogin user);
	public UserLogin findUserByName(String name);
}
