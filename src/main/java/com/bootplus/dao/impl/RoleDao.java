package com.bootplus.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.dao.IRoleDao;
import com.bootplus.model.Role;

@Repository
public class RoleDao extends BaseDaoImpl implements IRoleDao {

	@Override
	public List<Role> queryRoleList(Role role) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from Role where status='1' ");
		Map paramMap = new HashMap();
		if(StringUtils.hasText(role.getCode())) {
			sb.append(" and code=:code");
			paramMap.put("code", role.getCode());
		}
		if(StringUtils.hasText(role.getType())) {
			sb.append(" and type=:type");
			paramMap.put("type", role.getType());
		}
		if(StringUtils.hasText(role.getName())) {
			sb.append(" and name=:name");
			paramMap.put("name", role.getName());
		}
		sb.append(" order by createTime");
		return (List<Role>)this.query(sb.toString(), paramMap);
	}

}
