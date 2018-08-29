/*
SQLyog Trial v12.01 (64 bit)
MySQL - 5.7.9 : Database - admin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`admin` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `admin`;

/*Table structure for table `sys_about_site` */

DROP TABLE IF EXISTS `sys_about_site`;

CREATE TABLE `sys_about_site` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL COMMENT '栏目id',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `key_words` varchar(255) DEFAULT NULL COMMENT '关键词',
  `introduction` varchar(1000) DEFAULT NULL COMMENT '简介',
  `content` text NOT NULL COMMENT '正文',
  `thumb` varchar(300) DEFAULT NULL COMMENT '缩略图',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_id` int(11) DEFAULT NULL COMMENT '作者',
  `delf` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记（0-未删除，1-已删除）',
  `hits` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '阅读量',
  `status` varchar(30) NOT NULL DEFAULT '待审核' COMMENT '审核状态（待审核、审核通过、审核不通过、退回修改）',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `sys_about_site` */

insert  into `sys_about_site`(`id`,`category_id`,`title`,`key_words`,`introduction`,`content`,`thumb`,`create_time`,`update_time`,`user_id`,`delf`,`hits`,`status`) values (10,1,'习近平：在深入推动长江经济带发展座谈会上的讲话',NULL,NULL,'<p>　　这次座谈会是我主持召开的第二次长江经济带发展座谈会。上一次是2016年1月在长江上游的重庆召开，这一次放在长江中游的武汉召开。</p><p><br/></p><p>　　推动长江经济带发展是党中央作出的重大决策，是关系国家发展全局的重大战略，对实现“两个一百年”奋斗目标、实现中华民族伟大复兴的中国梦具有重要意义。</p><p><br/></p><p>　　总体上看，实施长江经济带发展战略要加大力度。这是我这次调研和召开座谈会的目的。这几天，我先后到宜昌、荆州、岳阳、武汉以及三峡坝区等地，考察了企业转型发展、化工企业搬迁、非法码头整治、污染治理、河势控制和护岸工程、航道治理、湿地修复、水文站水文监测工作等方面的情况，还到乡村、企业、社区等地作了调研，沿途听取了湖北、湖南有关负责同志关于本省参与长江经济带发展的情况汇报。刚才，又听取了国家发展改革委、生态环境部、交通运输部、水利部负责同志和部分省市负责同志的发言，韩正同志也作了讲话。下面，结合调研情况和同志们的发言，我就3个问题讲点意见。</p><p><br/></p>','','2018-06-13 20:53:24','2018-06-13 20:53:24',1,0,1,'待审核'),(11,1,'习近平同巴拿马总统互致贺函 庆祝中巴建交一周年',NULL,NULL,'<p>　　习近平在贺函中指出，去年6月，中国同巴拿马正式建立外交关系，开启了两国关系新纪元。去年11月，你成功对中国进行国事访问，我们就中巴关系全面发展进行共同探讨和规划。在双方精心培育下，中巴关系发展的种子正在开花结果。事实证明，中巴建交是双方登高望远作出的正确政治决断，得到两国人民一致拥护。我高度重视中巴关系发展，愿同你一道努力，本着相互尊重、合作共赢、共同发展的原则，加强各领域互利合作，使中巴关系枝繁叶茂，造福两国和两国人民。<br/></p><p><br/></p><p>　　巴雷拉在贺函中表示，一年来，巴中在传统友谊和既有合作基础上，达成重要共识，取得丰硕成果。在此背景下，双方迎来建交一周年的历史性时刻。我对亲身参与巴中关系开局起步深感自豪，将继续满怀热情地致力于从最广泛领域加强巴中关系。</p><p><br/></p>','public/uploads/20180613/2018061354693728.png','2018-06-13 22:12:01','2018-06-13 22:12:01',1,0,1,'待审核');

/*Table structure for table `sys_goods` */

DROP TABLE IF EXISTS `sys_goods`;

CREATE TABLE `sys_goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `category_id` int(11) DEFAULT NULL COMMENT '所属类别id',
  `goods_name` varchar(255) DEFAULT '' COMMENT '商品名称',
  `nickname` varchar(255) DEFAULT NULL COMMENT '别名',
  `thumb` varchar(255) DEFAULT '' COMMENT '商品主图',
  `del_state` tinyint(4) DEFAULT '2' COMMENT '删除 1是 2否',
  `simple_describe` varchar(255) DEFAULT '' COMMENT '简要描述',
  `detail_describe` text COMMENT '详细描述',
  `is_marketable` tinyint(4) DEFAULT '0' COMMENT '上架标志 1 已上架 0 未上架',
  `recommend` tinyint(4) DEFAULT '2' COMMENT '推荐 1是 2否',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 COMMENT='商品表';

