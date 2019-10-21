
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                             `uid` int(11) NOT NULL AUTO_INCREMENT,
                             `username` varchar(50) DEFAULT '' COMMENT '用户名',
                             `password` varchar(256) DEFAULT NULL COMMENT '登录密码',
                             `phone` varchar(256) DEFAULT NULL COMMENT '手机号码',
                             `mail` varchar(50) default null comment '邮箱',
                             `qq` varchar(50) default null comment 'QQ',
                             `sex` varchar(10) default null comment '性别',
                             `name` varchar(256) DEFAULT NULL COMMENT '用户真实姓名',
                             `state` char(1) DEFAULT '0' COMMENT '用户状态：0:正常状态,1：用户被锁定',
                             PRIMARY KEY (`uid`),
                             UNIQUE KEY `username` (`username`) USING BTREE,
                             UNIQUE KEY `id_card_num` (`phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;