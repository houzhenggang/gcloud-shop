package com.gcloud.shop.domain;

public class StoreInfoWithBLOBs extends StoreInfo {
    /**
     * 门店审核时需要的图片；至少包含一张门头照片，两张内景照片，必须反映真实的门店情况，审核才能够通过；多个图片之间以英文逗号分隔。 <p/>
     * This field corresponds to the database column tb_shop_store.audit_images
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String auditImages;

    /**
     * 在其他平台的开店图片，支持多张，逗号分隔。 <p/>
     * This field corresponds to the database column tb_shop_store.online_image
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String onlineImage;

    /**
     * 其它资质证明图片集；支持多张，逗号分隔。 <p/>
     * This field corresponds to the database column tb_shop_store.other_auth_images
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String otherAuthImages;

    /**
     * 其他平台开店的店铺链接url，多个url使用英文逗号隔开,isv迁移到新接口使用此字段，与is_operating_online=T配套使用。 <p/>
     * This field corresponds to the database column tb_shop_store.online_url
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String onlineUrl;

    /**
     * 门店标签；JSON格式。包括：keyMerchant-是否重点商户（T/F）；isHallMeal-堂食（T/F）；注：若标签 key 不存在，则门店无对应的标签 <p/>
     * This field corresponds to the database column tb_shop_store.shop_tags
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String shopTags;

    /**
     * 门店审核时需要的图片；至少包含一张门头照片，两张内景照片，必须反映真实的门店情况，审核才能够通过；多个图片之间以英文逗号分隔。 <p/>
     * This method returns the value of the database column tb_shop_store.audit_images
     *
     * @return the value of tb_shop_store.audit_images
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getAuditImages() {
        return auditImages;
    }

    /**
     * 门店审核时需要的图片；至少包含一张门头照片，两张内景照片，必须反映真实的门店情况，审核才能够通过；多个图片之间以英文逗号分隔。 <p/>
     * This method sets the value of the database column tb_shop_store.audit_images
     *
     * @param auditImages the value for tb_shop_store.audit_images
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setAuditImages(String auditImages) {
        this.auditImages = auditImages == null ? null : auditImages.trim();
    }

    /**
     * 在其他平台的开店图片，支持多张，逗号分隔。 <p/>
     * This method returns the value of the database column tb_shop_store.online_image
     *
     * @return the value of tb_shop_store.online_image
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getOnlineImage() {
        return onlineImage;
    }

    /**
     * 在其他平台的开店图片，支持多张，逗号分隔。 <p/>
     * This method sets the value of the database column tb_shop_store.online_image
     *
     * @param onlineImage the value for tb_shop_store.online_image
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setOnlineImage(String onlineImage) {
        this.onlineImage = onlineImage == null ? null : onlineImage.trim();
    }

    /**
     * 其它资质证明图片集；支持多张，逗号分隔。 <p/>
     * This method returns the value of the database column tb_shop_store.other_auth_images
     *
     * @return the value of tb_shop_store.other_auth_images
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getOtherAuthImages() {
        return otherAuthImages;
    }

    /**
     * 其它资质证明图片集；支持多张，逗号分隔。 <p/>
     * This method sets the value of the database column tb_shop_store.other_auth_images
     *
     * @param otherAuthImages the value for tb_shop_store.other_auth_images
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setOtherAuthImages(String otherAuthImages) {
        this.otherAuthImages = otherAuthImages == null ? null : otherAuthImages.trim();
    }

    /**
     * 其他平台开店的店铺链接url，多个url使用英文逗号隔开,isv迁移到新接口使用此字段，与is_operating_online=T配套使用。 <p/>
     * This method returns the value of the database column tb_shop_store.online_url
     *
     * @return the value of tb_shop_store.online_url
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getOnlineUrl() {
        return onlineUrl;
    }

    /**
     * 其他平台开店的店铺链接url，多个url使用英文逗号隔开,isv迁移到新接口使用此字段，与is_operating_online=T配套使用。 <p/>
     * This method sets the value of the database column tb_shop_store.online_url
     *
     * @param onlineUrl the value for tb_shop_store.online_url
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setOnlineUrl(String onlineUrl) {
        this.onlineUrl = onlineUrl == null ? null : onlineUrl.trim();
    }

    /**
     * 门店标签；JSON格式。包括：keyMerchant-是否重点商户（T/F）；isHallMeal-堂食（T/F）；注：若标签 key 不存在，则门店无对应的标签 <p/>
     * This method returns the value of the database column tb_shop_store.shop_tags
     *
     * @return the value of tb_shop_store.shop_tags
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getShopTags() {
        return shopTags;
    }

    /**
     * 门店标签；JSON格式。包括：keyMerchant-是否重点商户（T/F）；isHallMeal-堂食（T/F）；注：若标签 key 不存在，则门店无对应的标签 <p/>
     * This method sets the value of the database column tb_shop_store.shop_tags
     *
     * @param shopTags the value for tb_shop_store.shop_tags
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setShopTags(String shopTags) {
        this.shopTags = shopTags == null ? null : shopTags.trim();
    }
}