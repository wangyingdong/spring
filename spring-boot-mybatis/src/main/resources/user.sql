

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `email` varchar(120) NOT NULL,
  `password_hash` varchar(128) NOT NULL,
  `avatar` varchar(128) NOT NULL,
  `address` varchar(128),
  `sex` varchar(5),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', 'test12345@qq.com', 'passwd', 'avaterpath',null,null);
INSERT INTO `user` VALUES ('2', 'lisi', '12345test@qq.com', 'passwd', 'avaterpath',null,null);
INSERT INTO `user` VALUES ('3', 'wangwu', 'wangwu@163.com', '', '',null,null);
INSERT INTO `user` VALUES ('4', 'zhaolu', 'zhaoliu@sina.com', '1', '2',null,null);
INSERT INTO `user` VALUES ('5', 'sunqi', 'sunqi2@foxmail.com', '1', '1222','江苏省,无锡市,新安花苑','man');
