package com.gcloud.shop.domain.user;

import java.io.Serializable;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: DBInfo
 * @Package com.gcloud.domain.user
 * @Description: 数据库分库分表信息
 * @date 2016/6/1 13:53
 */
public class DBInfo implements Serializable {

    /**
     * 标识数据是否程序New
     */
    private boolean nullFlag;

    /**
     * 短信交易的分表号
     */
    private Integer smsTxnDbNo;

    /**
     * 订单的实例编号
     */
    private Integer tradeInstanceNo;

    /**
     * 子订单的实例编号
     */
    private Integer orderInstanceNo;

    /**
     * 订单的分表编号
     */
    private Integer tradeDbNo;

    /**
     * 子订单的分表编号
     */
    private Integer orderDbNo;

    /**
     * 商品itemd的分表编号
     */
    private Integer ItemDbNo;

    /**
     * 商品Sku的分表编号
     */
    private Integer SkuDbNo;

    /**
     * 电子面单号信息数据库实例编号
     */
    private Integer wlbNumberInstanceNo;

    /**
     * 电子面单信息数据库表编号
     */
    private Integer wlbNumberDbNo;

    /**
     * 用户电子面单模板分表编号
     */
    private Integer userWlbExpressTemplateDbNo;

    /**
     * 用户模版网点分表编号
     */
    private Integer templateBranchDbNo;

    /**
     * 用户模版网点地址分表编号
     */
    private Integer templateBranchAddressDbNo;

    /**
     * 用户拿货单分表编号
     */
    private Integer userAssemblyTemplateDbNo;

    /**
     * 用户发货模板分表编号
     */
    private Integer userDeliverTemplateDbNo;

    /**
     * 用户拣货单模版分表编号
     */
    private Integer userPickerTemplateDbNo;

    /**
     * 用户拿货单模版分表编号
     */
    private Integer userGetterTemplateDbNo;

    /**
     * 用户快递模板分表编号
     */
    private Integer userExpressTemplateDbNo;

    /**
     * 用户打印订单日志分表编号
     */
    private Integer printTradeLogDbNo;

    /**
     * 用户打印订单日志分表编号
     */
    private Integer printTradeLogDetailDbNo;

    /**
     * 用户打印订单统计日志分表编号
     */
    private Integer printOrderShipCountDbNo;

    /**
     * 用户自定义打印分表编号
     */
    private Integer userCustomPrintCountDbNo;

    /**
     * 文件上传日志的分表编号
     */
    public Integer fileUploadLogDbNo;

    /**
     * 订单跟踪分表号
     */
    private Integer tradeTraceDbNo;

    /**
     * 短信通知日志的分表号
     */
    private Integer notificationLogDbNo;

    /**
     * 电子面单号记录的分表号
     */
    private Integer outSidPoolDbNo;

    /**
     * 电子面单号回收的分表号
     */
    private Integer outSidRecoverDbNo;

    /**
     * 电子面单的网点与订单的对应关系的分表号
     */
    private Integer wlbAddressTradeLinkDbNo;

    /**
     * 操作日志分表号
     */
    private Integer actionLogDbNo;

    /**
     * 短信的创建订单的分表号
     */
    private Integer smsCreatedTradeDbNo;

    /**
     * 快递智能匹配的分表号
     */
    private Integer expressSmartMatchDbNo;

    /**
     * 商品库存的分表号
     */
    private Integer itemStockDbNo;

    /**
     * 库存出入库统计日志标表的分表号
     */
    private Integer itemStockLogDbNo;

    public boolean isNullFlag() {
        return nullFlag;
    }

    public void setNullFlag(boolean nullFlag) {
        this.nullFlag = nullFlag;
    }

    public Integer getSmsTxnDbNo() {
        return smsTxnDbNo;
    }

    public void setSmsTxnDbNo(Integer smsTxnDbNo) {
        this.smsTxnDbNo = smsTxnDbNo;
    }

