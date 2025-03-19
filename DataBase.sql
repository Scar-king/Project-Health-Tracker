CREATE DATABASE  IF NOT EXISTS `health_tracker` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `health_tracker`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: health_tracker
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `bmi_data`
--

DROP TABLE IF EXISTS `bmi_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bmi_data` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `Weight` double(5,2) DEFAULT NULL,
  `Height` double(5,2) DEFAULT NULL,
  `BMI` double(5,2) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bmi_data`
--

LOCK TABLES `bmi_data` WRITE;
/*!40000 ALTER TABLE `bmi_data` DISABLE KEYS */;
INSERT INTO `bmi_data` VALUES (1,'Do Davin',20,'M',54.00,1.79,16.85,'2025-03-11 07:42:58'),(2,'Bro Vath',20,'M',75.00,1.78,23.67,'2025-03-11 08:19:56'),(3,'Davin',18,'M',53.00,1.80,16.36,'2025-03-11 09:06:02'),(4,'Davin',18,'M',54.00,1.80,16.67,'2025-03-11 09:07:04'),(5,'Davin',18,'M',54.00,1.40,27.55,'2025-03-11 09:07:17'),(6,'Vontey',19,'F',50.00,1.55,20.81,'2025-03-12 14:12:16'),(7,'do avvvv',100,'M',53.00,1.90,14.68,'2025-03-12 14:47:56'),(8,'Do Davin',20,'M',54.00,1.80,16.67,'2025-03-17 14:20:27');
/*!40000 ALTER TABLE `bmi_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `heart_rate_data`
--

DROP TABLE IF EXISTS `heart_rate_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `heart_rate_data` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `Resting_HR` int DEFAULT NULL,
  `Max_HR` int DEFAULT NULL,
  `HRR` int DEFAULT NULL,
  `Current_HR` int DEFAULT NULL,
  `Heart_Zone` varchar(50) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `heart_rate_data`
--

LOCK TABLES `heart_rate_data` WRITE;
/*!40000 ALTER TABLE `heart_rate_data` DISABLE KEYS */;
INSERT INTO `heart_rate_data` VALUES (1,'Do Davin',20,'M',72,200,128,100,'Fat Burn Zone','2025-03-08 22:46:15'),(2,'Do Davin',20,'M',72,200,-72,100,'Fat Burn Zone','2025-03-08 22:52:16'),(3,'Do Davin',20,'M',72,200,28,100,'Fat Burn Zone','2025-03-08 22:55:09'),(4,'Do Davin',20,'M',72,200,28,100,'Fat Burn Zone','2025-03-08 23:37:35'),(5,'Do Davin',20,'M',-100,200,0,-100,'Resting Zone','2025-03-09 01:44:10'),(6,'Do Davin',20,'M',72,200,28,100,'Fat Burn Zone','2025-03-09 01:51:24'),(7,'Do Davin',20,'M',72,200,28,100,'Fat Burn Zone','2025-03-09 11:19:57'),(8,'Do Davin',20,'M',72,200,-72,0,'Resting Zone','2025-03-10 19:52:54'),(9,'Kol Thyda',20,'F',72,200,28,100,'Fat Burn Zone','2025-03-10 21:03:58'),(10,'DAvin',20,'M',73,200,27,100,'Fat Burn Zone','2025-03-10 21:17:40'),(11,'dav',10,'M',72,210,28,100,'Resting Zone','2025-03-10 23:48:15'),(12,'dav',1,'M',72,219,28,100,'Resting Zone','2025-03-11 00:20:10'),(13,'d',23,'M',72,197,96,168,'Peak Zone','2025-03-11 00:28:02'),(14,'d',23,'M',72,197,65,137,'Fat Burn Zone','2025-03-11 00:28:28'),(15,'d',23,'M',72,197,66,138,'Cardio Zone','2025-03-11 00:28:40'),(16,'davin',20,'M',72,200,28,100,'Fat Burn Zone','2025-03-11 00:33:17'),(17,'Vin',18,'M',40,202,20,60,'Resting Zone','2025-03-11 07:05:22'),(18,'ues',20,'M',72,200,28,100,'Fat Burn Zone','2025-03-11 07:12:07'),(19,'Bro Vath',20,'M',72,200,28,100,'Fat Burn Zone','2025-03-11 08:17:22'),(20,'do',20,'M',72,200,28,100,'Fat Burn Zone','2025-03-12 11:37:46'),(21,'na',40,'M',72,180,28,100,'Fat Burn Zone','2025-03-12 14:39:55'),(22,'Hayabuda',20,'M',72,200,28,100,'Fat Burn Zone','2025-03-12 14:41:57'),(23,'Uranus',20,'M',72,200,28,100,'Fat Burn Zone','2025-03-12 14:43:06'),(24,'Do Davinnnn',20,'M',72,200,28,100,'Fat Burn Zone','2025-03-12 14:43:49');
/*!40000 ALTER TABLE `heart_rate_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sleep_data`
--

DROP TABLE IF EXISTS `sleep_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sleep_data` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `Sleep_Start` time DEFAULT NULL,
  `Wake_Up_Time` time DEFAULT NULL,
  `Time_In_Bed` double(5,2) DEFAULT NULL,
  `Total_Sleep_Hours` double(5,2) DEFAULT NULL,
  `Sleep_Efficiency` double(5,2) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sleep_data`
