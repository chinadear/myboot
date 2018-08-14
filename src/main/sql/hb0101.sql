# Host: localhost  (Version 5.7.18)
# Date: 2018-05-03 10:55:55
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "hb0101"
#

DROP TABLE IF EXISTS `hb0101`;
CREATE TABLE `hb0101` (
  `ID_` int(11) NOT NULL AUTO_INCREMENT,
  `Hb0101001` varchar(64) DEFAULT NULL COMMENT '登陆名',
  `Hb0101002` varchar(64) CHARACTER SET gbk DEFAULT NULL COMMENT '姓名',
  `Hb0101003` varchar(16) DEFAULT NULL COMMENT '手机',
  `Hb0101004` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `Hb0101005` int(11) DEFAULT NULL COMMENT '成功登陆次数',
  `Hb0101006` datetime DEFAULT NULL COMMENT '上次成功登陆时间',
  `Hb0101007` varchar(128) DEFAULT NULL COMMENT '登陆地点',
  `Hb0101008` datetime DEFAULT NULL COMMENT '出身日期',
  `Hb0101009` varchar(2) DEFAULT NULL COMMENT '性别',
  `Hb0101010` varchar(32) DEFAULT NULL COMMENT '身份证号码',
  `Hb0101011` varchar(128) DEFAULT NULL COMMENT '密码',
  `Hb0101012` varchar(16) DEFAULT NULL COMMENT '昵称',
  `Hb0101013` varchar(16) DEFAULT NULL COMMENT 'QQ号码',
  `Hb0101014` varchar(64) DEFAULT NULL COMMENT '微信号',
  `Hb0101015` varchar(128) DEFAULT NULL COMMENT '交易密码',
  `Hb0101016` longtext COMMENT '安全',
  `Hb0101017` longtext COMMENT '属性',
  `Hb0101018` varchar(16) DEFAULT NULL COMMENT '图标编号',
  `Hb0101019` datetime DEFAULT NULL COMMENT '过期时间',
  `Hb0101020` int(11) DEFAULT NULL COMMENT '总的登陆次数',
  `Hb0101021` datetime DEFAULT NULL COMMENT '最新登陆时间',
  `Hb0101022` int(6) DEFAULT NULL COMMENT '登陆错误次数',
  `Hb0101023` datetime DEFAULT NULL COMMENT '可以登陆时间',
  `Hb9999997` int(6) DEFAULT NULL COMMENT 'REV_',
  `Hb9999998` varchar(64) DEFAULT NULL COMMENT '串号',
  `Hb9999999` varchar(2) DEFAULT NULL COMMENT '状态',
  `RowID_` varchar(64) DEFAULT NULL COMMENT '行编号',
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `HB0101001` (`Hb0101001`),
  UNIQUE KEY `HB0101003` (`Hb0101003`),
  KEY `HB0101002` (`Hb0101002`)
) ENGINE=InnoDB AUTO_INCREMENT=10007 DEFAULT CHARSET=utf8 COMMENT='用户信息';

CREATE TABLE `resource` (
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

CREATE TABLE `userlogin` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `USERNAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
   `PASSWORD` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
   `USER_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
   `CREATE_TIME` datetime DEFAULT NULL,
   `UPDATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `user` (
   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
   `NAME` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '昵称，名字',
   `REALNAME` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '真实姓名',
   `IDCARD` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
   `PHONE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号',
   `QQ` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
   `EMAIL` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
   `OPENID` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '微信的OPENID',
   `BIRTHDAY` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
   `ADDRESS` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
   `USERTYPE` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0超级管理员',
   `LASTLOGINTIME` datetime DEFAULT NULL COMMENT '上次登录日期',
   `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0删除，1正常',
   `CREATE_TIME` datetime DEFAULT NULL,
   `UPDATE_TIME` datetime DEFAULT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `sysconfig` (
		   `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
		   `CONFIG_KEY` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
		   `CONFIG_VALUE` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
		   `COMMENTS` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
		   `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
		   `CREATE_TIME` datetime DEFAULT NULL,
		   `UPDATE_TIME` datetime DEFAULT NULL,
		   PRIMARY KEY (`ID`)
		 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