    public Integer getTradeInstanceNo() {
        return tradeInstanceNo;
    }

    public void setTradeInstanceNo(Integer tradeInstanceNo) {
        this.tradeInstanceNo = tradeInstanceNo;
    }

    public Integer getOrderInstanceNo() {
        return orderInstanceNo;
    }

    public void setOrderInstanceNo(Integer orderInstanceNo) {
        this.orderInstanceNo = orderInstanceNo;
    }

    public Integer getTradeDbNo() {
        return tradeDbNo;
    }

    public void setTradeDbNo(Integer tradeDbNo) {
        this.tradeDbNo = tradeDbNo;
    }

    public Integer getOrderDbNo() {
        return orderDbNo;
    }

    public void setOrderDbNo(Integer orderDbNo) {
        this.orderDbNo = orderDbNo;
    }

    public Integer getItemDbNo() {
        return ItemDbNo;
    }

    public void setItemDbNo(Integer itemDbNo) {
        ItemDbNo = itemDbNo;
    }

    public Integer getSkuDbNo() {
        return SkuDbNo;
    }

    public void setSkuDbNo(Integer skuDbNo) {
        SkuDbNo = skuDbNo;
    }

    public Integer getWlbNumberInstanceNo() {
        return wlbNumberInstanceNo;
    }

    public void setWlbNumberInstanceNo(Integer wlbNumberInstanceNo) {
        this.wlbNumberInstanceNo = wlbNumberInstanceNo;
    }

    public Integer getWlbNumberDbNo() {
        return wlbNumberDbNo;
    }

    public void setWlbNumberDbNo(Integer wlbNumberDbNo) {
        this.wlbNumberDbNo = wlbNumberDbNo;
    }

    public Integer getUserWlbExpressTemplateDbNo() {
        return userWlbExpressTemplateDbNo;
    }

    public void setUserWlbExpressTemplateDbNo(Integer userWlbExpressTemplateDbNo) {
        this.userWlbExpressTemplateDbNo = userWlbExpressTemplateDbNo;
    }

    public Integer getTemplateBranchDbNo() {
        return templateBranchDbNo;
    }

    public void setTemplateBranchDbNo(Integer templateBranchDbNo) {
        this.templateBranchDbNo = templateBranchDbNo;
    }

    public Integer getTemplateBranchAddressDbNo() {
        return templateBranchAddressDbNo;
    }

    public void setTemplateBranchAddressDbNo(Integer templateBranchAddressDbNo) {
        this.templateBranchAddressDbNo = templateBranchAddressDbNo;
    }

    public Integer getUserAssemblyTemplateDbNo() {
        return userAssemblyTemplateDbNo;
    }

    public void setUserAssemblyTemplateDbNo(Integer userAssemblyTemplateDbNo) {
        this.userAssemblyTemplateDbNo = userAssemblyTemplateDbNo;
    }

    public Integer getUserDeliverTemplateDbNo() {
        return userDeliverTemplateDbNo;
    }

    public void setUserDeliverTemplateDbNo(Integer userDeliverTemplateDbNo) {
        this.userDeliverTemplateDbNo = userDeliverTemplateDbNo;
    }

    public Integer getUserPickerTemplateDbNo() {
        return userPickerTemplateDbNo;
    }

    public void setUserPickerTemplateDbNo(Integer userPickerTemplateDbNo) {
        this.userPickerTemplateDbNo = userPickerTemplateDbNo;
    }

    public Integer getUserGetterTemplateDbNo() {
        return userGetterTemplateDbNo;
    }

    public void setUserGetterTemplateDbNo(Integer userGetterTemplateDbNo) {
        this.userGetterTemplateDbNo = userGetterTemplateDbNo;
    }

    public Integer getUserExpressTemplateDbNo() {
        return userExpressTemplateDbNo;
    }

    public void setUserExpressTemplateDbNo(Integer userExpressTemplateDbNo) {
        this.userExpressTemplateDbNo = userExpressTemplateDbNo;
    }