/*Data for the table `sys_goods` */

insert  into `sys_goods`(`goods_id`,`category_id`,`goods_name`,`nickname`,`thumb`,`del_state`,`simple_describe`,`detail_describe`,`is_marketable`,`recommend`,`create_time`,`update_time`,`admin_id`) values (69,3,'粉红豹毛绒公仔 情人节礼物生日',NULL,'uploads/20180608/2018060853108629.png',2,'名创优品（MINISO）粉红豹毛绒公仔 情人节礼物生日','<p>名创优品（MINISO）粉红豹毛绒公仔 情人节礼物生日送礼 顽皮豹大号布偶娃娃 经典慵懒款（高度54cm）</p>',1,2,'2018-06-08 20:26:15',NULL,1),(70,1,'混色混图案 驱蚊液80ml混色',NULL,'uploads/20180608/2018060815390784.png',2,'','<p>名创优品（MINISO） 咱们裸熊系列驱蚊扣/驱蚊液/驱蚊手环/驱蚊贴 混色混图案 驱蚊液80ml混色（随机发货）</p><p><img src=\"http://localhost:8081/ueditor/jsp/upload/image/20180608/1528460858522057352.jpg\" title=\"1528460858522057352.jpg\" alt=\"5b101158N2c945680.jpg\"/></p>',1,2,'2018-06-08 20:27:40',NULL,1),(71,2,'aaa 青岛上合峰会',NULL,'/public/uploads/20180608/2018060842176803.png',2,'dfsf 上合','<p>sdfsdf</p><p>上合峰会</p>',1,2,'2018-06-08 21:53:18','2018-06-09 23:01:34',1),(76,1,'bb修改后标题',NULL,'',2,'简要bbupdate','<p>sfsdff</p><p>update</p><p>正文</p>',1,2,'2018-06-09 22:55:10',NULL,1),(77,1,'bb标题',NULL,'',2,'测试bb','<p>sfsdff</p><p>测试内容</p>',1,2,'2018-06-09 22:57:59',NULL,1),(78,1,'aaaimya 标题',NULL,'public/uploads/20180609/2018060916032854.png',2,'dfsf描述','<p>sdfsdf</p><p>风之谷</p>',1,2,'2018-06-09 22:59:13','2018-06-09 23:08:10',1),(81,2,'reeeee',NULL,'',2,'rrrr','<p>sdfsdf</p>',1,2,'2018-06-12 22:52:37',NULL,1),(82,2,'reeeee5533',NULL,'',2,'rrrr','<p>sdfsdf5</p>',1,2,'2018-06-12 22:53:10','2018-06-12 22:57:21',1),(83,3,'dddd555',NULL,'public/uploads/20180612/2018061236587012.png',2,'ffff35','<p>fddd3555</p>',2,2,'2018-06-12 22:54:49','2018-06-12 23:10:37',1),(84,6,'入推动长江经济带发展座谈会并发表重要讲',NULL,'',2,'4月26日下午，中共中央总书记、国家主席、中央军委主席习近平在武汉主持召开深入推动长江经济带发展座谈会并发表重要讲话。','<p>　　这次座谈会是我主持召开的第二次长江经济带发展座谈会。上一次是2016年1月在长江上游的重庆召开，这一次放在长江中游的武汉召开。</p><p><br/></p><p>　　推动长江经济带发展是党中央作出的重大决策，是关系国家发展全局的重大战略，对实现“两个一百年”奋斗目标、实现中华民族伟大复兴的中国梦具有重要意义。</p><p><br/></p><p>　　总体上看，实施长江经济带发展战略要加大力度。这是我这次调研和召开座谈会的目的。这几天，我先后到宜昌、荆州、岳阳、武汉以及三峡坝区等地，考察了企业转型发展、化工企业搬迁、非法码头整治、污染治理、河势控制和护岸工程、航道治理、湿地修复、水文站水文监测工作等方面的情况，还到乡村、企业、社区等地作了调研，沿途听取了湖北、湖南有关负责同志关于本省参与长江经济带发展的情况汇报。刚才，又听取了国家发展改革委、生态环境部、交通运输部、水利部负责同志和部分省市负责同志的发言，韩正同志也作了讲话。下面，结合调研情况和同志们的发言，我就3个问题讲点意见。</p><p><br/></p>',1,2,'2018-06-13 20:27:49','2018-06-13 23:21:16',1),(85,1,'sdfffrrr',NULL,'public/uploads/20180829/2018082923794580.png',2,'sdfsd','<p>vxcv</p><p><img src=\"http://localhost:8081/ueditor/jsp/upload/image/20180829/1535521939727027355.jpg\" title=\"1535521939727027355.jpg\" alt=\"5b101158N2c945680.jpg\"/></p>',1,2,'2018-08-29 13:52:23','2018-08-29 14:08:21',NULL);

