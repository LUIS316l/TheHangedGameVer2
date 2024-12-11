-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: game
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `words`
--

DROP TABLE IF EXISTS `words`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `words` (
  `id_word` int NOT NULL AUTO_INCREMENT,
  `word` varchar(25) DEFAULT NULL,
  `used` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id_word`)
) ENGINE=InnoDB AUTO_INCREMENT=302 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `words`
--

LOCK TABLES `words` WRITE;
/*!40000 ALTER TABLE `words` DISABLE KEYS */;
INSERT INTO `words` VALUES (1,'Sandía',0),(2,'Manzana',0),(3,'Kiwi',0),(4,'Guanábana',0),(5,'Cereza',0),(6,'Durazno',0),(7,'Papaya',0),(8,'Fresa',0),(9,'Piña',0),(10,'Mandarina',0),(11,'Mora',0),(12,'Granada',0),(13,'Mango',0),(14,'Litchi',0),(15,'Naranja',0),(16,'Pera',0),(17,'Ciruela',0),(18,'Coco',0),(19,'Lima',0),(20,'Guayaba',0),(21,'Plátano',0),(22,'Higo',0),(23,'Frambuesa',0),(24,'Chirimoya',0),(25,'Toronja',0),(26,'Pitaya',0),(27,'Acerola',0),(28,'Arándano',0),(29,'Zapote',0),(30,'Tamarindo',0),(31,'Enchilada',0),(32,'Tacos',0),(33,'Paella',0),(34,'Sushi',0),(35,'Ceviche',0),(36,'Tortilla',0),(37,'Pozole',0),(38,'Hamburguesa',0),(39,'Tamales',0),(40,'Spaghetti',0),(41,'Arepa',0),(42,'Mole',0),(43,'Sopa',0),(44,'Panucho',0),(45,'Salchicha',0),(46,'Empanada',0),(47,'Pastel',0),(48,'Pizza',0),(49,'Burrito',0),(50,'Chilaquiles',0),(51,'Lasagna',0),(52,'Galletas',0),(53,'Hotcakes',0),(54,'Tostadas',0),(55,'Carnitas',0),(56,'Caldo',0),(57,'Albóndigas',0),(58,'Croissant',0),(59,'Risotto',0),(60,'Barbacoa',0),(61,'Huarache',0),(62,'Quesadilla',0),(63,'Atole',0),(64,'Ramen',0),(65,'Nopales',0),(66,'Papas',0),(67,'Panini',0),(68,'Fondue',0),(69,'Chimichanga',0),(70,'Fajitas',0),(71,'Crepas',0),(72,'Poutine',0),(73,'Yakitori',0),(74,'Falafel',0),(75,'Shawarma',0),(76,'Baguette',0),(77,'Gazpacho',0),(78,'Arequipe',0),(79,'Tortitas',0),(80,'Arroz',0),(81,'México',0),(82,'Japón',0),(83,'Francia',0),(84,'Italia',0),(85,'Brasil',0),(86,'Canadá',0),(87,'Alemania',0),(88,'Sudáfrica',0),(89,'India',0),(90,'Australia',0),(91,'Colombia',0),(92,'Egipto',0),(93,'Turquía',0),(94,'España',0),(95,'Grecia',0),(96,'Rusia',0),(97,'Noruega',0),(98,'Suecia',0),(99,'China',0),(100,'Portugal',0),(101,'Marruecos',0),(102,'Polonia',0),(103,'Irlanda',0),(104,'Dinamarca',0),(105,'Filipinas',0),(106,'Perú',0),(107,'Venezuela',0),(108,'Argentina',0),(109,'Chile',0),(110,'Corea',0),(111,'Suiza',0),(112,'Indonesia',0),(113,'Finlandia',0),(114,'Nigeria',0),(115,'Panamá',0),(116,'Cuba',0),(117,'Ucrania',0),(118,'Austria',0),(119,'Tailandia',0),(120,'Ecuador',0),(121,'Lilas',0),(122,'Rosa',0),(123,'Girasol',0),(124,'Orquídea',0),(125,'Dalia',0),(126,'Tulipán',0),(127,'Gardenia',0),(128,'Lirio',0),(129,'Clavel',0),(130,'Azalea',0),(131,'Jazmín',0),(132,'Hortensia',0),(133,'Narciso',0),(134,'Peonía',0),(135,'Violeta',0),(136,'Crisantemo',0),(137,'Begonia',0),(138,'Geranio',0),(139,'Lavanda',0),(140,'Camelia',0),(141,'Floripondio',0),(142,'Amapola',0),(143,'Petunia',0),(144,'Caléndula',0),(145,'Loto',0),(146,'Diente de león',0),(147,'Alelí',0),(148,'Bugambilia',0),(149,'Alhelí',0),(150,'Tulipero',0),(151,'Labial',0),(152,'Sombras',0),(153,'Delineador',0),(154,'Corrector',0),(155,'Rubor',0),(156,'Base',0),(157,'Brochas',0),(158,'Iluminador',0),(159,'Esmalte',0),(160,'Máscara',0),(161,'Pestañas',0),(162,'Contorno',0),(163,'Polvo',0),(164,'Primer',0),(165,'Bronceador',0),(166,'Cejas',0),(167,'Cremas',0),(168,'Paleta',0),(169,'Tonalizador',0),(170,'Esponja',0),(171,'Avión',0),(172,'Teléfono',0),(173,'Mochila',0),(174,'Reloj',0),(175,'Bicicleta',0),(176,'Almohada',0),(177,'Tijeras',0),(178,'Pluma',0),(179,'Llave',0),(180,'Guitarra',0),(181,'Paraguas',0),(182,'Televisión',0),(183,'Sofá',0),(184,'Computadora',0),(185,'Lámpara',0),(186,'Cámara',0),(187,'Cuaderno',0),(188,'Escritorio',0),(189,'Microondas',0),(190,'Piano',0),(191,'Audífonos',0),(192,'Ventilador',0),(193,'Martillo',0),(194,'Tornillo',0),(195,'Maleta',0),(196,'Foco',0),(197,'Escoba',0),(198,'Botella',0),(199,'Ventana',0),(200,'Puerta',0),(201,'Termo',0),(202,'Cargador',0),(203,'Consola',0),(204,'Imán',0),(205,'Cartera',0),(206,'Globo',0),(207,'Mapa',0),(208,'Libro',0),(209,'Bolígrafo',0),(210,'Estufa',0),(211,'Refrán',0),(212,'Sombrero',0),(213,'Colchón',0),(214,'Cuchara',0),(215,'Llanta',0),(216,'Silla',0),(217,'Moneda',0),(218,'Hilo',0),(219,'Toalla',0),(220,'Cepillo',0),(221,'Plato',0),(222,'Escalera',0),(223,'Placa',0),(224,'Vaso',0),(225,'Dron',0),(226,'Revista',0),(227,'Zapatillas',0),(228,'Póster',0),(229,'Estuche',0),(230,'Bolsa',0),(231,'Taladro',0),(232,'Caja',0),(233,'Telescopio',0),(234,'Taza',0),(235,'Barra',0),(236,'Collar',0),(237,'Rojo',0),(238,'Azul',0),(239,'Verde',0),(240,'Amarillo',0),(241,'Negro',0),(242,'Blanco',0),(243,'Naranja',0),(244,'Rosa',0),(245,'Morado',0),(246,'Marrón',0),(247,'Gris',0),(248,'Celeste',0),(249,'Turquesa',0),(250,'Fucsia',0),(251,'Dorado',0),(252,'Perro',0),(253,'Gato',0),(254,'León',0),(255,'Tigre',0),(256,'Elefante',0),(257,'Delfín',0),(258,'Jirafa',0),(259,'Cebra',0),(260,'Pingüino',0),(261,'Caballo',0),(262,'Conejo',0),(263,'Oso',0),(264,'Lobo',0),(265,'Tortuga',0),(266,'Águila',0),(267,'Hidrógeno',0),(268,'Helio',0),(269,'Litio',0),(270,'Berilio',0),(271,'Carbono',0),(272,'Nitrógeno',0),(273,'Oxígeno',0),(274,'Flúor',0),(275,'Neón',0),(276,'Sodio',0),(277,'Magnesio',0),(278,'Aluminio',0),(279,'Silicio',0),(280,'Azufre',0),(281,'Cloro',0),(282,'Hierro',0),(283,'Uranio',0),(284,'Oro',0),(285,'Plata',0),(286,'Platino',0),(287,'Diamante',0),(288,'Rubí',0),(289,'Esmeralda',0),(290,'Zafiro',0),(291,'Jade',0),(292,'Ámbar',0),(293,'Topacio',0),(294,'Cuarzo',0),(295,'Ópalo',0),(296,'Amatista',0),(297,'Turmalina',0),(298,'Berilo',0),(299,'Granate',0),(300,'Crisoprasa',0),(301,'Parangaricutirimicuaro',0);
/*!40000 ALTER TABLE `words` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-22 14:59:41