--

LOCK TABLES `sleep_data` WRITE;
/*!40000 ALTER TABLE `sleep_data` DISABLE KEYS */;
INSERT INTO `sleep_data` VALUES (1,'Do Davin',20,'M','11:00:00','23:00:00',12.00,11.00,91.67,'2025-03-08 22:31:04'),(2,'Do Davin',20,'M','11:00:00','12:00:00',1.00,2.67,266.67,'2025-03-09 01:31:21'),(3,'Do Davin',20,'M','11:00:00','12:00:00',1.00,-1.00,-100.00,'2025-03-09 01:33:56'),(4,'Do Davin',20,'M','11:00:00','12:00:00',1.00,0.00,0.00,'2025-03-09 01:40:56'),(5,'Do Davin',20,'M','00:11:00','11:00:00',10.82,8.82,81.51,'2025-03-10 19:52:20'),(6,'Kol Thyda',20,'F','23:00:00','04:00:00',5.00,5.00,100.00,'2025-03-10 21:03:46'),(7,'DAvin',20,'M','23:00:00','06:00:00',7.00,7.00,100.00,'2025-03-10 21:17:12'),(8,'davin',20,'M','11:00:00','12:00:00',1.00,1.00,100.00,'2025-03-10 22:19:22'),(9,'dav',22,'M','11:00:00','12:00:00',1.00,0.67,66.67,'2025-03-10 23:08:39'),(10,'d',2,'M','11:00:00','01:00:00',14.00,13.50,96.43,'2025-03-10 23:26:49'),(11,'d',2,'M','11:00:00','13:00:00',2.00,1.50,75.00,'2025-03-10 23:27:25'),(12,'Vin',18,'M','23:00:00','06:30:00',7.50,7.50,100.00,'2025-03-11 07:04:16'),(13,'Bro Vath',20,'M','11:00:00','12:00:00',1.00,1.00,100.00,'2025-03-11 08:17:00');
/*!40000 ALTER TABLE `sleep_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `step_data`
--

DROP TABLE IF EXISTS `step_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `step_data` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `Steps_Count` int DEFAULT NULL,
  `Step_Goal` int DEFAULT NULL,
  `Weight` double(5,2) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `step_data`
--

LOCK TABLES `step_data` WRITE;
/*!40000 ALTER TABLE `step_data` DISABLE KEYS */;
INSERT INTO `step_data` VALUES (1,'Do Davin',20,'M',100,200,54.00,'2025-03-08 22:00:30'),(2,'Do Davin',20,'M',100,200,54.00,'2025-03-09 00:27:43'),(3,'Do Davin',20,'M',100,200,54.00,'2025-03-09 00:39:39'),(4,'Do Davin',20,'M',0,100,-90.00,'2025-03-09 00:51:57'),(5,'Do Davin',20,'M',10,200,54.00,'2025-03-09 00:55:25'),(6,'Do Davin',20,'M',1,100,54.00,'2025-03-09 01:17:35'),(7,'thyda',19,'M',1000,2000,43.00,'2025-03-10 15:40:07'),(8,'thyda',19,'F',1000,2000,43.00,'2025-03-10 15:47:29'),(9,'Do Davin',10,'M',0,1,2.00,'2025-03-10 16:31:04'),(10,'Kol Thyda',20,'F',1000,2000,43.00,'2025-03-10 21:03:12'),(11,'DAvin',20,'M',1000,2000,300.00,'2025-03-10 21:16:43'),(12,'davv',20,'M',1000,2000,200.00,'2025-03-10 21:32:35'),(13,'Do Davin',20,'M',100,200,200.00,'2025-03-10 21:53:12'),(14,'Do Davin',20,'M',100,200,200.00,'2025-03-10 21:53:33'),(15,'Vin',18,'M',0,1,10.00,'2025-03-11 07:03:15'),(16,'Bro Vath',20,'M',100,200,75.00,'2025-03-11 08:14:58'),(17,'Davin',18,'M',5000,6000,60.00,'2025-03-11 09:07:51');
/*!40000 ALTER TABLE `step_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `water_data`
--

DROP TABLE IF EXISTS `water_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `water_data` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `Total_Water_Intake` double(5,2) DEFAULT NULL,
  `Goal_Water_Intake` double(5,2) DEFAULT NULL,
  `Hydration_Level` varchar(25) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `water_data`
--

LOCK TABLES `water_data` WRITE;
/*!40000 ALTER TABLE `water_data` DISABLE KEYS */;
INSERT INTO `water_data` VALUES (1,'Do Davin',20,'M',1.00,2.00,'Dehydrated','2025-03-08 21:38:05'),(2,'Do Davin',20,'M',2.00,2.00,'Hydrated','2025-03-08 21:38:13'),(3,'Do Davin',10,'M',2.00,1.00,'Over-hydrated','2025-03-09 01:19:19'),(4,'da',1,'M',2.00,1.00,'Over-hydrated','2025-03-09 01:19:42'),(5,'da',1,'M',1.00,3.00,'Dehydrated','2025-03-09 01:20:00'),(6,'Do Davin',20,'M',50.00,100.00,'Dehydrated','2025-03-09 01:30:01'),(7,'Do Davin',20,'M',1.00,1.00,'Hydrated','2025-03-10 19:51:06'),(8,'Kol Thyda',20,'F',1.00,2.00,'Dehydrated','2025-03-10 21:03:22'),(9,'DAvin',12,'M',1.00,2.00,'Dehydrated','2025-03-10 21:18:43'),(10,'Vin',18,'M',0.10,0.10,'Hydrated','2025-03-11 07:03:34'),(11,'Bro Vath',20,'M',1.00,2.00,'Dehydrated','2025-03-11 08:15:26'),(12,'Bro Vath',20,'M',3.00,2.00,'Over-hydrated','2025-03-11 08:15:49'),(13,'Hay',20,'M',1.00,3.00,'Dehydrated','2025-03-11 08:23:16'),(14,'Hay',20,'M',2.00,3.00,'Dehydrated','2025-03-11 08:23:31'),(15,'Bro Vin',20,'M',1.00,3.00,'Dehydrated','2025-03-11 08:28:12'),(16,'Bro Vin',20,'M',2.00,3.00,'Dehydrated','2025-03-11 08:28:53'),(17,'Bro NAA',20,'M',1.00,1.00,'Hydrated','2025-03-11 08:31:49'),(18,'iPhone',20,'M',1.00,1.00,'Hydrated','2025-03-11 08:47:41'),(19,'Davin',18,'M',1.50,2.00,'Dehydrated','2025-03-11 09:08:37'),(20,'Davin',18,'M',1.75,2.00,'Dehydrated','2025-03-11 09:09:08'),(21,'Davin',18,'M',2.25,2.00,'Hydrated','2025-03-11 09:09:32'),(22,'Sereyvong',20,'M',1.00,3.00,'Dehydrated','2025-03-12 11:47:16'),(23,'Sereyvong',20,'M',3.00,3.00,'Hydrated','2025-03-12 11:47:21'),(24,'Rith',23,'M',100.00,100.00,'Hydrated','2025-03-12 13:10:57'),(25,'Hayle',20,'M',5.00,5.00,'Hydrated','2025-03-12 13:29:17'),(26,'Ot',20,'M',5.00,5.00,'Hydrated','2025-03-12 13:31:00'),(27,'do',20,'M',5.00,5.00,'Hydrated','2025-03-12 13:34:48'),(28,'Dav',34,'M',5.00,5.00,'Hydrated','2025-03-12 13:36:03'),(29,'davb',20,'M',4.00,5.00,'Dehydrated','2025-03-12 13:37:03'),(30,'davb',20,'M',5.00,5.00,'Hydrated','2025-03-12 13:37:08');
/*!40000 ALTER TABLE `water_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-18  8:57:23