/*Table structure for table `sys_goods_category` */

DROP TABLE IF EXISTS `sys_goods_category`;

CREATE TABLE `sys_goods_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品种类id',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父种类id 为零表示顶层种类',
  `category_name` varchar(255) DEFAULT NULL COMMENT '商品种类名称',
  `image` varchar(255) DEFAULT NULL COMMENT '商品种类主图',
  `state` tinyint(4) DEFAULT '2' COMMENT '状态 1.启用 2.未启用 3 已删除',
  `simple_describe` varchar(255) DEFAULT NULL COMMENT '简要描述',
  `recommend` tinyint(4) DEFAULT '2' COMMENT '推荐标志 1是 2否',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `admin_id` int(11) DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='商品种类表';

/*Data for the table `sys_goods_category` */

insert  into `sys_goods_category`(`category_id`,`parent_id`,`category_name`,`image`,`state`,`simple_describe`,`recommend`,`create_time`,`update_time`,`admin_id`) values (1,0,'T恤',NULL,1,'T恤衫是春夏季人们最喜欢的服装之一，特别是烈日炎炎，酷暑难耐的盛夏，T恤衫以其自然、舒适、潇洒又不失庄重之感的优点而逐步替代昔日男士们穿件背心或汗衫 ...',NULL,'2018-06-13 22:35:50',NULL,1),(2,0,'休闲裤系列',NULL,NULL,'休闲裤系列休闲裤系列',NULL,'2018-06-13 22:50:40',NULL,1),(3,2,'aaa',NULL,NULL,'aa',NULL,'2018-06-13 22:50:57',NULL,1),(4,1,'ccc',NULL,1,'cc',NULL,'2018-06-13 23:08:17',NULL,1),(5,0,'休闲裤系列',NULL,1,'休闲裤',NULL,'2018-06-13 23:08:48',NULL,1),(6,5,'aa',NULL,1,'aaaa',NULL,'2018-06-13 23:09:00',NULL,1),(7,1,'dd',NULL,3,'dd',NULL,'2018-06-13 23:09:15',NULL,1),(8,0,'tt',NULL,1,'tt',NULL,'2018-08-29 13:26:22',NULL,NULL);

/*Table structure for table `sys_goods_price` */

DROP TABLE IF EXISTS `sys_goods_price`;

CREATE TABLE `sys_goods_price` (
  `price_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品规格价格id',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `unit_name` varchar(255) DEFAULT NULL COMMENT '计量单位',
  `retail_price` int(11) DEFAULT NULL COMMENT '零售价（以分为单位）',
  `buy_price` int(11) DEFAULT NULL COMMENT '采购价（以分为单位）',
  `wholesale_price` int(11) DEFAULT NULL COMMENT '批发价（以分为单位）',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态：1.启用 2.未启用 （后台未启用页面不显示，前台显示已下架）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `admin_id` int(11) DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`price_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品规格价格';

/*Data for the table `sys_goods_price` */

insert  into `sys_goods_price`(`price_id`,`goods_id`,`unit_name`,`retail_price`,`buy_price`,`wholesale_price`,`state`,`create_time`,`update_time`,`admin_id`) values (1,83,NULL,33,NULL,NULL,NULL,'2018-06-12 22:55:01','2018-06-12 22:55:01',1),(2,84,NULL,7,NULL,NULL,NULL,'2018-06-13 20:27:49',NULL,1),(3,85,NULL,7,NULL,NULL,NULL,'2018-06-13 23:17:44',NULL,1);

/*Table structure for table `sys_login` */

DROP TABLE IF EXISTS `sys_login`;

CREATE TABLE `sys_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `last_login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_login` */

