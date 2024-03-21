-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: bankapp
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `tr`
--

DROP TABLE IF EXISTS `tr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tr` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` decimal(15,2) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `percent` int DEFAULT NULL,
  `balance` decimal(15,2) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tr`
--

LOCK TABLES `tr` WRITE;
/*!40000 ALTER TABLE `tr` DISABLE KEYS */;
INSERT INTO `tr` VALUES (62,2000.00,2,10,2400.00,'01150523698'),(63,2000.00,2,20,2800.00,'01150523698'),(64,2000.00,2,30,3200.00,'01150523698'),(65,2000.00,2,40,3600.00,'01150523698'),(66,2000.00,2,50,4000.00,'01150523698'),(67,2000.00,2,80,5200.00,'01025549143'),(68,2000.00,2,70,4800.00,'01025549143'),(69,2000.00,2,90,5600.00,'01025549143'),(70,2000.00,2,50,4000.00,'01025549143'),(71,2000.00,2,40,3600.00,'01025549143'),(72,2000.00,2,40,3600.00,'01025549143'),(73,500.00,10,7,850.00,'011'),(74,500.00,10,70,4000.00,'011'),(75,5000.00,4,10,7000.00,'01000'),(76,1000.00,2,10,1200.00,'011234'),(77,1000.00,2,10,1200.00,'011234'),(78,1000.00,2,10,1200.00,'011234'),(79,8000.00,6,12,13760.00,'011'),(80,9000.00,6,30,25200.00,'011'),(81,9000.00,6,100,63000.00,'011'),(82,8800.00,3,10,11440.00,'090'),(83,12333.00,1,12,13812.96,'12345678'),(84,12222.00,1,20,14666.40,'1245'),(85,3444.00,3,34,6956.88,'34'),(86,33.00,2,5,36.30,'78'),(87,34.00,33,4,78.88,'90'),(88,700.00,0,10,710.00,'6789'),(89,788.00,6,6,1071.68,'6789'),(90,50000.00,589,10,2999999.00,'6789'),(91,34.00,33,4,78.88,'6789'),(92,8999.00,1,6,9538.94,'0987'),(93,90000.00,2,20,126000.00,'908070'),(94,30000.00,3,50,75000.00,'875857'),(95,120000.00,2,20,168000.00,'875857'),(96,10000.00,2,10,12000.00,'875857'),(97,1200.00,2,6477,156666.00,'011'),(98,8000.00,5,20,0.00,'01000'),(99,400.00,3,300,0.00,'090'),(100,400.00,3,300,0.00,'090'),(101,500.00,7,1128,0.00,'090');
/*!40000 ALTER TABLE `tr` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-20  0:56:47
