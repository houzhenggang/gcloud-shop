package com.gcloud.shop.domain.user;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: DBSplitInfo
 * @Package com.gcloud.domain.user
 * @Description: 数据库分库分表信息
 * @date 2016/6/1 13:53
 */
public class DBSplitInfo {

    /**
     * 订单数据库实例数量
     */
    public static final Integer COUNT_TRADE_INSTANCE_NUM = 2;

    /**
     * 子订单数据库实例数量
     */
    public static final Integer COUNT_ORDER_INSTANCE_NUM = 2;


    /**
     * Item数据库实例数量
     */
    public static final Integer COUNT_ITEM_INSTANCE_NUM = 50;

    /**
     * Sku数据库实例数量
     */
    public static final Integer COUNT_SKU_INSTANCE_NUM = 100;

    /**
     * 订单表的数量
     */
    public static final Integer COUNT_TRADE_DB_NUM = 100;

    /**
     * 电子面单号表的数量
     */
    public static final Integer COUNT_WLB_NUMBER_DB_NUM = 50;

    /**
     * 子订单表的数量
     */
    public static final Integer COUNT_ORDER_DB_NUM = 200;

    /**
     * 用户电子面单模板表的数量
     */
    public static final Integer COUNT_USER_WLB_EXPRESS_TEMPLATE_NUM = 2;

    /**
     * 用户拿货单模板表的数量
     */
    public static final Integer COUNT_USER_ASSEMBLY_TEMPLATE_NUM = 2;

    /**
     * 用户发货单模板表的数量
     */
    public static final Integer COUNT_USER_DELIVER_TEMPLATE_NUM = 2;

    /**
     * 用户拣货单模版表的数量
     */
    public static final Integer COUNT_USER_PICKER_TEMPLATE_NUM = 2;

    /**
     * 用户拿货单模版表的数量
     */
    public static final Integer COUNT_USER_GETTER_TEMPLATE_NUM = 2;

    /**
     * 用户快递模板表的数量
     */
    public static final Integer COUNT_USER_EXPRESS_TEMPLATE_NUM = 2;

    /**
     * 打印订单日志分表的数量
     */
    public static final Integer COUNT_PRINT_ORDER_LOG_NUM = 20;

    /**
     * 打印订单日志分表的数量
     */
    public static final Integer COUNT_PRINT_ORDER_LOG_DETAIL_NUM = 20;

    /**
     * 打印订单统计日志分表的数量
     */
    public static final Integer COUNT_PRINT_ORDER_SHIP_COUNT_NUM = 5;

    /**
     * 自定义打印分表
     */
    public static final Integer COUNT_USER_CUSTOM_PRINT_NUM = 5;

    /**
     * 文件上传分表
     */
    public static final Integer FILE_UPLOAD_LOG_COUNT_NUM = 5;

    /**
     * 订单跟踪的分表数量
     */
    public static final Integer COUNT_TRADE_TRACE_NUM = 100;

    /**
     * 电子面单号记录的分表数量
     */
    public static final Integer COUNT_OUT_SID_POOL_NUM = 30;

    /**
     * 电子面单号回收的分表数量
     */
    public static final Integer COUNT_OUT_SID_RECOVER_NUM = 2;

    /**
     * 电子面单的网点与订单的对应关系表数量
     */
    public static final Integer COUNT_WLB_ADDRESS_TRADE_LINK_NUM = 30;

    /**
     * 短信交易的分表数量
     */
    public static final Integer COUNT_SMS_TXN_NUM = 6;


    /**
     * 短信通知日志的分表数量
     */
    public static final Integer COUNT_NOTIFICATION_LOG_NUM = 6;

    /**
     * 操作日志的分表数量
     */
    public static final Integer COUNT_ACTION_LOG_NUM = 10;

    /**
     * 短信的创建订单的分表号
     */
    public static final Integer COUNT_SMS_CREATED_TRADE_NUM = 5;

    /**
     * 快递智能匹配的分表号
     */
    public static final Integer COUNT_EXPRESS_SMARTMATCH_NUM = 2;

    /**
     * 商品库存的分表数量
     */
    public static final Integer COUNT_ITEM_STOCK_NUM = 5;

    /**
     * 商品出入库统计的日志表数量
     */
    public static final Integer COUNT_ITEM_STOCK_LOG_NUM = 5;

    /**
     * 交易临时表
     */
    public static final int TABLE_TEMP_NUM = 10;

}
