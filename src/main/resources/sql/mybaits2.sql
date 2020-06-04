/*
SQLyog Ultimate v10.00 Beta1
MySQL - 8.0.18 : Database - mybaits2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybaits2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mybaits2`;

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `shipinid` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `comments` */

insert  into `comments`(`id`,`text`,`time`,`userid`,`shipinid`,`username`) values (1,'one more thing, it is expensiveQAQ',NULL,1,3,'fanfan'),(2,'I think it is wonderful hahahah',NULL,2,3,'fanfan2'),(3,'wonderful',NULL,2,3,'fanfan2'),(4,'I like that!!!',NULL,1,1,'fanfan'),(5,'aaaaa!!!',NULL,5,11,'fanfan12345'),(6,'good',NULL,1,11,'fanfan'),(7,'aaaaa',NULL,8,13,'fanfan12345'),(8,'i like it',NULL,9,1,'andy'),(9,'good!',NULL,1,7,'fanfan'),(10,'a!',NULL,1,9,'fanfan');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`departmentName`) values (1,'AA'),(2,' aa');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int(2) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`lastName`,`email`,`gender`,`d_id`) values (1,'fan','aa',0,22);

/*Table structure for table `shipins` */

DROP TABLE IF EXISTS `shipins`;

CREATE TABLE `shipins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(600) DEFAULT NULL,
  `name` varchar(600) DEFAULT NULL,
  `lujing` varchar(600) DEFAULT NULL,
  `content` text,
  `view` int(11) NOT NULL DEFAULT '0',
  `topicid` int(11) DEFAULT NULL,
  `topictext` varchar(250) DEFAULT 'others',
  `userid` int(11) DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `commentnums` int(11) DEFAULT '0',
  `likenums` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `shipins` */

insert  into `shipins`(`id`,`url`,`name`,`lujing`,`content`,`view`,`topicid`,`topictext`,`userid`,`username`,`commentnums`,`likenums`) values (1,'http://localhost:8080/images/20200308102949_火锅.jpg','20200308102949_火锅.jpg','C:/upload/20200308102949_火锅.jpg','good!!',3,1,'meals',1,'fanfan',2,0),(2,'http://localhost:8080/images/20200308103007_泡面.jpg','20200308103007_泡面.jpg','C:/upload/20200308103007_泡面.jpg','also good!!',0,5,NULL,1,'fanfan',0,0),(3,'http://localhost:8080/images/20200308103048_haochi.jpg','20200308103048_haochi.jpg','C:/upload/20200308103048_haochi.jpg','sUSHI!! I hope anyone can try!',4,5,NULL,1,'fanfan',3,0),(4,'http://localhost:8080/images/20200308103339_下载 (1).jpg','20200308103339_下载 (1).jpg','C:/upload/20200308103339_下载 (1).jpg','this is a good one',0,5,NULL,2,'fanfan2',0,0),(5,'http://localhost:8080/images/20200308103415_下载 (1).jpg','20200308103415_下载 (1).jpg','C:/upload/20200308103415_下载 (1).jpg','I like that hahah',0,5,NULL,2,'fanfan2',0,0),(6,'http://localhost:8080/images/20200308103436_','20200308103436_','C:/upload/20200308103436_','a!!',0,4,'others',NULL,NULL,0,0),(7,'http://localhost:8080/images/20200308104629_下载.jpg','20200308104629_下载.jpg','C:/upload/20200308104629_下载.jpg','a!!',8,4,'movies',2,'fanfan2',1,2),(8,'http://localhost:8080/images/20200309003452_泡面.jpg','20200309003452_泡面.jpg','C:/upload/20200309003452_泡面.jpg','another one 2333',0,1,'meals',1,'fanfan',0,0),(9,'http://localhost:8080/images/20200309003842_下载.jpg','20200309003842_下载.jpg','C:/upload/20200309003842_下载.jpg','do some excersise!',1,2,'activities',1,'fanfan',1,0),(10,'http://localhost:8080/images/20200309010356_火锅.jpg','20200309010356_火锅.jpg','C:/upload/20200309010356_火锅.jpg','aaa!',24,1,'meals',1,'fanfan',0,0),(11,'http://localhost:8080/images/20200309021250_火锅.jpg','20200309021250_火锅.jpg','C:/upload/20200309021250_火锅.jpg','huoguohaohaochi',2,1,'meals',5,'fanfan12345',2,0),(12,'http://localhost:8080/images/20200310085521_','20200310085521_','C:/upload/20200310085521_','',0,1,'meals',6,'lindong',0,0),(13,'http://localhost:8080/images/20200311031716_haochi.jpg','20200311031716_haochi.jpg','C:/upload/20200311031716_haochi.jpg','goood!!!!',1,1,'meals',8,'fanfan12345',1,0),(14,'http://localhost:8080/images/20200311033056_haochi.jpg','20200311033056_haochi.jpg','C:/upload/20200311033056_haochi.jpg','good',0,5,NULL,9,'andy',0,0),(15,'http://localhost:8080/images/20200311033235_','20200311033235_','C:/upload/20200311033235_','good',0,1,'meals',9,'andy',0,0),(16,'http://localhost:8080/images/20200311033252_火锅.jpg','20200311033252_火锅.jpg','C:/upload/20200311033252_火锅.jpg','good',0,5,NULL,9,'andy',0,0),(17,'http://localhost:8080/images/20200311033311_火锅.jpg','20200311033311_火锅.jpg','C:/upload/20200311033311_火锅.jpg','good',0,1,'meals',9,'andy',0,0),(18,'http://localhost:8080/images/20200311230904_火锅.jpg','20200311230904_火锅.jpg','C:/upload/20200311230904_火锅.jpg','good',0,5,NULL,9,'andy',0,0),(19,'http://localhost:8080/images/20200311230919_haochi.jpg','20200311230919_haochi.jpg','C:/upload/20200311230919_haochi.jpg','GOOD',0,5,NULL,9,'andy',0,0),(20,'http://localhost:8080/images/20200311231008_泡面.jpg','20200311231008_泡面.jpg','C:/upload/20200311231008_泡面.jpg','GOOD',0,1,'meals',9,'andy',0,0),(21,'http://localhost:8080/images/20200329060209_泡面.jpg','20200329060209_泡面.jpg','C:/upload/20200329060209_泡面.jpg','hahahah',0,1,'meals',1,'fanfan',0,0),(22,'http://localhost:8080/images/20200404221932_haochi.jpg','20200404221932_haochi.jpg','C:/upload/20200404221932_haochi.jpg','family meat',1,3,'families',1,'fanfan',0,1);

/*Table structure for table `topics` */

DROP TABLE IF EXISTS `topics`;

CREATE TABLE `topics` (
  `topicid` int(11) NOT NULL AUTO_INCREMENT,
  `topicname` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `topicimage` varchar(500) DEFAULT '/asserts/img/our.svg',
  PRIMARY KEY (`topicid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `topics` */

