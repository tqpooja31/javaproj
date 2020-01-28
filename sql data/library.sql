-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `callno` varchar(10) NOT NULL,
  `bname` varchar(45) NOT NULL,
  `Author` varchar(45) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `issue` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'A-1','Java Devlaper','bala subramaniyam','B.K.Naikrs',4,0),(2,'B-2','C++ Language','asdkjasdjfh','ytyuweuriut',5,0),(3,'C-3','Angular','Yashwant K','hggh jhkj',6,0),(4,'D-4','Hibernate','Asdf rthh','Kjhy Rtu',4,0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issuebook`
--

DROP TABLE IF EXISTS `issuebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `issuebook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `callno` varchar(45) NOT NULL,
  `studid` int(10) NOT NULL,
  `sname` varchar(45) NOT NULL,
  `smobno` varchar(45) NOT NULL,
  `issuedate` date NOT NULL,
  `Returnstatus` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sid_idx` (`studid`),
  KEY `studid_idx` (`studid`),
  CONSTRAINT `studid` FOREIGN KEY (`studid`) REFERENCES `student` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuebook`
--

LOCK TABLES `issuebook` WRITE;
/*!40000 ALTER TABLE `issuebook` DISABLE KEYS */;
INSERT INTO `issuebook` VALUES (1,'B-2',101,'Ashish','9854123675','2019-12-20','yes'),(2,'B-2',104,'pooja','9857412368','2019-12-20','yes'),(3,'A-1',101,'Ashish','9854123675','2019-12-20','yes'),(4,'D-4',106,'shraddha','9854126375','2019-12-20','yes'),(5,'A-1',101,'Ashish','9854123675','2019-12-30','yes'),(6,'B-2',102,'Saurabh','9854123675','2019-12-30','yes'),(7,'C-3',103,'Sankalp','8574961253','2019-12-30','yes'),(8,'A-1',104,'pooja','9857412368','2019-12-30','yes'),(9,'A-1',101,'Ashish','9854123675','2019-12-30','yes'),(10,'A-1',101,'Ashish','9854123675','2019-12-30','yes');
/*!40000 ALTER TABLE `issuebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `librarian`
--

DROP TABLE IF EXISTS `librarian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `librarian` (
  `Lid` int(11) NOT NULL AUTO_INCREMENT,
  `Lname` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `mobno` bigint(10) NOT NULL,
  PRIMARY KEY (`Lid`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  UNIQUE KEY `mobno_UNIQUE` (`mobno`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `librarian`
--

LOCK TABLES `librarian` WRITE;
/*!40000 ALTER TABLE `librarian` DISABLE KEYS */;
INSERT INTO `librarian` VALUES (1,'pooja kolpe','p@gmail.com','pooja123',123456856),(6,'gauri pathak','g@gmail.com','gauri123',8563241),(8,'vivek','vv@gmail.com','hggj12',985426),(9,'Shraddha Marath','sm@gmail.com','12345678',123456789),(11,'priyanka','pro@gmail.com','12345678',7720819485),(19,'sujit','s@gmail.com','sujit123',8596214632),(21,'Amruta','amu@gmail.com','amruta123',9857416325),(22,'shital j','sh@gmail.comm','shital123',9854123682),(23,'oiuytre','kjytr@dd.ggbbb','78654324567',234567890),(24,'sdfghj','a@f.hh','12345678',1234567),(25,'wertyui','a@a.gg','1234561234567',2345678),(43,'priya khan','priya@gmail.com','priya@123',8541365984);
/*!40000 ALTER TABLE `librarian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL,
  `sname` varchar(45) NOT NULL,
  `smobno` varchar(25) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (101,'Ashish','9854123675','ashis@gmail.com'),(102,'Saurabh','9854123675','sau@gmail.com'),(103,'Sankalp','8574961253','san@gmail.com'),(104,'pooja','9857412368','p@gmail.com'),(105,'Amruta','8541236595','amru@gmail.com'),(106,'shraddha','9854126375','sh@gmail.com');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'library'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-27 18:06:04
