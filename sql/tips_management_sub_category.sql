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
-- Table structure for table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(225) CHARACTER SET utf8 DEFAULT NULL,
  `Description` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  `IdMasterCategory` int(11) DEFAULT NULL,
  `DeleteDate` date DEFAULT NULL,
  `UpdateTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_category`
--

LOCK TABLES `sub_category` WRITE;
/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` VALUES (1,'sdsd','U7PZJdj3Wu5h3HqqWADYt5iLYF2K6L89JWRP4jIlCNdBkWCrDamHuxREaEviRyxzzxRkLp8Y2MKALlOVkttxctDNtQjnm0QXBTeC88OVpKWx8nq0L7z8fOPNUowKLDgbJKcLcqjSFnYzNUAgiUEoPwKyp6nrXYAXijzyfbLkbYsAdyKnltWUFaLrAKqO9dhTDnyrQMDjfuWj9Cu8zfI53yrfGuXMIPYSsTZmxMIrtOMcz6sHEbaBQPFEnnyTIhriiYv9h5gICKcKuv4oL3Q99qFAnR1MbWCHhG4eiC2wwNGnErEZzXN35Gyu46kjhdSAuNXvdvhX2U3BcGtGWgPHfkuGUXP72XRXUnCgV6B6R4CMRkwj0rJJJ3EMp98np1ecoKWjAgpeXynrL0ioEyWq5eRTWnw1nyptBnKr9FTzHfExkkrFNCSSaMcuqDld0i9vovDphSKxA4sVE05aRVDxnUcNr30R4Dev4hhfaPK77urOnXZ7iXiYXvWHyzGcFfio4tw8KRrzUW0MWkB3SlPbAcMWBHv7gNiBFabOkS8vuBVwXNRoQe68Rg10L2vNHw6dgYZnRnCC3s8PALgd0pC7Y70dxPrWsuKl5DsIrgKOSOn634oQDXXxYMa1vLkPK04JESYPcnD5Y4TtCH6kb8GY0RdWMYlOLfff7S7i87O2OMQi4B9HlrA9pG5JLdd40r5rekYapkgFwo7sTDrj00LxASWrOK5h210GsF1BRIQrhWU6gRRsjbaJj17Xg3nq7QRw0t93Fucr4U6RMjmKrUZevnvsjG7QqHsJsdZ8gCvzJfv8wbqKxtGI9Pi1VypVRBwpph49b4fhArXY3DqwoGNs5VkPcaX89RncUUEMwKOfVxA72gke635QTXwUP7dNLyCfTOgAn7cmFJZHqSLYduQ2HpSgfJzGygbDmG8b5NgkdHAByEvUIzYFJ8pZo1p8PAjuTNFXPDFpw8em8MP9E1jW9rAE7ReT9nd3rWemnMx7',1,'2018-08-20','2016-07-20'),(4,'employee11','xccz',NULL,NULL,'2021-11-27'),(5,'Sangnv','xccz',NULL,NULL,'2021-11-27'),(7,'fdf','fsdfsd',3,NULL,'2021-11-27'),(10,'Spring','fsdfsd',4,NULL,'2021-11-28'),(11,'Hook','https://viblo.asia/p/react-hooks-va-nhung-thay-doi-co-ban-can-nam-duoc-RnB5p6e2ZPG',2,NULL,'2021-11-30'),(12,'sdfsdfsd',NULL,6,'2021-11-30','2021-11-30');
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;
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
