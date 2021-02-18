/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50614
 Source Host           : localhost:3306
 Source Schema         : jeelession

 Target Server Type    : MySQL
 Target Server Version : 50614
 File Encoding         : 65001

 Date: 08/10/2020 23:58:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course_tea
-- ----------------------------
DROP TABLE IF EXISTS `course_tea`;
CREATE TABLE `course_tea`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) NULL DEFAULT NULL,
  `teaid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `courseid`(`courseid`) USING BTREE,
  INDEX `teaid`(`teaid`) USING BTREE,
  CONSTRAINT `course_tea_ibfk_1` FOREIGN KEY (`courseid`) REFERENCES `coursetable` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT,
  CONSTRAINT `course_tea_ibfk_2` FOREIGN KEY (`teaid`) REFERENCES `userinfo` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_tea
-- ----------------------------
INSERT INTO `course_tea` VALUES (1, 1, 2);
INSERT INTO `course_tea` VALUES (5, 7, 2);
INSERT INTO `course_tea` VALUES (6, 8, 2);

-- ----------------------------
-- Table structure for coursetable
-- ----------------------------
DROP TABLE IF EXISTS `coursetable`;
CREATE TABLE `coursetable`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科目的名称',
  `questionbank_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题库的名称',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '科目表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of coursetable
-- ----------------------------
INSERT INTO `coursetable` VALUES (1, '大学计算机', '大学计算机题库');
INSERT INTO `coursetable` VALUES (2, '大学英语', '大学英语公共题库');
INSERT INTO `coursetable` VALUES (3, '大学物理', '大学物理题库');
INSERT INTO `coursetable` VALUES (7, '测试提交的课程', '测试提交课程题库');
INSERT INTO `coursetable` VALUES (8, '测试提交的课程1', '测试提交课程题库1');

-- ----------------------------
-- Table structure for noticetable
-- ----------------------------
DROP TABLE IF EXISTS `noticetable`;
CREATE TABLE `noticetable`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知的内容',
  `fromcourse` int(11) NULL DEFAULT NULL COMMENT '来自的课程',
  `byuserid` int(11) NULL DEFAULT NULL COMMENT '来自用户id',
  `pubtime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '发布的时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `byuserid`(`byuserid`) USING BTREE,
  INDEX `fromcourse`(`fromcourse`) USING BTREE,
  CONSTRAINT `noticetable_ibfk_1` FOREIGN KEY (`byuserid`) REFERENCES `userinfo` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT,
  CONSTRAINT `noticetable_ibfk_2` FOREIGN KEY (`fromcourse`) REFERENCES `coursetable` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of noticetable
-- ----------------------------
INSERT INTO `noticetable` VALUES (1, '十一期间，请大家注意出行安全，要回家的同学请及时向导员请假', 1, 2, '2020-10-05 23:16:41');
INSERT INTO `noticetable` VALUES (2, '这是一条测试的程序', 1, 2, '2020-10-07 22:25:16');
INSERT INTO `noticetable` VALUES (3, '这是提交测试通知', 1, 2, '2020-10-08 17:39:13');

-- ----------------------------
-- Table structure for paper_stu
-- ----------------------------
DROP TABLE IF EXISTS `paper_stu`;
CREATE TABLE `paper_stu`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `testpaperid` int(11) NULL DEFAULT NULL,
  `stuid` int(11) NULL DEFAULT NULL,
  `grade` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `testpaperid`(`testpaperid`) USING BTREE,
  INDEX `stuid`(`stuid`) USING BTREE,
  CONSTRAINT `paper_stu_ibfk_1` FOREIGN KEY (`testpaperid`) REFERENCES `testpaper` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT,
  CONSTRAINT `paper_stu_ibfk_2` FOREIGN KEY (`stuid`) REFERENCES `userinfo` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of paper_stu
-- ----------------------------
INSERT INTO `paper_stu` VALUES (1, 1, 1, 0000000065);
INSERT INTO `paper_stu` VALUES (2, 2, 1, 0000000089);
INSERT INTO `paper_stu` VALUES (3, 3, 1, 0000000070);
INSERT INTO `paper_stu` VALUES (4, 1, 3, 0000000054);
INSERT INTO `paper_stu` VALUES (5, 1, 4, 0000000074);
INSERT INTO `paper_stu` VALUES (6, 1, 5, 0000000090);
INSERT INTO `paper_stu` VALUES (9, 12, 1, 0000000000);

-- ----------------------------
-- Table structure for personalquestionbank
-- ----------------------------
DROP TABLE IF EXISTS `personalquestionbank`;
CREATE TABLE `personalquestionbank`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人题库',
  `userid` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `userid`(`userid`) USING BTREE,
  CONSTRAINT `personalquestionbank_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `userinfo` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教师个人的题目收藏' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of personalquestionbank
