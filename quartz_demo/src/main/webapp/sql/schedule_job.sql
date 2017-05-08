/*
Navicat MySQL Data Transfer

Source Server         : vipsnacks
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : wish

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-05-08 10:07:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `JOB_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `JOB_NAME` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `JOB_GROUP` varchar(255) DEFAULT NULL COMMENT '任务分组',
  `JOB_STATUS` varchar(255) DEFAULT NULL COMMENT '任务状态 1开启：0停止',
  `CRON_EXPRESSION` varchar(255) DEFAULT NULL COMMENT 'cron表达式',
  `DESCRIPTION` varchar(255) DEFAULT NULL COMMENT '描述',
  `BEAN_CLASS` varchar(255) DEFAULT NULL COMMENT '调用类（包名加类名）',
  `SPRING_ID` varchar(255) DEFAULT NULL COMMENT 'spring bean 名称',
  `METHOD_NAME` varchar(255) DEFAULT NULL COMMENT '调用方法名称',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`JOB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('1', 'handx', 'handx', '0', '0/5 * * * * ?', 'this is test', 'com.quartz.base.task.Handx', null, 'run', '2017-05-07 21:20:53', null);
INSERT INTO `schedule_job` VALUES ('2', 'main', 'main', '0', '0/1 * * * * ?', '	this is test', 'com.quartz.base.task.Handx', '', 'main', '2017-05-08 09:48:23', null);
