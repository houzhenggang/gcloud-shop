package com.gcloud.shop.domain;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ConfigConst
 * @Package com.gcloud.domain
 * @Description: 配置常亮名称
 * @date 2016/6/1 13:53
 */
public class ConfigConst {

    /**
     * 是否打开API导入的Key
     */
    public static final String OPEN_API_IMPORT = "open_api_import";

    /**
     * 是否打开订单同步检验参数
     */
    public static final String OPEN_CHECK_TRADE_IMPORT = "open_check_trade_import";

    /**
     * 当使用API获取订单时，先判断一下订单总数量，如果总数量大于属性这个值，那么直接获取待发货的订单，如果小于，那么获取所有订单
     */
    public static final String QUERY_PAY_WITH_API_INVOKING = "query_pay_with_api_invoking";

    /**
     * 测试用的卖家白名单，这些卖家都是来自超级店长
     */
    public static final String TEST_SELLER_WHITE_LIST = "test_seller_white_list";

    /**
     * 沙箱环境的用户的taobao_id这个和TEST_SELLER_WHITE_LIST不一样，TEST_SELLER_WHITE_LIST只能同步店长的里的用户订单，但不能做任何有关订单的
     * 操作，但是沙箱环境中的用户可以
     */
    public static final String SANDBOX_SELLER_WHITE_LIST = "sandbox_seller_white_list";

    /**
     *
     */
    public static final String DELAY_SEND_IMPORT_COMPLETE = "delay_send_trade_import_complete";

    /**
     * 同步用户到期时间的间隔
     */
    public static final String SYNC_DEADLINE_INTERVAL = "sync_deadline_interval";

    /**
     * 首页公告栏 通知
     */
    public static final String INDEX_NOTICE = "index_notice";

    /**
     * 产品更新进度信息
     */
    public static final String PROD_PROGRESS_INFO = "prod_progress_info";

    /**
     * 查询短信服务的回执状态
     */
    public static final String QUERY_SMS_RECEIPT_COUNT = "query_sms_receipt_count";

    /**
     * 查询短信服务的回执状态的间隔
     */
    public static final String QUERY_SMS_RECEIPT_INTERVAL = "query_sms_receipt_interval";

    /**
     * 短信账户的功能账户编号
     */
    public static final String SMS_ACCOUNT_ID = "sms_account_id";

    /**
     * 短信发送的功能类型
     */
    public static final String SMS_FUNCTION_TYPE = "sms_function_type";

    /**
     * 短信发送的APP编号
     */
    public static final String SMS_APP_ID = "sms_app_id";

    /**
     * 是否使用测试的发送短信接口
     */
    public static final String SMS_MOCK = "sms_mock";

    /**
     * 物流宝的接口是否使用沙箱测试帐号来调用
     */
    public static final String WLB_SANDBOX = "wlb_sandbox";

    /**
     * 延迟发送的短信的有效期的key
     */
    public static final String DELAY_SMS_EXPIRY = "delay_sms_expiry";

    /**
     * 延迟发送的短信校验检查物流流转信息的延迟时间
     */
    public static final String DELAY_SMS_SEARCH_TRACE_DELAY = "delay_sms_search_trace_delay";

    /**
     *
     */
    public static final String TRADE_CHECK_OPEN = "trade_check_open";

    /**
     * 订单同步时，获取淘宝的订单的modified时间和本地系统的订单的modified的时间的误差值，单位秒，例如这个值设置为2时，表示
     * 允许本地系统订单的modified时间向前推进2秒，只要淘宝的modified时间大于本地系统的订单modified时间则更新此订单。
     */
    public static final String TRADE_SYNC_UPDATE_DELAY = "trade_sync_update_delay";

    /**
     * 做短信催付提醒时,扫描sms_created_trade表的checkTime的时间范围
     */
    public static final String SMS_CREATED_TRADE_INTERVAL = "sms_created_trade_interval";

    /**
     * 使用缓存区插入订单的缓存大小
     */
    public static final String SMS_CREATED_TRADE_BUFFER_SIZE = "sms_created_trade_buffer_size";

    /**
     * 使用缓存区定时扫描队列的时间,单位毫秒
     */
    public static final String SMS_CREATED_TRADE_BUFFER_INTERVAL = "sms_created_trade_buffer_interval";

    /**
     * 菜单配置数据
     */
    public static final String MENU_CONFIG = "menu_config";

    /**
     * 营销活动配置
     */
    public static final String ACTIVE_CONFIG = "active_config";

    /**
     * 给指定用户注册TMC消息
     */
    public static final String TB_MESSAGE_TOPICS = "taobao_refund_RefundCreated,taobao_refund_RefundSuccess,taobao_refund_RefundClosed,taobao_trade_TradeCreate,taobao_trade_TradeBuyerPay,taobao_trade_TradeRated,taobao_trade_TradeSellerShip,taobao_trade_TradeMemoModified,taobao_trade_TradeLogisticsAddressChanged,taobao_trade_TradeChanged,taobao_trade_TradePartlySellerShip,taobao_item_ItemDelete";

    /**
     * 给指定用户注册TMC消息
     */
    public static final String TEST_TB_MESSAGE_TOPICS = "taobao_refund_RefundCreated,taobao_refund_RefundSuccess,taobao_refund_RefundClosed,taobao_refund_RefundableCanceled,taobao_refund_RefundableMarked,taobao_refund_RefundBuyerReturnGoods,taobao_refund_RefundBuyerModifyAgreement,taobao_refund_RefundSellerRefuseAgreement,taobao_refund_RefundSellerAgreeAgreement,taobao_trade_TradeCreate,taobao_trade_TradeBuyerPay,taobao_trade_TradeRated,taobao_trade_TradeSellerShip,taobao_trade_TradeMemoModified,taobao_trade_TradeLogisticsAddressChanged,taobao_item_ItemDelete,taobao_trade_TradeChanged,taobao_trade_TradePartlySellerShip";

    /**
     * 快递模版相关的日志名称
     */
    public static final String Express_Log_Name = "express";

}
