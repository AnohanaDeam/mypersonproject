/*
Navicat MySQL Data Transfer

Source Server         : l
Source Server Version : 50087
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2018-03-24 11:48:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_business
-- ----------------------------
DROP TABLE IF EXISTS `tb_business`;
CREATE TABLE `tb_business` (
  `business_number` varchar(32) NOT NULL COMMENT '业务受理号',
  `applicant_name` varchar(20) NOT NULL COMMENT '申请人姓名',
  `ID_number` varchar(18) NOT NULL COMMENT '身份证号码',
  `phone` varchar(22) NOT NULL COMMENT '联系电话',
  `f_service` varchar(20) NOT NULL COMMENT '权利类型',
  `service_number` varchar(50) NOT NULL COMMENT '登记类型',
  `Service_time` datetime default NULL COMMENT '业务受理时间',
  PRIMARY KEY  (`business_number`),
  KEY `FK_Reference_7` (`service_number`,`f_service`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`service_number`, `f_service`) REFERENCES `tb_service` (`service_number`, `f_service`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_business
-- ----------------------------
INSERT INTO `tb_business` VALUES ('DA20180316113758', '伍彬行', '231100199201299169', '13204662330', 'D', 'A', '2018-03-23 16:03:20');
INSERT INTO `tb_business` VALUES ('DA20180316113815', '纪时', '130535196008168603', '13204893081', 'D', 'A', '2018-03-23 16:05:21');
INSERT INTO `tb_business` VALUES ('DA20180316113843', '法玉琴', '141028200306176557', '13704579056', 'D', 'A', null);
INSERT INTO `tb_business` VALUES ('DC20180316113808', '门枫', '632522197508103091', '13500263968', 'D', 'C', null);
INSERT INTO `tb_business` VALUES ('DC20180316113825', '笪月', '210503197609247167', '13003180191', 'D', 'C', null);
INSERT INTO `tb_business` VALUES ('DC20180316113832', '亢达发', '440903198902170903', '13707464981', 'D', 'C', null);
INSERT INTO `tb_business` VALUES ('DC20180316113834', '韩美妍', '350924196901173951', '13603876925', 'D', 'C', null);
INSERT INTO `tb_business` VALUES ('DF20180316113756', '胥宁', '150104198606289081', '13704911917', 'D', 'F', null);
INSERT INTO `tb_business` VALUES ('DF20180316113806', '苗弘岩', '511821199906154768', '15706475458', 'D', 'F', null);
INSERT INTO `tb_business` VALUES ('DF20180316113818', '贺峰', '130922198408264679', '13703554173', 'D', 'F', null);
INSERT INTO `tb_business` VALUES ('DF20180316113827', '毕勤薇', '610327195810010503', '13703475280', 'D', 'F', null);
INSERT INTO `tb_business` VALUES ('DF20180316113829', '寿斌', '450331197208142048', '13104446331', 'D', 'F', null);
INSERT INTO `tb_business` VALUES ('DF20180316113838', '师晓融', '32130219840927368X', '13702781780', 'D', 'F', null);
INSERT INTO `tb_business` VALUES ('DM20180316113759', '百军', '340111200309181495', '13801232528', 'D', 'M', null);
INSERT INTO `tb_business` VALUES ('DM20180316113821', '暨思', '652324196305051050', '15203333046', 'D', 'M', null);
INSERT INTO `tb_business` VALUES ('DM20180316113823', '汪颖雁', '632127199302112995', '13208074572', 'D', 'M', null);
INSERT INTO `tb_business` VALUES ('DM20180316113842', '舌世刚', '341222195005303811', '13004166427', 'D', 'M', null);
INSERT INTO `tb_business` VALUES ('DM20180319143927', '小明', '142600199107226533', '13566668888', 'D', 'M', '2018-03-23 19:11:01');
INSERT INTO `tb_business` VALUES ('DM20180323144324', '熊测试', '500106199201120838', '15086819611', 'D', 'M', '2018-03-23 14:49:34');
INSERT INTO `tb_business` VALUES ('DM20180323192235', '郭宵宵', '231100199201299169', '13511501405', 'D', 'M', '2018-03-23 19:32:18');
INSERT INTO `tb_business` VALUES ('DM20180324104332', '哈哈哈哈啊哈', '500106199201120838', '15086819610', 'D', 'M', null);
INSERT INTO `tb_business` VALUES ('DM20180324105410', '小小', '340111200309181495', '13355556666', 'D', 'M', '2018-03-24 11:16:57');
INSERT INTO `tb_business` VALUES ('DM20180324110100', '他大爷', '500106199201120838', '15086819610', 'D', 'M', '2018-03-24 11:02:59');
INSERT INTO `tb_business` VALUES ('DU20180316113820', '纪玲眉', '331121198508249810', '15803037544', 'D', 'U', null);
INSERT INTO `tb_business` VALUES ('DU20180316113826', '管娅', '411700200108316173', '13308611986', 'D', 'U', null);
INSERT INTO `tb_business` VALUES ('DU20180316113837', '叶霄莉', '370811197001174108', '13804315467', 'D', 'U', null);
INSERT INTO `tb_business` VALUES ('DU20180316113841', '车国坚', '341523195509150612', '13905464474', 'D', 'U', null);
INSERT INTO `tb_business` VALUES ('EA20180316113750', '台全', '370828197004054539', '15101842275', 'E', 'A', null);
INSERT INTO `tb_business` VALUES ('EA20180316113752', '赵顺河', '220622199207199153', '13204657901', 'E', 'A', null);
INSERT INTO `tb_business` VALUES ('EA20180316113754', '商斌', '542100196412265815', '15203867824', 'E', 'A', null);
INSERT INTO `tb_business` VALUES ('EA20180316113800', '游飞辉', '330522195712099550', '15004540530', 'E', 'A', null);
INSERT INTO `tb_business` VALUES ('EA20180316113801', '师娜', '500222197707231806', '13304917062', 'E', 'A', null);
INSERT INTO `tb_business` VALUES ('EA20180316113814', '喻蓓莺', '411702198904136555', '15107811745', 'E', 'A', '2018-03-16 11:38:14');
INSERT INTO `tb_business` VALUES ('MA20180316113753', '童承博', '654321199206192890', '15904146355', 'M', 'A', '2018-03-16 11:37:53');
INSERT INTO `tb_business` VALUES ('MA20180316113810', '谭倩', '230921197008143221', '13506716466', 'M', 'A', '2018-03-16 11:38:10');
INSERT INTO `tb_business` VALUES ('MA20180316113833', '罗朗风', '211000195201180769', '15502066164', 'M', 'A', '2018-03-16 11:38:33');
INSERT INTO `tb_business` VALUES ('OA20180316113751', '靳眉', '230125195908225444', '15702881481', 'O', 'A', '2018-03-16 11:37:51');
INSERT INTO `tb_business` VALUES ('OA20180316113812', '厍震', '130403200709305837', '15307867984', 'O', 'A', '2018-03-16 11:38:12');
INSERT INTO `tb_business` VALUES ('OA20180316113816', '糜辰奇', '450600199711216690', '13304490623', 'O', 'A', '2018-03-16 11:38:16');
INSERT INTO `tb_business` VALUES ('OA20180316113817', '赏婕', '450404196410046369', '13301063950', 'O', 'A', '2018-03-16 11:38:17');
INSERT INTO `tb_business` VALUES ('OA20180316113828', '秋伯', '431126199904135065', '15507730296', 'O', 'A', '2018-03-16 11:38:28');
INSERT INTO `tb_business` VALUES ('OA20180316113831', '钦亨', '152923200206163652', '13805283304', 'O', 'A', '2018-03-16 11:38:31');
INSERT INTO `tb_business` VALUES ('TA20180316113757', '席发之', '150925197510206991', '15304245004', 'T', 'A', '2018-03-16 11:37:57');
INSERT INTO `tb_business` VALUES ('TA20180316113803', '郭伊琳', '220881200705313939', '15104778193', 'T', 'A', '2018-03-16 11:38:03');

-- ----------------------------
-- Table structure for tb_b_and_m
-- ----------------------------
DROP TABLE IF EXISTS `tb_b_and_m`;
CREATE TABLE `tb_b_and_m` (
  `service_number` varchar(4) default NULL COMMENT '业务编号',
  `Material_number` varchar(32) default NULL COMMENT '材料编号',
  `Whether` varchar(20) default NULL COMMENT '是否必须',
  `f_service` varchar(4) default NULL COMMENT '业务父编号',
  KEY `FK_Reference_5` (`Material_number`),
  KEY `FK_Reference_6` (`service_number`,`f_service`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`Material_number`) REFERENCES `tb_m_type` (`Material_type_number`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`service_number`, `f_service`) REFERENCES `tb_service` (`service_number`, `f_service`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_b_and_m
-- ----------------------------
INSERT INTO `tb_b_and_m` VALUES ('M', 'SQS', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('M', 'SFZ', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('M', 'JSZ', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('M', 'GHZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('M', 'JGZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('M', 'ZHB', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('M', 'QTCL', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('C', 'SQS', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('C', 'SFZ', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('C', 'JSZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('C', 'GHZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('C', 'JGZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('C', 'ZHB', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('C', 'QTCL', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('F', 'SQS', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('F', 'SFZ', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('F', 'JSZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('F', 'GHZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('F', 'JGZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('F', 'ZHB', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('F', 'QTCL', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'SQS', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'SFZ', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'JSZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'GHZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'JGZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'ZHB', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'QTCL', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'SQS', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'SFZ', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'JSZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'GHZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'JGZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'ZHB', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('U', 'QTCL', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('A', 'SQS', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('A', 'SFZ', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('A', 'JSZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('A', 'GHZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('A', 'JGZ', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('A', 'ZHB', '是', 'D');
INSERT INTO `tb_b_and_m` VALUES ('A', 'QTCL', '否', 'D');
INSERT INTO `tb_b_and_m` VALUES ('A', 'SQS', '是', 'E');
INSERT INTO `tb_b_and_m` VALUES ('A', 'SFZ', '是', 'E');
INSERT INTO `tb_b_and_m` VALUES ('A', 'SYZ', '是', 'E');
INSERT INTO `tb_b_and_m` VALUES ('A', 'DYHT', '否', 'E');
INSERT INTO `tb_b_and_m` VALUES ('A', 'GYZ', '否', 'E');
INSERT INTO `tb_b_and_m` VALUES ('A', 'ZZHT', '是', 'E');
INSERT INTO `tb_b_and_m` VALUES ('A', 'QTCL', '否', 'E');
INSERT INTO `tb_b_and_m` VALUES ('A', 'SQS', '是', 'M');
INSERT INTO `tb_b_and_m` VALUES ('A', 'SFZ', '是', 'M');
INSERT INTO `tb_b_and_m` VALUES ('A', 'SYZ', '是', 'M');
INSERT INTO `tb_b_and_m` VALUES ('A', 'ZZHT', '否', 'M');
INSERT INTO `tb_b_and_m` VALUES ('A', 'QTCL', '否', 'M');
INSERT INTO `tb_b_and_m` VALUES ('A', 'QTCL', '否', 'T');
INSERT INTO `tb_b_and_m` VALUES ('A', 'QTCL', '否', 'O');

-- ----------------------------
-- Table structure for tb_certificate
-- ----------------------------
DROP TABLE IF EXISTS `tb_certificate`;
CREATE TABLE `tb_certificate` (
  `certificate_id` varchar(32) NOT NULL COMMENT '证件号',
  `Business_types` varchar(32) NOT NULL COMMENT '业务类型',
  `business_number` varchar(32) NOT NULL COMMENT '业务受理号',
  `owner` varchar(20) NOT NULL COMMENT '证件所有人',
  `receive` varchar(20) NOT NULL COMMENT '是否领取',
  `Other_information` varchar(255) default NULL COMMENT '其它信息',
  PRIMARY KEY  (`business_number`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`business_number`) REFERENCES `tb_business` (`business_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_certificate
-- ----------------------------
INSERT INTO `tb_certificate` VALUES ('RE01299169', '所有权登记-经济适用房初始登记', 'DA20180316113758', '伍彬行', '是', null);
INSERT INTO `tb_certificate` VALUES ('RE01299169', '所有权登记-商品房初始登记', 'DM20180323192235', '郭宵宵', '是', null);
INSERT INTO `tb_certificate` VALUES ('RE01120838', '所有权登记-商品房初始登记', 'DM20180324110100', '他大爷', '否', null);

-- ----------------------------
-- Table structure for tb_check
-- ----------------------------
DROP TABLE IF EXISTS `tb_check`;
CREATE TABLE `tb_check` (
  `business_number` varchar(32) NOT NULL COMMENT '业务受理号',
  `first_trial_case` varchar(32) default NULL COMMENT '一审情况',
  `second_case` varchar(32) default NULL COMMENT '二审情况',
  `three_case` varchar(32) default NULL COMMENT '三审情况',
  `one_opinion` varchar(255) default NULL COMMENT '一审意见',
  `two_opinion` varchar(255) default NULL COMMENT '二审意见',
  `three_opinion` varchar(255) default NULL COMMENT '三审意见',
  `one_time` datetime default NULL COMMENT '一审未通过时间',
  `two_time` datetime default NULL COMMENT '二审未通过时间',
  `three_time` datetime default NULL COMMENT '三审未通过时间',
  `one_material` varchar(255) default NULL COMMENT '一审需补充材料',
  `two_material` varchar(255) default NULL COMMENT '二审需补充材料',
  `three_material` varchar(255) default NULL COMMENT '三审需补充材料',
  `one_realcheck` varchar(255) default NULL COMMENT '实地考察情况',
  `two__realcheck` varchar(255) default NULL,
  `three_realcheck` varchar(255) default NULL,
  KEY `FK_Reference_4` (`business_number`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`business_number`) REFERENCES `tb_business` (`business_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_check
-- ----------------------------
INSERT INTO `tb_check` VALUES ('DA20180316113758', '是', '是', '是', '1111', '111111', '1111', null, null, null, null, null, null, '111111', null, null);
INSERT INTO `tb_check` VALUES ('DA20180316113815', '是', null, null, '11111', null, null, null, null, null, null, null, null, '111111', null, null);
INSERT INTO `tb_check` VALUES ('DM20180319143927', '是', null, null, '1111', null, null, null, null, null, null, null, null, '1111', null, null);
INSERT INTO `tb_check` VALUES ('DM20180323192235', '是', '是', '是', '通过', '通过', '通过', null, null, null, null, null, null, '很棒！', null, null);
INSERT INTO `tb_check` VALUES ('DM20180324110100', '是', '是', '是', '实话实说', '打算快乐的加拉塞克简单莱卡是假的莱卡是假的老卡位设计', '艾赛杜拉； 卡；历史地看啊；老师的库；阿斯卡德卢卡斯大事；登录‘啊大 啊是快乐的55', null, null, null, null, null, null, '晒晒臩', null, null);

-- ----------------------------
-- Table structure for tb_document
-- ----------------------------
DROP TABLE IF EXISTS `tb_document`;
CREATE TABLE `tb_document` (
  `file_header` varchar(32) default NULL COMMENT '文件头',
  `word_size` double(33,0) default NULL COMMENT '字号',
  `title` varchar(34) NOT NULL COMMENT '标题',
  `sr_time` datetime default NULL COMMENT '收发日期',
  `archive_location` varchar(255) default NULL COMMENT '存档位置',
  `subject_term` varchar(255) default NULL COMMENT '主题词',
  `send` varchar(255) default NULL COMMENT '抄送',
  PRIMARY KEY  (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_document
-- ----------------------------

-- ----------------------------
-- Table structure for tb_file
-- ----------------------------
DROP TABLE IF EXISTS `tb_file`;
CREATE TABLE `tb_file` (
  `business_number` varchar(32) NOT NULL COMMENT '业务受理号',
  `Business_types` varchar(40) NOT NULL COMMENT '业务类型',
  `property_owner` varchar(20) NOT NULL COMMENT '产权人',
  `File_location` varchar(255) default NULL COMMENT '档案存放位置',
  `security` varchar(20) default NULL COMMENT '密级',
  `address` varchar(255) NOT NULL COMMENT '房产地址',
  `Filing_date` datetime default NULL COMMENT '归档日期',
  PRIMARY KEY  (`business_number`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`business_number`) REFERENCES `tb_business` (`business_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_file
-- ----------------------------
INSERT INTO `tb_file` VALUES ('DA20180316113758', '所有权登记-经济适用房初始登记', '伍彬行', null, null, '莘县路23号-20-7', null);
INSERT INTO `tb_file` VALUES ('DM20180323192235', '所有权登记-商品房初始登记', '郭宵宵', '606', 'B', '漳州街二街86号-13-5', '2018-03-23 19:56:27');
INSERT INTO `tb_file` VALUES ('DM20180324110100', '所有权登记-商品房初始登记', '他大爷', '拉开是假的老卡时间但老卡时间但老卡时间但老卡时间里的卡就是离开多久啊路上看到将拉升空间对啦睡觉对啦睡觉的垃圾死了的空间啊算了大家阿拉山口但将拉升空间对啦睡觉的莱卡是假的莱卡是假的莱卡是假的卢卡斯决定了啊睡觉了的就爱上了看得见啊老实交代拉升空间的拉升阶段卡式机卡式机但老卡时间但老卡时间的莱卡就算了卡就是但老卡时间的老卡时间但老卡时间但老卡时间对啦睡觉对啦睡觉的拉升阶段啦睡觉啦看', 'C', '芝泉路72号-17-10', '2018-03-24 11:09:45');

-- ----------------------------
-- Table structure for tb_housing_project
-- ----------------------------
DROP TABLE IF EXISTS `tb_housing_project`;
CREATE TABLE `tb_housing_project` (
  `Item_no` varchar(32) NOT NULL COMMENT '项目号',
  `enterprise` varchar(32) default NULL COMMENT '开发企业',
  `project_name` varchar(32) default NULL COMMENT '项目名称',
  `booking_number` varchar(32) default NULL COMMENT '预售证号',
  `address` varchar(255) default NULL,
  PRIMARY KEY  (`Item_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_housing_project
-- ----------------------------
INSERT INTO `tb_housing_project` VALUES ('XM1001', '碧桂园', '春江名城', 'CJ120012', '漳州街二街86号-13-5');
INSERT INTO `tb_housing_project` VALUES ('XM1002', '恒大地产', '水晶郦城', 'SJ123456', '芝泉路72号-17-10');
INSERT INTO `tb_housing_project` VALUES ('XM1003', '腾讯房产', '悠山郡', 'YS112233', '漳州街二街34号-11-1');
INSERT INTO `tb_housing_project` VALUES ('XM1004', '万达房产', '名景台', 'MJ108968', '华严路116号-11-3');
INSERT INTO `tb_housing_project` VALUES ('XM1005', '绿地地产', '听蓝湾', 'TL874758', '丰海路12号-10-3');
INSERT INTO `tb_housing_project` VALUES ('XM1006', '万科', '铂金岛', 'BJ564674', '山口路144号-9-4');
INSERT INTO `tb_housing_project` VALUES ('XM1007', '华润置地', '长安天街', 'CA478788', '标山路29号-20-1');
INSERT INTO `tb_housing_project` VALUES ('XM1008', '龙湖地产', '原府', 'YF445445', '艳阳街107号-14-5');
INSERT INTO `tb_housing_project` VALUES ('XM1009', '中海地产', '星海彼岸', 'XH675765', '莘县路23号-20-7');
INSERT INTO `tb_housing_project` VALUES ('XM1010', '保利地产', '盛世华府', 'SS545658', '锦城广场118号-2-4');

-- ----------------------------
-- Table structure for tb_login
-- ----------------------------
DROP TABLE IF EXISTS `tb_login`;
CREATE TABLE `tb_login` (
  `user_name` varchar(255) NOT NULL,
  `user_pass` varchar(255) NOT NULL,
  `identity` varchar(255) default NULL,
  PRIMARY KEY  (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_login
-- ----------------------------
INSERT INTO `tb_login` VALUES ('123456', '123456', '一审');
INSERT INTO `tb_login` VALUES ('234567', '123456', '二审');
INSERT INTO `tb_login` VALUES ('345678', '123456', '三审');
INSERT INTO `tb_login` VALUES ('456789', '123456', '前台受理');
INSERT INTO `tb_login` VALUES ('567890', '123456', '档案管理');
INSERT INTO `tb_login` VALUES ('suchan', '123789', '前台受理');

-- ----------------------------
-- Table structure for tb_material
-- ----------------------------
DROP TABLE IF EXISTS `tb_material`;
CREATE TABLE `tb_material` (
  `Material_number` int(32) NOT NULL auto_increment COMMENT '材料编号',
  `Material_type_number` varchar(32) NOT NULL COMMENT '材料类型编号',
  `file_name` varchar(32) default NULL COMMENT '文件名称',
  `file_size` varchar(32) default NULL COMMENT '文件字号',
  `Material_address` varchar(255) default NULL COMMENT '材料地址',
  `form` varchar(20) default NULL COMMENT '存在形式',
  `business_number` varchar(32) NOT NULL COMMENT '所属业务',
  PRIMARY KEY  (`Material_number`),
  KEY `FK_Reference_10` (`business_number`),
  KEY `FK_Reference_8` (`Material_type_number`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`business_number`) REFERENCES `tb_business` (`business_number`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`Material_type_number`) REFERENCES `tb_m_type` (`Material_type_number`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_material
-- ----------------------------
INSERT INTO `tb_material` VALUES ('1', 'SQS', 'DM20180319143927SQS.jpg', '845941', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180319143927SQS.jpg', 'image/jpeg', 'DM20180319143927');
INSERT INTO `tb_material` VALUES ('2', 'SFZ', 'DM20180319143927SFZ.jpg', '775702', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180319143927SFZ.jpg', 'image/jpeg', 'DM20180319143927');
INSERT INTO `tb_material` VALUES ('3', 'JSZ', 'DM20180319143927JSZ.jpg', '561276', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180319143927JSZ.jpg', 'image/jpeg', 'DM20180319143927');
INSERT INTO `tb_material` VALUES ('4', 'GHZ', 'DM20180319143927GHZ.jpg', '780831', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180319143927GHZ.jpg', 'image/jpeg', 'DM20180319143927');
INSERT INTO `tb_material` VALUES ('5', 'JGZ', 'DM20180319143927JGZ.jpg', '777835', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180319143927JGZ.jpg', 'image/jpeg', 'DM20180319143927');
INSERT INTO `tb_material` VALUES ('6', 'ZHB', 'DM20180319143927ZHB.jpg', '620888', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180319143927ZHB.jpg', 'image/jpeg', 'DM20180319143927');
INSERT INTO `tb_material` VALUES ('7', 'QTCL', 'DM20180319143927QTCL.jpg', '879394', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180319143927QTCL.jpg', 'image/jpeg', 'DM20180319143927');
INSERT INTO `tb_material` VALUES ('29', 'SQS', 'DM20180323192235SQS', '879394', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180323192235SQS', 'image/jpeg', 'DM20180323192235');
INSERT INTO `tb_material` VALUES ('30', 'SFZ', 'DM20180323192235SFZ', '845941', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180323192235SFZ', 'image/jpeg', 'DM20180323192235');
INSERT INTO `tb_material` VALUES ('31', 'JSZ', 'DM20180323192235JSZ', '595284', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180323192235JSZ', 'image/jpeg', 'DM20180323192235');
INSERT INTO `tb_material` VALUES ('32', 'GHZ', 'DM20180323192235GHZ', '775702', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180323192235GHZ', 'image/jpeg', 'DM20180323192235');
INSERT INTO `tb_material` VALUES ('33', 'JGZ', 'DM20180323192235JGZ', '780831', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180323192235JGZ', 'image/jpeg', 'DM20180323192235');
INSERT INTO `tb_material` VALUES ('34', 'ZHB', 'DM20180323192235ZHB', '561276', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180323192235ZHB', 'image/jpeg', 'DM20180323192235');
INSERT INTO `tb_material` VALUES ('35', 'QTCL', 'DM20180323192235QTCL', '777835', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180323192235QTCL', 'image/jpeg', 'DM20180323192235');
INSERT INTO `tb_material` VALUES ('36', 'SQS', 'DM20180324104332SQS', '879394', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324104332SQS', 'image/jpeg', 'DM20180324104332');
INSERT INTO `tb_material` VALUES ('37', 'SFZ', 'DM20180324104332SFZ', '775702', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324104332SFZ', 'image/jpeg', 'DM20180324104332');
INSERT INTO `tb_material` VALUES ('38', 'JSZ', 'DM20180324104332JSZ', '561276', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324104332JSZ', 'image/jpeg', 'DM20180324104332');
INSERT INTO `tb_material` VALUES ('39', 'GHZ', 'DM20180324104332GHZ', '777835', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324104332GHZ', 'image/jpeg', 'DM20180324104332');
INSERT INTO `tb_material` VALUES ('40', 'JGZ', 'DM20180324104332JGZ', '879394', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324104332JGZ', 'image/jpeg', 'DM20180324104332');
INSERT INTO `tb_material` VALUES ('41', 'ZHB', 'DM20180324104332ZHB', '775702', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324104332ZHB', 'image/jpeg', 'DM20180324104332');
INSERT INTO `tb_material` VALUES ('42', 'QTCL', 'DM20180324104332QTCL', '620888', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324104332QTCL', 'image/jpeg', 'DM20180324104332');
INSERT INTO `tb_material` VALUES ('43', 'SQS', 'DM20180324105410SQS.jpg', '595284', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324105410SQS', 'image/jpeg', 'DM20180324105410');
INSERT INTO `tb_material` VALUES ('44', 'SFZ', 'DM20180324105410SFZ.jpg', '561276', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324105410SFZ', 'image/jpeg', 'DM20180324105410');
INSERT INTO `tb_material` VALUES ('45', 'JSZ', 'DM20180324105410JSZ.jpg', '620888', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324105410JSZ', 'image/jpeg', 'DM20180324105410');
INSERT INTO `tb_material` VALUES ('46', 'GHZ', 'DM20180324105410GHZ.jpg', '775702', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324105410GHZ', 'image/jpeg', 'DM20180324105410');
INSERT INTO `tb_material` VALUES ('47', 'JGZ', 'DM20180324105410JGZ.jpg', '845941', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324105410JGZ', 'image/jpeg', 'DM20180324105410');
INSERT INTO `tb_material` VALUES ('48', 'ZHB', 'DM20180324105410ZHB.jpg', '879394', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324105410ZHB', 'image/jpeg', 'DM20180324105410');
INSERT INTO `tb_material` VALUES ('49', 'QTCL', 'DM20180324105410QTCL.jpg', '595284', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324105410QTCL', 'image/jpeg', 'DM20180324105410');
INSERT INTO `tb_material` VALUES ('50', 'SQS', 'DM20180324110100SQS.jpg', '845941', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324110100SQS.jpg', 'image/jpeg', 'DM20180324110100');
INSERT INTO `tb_material` VALUES ('51', 'SFZ', 'DM20180324110100SFZ.jpg', '879394', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324110100SFZ.jpg', 'image/jpeg', 'DM20180324110100');
INSERT INTO `tb_material` VALUES ('52', 'JSZ', 'DM20180324110100JSZ.jpg', '595284', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324110100JSZ.jpg', 'image/jpeg', 'DM20180324110100');
INSERT INTO `tb_material` VALUES ('53', 'GHZ', 'DM20180324110100GHZ.jpg', '780831', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324110100GHZ.jpg', 'image/jpeg', 'DM20180324110100');
INSERT INTO `tb_material` VALUES ('54', 'JGZ', 'DM20180324110100JGZ.jpg', '777835', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324110100JGZ.jpg', 'image/jpeg', 'DM20180324110100');
INSERT INTO `tb_material` VALUES ('55', 'ZHB', 'DM20180324110100ZHB.jpg', '561276', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324110100ZHB.jpg', 'image/jpeg', 'DM20180324110100');
INSERT INTO `tb_material` VALUES ('56', 'QTCL', 'DM20180324110100QTCL.jpg', '620888', 'D:\\javaworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\EstateManageSystem\\upfile\\DM20180324110100QTCL.jpg', 'image/jpeg', 'DM20180324110100');

-- ----------------------------
-- Table structure for tb_m_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_m_type`;
CREATE TABLE `tb_m_type` (
  `Material_type_number` varchar(32) NOT NULL COMMENT '材料类型编号',
  `Material_name` varchar(255) NOT NULL COMMENT '材料名称',
  PRIMARY KEY  (`Material_type_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_m_type
-- ----------------------------
INSERT INTO `tb_m_type` VALUES ('DYHT', '抵押合同原件');
INSERT INTO `tb_m_type` VALUES ('GHZ', '建设工程符合规划的证明');
INSERT INTO `tb_m_type` VALUES ('GYZ', '国有土地使用证');
INSERT INTO `tb_m_type` VALUES ('JGZ', '房屋已竣工的证明');
INSERT INTO `tb_m_type` VALUES ('JSZ', '建设用地使用权证明');
INSERT INTO `tb_m_type` VALUES ('QTCL', '其他材料');
INSERT INTO `tb_m_type` VALUES ('SFZ', '申请人身份证明');
INSERT INTO `tb_m_type` VALUES ('SQS', '登记申请书');
INSERT INTO `tb_m_type` VALUES ('SYZ', '房屋所有权证');
INSERT INTO `tb_m_type` VALUES ('ZHB', '房屋测绘报告');
INSERT INTO `tb_m_type` VALUES ('ZZHT', '主债权合同原件');

-- ----------------------------
-- Table structure for tb_roomrecord
-- ----------------------------
DROP TABLE IF EXISTS `tb_roomrecord`;
CREATE TABLE `tb_roomrecord` (
  `number` int(32) default NULL COMMENT '序号',
  `movie_theater` varchar(32) default NULL COMMENT '栋号',
  `Room_number` varchar(32) default NULL COMMENT '房号',
  `area` varchar(32) default NULL COMMENT '面积',
  `buyer` varchar(32) default NULL COMMENT '买受人',
  `business_number` varchar(32) NOT NULL COMMENT '合同号',
  `Signing_time` datetime default NULL COMMENT '签约时间',
  `total_price` double default NULL COMMENT '总房款',
  `payment_method` varchar(32) default NULL COMMENT '付款方式',
  `Booking_record` varchar(255) default NULL COMMENT '预售备案',
  `Mortgage_reg` varchar(255) default NULL COMMENT '按揭备案',
  `Mortgage_bank` varchar(255) default NULL COMMENT '按揭银行',
  `Item_no` varchar(32) NOT NULL COMMENT '项目号',
  PRIMARY KEY  (`business_number`),
  KEY `FK_Reference_1` (`Item_no`),
  KEY `FK_Reference_9` (`business_number`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`Item_no`) REFERENCES `tb_housing_project` (`Item_no`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`business_number`) REFERENCES `tb_business` (`business_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_roomrecord
-- ----------------------------
INSERT INTO `tb_roomrecord` VALUES ('19', '055栋', '2168号', '096', '伍彬行', 'DA20180316113758', '2018-03-16 11:37:58', '3415500', '按揭付款', '有预售备案', '有按揭备案', '中国交通银行', 'XM1009');
INSERT INTO `tb_roomrecord` VALUES ('29', '022栋', '2266号', '128', '纪时', 'DA20180316113815', '2018-03-16 11:38:15', '1574100', '按揭付款', '有预售备案', '无按揭备案', '中国建设银行', 'XM1009');
INSERT INTO `tb_roomrecord` VALUES ('49', '067栋', '2059号', '173', '法玉琴', 'DA20180316113843', '2018-03-16 11:38:43', '4415400', '按揭付款', '有预售备案', '有按揭备案', '中国交通银行', 'XM1002');
INSERT INTO `tb_roomrecord` VALUES ('25', '057栋', '1102号', '197', '门枫', 'DC20180316113808', '2018-03-16 11:38:08', '3904200', '按揭付款', '有预售备案', '有按揭备案', '中国银行', 'XM1006');
INSERT INTO `tb_roomrecord` VALUES ('36', '064栋', '1828号', '202', '笪月', 'DC20180316113825', '2018-03-16 11:38:25', '3091200', '按揭付款', '有预售备案', '有按揭备案', '中国建设银行', 'XM1006');
INSERT INTO `tb_roomrecord` VALUES ('42', '008栋', '2686号', '094', '亢达发', 'DC20180316113832', '2018-03-16 11:38:32', '897900', '按揭付款', '有预售备案', '有按揭备案', '中国银行', 'XM1010');
INSERT INTO `tb_roomrecord` VALUES ('44', '034栋', '1334号', '263', '韩美妍', 'DC20180316113834', '2018-03-16 11:38:34', '3136500', '按揭付款', '有预售备案', '有按揭备案', '中国农业银行', 'XM1003');
INSERT INTO `tb_roomrecord` VALUES ('17', '085栋', '807号', '228', '胥宁', 'DF20180316113756', '2018-03-16 11:37:56', '1493100', '按揭付款', '无预售备案', '无按揭备案', '中国建设银行', 'XM1009');
INSERT INTO `tb_roomrecord` VALUES ('24', '057栋', '2504号', '292', '苗弘岩', 'DF20180316113806', '2018-03-16 11:38:06', '2928300', '按揭付款', '有预售备案', '无按揭备案', '中国建设银行', 'XM1005');
INSERT INTO `tb_roomrecord` VALUES ('32', '074栋', '774号', '134', '贺峰', 'DF20180316113818', '2018-03-16 11:38:18', '2678400', '按揭付款', '无预售备案', '有按揭备案', '中国商业银行', 'XM1004');
INSERT INTO `tb_roomrecord` VALUES ('38', '098栋', '3055号', '312', '毕勤薇', 'DF20180316113827', '2018-03-16 11:38:27', '5023200', '按揭付款', '有预售备案', '无按揭备案', '中国建设银行', 'XM1008');
INSERT INTO `tb_roomrecord` VALUES ('40', '052栋', '336号', '339', '寿斌', 'DF20180316113829', '2018-03-16 11:38:29', '2637600', '按揭付款', '有预售备案', '有按揭备案', '中国建设银行', 'XM1006');
INSERT INTO `tb_roomrecord` VALUES ('46', '021栋', '1161号', '084', '师晓融', 'DF20180316113838', '2018-03-16 11:38:38', '2592000', '按揭付款', '无预售备案', '有按揭备案', '中国银行', 'XM1003');
INSERT INTO `tb_roomrecord` VALUES ('20', '043栋', '755号', '296', '百军', 'DM20180316113759', '2018-03-16 11:37:59', '1635600', '按揭付款', '无预售备案', '有按揭备案', '中国交通银行', 'XM1005');
INSERT INTO `tb_roomrecord` VALUES ('34', '054栋', '1533号', '325', '暨思', 'DM20180316113821', '2018-03-16 11:38:21', '2325600', '按揭付款', '无预售备案', '有按揭备案', '中国建设银行', 'XM1010');
INSERT INTO `tb_roomrecord` VALUES ('35', '079栋', '837号', '292', '汪颖雁', 'DM20180316113823', '2018-03-16 11:38:23', '2969400', '按揭付款', '有预售备案', '有按揭备案', '中国交通银行', 'XM1002');
INSERT INTO `tb_roomrecord` VALUES ('48', '091栋', '1360号', '260', '舌世刚', 'DM20180316113842', '2018-03-16 11:38:42', '3985200', '按揭付款', '有预售备案', '有按揭备案', '中国交通银行', 'XM1004');
INSERT INTO `tb_roomrecord` VALUES ('52', '1', '1', '1', '小明', 'DM20180319143927', '2018-03-19 08:00:00', '11111', '全额付款', '无', '无', '中国银行', 'XM1001');
INSERT INTO `tb_roomrecord` VALUES (null, '1', '1', '100', '郭宵宵', 'DM20180323192235', '2018-03-23 08:00:00', '100', '分期付款', '1234546487', '12345646565', '中国农业银行', 'XM1001');
INSERT INTO `tb_roomrecord` VALUES (null, '1', '1', '1', '小小', 'DM20180324105410', '2018-03-24 08:00:00', '111', '全额付款', '11111', '11111', '中国交通银行', 'XM1001');
INSERT INTO `tb_roomrecord` VALUES (null, '1', '1', '1', '你大爷', 'DM20180324110100', '2018-03-24 08:00:00', '1', '全额付款', '1', '123123123', '', 'XM1002');
INSERT INTO `tb_roomrecord` VALUES ('33', '060栋', '135号', '277', '纪玲眉', 'DU20180316113820', '2018-03-16 11:38:20', '681600', '按揭付款', '有预售备案', '有按揭备案', '中国农业银行', 'XM1005');
INSERT INTO `tb_roomrecord` VALUES ('37', '027栋', '2274号', '070', '管娅', 'DU20180316113826', '2018-03-16 11:38:26', '4719000', '按揭付款', '有预售备案', '有按揭备案', '中国建设银行', 'XM1010');
INSERT INTO `tb_roomrecord` VALUES ('45', '011栋', '2781号', '045', '叶霄莉', 'DU20180316113837', '2018-03-16 11:38:37', '2046000', '按揭付款', '有预售备案', '有按揭备案', '中国建设银行', 'XM1001');
INSERT INTO `tb_roomrecord` VALUES ('47', '040栋', '1440号', '188', '车国坚', 'DU20180316113841', '2018-03-16 11:38:41', '621300', '按揭付款', '无预售备案', '有按揭备案', '中国建设银行', 'XM1003');
INSERT INTO `tb_roomrecord` VALUES ('12', '037栋', '1169号', '170', '台全', 'EA20180316113750', '2018-03-16 11:37:50', '1435200', '按揭付款', '有预售备案', '有按揭备案', '中国农业银行', 'XM1010');
INSERT INTO `tb_roomrecord` VALUES ('14', '018栋', '430号', '285', '赵顺河', 'EA20180316113752', '2018-03-16 11:37:52', '3898800', '按揭付款', '有预售备案', '有按揭备案', '中国商业银行', 'XM1004');
INSERT INTO `tb_roomrecord` VALUES ('16', '059栋', '1635号', '209', '商斌', 'EA20180316113754', '2018-03-16 11:37:54', '1170300', '按揭付款', '有预售备案', '有按揭备案', '中国建设银行', 'XM1009');
INSERT INTO `tb_roomrecord` VALUES ('21', '073栋', '1358号', '183', '游飞辉', 'EA20180316113800', '2018-03-16 11:38:00', '1012200', '按揭付款', '有预售备案', '有按揭备案', '中国商业银行', 'XM1002');
INSERT INTO `tb_roomrecord` VALUES ('22', '030栋', '1274号', '150', '师娜', 'EA20180316113801', '2018-03-16 11:38:01', '6029100', '按揭付款', '无预售备案', '有按揭备案', '中国银行', 'XM1010');
INSERT INTO `tb_roomrecord` VALUES ('28', '043栋', '667号', '239', '喻蓓莺', 'EA20180316113814', '2018-03-16 11:38:14', '2970000', '按揭付款', '有预售备案', '有按揭备案', '中国交通银行', 'XM1003');
INSERT INTO `tb_roomrecord` VALUES ('15', '007栋', '230号', '309', '童承博', 'MA20180316113753', '2018-03-16 11:37:53', '2624400', '按揭付款', '有预售备案', '无按揭备案', '中国建设银行', 'XM1005');
INSERT INTO `tb_roomrecord` VALUES ('26', '068栋', '1826号', '094', '谭倩', 'MA20180316113810', '2018-03-16 11:38:10', '357000', '按揭付款', '无预售备案', '有按揭备案', '中国农业银行', 'XM1004');
INSERT INTO `tb_roomrecord` VALUES ('43', '075栋', '2169号', '168', '罗朗风', 'MA20180316113833', '2018-03-16 11:38:33', '3849300', '按揭付款', '有预售备案', '有按揭备案', '中国商业银行', 'XM1006');
INSERT INTO `tb_roomrecord` VALUES ('13', '060栋', '1616号', '107', '靳眉', 'OA20180316113751', '2018-03-16 11:37:51', '3427200', '按揭付款', '有预售备案', '有按揭备案', '中国交通银行', 'XM1004');
INSERT INTO `tb_roomrecord` VALUES ('27', '087栋', '658号', '153', '厍震', 'OA20180316113812', '2018-03-16 11:38:12', '1497600', '按揭付款', '有预售备案', '有按揭备案', '中国商业银行', 'XM1002');
INSERT INTO `tb_roomrecord` VALUES ('30', '043栋', '2000号', '173', '糜辰奇', 'OA20180316113816', '2018-03-16 11:38:16', '1486800', '按揭付款', '无预售备案', '有按揭备案', '中国交通银行', 'XM1002');
INSERT INTO `tb_roomrecord` VALUES ('31', '007栋', '1216号', '048', '赏婕', 'OA20180316113817', '2018-03-16 11:38:17', '899100', '按揭付款', '有预售备案', '有按揭备案', '中国建设银行', 'XM1002');
INSERT INTO `tb_roomrecord` VALUES ('39', '014栋', '1490号', '078', '秋伯', 'OA20180316113828', '2018-03-16 11:38:28', '2316600', '按揭付款', '有预售备案', '有按揭备案', '中国农业银行', 'XM1005');
INSERT INTO `tb_roomrecord` VALUES ('41', '013栋', '2562号', '338', '钦亨', 'OA20180316113831', '2018-03-16 11:38:31', '1398600', '按揭付款', '有预售备案', '无按揭备案', '中国银行', 'XM1006');
INSERT INTO `tb_roomrecord` VALUES ('18', '073栋', '1079号', '125', '席发之', 'TA20180316113757', '2018-03-16 11:37:57', '349200', '按揭付款', '有预售备案', '有按揭备案', '中国银行', 'XM1002');
INSERT INTO `tb_roomrecord` VALUES ('23', '007栋', '1358号', '182', '郭伊琳', 'TA20180316113803', '2018-03-16 11:38:03', '1474200', '按揭付款', '有预售备案', '有按揭备案', '中国建设银行', 'XM1006');

-- ----------------------------
-- Table structure for tb_service
-- ----------------------------
DROP TABLE IF EXISTS `tb_service`;
CREATE TABLE `tb_service` (
  `service_number` varchar(4) NOT NULL COMMENT '业务编号',
  `service_name` varchar(32) default NULL COMMENT '业务名称',
  `f_service` varchar(4) NOT NULL COMMENT '业务父编号',
  `level_price` decimal(10,2) default NULL,
  PRIMARY KEY  (`service_number`,`f_service`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_service
-- ----------------------------
INSERT INTO `tb_service` VALUES ('A', '所有权登记-经济适用房初始登记', 'D', '100.00');
INSERT INTO `tb_service` VALUES ('A', '地役权登记', 'E', '300.00');
INSERT INTO `tb_service` VALUES ('A', '抵押权登记', 'M', '300.00');
INSERT INTO `tb_service` VALUES ('A', '其他登记', 'O', '300.00');
INSERT INTO `tb_service` VALUES ('A', '预告登记', 'T', '300.00');
INSERT INTO `tb_service` VALUES ('C', '所有权登记-集体入地房屋新建', 'D', '100.00');
INSERT INTO `tb_service` VALUES ('F', '所有权登记-集资建房', 'D', '100.00');
INSERT INTO `tb_service` VALUES ('M', '所有权登记-商品房初始登记', 'D', '100.00');
INSERT INTO `tb_service` VALUES ('U', '所有权登记-城市房屋新建', 'D', '100.00');
