package com.bootplus.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.dao.IAuthDao;
import com.bootplus.model.ResRole;
import com.bootplus.model.Role;
import com.bootplus.model.UserRole;

@Repository
public class AuthDao extends BaseDaoImpl implements IAuthDao {

	@Override
	public List<UserRole> queryUserRoleList(UserRole ur) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from UserRole where 1=1 ");
		Map paramMap = new HashMap();
		if(ur.getRole()!=null && StringUtils.hasText(ur.getRole().getId())) {
			sb.append(" and role.id=:rid");
			paramMap.put("rid", ur.getRole().getId());
		}
		if(ur.getUser()!=null &&StringUtils.hasText(ur.getUser().getId())) {
			sb.append(" and user.id=:uid");
			paramMap.put("uid", ur.getUser().getId());
		}
		sb.append(" order by createTime");
		return (List<UserRole>)this.query(sb.toString(), paramMap);
	}

	@Override
	public void deleteUserRolesByRoleId(String id) {
		// TODO Auto-generated method stub
		String hql = "DELETE FROM UserRole WHERE role.id=?";
		this.executeHql(hql, id);
	}

	@Override
	public void deleteUserRolesByUserId(String id) {
		// TODO Auto-generated method stub
		String hql = "DELETE FROM UserRole WHERE user.id=?";
		this.executeHql(hql, id);
	}

	@Override
	public List<ResRole> queryResRoleList(ResRole rr) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from ResRole where 1=1 ");
		Map paramMap = new HashMap();
		if(rr.getRole()!=null && StringUtils.hasText(rr.getRole().getId())) {
			sb.append(" and role.id=:rid");
			paramMap.put("rid", rr.getRole().getId());
		}
		sb.append(" order by createTime");
		return (List<ResRole>)this.query(sb.toString(), paramMap);
	}

	@Override
	public void deleteResRolesByRoleId(String id) {
		// TODO Auto-generated method stub
		String hql = "DELETE FROM ResRole WHERE role.id=?";
		this.executeHql(hql, id);
	}

}
