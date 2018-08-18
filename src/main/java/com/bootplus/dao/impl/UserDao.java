package com.bootplus.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootplus.Util.Constants;
import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.IUserDao;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;

@Repository
public class UserDao extends BaseDaoImpl implements IUserDao {

	@Override
	public UserLogin findUserLoginByName(String name) {
		// TODO Auto-generated method stub
		return (UserLogin)this.queryUnique("from UserLogin where username=? and status='1'", name);
	}

	@Override
	public List<UserLogin> queryUserLoginList() {
		// TODO Auto-generated method stub
		return (List<UserLogin>)this.query("from UserLogin where status='1'");
	}

	@Override
	public List<User> queryUserList(User user) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from User where status='1' ");
		Map paramMap = new HashMap();
		if(StringUtils.hasText(user.getName())) {
			sb.append(" and name=:name");
			paramMap.put("name", user.getName());
		}
		if(StringUtils.hasText(user.getUserType())) {
			sb.append(" and userType=:userType");
			paramMap.put("userType", user.getUserType());
		}
		sb.append(" order by updateTime");
		return (List<User>)this.query(sb.toString(), paramMap);
	}

	@Override
	public Page queryUserLoginPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return this.pagedQuery("from UserLogin where status='1'", pageNo, pageSize, null);
	}

	@Override
	public Page queryUserPage(User user,int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from User where status='1' ");
		Map paramMap = new HashMap();
		if(StringUtils.hasText(user.getName())) {
			sb.append(" and name=:name");
			paramMap.put("name", user.getName());
		}
		if(StringUtils.hasText(user.getUserType())) {
			sb.append(" and userType=:userType");
			paramMap.put("userType", user.getUserType());
		}
		sb.append(" order by updateTime");
		return this.pagedQuery(sb.toString(), paramMap, pageSize, pageNo);
	}

}
