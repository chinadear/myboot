package com.bootplus.dto;

import com.bootplus.model.Blog;
import com.bootplus.model.Category;
import com.bootplus.model.Drumbeating;
import com.bootplus.model.Tag;

import java.util.List;
/**
 * 非持久化类，用于数据传输
 * 目前主要用于存储网站各个推广模块的信息
 * @author angle
 *
 */
public class StructModel implements java.io.Serializable{

	private static final long serialVersionUID = -8307301018520389160L;

	private Drumbeating banner;
	private List<Drumbeating> rightdrum;
	private List<Blog> hot;
	private List<Tag> tag;
	private List<Category> cate;
	
	public Drumbeating getBanner() {
		return banner;
	}
	public void setBanner(Drumbeating banner) {
		this.banner = banner;
	}
	public List<Drumbeating> getRightdrum() {
		return rightdrum;
	}
	public void setRightdrum(List<Drumbeating> rightdrum) {
		this.rightdrum = rightdrum;
	}
	public List<Blog> getHot() {
		return hot;
	}
	public void setHot(List<Blog> hot) {
		this.hot = hot;
	}
	public List<Tag> getTag() {
		return tag;
	}
	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}
	public List<Category> getCate() {
		return cate;
	}
	public void setCate(List<Category> cate) {
		this.cate = cate;
	}
	
}
