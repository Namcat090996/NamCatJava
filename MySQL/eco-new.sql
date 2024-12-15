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
  PRIMARY KEY (`id`),
  KEY `fk_user_idx` (`username`),
  KEY `fk_product_id_idx` (`product_id`),
  CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `fk_user_cart` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
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
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_code` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `create` date NOT NULL,
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
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES ('OD001','admin','2024-12-14','PENDING',7500000,'Electronics',NULL,'admin');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
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
  CONSTRAINT `fk_order_code` FOREIGN KEY (`order_code`) REFERENCES `order` (`order_code`),
  CONSTRAINT `fk_order_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,'OD001','DT01',3,5000000);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
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
  `content` varchar(1000) DEFAULT NULL,
  `create` date DEFAULT NULL,
  `user_create` varchar(50) DEFAULT NULL,
  `update` date DEFAULT NULL,
  `approved_date` date DEFAULT NULL,
  `user_approved` varchar(50) DEFAULT NULL,
  `approved` int DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
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
INSERT INTO `product` VALUES ('DT01','Samsung Galaxy S24 Ultra 12GB 512GB',7500000,1000,'Điện thoại','ss-s24-ultra-xam-222.webp','Samsung Galaxy S24 Ultra 512GB là siêu phẩm công nghệ mà hãng muốn mang tới thị trường trong thời gian tới. Được trang bị rất nhiều tính năng hiện đại từ hiệu năng tới camera, cùng với đó là thiết kế siêu đỉnh. Chắc chắn rằng đây sẽ là sản phẩm mà bất kỳ ai cũng mong muốn sở hữu.',NULL,NULL,'admin',NULL,NULL,'admin',0,'Đỏ'),('LT01','Laptop MSI Prestige 14 AI Studio C1UDXG-058VN',5000000,5,'Laptop','text_d_i_1__3_14.webp','Laptop MSI Prestige 14 AI Studio C1UDXG-058VN là một mẫu laptop MSI Prestige cao cấp, được thiết kế để phục vụ các chuyên gia sáng tạo nội dung với hiệu suất mạnh mẽ và thiết kế thanh lịch. Máy nổi bật với bộ vi xử lý Intel Core thế hệ 13 cùng card đồ họa NVIDIA GeForce RTX, mang lại sức mạnh xử lý tốt cho cả những công việc yêu cầu khả năng đồ họa cao. ',NULL,NULL,'admin',NULL,NULL,'admin',0,'Đỏ'),('MH01','Màn hình LG UltraWide 29WQ600 29 inch',10500000,3,'Màn hình','group_179_1__4_3.webp','Màn hình LG Ultrawide 29WQ600 29 inch được cấu tạo từ tấm nền IPS chuẩn FHD với độ phân giải 2560*1080 cho chất lượng hình ảnh luôn chi tiết và rõ nét. Sản phẩm tái tạo màu sắc rực rỡ nhờ tích hợp HDR 10 và gam màu sRGB 99%. Tốc độ làm tươi 100Hz cùng công nghệ AMD FreeSync đảm bảo chuyển động khung hình mượt mà và độ trễ thấp. Thiết kế thiết bị cực bắt mắt, hầu như không thấy đường viền ở 3 cạnh màn hình. ',NULL,NULL,'admin',NULL,NULL,'admin',1,'Tím'),('MH02','Màn hình MSI UltraWide 29 inch',11500000,5,'Điện thoại','group_258_5.webp','Màn hình LG Ultrawide 29WQ600 29 inch được cấu tạo từ tấm nền IPS chuẩn FHD với độ phân giải 2560*1080 cho chất lượng hình ảnh luôn chi tiết và rõ nét. Sản phẩm tái tạo màu sắc rực rỡ nhờ tích hợp HDR 10 và gam màu sRGB 99%. Tốc độ làm tươi 100Hz cùng công nghệ AMD FreeSync đảm bảo chuyển động khung hình mượt mà và độ trễ thấp. Thiết kế thiết bị cực bắt mắt, hầu như không thấy đường viền ở 3 cạnh màn hình. ',NULL,NULL,'admin',NULL,NULL,'admin',0,'Đỏ'),('MT01','Máy tính bảng Amazon Fire 7 tablet HD7 IPS 1GB 16GB Đen',6400000,10,'Máy tính bảng','_0002_6351530_sd.jpgmaxheight640maxwid_2.webp','Sản phẩm máy tính bảng Amazon Kindle HD Fire 7 không chỉ là chiếc máy tính bảng nhỏ gọn, giá cả phải chăng nhưng vẫn tích hợp đầy đủ ứng dụng công nghệ hiện đại, mà còn là một một lựa chọn thay thế iPad hoặc các dòng tablet đắt tiền khác trên thị trường.',NULL,NULL,'admin',NULL,NULL,'admin',1,'Đỏ'),('MT02','Máy tính bảng Amazon Fire 7 tablet HD7 IPS 1GB 16GB Trắng',9500000,5,'Máy tính bảng','ss-s24-ultra-xam-222.webp','Sản phẩm máy tính bảng Amazon Kindle HD Fire 7 không chỉ là chiếc máy tính bảng nhỏ gọn, giá cả phải chăng nhưng vẫn tích hợp đầy đủ ứng dụng công nghệ hiện đại, mà còn là một một lựa chọn thay thế iPad hoặc các dòng tablet đắt tiền khác trên thị trường.',NULL,NULL,'admin',NULL,NULL,'admin',1,'Vàng'),('TN01','Tai nghe Bluetooth True Wireless Anker Soundcore R50i A3949',12000000,7,'Tai nghe','tai-nghe-khong-day-anker-soundcore-r50i-a3949_2_.webp','Tai nghe không dây Anker Soundcore R50I-A3949 là mẫu tai nghe Anker mới được trang bị nhiều tính năng nổi bật. Sản phẩm tai nghe không dây này với tạo hình hiện đại, chất lượng âm thanh xuất sắc cùng nhiều tính năng đột phá, Anker Soundcore R50I dễ dàng làm hài lòng ngay cả những người dùng yêu âm nhạc khó tính nhất',NULL,NULL,'admin',NULL,NULL,'admin',1,'Vàng');
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
INSERT INTO `role` VALUES ('admin'),('customer');
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
INSERT INTO `user` VALUES ('admin','$2a$10$1QD9Gmdb7AwRI9wuHZDQmeCHEotxy6W.RTAMLlRE9cqzcJmMGxPnG','admin@gmail.com','admin','0123456789','admin','Da Nang'),('customer','$2a$10$CKVLu/PweNXh5Zsh2h8Sv.lr2yBSMTaKdSXB/MS0rOm2M2n3.xQ1q','customer@gmail.com','customeer','0123456788','customer','Ha Noi');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ecommerce'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-15 10:52:15
