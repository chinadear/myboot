package com.bootplus.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bootplus.core.dao.impl.BaseDaoImpl;
import com.bootplus.core.dao.page.Page;
import com.bootplus.dao.IDicDao;
import com.bootplus.model.Dic;
import com.bootplus.model.DicItem;

@Repository
public class DicDao extends BaseDaoImpl implements IDicDao {

	@Override
	public Page queryDicPage(Dic dic, int pageNo, int pageSize) {
		StringBuffer sb=new StringBuffer("from Dic where 1=1 ");
		Map paramMap = new HashMap();
		if(StringUtils.hasText(dic.getName())) {
			sb.append(" and name=:name");
			paramMap.put("name", dic.getName());
		}
		if(StringUtils.hasText(dic.getCode())) {
			sb.append(" and code=:code");
			paramMap.put("code", dic.getCode());
		}
		if(StringUtils.hasText(dic.getStatus())) {
			sb.append(" and status=:status");
			paramMap.put("status", dic.getStatus());
		}
		sb.append(" order by createTime");
		return this.pagedQuery(sb.toString(), paramMap, pageSize, pageNo);
	}

	@Override
	public List<Dic> queryDicList(Dic dic) {
		StringBuffer sb=new StringBuffer("from Dic where 1=1 ");
		Map paramMap = new HashMap();
		if(StringUtils.hasText(dic.getName())) {
			sb.append(" and name=:name");
			paramMap.put("name", dic.getName());
		}
		if(StringUtils.hasText(dic.getCode())) {
			sb.append(" and code=:code");
			paramMap.put("code", dic.getCode());
		}
		if(StringUtils.hasText(dic.getStatus())) {
			sb.append(" and status=:status");
			paramMap.put("status", dic.getStatus());
		}
		sb.append(" order by createTime");
		return this.query(sb.toString(), paramMap);
	}

	@Override
	public List<DicItem> queryDicItemListInDic(DicItem di) {
		StringBuffer sb=new StringBuffer("from DicItem where 1=1 ");
		Map paramMap = new HashMap();
		if(di.getDic()!=null && StringUtils.hasText(di.getDic().getId())) {
			sb.append(" and dic.id=:dicid");
			paramMap.put("dicid", di.getDic().getId());
		}
		if(di.getDic()!=null && StringUtils.hasText(di.getDic().getCode())) {
			sb.append(" and dic.code=:diccode");
			paramMap.put("diccode", di.getDic().getCode());
		}
		if(StringUtils.hasText(di.getName())) {
			sb.append(" and name=:name");
			paramMap.put("name", di.getName());
		}
		if(StringUtils.hasText(di.getCode())) {
			sb.append(" and code=:code");
			paramMap.put("code", di.getCode());
		}
		if(StringUtils.hasText(di.getStatus())) {
			sb.append(" and status=:status");
			paramMap.put("status", di.getStatus());
		}
		sb.append(" order by code");
		return this.query(sb.toString(), paramMap);
	}

	@Override
	public Page queryDicitemPage(DicItem di, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from DicItem where 1=1 ");
		Map paramMap = new HashMap();
		if(di.getDic()!=null && StringUtils.hasText(di.getDic().getId())) {
			sb.append(" and dic.id=:dicid");
			paramMap.put("dicid", di.getDic().getId());
		}
		if(StringUtils.hasText(di.getName())) {
			sb.append(" and name=:name");
			paramMap.put("name", di.getName());
		}
		if(StringUtils.hasText(di.getCode())) {
			sb.append(" and code=:code");
			paramMap.put("code", di.getCode());
		}
		if(StringUtils.hasText(di.getStatus())) {
			sb.append(" and status=:status");
			paramMap.put("status", di.getStatus());
		}
		sb.append(" order by code");
		return this.pagedQuery(sb.toString(), paramMap, pageSize, pageNo);
	}

}
