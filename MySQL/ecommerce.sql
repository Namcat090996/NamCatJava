-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: ecommerce
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `approved`
--

DROP TABLE IF EXISTS `approved`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `approved` (
  `id` int NOT NULL,
  `approved` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `approved_UNIQUE` (`approved`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approved`
--

LOCK TABLES `approved` WRITE;
/*!40000 ALTER TABLE `approved` DISABLE KEYS */;
INSERT INTO `approved` VALUES (0,'Chưa duyệt'),(1,'Đã duyệt');
/*!40000 ALTER TABLE `approved` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `product_id` varchar(50) NOT NULL,
  `quantity` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `total_price` int DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user_product` (`username`,`product_id`),
  KEY `fk_user_idx` (`username`),
  KEY `fk_product_id_idx` (`product_id`),
  CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `fk_user_cart` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (23,'admin','SP06',6,11500000,69000000,'1.jpg','Samsung Galaxy S24  '),(24,'admin','SP10',2,6400000,12800000,'8.jpg','Máy tính bảng Amazon Fire 7 '),(25,'admin','SP07',1,9500000,9500000,'12.jpg','Samsung Galaxy S23 '),(26,'admin','SP12',1,9500000,9500000,'12.jpg','Samsung Galaxy S23 ');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('Laptop'),('Màn hình'),('Máy tính bảng'),('Tai nghe'),('Điện thoại');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color` (
  `id` int NOT NULL AUTO_INCREMENT,
  `color` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `colorcol_UNIQUE` (`color`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (4,'Hồng'),(5,'Tím'),(3,'Trắng'),(2,'Vàng'),(6,'Xanh'),(1,'Đỏ');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` varchar(50) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_image_p_idx` (`product_id`),
  CONSTRAINT `fk_image_p` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (39,'SP14','4.jpg'),(40,'SP14','5.jpg'),(41,'SP14','6.jpg'),(42,'SP14','7.jpg'),(43,'SP14','8.jpg'),(44,'SP14','9.jpg'),(45,'SP05','10.jpg'),(46,'SP05','11.jpg'),(47,'SP05','12.jpg'),(48,'SP06','1.jpg'),(49,'SP06','2.jpg'),(50,'SP06','3.jpg'),(51,'SP06','4.jpg'),(52,'SP06','5.jpg'),(53,'SP06','6.jpg'),(54,'SP06','7.jpg');
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `money_range`
--

DROP TABLE IF EXISTS `money_range`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `money_range` (
  `value` int NOT NULL,
  PRIMARY KEY (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `money_range`
--

LOCK TABLES `money_range` WRITE;
/*!40000 ALTER TABLE `money_range` DISABLE KEYS */;
INSERT INTO `money_range` VALUES (5000000),(6000000),(7000000),(8000000),(9000000),(10000000),(11000000),(12000000);
/*!40000 ALTER TABLE `money_range` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_code` varchar(50) NOT NULL,
  `product_id` varchar(50) NOT NULL,
  `quantity` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_code_idx` (`order_code`),
  KEY `fk_order_product_idx` (`product_id`),
  CONSTRAINT `fk_order_code` FOREIGN KEY (`order_code`) REFERENCES `p_order` (`order_code`),
  CONSTRAINT `fk_order_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,'OD001','SP02',3,5000000);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `p_order`
--

DROP TABLE IF EXISTS `p_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `p_order` (
  `order_code` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `create_date` date NOT NULL,
  `status` varchar(50) NOT NULL,
  `total_price` int NOT NULL,
  `order_name` varchar(255) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `user_create` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_code`),
  KEY `fk_user_idx` (`username`),
  KEY `fk_user_create_idx` (`user_create`),
  KEY ` fk_status_idx` (`status`),
  CONSTRAINT `fk_status` FOREIGN KEY (`status`) REFERENCES `status` (`name`),
  CONSTRAINT `fk_user_creat` FOREIGN KEY (`user_create`) REFERENCES `user` (`username`),
  CONSTRAINT `fk_user_order` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `p_order`