insert  into `topics`(`topicid`,`topicname`,`topicimage`) values (1,'meals','/asserts/img/our.svg'),(2,'activities','/asserts/img/our.svg'),(3,'families','/asserts/img/our.svg'),(4,'movies','/asserts/img/our.svg'),(5,'others','/asserts/img/our.svg');

/*Table structure for table `userfollowers` */

DROP TABLE IF EXISTS `userfollowers`;

CREATE TABLE `userfollowers` (
  `userid` int(11) DEFAULT NULL,
  `followerid` int(11) DEFAULT NULL,
  `userfollowerid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userfollowerid`),
  KEY `userid` (`userid`),
  KEY `followerid` (`followerid`),
  CONSTRAINT `userfollowers_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
  CONSTRAINT `userfollowers_ibfk_2` FOREIGN KEY (`followerid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `userfollowers` */

insert  into `userfollowers`(`userid`,`followerid`,`userfollowerid`) values (6,1,12),(6,2,13),(6,3,14),(8,1,15),(8,2,16),(9,1,18),(2,1,20),(1,2,21),(1,3,22);

/*Table structure for table `userlikes` */

DROP TABLE IF EXISTS `userlikes`;

CREATE TABLE `userlikes` (
  `userlikeid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `shipinid` int(11) DEFAULT NULL,
  PRIMARY KEY (`userlikeid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `userlikes` */

insert  into `userlikes`(`userlikeid`,`userid`,`shipinid`) values (16,2,7),(24,1,22),(26,1,7);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `passWord` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '123@qq.com',
  `gender` int(11) DEFAULT NULL,
  `vocation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `religion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `hometown` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `birthyear` int(11) DEFAULT NULL,
  `birthmonth` int(11) DEFAULT NULL,
  `birthday` int(11) DEFAULT NULL,
  `userimage` varchar(500) DEFAULT '/asserts/img/our.svg',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `users` */

insert  into `users`(`userName`,`id`,`passWord`,`email`,`gender`,`vocation`,`religion`,`city`,`hometown`,`state`,`birthyear`,`birthmonth`,`birthday`,`userimage`) values ('fanfan',1,'123456','123567@qq.com',1,'engineer','none',NULL,NULL,NULL,1997,1,27,'/asserts/img/our.svg'),('fanfan2',2,'1234567','123@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/asserts/img/our.svg'),('fanfan21',3,'12345678','123@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/asserts/img/our.svg'),('fanfan223',4,'123456','123@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/asserts/img/our.svg'),('fanfan123000',5,'12345','123@qq.com',0,'engineer','re',NULL,NULL,NULL,1997,1,27,'/asserts/img/our.svg'),('lindong',6,'hahaha','123@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/asserts/img/our.svg'),('aaaa',7,'122222','123@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/asserts/img/our.svg'),('fanfan12345',8,'123456','156789@qq.com',0,'engineer','',NULL,NULL,NULL,0,0,0,'/asserts/img/our.svg'),('andy',9,'123456','123@qq.com',0,'engineer','',NULL,NULL,NULL,0,0,0,'/asserts/img/our.svg'),('aaaa',10,'122222','123@qq.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/asserts/img/our.svg');

/*Table structure for table `usertopics` */

DROP TABLE IF EXISTS `usertopics`;

CREATE TABLE `usertopics` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `topictext` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `usertopicid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`usertopicid`),
  KEY `id` (`id`),
  KEY `usertopicid` (`usertopicid`),
  CONSTRAINT `usertopics_ibfk_1` FOREIGN KEY (`id`) REFERENCES `topics` (`topicid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `usertopics` */

insert  into `usertopics`(`id`,`userid`,`topictext`,`usertopicid`) values (3,1,'families',3),(4,2,'movies',6),(2,5,'activities',8),(1,6,'meals',10),(1,8,'meals',11),(2,8,'activities',12),(1,9,'meals',14),(2,1,'activities',17);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
