/*
Navicat MySQL Data Transfer

Source Server         : 3308
Source Server Version : 50727
Source Host           : localhost:3308
Source Database       : jpa

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2021-01-15 14:55:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jpa_cutomers
-- ----------------------------
CREATE TABLE `JPA_CUSTOMERS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `birth` date DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `addr_id` int(10) DEFAULT NULL,
  `createdTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jpa_cutomers
-- ----------------------------
INSERT INTO `jpa_cutomers` VALUES ('1', '35', '1998-06-10', '2020-11-02 14:07:21', 'tony@163.com', 'AA');

-- ----------------------------
-- Table structure for jpa_persons
-- ----------------------------

CREATE TABLE `JPA_PERSONS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Records of jpa_persons
-- ----------------------------
INSERT INTO `jpa_persons` VALUES ('2', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('3', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('4', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('5', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('6', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('7', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('8', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('9', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('10', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('11', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('12', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('13', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('14', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('15', '2', '', '6');
INSERT INTO `jpa_persons` VALUES ('16', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('17', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('18', null, '5', '6');
INSERT INTO `jpa_persons` VALUES ('19', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('20', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('21', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('22', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('23', '2', '', '6');
INSERT INTO `jpa_persons` VALUES ('24', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('25', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('26', '2', '5', '6');
INSERT INTO `jpa_persons` VALUES ('27', '2', '5', '6');

CREATE TABLE `JPA_ADDRESSES` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

