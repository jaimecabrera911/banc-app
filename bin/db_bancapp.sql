-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: bancapp
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `adm_cuentas`
--

DROP TABLE IF EXISTS `adm_cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adm_cuentas` (
  `codigo_cuenta` varchar(10) NOT NULL,
  `fecha_creacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `cedula_cliente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo_cuenta`),
  KEY `FK6scydokwoefnwibg0f9h7bsc` (`cedula_cliente`),
  CONSTRAINT `FK6scydokwoefnwibg0f9h7bsc` FOREIGN KEY (`cedula_cliente`) REFERENCES `clientes` (`cedula`),
  CONSTRAINT `FKn85dc06rnwusd8xomr9leyykn` FOREIGN KEY (`codigo_cuenta`) REFERENCES `cuentas` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adm_cuentas`
--

LOCK TABLES `adm_cuentas` WRITE;
/*!40000 ALTER TABLE `adm_cuentas` DISABLE KEYS */;
INSERT INTO `adm_cuentas` VALUES ('001','2021-02-01 00:26:33','1026265331'),('002','2021-02-01 00:27:10','1026265331'),('003','2021-02-01 12:38:52','585344');
/*!40000 ALTER TABLE `adm_cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudades` (
  `codigo` varchar(10) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` VALUES ('001','Bogotá'),('002','Medéllin'),('003','Cali'),('004','Barranquilla');
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `cedula` varchar(12) NOT NULL,
  `nombre` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `apellido` varchar(12) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `cod_ciudad` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cedula`),
  KEY `FK3t50ro08lc8o7seiwa59ogmra` (`cod_ciudad`),
  CONSTRAINT `FK3t50ro08lc8o7seiwa59ogmra` FOREIGN KEY (`cod_ciudad`) REFERENCES `ciudades` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('1026265331','Jaime','Cabrera','CR 27 C 70 81','3504750746','001','CLIENTE','1234'),('123456789','Marck','Zuckerberg','CR 1 Nº 5 -4','2555555','001','ADMON','12345'),('2345678','David','Cepeda','CL 4 - 5 -6','2454578','002','ADMON','12345'),('36529753','Clara','Avendaño','Cr 20 31 40','3014525041','004','CLIENTE','1234'),('585344','Edwin','Palomino','Cl 3 4','35047876212','002','CLIENTE','1234');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `codigo` varchar(10) NOT NULL,
  `estado` bit(1) DEFAULT NULL,
  `nombre_cta` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES ('001',_binary '','AHORROS'),('002',_binary '','CORRIENTE'),('003',_binary '','AHORROS'),('004',_binary '','CORRIENTE');
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimiento`
--

DROP TABLE IF EXISTS `movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimiento` (
  `id` int NOT NULL,
  `cedula_cli` varchar(255) NOT NULL,
  `codigo_cta` varchar(255) NOT NULL,
  `fecha_mov` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo_movimiento` varchar(255) DEFAULT NULL,
  `saldo` double DEFAULT NULL,
  PRIMARY KEY (`cedula_cli`,`codigo_cta`,`id`),
  KEY `FKk913wcyjctwbk3t6pdfyahkcg` (`codigo_cta`),
  CONSTRAINT `FKj5nfvdhbk1xx95jj3ubdnlm0w` FOREIGN KEY (`cedula_cli`) REFERENCES `clientes` (`cedula`),
  CONSTRAINT `FKk913wcyjctwbk3t6pdfyahkcg` FOREIGN KEY (`codigo_cta`) REFERENCES `cuentas` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento`
--

LOCK TABLES `movimiento` WRITE;
/*!40000 ALTER TABLE `movimiento` DISABLE KEYS */;
INSERT INTO `movimiento` VALUES (1,'1026265331','001','2021-02-01 21:28:11','INGRESO',300000),(2,'1026265331','001','2021-02-01 21:39:44','INGRESO',1000000),(3,'1026265331','001','2021-02-01 21:39:54','INGRESO',3000000),(4,'1026265331','001','2021-02-01 21:40:08','EGRESO',1000000),(7,'1026265331','001','2021-02-01 22:10:27','EGRESO',2000000),(9,'1026265331','001','2021-02-01 22:30:37','INGRESO',400000),(10,'1026265331','001','2021-02-01 22:33:28','INGRESO',1000000),(13,'1026265331','001','2021-02-02 02:34:35','EGRESO',100000),(18,'1026265331','001','2021-02-02 02:49:59','INGRESO',1000000),(5,'1026265331','002','2021-02-01 22:08:36','INGRESO',1000000),(6,'1026265331','002','2021-02-01 22:10:12','INGRESO',4000000),(10,'1026265331','002','2021-02-01 22:39:31','INGRESO',50000),(11,'1026265331','002','2021-02-01 22:39:49','EGRESO',1000000),(15,'1026265331','002','2021-02-02 02:47:50','INGRESO',1000000),(16,'1026265331','002','2021-02-02 02:48:36','INGRESO',1000000),(17,'1026265331','002','2021-02-02 02:49:39','INGRESO',1000000),(19,'1026265331','002','2021-02-02 02:51:18','EGRESO',350000),(20,'1026265331','002','2021-02-02 02:52:40','INGRESO',350000),(12,'585344','003','2021-02-01 22:40:34','INGRESO',1500000);
/*!40000 ALTER TABLE `movimiento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-01 19:11:26