-- ----------------------------
INSERT INTO `personalquestionbank` VALUES (1, 'gsws的个人题库', 2);
INSERT INTO `personalquestionbank` VALUES (2, 'ceshi题库', 1);

-- ----------------------------
-- Table structure for question_personal
-- ----------------------------
DROP TABLE IF EXISTS `question_personal`;
CREATE TABLE `question_personal`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NULL DEFAULT NULL,
  `bankid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `question_id`(`question_id`) USING BTREE,
  INDEX `bankid`(`bankid`) USING BTREE,
  CONSTRAINT `question_personal_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `questions` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT,
  CONSTRAINT `question_personal_ibfk_2` FOREIGN KEY (`bankid`) REFERENCES `personalquestionbank` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of question_personal
-- ----------------------------
INSERT INTO `question_personal` VALUES (1, 1, 1);
INSERT INTO `question_personal` VALUES (2, 4, 1);
INSERT INTO `question_personal` VALUES (3, 2, 1);

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答案',
  `qb` int(11) NULL DEFAULT NULL COMMENT '属于的题库',
  `kind` tinyint(3) UNSIGNED NULL DEFAULT 0 COMMENT '题目的类别，0为填空，1为选择，2为判断，3为问答，默认0',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `qb`(`qb`) USING BTREE,
  CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`qb`) REFERENCES `personalquestionbank` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '题目表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES (1, '请问计算机网络的七层架构是什么', '物理层，数据链路层，传输层，表示层，网络层，会话层，应用层', 1, 3);
INSERT INTO `questions` VALUES (2, '请问今天的日期_', '10.3', 1, 0);
INSERT INTO `questions` VALUES (3, '请问那个选项对？A.***;B.***;C.***;D.***', 'A', 1, 1);
INSERT INTO `questions` VALUES (4, '请问对吗', '错', 1, 2);

-- ----------------------------
-- Table structure for questions_paper
-- ----------------------------
DROP TABLE IF EXISTS `questions_paper`;
CREATE TABLE `questions_paper`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `paperid` int(11) NULL DEFAULT NULL,
  `questionid` int(11) NULL DEFAULT NULL,
  `grade` int(3) UNSIGNED NULL DEFAULT NULL COMMENT '题目的分数',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `paperid`(`paperid`) USING BTREE,
  INDEX `questionid`(`questionid`) USING BTREE,
  CONSTRAINT `questions_paper_ibfk_1` FOREIGN KEY (`paperid`) REFERENCES `testpaper` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT,
  CONSTRAINT `questions_paper_ibfk_2` FOREIGN KEY (`questionid`) REFERENCES `questions` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of questions_paper
-- ----------------------------
INSERT INTO `questions_paper` VALUES (1, 1, 1, 10);
INSERT INTO `questions_paper` VALUES (2, 1, 2, 2);
INSERT INTO `questions_paper` VALUES (3, 1, 3, 4);
INSERT INTO `questions_paper` VALUES (4, 1, 4, 3);
INSERT INTO `questions_paper` VALUES (9, 12, 4, 0);
INSERT INTO `questions_paper` VALUES (10, 12, 3, 0);
INSERT INTO `questions_paper` VALUES (11, 13, 1, 0);
INSERT INTO `questions_paper` VALUES (12, 13, 2, 0);

