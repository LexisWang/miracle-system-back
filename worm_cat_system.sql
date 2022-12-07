/*
 Navicat Premium Data Transfer

 Source Server         : 本地@worm_cat
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : worm_cat_system

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 07/12/2022 18:23:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bim_dict
-- ----------------------------
DROP TABLE IF EXISTS `bim_dict`;
CREATE TABLE `bim_dict`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `dict_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '代码',
  `dict_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名称',
  `dict_status` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `create_time` bigint NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint NOT NULL DEFAULT 0 COMMENT '更新时间',
  `creator_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者ID',
  `creator_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建者名称',
  `updater_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改者ID',
  `updater_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '修改者名称',
  `version` smallint UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前版本',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '配置字典类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bim_dict
-- ----------------------------

-- ----------------------------
-- Table structure for bim_task
-- ----------------------------
DROP TABLE IF EXISTS `bim_task`;
CREATE TABLE `bim_task`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `job_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '业务ID',
  `job_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '业务名',
  `job_params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '业务参数',
  `job_group` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '业务分组',
  `task_id` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '任务ID',
  `task_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '任务数量',
  `run_count` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '任务运行次数',
  `invoke_target` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '回调目标',
  `cron_expression` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'cron表达式',
  `misfire_policy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '不奏效策略',
  `concurrent` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否并发',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '任务状态',
  `last_time` timestamp NULL DEFAULT NULL COMMENT '上次运行时间',
  `next_time` timestamp NULL DEFAULT NULL COMMENT '下次运行时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '彻底结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `creator_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者ID',
  `creator_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建者名称',
  `updater_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改者ID',
  `updater_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '修改者名称',
  `version` smallint UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前版本',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '定时任务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bim_task
-- ----------------------------

-- ----------------------------
-- Table structure for bim_value
-- ----------------------------
DROP TABLE IF EXISTS `bim_value`;
CREATE TABLE `bim_value`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `value_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '代码',
  `value_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名称',
  `value_status` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `include_ids` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '包含的子ID',
  `belong_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '所属类别名',
  `super_id` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属类别ID',
  `dict_id` int NOT NULL DEFAULT 0 COMMENT '字典类ID',
  `dict_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '字典类名',
  `create_time` bigint NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint NOT NULL DEFAULT 0 COMMENT '更新时间',
  `creator_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者ID',
  `creator_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建者名称',
  `updater_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改者ID',
  `updater_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '修改者名称',
  `version` smallint UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前版本',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '配置字典值' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bim_value
-- ----------------------------
INSERT INTO `bim_value` VALUES (574, 'WD', '华迪国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (575, 'GZ', '易捷国际货运代理', 1, '', '货运,中港', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `bim_value` VALUES (576, 'HAOTENG', '浩腾国际代理', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (577, 'SHIDA', '世达国际代理', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (578, 'KSAD2D_BY_AIR', '沙特空运双清', 1, '[51,64,52,54,53,63,48,50,65,101,177,179]', '空运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 3, b'0');
INSERT INTO `bim_value` VALUES (579, 'KSAD2D_BY_SEA', '沙特海运双清', 1, '[66,67,64,18,51,52,25,53,180]', '海运', 0, 3, '服务渠道', 1629277894000, 1653291188000, 1, '奇迹哥', 1, '奇迹哥', 3, b'0');
INSERT INTO `bim_value` VALUES (580, 'BY-AIR PORT', '机场到机场', 1, '[16,17]', '空运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (581, 'BY-SEA PORT', '港口到港口', 1, '[16,17,129]', '海运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `bim_value` VALUES (582, 'DXB--D2D', '迪拜专线双清', 0, '[16,17]', '', 0, 3, '服务渠道', 1629277894000, 1653448031000, 1, '奇迹哥', 1, '奇迹哥', 10, b'0');
INSERT INTO `bim_value` VALUES (583, 'QATER--D2D', '卡塔尔专线双清', 1, '[16,17]', '', 0, 3, '服务渠道', 1629277894000, 1652633584000, 1, '奇迹哥', 1, '奇迹哥', 3, b'0');
INSERT INTO `bim_value` VALUES (584, 'KUWAIT--D2D', '科威特专线双清', 1, '[16,17]', '', 0, 3, '服务渠道', 1629277894000, 1652633584000, 1, '奇迹哥', 1, '奇迹哥', 3, b'0');
INSERT INTO `bim_value` VALUES (585, 'BAHRAIN--D2D', '巴林专线双清', 1, '[16,17]', '', 0, 3, '服务渠道', 1629277894000, 1652633584000, 1, '奇迹哥', 1, '奇迹哥', 3, b'0');
INSERT INTO `bim_value` VALUES (586, 'OMAN--D2D', '阿曼专线双清', 1, '[16,17]', '', 0, 3, '服务渠道', 1629277894000, 1652633584000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (587, 'Aclass', 'A级', 1, '', '', 0, 2, '客户级别', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (588, 'Bclass', 'B级', 1, '', '', 0, 2, '客户级别', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (589, 'normal', '普货', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (590, 'Charged', '带电普货', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (591, 'SpeacialATK', '敏感ATK', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (592, 'Cclass', 'C级', 1, '', '', 0, 2, '客户级别', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (593, 'Perpay', '预付', 1, '', '', 0, 4, '付款类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (594, 'Topay', '到付', 1, '', '', 0, 4, '付款类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (595, 'SHENGAO', '盛澳国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (596, 'Month pay', '月结', 1, '', '', 0, 4, '付款类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (597, 'DHL', '国际快递DHL', 1, '[16,17]', '空运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (598, 'EasyATK', '普通ATK', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (599, 'YUEFEI', '粤飞国际', 1, '', '货运,中港,报关', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 2, 'Lily武莉', 2, b'0');
INSERT INTO `bim_value` VALUES (600, 'SEA-WORLD', '海沃德国际', 1, '', '货运,报关,中港', 0, 1, '货运代理', 1629277894000, 1654246719000, 1, '奇迹哥', 2, 'Lily武莉', 3, b'0');
INSERT INTO `bim_value` VALUES (601, 'DMC', '德盟国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (602, 'Elite', '亿俐缇国际', 1, '', '货运,中港', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (603, 'RONG SHUN', '荣顺国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (604, 'ANJIE', '安捷国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (605, 'Wnlin', '合联国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (606, 'CHAMPION', '冠捷国际', 1, '', '货运,报关', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (607, 'CHOICE', '赛时国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (608, 'FST', '法斯特国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (609, 'Fasttrack', 'BABU', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (610, 'USKY', '永天国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (611, 'YOULI', '优力国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (612, 'ZYTH', '中运通航', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (613, 'TIANHUI', '天汇-中港', 1, '', '货运,中港,报关', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 2, 'Lily武莉', 4, b'0');
INSERT INTO `bim_value` VALUES (614, '1STC', '渠道一', 1, '[16,17,129]', '空运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `bim_value` VALUES (615, '2STC', '渠道二', 1, '[16,17]', '海运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (616, '3STC', '渠道三', 1, '[16,17]', '海运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (617, '4STC', '渠道四', 1, '', '海运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (618, '5STC', '渠道五', 1, '[16,17]', '海运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (619, 'HACOS', '瀚客国际', 1, '', '货运,报关', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (620, 'JIA YI', '加易国际', 1, '', '货运,中港', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 2, 'Lily武莉', 1, b'0');
INSERT INTO `bim_value` VALUES (621, 'Charger', '充电器类', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (622, 'BATTERY', '纯电池', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (623, 'MixGoods', '杂货', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (624, 'Wearing', '服装包包鞋子饰品', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (625, 'WireMobileFits', '线类手机配件', 1, '', '', 0, 5, '货物类型', 1629277894000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (626, 'LED', 'LED灯类', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (627, 'NonLiWatch', '非锂电池手表', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (628, 'STOCK', '世拓国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (629, 'ZWYT', '中外运通', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (630, 'CITITRANS', '亦邦国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (631, 'YHT', '粤海通', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (632, 'QQT', '全酋通', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (633, 'FOFO', 'FOFO', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (634, 'NASSER', 'NASSER', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (635, 'NSM', 'NSM CARGO', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (636, 'LCD', 'LCD类', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (637, 'EasyMobileFits', '简单手机配件', 1, '', '', 0, 5, '货物类型', 1629277894000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (638, 'ElectPhoneShip', '带电类手机配件', 1, '', '', 0, 5, '货物类型', 1629277894000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (639, 'EasyMixGoods', '简单杂货', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (640, 'WireMixgoods', '线类杂货', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (641, 'ADS', '空运电商小包', 1, '[69,70]', '空运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (642, 'electric', '电商货-带电', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (643, 'non-electric', '电商货-无电', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (644, 'ROCK', '珞石国际', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (645, '6STC', '渠道六', 1, '[16,17]', '海运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (646, 'Franky', 'Franky', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (647, '7STC', '渠道七', 1, '[16,17]', '海运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (648, 'MexicoSeaLine', '墨西哥海运专线', 1, '[16,17]', '海运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `bim_value` VALUES (649, 'A-Class', 'A类', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (650, 'B-Class', 'B类', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (651, 'C-Class', 'C类', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (652, 'D-Class', 'D类', 1, '', '', 0, 5, '货物类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (653, 'YemenSeaLine', '也门海运专线', 1, '[16,17,129]', '海运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `bim_value` VALUES (654, 'ETIHAD', '埃缇罕德代理', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (655, 'MINGJI', '明记物流', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 74, 'ERI梁思文', 1, b'0');
INSERT INTO `bim_value` VALUES (656, 'MexicoAirLine', '墨西哥空运专线', 1, '[16,17]', '空运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `bim_value` VALUES (657, 'CustomsClea', '清关专线', 1, '[85]', '', 0, 3, '服务渠道', 1629277894000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (658, 'CustomsCleaType', '清关类型(清关服务)', 1, '', '', 0, 5, '货物类型', 1629277894000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (659, 'MexicoLine', '墨西哥专线', 1, '[16,17]', '海运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (660, 'CustomsCleaProxy', '清关代理', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (661, 'ARAMEX', '国际快递ARAMEX', 1, '[16,17]', '空运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (662, 'FEDEX', '国际快递FEDEX', 1, '[16,18]', '空运', 0, 3, '服务渠道', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (663, 'Jia Mei', '佳美', 1, '', '货运', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (664, 'TongHang', '同行', 1, '', '', 0, 6, '客户性质', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (665, 'MarketDC', '市场直客', 1, '', '', 0, 6, '客户性质', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (666, 'E-CC', '电商客户', 1, '', '', 0, 6, '客户性质', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (667, 'CusInt', '客户介绍', 1, '', '', 0, 7, '获客途径', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (668, 'SaleSoft', '销冠软件', 1, '', '', 0, 7, '获客途径', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (669, 'WholeSiteSale', '全网营销', 1, '', '', 0, 7, '获客途径', 1629277894000, 1652636527000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (670, 'SelfSale', '自己开发', 1, '', '', 0, 7, '获客途径', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (671, 'CompDistri', '公司配发', 1, '', '', 0, 7, '获客途径', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (672, 'XingLong', '祥龙公司', 1, '', '货运,中港', 0, 1, '货运代理', 1629277894000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (673, 'Topay Half', '半到付', 1, '', '', 0, 4, '付款类型', 1629277894000, 1630573694000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (674, 'NonPhoneElect', '非手机配件类带电货物', 1, '', '', 0, 5, '货物类型', 1629277894000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (675, '8STC', '渠道八', 1, '[16,17]', '', 0, 3, '服务渠道', 1629277894000, 1652633584000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (676, 'ZhengHua', '正华(进口)', 1, '', '货运', 0, 1, '货运代理', 1629279112000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (677, 'HongYing', '宏盈公司', 1, '', '货运', 0, 1, '货运代理', 1629279112000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (678, 'HuiHang', '汇航国际', 1, '', '货运', 0, 1, '货运代理', 1629279112000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (679, 'YLHZ', '医疗化妆品类', 1, '', '', 0, 5, '货物类型', 1629279112000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (680, 'CBF', 'CBF渠道', 1, '[16,17, 106]', '', 0, 3, '服务渠道', 1629279112000, 1652633584000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (681, 'FeiTan', '飞坦物流', 1, '', '货运', 0, 1, '货运代理', 1629279112000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (682, 'IsFree', '免费', 1, '', '', 96, 7, '获客途径', 1630555587000, 1652636527000, 1, '奇迹哥', 1, '奇迹哥', 4, b'0');
INSERT INTO `bim_value` VALUES (683, 'NoFree', '付费', 1, '', '', 96, 7, '获客途径', 1630555603000, 1652636527000, 1, '奇迹哥', 1, '奇迹哥', 5, b'0');
INSERT INTO `bim_value` VALUES (684, 'YingXiao', '营销官网', 1, '', '', 109, 7, '获客途径', 1630562131000, 1652636420000, 1, '奇迹哥', 1, '奇迹哥', 4, b'0');
INSERT INTO `bim_value` VALUES (685, 'Aicaigou', '爱采购', 1, '', '', 109, 7, '获客途径', 1630562225000, 1652636418000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (686, 'GuanWang(Origin)', '官网(原)', 1, '', '', 109, 7, '获客途径', 1631583228000, 1652636420000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (687, 'Douyin', '抖音', 1, '', '', 109, 7, '获客途径', 1631583264000, 1652636419000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (688, 'Alibaba', '阿里巴巴', 1, '', '', 109, 7, '获客途径', 1631583316000, 1652636419000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (689, 'SheQun', '社群推广', 1, '', '', 109, 7, '获客途径', 1631583359000, 1652636419000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (690, 'OtherPath', '其他途径', 1, '', '', 109, 7, '获客途径', 1631583385000, 1652636418000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (691, 'ABU', 'ABU货运', 1, '', '货运', 0, 1, '货运代理', 1631591113000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (692, 'HangMeiDa', '杭美达公司', 1, '', '货运', 0, 1, '货运代理', 1631591167000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (693, 'FengMing', '丰鸣公司', 1, '', '货运,中港,报关', 0, 1, '货运代理', 1631591196000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `bim_value` VALUES (694, 'deliveryServer', '送仓服务', 1, '[16,50]', '海运', 0, 3, '服务渠道', 1631701939000, 1664437993000, 119, 'Azer王荣先', 119, 'Azer王荣先', 1, b'0');
INSERT INTO `bim_value` VALUES (695, 'deliveryProxy', '送仓代理', 1, '', '货运', 0, 1, '货运代理', 1631788080000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (696, 'ABU', '渠道一(ABU)', 1, '[16,17]', '空运', 0, 3, '服务渠道', 1634347560000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (697, 'YOUAN', '由昂公司', 1, '', '货运', 0, 1, '货运代理', 1634536159000, 1652633801000, 2, 'Lily武莉', 2, 'Lily武莉', 0, b'0');
INSERT INTO `bim_value` VALUES (698, 'YTGS', '亿泰公司', 1, '', '货运', 0, 1, '货运代理', 1634910886000, 1652633801000, 2, 'Lily武莉', 2, 'Lily武莉', 0, b'0');
INSERT INTO `bim_value` VALUES (699, 'Sensitive', '敏感货', 1, '', '', 0, 5, '货物类型', 1635477365000, 1635477365000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (700, 'TopayCash', '到付(现金)', 1, '', '', 0, 4, '付款类型', 1635503464000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (701, 'TopayNotCash', '到付(非现金)', 1, '', '', 0, 4, '付款类型', 1635503498000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (702, 'TopayHalfCash', '半到付(现金)', 1, '', '', 0, 4, '付款类型', 1635503656000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (703, 'TopayHalfNoCash', '半到付(非现金)', 1, '', '', 0, 4, '付款类型', 1635503688000, 1664437993000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (704, 'GuTeWei', '固特威国际', 1, '', '货运', 0, 1, '货运代理', 1635920103000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (705, 'BDJJ', '百度搜索', 1, '', '', 110, 7, '获客途径', 1637896068000, 1652636421000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (706, 'BDXXL', '百度信息流', 1, '', '', 110, 7, '获客途径', 1637896092000, 1652636421000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (707, 'BDZSYX', '百度知识营销', 1, '', '', 110, 7, '获客途径', 1637896124000, 1652636421000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (708, '360JJ', '360搜索', 1, '', '', 110, 7, '获客途径', 1637896158000, 1652636420000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (709, '360XXL', '360信息流', 0, '', '', 110, 7, '获客途径', 1637896179000, 1652636421000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (710, 'SGJJ', '搜狗搜索', 1, '', '', 110, 7, '获客途径', 1637896210000, 1652636421000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (711, 'SGXXL', '搜狗信息流', 0, '', '', 110, 7, '获客途径', 1637896230000, 1652636421000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (712, 'ZGGYS', '中国供应商', 1, '', '', 109, 7, '获客途径', 1637975853000, 1652636420000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (713, 'XGY', '小狐云', 1, '', '', 109, 7, '获客途径', 1637975870000, 1652636419000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (714, 'HaiBang', '海邦代理', 1, '', '货运,中港,报关', 0, 1, '货运代理', 1638700456000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `bim_value` VALUES (715, 'HuHang', '虎航代理', 1, '', '货运,中港', 0, 1, '货运代理', 1638700630000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (716, 'JUNYA', '俊亚中港', 1, '', '中港', 0, 1, '货运代理', 1640398984000, 1652633801000, 2, 'Lily武莉', 2, 'Lily武莉', 0, b'0');
INSERT INTO `bim_value` VALUES (717, 'HUIDA', '汇达报关', 1, '', '报关', 0, 1, '货运代理', 1640399128000, 1652633801000, 2, 'Lily武莉', 2, 'Lily武莉', 0, b'0');
INSERT INTO `bim_value` VALUES (718, 'CompanyPosters', '公司海报', 1, '', '', 109, 7, '获客途径', 1640569113000, 1652636527000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (719, 'ZHENGZHOU', '正州报关行', 1, '', '报关', 0, 1, '货运代理', 1640829899000, 1652633801000, 2, 'Lily武莉', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (720, 'WANLONG', '万隆诚运', 1, '', '货运', 0, 1, '货运代理', 1640923335000, 1652633801000, 74, 'ERI梁思文', 74, 'ERI梁思文', 0, b'0');
INSERT INTO `bim_value` VALUES (721, 'ShenMa', '神马搜索', 1, '', '', 110, 7, '获客途径', 1641348474000, 1652636418000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (722, 'HAIYA', '海雅国际海运', 1, '', '货运', 0, 1, '货运代理', 1641439905000, 1652633801000, 2, 'Lily武莉', 2, 'Lily武莉', 0, b'0');
INSERT INTO `bim_value` VALUES (723, 'KuaiShou', '快手', 1, '', '', 109, 7, '获客途径', 1641870452000, 1652636420000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (724, 'ZJSC', '中集世倡', 1, '', '货运,中港,报关', 0, 1, '货运代理', 1641959480000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (725, 'TieBa', '贴吧', 1, '', '', 109, 7, '获客途径', 1642054746000, 1652636419000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (726, 'XHS', '小红书', 1, '', '', 109, 7, '获客途径', 1642212684000, 1652636419000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (727, 'BXW', '百姓网', 1, '', '', 109, 7, '获客途径', 1642489910000, 1652636420000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (728, 'CKJS', '客户转介绍', 1, '', '', 109, 7, '获客途径', 1644828558000, 1652636420000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (729, 'BZhan', 'B站', 1, '', '', 109, 7, '获客途径', 1645090633000, 1652636420000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (730, 'XHY-DYGJ', '小狐云-抖音工具', 1, '', '', 109, 7, '获客途径', 1645090678000, 1652636420000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (731, 'WeiBo', '微博', 1, '', '', 109, 7, '获客途径', 1646805415000, 1652636420000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (732, 'TGLYZX', '泰国陆运专线', 1, '[16,129,17]', '空运', 0, 3, '服务渠道', 1647826937000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `bim_value` VALUES (733, 'TGHYZX', '泰国海运专线', 1, '[16,17,129]', '海运', 0, 3, '服务渠道', 1647826971000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (734, 'MLXYKY', '马来西亚空运', 1, '[16,17,129]', '空运', 0, 3, '服务渠道', 1647827022000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (735, 'MLXYHY', '马来西亚海运', 1, '[16,17,129]', '海运', 0, 3, '服务渠道', 1647827043000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (736, 'FLBKY', '菲律宾空运', 1, '[16,17,129]', '空运', 0, 3, '服务渠道', 1647827070000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (737, 'FLBHY', '菲律宾海运', 1, '[16,17,129]', '海运', 0, 3, '服务渠道', 1647827091000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (738, 'HAOPENG', '皓鹏国际物流', 1, '', '货运', 0, 1, '货运代理', 1648015951000, 1652633801000, 2, 'Lily武莉', 2, 'Lily武莉', 0, b'0');
INSERT INTO `bim_value` VALUES (739, 'HuangYe', '黄页', 1, '', '', 109, 7, '获客途径', 1648537245000, 1652636419000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (740, 'WaiDaiGuoJi', '外代国际', 1, '', '货运,中港', 0, 1, '货运代理', 1649411099000, 1652633801000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (741, 'EuropeLine', '欧洲专线', 1, '[16,17,25,50,51,52,67,66]', '', 0, 3, '服务渠道', 1650444842000, 1652633584000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (742, 'CDS', 'CDS渠道', 1, '[16,17,66]', '', 0, 3, '服务渠道', 1651124763000, 1652633584000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (743, 'Dubai-SEA', '迪拜海运专线', 1, '[16,129]', '海运', 0, 3, '服务渠道', 1651540620000, 1653449699000, 1, '奇迹哥', 74, 'ERI梁思文', 2, b'0');
INSERT INTO `bim_value` VALUES (744, 'Dubai-AIR', '迪拜空运专线', 1, '[16,129]', '空运', 0, 3, '服务渠道', 1651540673000, 1654509515000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `bim_value` VALUES (745, 'WXSPH', '微信视频号', 1, '', '', 109, 7, '获客途径', 1651721225000, 1652636504000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (746, 'Glasses', '眼镜类', 1, '', '', 0, 5, '货物类型', 1652249571000, 1652249571000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (747, 'GoogleSearch', '谷歌搜索', 1, '', '', 110, 7, '获客途径', 1652437811000, 1652636503000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (748, 'ZNSB', '智能手表(带电)', 1, '', '', 0, 5, '货物类型', 1652494781000, 1652494781000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (749, 'DDSB', '带电手表', 1, '', '', 0, 5, '货物类型', 1653291121000, 1653291121000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (750, 'B2BWebsite', 'B2B网站', 1, '', '', 109, 7, '获客途径', 1653529149000, 1654762402000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `bim_value` VALUES (751, 'GZHSS', '公众号搜索', 1, '', '', 109, 7, '获客途径', 1654064792000, 1654064792000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (752, 'WL', 'WL Logistices西城物流', 1, '', '货运,中港', 0, 1, '货运代理', 1654246845000, 1654246845000, 2, 'Lily武莉', 2, 'Lily武莉', 0, b'0');
INSERT INTO `bim_value` VALUES (753, 'YML', 'Young move limited', 1, '', '货运,中港,报关', 0, 1, '货运代理', 1655783092000, 1655783092000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `bim_value` VALUES (754, 'ARAU', 'Atheryoun', 1, '', '报关', 0, 1, '货运代理', 1656724914000, 1656724914000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');

-- ----------------------------
-- Table structure for sys_button
-- ----------------------------
DROP TABLE IF EXISTS `sys_button`;
CREATE TABLE `sys_button`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '代码号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称码',
  `menu_id` int UNSIGNED NOT NULL COMMENT '所属菜单ID',
  `menu_ids` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属所有菜单IDS',
  `menu_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '所属菜单名',
  `sort_no` int UNSIGNED NOT NULL COMMENT '所属模块号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000000012 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '按钮配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_button
-- ----------------------------
INSERT INTO `sys_button` VALUES (1000000001, '1-1-1', 'org-search', 2, '[1,2]', '组织管理', 1);
INSERT INTO `sys_button` VALUES (1000000002, '1-1-1-1', 'org-add', 2, '[1,2]', '组织管理', 1);
INSERT INTO `sys_button` VALUES (1000000003, '1-1-1-2', 'export-org-all', 2, '[1,2]', '组织管理', 1);
INSERT INTO `sys_button` VALUES (1000000004, '1-1-2', 'org-table', 2, '[1,2]', '组织管理', 2);
INSERT INTO `sys_button` VALUES (1000000005, '1-1-2-1', 'org-detail', 2, '[1,2]', '组织管理', 2);
INSERT INTO `sys_button` VALUES (1000000006, '1-1-2-2', 'org-update', 2, '[1,2]', '组织管理', 2);
INSERT INTO `sys_button` VALUES (1000000007, '1-1-2-3', 'org-switch-status', 2, '[1,2]', '组织管理', 2);
INSERT INTO `sys_button` VALUES (1000000008, '1-1-2-4', 'org-delete', 2, '[1,2]', '组织管理', 2);
INSERT INTO `sys_button` VALUES (1000000009, '1-1-1-3', 'export-org-page', 2, '[1,2]', '组织管理', 1);
INSERT INTO `sys_button` VALUES (1000000010, '1-1-3-1', 'org-cancel-submit', 2, '[1,2]', '组织管理', 3);
INSERT INTO `sys_button` VALUES (1000000011, '1-1-3-2', 'org-ensure-submit', 2, '[1,2]', '组织管理', 3);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `menu_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '代码',
  `menu_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名称',
  `menu_url` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '路由url',
  `menu_icon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '图标',
  `menu_status` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `is_leaf` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否叶子',
  `sort_no` tinyint UNSIGNED NOT NULL DEFAULT 1 COMMENT '排序号',
  `tier_level` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '层级',
  `global_sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '唯一序号(紧凑)',
  `p_id` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '父级ID',
  `p_ids` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '所有父级ID',
  `menu_remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注信息',
  `create_time` bigint NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint NOT NULL DEFAULT 0 COMMENT '更新时间',
  `creator_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者ID',
  `creator_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建者名称',
  `updater_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改者ID',
  `updater_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '修改者名称',
  `version` smallint UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前版本',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 'system', '系统管理', '/system', 'setting', 1, b'0', 1, 0, 0, 0, '[0]', '', 1669884829300, 1669884829300, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `sys_menu` VALUES (2, 'organization', '组织管理', '/system/organization', 'home-filled', 1, b'1', 1, 1, 0, 1, '[1]', '', 1669884889769, 1669884889769, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `sys_menu` VALUES (3, 'permission', '权限管理', '/system/permission', 'lock', 1, b'1', 2, 1, 0, 1, '[1]', '', 1669885198930, 1669885198930, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `sys_menu` VALUES (4, 'menu', '菜单管理', '/system/menu', 'menu', 1, b'1', 3, 1, 0, 1, '[1]', '', 1669885325853, 1669885325853, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `org_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '代码',
  `org_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名称',
  `org_desc` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '描述',
  `address` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '联系地址',
  `contact` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '联系方式',
  `email` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '联系邮箱',
  `org_status` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `is_leaf` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否叶子',
  `sort_no` tinyint UNSIGNED NOT NULL DEFAULT 1 COMMENT '排序号',
  `scope_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '权限码',
  `tier_level` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '权限等级',
  `p_id` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '父级ID',
  `p_ids` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '所有父级ID',
  `org_remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注信息',
  `create_time` bigint NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint NOT NULL DEFAULT 0 COMMENT '更新时间',
  `creator_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者ID',
  `creator_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建者名称',
  `updater_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改者ID',
  `updater_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '修改者名称',
  `version` smallint UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前版本',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门组织' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES (1, 'Sys-Dep', '系统开发部', '负责整个系统的开发', '', '0507829', 'miracle@google.com', 1, b'0', 0, '1', 0, 0, '', '', 1624843557000, 1669456356654, 1, '奇迹哥', 1, '奇迹哥', 4, b'0');
INSERT INTO `sys_org` VALUES (2, 'GZ-ZB', '广州总部', '管理整个公司的事务', '广州省广州市白云区穗新创意园B栋', '', '', 1, b'0', 1, '1', 0, 0, '', '', 1624849915000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `sys_org` VALUES (3, 'Sale-Dep(GZ)', '业务部(GZ)', '负责客户开发与跟进', '', '', '', 1, b'0', 1, '1-1-1', 2, 20, '[2,20]', '', 1624849991000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `sys_org` VALUES (4, 'Server-Dep', '关务部', '负责客户发货及收货的维系工作', '', '', '', 1, b'0', 4, '1-4', 1, 2, '[2]', '', 1624850061000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `sys_org` VALUES (5, 'Auditor-Dep(GZ)', '审核部(GZ)', '', '', '', '', 1, b'1', 2, '1-1-2', 2, 20, '[2,20]', '', 1624853623000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 4, b'0');
INSERT INTO `sys_org` VALUES (6, 'Store-Dep(GZ)', '仓务部(GZ)', '', '', '', '', 1, b'1', 3, '1-1-3', 2, 20, '[2,20]', '', 1624853682000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `sys_org` VALUES (7, 'Finance-Dep', '财务部', '', '', '', '', 1, b'1', 5, '1-5', 1, 2, '[2]', '', 1627006311000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `sys_org` VALUES (8, 'Operate-Dep', '操作部', '', '', '', '', 1, b'1', 6, '1-6', 1, 2, '[2]', '', 1627006342000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `sys_org` VALUES (9, 'YW-FB', '义乌分部', '管理整个公司的事务', '', '', '', 1, b'0', 2, '1-2', 1, 2, '[2]', '', 1629083515000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 3, b'0');
INSERT INTO `sys_org` VALUES (10, 'Sale-Dep(YW)', '业务部(YW)', '负责客户开发与跟进', '', '', '', 1, b'1', 1, '1-2-1', 2, 9, '[2,9]', '', 1629083591000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `sys_org` VALUES (11, 'SZ-FB', '深圳分部', '管理整个公司的事务', '', '', '', 1, b'0', 3, '1-3', 1, 2, '[2]', '', 1629083515000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 3, b'0');
INSERT INTO `sys_org` VALUES (12, 'Sale-Dep(SZ)', '业务部(SZ)', '负责客户开发与跟进', '', '', '', 1, b'1', 1, '1-3-1', 2, 11, '[2,11]', '', 1629083591000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `sys_org` VALUES (13, 'Store-Dep(YW)', '仓务部(YW)', '', '', '', '', 1, b'1', 3, '1-2-3', 2, 9, '[2,9]', '', 1624853682000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `sys_org` VALUES (14, 'Store-Dep(SZ)', '仓务部(SZ)', '', '', '', '', 1, b'1', 3, '1-3-3', 2, 11, '[2,11]', '', 1624853682000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 3, b'0');
INSERT INTO `sys_org` VALUES (15, 'Market-Group', '市场组', '', '', '', '', 1, b'0', 1, '1-1-1-1', 3, 3, '[2,20,3]', '', 1636697360000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 3, b'0');
INSERT INTO `sys_org` VALUES (16, 'E-commGroup', '电商组', '', '', '', '', 1, b'1', 2, '1-1-1-2', 3, 3, '[2,20,3]', '', 1636697420000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 3, b'0');
INSERT INTO `sys_org` VALUES (17, 'SiteGroup', '网销组', '', '', '', '', 1, b'1', 3, '1-1-1-3', 3, 3, '[2,20,3]', '', 1636697517000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 4, b'0');
INSERT INTO `sys_org` VALUES (18, 'BOSSGroup', 'BOSS组', '', '', '', '', 1, b'1', 5, '13', 0, 0, '[0]', '', 1636698892000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 1, b'0');
INSERT INTO `sys_org` VALUES (19, 'KuaJing', '跨境组', '', '', '', '', 1, b'1', 4, '1-1-1-4', 3, 3, '[2,20,3]', '', 1638162054000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 3, b'0');
INSERT INTO `sys_org` VALUES (20, 'GZ-FB', '广州分部', '管理广州分区的事务', '', '', '', 1, b'0', 1, '1-1', 1, 2, '[2]', '', 1652249752000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 9, b'0');
INSERT INTO `sys_org` VALUES (21, 'Group-A(GZ-SC)', 'A组(GZ-SC)', '', '', '', '', 1, b'1', 1, '1-1-1-1-1', 4, 15, '[2,20,3,15]', '', 1652261844000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `sys_org` VALUES (22, 'Server-A', '关务A组', '', '', '', '', 1, b'1', 1, '1-4-1', 2, 4, '[2,4]', '奇迹哥(删除): 就是要删除,这么了', 1653528573000, 1669033151000, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `sys_org` VALUES (32, 'ServerBgroup', '关务B组', '', '', '', '', 0, b'1', 2, '1-4', 2, 4, '[2,4]', '', 1669474624016, 1669803112584, 1, '奇迹哥', 1, '奇迹哥', 4, b'0');

-- ----------------------------
-- Table structure for sys_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `perm_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '代码',
  `perm_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名称',
  `perm_uri` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '路径uri',
  `req_method` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '请求方式',
  `perm_status` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `is_leaf` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否叶子',
  `sort_no` tinyint UNSIGNED NOT NULL DEFAULT 1 COMMENT '排序号',
  `tier_level` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '层级',
  `global_sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '唯一序号(紧凑)',
  `p_id` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '父级ID',
  `p_ids` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '所有父级ID',
  `perm_remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注信息',
  `create_time` bigint NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint NOT NULL DEFAULT 0 COMMENT '更新时间',
  `creator_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者ID',
  `creator_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建者名称',
  `updater_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改者ID',
  `updater_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '修改者名称',
  `version` smallint UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前版本',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_perm
-- ----------------------------
INSERT INTO `sys_perm` VALUES (1, 'system-mgr', '系统管理', '/system-mgr', 'GET', 1, b'0', 1, 0, 0, 0, '[0]', '', 1669876646444, 1669882599390, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `sys_perm` VALUES (2, 'org-mgr', '部门管理', '/system-mgr/sys-org', 'GET', 1, b'0', 1, 1, 0, 1, '[1]', '', 1669877150403, 1669877150404, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `sys_perm` VALUES (3, 'orgOptsData', '部门可选项', '/system-mgr/sys-org/orgOptsData', 'POST', 1, b'1', 1, 2, 0, 2, '[1,2]', '', 1669877265523, 1669877265524, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `sys_perm` VALUES (4, 'checkExist', '检查重复', '/system-mgr/sys-org/checkExist', 'POST', 1, b'1', 2, 2, 0, 2, '[1,2]', '', 1669877367185, 1669882595626, 1, '奇迹哥', 1, '奇迹哥', 2, b'0');
INSERT INTO `sys_perm` VALUES (5, 'orgAddData', '部门新增', '/system-mgr/sys-org/orgAddData', 'POST', 1, b'1', 3, 2, 0, 2, '[1,2]', '', 1669877425283, 1669877425283, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `sys_perm` VALUES (6, 'orgDeleteData', '部门删除', '/system-mgr/sys-org/orgDeleteData', 'DELETE', 1, b'1', 4, 2, 0, 2, '[1,2]', '', 1669877490812, 1669877490812, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `sys_perm` VALUES (7, 'orgUpdateData', '部门修改', '/system-mgr/sys-org/orgUpdateData', 'PUT', 1, b'1', 5, 2, 0, 2, '[1,2]', '', 1669877542370, 1669877542370, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `sys_perm` VALUES (8, 'orgPageData', '分页数据', '/system-mgr/sys-org/orgPageData', 'POST', 1, b'1', 6, 2, 0, 2, '[1,2]', '', 1669877614489, 1669877614489, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `sys_perm` VALUES (9, 'orgExportData', '导出数据', '/system-mgr/sys-org/orgExportData', 'POST', 1, b'1', 7, 2, 0, 2, '[1,2]', '', 1669877660582, 1669877660582, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '代码',
  `role_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名称',
  `role_category` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色类型',
  `role_desc` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '描述',
  `role_status` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `is_leaf` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否叶子',
  `sort_no` tinyint UNSIGNED NOT NULL DEFAULT 1 COMMENT '排序号',
  `scope_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '权限码',
  `org_id` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属组织ID',
  `org_ids` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '所属组所有织ID',
  `org_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '所有组织名',
  `role_remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注信息',
  `create_time` bigint NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint NOT NULL DEFAULT 0 COMMENT '更新时间',
  `creator_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者ID',
  `creator_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建者名称',
  `updater_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改者ID',
  `updater_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '修改者名称',
  `version` smallint UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前版本',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'SystemManager', '系统开发(主管)', 1, '管理整个系统的工作', 1, b'0', 1, '1', 1, '[1]', '', '', 0, 0, 1, '奇迹哥', 1, '奇迹哥', 0, b'0');
INSERT INTO `sys_role` VALUES (2, 'SystemDevoloper', '系统开发员', 1, '', 1, b'1', 2, '1-2', 1, '[1]', '', '', 1669951856354, 1669951856355, 1, '奇迹哥', 1, '奇迹哥', 4, b'0');

-- ----------------------------
-- Table structure for sys_role_button
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_button`;
CREATE TABLE `sys_role_button`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int UNSIGNED NOT NULL COMMENT '角色ID',
  `button_id` int UNSIGNED NOT NULL COMMENT '按钮ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色按钮(中间表)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_button
-- ----------------------------
INSERT INTO `sys_role_button` VALUES (1, 1, 1000000001);
INSERT INTO `sys_role_button` VALUES (2, 1, 1000000002);
INSERT INTO `sys_role_button` VALUES (3, 1, 1000000003);
INSERT INTO `sys_role_button` VALUES (4, 1, 1000000004);
INSERT INTO `sys_role_button` VALUES (5, 1, 1000000005);
INSERT INTO `sys_role_button` VALUES (6, 1, 1000000006);
INSERT INTO `sys_role_button` VALUES (7, 1, 1000000007);
INSERT INTO `sys_role_button` VALUES (8, 1, 1000000008);
INSERT INTO `sys_role_button` VALUES (9, 1, 1000000009);
INSERT INTO `sys_role_button` VALUES (10, 1, 1000000010);
INSERT INTO `sys_role_button` VALUES (11, 1, 1000000011);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int UNSIGNED NOT NULL COMMENT '角色ID',
  `menu_id` int UNSIGNED NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色菜单(中间表)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_perm`;
CREATE TABLE `sys_role_perm`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int UNSIGNED NOT NULL COMMENT '角色ID',
  `perm_Id` int UNSIGNED NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色权限(中间表)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_perm
-- ----------------------------

-- ----------------------------
-- Table structure for sys_staff
-- ----------------------------
DROP TABLE IF EXISTS `sys_staff`;
CREATE TABLE `sys_staff`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '密码',
  `nickname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `email` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '联系邮箱',
  `remark` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '描述',
  `staff_status` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `invite_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '邀请码',
  `mobile` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `super_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '领导ID',
  `super_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '领导姓名',
  `org_id` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属组织ID',
  `org_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '所有组织名',
  `role_id` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属角色ID',
  `role_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '所有角色名',
  `scope_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '权限码',
  `sort_no` bigint NOT NULL DEFAULT -1 COMMENT '排序号',
  `create_time` bigint NOT NULL DEFAULT 0 COMMENT '创建时间',
  `update_time` bigint NOT NULL DEFAULT 0 COMMENT '更新时间',
  `creator_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者ID',
  `creator_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建者名称',
  `updater_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改者ID',
  `updater_name` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '修改者名称',
  `version` smallint UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前版本',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否逻辑删除',
  `org_ids` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '所属所有部门IDS',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门职员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_staff
-- ----------------------------
INSERT INTO `sys_staff` VALUES (1, 'Miracle-', '$2a$10$1nhO41KTsNMSGTD2UG8dH.DQMw4KD1xo2gtVRNd53l2MCbbyAwOTe', '奇迹哥', '', '', 1, '', '15651910652', 0, '', 1, '系统开发部', 1, '系统开发(主管)', '1', -1, 1670313885476, 1670313885476, 1, '奇迹哥', 1, '奇迹哥', 0, b'0', '[1]');
INSERT INTO `sys_staff` VALUES (2, 'Elemer', '$2a$10$7LIGckAS3DaTs/O0JFePlu8lTzLcI1.Q/GOSLvMzn6H1weQAiplYi', '赖春和', '', '', 1, '', '0507829', 1, '奇迹哥', 1, '系统开发部', 2, '系统开发员', '1-2$2', -1, 1670313981066, 1670313981066, 1, '奇迹哥', 1, '奇迹哥', 0, b'0', '[1]');

SET FOREIGN_KEY_CHECKS = 1;
