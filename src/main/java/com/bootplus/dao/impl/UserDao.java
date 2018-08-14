package com.bootplus.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootplus.Util.Constants;
import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.dao.IUserDao;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;

@Repository
public class UserDao extends BaseDaoImpl implements IUserDao {

	@Override
	public UserLogin findUserLoginByName(String name) {
		// TODO Auto-generated method stub
		return (UserLogin)this.queryUnique("from UserLogin where username=?", name);
	}

	@Override
	public List<UserLogin> queryUserLoginList() {
		// TODO Auto-generated method stub
		return (List<UserLogin>)this.query("from UserLogin ");
	}

	@Override
	public List<User> queryUserList() {
		// TODO Auto-generated method stub
		return (List<User>)this.query("from User where status='1' and userType=?", Constants.SYSTEM_DIC_USERTYPE_MEMBER);
	}

	@Override
	public List<User> queryUser(User user) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from User where 1=1 ");
		Map paramMap = new HashMap();
		if(StringUtils.hasText(user.getName())) {
			sb.append(" and name=:name");
			paramMap.put("name", user.getName());
		}
		sb.append(" order by updateTime");
		return (List<User>)this.query(sb.toString(), paramMap);
	}

}
