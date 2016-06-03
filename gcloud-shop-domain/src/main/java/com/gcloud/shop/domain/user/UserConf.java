package com.gcloud.shop.domain.user;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: UserConf
 * @Package com.gcloud.domain.SubUser
 * @Description: 用户配置，这个配置将会转换为JSON格式的字符串存储在{@link User}中的conf属性中。
 * @date 2016/6/1 13:53
 */
public class UserConf implements Serializable {

    /**
     * 上一次导入订单的时间，此字段后期废用、
     */
    private Date lastImportTradeTime;

    /**
     * 上一次点击同步订单或者同步订单的时间，这个和lastImportTradeTime时间不一样
     */
    private Date lastClickImportTradeTime;

    /**
     * 最新的商品模块索引版本 itemIndexLatestVersion
     */
    private Integer itemILV;

    /**
     *
     */
    private static Integer CurrentitemILV = 2;

    /**
     * 上一次导入物流数据的时间
     */
    private Date lastImportLogisticsTime;

    /**
     * 上一次注册到订单同步服务的时间
     */
    private Date lastRegistTradeSyncTime;

    /**
     * 是否是第一次使用订单同步系统同步，
     */
    private boolean firstUseTradeSync = true;

    /**
     * 是否引导过
     */
    private boolean guide = false;

    /**
     * 数据库的分表分库信息
     */
    private DBInfo dbInfo;

    /**
     * 用户的订单查询条件
     */
    private LinkedList<TradeQueryTab> tradeQueryTabs;

    /**
     * 卖家的订单的快捷留言消息配置，使用','分割每个关键词
     */
    private String shortcutMessage;

    /**
     * 订单同步设置
     */
    private SyncSettings syncSettings;

    /**
     * 是否同步待付款订单
     */
    private Boolean syncWaitPay;

    /**
     * 是否同步关闭或者成功的订单
     */
    private Boolean syncCloseSuccess;

    /**
     * 是否是沙箱用户
     */
    private Boolean sandbox;

    /**
     * last get dealine date上一次获取到期时间，如果获取到期时间失败，将设置为空
     */
    private Date lgd;

    /**
     * 是否开启快递智能匹配
     *
     */
    private Boolean isOpenESM;

    /**
     * Mode of Multi-Shop 多店铺绑定模式，默认为0，店铺互相切换的方式，1表示Master-Slave的模式，主次店铺之分
     */
    private Integer mmb = 0;

    /**
     *
     */
    private TbAuth tbAuth;

    /**
     * 当前用户是否在维护：是否正在进行分表等操作
     */
    private Boolean isMaintain;

    /**
     * 卖家的信息，例如type，表示店铺类型,可选值:B(B商家),C(C商家)
     */
    private Map<String, Object> sellerInfo;

    public Date getLastImportTradeTime() {
        return lastImportTradeTime;
    }

    public void setLastImportTradeTime(Date lastImportTradeTime) {
        this.lastImportTradeTime = lastImportTradeTime;
    }

    public Date getLastClickImportTradeTime() {
        return lastClickImportTradeTime;
    }

    public void setLastClickImportTradeTime(Date lastClickImportTradeTime) {
        this.lastClickImportTradeTime = lastClickImportTradeTime;
    }

    public Integer getItemILV() {
        return itemILV;
    }

    public void setItemILV(Integer itemILV) {
        this.itemILV = itemILV;
    }

    public static Integer getCurrentitemILV() {
        return CurrentitemILV;
    }

    public static void setCurrentitemILV(Integer currentitemILV) {
        CurrentitemILV = currentitemILV;
    }

    public Date getLastImportLogisticsTime() {
        return lastImportLogisticsTime;
    }

    public void setLastImportLogisticsTime(Date lastImportLogisticsTime) {
        this.lastImportLogisticsTime = lastImportLogisticsTime;
    }

    public Date getLastRegistTradeSyncTime() {
        return lastRegistTradeSyncTime;
    }

    public void setLastRegistTradeSyncTime(Date lastRegistTradeSyncTime) {
        this.lastRegistTradeSyncTime = lastRegistTradeSyncTime;
    }

    public boolean isFirstUseTradeSync() {
        return firstUseTradeSync;
    }

    public void setFirstUseTradeSync(boolean firstUseTradeSync) {
        this.firstUseTradeSync = firstUseTradeSync;
    }

    public boolean isGuide() {
        return guide;
    }

    public void setGuide(boolean guide) {
        this.guide = guide;
    }

    public DBInfo getDbInfo() {
        return dbInfo;
    }

    public void setDbInfo(DBInfo dbInfo) {
        this.dbInfo = dbInfo;
    }

    public LinkedList<TradeQueryTab> getTradeQueryTabs() {
        return tradeQueryTabs;
    }

    public void setTradeQueryTabs(LinkedList<TradeQueryTab> tradeQueryTabs) {
        this.tradeQueryTabs = tradeQueryTabs;
    }

    public String getShortcutMessage() {
        return shortcutMessage;
    }

    public void setShortcutMessage(String shortcutMessage) {
        this.shortcutMessage = shortcutMessage;
    }

    public SyncSettings getSyncSettings() {
        return syncSettings;
    }

    public void setSyncSettings(SyncSettings syncSettings) {
        this.syncSettings = syncSettings;
    }

    public Boolean getSyncWaitPay() {
        return syncWaitPay;
    }

    public void setSyncWaitPay(Boolean syncWaitPay) {
        this.syncWaitPay = syncWaitPay;
    }

    public Boolean getSyncCloseSuccess() {
        return syncCloseSuccess;
    }

    public void setSyncCloseSuccess(Boolean syncCloseSuccess) {
        this.syncCloseSuccess = syncCloseSuccess;
    }

    public Boolean getSandbox() {
        return sandbox;
    }

    public void setSandbox(Boolean sandbox) {
        this.sandbox = sandbox;
    }

    public Date getLgd() {
        return lgd;
    }

    public void setLgd(Date lgd) {
        this.lgd = lgd;
    }

    public Boolean getIsOpenESM() {
        return isOpenESM;
    }

    public void setIsOpenESM(Boolean isOpenESM) {
        this.isOpenESM = isOpenESM;
    }

    public Integer getMmb() {
        return mmb;
    }

    public void setMmb(Integer mmb) {
        this.mmb = mmb;
    }

    public TbAuth getTbAuth() {
        return tbAuth;
    }

    public void setTbAuth(TbAuth tbAuth) {
        this.tbAuth = tbAuth;
    }

    public Boolean getIsMaintain() {
        return isMaintain;
    }

    public void setIsMaintain(Boolean isMaintain) {
        this.isMaintain = isMaintain;
    }

    public Map<String, Object> getSellerInfo() {
        return sellerInfo;
    }

    public void setSellerInfo(Map<String, Object> sellerInfo) {
        this.sellerInfo = sellerInfo;
    }
}
