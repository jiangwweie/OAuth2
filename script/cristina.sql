/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : cristina

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 16/12/2020 15:16:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for broker_message_log
-- ----------------------------
DROP TABLE IF EXISTS `broker_message_log`;
CREATE TABLE `broker_message_log` (
  `message_id` varchar(128) NOT NULL COMMENT '订单消息唯一id',
  `message` varchar(4000) DEFAULT NULL COMMENT '消息内容',
  `try_count` int(11) DEFAULT '0' COMMENT '重试次数',
  `status` varchar(10) DEFAULT NULL COMMENT '投递状态，0投递中，1成功，2失败',
  `next_retry` varchar(100) NOT NULL,
  `create_time` varchar(100) NOT NULL,
  `update_time` varchar(100) NOT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of broker_message_log
-- ----------------------------
BEGIN;
INSERT INTO `broker_message_log` VALUES ('1596607787051$d69226fd-eca4-465a-b7e4-08de91094410', '{\"id\":\"202007310101011002\",\"messageId\":\"1596607787051$d69226fd-eca4-465a-b7e4-08de91094410\",\"name\":\"测试订单\"}', 0, '1', '1596607847051', '1596607787838', '1596607787948');
INSERT INTO `broker_message_log` VALUES ('1596607910102$8a54f0fc-e745-4686-b021-3570346d4d3e', '{\"id\":\"202007310101011003\",\"messageId\":\"1596607910102$8a54f0fc-e745-4686-b021-3570346d4d3e\",\"name\":\"测试订单\"}', 0, '1', '1596607970102', '1596607910729', '1596607910838');
INSERT INTO `broker_message_log` VALUES ('1596607987173$97b35ded-5081-4243-9c29-7e6b48fc26d0', '{\"id\":\"202007310101011004\",\"messageId\":\"1596607987173$97b35ded-5081-4243-9c29-7e6b48fc26d0\",\"name\":\"测试订单\"}', 0, '1', '1596608047173', '1596607987869', '1596607988024');
INSERT INTO `broker_message_log` VALUES ('1596608323922$bf1f4857-9284-4514-99f3-e97119807c75', '{\"id\":\"202007310101011005\",\"messageId\":\"1596608323922$bf1f4857-9284-4514-99f3-e97119807c75\",\"name\":\"测试订单\"}', 3, '2', '1596608383922', '1596608324550', '1596608414485');
COMMIT;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(48) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
BEGIN;
INSERT INTO `oauth_client_details` VALUES ('app', 'order', '$2a$10$QnMaZ2U9CtPfHO/52TgRL.wmKph3DD5Xg.V8p6hMriekAPbFIE5iK', 'all', 'authorization_code', 'http://192.168.86.23:7081/login', NULL, 7200, 7200, NULL, 'ture');
INSERT INTO `oauth_client_details` VALUES ('web', 'order', '$2a$10$QnMaZ2U9CtPfHO/52TgRL.wmKph3DD5Xg.V8p6hMriekAPbFIE5iK', 'all,select', 'authorization_code,refresh_token,password,client_credentials', 'http://192.168.86.23:7081/login', NULL, 7200, 7200, NULL, 'ture');
COMMIT;

-- ----------------------------
-- Table structure for org_entity
-- ----------------------------
DROP TABLE IF EXISTS `org_entity`;
CREATE TABLE `org_entity` (
  `org_id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT 'orgId',
  `org_name` varchar(50) DEFAULT '' COMMENT 'orgName',
  `gmt_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'gmtTime',
  `parent_id` bigint(15) DEFAULT '-1' COMMENT 'parentId',
  `sort_num` int(11) DEFAULT '-1' COMMENT 'sortNum',
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='org_entity';

-- ----------------------------
-- Records of org_entity
-- ----------------------------
BEGIN;
INSERT INTO `org_entity` VALUES (1, '德清城市智能网联云控系统', '2020-12-02 08:55:46', 0, 1);
INSERT INTO `org_entity` VALUES (2, '德清城市智能网联云控系统11', '2020-12-02 09:00:34', 1, 2);
INSERT INTO `org_entity` VALUES (3, '德清城市智能网联云控系统22', '2020-12-02 09:00:45', 0, 3);
COMMIT;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `permission_index` (`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tenant_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_name_desc_index` (`name`,`description`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, '1', 'ROLE_admin', NULL, '');
INSERT INTO `role` VALUES (2, '1', 'ROLE_user', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` varchar(36) NOT NULL,
  `permission_id` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_user` VALUES (1, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` varchar(120) DEFAULT NULL,
  `name` varchar(120) DEFAULT NULL,
  `message_id` varchar(120) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES ('202007310101011002', '测试订单', '1596607787051$d69226fd-eca4-465a-b7e4-08de91094410');
INSERT INTO `t_order` VALUES ('202007310101011003', '测试订单', '1596607910102$8a54f0fc-e745-4686-b021-3570346d4d3e');
INSERT INTO `t_order` VALUES ('202007310101011004', '测试订单', '1596607987173$97b35ded-5081-4243-9c29-7e6b48fc26d0');
INSERT INTO `t_order` VALUES ('202007310101011005', '测试订单', '1596608323922$bf1f4857-9284-4514-99f3-e97119807c75');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT 'username',
  `sex` varchar(50) NOT NULL DEFAULT '' COMMENT 'sex',
  `birthday` datetime NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'birthday',
  `address` varchar(50) NOT NULL DEFAULT '' COMMENT 'address',
  `password` varchar(250) NOT NULL DEFAULT '' COMMENT 'password',
  `create_time` datetime NOT NULL DEFAULT '1000-01-01 00:00:00',
  `user_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='user';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'jiangwei', 'nan', '1000-01-01 00:00:00', '', '$2a$10$QnMaZ2U9CtPfHO/52TgRL.wmKph3DD5Xg.V8p6hMriekAPbFIE5iK', '1000-01-01 00:00:00', '-aohyswe78nbv');
INSERT INTO `user` VALUES (2, 'yingying', '', '1000-01-01 00:00:00', '', '$2a$10$QnMaZ2U9CtPfHO/52TgRL.wmKph3DD5Xg.V8p6hMriekAPbFIE5iK', '1000-01-01 00:00:00', '-aohyswe78nbv');
INSERT INTO `user` VALUES (3, 'xiaoma', '', '1000-01-01 00:00:00', '', '$2a$10$QnMaZ2U9CtPfHO/52TgRL.wmKph3DD5Xg.V8p6hMriekAPbFIE5iK', '1000-01-01 00:00:00', '-aohyswe78nbv');
INSERT INTO `user` VALUES (4, 'taowei', '', '1000-01-01 00:00:00', '', '$2a$10$QnMaZ2U9CtPfHO/52TgRL.wmKph3DD5Xg.V8p6hMriekAPbFIE5iK', '1000-01-01 00:00:00', '-aohyswe78nbv');
INSERT INTO `user` VALUES (5, 'wangkan', '', '1000-01-01 00:00:00', '', '$2a$10$QnMaZ2U9CtPfHO/52TgRL.wmKph3DD5Xg.V8p6hMriekAPbFIE5iK', '1000-01-01 00:00:00', '-aohyswe78nbv');
COMMIT;

-- ----------------------------
-- Table structure for user_entity
-- ----------------------------
DROP TABLE IF EXISTS `user_entity`;
CREATE TABLE `user_entity` (
  `user_id` varchar(50) NOT NULL COMMENT 'userId',
  `user_name` varchar(50) DEFAULT '' COMMENT 'userName',
  `user_phone` varchar(50) DEFAULT '' COMMENT 'userPhone',
  `org_id` bigint(15) DEFAULT '-1' COMMENT 'orgId',
  `head` varchar(50) DEFAULT '' COMMENT 'head',
  `work_num` varchar(50) DEFAULT '' COMMENT 'workNum',
  `status` int(11) DEFAULT '-1' COMMENT 'status',
  `user_type` varchar(50) DEFAULT '' COMMENT 'userType',
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='user_entity';

-- ----------------------------
-- Records of user_entity
-- ----------------------------
BEGIN;
INSERT INTO `user_entity` VALUES ('fafetgsfdsaf', 'jiangwei', '18271458826', NULL, '', '', 1, '-lopkjnh56st2', NULL);
INSERT INTO `user_entity` VALUES ('fasfvzxber', 'taowei', '', NULL, '', '', 1, '-aohyswe78nbv', NULL);
INSERT INTO `user_entity` VALUES ('fffafwerferq', 'yingying', '', NULL, '', '', 1, '-lopkjnh56st2', NULL);
INSERT INTO `user_entity` VALUES ('sdfqqaaa', 'chenxin', '', NULL, '', '', 1, '-aohyswe78nbv', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
