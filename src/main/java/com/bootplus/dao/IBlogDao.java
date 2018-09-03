package com.bootplus.dao;

import java.util.List;

import com.bootplus.core.dao.IBaseDao;
import com.bootplus.core.dao.page.Page;
import com.bootplus.model.Blog;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;

public interface IBlogDao<T> extends IBaseDao{

	public List<Blog> getBlogList(Blog blog);
	public Page getBlogPage(Blog blog,int pageNo, int pageSize);
	/**
	 * 禁止全部评论，此处紧控制的是不能增加新的评论，历史评论可以看
	 */
	public void disabledAllDiscuss();
	/**
	 * 启用全部评论
	 */
	public void enabledAllDiscuss();
	/**
	 * 更新浏览量
	 * @param articalId
	 */
	public void updateViewNum(String articalId);
}
