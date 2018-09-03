package com.bootplus.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.dao.IDrumbeatingDao;
import com.bootplus.model.Drumbeating;
/**
 * 
 * @author angle
 *
 */
@Repository
public class DrumbeatingDao extends BaseDaoImpl implements IDrumbeatingDao {

	@Override
	public List<Drumbeating> queryDrumbList(Drumbeating db) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from Drumbeating where 1=1 ");
		Map paramMap = new HashMap();
		if(StringUtils.hasText(db.getStatus())) {
			sb.append(" and status=:status");
			paramMap.put("status", db.getStatus());
		}
		if(StringUtils.hasText(db.getType())) {
			sb.append(" and type=:type");
			paramMap.put("type",db.getType());
		}
		sb.append(" order by createTime");
		return (List<Drumbeating>)this.query(sb.toString(), paramMap);
	}
}
