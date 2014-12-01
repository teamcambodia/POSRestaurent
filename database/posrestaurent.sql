/*
Navicat MySQL Data Transfer

Source Server         : INTER-PC3
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : posrestaurent

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2014-12-01 11:01:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(80) NOT NULL,
  `user_pass` varchar(80) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Channath', 'channath');
INSERT INTO `user` VALUES ('2', 'Nimol', 'nimol');
INSERT INTO `user` VALUES ('3', 'Samnang', 'samnang');
