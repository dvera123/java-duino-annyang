-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.41


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema projectx
--

CREATE DATABASE IF NOT EXISTS projectx;
USE projectx;

--
-- Definition of table `step`
--

DROP TABLE IF EXISTS `step`;
CREATE TABLE `step` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `num` int(10) unsigned NOT NULL,
  `description` varchar(255) NOT NULL,
  `action` varchar(45) NOT NULL,
  `fk_step_status` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_step_status` (`fk_step_status`),
  CONSTRAINT `fk_step_status` FOREIGN KEY (`fk_step_status`) REFERENCES `step_status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `step`
--

/*!40000 ALTER TABLE `step` DISABLE KEYS */;
/*!40000 ALTER TABLE `step` ENABLE KEYS */;


--
-- Definition of table `step_status`
--

DROP TABLE IF EXISTS `step_status`;
CREATE TABLE `step_status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `step_status`
--

/*!40000 ALTER TABLE `step_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `step_status` ENABLE KEYS */;


--
-- Definition of table `test_case`
--

DROP TABLE IF EXISTS `test_case`;
CREATE TABLE `test_case` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(85) NOT NULL,
  `fk_test_case_status` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_test_case_status` (`fk_test_case_status`),
  CONSTRAINT `fk_test_case_status` FOREIGN KEY (`fk_test_case_status`) REFERENCES `test_case_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test_case`
--

/*!40000 ALTER TABLE `test_case` DISABLE KEYS */;
INSERT INTO `test_case` (`id`,`name`,`description`,`fk_test_case_status`) VALUES 
 (1,'Test Case 1','insert data',1),
 (2,'Test Case 2','delete data',1);
/*!40000 ALTER TABLE `test_case` ENABLE KEYS */;


--
-- Definition of table `test_case_status`
--

DROP TABLE IF EXISTS `test_case_status`;
CREATE TABLE `test_case_status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test_case_status`
--

/*!40000 ALTER TABLE `test_case_status` DISABLE KEYS */;
INSERT INTO `test_case_status` (`id`,`name`) VALUES 
 (1,'Failure'),
 (2,'Approved');
/*!40000 ALTER TABLE `test_case_status` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `nick_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
