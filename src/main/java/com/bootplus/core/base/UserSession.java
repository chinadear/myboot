package com.bootplus.core.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootplus.model.Resource;

public class UserSession implements Serializable {

	private static final long serialVersionUID = 2710766762400417535L;
	public static final String SESSION_USER_KEY="sessionUser";
	
	private String userId;
	//用户名
	private String name;
	//登录账号
	private String loginName;
	//sitebar菜单，内联子菜单列表结构
	private Resource resource;
	//导航字符串
	private List<String> navList;
	//当前选中的菜单ID
	private String curMenuId;
	//当前选中的父菜单ID
	private String curParentMenuId;
	//上次登录时间
	private Date lastLoginDate;
	//sidebar的状态，1展开，0收缩
	private String sidebarStatus;
	//拥有的菜单权限，map
	private Map<String,Boolean> ownMenuMap;
	//是否超级管理员
	private boolean isAdmin=false;
	
	//扩展属性
	private boolean ext;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public List<String> getNavList() {
		return navList;
	}
	public void setNavList(List<String> navList) {
		this.navList = navList;
	}
	public String getCurMenuId() {
		return curMenuId;
	}
	public void setCurMenuId(String curMenuId) {
		this.curMenuId = curMenuId;
	}
	public String getCurParentMenuId() {
		return curParentMenuId;
	}
	public void setCurParentMenuId(String curParentMenuId) {
		this.curParentMenuId = curParentMenuId;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getSidebarStatus() {
		return sidebarStatus;
	}
	public void setSidebarStatus(String sidebarStatus) {
		this.sidebarStatus = sidebarStatus;
	}
	public Map<String, Boolean> getOwnMenuMap() {
		return ownMenuMap;
	}
	public void setOwnMenuMap(Map<String, Boolean> ownMenuMap) {
		this.ownMenuMap = ownMenuMap;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isExt() {
		return ext;
	}
	public void setExt(boolean ext) {
		this.ext = ext;
	}
	
}
