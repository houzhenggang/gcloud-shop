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
    KEY `inx_shop_id` (`store_id`),
    KEY `inx_company_id_store` (`company_id`,`store_id`)
  ) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_shop_store
  -- 门店信息
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_shop_store`;
  CREATE TABLE `tb_shop_store` (
    `id`               BIGINT(30)   PRIMARY KEY  COMMENT '主键（yyyyMMddhhmmss + 门店ID + 4位随机数）',
    `store_id`         VARCHAR(32)   NOT NULL COMMENT '门店ID',
    `category_id`      VARCHAR(32)   NOT NULL COMMENT '类目id，请参考',
    `brand_name`       VARCHAR(512)  DEFAULT '其它品牌' COMMENT '品牌名，不填写则默认为“其它品牌”',
    `brand_logo`       VARCHAR(512)  DEFAULT NULL COMMENT '品牌LOGO; 图片ID，不填写则默认为门店首图main_image',
    `main_shop_name`   VARCHAR(20)   NOT NULL COMMENT '主门店名 比如：肯德基；主店名里不要包含分店名，如“万塘路店”',
    `branch_shop_name` VARCHAR(20)   DEFAULT NULL COMMENT '分店名称，比如：万塘路店，与主门店名合并在客户端显示为：肯德基(万塘路店)。',
    `shop_type`        VARCHAR(10)   DEFAULT 'COMMON' COMMENT 'COMMON（普通门店）、MALL（商圈）',

    `province_code`    VARCHAR(10)  NOT NULL COMMENT '省份编码，国标码，详见国家统计局数据',
    `city_code`        VARCHAR(10)  NOT NULL COMMENT '城市编码，国标码，详见国家统计局数据',
    `district_code`    VARCHAR(10)  NOT NULL COMMENT '区县编码，国标码，详见国家统计局数据',
    `address`          VARCHAR(50)  NOT NULL  COMMENT '门店详细地址，地址字符长度在4-50个字符，注：不含省市区。例1：道路+门牌号，“人民东路18号”；例2：道路+门牌号+标志性建筑+楼层，“四川北路1552号欢乐广场1楼”。',
    `longitude`        VARCHAR(15)  NOT NULL  COMMENT '经度；最长15位字符（包括小数点）， 注：高德坐标系。',
    `latitude`         VARCHAR(15)  NOT NULL  COMMENT '纬度；最长15位字符（包括小数点）， 注：高德坐标系。',

    `partner_id`       VARCHAR(20) DEFAULT NULL COMMENT '门店的签约ID',
    `pay_type`         VARCHAR(128) DEFAULT NULL COMMENT '默认付款类型；如：付款码、扫码付、声波支付、在线买单、其它',
    `create_channel`   VARCHAR(128) DEFAULT NULL COMMENT '门店创建来源；如：开放平台、支付宝客户端、口碑商家app、商家自主开店、服务商开店、全民开店-支付宝客户端、全民开店-商户app、其它',

    `provider_xiaoer_uid`VARCHAR(512) NOT NULL  COMMENT '门店运营归属人uid',
    `contact_number`   VARCHAR(512) NOT NULL COMMENT '门店电话号码；支持座机和手机，只支持数字和+-号，在客户端对用户展现， 支持多个电话， 以英文逗号分隔',
    `notify_mobile`    VARCHAR(512) DEFAULT '' COMMENT '门店店长电话号码；用于接收门店状态变更通知，收款成功通知等通知消息， 不在客户端展示。',
    `main_image`       VARCHAR(512) NOT NULL COMMENT '门店首图，非常重要，推荐尺寸2000*1500。',
    `audit_images`     TEXT COMMENT '门店审核时需要的图片；至少包含一张门头照片，两张内景照片，必须反映真实的门店情况，审核才能够通过；多个图片之间以英文逗号分隔。',
    `online_image`     TEXT COMMENT '在其他平台的开店图片，支持多张，逗号分隔。',
    `other_auth_images`TEXT COMMENT '其它资质证明图片集；支持多张，逗号分隔。',

    `qr_code`          VARCHAR(512) DEFAULT '' COMMENT '门店收款二维码裸码。',
    `processed_qr_code`VARCHAR(512) DEFAULT '' COMMENT '经过加工后的门店收款二维码。',

    `business_time`    VARCHAR(256) DEFAULT '' COMMENT '营业时间，支持分段营业时间，以英文逗号分隔。',
    `wifi`             VARCHAR(16) DEFAULT 'T' COMMENT '门店是否支持WIFI，T表示支持，F表示不支持，不传在客户端不作展示。',
    `parking`          VARCHAR(16) DEFAULT 'F' COMMENT '门店是否支持停车，T表示支持，F表示不支持，不传在客户端不作展示。',
    `value_added`      VARCHAR(256)  DEFAULT '' COMMENT '门店其他的服务，门店与用户线下兑现。	免费茶水、免费糖果',
    `avg_price`        VARCHAR(16)   DEFAULT '' COMMENT '人均消费价格，最少1元，最大不超过99999元，请按实际情况填写；单位元，不需填写单位。',

    `isv_uid`          VARCHAR(16)  NOT NULL COMMENT 'ISV返佣id，门店创建、或者门店交易的返佣将通过此账号反给ISV，如果有口碑签订了返佣协议，则该字段作为返佣数据提取的依据。此字段必须是个合法uid，2088开头的16位支付宝会员账号，如果传入错误将无法创建门店。',
    `licence`          VARCHAR(512) DEFAULT NULL COMMENT '门店营业执照图片，各行业所需的证照资质参见商户入驻要求。',
    `licence_code`     VARCHAR(255) DEFAULT NULL COMMENT '门店营业执照编号，营业执照信息与is_operating_online至少填一项。',
    `licence_name`     VARCHAR(255) DEFAULT NULL COMMENT '门店营业执照名称。',
    `business_certificate` VARCHAR(512) DEFAULT NULL COMMENT '人许可证，各行业所需的证照资质参见商户入驻要求；该字段只能上传一张许可证，一张以外的许可证、除营业执照和许可证之外其他证照请放在其他资质字段上传。',

    `business_certificate_expires` VARCHAR(64) DEFAULT '1990-01-01' COMMENT '许可证有效期，格式：2020-03-20',
    `auth_letter`        VARCHAR(512) DEFAULT NULL COMMENT '门店授权函,营业执照与签约账号主体不一致时需要。',
    `online_url`         TEXT COMMENT '其他平台开店的店铺链接url，多个url使用英文逗号隔开,isv迁移到新接口使用此字段，与is_operating_online=T配套使用。',
    `operate_notify_url` VARCHAR(512) DEFAULT NULL COMMENT '当商户的门店审核状态发生变化时，会向该地址推送消息。',

    `implement_id`       VARCHAR(256) DEFAULT NULL COMMENT '机具号，多个之间以英文逗号分隔。',
    `request_id`         VARCHAR(64)  DEFAULT NULL COMMENT '支持英文字母和数字，由开发者自行定义（不允许重复），在门店notify消息中也会带有该参数，以此标明本次notify消息是对哪个请求的回应。',
    `other_authorization`VARCHAR(500) DEFAULT NULL COMMENT '其他资质。用于上传营业证照、许可证照外的其他资质，除已上传许可证外的其他许可证也可以在该字段上传。',

    `licence_expires` VARCHAR(64)   DEFAULT NULL COMMENT '营业执照过期时间。',
    `op_role`        VARCHAR(16)   DEFAULT NULL COMMENT '表示以系统集成商的身份开店，开放平台现在统一传入ISV 默认商户操作:MERCHANT；服务商操作：PROVIDER。支付宝内部使用，外部商户不需填写此字段',
    `biz_version`    VARCHAR(10)   DEFAULT NULL COMMENT '店铺接口业务版本号，新接入的ISV，请统一传入2.0',
    `apply_id`       VARCHAR(10)   DEFAULT NULL COMMENT '开店请求受理成功后返回的支付宝流水ID，根据此ID调用接口 alipay.offline.market.applyorder.batchquery，能够获取当前开店请求审核状态、驳回原因等信息。',

    `audit_status`   VARCHAR(16)   DEFAULT 'AUDITING' COMMENT '门店审核状态，对于系统商而言，只有三个状态，AUDITING：审核中，AUDIT_FAILED：审核驳回，AUDIT_SUCCESS：审核通过。第一次审核通过会触发门店上架',
    `audit_desc`     VARCHAR(255)  DEFAULT NULL COMMENT '门店审核状态描述，如果审核驳回则有相关的驳回理由',

    `no_smoking`     VARCHAR(16) DEFAULT 'T' COMMENT '是否有无烟区，T表示有无烟区，F表示没有无烟区，不传在客户端不展示。',
    `box`            VARCHAR(16) DEFAULT 'T' COMMENT '门店是否有包厢，T表示有，F表示没有，不传在客户端不作展示。',
    `is_operating_online` VARCHAR(16) DEFAULT 'F' COMMENT '是否在其他平台开店，T表示有开店，F表示未开店。',
    `is_online`      VARCHAR(16) DEFAULT 'F' COMMENT '门店是否上架，T表示上架,F表示未上架，第一次门店审核通过后会触发上架。',
    `is_show`        VARCHAR(16) DEFAULT 'F' COMMENT '门店是否在客户端显示，T表示显示，F表示隐藏。',

    `gmt_shop_create`  VARCHAR(32)  DEFAULT '2000-01-01 00:00:00' COMMENT '门店创建时间',
    `gmt_shop_modified`VARCHAR(32)  DEFAULT '2000-01-01 00:00:00' COMMENT '门店修改时间',
    `shop_tags`        TEXT COMMENT '门店标签；JSON格式。包括：keyMerchant-是否重点商户（T/F）；isHallMeal-堂食（T/F）；注：若标签 key 不存在，则门店无对应的标签',
    `status`        VARCHAR(16)  DEFAULT 'INIT' COMMENT '门店状态：OPEN（营业）、PAUSED（暂停）、INIT（初始）、FREEZE（冻结）、CLOSED（关店）',
    `created`       TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status` TINYINT(1)  NOT NULL DEFAULT 1,
    KEY `inx_shop_id` (`store_id`),
    KEY `inx_shop_category` (`store_id`,`category_id`),
    KEY `inx_shop_brand` (`store_id`,`brand_name`),
    KEY `inx_shop_category_brand` (`store_id`,`category_id`, `brand_name`),
    KEY `inx_shop_category_main_name` (`store_id`,`category_id`, `main_shop_name`),
    KEY `inx_shop_category_branch_name` (`store_id`,`category_id`, `branch_shop_name`),
    KEY `inx_shop_category_main_branch_name` (`store_id`,`main_shop_name`, `branch_shop_name`)
  ) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_shop_window
  -- 服务窗
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_shop_window`;
  CREATE TABLE `tb_shop_window` (

    `id`              BIGINT(30)   PRIMARY KEY COMMENT '主键',
    `store_id`        VARCHAR(32)  NOT NULL COMMENT '门店ID',
    `app_name`        VARCHAR(20) NOT NULL COMMENT '服务窗名称',
    `logo_url`        VARCHAR(128) NOT NULL COMMENT '服务窗头像地址',
    `public_greeting` VARCHAR(200) NOT NULL COMMENT '服务窗欢迎语',
    `license_url`     VARCHAR(128) NOT NULL COMMENT '营业执照地址，建议尺寸 320 x 320px，支持.jpg .jpeg .png 格式，小于3M',
    `shop_pic1`       VARCHAR(128) NOT NULL COMMENT '第一张门店照片地址，建议尺寸 320 x 320px，支持.jpg .jpeg .png 格式，小于3M',
    `shop_pic2`       VARCHAR(128) NOT NULL COMMENT '第二张门店照片地址',
    `shop_pic3`       VARCHAR(128) NOT NULL COMMENT '第三张门店照片地址',
    `auth_pic`        VARCHAR(128) NOT NULL COMMENT '授权运营书，企业商户若为被经营方授权，需上传加盖公章的扫描件，请使用照片上传接口上传图片获得image_url',
    `audit_status`    VARCHAR(16)  DEFAULT 'AUDITING' COMMENT '门店审核状态，对于系统商而言，只有三个状态，AUDITING：审核中，AUDIT_FAILED：审核驳回，AUDIT_SUCCESS：审核通过。第一次审核通过会触发门店上架',
    `audit_desc`      VARCHAR(255) DEFAULT NULL COMMENT '门店审核状态描述，如果审核驳回则有相关的驳回理由',
    `is_online`       VARCHAR(16)  DEFAULT 'F'  COMMENT '门店是否上架，T表示上架,F表示未上架，第一次门店审核通过后会触发上架。',
    `is_show`         VARCHAR(16)  DEFAULT 'F'  COMMENT '门店是否在客户端显示，T表示显示，F表示隐藏。',
    `platform`        VARCHAR(12)  DEFAULT 'kb' COMMENT '平台信息(kb口碑 tb淘宝 bd百度外卖)',
    `remark`          VARCHAR(256) DEFAULT ''   COMMENT '备注',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',

    KEY `inx_shop_store` (`store_id`),
    KEY `inx_shop_name` (`app_name`),
    KEY `inx_shop_store_name` (`store_id`, `app_name`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_shop_image
  -- 店铺图片信息
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_shop_image`;
  CREATE TABLE `tb_shop_image` (

    `id`              BIGINT(30)   PRIMARY KEY COMMENT '主键',
    `store_id`        VARCHAR(32)  NOT NULL COMMENT '门店ID',
    `image_type`      VARCHAR(8)   NOT NULL DEFAULT 'jpg' COMMENT '图片格式',
    `image_name`      VARCHAR(128) NOT NULL COMMENT '图片名称',
    `image_url`       VARCHAR(128) NOT NULL COMMENT '图片URL',
    `image_content`   TEXT NOT NULL COMMENT '图片二进制内容byte[]',
    `image_pid`       VARCHAR(16)  DEFAULT 0 COMMENT '用于显示指定图片所属的partnerId（支付宝内部使用，外部商户无需填写此字段）',
    `status`          TINYINT(2)   DEFAULT 0 COMMENT '当前状态(0 未确认 1 商家确认 2 小二确认  -1 屏蔽  -2 删除)',
    `platform`        VARCHAR(12)  DEFAULT 'kb' COMMENT '平台信息(kb口碑 tb淘宝 bd百度外卖)',
    `remark`          VARCHAR(256) DEFAULT '' COMMENT '备注',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',

    KEY `inx_shop_store` (`store_id`),
    KEY `inx_shop_type` (`image_type`),
    KEY `inx_shop_name` (`image_name`),
    KEY `inx_shop_store_name` (`store_id`, `image_name`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_shop_menu
  -- 店铺菜单
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_shop_menu`;
  CREATE TABLE `tb_shop_menu` (

    `id`              BIGINT(30)   PRIMARY KEY COMMENT '主键',
    `store_id`        VARCHAR(32)  NOT NULL COMMENT '门店ID',
    `menu`            VARCHAR(8)   NOT NULL COMMENT '菜单信息',
    `status`          TINYINT(2)   DEFAULT 0 COMMENT '当前状态(0 未确认 1 商家确认 2 小二确认  -1 屏蔽  -2 删除)',
    `platform`        VARCHAR(12)  DEFAULT 'kb' COMMENT '平台信息(kb口碑 tb淘宝 bd百度外卖)',
    `remark`          VARCHAR(256) DEFAULT '' COMMENT '备注',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',

    KEY `inx_shop_store` (`store_id`),
    KEY `inx_shop_name` (`store_id`, `menu`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_shop_category
  -- 商品类目
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_shop_category`;
  CREATE TABLE `tb_shop_category` (

    `id`              BIGINT(30)   PRIMARY KEY  COMMENT '主键',
    `category_id`     BIGINT(30)   NOT NULL     COMMENT '类目编号',
    `category_name`   VARCHAR(64)  DEFAULT ''   COMMENT '类目名称',
    `category_level`  BIGINT(30)   NOT NULL     COMMENT '类目层级,目前最多支持1、2、3三级',
    `category_parent` TINYINT(2)   DEFAULT 0    COMMENT '该类目是否为父类目(即：该类目是否还有子类目)',
    `status`          TINYINT(2)   DEFAULT 0    COMMENT '当前状态(0 未确认 1 商家确认 2 小二确认  -1 屏蔽  -2 删除)',
    `platform`        VARCHAR(12)  DEFAULT 'kb' COMMENT '平台信息(kb口碑 tb淘宝 bd百度外卖)',
    `remark`          VARCHAR(256) DEFAULT ''   COMMENT '备注',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',

    KEY `inx_shop_category` (`category_id`),
    KEY `inx_shop_category_name` (`category_name`),
    KEY `inx_shop_platform` (`platform`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_goods_item
  -- 店铺商品信息
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_goods_item`;
  CREATE TABLE `tb_goods_item` (

    `id`                  BIGINT(30)   PRIMARY KEY COMMENT '主键',
    `store_id`            VARCHAR(32)  NOT NULL COMMENT '门店ID',
    `itme_id`             VARCHAR(64)  NOT NULL COMMENT '商品ID(口碑)',
    `item_sys_id`         VARCHAR(64)  NOT NULL COMMENT '商品ID(系统)',
    `item_type`           VARCHAR(20)  NOT NULL COMMENT '商品类型，券类型填写固定值VOUCHER',
    `subject`             VARCHAR(40)  NOT NULL COMMENT '商品名称，请勿超过15个汉字，30个字符',
    `purchase_mode`       VARCHAR(20)  NOT NULL COMMENT '商品购买类型 OBTAIN为领取，AUTO_OBTAIN为自动领取',
    `inventory`           BIGINT(20)  DEFAULT 0 COMMENT '商品库存数量',
    `cover`               VARCHAR(100) NOT NULL COMMENT '商品首图，尺寸比例在65:53范围内且图片大小不超过10k皆可，图片推荐尺寸540*420',
    `weight`              BIGINT(20)  DEFAULT 1 COMMENT '商品顺序权重，必须是整数，不传默认为0，权重数值越大排序越靠前',
    `shop_list`           TEXT                    COMMENT '上架门店id列表，即传入一个或多个shop_id，必须是创建商品partnerId下的店铺，目前支持的店铺最大100个，如果超过100个店铺需要报备',
    `gmt_start`           TIMESTAMP    NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '商品生效时间，到达生效时间后才可在客户端展示出来。 说明： 商品的生效时间不能早于创建当天的0点',
    `gmt_end`             TIMESTAMP    NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '商品下架时间，不得早于商品生效时间，商品下架',
    `is_auto_expanded`    TINYINT(2)  NOT NULL  COMMENT '0否 1是 是否自动延期，默认false。 如果需要设置自动延期，则gmt_start和gmt_end之间要间隔2天以上',
    `operate_notify_url`  VARCHAR(512) NOT NULL COMMENT '商户通知地址，口碑发消息给商户通知其是否对商品创建、修改、变更状态成功',
    `status`          TINYINT(2)   DEFAULT 0 COMMENT '当前状态(0 未确认 1 商家确认 2 小二确认  -1 屏蔽  -2 删除)',
    `platform`        VARCHAR(12)  DEFAULT 'kb' COMMENT '平台信息(kb口碑 tb淘宝 bd百度外卖)',
    `remark`          VARCHAR(256) DEFAULT '' COMMENT '备注',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',

    KEY `inx_shop_store` (`store_id`),
    KEY `inx_shop_store_item` (`store_id`,`itme_id`),
    KEY `inx_shop_store_item_sys` (`store_id`,`item_sys_id`),
    KEY `inx_shop_store_subject` (`store_id`, `subject`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_good_item_desc
  -- 店铺商品描述（代金券）
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_good_item_desc`;
  CREATE TABLE `tb_good_item_desc` (

    `id`              BIGINT(30)   PRIMARY KEY COMMENT '主键',
    `store_id`        VARCHAR(32)  NOT NULL COMMENT '门店ID',
    `itme_id`         VARCHAR(64)  NOT NULL COMMENT '商品ID(口碑)',
    `item_sys_id`     VARCHAR(64)  NOT NULL COMMENT '商品ID(系统)',
    `title`           VARCHAR(30)  NOT NULL COMMENT '描述标题，不得超过15个中文字符(洗剪吹套餐)',
    `details`         VARCHAR(500)  NOT NULL COMMENT '标题下的描述列表,券使用说明内容',
    `images`          VARCHAR(200)  NOT NULL COMMENT '明细图片列表，要求图片张数小于或等于3。请勿上传过大图片，图片将会自适应至尺寸比例88:75',
    `url`             VARCHAR(255)  NOT NULL COMMENT '套餐使用说明链接，必须是https的地址链接',
    `status`          TINYINT(2)   DEFAULT 0 COMMENT '当前状态(0 未确认 1 商家确认 2 小二确认  -1 屏蔽  -2 删除)',
    `platform`        VARCHAR(12)  DEFAULT 'kb' COMMENT '平台信息(kb口碑 tb淘宝 bd百度外卖)',
    `remark`          VARCHAR(256) DEFAULT '' COMMENT '备注',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',

    KEY `inx_shop_store` (`store_id`),
    KEY `inx_shop_store_item` (`store_id`,`itme_id`),
    KEY `inx_shop_store_item_sys` (`store_id`,`item_sys_id`),
    KEY `inx_shop_store_title` (`store_id`, `title`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_goods_sale_rule
  -- 店铺商品销售规则
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_goods_sale_rule`;
  CREATE TABLE `tb_goods_sale_rule` (

    `id`                BIGINT(30)   PRIMARY KEY COMMENT '主键',
    `store_id`          VARCHAR(32)  NOT NULL COMMENT '门店ID',
    `itme_id`           VARCHAR(64)  NOT NULL COMMENT '商品ID(口碑)',
    `item_sys_id`       VARCHAR(64)  NOT NULL COMMENT '商品ID(系统)',
    `daily_sales_limit` BIGINT(10)   NOT NULL COMMENT '可限制商品单日销售上限',
    `user_sales_limit`  VARCHAR(50)  NOT NULL COMMENT '用户购买策略如不填，则默认值为一个用户一天可以领取三次。 可限制DAY、WEEK、MONTH中n天领取m次，格式为DAY|n|m； 同时也可限制券的1次生命周期中可被领取x次，如ALL|1|x，两个规则可组合使用',
    `buyer_crowd_limit` VARCHAR(20)  NOT NULL COMMENT '购买人群限制集合，开放平台暂时不支持此字段，如果需要使用，需要评估',
    `status`          TINYINT(2)   DEFAULT 0 COMMENT '当前状态(0 未确认 1 商家确认 2 小二确认  -1 屏蔽  -2 删除)',
    `platform`        VARCHAR(12)  DEFAULT 'kb' COMMENT '平台信息(kb口碑 tb淘宝 bd百度外卖)',
    `remark`          VARCHAR(256) DEFAULT '' COMMENT '备注',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',

    KEY `inx_shop_store` (`store_id`),
    KEY `inx_shop_store_item` (`store_id`,`itme_id`),
    KEY `inx_shop_store_item_sys` (`store_id`,`item_sys_id`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_goods_voucher
  -- 店铺商品券模板信息
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_goods_voucher`;
  CREATE TABLE `tb_goods_voucher` (

    `id`                 BIGINT(30)   PRIMARY KEY COMMENT '主键',
    `store_id`           VARCHAR(32)  NOT NULL COMMENT '门店ID',
    `voucher_type`       VARCHAR(20)  NOT NULL COMMENT '券类型，DISCOUNT（折扣券）、CASH（代金券）',
    `value_amount`       DOUBLE(20,2)  COMMENT '价值金额，单位（元） CASH类型为代金券金额 DISCOUNT类型为优惠封顶金额 在代金券类型时，value_amout与reduce_to_amount不能同时为空，不能同时不为空。',
    `threshold_quantity` BIGINT(20)    COMMENT '起步数量，用于指定可享受优惠的起步单品购买数量',
    `threshold_amount`   DOUBLE(20,2)  COMMENT '起步金额，单位（元）',
    `reduce_to_amount`   DOUBLE(20,2)  COMMENT '减至金额，单位（元），代表券可抵扣至多少（代金券类型可选字段，折扣券不需要）',
    `original_amount`    DOUBLE(20,2)  COMMENT '商品原金额，单位（元），（代金券类型可选字段，折扣券不需要）',
    `original_rate`      DOUBLE(20,2)  COMMENT '券原折扣,0-1之间，做展示使用（折扣券类型可选字段，代金券不需要）',
    `discount_rate`      DOUBLE(20,2)  COMMENT '折扣率，填写0-1间的小数且不包括0和1，如八折则传入0.8。（折扣券类型必选字段，代金券不需要）',
    `valid_period`       BIGINT(20)   COMMENT '领券之后多长时间内可以核销，单位：分钟，传入数值需大于1440（一天）',
    `voucher_desc`       VARCHAR(40)  COMMENT '券的描述信息，目前客户端将统一展示“折扣须知”',
    `delay_minute`       VARCHAR(40)  COMMENT '延迟生效时间（手动领取条件下，可跟valid_period组合使用）',
    `rounding_rule`      VARCHAR(40)  COMMENT '折扣金额取整规则 AUTO_ROUNDING_YUAN：自动抹零到元 AUTO_ROUNDING_JIAO：自动抹零到角 ROUNDING_UP_YUAN：四舍五入到元 ROUNDING_UP_JIAO：四舍五入到角',
    `status`          TINYINT(2)   DEFAULT 0 COMMENT '当前状态(0 未确认 1 商家确认 2 小二确认  -1 屏蔽  -2 删除)',
    `platform`        VARCHAR(12)  DEFAULT 'kb' COMMENT '平台信息(kb口碑 tb淘宝 bd百度外卖)',
    `remark`          VARCHAR(256) DEFAULT '' COMMENT '备注',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',

    KEY `inx_shop_voucher` (`store_id`),
    KEY `inx_shop_voucher_type` (`store_id`,`voucher_type`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_goods_voucher_period
  -- 店铺商品券模板使用时间
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_goods_voucher_period`;
  CREATE TABLE `tb_goods_voucher_period` (

    `id`              BIGINT(30)   PRIMARY KEY COMMENT '主键',
    `store_id`        VARCHAR(32)  NOT NULL COMMENT '门店ID',
    `voucher_id`      VARCHAR(32)  NOT NULL COMMENT '门店ID',
    `voucher_type`    VARCHAR(20)  NOT NULL COMMENT '券类型，DISCOUNT（折扣券）、CASH（代金券）',
    `unit`            VARCHAR(20)  NOT NULL COMMENT '单位描述，分为： MINUTE（分钟） HOUR（小时） WEEK_DAY（星期几） DAY（日） WEEK（周） MONTH（月） ALL（整个销售周期）',
    `rule`            VARCHAR(20)  NOT NULL COMMENT '区间范围枚举，分为： INCLUDE（包含） EXCLUDE（排除）',
    `value`           VARCHAR(10)  NOT NULL COMMENT '区间范围值，参数类型为Number',
    `status`          TINYINT(2)   DEFAULT 0 COMMENT '当前状态(0 未确认 1 商家确认 2 小二确认  -1 屏蔽  -2 删除)',
    `platform`        VARCHAR(12)  DEFAULT 'kb' COMMENT '平台信息(kb口碑 tb淘宝 bd百度外卖)',
    `remark`          VARCHAR(256) DEFAULT '' COMMENT '备注',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',

    KEY `inx_shop_voucher` (`store_id`),
    KEY `inx_shop_voucher_type` (`store_id`,`voucher_type`),
    KEY `inx_shop_voucher_id` (`store_id`,`voucher_id`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_shop_order
  -- 发放集分宝
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_shop_order`;
  CREATE TABLE `tb_shop_order` (

    `id`              BIGINT(30)   PRIMARY KEY COMMENT '主键',
    `store_id`        VARCHAR(32)   NOT NULL COMMENT '门店ID',
    `user_symbol`     VARCHAR(64)   NOT NULL COMMENT '用户标识符，用于指定集分宝发放的用户，和user_symbol_type一起使用，确定一个唯一的支付宝用户',
    `user_symbol_type`TINYINT(64)   DEFAULT 0 COMMENT '用户标识符类型， 现在支持ALIPAY_USER_ID:表示支付宝用户ID, ALIPAY_LOGON_ID:表示支付宝登陆号, TAOBAO_NICK:淘宝昵称',
    `point_count`     VARCHAR(64)   DEFAULT 'kb' COMMENT '发放集分宝的数量',
    `merchant_order_no` VARCHAR(32) DEFAULT '' COMMENT 'isv提供的发放订单号，由数字和字母组成，最大长度为32位，需要保证每笔订单发放的唯一性，支付宝对该参数做唯一性校验。如果订单号已存在，支付宝将返回订单号已经存在的错误',
    `memo`            VARCHAR(128)  DEFAULT '' COMMENT '向用户展示集分宝发放备注',
    `order_time`       TIMESTAMP    NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '发放集分宝时间',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',

    KEY `inx_shop_store` (`store_id`),
    KEY `inx_shop_user_symbol` (`store_id`, `user_symbol`, `user_symbol_type`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_trade_info
  -- 统一收单交易
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_trade_info`;
  CREATE TABLE `tb_trade_info` (

    `id`                   BIGINT(30)   PRIMARY KEY COMMENT '主键',
    `store_id`             VARCHAR(32)  NOT NULL COMMENT '门店ID',
    `out_trade_no`         VARCHAR(64)  NOT NULL COMMENT '商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复',
    `seller_id`            VARCHAR(28)  NOT NULL COMMENT '卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID',
    `total_amount`         DOUBLE(12,2) DEFAULT 0 COMMENT '订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]',
    `discountable_amount`  DOUBLE(12,2) DEFAULT 0  COMMENT '可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位',
    `undiscountable_amount`DOUBLE(12,2) DEFAULT 0  COMMENT '可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位',
    `buyer_logon_id`       VARCHAR(100) DEFAULT '' COMMENT '买家支付宝账号，和buyer_id不能同时为空',
    `subject`              VARCHAR(256) DEFAULT '' COMMENT '订单标题',
    `body`                 VARCHAR(128) DEFAULT '' COMMENT '对交易或商品的描述',
    `buyer_id`             VARCHAR(28) DEFAULT '' COMMENT '买家的支付宝唯一用户号（2088开头的16位纯数字）,和buyer_logon_id不能同时为空',
    `operator_id`          VARCHAR(28) DEFAULT '' COMMENT '商户操作员编号',
    `terminal_id`          VARCHAR(32) DEFAULT '' COMMENT '商户机具终端编号',
    `timeout_express`      VARCHAR(32) DEFAULT '' COMMENT '该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。',
    `alipay_store_id`      VARCHAR(32) DEFAULT '' COMMENT '支付宝的店铺编号',
    `merchant_id`          VARCHAR(32) DEFAULT '' COMMENT '二级商户的支付宝id ',
    `sys_service_provider_id` VARCHAR(64) DEFAULT '' COMMENT '系统商编号 该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID',
    `hb_fq_num`            VARCHAR(5) DEFAULT '' COMMENT '使用花呗分期要进行的分期数',
    `hb_fq_seller_percent` VARCHAR(3) DEFAULT '' COMMENT '使用花呗分期需要卖家承担的手续费比例的百分值，传入100代表100%',
    `royalty_type`         VARCHAR(150) DEFAULT 'ROYALTY' COMMENT '分账类型 卖家的分账类型，目前只支持传入ROYALTY（普通分账类型）。',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',
    KEY `inx_shop_store` (`store_id`),
    KEY `inx_shop_store_trade_no` (`store_id`, `out_trade_no`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_trade_detail
  -- 统一收单交易商品信息
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_trade_detail`;
  CREATE TABLE `tb_trade_detail` (

    `id`             BIGINT(30)   PRIMARY KEY COMMENT '主键',
    `store_id`       VARCHAR(32)  NOT NULL COMMENT '门店ID',
    `out_trade_no`   VARCHAR(64)  NOT NULL COMMENT '商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复',
    `goods_id`       VARCHAR(32)  NOT NULL COMMENT '卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID',
    `alipay_goods_id`VARCHAR(32)  NOT NULL COMMENT '订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]',
    `goods_name`     VARCHAR(256) NOT NULL COMMENT '可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位',
    `quantity`       BIGINT(10)   DEFAULT 0 COMMENT '可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位',
    `price`          DOUBLE(12,2) DEFAULT 0 COMMENT '买家支付宝账号，和buyer_id不能同时为空',
    `goods_category` VARCHAR(24)  DEFAULT '' COMMENT '订单标题',
    `body`           VARCHAR(1000)DEFAULT '' COMMENT '对交易或商品的描述',
    `show_url`       VARCHAR(400) DEFAULT '' COMMENT '买家的支付宝唯一用户号（2088开头的16位纯数字）,和buyer_logon_id不能同时为空',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',
    KEY `inx_shop_store` (`store_id`),
    KEY `inx_shop_store_trade_no` (`store_id`, `out_trade_no`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_trade_royalty
  -- 交易分账明细
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_trade_royalty`;
  CREATE TABLE `tb_trade_royalty` (

    `id`             BIGINT(30)   PRIMARY KEY COMMENT '主键',
    `store_id`       VARCHAR(32)  NOT NULL COMMENT '门店ID',
    `out_trade_no`   VARCHAR(64)  NOT NULL COMMENT '商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复',
    `serial_no`      VARCHAR(32)  NOT NULL COMMENT '分账序列号，表示分账执行的顺序，必须为正整数 ',
    `batch_no`       VARCHAR(32)  NOT NULL COMMENT '分账批次号。 目前需要和转入账号类型为bankIndex配合使用。',
    `trans_in_type`  VARCHAR(32)  DEFAULT 'userId' COMMENT '接受分账金额的账户类型', -- userId：支付宝账号对应的支付宝唯一用户号。  bankIndex：分账到银行账户的银行编号。目前暂时只支持分账到一个银行编号。 storeId：分账到门店对应的银行卡编号。 默认值为userId。',
    `out_relation_id`VARCHAR(64)  NOT NULL COMMENT  '商户分账的外部关联号，用于关联到每一笔分账信息，商户需保证其唯一性。 如果为空，该值则默认为“商户网站唯一订单号+分账序列号”',
    `trans_out_type` VARCHAR(24)  NOT NULL COMMENT '要分账的账户类型。 目前只支持userId：支付宝账号对应的支付宝唯一用户号。 默认值为userId。 ',
    `trans_out`      VARCHAR(16)  NOT NULL COMMENT '如果转出账号类型为userId，本参数为要分账的支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。 ',
    `trans_in`       VARCHAR(28)  NOT NULL COMMENT '如果转入账号类型为userId，本参数为接受分账金额的支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。  如果转入账号类型为bankIndex，本参数为28位的银行编号（商户和支付宝签约时确定）。 如果转入账号类型为storeId，本参数为商户的门店ID。 ',
    `amount`         DOUBLE(12,2) DEFAULT 0 COMMENT '分账的金额，单位为元 ',
    `desc`           VARCHAR(1000)DEFAULT '' COMMENT '分账描述信息 ',
    `amount_percentage`VARCHAR(3) DEFAULT '' COMMENT '分账的比例，值为20代表按20%的比例分账 ',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',
    KEY `inx_shop_store` (`store_id`),
    KEY `inx_shop_store_trade_no` (`store_id`, `out_trade_no`)
  ) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = UTF8;

  -- ----------------------------
  -- Table structure for tb_alipay_token
  -- 口碑网授权信息
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_alipay_token`;
  CREATE TABLE `tb_alipay_token` (

    `id`               BIGINT(30)  PRIMARY KEY COMMENT '主键',
    `user_id`          VARCHAR(16) NOT NUll COMMENT '授权商户的user_id ',
    `auth_app_id`      VARCHAR(20) NOT NUll COMMENT '授权商户的appid ',
    `app_auth_token`   VARCHAR(40) NOT NUll COMMENT '应用授权令牌',
    `app_refresh_token`VARCHAR(40) NOT NUll COMMENT '刷新令牌',
    `expires_in`       VARCHAR(16) NOT NUll COMMENT '应用授权令牌的有效时间（从接口调用时间作为起始时间），单位到秒',
    `re_expires_in`    VARCHAR(16) NOT NUll COMMENT '刷新令牌的有效时间（从接口调用时间作为起始时间），单位到秒',
    `created`          TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`         TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`    TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',
    KEY `inx_app_user` (`user_id`, `auth_app_id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  -- ----------------------------
  -- Table structure for tb_alipay_user
  -- 口碑网用户信息
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_alipay_user`;
  CREATE TABLE `tb_alipay_user` (

    `id`                  BIGINT(30)  PRIMARY KEY COMMENT '主键',
    `user_id`             VARCHAR(16) NOT NUll COMMENT '授权商户的user_id ',
    `avatar`              VARCHAR(200)NOT NUll COMMENT '用户头像',
    `user_type_value`     VARCHAR(2)  NOT NUll COMMENT '用户类型（1/2） 1代表公司账户2代表个人账户 ',
    `user_status`         VARCHAR(2)  NOT NUll COMMENT '用户状态（Q/T/B/W）。 Q代表快速注册用户 T代表已认证用户 B代表被冻结账户 W代表已注册，未激活的账户 ',
    `firm_name`           VARCHAR(100)NOT NUll COMMENT '公司名称（用户类型是公司类型时公司名称才有此字段）。 ',
    `real_name`           VARCHAR(200)NOT NUll COMMENT '用户的真实姓名',

    `email`               VARCHAR(200)NOT NUll COMMENT '用户支付宝账号绑定的邮箱地址',
    `cert_no`             VARCHAR(50) NOT NUll COMMENT '证件号码',
    `gender`              VARCHAR(2)  NOT NUll COMMENT '性别（F：女性；M：男性）',
    `phone`               VARCHAR(50) NOT NUll COMMENT '电话号码',
    `mobile`              VARCHAR(50) NOT NUll COMMENT '手机号码',

    `is_certified`        VARCHAR(2) NOT NUll COMMENT '是否通过实名认证。T是通过 F是没有实名认证',
    `is_bank_auth`        VARCHAR(2) NOT NUll COMMENT 'T为是银行卡认证，F为非银行卡认证。',
    `is_id_auth`          VARCHAR(2) NOT NUll COMMENT 'T为是身份证认证，F为非身份证认证。',
    `is_mobile_auth`      VARCHAR(2) NOT NUll COMMENT 'T为是手机认证，F为非手机认证。 ',
    `is_licence_auth`     VARCHAR(2) NOT NUll COMMENT 'T为通过营业执照认证，F为没有通过',

    `cert_type_value`     VARCHAR(5) NOT NUll COMMENT '0:身份证 1:护照 2:军官证 3:士兵证 4:回乡证 5:临时身份证 6:户口簿 7:警官证 8:台胞证 9:营业执照 10其它证件 ',
    `deliver_phone`       VARCHAR(50) NOT NUll COMMENT '收货地址的联系人固定电话0517-28888888',
    `deliver_mobile`      VARCHAR(50) NOT NUll COMMENT '收货地址的联系人移动电话131XXXXXXXX',
    `deliver_fullname`    VARCHAR(200) NOT NUll COMMENT '收货人全名 ',
    `default_deliver_address` VARCHAR(200) NOT NUll COMMENT '是否默认收货地址',
    `province`            VARCHAR(20) NOT NUll COMMENT '省份名称',
    `city`                VARCHAR(20) NOT NUll COMMENT '市名称',
    `area`                VARCHAR(20) NOT NUll COMMENT '区县名称',
    `address`             VARCHAR(200)NOT NUll COMMENT '地址',
    `zip`                 VARCHAR(50) NOT NUll COMMENT '邮政编码',
    `deliver_province`    VARCHAR(20) NOT NUll COMMENT '收货人所在省份',
    `deliver_city`        VARCHAR(20) NOT NUll COMMENT '收货人所在城市',
    `deliver_area`        VARCHAR(20) NOT NUll COMMENT '收货人所在区县',
    `address_code`        VARCHAR(16) NOT NUll COMMENT '区域编码',

    `is_student_certified` VARCHAR(2) DEFAULT 'T' COMMENT '是否是学生 T为是手机认证，F为非手机认证。 ',
    `is_certify_grade_a`  VARCHAR(2)  DEFAULT 'F' COMMENT 'T：表示A类实名认证；F：表示非A类实名认证 ',
    `alipay_user_id`      VARCHAR(20) NOT NUll COMMENT '支付宝用户ID ',
    `birthday`            VARCHAR(8)  NOT NUll COMMENT '用户生日(19900918)',
    `nick_name`           VARCHAR(200) NOT NUll COMMENT '用户昵称',
    `family_name`         VARCHAR(50) NOT NUll COMMENT '姓氏，取的是realName中的首个字符，对非中文、中文复姓支持较差。',

    `reduced_birthday`    VARCHAR(20) NOT NUll COMMENT '生日的月和日，MMdd格式',
    `is_balance_frozen`   VARCHAR(2)  DEFAULT 'F' COMMENT 'T--被冻结；F--未冻结',
    `balance_freeze_type` VARCHAR(50) NOT NUll COMMENT '注意】当is_balance_frozen为“F”时，改字段不会返回. ', -- CTU ---- CTU冻结，允许用户开启 ALIBABA ---- ALIBABA冻结，允许用户开启 SERVER ---- 后台冻结，允许用户开启 USER ---- 用户冻结 CTU_N---- CTU冻结，不允许用户开启 ALIBABA_N ---- ALIBABA冻结，不允许用户开启 SERVER_N ---- 后台冻结，不允许用户开启 UNKNOWN ---- 降级、或查询超时 ',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',

    KEY `inx_app_user` (`user_id`),
    KEY `inx_app_user_name` (`real_name`),
    KEY `inx_app_user_cert_no` (`cert_no`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  -- ----------------------------
  -- Table structure for tb_alipay_user_deliver
  -- 口碑网用户收货地址信息
  -- ----------------------------
  DROP TABLE IF EXISTS `tb_alipay_user_deliver`;
  CREATE TABLE `tb_alipay_user_deliver` (

    `id`              BIGINT(30)  PRIMARY KEY COMMENT '主键',
    `user_id`         VARCHAR(16) NOT NUll COMMENT '授权商户的user_id ',
    `deliver_fullname`VARCHAR(200) NOT NUll COMMENT '收货人全名 ',
    `default_deliver_address` VARCHAR(200) NOT NUll COMMENT '是否默认收货地址',
    `deliver_phone`   VARCHAR(50) NOT NUll COMMENT '收货地址的联系人固定电话0517-28888888',
    `deliver_mobile`  VARCHAR(50) NOT NUll COMMENT '收货地址的联系人移动电话131XXXXXXXX',
    `address`         VARCHAR(200) NOT NUll COMMENT '地址',
    `zip`             VARCHAR(50) NOT NUll COMMENT '邮政编码',
    `deliver_province`VARCHAR(20) NOT NUll COMMENT '收货人所在省份',
    `deliver_city`    VARCHAR(20) NOT NUll COMMENT '收货人所在城市',
    `deliver_area`    VARCHAR(20) NOT NUll COMMENT '收货人所在区县',
    `address_code`    VARCHAR(16) NOT NUll COMMENT '区域编码',
    `created`         TIMESTAMP   NOT NULL DEFAULT '2000-01-01 00:00:00',
    `modified`        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `enable_status`   TINYINT(1)  NOT NULL DEFAULT 1 COMMENT '0否 1是',

    KEY `inx_user_id` (`user_id`),
    KEY `inx_user_full_name` (`user_id`, `deliver_fullname`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;