insert  into `sys_login`(`id`,`user_id`,`last_login_time`) values (1,1,'2017-09-12 14:01:18'),(2,1,'2017-09-12 14:03:22'),(3,1,'2017-09-12 15:21:37'),(4,1,'2017-09-12 15:23:01'),(5,1,'2017-09-12 16:18:42'),(6,1,'2017-09-12 16:30:12'),(7,1,'2017-09-12 16:32:36'),(8,1,'2017-09-12 16:37:04'),(9,1,'2017-09-12 16:42:10'),(10,1,'2017-09-12 16:49:19'),(11,1,'2017-09-12 16:52:35'),(12,1,'2017-09-12 16:53:39'),(13,1,'2017-09-12 16:57:32'),(14,1,'2017-09-12 16:59:54'),(15,1,'2017-09-12 17:11:51'),(16,1,'2017-09-12 17:14:30'),(17,1,'2017-09-12 17:21:53'),(18,1,'2017-09-12 17:24:29'),(19,1,'2017-09-12 17:26:26'),(20,1,'2017-09-12 17:28:06'),(21,1,'2017-09-12 17:30:28'),(22,1,'2017-09-12 17:32:43'),(23,1,'2017-09-12 17:34:18'),(24,1,'2017-09-12 17:35:28'),(25,1,'2017-09-12 17:36:40'),(26,1,'2017-09-12 17:38:40'),(27,1,'2017-09-12 17:40:51'),(28,1,'2017-09-12 18:03:00'),(29,1,'2017-09-12 18:04:27'),(30,1,'2017-09-12 18:06:45'),(31,1,'2017-09-12 18:08:10'),(32,1,'2017-09-12 18:08:52'),(33,1,'2017-09-13 09:36:28'),(34,1,'2017-09-13 10:48:35'),(35,1,'2017-09-13 14:22:42'),(36,1,'2017-09-13 14:33:55'),(37,1,'2017-09-13 14:44:09'),(38,1,'2017-09-13 14:48:59'),(39,1,'2017-09-13 14:51:34'),(40,1,'2017-09-13 15:44:01'),(41,1,'2017-09-13 16:20:27'),(42,1,'2017-09-13 16:54:21'),(43,1,'2017-09-13 17:18:29'),(44,1,'2017-09-13 17:24:04'),(45,1,'2017-09-13 17:52:36'),(46,1,'2017-09-13 17:53:24'),(47,1,'2017-09-13 17:55:38'),(48,1,'2017-09-13 18:04:03'),(49,1,'2017-09-13 18:05:19'),(50,1,'2017-09-14 09:55:05'),(51,1,'2017-09-14 11:32:29'),(52,2,'2017-09-14 13:51:45'),(53,1,'2017-09-14 13:52:20'),(54,3,'2017-09-14 13:58:08'),(55,1,'2017-09-14 13:58:21'),(56,1,'2017-09-14 14:11:56'),(57,2,'2017-09-14 14:12:54'),(58,1,'2017-09-14 14:14:41'),(59,1,'2017-09-14 14:20:34'),(60,1,'2017-09-14 14:21:57'),(61,1,'2017-09-14 14:23:02'),(62,1,'2017-09-14 14:28:06'),(63,3,'2017-09-14 14:28:45'),(64,2,'2017-09-14 14:29:51'),(65,3,'2017-09-14 14:30:14'),(66,1,'2017-09-14 15:44:24'),(67,1,'2017-09-14 15:45:34'),(68,1,'2017-09-14 17:15:09'),(69,12,'2017-09-14 17:17:40'),(70,1,'2017-09-14 17:26:48'),(71,1,'2017-09-14 17:34:04'),(72,1,'2017-09-14 17:52:57'),(73,1,'2018-05-30 10:03:15'),(74,1,'2018-05-30 13:39:14'),(75,1,'2018-05-30 14:04:10'),(76,1,'2018-05-30 14:09:46'),(77,1,'2018-05-30 16:53:21'),(78,1,'2018-05-30 17:42:22'),(79,1,'2018-05-30 18:33:31'),(80,1,'2018-05-31 17:40:06'),(81,1,'2018-05-31 22:26:11'),(82,1,'2018-05-31 22:27:08'),(83,1,'2018-05-31 22:29:04'),(84,1,'2018-05-31 22:49:04'),(85,1,'2018-05-31 22:54:30'),(86,1,'2018-06-01 09:42:51'),(87,1,'2018-06-07 11:16:12'),(88,1,'2018-06-07 11:19:15'),(89,1,'2018-06-07 16:05:03'),(90,1,'2018-06-07 17:13:53'),(91,1,'2018-06-07 17:14:47'),(92,1,'2018-06-07 17:33:38'),(93,1,'2018-06-07 18:06:31'),(94,1,'2018-06-07 18:31:25'),(95,1,'2018-06-08 09:37:31'),(96,1,'2018-06-08 09:40:28'),(97,1,'2018-06-08 09:49:37'),(98,1,'2018-06-08 09:52:12'),(99,1,'2018-06-08 09:54:48'),(100,1,'2018-06-08 09:56:42'),(101,1,'2018-06-08 10:32:44'),(102,1,'2018-06-08 11:02:20'),(103,1,'2018-06-08 11:16:48'),(104,1,'2018-06-08 11:28:43'),(105,1,'2018-06-08 11:34:53'),(106,1,'2018-06-08 11:36:17'),(107,1,'2018-06-08 11:39:30'),(108,1,'2018-06-08 11:42:56'),(109,1,'2018-06-08 14:26:03'),(110,1,'2018-06-08 14:27:34'),(111,1,'2018-06-08 14:37:02'),(112,1,'2018-06-08 14:45:32'),(113,1,'2018-06-08 16:00:37'),(114,1,'2018-06-08 16:09:15'),(115,1,'2018-06-08 16:12:41'),(116,1,'2018-06-08 16:18:46'),(117,1,'2018-06-08 16:23:41'),(118,1,'2018-06-08 16:27:35'),(119,1,'2018-06-08 16:34:24'),(120,1,'2018-06-08 16:38:31'),(121,1,'2018-06-08 16:58:22'),(122,1,'2018-06-08 17:47:27'),(123,1,'2018-06-08 18:07:20'),(124,1,'2018-06-08 18:09:24'),(125,1,'2018-06-08 19:07:47'),(126,1,'2018-06-08 20:09:06'),(127,1,'2018-06-08 20:23:26'),(128,1,'2018-06-08 20:48:04'),(129,1,'2018-06-08 20:49:00'),(130,1,'2018-06-08 21:14:39'),(131,1,'2018-06-08 21:15:47'),(132,1,'2018-06-08 21:40:41'),(133,1,'2018-06-08 21:41:50'),(134,1,'2018-06-08 21:44:42'),(135,1,'2018-06-08 21:47:19'),(136,1,'2018-06-08 21:53:00'),(137,1,'2018-06-08 21:56:12'),(138,1,'2018-06-08 21:58:02'),(139,1,'2018-06-09 22:37:51'),(140,1,'2018-06-09 22:49:24'),(141,1,'2018-06-09 22:54:50'),(142,1,'2018-06-09 22:58:33'),(143,1,'2018-06-09 23:29:14'),(144,1,'2018-06-10 00:07:50'),(145,1,'2018-06-12 10:03:08'),(146,1,'2018-06-12 18:34:12'),(147,1,'2018-06-12 22:24:17'),(148,1,'2018-06-12 22:24:17'),(149,1,'2018-06-12 22:27:06'),(150,1,'2018-06-12 22:27:06'),(151,1,'2018-06-12 22:46:21'),(152,1,'2018-06-12 22:49:17'),(153,1,'2018-06-12 22:52:18'),(154,1,'2018-06-12 22:54:33'),(155,1,'2018-06-12 22:57:04'),(156,1,'2018-06-12 23:01:06'),(157,1,'2018-06-12 23:05:37'),(158,1,'2018-06-12 23:09:06'),(159,1,'2018-06-12 23:10:29'),(160,1,'2018-06-13 11:26:09'),(161,1,'2018-06-13 11:26:58'),(162,1,'2018-06-13 11:48:21'),(163,1,'2018-06-13 13:49:08'),(164,1,'2018-06-13 14:03:39'),(165,1,'2018-06-13 14:04:55'),(166,1,'2018-06-13 14:18:46'),(167,1,'2018-06-13 14:20:21'),(168,1,'2018-06-13 14:22:00'),(169,1,'2018-06-13 14:24:45'),(170,1,'2018-06-13 14:25:46'),(171,1,'2018-06-13 14:29:08'),(172,1,'2018-06-13 14:31:45'),(173,1,'2018-06-13 14:34:11'),(174,1,'2018-06-13 14:43:08'),(175,1,'2018-06-13 15:24:54'),(176,1,'2018-06-13 16:03:13'),(177,1,'2018-06-13 17:49:38'),(178,1,'2018-06-13 20:21:11'),(179,1,'2018-06-13 20:26:07'),(180,1,'2018-06-13 20:50:03'),(181,1,'2018-06-13 20:53:08'),(182,1,'2018-06-13 20:57:55'),(183,1,'2018-06-13 21:00:03'),(184,1,'2018-06-13 22:04:57'),(185,1,'2018-06-13 22:09:36'),(186,1,'2018-06-13 22:16:27'),(187,1,'2018-06-13 22:31:55'),(188,1,'2018-06-13 22:38:21'),(189,1,'2018-06-13 22:39:20'),(190,1,'2018-06-13 22:46:34'),(191,1,'2018-06-13 22:55:24'),(192,1,'2018-06-13 23:04:22'),(193,1,'2018-06-13 23:07:42'),(194,1,'2018-06-13 23:12:43'),(195,1,'2018-06-13 23:17:27'),(196,1,'2018-06-13 23:19:31'),(197,1,'2018-06-14 10:45:18'),(198,1,'2018-06-14 10:49:31'),(199,1,'2018-06-14 10:51:23'),(200,1,'2018-06-14 10:52:36'),(201,1,'2018-06-14 10:58:50'),(202,1,'2018-06-14 11:01:50'),(203,1,'2018-06-14 11:08:43'),(204,1,'2018-06-14 11:16:35'),(205,1,'2018-08-02 18:04:18');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `menu_name` varchar(50) DEFAULT NULL,
  `menu_url` varchar(50) DEFAULT '#',
  `menu_type` enum('2','1') DEFAULT '2' COMMENT '1 -- 系统菜单，2 -- 业务菜单',
  `menu_icon` varchar(50) DEFAULT '#',
  `sort_num` int(11) DEFAULT '1',
  `user_id` int(11) DEFAULT '1' COMMENT '创建这个菜单的用户id',
  `is_del` int(11) DEFAULT '0' COMMENT '1-- 删除状态，0 -- 正常',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`parent_id`,`menu_name`,`menu_url`,`menu_type`,`menu_icon`,`sort_num`,`user_id`,`is_del`,`update_time`,`create_time`) values (1,0,'公司新闻','pro/category/1',NULL,NULL,1,1,0,'2018-06-13 20:21:37','2018-06-08 20:23:57'),(2,0,'网站简介','pro/category/2',NULL,NULL,2,1,0,'2018-06-13 20:22:08','2018-06-08 20:24:20'),(3,1,'子类一','pro/category/3',NULL,NULL,4,1,1,'2018-06-13 20:22:22','2018-06-08 20:24:45'),(4,0,'测试菜单1','11',NULL,NULL,1,1,1,'2018-06-13 22:06:05','2018-06-13 22:05:43'),(5,0,'测试腰间2','2',NULL,NULL,2,1,1,'2018-06-13 22:09:48','2018-06-13 22:05:51');

