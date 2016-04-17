-- ----------------------------
-- Table structure for schedules
-- ----------------------------
DROP TABLE IF EXISTS `schedules`;
CREATE TABLE `schedules` (
  `uid` tinyint(4) NOT NULL AUTO_INCREMENT,
  `route` varchar(10) NOT NULL,
  `stop` varchar(20) NOT NULL,
  `time` varchar(50) NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `route` (`route`,`stop`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedules
-- ----------------------------
INSERT INTO `schedules` VALUES ('1', '3', 'A', '08:00, 12:00, 18:00');
INSERT INTO `schedules` VALUES ('2', '3', 'B', '08:30, 12:30, 18:30');
INSERT INTO `schedules` VALUES ('3', '3', 'D', '10:00, 14:00, 20:00');
INSERT INTO `schedules` VALUES ('4', '9', 'A', '08:10, 12:10, 18:10');
INSERT INTO `schedules` VALUES ('5', '9', 'C', '09:00, 13:00, 19:00');
INSERT INTO `schedules` VALUES ('6', '9', 'D', '11:00, 15:00, 21:00');
