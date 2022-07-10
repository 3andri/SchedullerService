-- MySQL dump 10.13  Distrib 5.7.22, for Win32 (AMD64)
--
-- Host: localhost    Database: stockdata
-- ------------------------------------------------------
-- Server version	5.5.5-10.7.3-MariaDB

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
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `No` int(11) DEFAULT NULL,
  `IDStockSummary` int(11) DEFAULT NULL,
  `Date` date NOT NULL,
  `StockCode` varchar(8) NOT NULL,
  `StockName` varchar(100) DEFAULT NULL,
  `Remarks` varchar(100) DEFAULT NULL,
  `Previous` double DEFAULT NULL,
  `OpenPrice` double DEFAULT NULL,
  `FirstTrade` double DEFAULT NULL,
  `High` double DEFAULT NULL,
  `Low` double DEFAULT NULL,
  `Close` double DEFAULT NULL,
  `Change` double DEFAULT NULL,
  `Volume` double DEFAULT NULL,
  `Value` double DEFAULT NULL,
  `Frequency` double DEFAULT NULL,
  `IndexIndividual` double DEFAULT NULL,
  `Offer` double DEFAULT NULL,
  `OfferVolume` double DEFAULT NULL,
  `Bid` double DEFAULT NULL,
  `BidVolume` double DEFAULT NULL,
  `ListedShares` double DEFAULT NULL,
  `TradebleShares` double DEFAULT NULL,
  `WeightForIndex` double DEFAULT NULL,
  `ForeignSell` double DEFAULT NULL,
  `ForeignBuy` double DEFAULT NULL,
  `DelistingDate` varchar(30) DEFAULT NULL,
  `NonRegularVolume` double DEFAULT NULL,
  `NonRegularValue` double DEFAULT NULL,
  `NonRegularFrequency` double DEFAULT NULL,
  `persen` varchar(30) DEFAULT NULL,
  `percentage` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Date`,`StockCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stockdate`
--

DROP TABLE IF EXISTS `stockdate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockdate` (
  `date` int(11) NOT NULL,
  `status_get_data` int(1) DEFAULT NULL,
  `sabtu_minggu` int(1) DEFAULT NULL,
  `hari_libur` int(1) DEFAULT NULL,
  `keterangan` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stockdifferent`
--

DROP TABLE IF EXISTS `stockdifferent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockdifferent` (
  `date` int(10) NOT NULL,
  `stockcode` varchar(10) NOT NULL,
  `pricetoday` double DEFAULT NULL,
  `priceyesterday` double DEFAULT NULL,
  `percentage` double DEFAULT NULL,
  PRIMARY KEY (`date`,`stockcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'stockdata'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-10 12:49:14