/*Table structure for table `sys_order` */

DROP TABLE IF EXISTS `sys_order`;

CREATE TABLE `sys_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_number` varchar(255) DEFAULT '' COMMENT '订单号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `total_amount` int(11) DEFAULT NULL COMMENT '订单总金额(以分为单位)',
  `paid_amount` int(11) DEFAULT NULL COMMENT '实付金额',
  `discount_amount` int(11) DEFAULT NULL COMMENT '优惠金额',
  `receive_id` int(11) DEFAULT NULL COMMENT '收货id',
  `send_time` datetime DEFAULT NULL COMMENT '发货时间',
  `logistics_state` tinyint(4) DEFAULT '1' COMMENT '配送状态 1 待待配 2  已配送 3 已确认收货',
  `invoice_tag` tinyint(4) DEFAULT '0' COMMENT '开具发票标志 0 否 1 是',
  `del_state` tinyint(4) DEFAULT '2' COMMENT '删除 1是 2否',
  `payment_id` int(11) DEFAULT NULL COMMENT '支付方式id',
  `payment_seq` varchar(255) DEFAULT NULL COMMENT '在线支付流水号',
  `pay_state` tinyint(3) unsigned DEFAULT '1' COMMENT '支付状态 1.未付款 2 已付款',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注说明',
  `create_time` datetime DEFAULT NULL COMMENT '下单时间',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

