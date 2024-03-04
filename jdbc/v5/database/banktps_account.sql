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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `AccNum` int NOT NULL,
  `AccHolderSSN` int DEFAULT NULL,
  `BranchName` varchar(45) DEFAULT NULL,
  `Balance` decimal(15,2) DEFAULT NULL,
  `AccHolderFname` varchar(20) DEFAULT NULL,
  `AccHolderLname` varchar(45) DEFAULT NULL,
  `AccEmail` varchar(45) DEFAULT NULL,
  `Street` varchar(20) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `EmpCode` int DEFAULT NULL,
  `AccType` varchar(45) DEFAULT NULL,
  `InitialBalance` decimal(15,2) DEFAULT NULL,
  `BalanceStatus` varchar(45) DEFAULT 'stable',
  `InterestDate` date DEFAULT NULL,
  PRIMARY KEY (`AccNum`),
  KEY `AccoEmp_idx` (`EmpCode`),
  CONSTRAINT `EmpCode1` FOREIGN KEY (`EmpCode`) REFERENCES `employee` (`EmpCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (454,454,'nasrcity',22000.00,'mohamed','ali','hh@gmail.com','rabaa','nasrcity',2,'current',2000.00,'stable','2024-03-10'),(12131415,67888,'banha',6000.00,'ali','mahmoud','kk@gmail.com','fahd','banha',1,'current',4000.00,'stable',NULL),(12345678,1314,'doki',1200.00,'ahmed','Moustafa','aa@gmail.com','shobra','cairo',1,'saving',3000.00,'instable','2025-03-04'),(45678910,46554,'alex',2500.00,'mohamed','ahmed','dd@yahoo.com','tahrer','alex',2,'current',1000.00,'stable',NULL),(90802010,1213244567,'newcairo',4000.00,'kamal','samy','lgh@gmail.com','ahram','newcairo',2,'saving',4000.00,'stable',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-04  0:44:56
