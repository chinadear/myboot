package com.bootplus.Util;

public class Constants {
	/**
	 * 根菜单名称
	 */
	public static final String ROOT_MENU_NAME = "菜单";
	/**
	 * 根菜单编码
	 */
	public static final String ROOT_MENU_BOOT_CODE="BOOT_MENU";
	/**
	 * 删除状态
	 */
	public static final String SYSTEM_DIC_DELETE_STATUS = "0";
	/**
	 * 正常状态
	 */
	public static final String SYSTEM_DIC_NORMAL_STATUS = "1";
	/**
	 * 管理员
	 */
	public static final String SYSTEM_DIC_USERTYPE_ADMIN = "0";
	/**
	 * 系统用户，可以登录后台系统的用户
	 */
	public static final String SYSTEM_DIC_USERTYPE_USER = "1";
	/**
	 * 网站会员
	 */
	public static final String SYSTEM_DIC_USERTYPE_MEMBER= "2";
	/**
	 * 用户session的key
	 */
	public static final String SESSION_USER_KEY="sessionUser";
	//=====以下是系统配置用的key
	/**
	 * 系统配置中设置的附件上传目录
	 */
	public static final String SYSTEM_DIC_SYSTEMCONFIG_UPLOADPATH_KEY= "UPLOADPATH";
	/**
	 * 默认密码的key值
	 */
	public static final String SYSTEM_DIC_SYSTEMCONFIG_DEFAULT_PASSWORD_KEY= "DEFAULT_PASSWORD";
	/**
	 * 文章评论的开关，此处控制是否开启评论功能，0关闭，1开启；关闭评论功能意味着网站中将看不到评论模块
	 */
	public static final String SYSTEM_DIC_SYSTEMCONFIG_SWITCH_COMMENT="COMMENT_SWITCH";
}
