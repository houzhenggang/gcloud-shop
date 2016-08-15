  CREATE DATABASE IF NOT EXISTS gcloud_shop;
  USE gcloud_shop;
  SET FOREIGN_KEY_CHECKS = 0;

  -- ----------------------------
  -- Table structure for tb_shop_area
  -- 地区信息
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_shop_area`;
  CREATE TABLE `tb_shop_area` (
    `id`        BIGINT(20) NOT NULL,
    `type`      tinyint(4) DEFAULT NULL,
    `name`      VARCHAR(128) DEFAULT '',
    `parent_id` BIGINT(20) DEFAULT NULL,
    `zip`       VARCHAR(128) DEFAULT '',
    PRIMARY KEY (`id`),
    KEY `inx_name` (`name`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  -- ----------------------------
  -- Table structure for tb_shop_warehouse
  -- 仓库信息
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_shop_warehouse`;
  CREATE TABLE `tb_shop_warehouse` (
    `id`             BIGINT(30)   PRIMARY KEY  COMMENT '主键（yyyyMMddhhmmss + 门店ID + 4位随机数）',
    `company_id`     BIGINT(30)   DEFAULT NULL COMMENT '公司ID',
    `store_id`       BIGINT(30)   DEFAULT NULL COMMENT '门店ID',
    `warehouse_id`   BIGINT(30)   DEFAULT NULL COMMENT '仓库ID',
    `name`           VARCHAR(255) DEFAULT "默认仓储" COMMENT '默认仓储',
    `address`        VARCHAR(255) DEFAULT '' COMMENT '仓库地址',
    `location`       VARCHAR(255) DEFAULT '' COMMENT '高德地址（经纬度）',
    `created`       TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status` TINYINT(1)  NOT NULL DEFAULT 1,
    KEY `inx_company_id` (`company_id`),
    KEY `inx_store_id` (`store_id`),
    KEY `inx_company_id_store` (`company_id`,`store_id`)
  ) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

