# Host: localhost  (Version 5.7.18)
# Date: 2018-05-03 10:55:55
# Generator: MySQL-Front 6.0  (Build 2.20)

CREATE TABLE `RESOURCE` (
   `ID` VARCHAR(32) COLLATE utf8_unicode_ci NOT NULL,
   `PARENT_ID` VARCHAR(32) COLLATE utf8_unicode_ci DEFAULT NULL,
   `NAME` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
   `TYPE` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
   `CODE` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
   `LINK` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
   `CLASS_CODE` VARCHAR(255) COLLATE utf8_unicode_ci DEFAULT NULL,
   `SEQ_NUM` INT(11) DEFAULT NULL,
   `STATUS` VARCHAR(1) COLLATE utf8_unicode_ci DEFAULT NULL,
   `COMMENTS` VARCHAR(1500) COLLATE utf8_unicode_ci DEFAULT NULL,
   `CREATE_TIME` DATETIME DEFAULT NULL,
   `UPDATE_TIME` DATETIME DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `USERLOGIN` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `USERNAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
   `PASSWORD` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
   `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
   `USER_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
   `CREATE_TIME` datetime DEFAULT NULL,
   `UPDATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `USER` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `NAME` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '昵称，名字',
   `REALNAME` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '真实姓名',
   `IDCARD` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
   `PHONE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
   `QQ` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
   `EMAIL` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
   `PASSWORD` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码，网站用户的密码',
   `OPENID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '微信的OPENID',
   `BIRTHDAY` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
   `ADDRESS` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
   `USERTYPE` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0超级管理员',
   `HEADERIMG` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户头像',
   `LASTLOGINTIME` datetime DEFAULT NULL COMMENT '上次登录日期',
   `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0删除，1正常',
   `CREATE_TIME` datetime DEFAULT NULL,
   `UPDATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `SYSCONFIG` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `CONFIG_KEY` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
   `CONFIG_VALUE` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
   `COMMENTS` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
   `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
   `CREATE_TIME` datetime DEFAULT NULL,
   `UPDATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `ROLE` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
   `TYPE` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型',
   `CODE` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '编码',
   `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态',
   `COMMENTS` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
   `UPDATE_TIME` datetime DEFAULT NULL,
   `CREATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `FILE` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `SHOWNAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '文件展示名称，上传时文件的名称',
   `SUFFIX` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '后缀',
   `FILENAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '文件名称，改名后存储的文件名称',
   `PATH` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '文件路径，根据年月日来分目录',
   `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态',
   `TYPE` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型',
   `CREATE_TIME` datetime DEFAULT NULL,
   `UPDATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `USER_ROLE` (
   `ID` VARCHAR(32) COLLATE utf8_unicode_ci NOT NULL,
   `USER_ID` VARCHAR(32) COLLATE utf8_unicode_ci DEFAULT NULL,
   `ROLE_ID` VARCHAR(32) COLLATE utf8_unicode_ci DEFAULT NULL,
   `CREATE_TIME` DATETIME DEFAULT NULL,
   `UPDATE_TIME` DATETIME DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

 CREATE TABLE `RES_ROLE` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `RESOURCE_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
   `ROLE_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
   `CREATE_TIME` datetime DEFAULT NULL,
   `UPDATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
 
CREATE TABLE `BOLG` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `CONTENT` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '内容源码',
   `HTML_CONTENT` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '转为HTML的内容',
   `SUMMARY` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '摘要',
   `TITLE` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '标题',
   `CATEGORY` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类别',
   `VIEW_NUM` int(11) DEFAULT '0' COMMENT '浏览量',
   `POSTER` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '海报',
   `USER_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '博客拥有者',
   `DISCUSS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否开启评论',
   `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态',
   `CREATE_TIME` datetime DEFAULT NULL,
   `UPDATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `CATEGORY` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类名称',
   `CODE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '编码',
   `TYPE` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型',
   `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态',
   `COMMENTS` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
   `CREATE_TIME` datetime DEFAULT NULL,
   `UPDATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

 CREATE TABLE `TAG` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
   `CREATE_TIME` datetime DEFAULT NULL,
   `UPDATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
 
 CREATE TABLE `TAGBLOG` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `TAG` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
   `BLOG` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
   `CREATE_TIME` datetime DEFAULT NULL,
   `UPDATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

 CREATE TABLE `COMMENT` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `USER` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '评论人ID，关联用户',
   `SCREENNAME` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '屏显名称，不关联具体人，只保存名称，用于开启匿名评论',
   `ARTICAL` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '文章',
   `COMMENT` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '评论内容',
   `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态',
   `UPDATE_TIME` datetime DEFAULT NULL,
   `CREATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
 
insert into `SYSCONFIG` (`ID`, `CONFIG_KEY`, `CONFIG_VALUE`, `COMMENTS`, `STATUS`, `CREATE_TIME`, `UPDATE_TIME`) values('4028935d654090c2016540983a280000','UPLOADPATH','d:\\boot\\upload','d:\\boot\\upload','1','2018-08-16 10:37:22','2018-08-16 14:57:07');
insert into `SYSCONFIG` (`ID`, `CONFIG_KEY`, `CONFIG_VALUE`, `COMMENTS`, `STATUS`, `CREATE_TIME`, `UPDATE_TIME`) values('402893766536fd6201653700e13d0002','DEFAULT_PASSWORD','12345678','默认密码','1','2018-08-14 13:55:29','2018-08-18 12:39:27');
insert into `SYSCONFIG` (`ID`, `CONFIG_KEY`, `CONFIG_VALUE`, `COMMENTS`, `STATUS`, `CREATE_TIME`, `UPDATE_TIME`) values('4028a881658b11d301658b1522030000','COMMENT_SWITCH','1','是否开启评论，0关闭，1开启，关闭评论后评论内容不可见','1','2018-08-30 21:45:42','2018-08-30 21:48:20');
insert into `SYSCONFIG` (`ID`, `CONFIG_KEY`, `CONFIG_VALUE`, `COMMENTS`, `STATUS`, `CREATE_TIME`, `UPDATE_TIME`) values('4028a881658b11d301658b171dbd0001','COMMENT_CHECK','1','是否开启评论审核，0关闭，1开启，开启审核时，评论进入未发布状态 需要审核后手动发布，发布后才可在页面看到','1','2018-08-30 21:47:52','2018-08-30 21:47:52');
 
