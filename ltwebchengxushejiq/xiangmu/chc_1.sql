/*
Navicat MySQL Data Transfer

Source Server         : chc
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : chc

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-06-09 20:26:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');
INSERT INTO `admin` VALUES ('2', '程洪池', '123');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '照片',
  `book_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书名',
  `book_price` decimal(10,2) NOT NULL COMMENT '价格',
  `book_category` varchar(20) NOT NULL COMMENT '种类',
  `book_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '介绍',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('8', 'F:\\BookMall\\WebContent\\image\\1499226_000_160.jpg', '禁断的魔术', '42.10', '文学', '东野圭吾中意之作，《嫌疑人X的献身》系列作全新长篇小说');
INSERT INTO `book` VALUES ('9', 'F:\\BookMall\\WebContent\\image\\1534221_000_160.jpg', '撒野.2', '42.30', '文学', '超人气作者巫哲至高人气代表作');
INSERT INTO `book` VALUES ('10', 'F:\\BookMall\\WebContent\\image\\5201011_160.jpg.png', '其实你很好', '58.00', '社科', '写给焦虑、不安、自卑和在内心深处担心自己不够好的你，愿你与自己和解、爱并接纳自己 因百万级英语畅销书《考拉小巫的英语学习日记》被读者熟知的考拉小巫，回归自身专业领域，用通俗易懂的语言，帮你学会如何应对内心的焦虑。');
INSERT INTO `book` VALUES ('11', 'F:\\BookMall\\WebContent\\image\\5205068_160.jpg.png', '人工智能营销', '89.00', '经管', '《人工智能营销》介绍了大热的“人工智能”在营销中的具体应用场景。 大数据和机器学习的概念对大多数人来说并不陌生，而在营销如何使用却一直一知半解，语焉不详。营销行业未来最缺乏的应该就是和数据工作者对话的营销人，多看几遍这本书，结合正在进行的工作实践，你将会觉得投入阅读的时间物有所值。');
INSERT INTO `book` VALUES ('12', 'F:\\BookMall\\WebContent\\image\\160_d422b8bca867492282df44aa352ecab1.png', '神奇的手账整理魔法', '68.00', '生活', '这是一本教你写手账、整理手账，以及如何挑到适合自己的手账和文具的书。');
INSERT INTO `book` VALUES ('13', 'F:\\BookMall\\WebContent\\image\\160_b1670d98626c4185958bf563c6c1b72d.png', '能力陷阱', '56.00', '社科', '  我们很乐于去做那些我们擅长的事，于是就会一直去做，最终就使得我们会一直擅长那些事。');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'chc', '123');
INSERT INTO `user` VALUES ('2', '程', '123');
INSERT INTO `user` VALUES ('3', '李四', '235');
INSERT INTO `user` VALUES ('4', '王五', '456');
INSERT INTO `user` VALUES ('5', '张三', '258');
INSERT INTO `user` VALUES ('6', '赵六', '52365');
