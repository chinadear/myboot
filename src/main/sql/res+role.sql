DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类名称',
  `CODE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '编码',
  `TYPE` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型',
  `FILE` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片，用于单独展示',
  `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态',
  `COMMENTS` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `category` */

insert  into `category`(`ID`,`NAME`,`CODE`,`TYPE`,`FILE`,`STATUS`,`COMMENTS`,`CREATE_TIME`,`UPDATE_TIME`) values ('4028935d657a718501657a9123d3000a','springboot',NULL,'0',NULL,'1','springboot一款spring出品的开源框架，基于模块化','2018-08-27 16:47:36','2018-08-27 16:47:50'),('4028935d657a718501657a9781da000c','docker',NULL,'1',NULL,'1','','2018-08-27 16:54:34','2018-09-12 11:58:22'),('4028935d65834deb01658365560c0001','javascrip',NULL,'0',NULL,'1','','2018-08-29 09:56:21','2018-08-29 09:56:21'),('4028937065cb710a0165cb9d790d0000','云服务',NULL,'1','4028937065cbe6700165cbe9b9e10003','1','属于云服务从无到有系列','2018-09-12 10:30:19','2018-09-12 11:53:37'),('4028937065cbb4bf0165cbb8bd280000','springboot从0-1',NULL,'1','4028937065cbe6700165cbe980550001','1','学习从开发工具到环境搭建，再到框架代码学习，最后部署上云的全过程','2018-09-12 11:00:06','2018-09-12 11:53:22'),('4028937065cbb4bf0165cbb959040001','测试23',NULL,'3',NULL,'0','嗷嗷1','2018-09-12 11:00:46','2018-09-12 11:01:08');

/*Table structure for table `dic` */

DROP TABLE IF EXISTS `dic`;

CREATE TABLE `dic` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CODE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `COMMENTS` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `dic` */

insert  into `dic`(`ID`,`NAME`,`CODE`,`STATUS`,`COMMENTS`,`CREATE_TIME`,`UPDATE_TIME`) values ('4028937065c16b720165c1744b200001','区域','POSITION','1','头部banner,右侧轮播图，工具箱，资源下载','2018-09-10 11:09:08','2018-09-12 10:37:57'),('4028937065c19b840165c1a0b5970001','板块','PLATE','0','文章所属板块,当前板块分为，博客；行业新闻；从0-1，首页','2018-09-10 11:57:39','2018-09-12 11:10:40');

/*Table structure for table `dic_item` */

DROP TABLE IF EXISTS `dic_item`;

CREATE TABLE `dic_item` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CODE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DIC` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL,
  `COMMENTS` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `dic_item` */

insert  into `dic_item`(`ID`,`NAME`,`CODE`,`DIC`,`STATUS`,`SORT`,`COMMENTS`,`UPDATE_TIME`,`CREATE_TIME`) values ('4028937065c16b720165c1749c9d0002','头部banner','0','4028937065c16b720165c1744b200001','1',0,'头部图片的配置','2018-09-11 11:02:49','2018-09-10 11:09:29'),('4028937065c16b720165c174eed20003','右侧轮播','1','4028937065c16b720165c1744b200001','1',0,'右侧轮播图的内容添加','2018-09-10 11:09:50','2018-09-10 11:09:50'),('4028937065c19b840165c1a0ec0e0002','博客','0','4028937065c19b840165c1a0b5970001','1',0,'','2018-09-10 11:57:53','2018-09-10 11:57:53'),('4028937065c19b840165c1a154e80003','行业资讯','2','4028937065c19b840165c1a0b5970001','1',0,'','2018-09-11 17:00:05','2018-09-10 11:58:20'),('4028937065c668390165c68bc48f0004','工具箱','3','4028937065c16b720165c1744b200001','1',0,'站外资源，资源URL+标题，通过tag的形式展示与使用','2018-09-11 11:04:34','2018-09-11 10:52:53'),('4028937065c668390165c68cf0ab0005','资源下载','2','4028937065c16b720165c1744b200001','1',0,'百度网盘及其他资源，采用下载链接+标题，采用tag的形式','2018-09-11 11:03:06','2018-09-11 10:54:10'),('4028937065c7ca3d0165c7daa2430002','从0-1系列','1','4028937065c19b840165c1a0b5970001','1',0,'','2018-09-12 11:11:01','2018-09-11 16:58:39'),('4028937065c7ca3d0165c7dad23e0003','首页','3','4028937065c19b840165c1a0b5970001','1',0,'','2018-09-11 16:58:51','2018-09-11 16:58:51'),('4028937065cc64080165cc7e047d0003','内容导航','4','4028937065c19b840165c1a0b5970001','1',0,'','2018-09-12 14:35:35','2018-09-12 14:35:35'),('4028937065cc64080165cc7e398a0004','工具箱','5','4028937065c19b840165c1a0b5970001','1',0,'','2018-09-12 14:36:00','2018-09-12 14:35:49'),('4028937065cc64080165cc7e61d90005','资源下载','6','4028937065c19b840165c1a0b5970001','1',0,'','2018-09-12 14:35:59','2018-09-12 14:35:59');

/*Table structure for table `drumbeating` */

DROP TABLE IF EXISTS `drumbeating`;

CREATE TABLE `drumbeating` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `FILE` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片文件',
  `TITLE` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `SUMMARY` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '摘要',
  `URL` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '链接',
  `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态，停用启用等',
  `PLATE` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '板块',
  `CLOSINGDATE` datetime DEFAULT NULL COMMENT '截止日期，下架日期',
  `TYPE` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型，哪个版块的',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `drumbeating` */