--

LOCK TABLES `p_order` WRITE;
/*!40000 ALTER TABLE `p_order` DISABLE KEYS */;
INSERT INTO `p_order` VALUES ('OD001','admin','2024-12-14','PENDING',7500000,'Electronics',NULL,'admin'),('OD002','customer','2024-12-15','PENDING',15000000,'Tablet',NULL,'admin');
/*!40000 ALTER TABLE `p_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int NOT NULL,
  `stock` int NOT NULL,
  `category` varchar(50) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `p_content` varchar(1000) DEFAULT NULL,
  `create_day` date DEFAULT NULL,
  `user_create` varchar(50) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `approved_date` date DEFAULT NULL,
  `user_approved` varchar(50) DEFAULT NULL,
  `p_approved` int DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `fk_user_create_idx` (`user_create`),
  KEY `fk_user_approved_idx` (`user_approved`),
  KEY `fk_color_idx` (`color`),
  KEY `fk_category_idx` (`category`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category`) REFERENCES `category` (`name`),
  CONSTRAINT `fk_color` FOREIGN KEY (`color`) REFERENCES `color` (`color`),
  CONSTRAINT `fk_user_approved` FOREIGN KEY (`user_approved`) REFERENCES `user` (`username`),
  CONSTRAINT `fk_user_create` FOREIGN KEY (`user_create`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('SP01','Samsung Galaxy S24  ',11500000,50,'Điện thoại','10.jpg','12GB 512GB','Samsung Galaxy S24 Ultra 512GB là siêu phẩm công nghệ mà hãng muốn mang tới thị trường trong thời gian tới. Được trang bị rất nhiều tính năng hiện đại từ hiệu năng tới camera, cùng với đó là thiết kế siêu đỉnh. Chắc chắn rằng đây sẽ là sản phẩm mà bất kỳ ai cũng mong muốn sở hữu.','2024-12-15','admin','2024-12-15',NULL,NULL,0,NULL),('SP02','Samsung Galaxy S23 ',9500000,5,'Điện thoại','12.jpg','12GB 512GB','Samsung Galaxy S24 Ultra 512GB là siêu phẩm công nghệ mà hãng muốn mang tới thị trường trong thời gian tới. Được trang bị rất nhiều tính năng hiện đại từ hiệu năng tới camera, cùng với đó là thiết kế siêu đỉnh. Chắc chắn rằng đây sẽ là sản phẩm mà bất kỳ ai cũng mong muốn sở hữu.','2024-12-15','admin','2024-12-15',NULL,NULL,0,NULL),('SP03','Màn hình LG UltraWide ',10500000,3,'Màn hình','1.jpg','29WQ600 29 inch','Màn hình LG Ultrawide 29WQ600 29 inch được cấu tạo từ tấm nền IPS chuẩn FHD với độ phân giải 2560*1080 cho chất lượng hình ảnh luôn chi tiết và rõ nét. Sản phẩm tái tạo màu sắc rực rỡ nhờ tích hợp HDR 10 và gam màu sRGB 99%. Tốc độ làm tươi 100Hz cùng công nghệ AMD FreeSync đảm bảo chuyển động khung hình mượt mà và độ trễ thấp. Thiết kế thiết bị cực bắt mắt, hầu như không thấy đường viền ở 3 cạnh màn hình. ','2024-12-15','admin',NULL,NULL,NULL,0,'Tím'),('SP04','Màn hình MSI UltraWide',11500000,5,'Màn hình','4.jpg','29 inch','Màn hình LG Ultrawide 29WQ600 29 inch được cấu tạo từ tấm nền IPS chuẩn FHD với độ phân giải 2560*1080 cho chất lượng hình ảnh luôn chi tiết và rõ nét. Sản phẩm tái tạo màu sắc rực rỡ nhờ tích hợp HDR 10 và gam màu sRGB 99%. Tốc độ làm tươi 100Hz cùng công nghệ AMD FreeSync đảm bảo chuyển động khung hình mượt mà và độ trễ thấp. Thiết kế thiết bị cực bắt mắt, hầu như không thấy đường viền ở 3 cạnh màn hình. ','2024-12-15','admin',NULL,NULL,NULL,0,'Đỏ'),('SP05','Máy tính bảng Amazon Fire 7 ',6400000,10,'Máy tính bảng','10.jpg','HD7 IPS 1GB 16GB Đen','Sản phẩm máy tính bảng Amazon Kindle HD Fire 7 không chỉ là chiếc máy tính bảng nhỏ gọn, giá cả phải chăng nhưng vẫn tích hợp đầy đủ ứng dụng công nghệ hiện đại, mà còn là một một lựa chọn thay thế iPad hoặc các dòng tablet đắt tiền khác trên thị trường.','2024-12-15','admin','2024-12-22',NULL,NULL,0,NULL),('SP06','Samsung Galaxy S24  ',11500000,50,'Điện thoại','1.jpg','12GB 512GB','Samsung Galaxy S24 Ultra 512GB là siêu phẩm công nghệ mà hãng muốn mang tới thị trường trong thời gian tới. Được trang bị rất nhiều tính năng hiện đại từ hiệu năng tới camera, cùng với đó là thiết kế siêu đỉnh. Chắc chắn rằng đây sẽ là sản phẩm mà bất kỳ ai cũng mong muốn sở hữu.','2024-12-15','admin','2024-12-23','2024-12-21','admin',1,NULL),('SP07','Samsung Galaxy S23 ',9500000,5,'Điện thoại','12.jpg','12GB 512GB','Samsung Galaxy S24 Ultra 512GB là siêu phẩm công nghệ mà hãng muốn mang tới thị trường trong thời gian tới. Được trang bị rất nhiều tính năng hiện đại từ hiệu năng tới camera, cùng với đó là thiết kế siêu đỉnh. Chắc chắn rằng đây sẽ là sản phẩm mà bất kỳ ai cũng mong muốn sở hữu.','2024-12-15','admin',NULL,'2024-12-21','admin',1,'Hồng'),('SP08','Màn hình LG UltraWide ',10500000,3,'Màn hình','1.jpg','29WQ600 29 inch','Màn hình LG Ultrawide 29WQ600 29 inch được cấu tạo từ tấm nền IPS chuẩn FHD với độ phân giải 2560*1080 cho chất lượng hình ảnh luôn chi tiết và rõ nét. Sản phẩm tái tạo màu sắc rực rỡ nhờ tích hợp HDR 10 và gam màu sRGB 99%. Tốc độ làm tươi 100Hz cùng công nghệ AMD FreeSync đảm bảo chuyển động khung hình mượt mà và độ trễ thấp. Thiết kế thiết bị cực bắt mắt, hầu như không thấy đường viền ở 3 cạnh màn hình. ','2024-12-15','admin',NULL,'2024-12-21','admin',1,'Tím'),('SP09','Màn hình MSI UltraWide',11500000,5,'Màn hình','4.jpg','29 inch','Màn hình LG Ultrawide 29WQ600 29 inch được cấu tạo từ tấm nền IPS chuẩn FHD với độ phân giải 2560*1080 cho chất lượng hình ảnh luôn chi tiết và rõ nét. Sản phẩm tái tạo màu sắc rực rỡ nhờ tích hợp HDR 10 và gam màu sRGB 99%. Tốc độ làm tươi 100Hz cùng công nghệ AMD FreeSync đảm bảo chuyển động khung hình mượt mà và độ trễ thấp. Thiết kế thiết bị cực bắt mắt, hầu như không thấy đường viền ở 3 cạnh màn hình. ','2024-12-15','admin',NULL,'2024-12-21','admin',1,'Đỏ'),('SP10','Máy tính bảng Amazon Fire 7 ',6400000,10,'Máy tính bảng','8.jpg','HD7 IPS 1GB 16GB Đen','Sản phẩm máy tính bảng Amazon Kindle HD Fire 7 không chỉ là chiếc máy tính bảng nhỏ gọn, giá cả phải chăng nhưng vẫn tích hợp đầy đủ ứng dụng công nghệ hiện đại, mà còn là một một lựa chọn thay thế iPad hoặc các dòng tablet đắt tiền khác trên thị trường.','2024-12-15','admin',NULL,'2024-12-17','admin',1,'Đỏ'),('SP12','Samsung Galaxy S23 ',9500000,5,'Điện thoại','12.jpg','12GB 512GB','Samsung Galaxy S24 Ultra 512GB là siêu phẩm công nghệ mà hãng muốn mang tới thị trường trong thời gian tới. Được trang bị rất nhiều tính năng hiện đại từ hiệu năng tới camera, cùng với đó là thiết kế siêu đỉnh. Chắc chắn rằng đây sẽ là sản phẩm mà bất kỳ ai cũng mong muốn sở hữu.','2024-12-15','admin',NULL,'2024-12-17','admin',1,'Hồng'),('SP13','Màn hình LG UltraWide ',10500000,3,'Màn hình','1.jpg','29WQ600 29 inch','Màn hình LG Ultrawide 29WQ600 29 inch được cấu tạo từ tấm nền IPS chuẩn FHD với độ phân giải 2560*1080 cho chất lượng hình ảnh luôn chi tiết và rõ nét. Sản phẩm tái tạo màu sắc rực rỡ nhờ tích hợp HDR 10 và gam màu sRGB 99%. Tốc độ làm tươi 100Hz cùng công nghệ AMD FreeSync đảm bảo chuyển động khung hình mượt mà và độ trễ thấp. Thiết kế thiết bị cực bắt mắt, hầu như không thấy đường viền ở 3 cạnh màn hình. ','2024-12-15','admin',NULL,'2024-12-17','admin',1,'Tím'),('SP14','Màn hình MSI UltraWide',11500000,5,'Màn hình','4.jpg','29 inch','Màn hình LG Ultrawide 29WQ600 29 inch được cấu tạo từ tấm nền IPS chuẩn FHD với độ phân giải 2560*1080 cho chất lượng hình ảnh luôn chi tiết và rõ nét. Sản phẩm tái tạo màu sắc rực rỡ nhờ tích hợp HDR 10 và gam màu sRGB 99%. Tốc độ làm tươi 100Hz cùng công nghệ AMD FreeSync đảm bảo chuyển động khung hình mượt mà và độ trễ thấp. Thiết kế thiết bị cực bắt mắt, hầu như không thấy đường viền ở 3 cạnh màn hình. ','2024-12-15','admin','2024-12-22','2024-12-17','admin',1,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `name` varchar(70) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('admin'),('approver'),('customer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES ('ACCEPTED'),('CANCELED'),('PENDING');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `role` varchar(70) NOT NULL,
  `address` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  KEY `fk_role_idx` (`role`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role`) REFERENCES `role` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','$2a$10$1QD9Gmdb7AwRI9wuHZDQmeCHEotxy6W.RTAMLlRE9cqzcJmMGxPnG','admin@gmail.com','admin','0123456789','admin','Da Nang'),('approver','$2a$10$MhNVbPaeIunmrZnuNkcT6ecLLInocUr8oROtuYxW0Vm/mut6LVr/.','approver@gmail.com','Huỳnh Nam Cát','0703039949','approver','Hà Nội'),('customer','$2a$10$CKVLu/PweNXh5Zsh2h8Sv.lr2yBSMTaKdSXB/MS0rOm2M2n3.xQ1q','customer@gmail.com','customeer','0123456788','customer','Ha Noi');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ecommerce'
--

--
-- Dumping routines for database 'ecommerce'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-24  0:00:50
