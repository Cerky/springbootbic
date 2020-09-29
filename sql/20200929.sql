/* 用户信息表 */
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐值',
  `locked` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_user_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户信息';

LOCK TABLES `sys_user` WRITE;
INSERT INTO `sys_user` VALUES (1,'cerky','123456','123',0),(2,'root','123456','321',0),(3,'admin','123456','adm',0);
UNLOCK TABLES;


/* 角色表 */
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `pid` bigint(20) DEFAULT NULL COMMENT '父节点',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_role_role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色';

LOCK TABLES `sys_role` WRITE;
INSERT INTO `sys_role` VALUES (1,'超级管理员','超级管理员权限描述',0,0),(2,'系统管理员','系统管理员权限描述',0,0),(3,'一般管理员','一般管理员权限描述',0,0);
UNLOCK TABLES;


/* 权限表 */
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `permission` varchar(100) DEFAULT NULL COMMENT '权限编号',
  `description` varchar(100) DEFAULT NULL COMMENT '权限描述',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_permission_permission` (`permission`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='资源权限';

LOCK TABLES `sys_permission` WRITE;
INSERT INTO `sys_permission` VALUES (1,'user:insert','用户增加',0),(2,'user:delete','用户删除',0),(3,'user:update','用户修改',0),(4,'user:select','用户查询',0);
UNLOCK TABLES;


/* 用户-角色映射 */
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户-角色映射';

LOCK TABLES `sys_user_role` WRITE;
INSERT INTO `sys_user_role` VALUES (1,1,1),(2,2,1),(3,2,3);
UNLOCK TABLES;


/* 角色-权限映射 */
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色-权限映射';

LOCK TABLES `sys_role_permission` WRITE;
INSERT INTO `sys_role_permission` VALUES (1,1,1),(2,1,1),(3,1,2),(4,1,3),(5,1,4),(6,2,1),(7,2,1),(8,3,1);
UNLOCK TABLES;
