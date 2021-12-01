CREATE DATABASE  IF NOT EXISTS `tips_management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tips_management`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: tips_management
-- ------------------------------------------------------
-- Server version	5.7.36-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tips`
--

DROP TABLE IF EXISTS `tips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tips` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `Contents` varchar(5120) CHARACTER SET utf8 DEFAULT NULL,
  `IdType` int(11) DEFAULT NULL,
  `DeleteDate` date DEFAULT NULL,
  `UpdateTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tips`
--

LOCK TABLES `tips` WRITE;
/*!40000 ALTER TABLE `tips` DISABLE KEYS */;
INSERT INTO `tips` VALUES (7,'Sửa lỗi hiển thị tiếng Việt ;','https://nguyendangkhiemit.wordpress.com/2015/05/10/sua-loi-hien-thi-tieng-viet-khi-lam-voi-hibernate-spring-mvc-mysql/',10,NULL,'2021-11-28'),(13,' useEffect - cách dùng tham số [ ] trong lifecycle','https://viblo.asia/p/react-hooks-va-nhung-thay-doi-co-ban-can-nam-duoc-RnB5p6e2ZPG',11,NULL,'2021-11-30'),(15,'Can I set state inside a useEffect hook','<p><a href=\"https://stackoverflow.com/questions/53715465/can-i-set-state-inside-a-useeffect-hook\">https://stackoverflow.com/questions/53715465/can-i-set-state-inside-a-useeffect-hook</a></p>',11,NULL,'2021-11-30');
/*!40000 ALTER TABLE `tips` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-01  9:11:04