    public Integer getPrintTradeLogDbNo() {
        return printTradeLogDbNo;
    }

    public void setPrintTradeLogDbNo(Integer printTradeLogDbNo) {
        this.printTradeLogDbNo = printTradeLogDbNo;
    }

    public Integer getPrintTradeLogDetailDbNo() {
        return printTradeLogDetailDbNo;
    }

    public void setPrintTradeLogDetailDbNo(Integer printTradeLogDetailDbNo) {
        this.printTradeLogDetailDbNo = printTradeLogDetailDbNo;
    }

    public Integer getPrintOrderShipCountDbNo() {
        return printOrderShipCountDbNo;
    }

    public void setPrintOrderShipCountDbNo(Integer printOrderShipCountDbNo) {
        this.printOrderShipCountDbNo = printOrderShipCountDbNo;
    }

    public Integer getUserCustomPrintCountDbNo() {
        return userCustomPrintCountDbNo;
    }

    public void setUserCustomPrintCountDbNo(Integer userCustomPrintCountDbNo) {
        this.userCustomPrintCountDbNo = userCustomPrintCountDbNo;
    }

    public Integer getFileUploadLogDbNo() {
        return fileUploadLogDbNo;
    }

    public void setFileUploadLogDbNo(Integer fileUploadLogDbNo) {
        this.fileUploadLogDbNo = fileUploadLogDbNo;
    }

    public Integer getTradeTraceDbNo() {
        return tradeTraceDbNo;
    }

    public void setTradeTraceDbNo(Integer tradeTraceDbNo) {
        this.tradeTraceDbNo = tradeTraceDbNo;
    }

    public Integer getNotificationLogDbNo() {
        return notificationLogDbNo;
    }

    public void setNotificationLogDbNo(Integer notificationLogDbNo) {
        this.notificationLogDbNo = notificationLogDbNo;
    }

    public Integer getOutSidPoolDbNo() {
        return outSidPoolDbNo;
    }

    public void setOutSidPoolDbNo(Integer outSidPoolDbNo) {
        this.outSidPoolDbNo = outSidPoolDbNo;
    }

    public Integer getOutSidRecoverDbNo() {
        return outSidRecoverDbNo;
    }

    public void setOutSidRecoverDbNo(Integer outSidRecoverDbNo) {
        this.outSidRecoverDbNo = outSidRecoverDbNo;
    }

    public Integer getWlbAddressTradeLinkDbNo() {
        return wlbAddressTradeLinkDbNo;
    }

    public void setWlbAddressTradeLinkDbNo(Integer wlbAddressTradeLinkDbNo) {
        this.wlbAddressTradeLinkDbNo = wlbAddressTradeLinkDbNo;
    }

    public Integer getActionLogDbNo() {
        return actionLogDbNo;
    }

    public void setActionLogDbNo(Integer actionLogDbNo) {
        this.actionLogDbNo = actionLogDbNo;
    }

    public Integer getSmsCreatedTradeDbNo() {
        return smsCreatedTradeDbNo;
    }

    public void setSmsCreatedTradeDbNo(Integer smsCreatedTradeDbNo) {
        this.smsCreatedTradeDbNo = smsCreatedTradeDbNo;
    }

    public Integer getExpressSmartMatchDbNo() {
        return expressSmartMatchDbNo;
    }

    public void setExpressSmartMatchDbNo(Integer expressSmartMatchDbNo) {
        this.expressSmartMatchDbNo = expressSmartMatchDbNo;
    }

    public Integer getItemStockDbNo() {
        return itemStockDbNo;
    }

    public void setItemStockDbNo(Integer itemStockDbNo) {
        this.itemStockDbNo = itemStockDbNo;
    }

    public Integer getItemStockLogDbNo() {
        return itemStockLogDbNo;
    }

    public void setItemStockLogDbNo(Integer itemStockLogDbNo) {
        this.itemStockLogDbNo = itemStockLogDbNo;
    }
}
