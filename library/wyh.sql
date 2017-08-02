# Host: localhost  (Version: 5.5.20)
# Date: 2016-12-20 14:55:06
# Generator: MySQL-Front 5.3  (Build 4.89)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "persons"
#

DROP TABLE IF EXISTS `persons`;
CREATE TABLE `persons` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `isgraduate` int(2) NOT NULL DEFAULT '1',
  `major` varchar(100) NOT NULL,
  `telephone` varchar(11) NOT NULL,
  `education` int(11) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

#
# Data for table "persons"
#

INSERT INTO `persons` VALUES (1,'孙悟空',1,'网络','12345678901',1),(31,'wyhlaughing78',1,'经管','19078952143',2);

#
# Structure for table "readers"
#

DROP TABLE IF EXISTS `readers`;
CREATE TABLE `readers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `readername` varchar(32) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `sex` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `profession` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

#
# Data for table "readers"
#

INSERT INTO `readers` VALUES (28,'林浩',21,'男','10012@qq.com','12长安区'),(30,'候杏林',20,'男','04142129@qq.com','student');

#
# Structure for table "tb_books"
#

DROP TABLE IF EXISTS `tb_books`;
CREATE TABLE `tb_books` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `serialnum` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(45) NOT NULL DEFAULT '',
  `price` double NOT NULL DEFAULT '0',
  `bookCount` int(11) unsigned NOT NULL DEFAULT '0',
  `author` varchar(45) NOT NULL DEFAULT '',
  `press` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "tb_books"
#

INSERT INTO `tb_books` VALUES (8,'0ae56','公司法',500,2,'马双红','政法'),(10,'0qw','网络',12,7,'lp','计算机'),(11,'0a123','舒泊尔',23,2,'啊煞笔','邮电出版');

#
# Structure for table "tbl_user"
#

DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Data for table "tbl_user"
#

INSERT INTO `tbl_user` VALUES (1,'xiaoming','123456'),(2,'汪義航','7468095'),(3,'马双红','960109'),(4,'wang','qwer'),(5,'laughing','123'),(6,'qwer','123'),(7,'msh','960109');
