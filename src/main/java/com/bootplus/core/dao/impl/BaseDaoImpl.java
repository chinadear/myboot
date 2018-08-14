package com.bootplus.core.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.bootplus.core.base.BaseModel;
import com.bootplus.core.dao.page.Page;

public class BaseDaoImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 根据ID获取对象. 实际调用Hibernate的session.load()方法返回实体或其proxy对象. 如果对象不存在，抛出异常。
	 */
	public BaseModel get(Class<?> entityClass, Serializable id) {
		return (BaseModel) getSession().get(entityClass, id);
	}
	
	/**
	 * 通过HQL查询对象列表
	 * 
	 * @param hql
	 *            hql语句
	 * @param values
	 *            数量可变的参数
	 */
	public List<?> query(String hql, Object... values) {
		return createQuery(hql, values).list();
	}

	/**
	 * 通过HQL查询唯一对象
	 */
	public Object queryUnique(String hql, Object... values) {
		return createQuery(hql, values).uniqueResult();
	}
		
	
	/**
	 * 根据查询函数与参数列表创建Query对象,后续可进行更多处理,辅助函数.
	 */
	private Query<?> createQuery(String queryString, Object... values) {
		Assert.hasText(queryString, "no hql was detected");
		Query<?> queryObject = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				queryObject.setParameter(i, values[i]);
			}
		}
		return queryObject;
	}
	
	/**
	 * 保存对象
	 */
	/*public void saveOrUpdate(Object o) {
		getSession().saveOrUpdate(o);
	}*/
	
	/**
	 * 保存对象
	 */
	public void update(BaseModel o) {
		o.setUpdateTime(new Date());
		getSession().update(o);
	}
	/**
	 * 保存对象
	 */
	public void save(BaseModel o) {
		o.setCreateTime(new Date());
		o.setUpdateTime(new Date());
		getSession().save(o);
	}
	
	/**
	 * 删除对象
	 */
	public void delete(BaseModel o) {
		getSession().delete(o);
	}
	
	


	public void flush() {
		getSession().flush();
	}
	

	public void clear() {
		getSession().clear();
	}

	/**
	 * 消除与 Hibernate Session 的关联
	 * @param entity
	 */
	public void evit(BaseModel entity){
		getSession().evict(entity);
	}	
	
	public long queryCount(String hql, Object... values) {
		Query<?> queryObject = createQuery(hql, values);
		List<?> list = queryObject.list();
		if (list != null && list.size() > 0) {
			Long count = (Long) list.get(0);
			if (count.intValue() > 0) {
				return count.intValue();
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	/**
	 * 分页查询函数，使用hql.
	 * 
	 * @param pageNo
	 *            页号,从1开始.
	 */
	public Page pagedQuery(String hql, int pageNo, int pageSize,
			Object... values) {
		Assert.hasText(hql,"no hql was detected");
		Assert.isTrue(pageNo >= 1, "pageNo should start from 1");

		// Count查询
		//String countQueryString = " select count (*) "
		//		+ removeSelect(removeOrders(hql));
		//
		String countQueryString =getCountQueryString(hql);
		List<?> countlist = this.query(countQueryString, values);
		long totalCount = (Long) countlist.get(0);

		if (totalCount < 1) {
			return new Page();
		}

		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		Query<?> query = createQuery(hql, values);
		List<?> list = query.setFirstResult(startIndex).setMaxResults(pageSize)
				.list();

		return new Page(startIndex, totalCount, pageSize, list);
	}
	private static String getCountQueryString(String hql){
		int beginPos = hql.toLowerCase().indexOf(" from ");
		if(hql.toLowerCase().startsWith("from "))
			beginPos=0;		
		Assert.isTrue(beginPos != -1, " hql : " + hql
				+ " must has a keyword 'from'");
		if(beginPos>0&&hql.toLowerCase().substring(0, beginPos).indexOf(" distinct ")>-1){
			
			return removeOrders(new StringBuffer(hql.substring(0, beginPos).replace("select", "select count(")).append(") ").append(hql.substring(beginPos)).toString());
		}
		else
			
			return " select count (*) "
						+ removeOrders(hql.substring(beginPos));
				
	}

	/**
	 * 去除hql的orderby 子句，用于pagedQuery.
	 * 
	 * @see #pagedQuery(String, int, int, Object[])
	 */
	private static String removeOrders(String hql) {
		Assert.hasText(hql,"no hql was detected");
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 通过Query 获得分页查询结果
	 * 
	 * @param query
	 * @param totalCount
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unused")
	private Page getPageResult(Query<?> query, int totalCount, int pageNo,
			int pageSize) {
		if (totalCount < 1) {
			return new Page();
		}

		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		List<?> list = query.setFirstResult(startIndex).setMaxResults(pageSize)
				.list();

		return new Page(startIndex, totalCount, pageSize, list);
	}

	public void deleteById(Class<?> entityClass, Serializable id) {
		delete(get(entityClass, id));
	}
	private Query<?> setParameter(Query<?> query, Map<String, Object> map) {  
        if (map != null) {  
            Set<String> keySet = map.keySet();  
            for (String string : keySet) {  
                Object obj = map.get(string);  
                //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
                if(obj instanceof Collection<?>){  
                    query.setParameterList(string, (Collection<?>)obj);  
                }else if(obj instanceof Object[]){  
                    query.setParameterList(string, (Object[])obj);  
                }else{  
                    query.setParameter(string, obj);  
                }  
            }  
        }  
        return query;  
    } 
	
	
	
	/**
	 * hql 支持key map 写法
	 * @param hql
	 * @param map
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Page pagedQuery(String hql, Map<String, Object> map, int pageSize,int pageNo) {  
	    //return this.getQuery(hql, map, pageSize, pageNo).list(); 
		Assert.hasText(hql,"no hql was detected");
		Assert.isTrue(pageNo >= 1, "pageNo should start from 1");

		// Count查询
		//String countQueryString = " select count (*) "
		//		+ removeSelect(removeOrders(hql));
		String countQueryString =getCountQueryString(hql);
		List<?> countlist = this.getQuery(countQueryString, map).list();
		long totalCount = (Long) countlist.get(0);
		if (totalCount < 1) {
			return new Page();
		}
		// 实际查询返回分页对象
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		@SuppressWarnings("unused")
		Query<?> query = getQuery(hql, map,  pageSize, pageNo);
		List<?> list = this.getQuery(hql, map, pageSize, pageNo).list(); 

		return new Page(startIndex, totalCount, pageSize, list);
	}
	/**
	 * 执行hql
	 * @param hql
	 * @param map
	 */
	public void executeHql(String hql, Object... values) {
		Query<?> queryObject = createQuery(hql, values);
		queryObject.executeUpdate();
	}
	/**
	 * 执行hql，由map传递参数
	 * @param hql
	 * @param map
	 */
	public void executeHql(String hql, Map<String, Object> map) {
		Query<?> query = this.getQuery(hql, map);
		query.executeUpdate();
	} 
	/**
	 * hql 支持key map 写法 
	 * @param hql
	 * @param map
	 * @return
	 */
	public List<?> query(String hql, Map<String, Object> map){
		return this.getQuery(hql, map).list();
	} 
	
	private Query<?> getQuery(String hql, Map<String, Object> map) {  
	    Query<?> query = this.createQuery(hql);  
	    query = this.setParameter(query, map);   
	    return query;  
	} 
		  
	private Query<?> getQuery(String hql, Map<String, Object> map, int pageSize,int pageNo) {  
	    Query<?> query = this.createQuery(hql);  
	    query = this.setParameter(query, map);  
	    query = this.setPageProperty(query, pageSize, pageNo);  
	    return query;  
	}  
	  
		  
	private Query<?> setPageProperty(Query<?> query, int pageSize, int pageNo) {  
	    if (pageNo != 0 && pageSize != 0) {  
	        query.setFirstResult((pageNo - 1) * pageSize);  
	        query.setMaxResults(pageSize);  
	    }  
	    return query;  
	} 
	
}
