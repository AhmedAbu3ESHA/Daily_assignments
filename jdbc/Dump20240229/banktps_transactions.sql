-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: banktps
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
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `TransID` int NOT NULL AUTO_INCREMENT,
  `TransType` varchar(20) DEFAULT NULL,
  `TransAmount` decimal(15,2) DEFAULT NULL,
  `TransDate` date DEFAULT NULL,
  `AccNum` int DEFAULT NULL,
  `EmpCode` int DEFAULT NULL,
  `TransStatus` bit(2) DEFAULT NULL,
  PRIMARY KEY (`TransID`),
  KEY `AccoTrans_idx` (`AccNum`),
  KEY `EmpCode_idx` (`EmpCode`),
  CONSTRAINT `AccoTrans` FOREIGN KEY (`AccNum`) REFERENCES `account` (`AccNum`),
  CONSTRAINT `EmpCode` FOREIGN KEY (`EmpCode`) REFERENCES `employee` (`EmpCode`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (4,'credit',100.00,'2024-02-29',12345678,2,_binary ''),(5,'credit',1000.00,'2024-02-29',12345678,2,_binary ''),(6,'credit',5000.00,'2024-02-29',12345678,2,_binary ''),(9,'credit',1000.00,'2024-02-29',12345678,2,_binary ''),(10,'debit',1000.00,'2024-02-29',12345678,2,_binary ''),(11,'credit',1000.00,'2024-02-29',12345678,2,_binary ''),(12,'credit',1000.00,'2024-02-29',12345678,2,_binary ''),(13,'credit',1000.00,'2024-02-29',12345678,2,_binary ''),(14,'100.0',12345678.00,'2024-02-29',12345678,2,_binary ''),(15,'100.0',12345678.00,'2024-02-29',12345678,2,_binary ''),(16,'credit',1000.00,'2024-02-29',12345678,2,_binary ''),(17,'debit',2000.00,'2024-02-29',12345678,1,_binary ''),(18,'credit',1000.00,'2024-02-29',454,2,_binary ''),(19,'credit',-5000.00,'2024-02-29',454,1,_binary '\0');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-29 16:41:32
