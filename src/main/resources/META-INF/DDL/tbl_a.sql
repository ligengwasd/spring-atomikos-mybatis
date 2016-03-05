/*
Navicat MySQL Data Transfer

Source Server         : adatasource-3312
Source Server Version : 50530
Source Host           : localhost:3312
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2016-03-05 16:33:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_a
-- ----------------------------
DROP TABLE IF EXISTS `tbl_a`;
CREATE TABLE `tbl_a` (
  `a1` int(11) NOT NULL DEFAULT '0',
  `a2` char(10) DEFAULT NULL,
  PRIMARY KEY (`a1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_a
-- ----------------------------
INSERT INTO `tbl_a` VALUES ('1', 'a');
