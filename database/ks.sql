/*
Navicat MySQL Data Transfer

Source Server         : keshe
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : ks

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-12-26 16:47:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_car
-- ----------------------------
DROP TABLE IF EXISTS `tb_car`;
CREATE TABLE `tb_car` (
  `id` varchar(50) NOT NULL,
  `type` varchar(100) NOT NULL,
  `volume` int(10) NOT NULL,
  `inTime` date NOT NULL,
  `value` int(10) NOT NULL,
  `isOk` int(10) NOT NULL,
  `state` varchar(100) NOT NULL,
  `notes` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_car
-- ----------------------------
INSERT INTO `tb_car` VALUES ('123', '123', '123', '2012-11-11', '123', '123', '123', '213');
INSERT INTO `tb_car` VALUES ('甘A11133', '轿车', '5', '2018-01-08', '50000', '1', '空闲', null);
INSERT INTO `tb_car` VALUES ('甘A12345', '客车', '30', '2018-01-08', '455645', '1', '空闲', '');
INSERT INTO `tb_car` VALUES ('甘A65666', '货车', '1', '2018-01-09', '122100', '0', '使用中', '');
INSERT INTO `tb_car` VALUES ('甘A66666', '轿车', '3', '2018-01-08', '1200000', '1', '空闲', '');
INSERT INTO `tb_car` VALUES ('甘A98989', '轿车', '5', '2018-01-08', '100000', '1', '空闲', null);
INSERT INTO `tb_car` VALUES ('甘A99999', '轿车', '4', '2018-01-08', '200000', '1', '空闲', null);
INSERT INTO `tb_car` VALUES ('甘LF4668', '轿车', '4', '2018-01-08', '70000', '0', '维修', '');

-- ----------------------------
-- Table structure for tb_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department` (
  `id` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `department` varchar(200) NOT NULL,
  `head` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_department
-- ----------------------------
INSERT INTO `tb_department` VALUES ('1111', '1111', '财务部', '小明', '18793326380');
INSERT INTO `tb_department` VALUES ('2222', '2222', '技术部', '小李', '18993337191');
INSERT INTO `tb_department` VALUES ('3333', '3333', '后勤部', '小张', '15639966552');

-- ----------------------------
-- Table structure for tb_drivers
-- ----------------------------
DROP TABLE IF EXISTS `tb_drivers`;
CREATE TABLE `tb_drivers` (
  `id` int(20) NOT NULL,
  `type` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `isOk` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_drivers
-- ----------------------------
INSERT INTO `tb_drivers` VALUES ('1', '客车', '张三', '15693399667', '空闲', '1');
INSERT INTO `tb_drivers` VALUES ('2', '货车', '王五', '18793326380', '空闲', '1');
INSERT INTO `tb_drivers` VALUES ('3', '轿车', '李四', '13245679811', '空闲', '1');
INSERT INTO `tb_drivers` VALUES ('4', '轿车', '赵六', '1546559811', '请假', '0');

-- ----------------------------
-- Table structure for tb_spendcard
-- ----------------------------
DROP TABLE IF EXISTS `tb_spendcard`;
CREATE TABLE `tb_spendcard` (
  `id` int(20) NOT NULL,
  `carId` varchar(50) NOT NULL,
  `spendMoney` int(50) NOT NULL,
  `reason` varchar(500) NOT NULL,
  `time` datetime NOT NULL,
  `notes` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_spendcard
-- ----------------------------
INSERT INTO `tb_spendcard` VALUES ('1', '甘LF4668', '2000', '维修', '2018-01-06 22:42:41', '事故维修');
INSERT INTO `tb_spendcard` VALUES ('2', '甘A12345', '1000', '保养', '2018-01-06 22:44:59', '保养');
INSERT INTO `tb_spendcard` VALUES ('3', '3123213', '12222', '事故', '2014-12-11 00:00:00', '544655465');
INSERT INTO `tb_spendcard` VALUES ('12', '1', '1', '保养', '2012-01-01 00:00:00', '445545454');
INSERT INTO `tb_spendcard` VALUES ('123', '12312', '1223', '事故', '2014-08-08 00:00:00', '3123');
INSERT INTO `tb_spendcard` VALUES ('1232', '11133811', '3421', '事故', '2011-09-09 00:00:00', '');
INSERT INTO `tb_spendcard` VALUES ('2131', '3123213', '12222', '事故', '2014-12-11 00:00:00', '544655465');
INSERT INTO `tb_spendcard` VALUES ('4554', '54645', '54654', '加油', '2011-01-01 00:00:00', '');
INSERT INTO `tb_spendcard` VALUES ('4564', '1', '11', '事故', '2014-04-04 00:00:00', '');
INSERT INTO `tb_spendcard` VALUES ('12344', '123123', '123', '事故', '2014-04-04 00:00:00', '');
INSERT INTO `tb_spendcard` VALUES ('77777', '11133811', '45455', '事故', '2015-01-01 00:00:00', '454545');
INSERT INTO `tb_spendcard` VALUES ('212313', '1231', '12', '事故', '2010-01-01 00:00:00', '1111');

-- ----------------------------
-- Table structure for tb_usecard
-- ----------------------------
DROP TABLE IF EXISTS `tb_usecard`;
CREATE TABLE `tb_usecard` (
  `id` int(20) NOT NULL,
  `departmentId` int(20) NOT NULL,
  `carId` varchar(50) NOT NULL,
  `startTime` date NOT NULL,
  `endTime` date NOT NULL,
  `head` varchar(100) NOT NULL,
  `driverName` varchar(100) NOT NULL,
  `notes` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_usecard
-- ----------------------------
INSERT INTO `tb_usecard` VALUES ('1', '1111', '甘LF4668', '2018-01-08', '2018-01-10', '小明', '赵六', '已还');
INSERT INTO `tb_usecard` VALUES ('767', '1111', '甘A11133', '2018-01-11', '2018-01-11', '财务部', '李四', '已还');
INSERT INTO `tb_usecard` VALUES ('2078', '1111', '甘A12345', '2018-01-11', '2018-01-11', '财务部', '张三', '已还');
INSERT INTO `tb_usecard` VALUES ('7853', '1111', '甘A99999', '2018-01-11', '2018-01-11', '财务部', '李四', '已还');
INSERT INTO `tb_usecard` VALUES ('123123', '1111', '123', '2011-01-01', '2011-01-01', '21', '12121', '21212');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(200) NOT NULL,
  `phoneNumber` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `isOk` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('123', '123', '李俊杰', '16533665633', '男', '1');
INSERT INTO `tb_user` VALUES ('11133811', '11133811', '白宝宝', '65646546546', '男', '1');
