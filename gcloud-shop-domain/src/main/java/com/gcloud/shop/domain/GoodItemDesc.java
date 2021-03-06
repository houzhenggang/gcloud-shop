package com.gcloud.shop.domain;

import java.util.Date;

public class GoodItemDesc {
    /**
     * 主键 <p/>
     * This field corresponds to the database column tb_good_item_desc.id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Long id;

    /**
     * 门店ID <p/>
     * This field corresponds to the database column tb_good_item_desc.store_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String storeId;

    /**
     * 商品ID(口碑) <p/>
     * This field corresponds to the database column tb_good_item_desc.itme_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String itmeId;

    /**
     * 商品ID(系统) <p/>
     * This field corresponds to the database column tb_good_item_desc.item_sys_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String itemSysId;

    /**
     * 描述标题，不得超过15个中文字符(洗剪吹套餐) <p/>
     * This field corresponds to the database column tb_good_item_desc.title
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String title;

    /**
     * 标题下的描述列表,券使用说明内容 <p/>
     * This field corresponds to the database column tb_good_item_desc.details
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String details;

    /**
     * 明细图片列表，要求图片张数小于或等于3。请勿上传过大图片，图片将会自适应至尺寸比例88:75 <p/>
     * This field corresponds to the database column tb_good_item_desc.images
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String images;

    /**
     * 套餐使用说明链接，必须是https的地址链接 <p/>
     * This field corresponds to the database column tb_good_item_desc.url
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String url;

    /**
     * 当前状态(0 未确认 1 商家确认 2 小二确认  -1 屏蔽  -2 删除) <p/>
     * This field corresponds to the database column tb_good_item_desc.status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Byte status;

    /**
     * 平台信息(kb口碑 tb淘宝 bd百度外卖) <p/>
     * This field corresponds to the database column tb_good_item_desc.platform
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String platform;

    /**
     * 备注 <p/>
     * This field corresponds to the database column tb_good_item_desc.remark
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_good_item_desc.created
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_good_item_desc.modified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Date modified;

    /**
     * 0否 1是 <p/>
     * This field corresponds to the database column tb_good_item_desc.enable_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Boolean enableStatus;

    /**
     * 主键 <p/>
     * This method returns the value of the database column tb_good_item_desc.id
     *
     * @return the value of tb_good_item_desc.id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键 <p/>
     * This method sets the value of the database column tb_good_item_desc.id
     *
     * @param id the value for tb_good_item_desc.id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 门店ID <p/>
     * This method returns the value of the database column tb_good_item_desc.store_id
     *
     * @return the value of tb_good_item_desc.store_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * 门店ID <p/>
     * This method sets the value of the database column tb_good_item_desc.store_id
     *
     * @param storeId the value for tb_good_item_desc.store_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    /**
     * 商品ID(口碑) <p/>
     * This method returns the value of the database column tb_good_item_desc.itme_id
     *
     * @return the value of tb_good_item_desc.itme_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getItmeId() {
        return itmeId;
    }

    /**
     * 商品ID(口碑) <p/>
     * This method sets the value of the database column tb_good_item_desc.itme_id
     *
     * @param itmeId the value for tb_good_item_desc.itme_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setItmeId(String itmeId) {
        this.itmeId = itmeId == null ? null : itmeId.trim();
    }

    /**
     * 商品ID(系统) <p/>
     * This method returns the value of the database column tb_good_item_desc.item_sys_id
     *
     * @return the value of tb_good_item_desc.item_sys_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getItemSysId() {
        return itemSysId;
    }

    /**
     * 商品ID(系统) <p/>
     * This method sets the value of the database column tb_good_item_desc.item_sys_id
     *
     * @param itemSysId the value for tb_good_item_desc.item_sys_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setItemSysId(String itemSysId) {
        this.itemSysId = itemSysId == null ? null : itemSysId.trim();
    }

    /**
     * 描述标题，不得超过15个中文字符(洗剪吹套餐) <p/>
     * This method returns the value of the database column tb_good_item_desc.title
     *
     * @return the value of tb_good_item_desc.title
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getTitle() {
        return title;
    }

    /**
     * 描述标题，不得超过15个中文字符(洗剪吹套餐) <p/>
     * This method sets the value of the database column tb_good_item_desc.title
     *
     * @param title the value for tb_good_item_desc.title
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 标题下的描述列表,券使用说明内容 <p/>
     * This method returns the value of the database column tb_good_item_desc.details
     *
     * @return the value of tb_good_item_desc.details
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getDetails() {
        return details;
    }

    /**
     * 标题下的描述列表,券使用说明内容 <p/>
     * This method sets the value of the database column tb_good_item_desc.details
     *
     * @param details the value for tb_good_item_desc.details
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    /**
     * 明细图片列表，要求图片张数小于或等于3。请勿上传过大图片，图片将会自适应至尺寸比例88:75 <p/>
     * This method returns the value of the database column tb_good_item_desc.images
     *
     * @return the value of tb_good_item_desc.images
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getImages() {
        return images;
    }

    /**
     * 明细图片列表，要求图片张数小于或等于3。请勿上传过大图片，图片将会自适应至尺寸比例88:75 <p/>
     * This method sets the value of the database column tb_good_item_desc.images
     *
     * @param images the value for tb_good_item_desc.images
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    /**
     * 套餐使用说明链接，必须是https的地址链接 <p/>
     * This method returns the value of the database column tb_good_item_desc.url
     *
     * @return the value of tb_good_item_desc.url
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getUrl() {
        return url;
    }

    /**
     * 套餐使用说明链接，必须是https的地址链接 <p/>
     * This method sets the value of the database column tb_good_item_desc.url
     *
     * @param url the value for tb_good_item_desc.url
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 当前状态(0 未确认 1 商家确认 2 小二确认  -1 屏蔽  -2 删除) <p/>
     * This method returns the value of the database column tb_good_item_desc.status
     *
     * @return the value of tb_good_item_desc.status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 当前状态(0 未确认 1 商家确认 2 小二确认  -1 屏蔽  -2 删除) <p/>
     * This method sets the value of the database column tb_good_item_desc.status
     *
     * @param status the value for tb_good_item_desc.status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 平台信息(kb口碑 tb淘宝 bd百度外卖) <p/>
     * This method returns the value of the database column tb_good_item_desc.platform
     *
     * @return the value of tb_good_item_desc.platform
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 平台信息(kb口碑 tb淘宝 bd百度外卖) <p/>
     * This method sets the value of the database column tb_good_item_desc.platform
     *
     * @param platform the value for tb_good_item_desc.platform
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    /**
     * 备注 <p/>
     * This method returns the value of the database column tb_good_item_desc.remark
     *
     * @return the value of tb_good_item_desc.remark
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 <p/>
     * This method sets the value of the database column tb_good_item_desc.remark
     *
     * @param remark the value for tb_good_item_desc.remark
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_good_item_desc.created
     *
     * @return the value of tb_good_item_desc.created
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_good_item_desc.created
     *
     * @param created the value for tb_good_item_desc.created
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_good_item_desc.modified
     *
     * @return the value of tb_good_item_desc.modified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Date getModified() {
        return modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_good_item_desc.modified
     *
     * @param modified the value for tb_good_item_desc.modified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * 0否 1是 <p/>
     * This method returns the value of the database column tb_good_item_desc.enable_status
     *
     * @return the value of tb_good_item_desc.enable_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Boolean getEnableStatus() {
        return enableStatus;
    }

    /**
     * 0否 1是 <p/>
     * This method sets the value of the database column tb_good_item_desc.enable_status
     *
     * @param enableStatus the value for tb_good_item_desc.enable_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setEnableStatus(Boolean enableStatus) {
        this.enableStatus = enableStatus;
    }
}