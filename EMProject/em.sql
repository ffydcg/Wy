/*
Navicat MySQL Data Transfer

Source Server         : ff
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : em

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-06-21 16:50:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for complainer
-- ----------------------------
DROP TABLE IF EXISTS `complainer`;
CREATE TABLE `complainer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `com_owner_name` varchar(20) DEFAULT NULL,
  `com_accepter` varchar(20) DEFAULT NULL,
  `com_owner_no` varchar(20) DEFAULT NULL,
  `com_date` datetime DEFAULT NULL,
  `handle_date` datetime DEFAULT NULL,
  `com_content` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of complainer
-- ----------------------------
INSERT INTO `complainer` VALUES ('1', '刘强东', '章泽天', '010004', '2017-03-21 00:00:00', '2017-03-24 00:00:00', '晚上动静太大');
INSERT INTO `complainer` VALUES ('3', '马化腾', '陈辉', '010002', '2016-05-03 00:00:00', '2017-06-01 00:00:00', '水管漏水');
INSERT INTO `complainer` VALUES ('4', '奥巴马', '克里', '010010', '2017-03-21 00:00:00', '2017-03-22 00:00:00', '洗刷间漏水');
INSERT INTO `complainer` VALUES ('10', '马云', '任我行', '010003', '2017-06-21 00:00:00', '2017-06-09 00:00:00', '天天太吵');

-- ----------------------------
-- Table structure for owner
-- ----------------------------
DROP TABLE IF EXISTS `owner`;
CREATE TABLE `owner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `owner_name` varchar(20) DEFAULT NULL,
  `owner_tel` varchar(20) DEFAULT NULL,
  `owner_house_info` varchar(50) DEFAULT NULL,
  `owner_checkin_date` datetime DEFAULT NULL,
  `owner_house_area` varchar(20) DEFAULT NULL,
  `owner_no` varchar(16) DEFAULT NULL,
  `owner_id_card` varchar(30) DEFAULT NULL,
  `owner_house_type` varchar(20) DEFAULT NULL,
  `owner_people_num` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of owner
-- ----------------------------
INSERT INTO `owner` VALUES ('1', '李彦宏', '13006348960', '钓鱼台七号院1栋', '2017-03-02 16:59:09', '150', '010001', '370830197506033588', '毛坯', '2');
INSERT INTO `owner` VALUES ('2', '马化腾', '13006348961', '钓鱼台七号院2栋', '2017-03-02 16:59:17', '136', '010002', '370830197506032259', '精装修', '2');
INSERT INTO `owner` VALUES ('3', '任正非', '13006348962', '钓鱼台七号院3栋', '2017-03-02 16:59:29', '136', '010003', '370830197506032255', '精装修', '5');
INSERT INTO `owner` VALUES ('4', '刘强东', '13006348969', '钓鱼台七号院8栋', '2017-06-20 16:10:16', '288', '010004', '370830197506035892', '精装修', '2');
INSERT INTO `owner` VALUES ('5', '俞敏洪', '13006341125', '钓鱼台七号院5栋', '2017-06-20 21:51:31', '128', '010005', '370830197506035899', '精装修', '3');
INSERT INTO `owner` VALUES ('6', '马云', '13106348969', '华师南湖六栋', '2017-06-21 09:02:21', '128', '010006', '370830197506035892', '精装修', '1');
INSERT INTO `owner` VALUES ('7', '林志玲', '13006348966', '钓鱼台七号院8栋', '2017-06-15 09:46:37', '166', '010007', '370830197506035898', '毛坯房', '1');
INSERT INTO `owner` VALUES ('8', '刘欢', '13016348979', '钓鱼台七号院9栋', '2017-06-15 09:46:37', '175', '010008', '370830197506035868', '毛坯房', '1');
INSERT INTO `owner` VALUES ('9', '奥巴马', '13006346670', '钓鱼台七号院4栋', '2017-06-15 09:46:37', '166', '010009', '370830197506035668', '毛坯房', '1');

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_owner_no` varchar(20) DEFAULT NULL,
  `payment_owner_name` varchar(20) DEFAULT NULL,
  `payment_category` varchar(50) DEFAULT NULL,
  `payment_fee` decimal(10,0) DEFAULT NULL,
  `payment_content` varchar(50) DEFAULT NULL,
  `payment_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('2', '010002', '马化腾', '物业费', '39000', '一年的物业费', '2017-05-31 10:03:35');
INSERT INTO `payment` VALUES ('3', '010003', '任正非', '水电费', '2000', '一年的水电费', '2017-06-21 10:27:45');
INSERT INTO `payment` VALUES ('4', '010004', '刘强东', '物业管理费用', '1000', '500', null);
INSERT INTO `payment` VALUES ('5', '010007', '林志玲', '水电费', '1000', '1000', null);

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `repair_owner_no` varchar(20) DEFAULT NULL,
  `repair_owner_name` varchar(20) DEFAULT NULL,
  `repair_content` varchar(50) DEFAULT NULL,
  `repair_fee` decimal(10,0) DEFAULT NULL,
  `repair_fee_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES ('1', '010007', '林志玲', '地暖', '250', '未缴纳');
INSERT INTO `repair` VALUES ('2', '010008', '刘欢', '地下室', '1000', '已上交');
INSERT INTO `repair` VALUES ('3', '010009', '奥巴马', '厨房', '1200', '已上交');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(33) DEFAULT NULL,
  `user_type` varchar(2) DEFAULT NULL,
  `tel` varchar(17) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'admin', '202cb962ac59075b964b07152d234b70', '1', null, null);
