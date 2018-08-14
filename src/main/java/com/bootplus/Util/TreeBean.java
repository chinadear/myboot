package com.bootplus.Util;

import java.io.Serializable;

public class TreeBean implements Serializable {
	private static final long serialVersionUID = 7442887876540587434L;
	/**
	 * id
	 */
	private String id;
	/**
	 * 父id,根节点父id为0或null
	 */
	private String pId;
	/**
	 * 节点显示名称
	 */
	private String name;
	/**
	 * 是否初始化展开节点,"true"展开，"false"不展开，默认false
	 */
	private String open="false";
	/**
	 * 扩展参数，可用于树节点可扩展的自定义参数
	 */
	private String param;
	/**
	 * 设置节点图标
	 */
	private String icon;
	/**
	 * 是否勾选，只使用于checkbox,radio;勾选t"true",不勾选"false"
	 */
	private String checked="false";
	
	private String title;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	/**
	 * 父id,根节点父id为0或null
	 */
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	/**
	 * 节点显示名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	public String getParam() {
		return param;
	}
	/**
	 * 扩展参数，可用于树节点可扩展的自定义参数
	 */
	public void setParam(String param) {
		this.param = param;
	}
	public String getOpen() {
		return open;
	}
	/**
	 * 是否初始化展开节点,"true"展开，"false"不展开，默认false
	 */
	public void setOpen(String open) {
		this.open = open;
	}
	public String getChecked() {
		return checked;
	}
	/**
	 * 是否勾选，只使用于checkbox,radio;勾选t"true",不勾选"false"
	 */
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置节点图标
	 * @param icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
