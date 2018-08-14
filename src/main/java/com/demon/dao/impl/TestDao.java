package com.demon.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.demon.dao.ITestDao;
import com.demon.model.Hb0101;

@Repository
public class TestDao<T> extends BaseDaoImpl implements ITestDao<T> {

//	@Override
//	public Serializable save(T object) {
//		return getSession().save(object);
//	}

	@Override
	public Hb0101 getHbById(int id) {
		// TODO Auto-generated method stub
		return (Hb0101)this.get(Hb0101.class, id);
	}

	@Override
	public List<T> findAll() {
		return (List<T>)this.query("from Hb0101", new Object[] {});
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		this.deleteById(id);
	}

	@Override
	public UserLogin findUserByName(String name) {
		// TODO Auto-generated method stub
		return (UserLogin)this.queryUnique("from UserLogin where username=?", name);
	}
}