-- ----------------------------
-- Table structure for stuans
-- ----------------------------
DROP TABLE IF EXISTS `stuans`;
CREATE TABLE `stuans`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `quesid` int(11) NULL DEFAULT NULL,
  `ans` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生的回答',
  `paperid` int(11) NULL DEFAULT NULL,
  `grade` int(3) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '学生的分数',
  `stuid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `paperid`(`paperid`) USING BTREE,
  INDEX `quesid`(`quesid`) USING BTREE,
  INDEX `stuid`(`stuid`) USING BTREE,
  CONSTRAINT `stuans_ibfk_1` FOREIGN KEY (`paperid`) REFERENCES `testpaper` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT,
  CONSTRAINT `stuans_ibfk_2` FOREIGN KEY (`quesid`) REFERENCES `questions` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT,
  CONSTRAINT `stuans_ibfk_3` FOREIGN KEY (`stuid`) REFERENCES `userinfo` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生的答案' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of stuans
-- ----------------------------
INSERT INTO `stuans` VALUES (1, 1, '1的回答', 1, 000, 1);
INSERT INTO `stuans` VALUES (2, 2, '2的回答修改', 1, 000, 1);
INSERT INTO `stuans` VALUES (3, 3, '3的回答 修改的', 1, 000, 1);
INSERT INTO `stuans` VALUES (4, 4, '4的回答对', 1, 000, 1);

-- ----------------------------
-- Table structure for testpaper
-- ----------------------------
DROP TABLE IF EXISTS `testpaper`;
CREATE TABLE `testpaper`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试卷名称',
  `byuserid` int(11) NULL DEFAULT NULL,
  `bycourseid` int(11) NULL DEFAULT NULL COMMENT '属于的科目',
  `starttime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `endtime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `info` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考试介绍',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `byuserid`(`byuserid`) USING BTREE,
  INDEX `bycourseid`(`bycourseid`) USING BTREE,
  CONSTRAINT `testpaper_ibfk_1` FOREIGN KEY (`byuserid`) REFERENCES `userinfo` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT,
  CONSTRAINT `testpaper_ibfk_2` FOREIGN KEY (`bycourseid`) REFERENCES `coursetable` (`Id`) ON DELETE NO ACTION ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试卷' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of testpaper
-- ----------------------------
INSERT INTO `testpaper` VALUES (1, '大学计算机考试', 2, 1, '2020-10-04 13:42:53', '2020-10-16 13:42:57', '这是一门大学计算机考试，考试难度较低');
INSERT INTO `testpaper` VALUES (2, '英语考试', 2, 2, '2020-10-05 17:00:37', '2020-10-07 17:00:39', NULL);
INSERT INTO `testpaper` VALUES (3, '物理考试大学', 2, 3, '2020-10-05 17:01:10', '2020-10-08 17:01:14', NULL);
INSERT INTO `testpaper` VALUES (12, '测试实体', 2, 1, '2020-10-06 20:37:32', '2020-10-06 21:37:32', '123');
INSERT INTO `testpaper` VALUES (13, '测试提交', 2, 1, '2020-10-08 17:37:26', '2020-10-08 19:01:26', '这是测试最后次');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的账号',
  `userpasswd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `age` int(11) UNSIGNED NULL DEFAULT NULL,
  `gender` int(1) NULL DEFAULT NULL COMMENT '0为女性，1为男性',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` int(5) UNSIGNED NULL DEFAULT NULL COMMENT '0为管理员，1为老师，2为学生',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表格' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, '123465', '3456789c', 23, 1, '13265466589', 2);
INSERT INTO `userinfo` VALUES (2, '55170700', '3456789c', 24, 0, '13254544585', 1);
INSERT INTO `userinfo` VALUES (3, 'grade1', '3456789c', 12, 0, '1', 2);
INSERT INTO `userinfo` VALUES (4, 'grade2', '3456789c', 12, 0, '1', 2);
INSERT INTO `userinfo` VALUES (5, 'grade3', '3456789c', 12, 0, '123456', 2);
INSERT INTO `userinfo` VALUES (7, 'admin', '3456789c', 12, 0, '1234', 0);

SET FOREIGN_KEY_CHECKS = 1;
