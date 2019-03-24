-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: dormitory
-- ------------------------------------------------------
-- Server version	5.1.62-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `t_permission`
--

LOCK TABLES `t_permission` WRITE;
/*!40000 ALTER TABLE `t_permission` DISABLE KEYS */;
INSERT INTO `t_permission` VALUES (1,'menu-plugin','系统菜单',-1,1,NULL),(10,'menu-10','公告管理',1,1,NULL),(20,'menu-2','学生信息管理',1,1,''),(30,'menu-3','角色管理',1,1,''),(40,'menu-4','用户信息管理',1,1,''),(50,'menu-5','寝室管理',1,1,''),(60,'menu-6','安全退出',1,1,''),(1010,'menu-11','添加公告',10,0,'/cjadmin/addNoticeInfo.html'),(2010,'menu-12','学生信息查询',20,0,'/cjadmin/manageStudent.html'),(3010,'menu-12','角色信息',30,0,'/cjadmin/manageRole.html'),(4010,'menu-12','用户信息',40,0,'/cjadmin/userInfo.html'),(5010,'menu-12','寝室信息',50,0,'/cjadmin/dormitoryInfo.html'),(6010,'menu-12','安全退出',60,0,'/cjadmin/return.html'),(70,'menu-7','安全退出',1,1,''),(80,'menu-8','用户管理',1,1,''),(81,'menu-9','水电费管理',1,1,''),(82,'menu-10','记过信息',1,1,''),(83,'menu-10','报修信息',1,1,''),(7010,'menu-10','安全退出',70,0,'/student/return.html'),(8010,'menu-10','用户信息',80,0,'/student/userInfo.html'),(8110,'menu-10','水电费信息',81,0,'/student/waterRay.html'),(8210,'menu-10','记过信息',82,0,'/student/jgInfo.html'),(8310,'menu-10','报修信息',83,0,'/student/repairedInfo.html'),(90,'menu-10','安全退出',1,1,NULL),(91,'menu-10','用户管理',1,1,NULL),(92,'menu-10','学生缺勤记录管理',1,1,NULL),(93,'menu-10','来访登记管理',1,1,NULL),(94,'menu-10','处理报修情况管理',1,1,NULL),(95,'menu-10','学生记过处理管理',1,1,NULL),(9010,'menu-10','安全退出',90,0,'/admin/return.html'),(9110,'menu-10','用户信息',91,0,'/admin/adminInfo.html'),(9210,'menu-10','学生缺勤记录信息',92,0,'/admin/xsqqInfo.html'),(9310,'menu-10','来访登记信息',93,0,'/admin/lfdjInfo.html'),(9410,'menu-10','处理报修情况信息',94,0,'/admin/clbxInfo.html'),(9510,'menu-10','学生记过信息',95,0,'/admin/xsjgInfo.html'),(1020,'menu-4','查询公告',10,0,'/cjadmin/selectNoticeInfo.html');
/*!40000 ALTER TABLE `t_permission` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-24 17:41:35