insert  into `drumbeating`(`ID`,`FILE`,`TITLE`,`SUMMARY`,`URL`,`STATUS`,`PLATE`,`CLOSINGDATE`,`TYPE`,`CREATE_TIME`,`UPDATE_TIME`) values ('4028935d659e91b701659e929bc00002','4028935d659e91b701659e929b3b0001','bootplus助你成长','学习就要循序渐进，坚持到底才能成功！,bootplus一款开源学习平台，为你踏平学习中的陷阱，学习就要循序渐进，坚持到底才能成功！','','1','3',NULL,'0','2018-09-03 16:35:32','2018-09-12 14:30:31'),('4028935d659e91b701659e939d7b0005','4028935d659e91b701659e939d180004','中国最大的企业','腾讯财经讯 9月2日，由中国企业联合会、中国企业家协会连续第17次向社会公开发布的“中国企业500强”排行榜今日在西安揭晓。中国企业联合会、中国企业家协会课题组同时发布了一份关于2018中国大企业发展的趋势、问题和建议。','https://finance.qq.com/a/20180902/039501.htm','1',NULL,NULL,'1','2018-09-03 16:36:38','2018-09-11 11:43:37'),('4028935d659e91b701659e9442460008','4028935d659e91b701659e9441d40007','中国最大的公司是哪家？','提及中国最大的公司，你可能会脱口而出中石化、中石油？阿里巴巴、腾讯？万达、万科？都不对，中国最大的公司是中国铁路总公司。中国铁路总公司是由中央管理的正部级国有独资企业，2013年3月17日正式成立，注册资金10360亿元，职工总数204.56万人，资产总额46631.59亿元，营业里程近2万公里，居世界第一。','https://baijiahao.baidu.com/s?id=1577301547448774030&wfr=spider&for=pc','1',NULL,NULL,'1','2018-09-03 16:37:21','2018-09-11 11:43:38'),('4028935d659e91b701659e94de17000b','4028935d659e91b701659e94dda9000a','台湾民众积极领证，蔡英文要气坏了。','《港澳台居民居住证申领发放办法》9月1日起正式实施，大陆公安机关设立的6000多个受理点开始受理港澳台居民的申请，各地符合条件的人士出现“抢头香”的“壮观场景”。相对于民众的积极，台湾民进党当局仍在极力阻挠。台湾《中国时报》2日直言，比起从小处着手为台胞着想的大陆，台湾陆委会“威吓国人的制式响应”充满冷战思维，毫无帮助，更无说服力。','https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_18034597517739531806%22%7D&n_type=0&p_from=1','1',NULL,NULL,'1','2018-09-03 16:38:00','2018-09-11 11:43:38'),('4028937065c6b5ef0165c6bd824c0000',NULL,'在线格式化(可加密)','在线格式化工具，支持js,css等加密处理，也可格式化','http://www.bejson.com/','1',NULL,NULL,'3','2018-09-11 11:47:13','2018-09-11 14:00:23'),('4028937065c6b5ef0165c6be0da40001',NULL,'在线格式化(多语言)','可支持多种语言的代码格式化操作','http://tool.oschina.net/codeformat/html','1',NULL,NULL,'3','2018-09-11 11:47:48','2018-09-11 14:00:39'),('4028937065c74d690165c796db0c0000',NULL,'定时任务','可以定时执行制定的任务，根据任务列表指定任务','','1',NULL,NULL,'3','2018-09-11 15:44:37','2018-09-11 15:44:58'),('4028937065c74d690165c7975d470001',NULL,'随心所欲的博客','','','1',NULL,NULL,'3','2018-09-11 15:45:10','2018-09-11 15:45:12'),('4028937065c74d690165c7979b100002',NULL,'压缩工具','','','1',NULL,NULL,'3','2018-09-11 15:45:26','2018-09-11 15:45:36'),('4028937065c74d690165c797bd9a0003',NULL,'转码工具','','','1',NULL,NULL,'3','2018-09-11 15:45:35','2018-09-11 15:45:35'),('4028937065c74d690165c797ea1e0004',NULL,'加密工具','','','1',NULL,NULL,'3','2018-09-11 15:45:46','2018-09-11 15:45:46'),('4028937065c74d690165c79812a60005',NULL,'图片处理','','','1',NULL,NULL,'3','2018-09-11 15:45:56','2018-09-11 15:45:56'),('4028937065c7ca3d0165c7cd77c00000',NULL,'xmanager','linux SSH工具','https://pan.baidu.com/s/1fW-Knbji8JcGAj3kHXCOYg','1',NULL,NULL,'2','2018-09-11 16:44:16','2018-09-11 16:44:18'),('4028937065c7ca3d0165c7ce42510001',NULL,'内存监控代码','用于监控内存情况的java代码，可独立运行的代码','https://pan.baidu.com/s/1mhIbOBe','1',NULL,NULL,'2','2018-09-11 16:45:08','2018-09-11 16:45:08'),('4028937065cc64080165cc6c94a30002','4028937065cc64080165cc6c93d40001','阿里云优惠券','免费领取阿里云优惠券，通用型可用于大部分阿里云产品，优惠券金额最高可达1000元。','https://promotion.aliyun.com/ntms/yunparter/invite.html?userCode=k8o2t2vr','1','1',NULL,'0','2018-09-12 14:16:32','2018-09-12 15:02:46'),('4028937065cc64080165cc8178bc0008','4028937065cc64080165cc8178540007','智慧校园','智慧校园整体解决方案','','1','5',NULL,'0','2018-09-12 14:39:21','2018-09-12 15:03:59'),('4028937065cc64080165cc8239f2000b','4028937065cc64080165cc82399c000a','自能办公','物联网一站式开发及云服务平台,提供一体化IoT解决方案,助力传统','','1','4',NULL,'0','2018-09-12 14:40:11','2018-09-12 15:04:02'),('4028937065cc64080165cc830c87000e','4028937065cc64080165cc830c32000d','百度云服务','百度云—百度基于17年技术积累为公有云需求者提供稳定、高可用、可扩展的云计算服务。已拥有云服务器BCC、内容分发网络CDN、关系型数据库RDS、对象存储BOS等100余款产品，智能大数据-天算、智能多媒体-天像、智能物联网-天工、人工智能-天智四大智能平台解决方案。','','1','2',NULL,'0','2018-09-12 14:41:05','2018-09-12 15:05:40');