/*Data for the table `sys_order` */

/*Table structure for table `sys_order_certify` */

DROP TABLE IF EXISTS `sys_order_certify`;

CREATE TABLE `sys_order_certify` (
  `certify_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收款凭证id，主键',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `order_number` varchar(255) DEFAULT NULL COMMENT '订单号',
  `image_url` varchar(255) DEFAULT NULL COMMENT '订单凭证',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `admin_id` int(11) DEFAULT NULL COMMENT '管理员id',
  PRIMARY KEY (`certify_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单收款凭证表';

/*Data for the table `sys_order_certify` */

/*Table structure for table `sys_order_details` */

DROP TABLE IF EXISTS `sys_order_details`;

CREATE TABLE `sys_order_details` (
  `order_details_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单详情id',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `order_number` varchar(255) DEFAULT '' COMMENT '订单号',
  `price_id` int(11) DEFAULT NULL COMMENT '商品规格价格id',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `unit_name` varchar(255) DEFAULT NULL COMMENT '商品规格名称',
  `goods_name` varchar(255) DEFAULT '' COMMENT '商品名称',
  `unit_price` int(11) DEFAULT NULL COMMENT '商品规格价格(以分为单位)',
  `num` int(11) DEFAULT NULL COMMENT '个数',
  `details_amount` int(11) DEFAULT NULL COMMENT '订单单品总价(以分为单位)',
  `create_time` datetime DEFAULT NULL,
  `image` varchar(255) DEFAULT '' COMMENT '商品主图',
  PRIMARY KEY (`order_details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单单品表';

/*Data for the table `sys_order_details` */

/*Table structure for table `sys_order_join` */

DROP TABLE IF EXISTS `sys_order_join`;

CREATE TABLE `sys_order_join` (
  `join_order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增1',
  `join_order_number` varchar(255) DEFAULT NULL COMMENT '合并订单号',
  `order_ids` varchar(255) DEFAULT NULL COMMENT '订单id',
  `order_numbers` text COMMENT '订单号',
  `total_price` int(11) DEFAULT NULL COMMENT '订单总金额(以分为单位)',
  PRIMARY KEY (`join_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_order_join` */

/*Table structure for table `sys_payment_method` */

DROP TABLE IF EXISTS `sys_payment_method`;

CREATE TABLE `sys_payment_method` (
  `payment_id` int(11) NOT NULL COMMENT '支付方式id，手动维护',
  `name` varchar(255) DEFAULT NULL COMMENT '支付方式名称',
  `description` varchar(255) DEFAULT NULL,
  `isGeneral` tinyint(4) NOT NULL COMMENT '是否通用 1 是 0 否',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `state` tinyint(4) DEFAULT '2' COMMENT '1 已删除 2 未删除',
  PRIMARY KEY (`payment_id`,`isGeneral`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_payment_method` */

insert  into `sys_payment_method`(`payment_id`,`name`,`description`,`isGeneral`,`create_time`,`update_time`,`state`) values (1,'货到付款','货到付款',0,'2017-03-23 16:49:23','2017-03-23 16:49:23',2),(2,'在线支付','在线支付',1,'2017-03-23 16:50:20','2017-03-23 16:50:20',2),(3,'累计结算','累计结算',0,'2017-03-23 16:50:27','2017-03-23 16:50:27',2);

/*Table structure for table `sys_privilege` */

DROP TABLE IF EXISTS `sys_privilege`;

CREATE TABLE `sys_privilege` (
  `privilege_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '优惠id，主键，自增',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `is_wholeSalePrice` tinyint(4) DEFAULT '0' COMMENT '享受批发价标志 1 享受批发价 0 不享受批发价',
  `isDiscount` tinyint(4) DEFAULT NULL COMMENT '是否享受折扣 1 是 0 否',
  `discount` int(11) DEFAULT NULL COMMENT '商品折扣 使用整数表示折扣数，比如98，表示98折',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `state` tinyint(4) DEFAULT '2' COMMENT '状态 1 已删除 2 未删除',
  `admin_id` int(11) DEFAULT NULL COMMENT '管理员id',
  PRIMARY KEY (`privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠信息';

/*Data for the table `sys_privilege` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `role_desc` varchar(255) DEFAULT NULL,
  `rights` varchar(255) DEFAULT '0' COMMENT '最大权限的值',
  `add_qx` varchar(255) DEFAULT '0',
  `del_qx` varchar(255) DEFAULT '0',
  `edit_qx` varchar(255) DEFAULT '0',
  `query_qx` varchar(255) DEFAULT '0',
  `user_id` varchar(10) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `addqx` varchar(255) DEFAULT NULL,
  `delqx` varchar(255) DEFAULT NULL,
  `editqx` varchar(255) DEFAULT NULL,
  `queryqx` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`role_desc`,`rights`,`add_qx`,`del_qx`,`edit_qx`,`query_qx`,`user_id`,`create_time`,`addqx`,`delqx`,`editqx`,`queryqx`) values (1,'ROLE_ADMIN','管理员权限','1267650600228229401496703205375','1','1','126','126','1','2018-08-28 17:24:30',NULL,NULL,NULL,NULL),(2,'ROLE_USER','随便创建的随便创建的随便创建的随便创建的随便创建的随便创建的随便创建的随便创建的随便创建的随便创建的','94','2','1','4','126','1','2018-08-28 17:24:39',NULL,NULL,NULL,NULL),(3,'role_test','是测试角色这个是测试角色这个是测试角色这个是测试角色这个是测试角色','382','382','382','382','126','1','2018-08-24 19:05:35',NULL,NULL,NULL,NULL);

/*Table structure for table `sys_short_message` */

DROP TABLE IF EXISTS `sys_short_message`;

CREATE TABLE `sys_short_message` (
  `message_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) DEFAULT '' COMMENT '手机号',
  `code` int(255) DEFAULT '0' COMMENT '验证码',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `state` tinyint(4) DEFAULT '1' COMMENT '短信验证码是否可用  1 可用 2 不可用',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信验证码';

/*Data for the table `sys_short_message` */

/*Table structure for table `sys_store_goods` */

DROP TABLE IF EXISTS `sys_store_goods`;

CREATE TABLE `sys_store_goods` (
  `store_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `state` tinyint(4) DEFAULT '2' COMMENT '状态 1 已删除 2 未删除',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户收藏商品表';

/*Data for the table `sys_store_goods` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `pic_path` varchar(200) DEFAULT '/images/logo.png',
  `status` enum('unlock','lock') DEFAULT 'unlock',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`username`,`nick_name`,`password`,`pic_path`,`status`,`create_time`) values (1,'admin','管理员','86f7e437faa5a7fce15d1ddcb9eaeaea377667b8','http://www.lrshuai.top/upload/user/20170612/05976238.png','unlock','2017-08-18 13:57:32'),(2,'tyro','tyro','86f7e437faa5a7fce15d1ddcb9eaeaea377667b8','/upload/show/user/82197046.png','unlock','2017-09-12 14:03:39'),(3,'asdf','asdf','3da541559918a808c2402bba5012f6c60b27661c','/upload/show/user/85610497.png','unlock','2017-09-13 14:49:10'),(13,'nathan','nath','86f7e437faa5a7fce15d1ddcb9eaeaea377667b8','/upload/show/user/82409756.png','unlock','2018-05-30 13:41:20'),(15,'nathaaacc','南京','e0c9035898dd52fc65c41454cec9c4d2611bfb37','/images/logo.png','unlock',NULL),(16,'root','linxuroot','86f7e437faa5a7fce15d1ddcb9eaeaea377667b8','/images/logo.png','unlock','2018-06-14 11:04:27'),(17,'abcd','aa','7b21848ac9af35be0ddb2d6b9fc3851934db8420','/images/logo.png','unlock','2018-06-14 11:05:32'),(19,'test','测试账号','a94a8fe5ccb19ba61c4c0873d391e987982fbbd3','/images/logo.png','lock','2018-06-14 11:08:51');

/*Table structure for table `sys_user_message` */

DROP TABLE IF EXISTS `sys_user_message`;

CREATE TABLE `sys_user_message` (
  `user_message_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增1',
  `message_id` int(11) DEFAULT NULL COMMENT '消息id',
  `user_id` int(11) DEFAULT NULL,
  `state` tinyint(4) DEFAULT '2' COMMENT '状态 1 已读 2 未读',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_state` tinyint(4) DEFAULT '2' COMMENT '删除状态 1 已删除 2 未删除',
  PRIMARY KEY (`user_message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户站内消息表';

/*Data for the table `sys_user_message` */

/*Table structure for table `sys_user_payment` */

DROP TABLE IF EXISTS `sys_user_payment`;

CREATE TABLE `sys_user_payment` (
  `user_payment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增1',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `payment_id` int(11) DEFAULT NULL COMMENT '支付方式id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `admin_id` int(11) DEFAULT NULL COMMENT '管理员id',
  PRIMARY KEY (`user_payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_payment` */

/*Table structure for table `sys_user_receive` */

DROP TABLE IF EXISTS `sys_user_receive`;

CREATE TABLE `sys_user_receive` (
  `receive_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收货id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `contact` varchar(255) DEFAULT '' COMMENT '收货人姓名',
  `tel` varchar(255) DEFAULT '' COMMENT '收货人电话',
  `receive_province` varchar(255) DEFAULT '' COMMENT '收货地址：省',
  `receive_city` varchar(255) DEFAULT '' COMMENT '收货地址：城市',
  `receive_county` varchar(255) DEFAULT '' COMMENT '收货地址：县/区',
  `receive_address` varchar(255) DEFAULT '' COMMENT '收货地址 详细地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `isDefault` tinyint(4) DEFAULT '0' COMMENT '默认收货地址标志 0 否 1 是',
  `del_state` tinyint(4) DEFAULT '2' COMMENT '删除状态 1 已删除 2 未删除',
  PRIMARY KEY (`receive_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='送货表';

/*Data for the table `sys_user_receive` */

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`,`create_time`) values (1,1,1,'2017-08-18 14:45:43'),(2,2,3,'2017-09-08 17:12:58'),(13,3,3,'2017-09-14 14:30:02'),(15,13,2,'2018-05-30 13:41:33');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
