use coronavirus;

drop table if exists `test_place`;
create table `test_place` (
 `id` int(11) not null auto_increment,
    `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `place` varchar(255) character set utf8 collate utf8_general_ci not null,
    `phone` varchar(100) character set utf8 collate utf8_general_ci not null,
    `time` varchar(255) character set utf8 collate utf8_general_ci not null,
    primary key(`id`) using btree
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

select * from `test_place`;
insert into `test_place` values(null, '珠海市人民医院','珠海市香洲区康宁路79号','(0756)2222569','挂号时间 08:00-12:00,14:30-17:30 开诊时间 08:00-12:00,14:30-17:30');
insert into `test_place` values(null, '友谊路24号','','','');
insert into `test_place` values(null, '遵义医学院第五附属医院','广东省珠海市斗门区珠峰大道1439号','(0756)6275013,(0756)6275170,(0756)6275299','挂号时间 08:00-12:00,14:30-18:00 开诊时间 08:00-12:00,14:30-18:00');
insert into `test_place` values(null, '珠海市妇幼保健院','珠海市香洲区柠溪路543号','(0756)2313115','挂号时间 00:00-24:00 开诊时间 08:00-12:00,14:30-17:30');
insert into `test_place` values(null, '迎宾广场','广东省珠海市香洲区迎宾南路1144号','','');
insert into `test_place` values(null, '连屏村核酸采样点','珠海市香洲区保北路中国石油(连屏加油站)东南侧约250米','','');
insert into `test_place` values(null, '广东省中医院','珠海市香洲区吉大景乐路53号','(0756)3325119','08:00-18:30');

drop table if exists `supply`;
create table `supply`
(
 `id` int(11) not null auto_increment,
    `name` varchar(255) character set utf8 collate utf8_general_ci NOT NULL,
    `price` varchar(100) character set utf8 collate utf8_general_ci NOT NULL,
    `amount` varchar(100) character set utf8 collate utf8_general_ci NOT NULL,
		`illness` varchar(100) character set utf8 collate utf8_general_ci NOT NULL,
    primary key(`id`) using btree
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

select * from `supply`;

TRUNCATE supply;
insert into `supply` values(null, '布洛芬胶囊', '13元/盒', '1000','发热');
insert into `supply` values(null, '阿司匹林胶囊', '18元/盒', '10000','发热');
insert into `supply` values(null, '金花清感颗粒', '54元/盒', '300','发热');
insert into `supply` values(null, '六神丸', '98元/10粒*6支', '100','咽干咽痛');
insert into `supply` values(null, '清咽滴丸', '31.95元/盒', '500','咽干咽痛');
insert into `supply` values(null, '疏风解毒胶囊', '18.2元/盒', '2000','咽干咽痛');
insert into `supply` values(null, '盐酸溴己新片', '23元/盒', '800','咳嗽吐痰');
insert into `supply` values(null, '愈创甘油醚片', '5.85元/盒', '6000','咳嗽吐痰');
insert into `supply` values(null, '乙酰半膀氨基酸片', '35元/盒', '800','咳嗽吐痰');
insert into `supply` values(null, '复方福尔可定溶液', '46.5元/盒', '100','干咳无痰');
insert into `supply` values(null, '氢溴酸右美沙芬片', '8元/盒', '2000','干咳无痰');
insert into `supply` values(null, '马来酸氯苯那敏片', '21元/瓶', '500','流鼻涕');
insert into `supply` values(null, '氯雷他定片', '18元/盒', '1000','流鼻涕');
insert into `supply` values(null, '清肺排毒颗粒', '12.6元/盒', '500','鼻塞');
insert into `supply` values(null, '宣肺败毒颗粒', '395元/盒', '200','鼻塞');

DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (    `id` int not null primary key ,
                          `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `level` int
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

INSERT INTO `area` VALUES ( '1','香洲区', 1);
INSERT INTO `area` VALUES ( '2','斗门区', 0);
INSERT INTO `area` VALUES ( '3','金湾区', 1);

DROP TABLE IF EXISTS `authentication`;
CREATE TABLE `authentication`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

INSERT INTO `authentication` VALUES (1, '管理员', 'Admin');
INSERT INTO `authentication` VALUES (2, '用户', 'User');

DROP TABLE IF EXISTS `base`;
CREATE TABLE `base`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `gender` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` bigint(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idCard`(`idCard`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

INSERT INTO `base` VALUES (78, '513030199411234123', '王曦彤', 23, '女', '广东省珠海市香洲区', 13508123423);
INSERT INTO `base` VALUES (79, '513042198810241234', '张霞', 38, '女', '广东省珠海市香洲区', 13508018342);
INSERT INTO `base` VALUES (80, '513012199011234233', '王佳', 23, '女', '广东省珠海市香洲区', 13508302342);
INSERT INTO `base` VALUES (81, '513031197212015234', '黄雅莉', 52, '女', '广东省珠海市高新区', 15308410834);
INSERT INTO `base` VALUES (82, '513030199411234234', '李明涛', 52, '男', '广东省珠海市高新区', 13580293523);
INSERT INTO `base` VALUES (83, '510302199611051234', '张夏婷', 23, '女', '广东省珠海市高新区', 15083029342);
INSERT INTO `base` VALUES (84, '513001199103221234', '张天昊', 27, '男', '广东省珠海市斗门区', 15082308123);
INSERT INTO `base` VALUES (85, '510381198502123421', '黄小龙', 38, '男', '广东省珠海市金湾区', 15083013942);

DROP TABLE IF EXISTS `cure`;
CREATE TABLE `cure`  (
  `baseId` int(11) NOT NULL,
  `dischargeDate` date NULL DEFAULT NULL,
  `current` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`baseId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

INSERT INTO `cure` VALUES (78, '2020-10-01', '良好');
INSERT INTO `cure` VALUES (80, '2020-10-08', '治愈了');

DROP TABLE IF EXISTS `dead`;
CREATE TABLE `dead`  (
  `baseId` int(11) NOT NULL,
  `deadTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`baseId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

INSERT INTO `dead` VALUES (79, '2020-10-08');

DROP TABLE IF EXISTS `inspect`;
CREATE TABLE `inspect`  (
  `testId` int(11) NOT NULL AUTO_INCREMENT,
  `baseId` int(11) NOT NULL,
  `testDate` date NULL DEFAULT NULL,
  `ctTest` enum('病变','正常') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nuTest` enum('阴性','阳性') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`testId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

INSERT INTO `inspect` VALUES (1, 84, '2020-10-05', '正常', '阳性');

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `baseId` int(11) NOT NULL,
  `infectionSource` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `onsetDate` date NULL DEFAULT NULL,
  `symptoms` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hospital` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `critical` enum('是','否') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`baseId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

INSERT INTO `patient` VALUES (78, '格力海岸', '2020-10-01', '发烧', '华西医院', '否', '测试');
INSERT INTO `patient` VALUES (79, '格力海岸', '2020-10-03', '咳嗽', '人民医院', '否', '阳性');
INSERT INTO `patient` VALUES (80, '唐家湾站乘车', '2020-10-08', '咳嗽发烧', '华西医院', '否', '确诊了哦');
INSERT INTO `patient` VALUES (82, '斗门区市场', '2020-10-01', '发热', '传染病医院', '否', '测试');
INSERT INTO `patient` VALUES (83, '中大五院', '2020-10-01', '发绕', '32', '否', '测试');
INSERT INTO `patient` VALUES (84, '中大五院', '2020-10-02', '咳嗽', '27', '否', '测试患者');

DROP TABLE IF EXISTS `touch`;
CREATE TABLE `touch`  (
  `baseId` int(11) NULL DEFAULT NULL,
  `comeFrom` varchar(56) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isoAddress` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startDate` date NULL DEFAULT NULL,
  `finished` enum('是','否') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


INSERT INTO `touch` VALUES (79, '境外航班', '传染病医院', '2020-10-02', '是');
INSERT INTO `touch` VALUES (80, '去过广州', '传染病医院', '2020-10-07', '是');
INSERT INTO `touch` VALUES (81, '去过武汉', '传染病医院', '2020-10-05', '否');
INSERT INTO `touch` VALUES (85, '境外输入', '酒店集中隔离', '2020-10-04', '否');

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

INSERT INTO `user` VALUES (5, 'Shiroha', '$2a$10$O0LmLvs6sPVR4oy7StpgzuIaZY2jnToS/u38EsWxfKofIBY6W5POm', '13508130824', '软件公司ceo', '白羽');
INSERT INTO `user` VALUES (7, 'Shio', '$2a$10$h52sifTgaJ2AeI1rldAqe.5XDOsUCVBmSrAdBsxH0tOuVFkwPgtyK', '13508108103', '家里蹲死宅', '汐');

DROP TABLE IF EXISTS `user_authorities`;
CREATE TABLE `user_authorities`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authentication_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

INSERT INTO `user_authorities` VALUES (11, 2, 5);
INSERT INTO `user_authorities` VALUES (12, 1, 5);
INSERT INTO `user_authorities` VALUES (13, 2, 6);

SET FOREIGN_KEY_CHECKS = 1;