/*Table structure for table `resource` */

DROP TABLE IF EXISTS `resource`;

CREATE TABLE `resource` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `PARENT_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TYPE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CODE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LINK` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CLASS_CODE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SEQ_NUM` int(11) DEFAULT NULL,
  `STATUS` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `COMMENTS` varchar(1500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `resource` */

insert  into `resource`(`ID`,`PARENT_ID`,`NAME`,`TYPE`,`CODE`,`LINK`,`CLASS_CODE`,`SEQ_NUM`,`STATUS`,`COMMENTS`,`CREATE_TIME`,`UPDATE_TIME`) values ('4028935d658a1b9c01658a1daf1f0000','40289376650d3b1701650d49dacf0004','评论管理',NULL,'comment','comment/blogs','glyphicon glyphicon-comment',2,'1','','2018-08-30 17:15:25','2018-09-10 13:12:03'),('4028935d659e85d001659e8dad850000','40289376650d3b1701650d49dacf0004','推广管理',NULL,'drumbeating','drumbeating/list','glyphicon glyphicon-globe',4,'0','','2018-09-03 16:30:09','2018-09-03 16:30:09'),('4028935d65a8eb260165a9012ed20000','40289376650d3b1701650d4a69ac0005','字典管理',NULL,'dic','dic/list','glyphicon glyphicon-book',7,'1','','2018-09-05 17:12:31','2018-09-05 17:12:31'),('40289376650d3b1701650d47a3b10002',NULL,'根菜单',NULL,'BOOT_MENU','','',0,'1','','2018-08-06 11:28:43','2018-08-06 11:28:43'),('40289376650d3b1701650d48e4130003','40289376650d3b1701650d47a3b10002','首页',NULL,'MAIN_MENU','/','fa fa-home',1,'0','','2018-08-06 11:30:05','2018-08-06 11:30:05'),('40289376650d3b1701650d49dacf0004','40289376650d3b1701650d47a3b10002','内容管理',NULL,'CONTENT','','glyphicon glyphicon-bold',3,'1','','2018-08-06 11:31:08','2018-09-11 16:56:16'),('40289376650d3b1701650d4a69ac0005','40289376650d3b1701650d47a3b10002','系统管理',NULL,'SYSTEMMANAGE_MENU','','glyphicon glyphicon-scale',2,'1','','2018-08-06 11:31:45','2018-08-18 12:39:59'),('40289376650d3b1701650d4ad8b00006','40289376650d3b1701650d47a3b10002','用户管理',NULL,'USERMANAGE_MENU','','fa fa-bell',4,'0','','2018-08-06 11:32:13','2018-08-06 11:32:13'),('40289376650d3b1701650d4b4c9b0007','40289376650d3b1701650d47a3b10002','字典管理',NULL,'DIC_MENU','','fa fa-magnet',5,'0','','2018-08-06 11:32:43','2018-08-06 11:32:43'),('40289376650d3b1701650d4bb0e10008','40289376650d3b1701650d47a3b10002','区域内容',NULL,'drumbeating','drumbeating/list','glyphicon glyphicon-globe',6,'1','','2018-08-06 11:33:08','2018-09-12 10:38:10'),('40289376650d3b1701650d4c31fe0009','40289376650d3b1701650d47a3b10002','设备管理',NULL,'SET_MENU','','fa fa-map',7,'0','','2018-08-06 11:33:42','2018-08-06 11:33:42'),('40289376650d3b1701650d4c7e71000a','40289376650d3b1701650d47a3b10002','接口管理',NULL,'INTERFACE_MENU','','glyphicon glyphicon-user',9,'1','','2018-08-06 11:34:01','2018-08-18 12:40:35'),('40289376650d3b1701650d4cbdbe000b','40289376650d3b1701650d4a69ac0005','系统配置',NULL,'SYSTEM','system/config','glyphicon glyphicon-cog',1,'1','12341','2018-08-06 11:34:17','2018-08-19 09:54:09'),('40289376650d3b1701650d4d2a4e000c','40289376650d3b1701650d4a69ac0005','权限管理',NULL,'authorization','authorization/authmanage','glyphicon glyphicon-filter',5,'1','','2018-08-06 11:34:45','2018-08-19 09:54:50'),('40289376650d3b1701650d4d782c000d','40289376650d3b1701650d4a69ac0005','账号管理',NULL,'ACCOUNT','account/list','glyphicon glyphicon-user',3,'1','','2018-08-06 11:35:05','2018-08-19 09:54:29'),('40289376650d3b1701650d4db950000e','40289376650d3b1701650d4b4c9b0007','字典分类',NULL,'DICCAT_MENU','','fa fa-bookmark',2,'0','','2018-08-06 11:35:22','2018-08-06 11:35:22'),('40289376650d3b1701650d4e0d19000f','40289376650d3b1701650d4b4c9b0007','字典项',NULL,'DICITEM_MENU','','fa fa-bookmark',1,'0','','2018-08-06 11:35:43','2018-08-06 11:35:43'),('40289376650d3b1701650d4e52ba0010','40289376650d3b1701650d4c7e71000a','微信接口',NULL,'WXINTERFACE','','fa fa-bookmark',1,'1','','2018-08-06 11:36:01','2018-08-06 11:36:01'),('40289376650d3b1701650d4e8df70011','40289376650d3b1701650d4c7e71000a','小程序接口',NULL,'SMALLPRO','','fa fa-bookmark',2,'1','','2018-08-06 11:36:16','2018-08-06 11:36:16'),('40289376650d3b1701650d4ed9130012','40289376650d3b1701650d4c7e71000a','微博接口',NULL,'WEBOINTERFACE','','fa fa-bookmark',3,'1','','2018-08-06 11:36:35','2018-08-06 11:36:35'),('40289376650d3b1701650d4f1f6d0013','40289376650d3b1701650d4c7e71000a','自定义接口',NULL,'FREEINTERFACE','','fa fa-bookmark',4,'1','','2018-08-06 11:36:53','2018-08-06 11:36:53'),('4028937665123bc201651253705c0000','40289376650d3b1701650d4a69ac0005','菜单管理',NULL,'RESOURCE','resource/list','glyphicon glyphicon-th-list',2,'1','','2018-08-07 10:59:42','2018-08-19 09:54:21'),('4028937665189b3e0165189c4ae20000','40289376650d3b1701650d49dacf0004','12',NULL,'12','12','2',1,'0','2','2018-08-08 16:17:00','2018-08-08 16:17:00'),('4028937665325d2501653276b4ef0000','40289376650d3b1701650d4a69ac0005','角色管理',NULL,'ROLE','role/list','glyphicon glyphicon-education',4,'1','','2018-08-13 16:46:05','2018-08-19 09:54:40'),('4028937665325d250165327750e40001','40289376650d3b1701650d4a69ac0005','成员管理',NULL,'MEMBER','member/list','glyphicon glyphicon-heart',6,'1','','2018-08-13 16:46:44','2018-08-19 09:54:57'),('4028a881654b51c701654b5596110000','40289376650d3b1701650d47a3b10002','A2',NULL,'A2','2','2',8,'0','2','2018-08-18 12:40:24','2018-08-18 12:40:35'),('4028a881657449d60165744c7cab0000','40289376650d3b1701650d49dacf0004','分类管理',NULL,'category','category/list','glyphicon glyphicon-tags',1,'1','','2018-08-26 11:34:54','2018-08-26 11:34:54'),('4028a881657449d60165744d1fb70001','40289376650d3b1701650d49dacf0004','博文管理',NULL,'blog','blog/myblogs','glyphicon glyphicon-file',3,'1','','2018-08-26 11:35:36','2018-09-10 13:12:03');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
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

/*Data for the table `role` */

insert  into `role`(`ID`,`NAME`,`TYPE`,`CODE`,`STATUS`,`COMMENTS`,`UPDATE_TIME`,`CREATE_TIME`) values ('4028935d65405f70016540611e3e0000','系统管理员','1','ADMIN','1','系统管理员角色','2018-08-16 09:37:11','2018-08-16 09:37:11'),('4028935d65405f7001654063e7d30001','会长','2','MASTER','1','会员协会的会长，主要管理会员协会的会员，组织活动与日常问题的解决','2018-08-18 10:49:03','2018-08-16 09:37:12'),('4028935d654066c00165406810320000','会员','2','MEMBER','1','普通会员角色','2018-08-16 09:44:46','2018-08-16 09:44:46'),('4028935d654066c001654068508f0001','成员','1','1','0','3','2018-08-16 09:45:12','2018-08-16 09:45:02'),('4028935d654066c00165406c53a60002','外部成员','2','OUTMEMBER','1','非系统用户','2018-08-16 09:49:35','2018-08-16 09:49:25'),('4028935d654066c001654079b1c30003','1','1','1','0','1','2018-08-16 10:04:04','2018-08-16 10:04:01'),('4028935d654090c2016540bbefb80001','1','1','1','1','132323232','2018-08-19 10:21:07','2018-08-16 11:16:23'),('4028935d654090c2016540bc0f820002','2','1','2','0','2','2018-09-12 14:36:48','2018-08-16 11:16:31'),('4028935d654090c2016540bc1d670003','3','1','3','1','3','2018-08-16 11:16:34','2018-08-16 11:16:34'),('4028935d654090c2016540bc30620004','44','1','4','1','4','2018-08-16 11:16:39','2018-08-16 11:16:39'),('4028935d654090c2016540bc42470005','5','1','6','1','5','2018-08-16 11:16:44','2018-08-16 11:16:44'),('4028935d654090c2016540bc56aa0006','6','1','5','1','6','2018-08-16 11:16:49','2018-08-16 11:16:49'),('4028935d654090c2016540bc66d80007','7','1','7','0','7','2018-09-12 14:36:52','2018-08-16 11:16:53'),('4028935d654090c2016540bc7b770008','8','1','8','1','8','2018-08-16 11:16:58','2018-08-16 11:16:58'),('4028935d654090c2016540bc8a6d0009','9','1','9','1','9','2018-08-16 11:17:02','2018-08-16 11:17:02'),('4028935d65471a060165473ade190000','11','1','11','1','','2018-08-17 17:32:44','2018-08-17 17:32:44'),('4028935d65471a060165473aee5a0001','111','1','111','1','','2018-08-17 17:32:49','2018-08-17 17:32:49'),('4028935d65471a060165473afd470002','22','1','22','1','','2018-08-17 17:32:52','2018-08-17 17:32:52'),('4028935d65471a060165473b0b650003','33','1','33','1','','2018-08-17 17:32:56','2018-08-17 17:32:56'),('4028935d65471a060165473b19b50004','222','1','222','1','','2018-08-17 17:33:00','2018-08-17 17:33:00'),('4028935d65471a060165473b29810005','333','1','333','1','','2018-08-17 17:33:04','2018-08-17 17:33:04'),('4028935d65471a060165473b38b10006','444','1','444','1','','2018-08-17 17:33:08','2018-08-17 17:33:08'),('4028935d65471a060165473b6c5b0007','4444','1','44444','1','','2018-08-17 17:33:21','2018-08-17 17:33:21'),('4028a881654ff85101654ff9e2140000','1111','1','1111','1','1','2018-08-19 12:49:00','2018-08-19 10:18:21');

/*Table structure for table `sysconfig` */

DROP TABLE IF EXISTS `sysconfig`;

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

/*Data for the table `sysconfig` */

insert  into `sysconfig`(`ID`,`CONFIG_KEY`,`CONFIG_VALUE`,`COMMENTS`,`STATUS`,`CREATE_TIME`,`UPDATE_TIME`) values ('4028935d654090c2016540983a280000','UPLOADPATH','d:\\boot\\upload','d:\\boot\\upload','1','2018-08-16 10:37:22','2018-08-16 14:57:07'),('402893766536fd6201653700e13d0002','DEFAULT_PASSWORD','12345678','默认密码','1','2018-08-14 13:55:29','2018-08-18 12:39:27'),('4028a881658b11d301658b1522030000','COMMENT_SWITCH','1','是否开启评论，0（其他非1值均按照关闭处理）关闭，1开启，关闭评论后评论内容不可见，','1','2018-08-30 21:45:42','2018-08-31 14:58:07'),('4028a881658b11d301658b171dbd0001','COMMENT_CHECK','0','是否开启评论审核，0（其他非1值均按照关闭处理）关闭，1开启，开启审核时，评论进入未发布状态 需要审核后手动发布，发布后才可在页面看到','1','2018-08-30 21:47:52','2018-08-31 15:42:49');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
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

/*Data for the table `user` */

insert  into `user`(`ID`,`NAME`,`REALNAME`,`IDCARD`,`PHONE`,`QQ`,`EMAIL`,`PASSWORD`,`OPENID`,`BIRTHDAY`,`ADDRESS`,`USERTYPE`,`HEADERIMG`,`LASTLOGINTIME`,`STATUS`,`CREATE_TIME`,`UPDATE_TIME`) values ('4028935d657a718501657a8433b40000','系统管理员',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-27',NULL,'0',NULL,'2018-09-12 15:02:39','1','2018-08-27 16:33:29','2018-09-12 15:02:39');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `USER_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ROLE_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_role` */