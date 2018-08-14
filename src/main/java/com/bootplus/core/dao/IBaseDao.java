package com.bootplus.core.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.bootplus.core.base.BaseModel;
import com.bootplus.core.dao.page.Page;

public interface IBaseDao {
	/**
	 * 通过HQL查询对象列表
	 * 
	 * @param hql
	 *            hql语句
	 * @param values
	 *            数量可变的参数
	 */
	public abstract List<?> query(String hql, Object... values);
	/**
	 * 通过HQL查询唯一对象
	 */
	public abstract Object queryUnique(String hql, Object... values);
	/**
	 * 保存对象
	 */
	//public void saveOrUpdate(Object o);
	
	/**
	 * 更新对象
	 */
	public void update(BaseModel o);
	
	/**
	 * 保存对象
	 */
	public void save(BaseModel o) ;
	
	/**
	 * 删除对象
	 */
	public void delete(BaseModel o);
	/**
	 * 根据ID删除对象
	 */
	public void deleteById(Class<?> entityClass, Serializable id);
	
	public void flush() ;
	public void clear();
	/**
	 * 消除与 Hibernate Session 的关联
	 * @param entity
	 */
	public void evit(BaseModel entity);
	
	/**
	 * 分页查询函数，使用hql.
	 * 
	 * @param pageNo
	 *            页号,从1开始.
	 */
	public Page pagedQuery(String hql, int pageNo, int pageSize,
			Object... values) ;
	
	/**
	 * 根据ID获取对象. 实际调用Hibernate的session.load()方法返回实体或其proxy对象. 如果对象不存在，抛出异常。
	 */
	public BaseModel get(Class<?> entityClass, Serializable id);
	
	
	//查询数量
	public long queryCount(String hql, Object... values);
	
	/**
	 * hql 支持key map 写法
	 * @param hql
	 * @param map
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public Page pagedQuery(String hql, Map<String, Object> map, int pageSize,int pageNo);
	
	/**
	 * hql 支持key map 写法 
	 * @param hql
	 * @param map
	 * @return
	 */
	public List<?> query(String hql, Map<String, Object> map);
	/**
	 * 执行hql
	 * @param hql
	 * @param map
	 */
	public void executeHql(String hql, Object... values);
	/**
	 * 执行hql，由map传递参数
	 * @param hql
	 * @param map
	 */
	public void executeHql(String hql, Map<String, Object> map);
	
}
