package com.bootplus.core.dao.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Page implements Serializable{
	
	private static final long serialVersionUID = -7050810756121673815L;

	public static  int DEFAULT_PAGE_SIZE = 10;

	private int pageSize = DEFAULT_PAGE_SIZE; //每页的记录数

	private long start;  //当前页第一条数据在List中的位置,从0开始

	private Collection<?> data;  //当前页中存放的记录,类型一般为List

	private long totalCount; //总记录数

	/**
	 * 构造方法，只构造空页
	 */
	public Page() {
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<Object>(0));
	}

	/**
	 * 默认构造方法
	 *
	 * @param start	 本页数据在数据库中的起始位置
	 * @param totalSize 数据库中总记录条数
	 * @param pageSize  本页容量
	 * @param data	  本页包含的数据
	 */
	public Page(long start, long totalSize, int pageSize, Collection<?> data) {
		if(pageSize==0)
			this.pageSize = DEFAULT_PAGE_SIZE;
		else
			this.pageSize = pageSize;
		this.start = start;
		this.totalCount = totalSize;
		this.data = data;
	}

	/**
	 * 取总记录数.
	 */
	public long getTotalCount() {
		return this.totalCount;
	}

	/**
	 * 取总页数.
	 */
	public long getTotalPageCount() {
		if (totalCount % pageSize == 0)
			return totalCount / pageSize;
		else
			return totalCount / pageSize + 1;
	}

	/**
	 * 取每页数据容量.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 取当前页中的记录.
	 */
	public Collection<?> getResult() {
		return data;
	}
	
	/**
	 * 设置数据集合
	 * @param data
	 */
	public void setResult(Collection<?> data) {
		this.data = data;
	}

	/**
	 * 取该页当前页码,页码从1开始.
	 */
	public long getCurrentPageNo() {
		return start / pageSize + 1;
	}

	/**
	 * 该页是否有下一页.
	 */
	public boolean hasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount();
	}

	/**
	 * 该页是否有上一页.
	 */
	public boolean hasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}

	/**
	 * 获得此页的下一页页数
	 */
	public long getNextPageNo() {
		if (hasNextPage()) {
			return this.getCurrentPageNo() + 1;
		}
		
		return this.getCurrentPageNo();
	}
	
	/**
	 * 获得此页上一页的页数
	 */
	public long getPreviousPageNo() {
		if (hasPreviousPage()) {
			return this.getCurrentPageNo() - 1;
		}
		
		return this.getCurrentPageNo();
	}
	/**
	 * 
	 * 获取任一页第一条数据在数据集的位置
	 *
	 * @param pageNo   从1开始的页号
	 * @param pageSize 每页记录条数
	 * @return 该页第一条数据
	 */
	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}

	
	/**
	 * 获取任一页第一条数据在数据集的位置，每页条数使用默认值.
	 *
	 * @see #getStartOfPage(int,int)
	 */
	protected static int getStartOfPage(int pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
