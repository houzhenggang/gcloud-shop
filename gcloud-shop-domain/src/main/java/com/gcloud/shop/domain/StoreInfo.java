package com.gcloud.shop.domain;

import java.util.Date;

public class StoreInfo {
    /**
     * 主键（yyyyMMddhhmmss + 门店ID + 4位随机数） <p/>
     * This field corresponds to the database column tb_shop_store.id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Long id;

    /**
     * 门店ID <p/>
     * This field corresponds to the database column tb_shop_store.store_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String storeId;

    /**
     * 类目id，请参考 <p/>
     * This field corresponds to the database column tb_shop_store.category_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String categoryId;

    /**
     * 品牌名，不填写则默认为“其它品牌” <p/>
     * This field corresponds to the database column tb_shop_store.brand_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String brandName;

    /**
     * 品牌LOGO; 图片ID，不填写则默认为门店首图main_image <p/>
     * This field corresponds to the database column tb_shop_store.brand_logo
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String brandLogo;

    /**
     * 主门店名 比如：肯德基；主店名里不要包含分店名，如“万塘路店” <p/>
     * This field corresponds to the database column tb_shop_store.main_shop_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String mainShopName;

    /**
     * 分店名称，比如：万塘路店，与主门店名合并在客户端显示为：肯德基(万塘路店)。 <p/>
     * This field corresponds to the database column tb_shop_store.branch_shop_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String branchShopName;

    /**
     * COMMON（普通门店）、MALL（商圈） <p/>
     * This field corresponds to the database column tb_shop_store.shop_type
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String shopType;

    /**
     * 省份编码，国标码，详见国家统计局数据 <p/>
     * This field corresponds to the database column tb_shop_store.province_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String provinceCode;

    /**
     * 城市编码，国标码，详见国家统计局数据 <p/>
     * This field corresponds to the database column tb_shop_store.city_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String cityCode;

    /**
     * 区县编码，国标码，详见国家统计局数据 <p/>
     * This field corresponds to the database column tb_shop_store.district_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String districtCode;

    /**
     * 门店详细地址，地址字符长度在4-50个字符，注：不含省市区。例1：道路+门牌号，“人民东路18号”；例2：道路+门牌号+标志性建筑+楼层，“四川北路1552号欢乐广场1楼”。 <p/>
     * This field corresponds to the database column tb_shop_store.address
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String address;

    /**
     * 经度；最长15位字符（包括小数点）， 注：高德坐标系。 <p/>
     * This field corresponds to the database column tb_shop_store.longitude
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String longitude;

    /**
     * 纬度；最长15位字符（包括小数点）， 注：高德坐标系。 <p/>
     * This field corresponds to the database column tb_shop_store.latitude
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String latitude;

    /**
     * 门店的签约ID <p/>
     * This field corresponds to the database column tb_shop_store.partner_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String partnerId;

    /**
     * 默认付款类型；如：付款码、扫码付、声波支付、在线买单、其它 <p/>
     * This field corresponds to the database column tb_shop_store.pay_type
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String payType;

    /**
     * 门店创建来源；如：开放平台、支付宝客户端、口碑商家app、商家自主开店、服务商开店、全民开店-支付宝客户端、全民开店-商户app、其它 <p/>
     * This field corresponds to the database column tb_shop_store.create_channel
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String createChannel;

    /**
     * 门店运营归属人uid <p/>
     * This field corresponds to the database column tb_shop_store.provider_xiaoer_uid
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String providerXiaoerUid;

    /**
     * 门店电话号码；支持座机和手机，只支持数字和+-号，在客户端对用户展现， 支持多个电话， 以英文逗号分隔 <p/>
     * This field corresponds to the database column tb_shop_store.contact_number
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String contactNumber;

    /**
     * 门店店长电话号码；用于接收门店状态变更通知，收款成功通知等通知消息， 不在客户端展示。 <p/>
     * This field corresponds to the database column tb_shop_store.notify_mobile
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String notifyMobile;

    /**
     * 门店首图，非常重要，推荐尺寸2000*1500。 <p/>
     * This field corresponds to the database column tb_shop_store.main_image
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String mainImage;

    /**
     * 门店收款二维码裸码。 <p/>
     * This field corresponds to the database column tb_shop_store.qr_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String qrCode;

    /**
     * 经过加工后的门店收款二维码。 <p/>
     * This field corresponds to the database column tb_shop_store.processed_qr_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String processedQrCode;

    /**
     * 营业时间，支持分段营业时间，以英文逗号分隔。 <p/>
     * This field corresponds to the database column tb_shop_store.business_time
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String businessTime;

    /**
     * 门店是否支持WIFI，T表示支持，F表示不支持，不传在客户端不作展示。 <p/>
     * This field corresponds to the database column tb_shop_store.wifi
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String wifi;

    /**
     * 门店是否支持停车，T表示支持，F表示不支持，不传在客户端不作展示。 <p/>
     * This field corresponds to the database column tb_shop_store.parking
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String parking;

    /**
     * 门店其他的服务，门店与用户线下兑现。	免费茶水、免费糖果 <p/>
     * This field corresponds to the database column tb_shop_store.value_added
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String valueAdded;

    /**
     * 人均消费价格，最少1元，最大不超过99999元，请按实际情况填写；单位元，不需填写单位。 <p/>
     * This field corresponds to the database column tb_shop_store.avg_price
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String avgPrice;

    /**
     * ISV返佣id，门店创建、或者门店交易的返佣将通过此账号反给ISV，如果有口碑签订了返佣协议，则该字段作为返佣数据提取的依据。此字段必须是个合法uid，2088开头的16位支付宝会员账号，如果传入错误将无法创建门店。 <p/>
     * This field corresponds to the database column tb_shop_store.isv_uid
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String isvUid;

    /**
     * 门店营业执照图片，各行业所需的证照资质参见商户入驻要求。 <p/>
     * This field corresponds to the database column tb_shop_store.licence
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String licence;

    /**
     * 门店营业执照编号，营业执照信息与is_operating_online至少填一项。 <p/>
     * This field corresponds to the database column tb_shop_store.licence_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String licenceCode;

    /**
     * 门店营业执照名称。 <p/>
     * This field corresponds to the database column tb_shop_store.licence_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String licenceName;

    /**
     * 人许可证，各行业所需的证照资质参见商户入驻要求；该字段只能上传一张许可证，一张以外的许可证、除营业执照和许可证之外其他证照请放在其他资质字段上传。 <p/>
     * This field corresponds to the database column tb_shop_store.business_certificate
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String businessCertificate;

    /**
     * 许可证有效期，格式：2020-03-20 <p/>
     * This field corresponds to the database column tb_shop_store.business_certificate_expires
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String businessCertificateExpires;

    /**
     * 门店授权函,营业执照与签约账号主体不一致时需要。 <p/>
     * This field corresponds to the database column tb_shop_store.auth_letter
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String authLetter;

    /**
     * 当商户的门店审核状态发生变化时，会向该地址推送消息。 <p/>
     * This field corresponds to the database column tb_shop_store.operate_notify_url
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String operateNotifyUrl;

    /**
     * 机具号，多个之间以英文逗号分隔。 <p/>
     * This field corresponds to the database column tb_shop_store.implement_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String implementId;

    /**
     * 支持英文字母和数字，由开发者自行定义（不允许重复），在门店notify消息中也会带有该参数，以此标明本次notify消息是对哪个请求的回应。 <p/>
     * This field corresponds to the database column tb_shop_store.request_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String requestId;

    /**
     * 其他资质。用于上传营业证照、许可证照外的其他资质，除已上传许可证外的其他许可证也可以在该字段上传。 <p/>
     * This field corresponds to the database column tb_shop_store.other_authorization
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String otherAuthorization;

    /**
     * 营业执照过期时间。 <p/>
     * This field corresponds to the database column tb_shop_store.licence_expires
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String licenceExpires;

    /**
     * 表示以系统集成商的身份开店，开放平台现在统一传入ISV 默认商户操作:MERCHANT；服务商操作：PROVIDER。支付宝内部使用，外部商户不需填写此字段 <p/>
     * This field corresponds to the database column tb_shop_store.op_role
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String opRole;

    /**
     * 店铺接口业务版本号，新接入的ISV，请统一传入2.0 <p/>
     * This field corresponds to the database column tb_shop_store.biz_version
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String bizVersion;

    /**
     * 开店请求受理成功后返回的支付宝流水ID，根据此ID调用接口 alipay.offline.market.applyorder.batchquery，能够获取当前开店请求审核状态、驳回原因等信息。 <p/>
     * This field corresponds to the database column tb_shop_store.apply_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String applyId;

    /**
     * 门店审核状态，对于系统商而言，只有三个状态，AUDITING：审核中，AUDIT_FAILED：审核驳回，AUDIT_SUCCESS：审核通过。第一次审核通过会触发门店上架 <p/>
     * This field corresponds to the database column tb_shop_store.audit_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String auditStatus;

    /**
     * 门店审核状态描述，如果审核驳回则有相关的驳回理由 <p/>
     * This field corresponds to the database column tb_shop_store.audit_desc
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String auditDesc;

    /**
     * 是否有无烟区，T表示有无烟区，F表示没有无烟区，不传在客户端不展示。 <p/>
     * This field corresponds to the database column tb_shop_store.no_smoking
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String noSmoking;

    /**
     * 门店是否有包厢，T表示有，F表示没有，不传在客户端不作展示。 <p/>
     * This field corresponds to the database column tb_shop_store.box
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String box;

    /**
     * 是否在其他平台开店，T表示有开店，F表示未开店。 <p/>
     * This field corresponds to the database column tb_shop_store.is_operating_online
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String isOperatingOnline;

    /**
     * 门店是否上架，T表示上架,F表示未上架，第一次门店审核通过后会触发上架。 <p/>
     * This field corresponds to the database column tb_shop_store.is_online
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String isOnline;

    /**
     * 门店是否在客户端显示，T表示显示，F表示隐藏。 <p/>
     * This field corresponds to the database column tb_shop_store.is_show
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String isShow;

    /**
     * 门店创建时间 <p/>
     * This field corresponds to the database column tb_shop_store.gmt_shop_create
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String gmtShopCreate;

    /**
     * 门店修改时间 <p/>
     * This field corresponds to the database column tb_shop_store.gmt_shop_modified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String gmtShopModified;

    /**
     * 门店状态：OPEN（营业）、PAUSED（暂停）、INIT（初始）、FREEZE（冻结）、CLOSED（关店） <p/>
     * This field corresponds to the database column tb_shop_store.status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shop_store.created
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shop_store.modified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Date modified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_shop_store.enable_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Boolean enableStatus;

    /**
     * 主键（yyyyMMddhhmmss + 门店ID + 4位随机数） <p/>
     * This method returns the value of the database column tb_shop_store.id
     *
     * @return the value of tb_shop_store.id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键（yyyyMMddhhmmss + 门店ID + 4位随机数） <p/>
     * This method sets the value of the database column tb_shop_store.id
     *
     * @param id the value for tb_shop_store.id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 门店ID <p/>
     * This method returns the value of the database column tb_shop_store.store_id
     *
     * @return the value of tb_shop_store.store_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * 门店ID <p/>
     * This method sets the value of the database column tb_shop_store.store_id
     *
     * @param storeId the value for tb_shop_store.store_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    /**
     * 类目id，请参考 <p/>
     * This method returns the value of the database column tb_shop_store.category_id
     *
     * @return the value of tb_shop_store.category_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 类目id，请参考 <p/>
     * This method sets the value of the database column tb_shop_store.category_id
     *
     * @param categoryId the value for tb_shop_store.category_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    /**
     * 品牌名，不填写则默认为“其它品牌” <p/>
     * This method returns the value of the database column tb_shop_store.brand_name
     *
     * @return the value of tb_shop_store.brand_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 品牌名，不填写则默认为“其它品牌” <p/>
     * This method sets the value of the database column tb_shop_store.brand_name
     *
     * @param brandName the value for tb_shop_store.brand_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 品牌LOGO; 图片ID，不填写则默认为门店首图main_image <p/>
     * This method returns the value of the database column tb_shop_store.brand_logo
     *
     * @return the value of tb_shop_store.brand_logo
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getBrandLogo() {
        return brandLogo;
    }

    /**
     * 品牌LOGO; 图片ID，不填写则默认为门店首图main_image <p/>
     * This method sets the value of the database column tb_shop_store.brand_logo
     *
     * @param brandLogo the value for tb_shop_store.brand_logo
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo == null ? null : brandLogo.trim();
    }

    /**
     * 主门店名 比如：肯德基；主店名里不要包含分店名，如“万塘路店” <p/>
     * This method returns the value of the database column tb_shop_store.main_shop_name
     *
     * @return the value of tb_shop_store.main_shop_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getMainShopName() {
        return mainShopName;
    }

    /**
     * 主门店名 比如：肯德基；主店名里不要包含分店名，如“万塘路店” <p/>
     * This method sets the value of the database column tb_shop_store.main_shop_name
     *
     * @param mainShopName the value for tb_shop_store.main_shop_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setMainShopName(String mainShopName) {
        this.mainShopName = mainShopName == null ? null : mainShopName.trim();
    }

    /**
     * 分店名称，比如：万塘路店，与主门店名合并在客户端显示为：肯德基(万塘路店)。 <p/>
     * This method returns the value of the database column tb_shop_store.branch_shop_name
     *
     * @return the value of tb_shop_store.branch_shop_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getBranchShopName() {
        return branchShopName;
    }

    /**
     * 分店名称，比如：万塘路店，与主门店名合并在客户端显示为：肯德基(万塘路店)。 <p/>
     * This method sets the value of the database column tb_shop_store.branch_shop_name
     *
     * @param branchShopName the value for tb_shop_store.branch_shop_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setBranchShopName(String branchShopName) {
        this.branchShopName = branchShopName == null ? null : branchShopName.trim();
    }

    /**
     * COMMON（普通门店）、MALL（商圈） <p/>
     * This method returns the value of the database column tb_shop_store.shop_type
     *
     * @return the value of tb_shop_store.shop_type
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getShopType() {
        return shopType;
    }

    /**
     * COMMON（普通门店）、MALL（商圈） <p/>
     * This method sets the value of the database column tb_shop_store.shop_type
     *
     * @param shopType the value for tb_shop_store.shop_type
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setShopType(String shopType) {
        this.shopType = shopType == null ? null : shopType.trim();
    }

    /**
     * 省份编码，国标码，详见国家统计局数据 <p/>
     * This method returns the value of the database column tb_shop_store.province_code
     *
     * @return the value of tb_shop_store.province_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 省份编码，国标码，详见国家统计局数据 <p/>
     * This method sets the value of the database column tb_shop_store.province_code
     *
     * @param provinceCode the value for tb_shop_store.province_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * 城市编码，国标码，详见国家统计局数据 <p/>
     * This method returns the value of the database column tb_shop_store.city_code
     *
     * @return the value of tb_shop_store.city_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 城市编码，国标码，详见国家统计局数据 <p/>
     * This method sets the value of the database column tb_shop_store.city_code
     *
     * @param cityCode the value for tb_shop_store.city_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 区县编码，国标码，详见国家统计局数据 <p/>
     * This method returns the value of the database column tb_shop_store.district_code
     *
     * @return the value of tb_shop_store.district_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * 区县编码，国标码，详见国家统计局数据 <p/>
     * This method sets the value of the database column tb_shop_store.district_code
     *
     * @param districtCode the value for tb_shop_store.district_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    /**
     * 门店详细地址，地址字符长度在4-50个字符，注：不含省市区。例1：道路+门牌号，“人民东路18号”；例2：道路+门牌号+标志性建筑+楼层，“四川北路1552号欢乐广场1楼”。 <p/>
     * This method returns the value of the database column tb_shop_store.address
     *
     * @return the value of tb_shop_store.address
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getAddress() {
        return address;
    }

    /**
     * 门店详细地址，地址字符长度在4-50个字符，注：不含省市区。例1：道路+门牌号，“人民东路18号”；例2：道路+门牌号+标志性建筑+楼层，“四川北路1552号欢乐广场1楼”。 <p/>
     * This method sets the value of the database column tb_shop_store.address
     *
     * @param address the value for tb_shop_store.address
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 经度；最长15位字符（包括小数点）， 注：高德坐标系。 <p/>
     * This method returns the value of the database column tb_shop_store.longitude
     *
     * @return the value of tb_shop_store.longitude
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 经度；最长15位字符（包括小数点）， 注：高德坐标系。 <p/>
     * This method sets the value of the database column tb_shop_store.longitude
     *
     * @param longitude the value for tb_shop_store.longitude
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * 纬度；最长15位字符（包括小数点）， 注：高德坐标系。 <p/>
     * This method returns the value of the database column tb_shop_store.latitude
     *
     * @return the value of tb_shop_store.latitude
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 纬度；最长15位字符（包括小数点）， 注：高德坐标系。 <p/>
     * This method sets the value of the database column tb_shop_store.latitude
     *
     * @param latitude the value for tb_shop_store.latitude
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * 门店的签约ID <p/>
     * This method returns the value of the database column tb_shop_store.partner_id
     *
     * @return the value of tb_shop_store.partner_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 门店的签约ID <p/>
     * This method sets the value of the database column tb_shop_store.partner_id
     *
     * @param partnerId the value for tb_shop_store.partner_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 默认付款类型；如：付款码、扫码付、声波支付、在线买单、其它 <p/>
     * This method returns the value of the database column tb_shop_store.pay_type
     *
     * @return the value of tb_shop_store.pay_type
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 默认付款类型；如：付款码、扫码付、声波支付、在线买单、其它 <p/>
     * This method sets the value of the database column tb_shop_store.pay_type
     *
     * @param payType the value for tb_shop_store.pay_type
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * 门店创建来源；如：开放平台、支付宝客户端、口碑商家app、商家自主开店、服务商开店、全民开店-支付宝客户端、全民开店-商户app、其它 <p/>
     * This method returns the value of the database column tb_shop_store.create_channel
     *
     * @return the value of tb_shop_store.create_channel
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getCreateChannel() {
        return createChannel;
    }

    /**
     * 门店创建来源；如：开放平台、支付宝客户端、口碑商家app、商家自主开店、服务商开店、全民开店-支付宝客户端、全民开店-商户app、其它 <p/>
     * This method sets the value of the database column tb_shop_store.create_channel
     *
     * @param createChannel the value for tb_shop_store.create_channel
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setCreateChannel(String createChannel) {
        this.createChannel = createChannel == null ? null : createChannel.trim();
    }

    /**
     * 门店运营归属人uid <p/>
     * This method returns the value of the database column tb_shop_store.provider_xiaoer_uid
     *
     * @return the value of tb_shop_store.provider_xiaoer_uid
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getProviderXiaoerUid() {
        return providerXiaoerUid;
    }

    /**
     * 门店运营归属人uid <p/>
     * This method sets the value of the database column tb_shop_store.provider_xiaoer_uid
     *
     * @param providerXiaoerUid the value for tb_shop_store.provider_xiaoer_uid
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setProviderXiaoerUid(String providerXiaoerUid) {
        this.providerXiaoerUid = providerXiaoerUid == null ? null : providerXiaoerUid.trim();
    }

    /**
     * 门店电话号码；支持座机和手机，只支持数字和+-号，在客户端对用户展现， 支持多个电话， 以英文逗号分隔 <p/>
     * This method returns the value of the database column tb_shop_store.contact_number
     *
     * @return the value of tb_shop_store.contact_number
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * 门店电话号码；支持座机和手机，只支持数字和+-号，在客户端对用户展现， 支持多个电话， 以英文逗号分隔 <p/>
     * This method sets the value of the database column tb_shop_store.contact_number
     *
     * @param contactNumber the value for tb_shop_store.contact_number
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    /**
     * 门店店长电话号码；用于接收门店状态变更通知，收款成功通知等通知消息， 不在客户端展示。 <p/>
     * This method returns the value of the database column tb_shop_store.notify_mobile
     *
     * @return the value of tb_shop_store.notify_mobile
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getNotifyMobile() {
        return notifyMobile;
    }

    /**
     * 门店店长电话号码；用于接收门店状态变更通知，收款成功通知等通知消息， 不在客户端展示。 <p/>
     * This method sets the value of the database column tb_shop_store.notify_mobile
     *
     * @param notifyMobile the value for tb_shop_store.notify_mobile
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setNotifyMobile(String notifyMobile) {
        this.notifyMobile = notifyMobile == null ? null : notifyMobile.trim();
    }

    /**
     * 门店首图，非常重要，推荐尺寸2000*1500。 <p/>
     * This method returns the value of the database column tb_shop_store.main_image
     *
     * @return the value of tb_shop_store.main_image
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getMainImage() {
        return mainImage;
    }

    /**
     * 门店首图，非常重要，推荐尺寸2000*1500。 <p/>
     * This method sets the value of the database column tb_shop_store.main_image
     *
     * @param mainImage the value for tb_shop_store.main_image
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    /**
     * 门店收款二维码裸码。 <p/>
     * This method returns the value of the database column tb_shop_store.qr_code
     *
     * @return the value of tb_shop_store.qr_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     * 门店收款二维码裸码。 <p/>
     * This method sets the value of the database column tb_shop_store.qr_code
     *
     * @param qrCode the value for tb_shop_store.qr_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    /**
     * 经过加工后的门店收款二维码。 <p/>
     * This method returns the value of the database column tb_shop_store.processed_qr_code
     *
     * @return the value of tb_shop_store.processed_qr_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getProcessedQrCode() {
        return processedQrCode;
    }

    /**
     * 经过加工后的门店收款二维码。 <p/>
     * This method sets the value of the database column tb_shop_store.processed_qr_code
     *
     * @param processedQrCode the value for tb_shop_store.processed_qr_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setProcessedQrCode(String processedQrCode) {
        this.processedQrCode = processedQrCode == null ? null : processedQrCode.trim();
    }

    /**
     * 营业时间，支持分段营业时间，以英文逗号分隔。 <p/>
     * This method returns the value of the database column tb_shop_store.business_time
     *
     * @return the value of tb_shop_store.business_time
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getBusinessTime() {
        return businessTime;
    }

    /**
     * 营业时间，支持分段营业时间，以英文逗号分隔。 <p/>
     * This method sets the value of the database column tb_shop_store.business_time
     *
     * @param businessTime the value for tb_shop_store.business_time
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime == null ? null : businessTime.trim();
    }

    /**
     * 门店是否支持WIFI，T表示支持，F表示不支持，不传在客户端不作展示。 <p/>
     * This method returns the value of the database column tb_shop_store.wifi
     *
     * @return the value of tb_shop_store.wifi
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getWifi() {
        return wifi;
    }

    /**
     * 门店是否支持WIFI，T表示支持，F表示不支持，不传在客户端不作展示。 <p/>
     * This method sets the value of the database column tb_shop_store.wifi
     *
     * @param wifi the value for tb_shop_store.wifi
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setWifi(String wifi) {
        this.wifi = wifi == null ? null : wifi.trim();
    }

    /**
     * 门店是否支持停车，T表示支持，F表示不支持，不传在客户端不作展示。 <p/>
     * This method returns the value of the database column tb_shop_store.parking
     *
     * @return the value of tb_shop_store.parking
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getParking() {
        return parking;
    }

    /**
     * 门店是否支持停车，T表示支持，F表示不支持，不传在客户端不作展示。 <p/>
     * This method sets the value of the database column tb_shop_store.parking
     *
     * @param parking the value for tb_shop_store.parking
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setParking(String parking) {
        this.parking = parking == null ? null : parking.trim();
    }

    /**
     * 门店其他的服务，门店与用户线下兑现。	免费茶水、免费糖果 <p/>
     * This method returns the value of the database column tb_shop_store.value_added
     *
     * @return the value of tb_shop_store.value_added
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getValueAdded() {
        return valueAdded;
    }

    /**
     * 门店其他的服务，门店与用户线下兑现。	免费茶水、免费糖果 <p/>
     * This method sets the value of the database column tb_shop_store.value_added
     *
     * @param valueAdded the value for tb_shop_store.value_added
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setValueAdded(String valueAdded) {
        this.valueAdded = valueAdded == null ? null : valueAdded.trim();
    }

    /**
     * 人均消费价格，最少1元，最大不超过99999元，请按实际情况填写；单位元，不需填写单位。 <p/>
     * This method returns the value of the database column tb_shop_store.avg_price
     *
     * @return the value of tb_shop_store.avg_price
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getAvgPrice() {
        return avgPrice;
    }

    /**
     * 人均消费价格，最少1元，最大不超过99999元，请按实际情况填写；单位元，不需填写单位。 <p/>
     * This method sets the value of the database column tb_shop_store.avg_price
     *
     * @param avgPrice the value for tb_shop_store.avg_price
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice == null ? null : avgPrice.trim();
    }

    /**
     * ISV返佣id，门店创建、或者门店交易的返佣将通过此账号反给ISV，如果有口碑签订了返佣协议，则该字段作为返佣数据提取的依据。此字段必须是个合法uid，2088开头的16位支付宝会员账号，如果传入错误将无法创建门店。 <p/>
     * This method returns the value of the database column tb_shop_store.isv_uid
     *
     * @return the value of tb_shop_store.isv_uid
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getIsvUid() {
        return isvUid;
    }

    /**
     * ISV返佣id，门店创建、或者门店交易的返佣将通过此账号反给ISV，如果有口碑签订了返佣协议，则该字段作为返佣数据提取的依据。此字段必须是个合法uid，2088开头的16位支付宝会员账号，如果传入错误将无法创建门店。 <p/>
     * This method sets the value of the database column tb_shop_store.isv_uid
     *
     * @param isvUid the value for tb_shop_store.isv_uid
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setIsvUid(String isvUid) {
        this.isvUid = isvUid == null ? null : isvUid.trim();
    }

    /**
     * 门店营业执照图片，各行业所需的证照资质参见商户入驻要求。 <p/>
     * This method returns the value of the database column tb_shop_store.licence
     *
     * @return the value of tb_shop_store.licence
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getLicence() {
        return licence;
    }

    /**
     * 门店营业执照图片，各行业所需的证照资质参见商户入驻要求。 <p/>
     * This method sets the value of the database column tb_shop_store.licence
     *
     * @param licence the value for tb_shop_store.licence
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setLicence(String licence) {
        this.licence = licence == null ? null : licence.trim();
    }

    /**
     * 门店营业执照编号，营业执照信息与is_operating_online至少填一项。 <p/>
     * This method returns the value of the database column tb_shop_store.licence_code
     *
     * @return the value of tb_shop_store.licence_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getLicenceCode() {
        return licenceCode;
    }

    /**
     * 门店营业执照编号，营业执照信息与is_operating_online至少填一项。 <p/>
     * This method sets the value of the database column tb_shop_store.licence_code
     *
     * @param licenceCode the value for tb_shop_store.licence_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setLicenceCode(String licenceCode) {
        this.licenceCode = licenceCode == null ? null : licenceCode.trim();
    }

    /**
     * 门店营业执照名称。 <p/>
     * This method returns the value of the database column tb_shop_store.licence_name
     *
     * @return the value of tb_shop_store.licence_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getLicenceName() {
        return licenceName;
    }

    /**
     * 门店营业执照名称。 <p/>
     * This method sets the value of the database column tb_shop_store.licence_name
     *
     * @param licenceName the value for tb_shop_store.licence_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setLicenceName(String licenceName) {
        this.licenceName = licenceName == null ? null : licenceName.trim();
    }

    /**
     * 人许可证，各行业所需的证照资质参见商户入驻要求；该字段只能上传一张许可证，一张以外的许可证、除营业执照和许可证之外其他证照请放在其他资质字段上传。 <p/>
     * This method returns the value of the database column tb_shop_store.business_certificate
     *
     * @return the value of tb_shop_store.business_certificate
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getBusinessCertificate() {
        return businessCertificate;
    }

    /**
     * 人许可证，各行业所需的证照资质参见商户入驻要求；该字段只能上传一张许可证，一张以外的许可证、除营业执照和许可证之外其他证照请放在其他资质字段上传。 <p/>
     * This method sets the value of the database column tb_shop_store.business_certificate
     *
     * @param businessCertificate the value for tb_shop_store.business_certificate
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setBusinessCertificate(String businessCertificate) {
        this.businessCertificate = businessCertificate == null ? null : businessCertificate.trim();
    }

    /**
     * 许可证有效期，格式：2020-03-20 <p/>
     * This method returns the value of the database column tb_shop_store.business_certificate_expires
     *
     * @return the value of tb_shop_store.business_certificate_expires
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getBusinessCertificateExpires() {
        return businessCertificateExpires;
    }

    /**
     * 许可证有效期，格式：2020-03-20 <p/>
     * This method sets the value of the database column tb_shop_store.business_certificate_expires
     *
     * @param businessCertificateExpires the value for tb_shop_store.business_certificate_expires
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setBusinessCertificateExpires(String businessCertificateExpires) {
        this.businessCertificateExpires = businessCertificateExpires == null ? null : businessCertificateExpires.trim();
    }

    /**
     * 门店授权函,营业执照与签约账号主体不一致时需要。 <p/>
     * This method returns the value of the database column tb_shop_store.auth_letter
     *
     * @return the value of tb_shop_store.auth_letter
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getAuthLetter() {
        return authLetter;
    }

    /**
     * 门店授权函,营业执照与签约账号主体不一致时需要。 <p/>
     * This method sets the value of the database column tb_shop_store.auth_letter
     *
     * @param authLetter the value for tb_shop_store.auth_letter
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setAuthLetter(String authLetter) {
        this.authLetter = authLetter == null ? null : authLetter.trim();
    }

    /**
     * 当商户的门店审核状态发生变化时，会向该地址推送消息。 <p/>
     * This method returns the value of the database column tb_shop_store.operate_notify_url
     *
     * @return the value of tb_shop_store.operate_notify_url
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getOperateNotifyUrl() {
        return operateNotifyUrl;
    }

    /**
     * 当商户的门店审核状态发生变化时，会向该地址推送消息。 <p/>
     * This method sets the value of the database column tb_shop_store.operate_notify_url
     *
     * @param operateNotifyUrl the value for tb_shop_store.operate_notify_url
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setOperateNotifyUrl(String operateNotifyUrl) {
        this.operateNotifyUrl = operateNotifyUrl == null ? null : operateNotifyUrl.trim();
    }

    /**
     * 机具号，多个之间以英文逗号分隔。 <p/>
     * This method returns the value of the database column tb_shop_store.implement_id
     *
     * @return the value of tb_shop_store.implement_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getImplementId() {
        return implementId;
    }

    /**
     * 机具号，多个之间以英文逗号分隔。 <p/>
     * This method sets the value of the database column tb_shop_store.implement_id
     *
     * @param implementId the value for tb_shop_store.implement_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setImplementId(String implementId) {
        this.implementId = implementId == null ? null : implementId.trim();
    }

    /**
     * 支持英文字母和数字，由开发者自行定义（不允许重复），在门店notify消息中也会带有该参数，以此标明本次notify消息是对哪个请求的回应。 <p/>
     * This method returns the value of the database column tb_shop_store.request_id
     *
     * @return the value of tb_shop_store.request_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * 支持英文字母和数字，由开发者自行定义（不允许重复），在门店notify消息中也会带有该参数，以此标明本次notify消息是对哪个请求的回应。 <p/>
     * This method sets the value of the database column tb_shop_store.request_id
     *
     * @param requestId the value for tb_shop_store.request_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * 其他资质。用于上传营业证照、许可证照外的其他资质，除已上传许可证外的其他许可证也可以在该字段上传。 <p/>
     * This method returns the value of the database column tb_shop_store.other_authorization
     *
     * @return the value of tb_shop_store.other_authorization
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getOtherAuthorization() {
        return otherAuthorization;
    }

    /**
     * 其他资质。用于上传营业证照、许可证照外的其他资质，除已上传许可证外的其他许可证也可以在该字段上传。 <p/>
     * This method sets the value of the database column tb_shop_store.other_authorization
     *
     * @param otherAuthorization the value for tb_shop_store.other_authorization
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setOtherAuthorization(String otherAuthorization) {
        this.otherAuthorization = otherAuthorization == null ? null : otherAuthorization.trim();
    }

    /**
     * 营业执照过期时间。 <p/>
     * This method returns the value of the database column tb_shop_store.licence_expires
     *
     * @return the value of tb_shop_store.licence_expires
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getLicenceExpires() {
        return licenceExpires;
    }

    /**
     * 营业执照过期时间。 <p/>
     * This method sets the value of the database column tb_shop_store.licence_expires
     *
     * @param licenceExpires the value for tb_shop_store.licence_expires
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setLicenceExpires(String licenceExpires) {
        this.licenceExpires = licenceExpires == null ? null : licenceExpires.trim();
    }

    /**
     * 表示以系统集成商的身份开店，开放平台现在统一传入ISV 默认商户操作:MERCHANT；服务商操作：PROVIDER。支付宝内部使用，外部商户不需填写此字段 <p/>
     * This method returns the value of the database column tb_shop_store.op_role
     *
     * @return the value of tb_shop_store.op_role
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getOpRole() {
        return opRole;
    }

    /**
     * 表示以系统集成商的身份开店，开放平台现在统一传入ISV 默认商户操作:MERCHANT；服务商操作：PROVIDER。支付宝内部使用，外部商户不需填写此字段 <p/>
     * This method sets the value of the database column tb_shop_store.op_role
     *
     * @param opRole the value for tb_shop_store.op_role
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setOpRole(String opRole) {
        this.opRole = opRole == null ? null : opRole.trim();
    }

    /**
     * 店铺接口业务版本号，新接入的ISV，请统一传入2.0 <p/>
     * This method returns the value of the database column tb_shop_store.biz_version
     *
     * @return the value of tb_shop_store.biz_version
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getBizVersion() {
        return bizVersion;
    }

    /**
     * 店铺接口业务版本号，新接入的ISV，请统一传入2.0 <p/>
     * This method sets the value of the database column tb_shop_store.biz_version
     *
     * @param bizVersion the value for tb_shop_store.biz_version
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setBizVersion(String bizVersion) {
        this.bizVersion = bizVersion == null ? null : bizVersion.trim();
    }

    /**
     * 开店请求受理成功后返回的支付宝流水ID，根据此ID调用接口 alipay.offline.market.applyorder.batchquery，能够获取当前开店请求审核状态、驳回原因等信息。 <p/>
     * This method returns the value of the database column tb_shop_store.apply_id
     *
     * @return the value of tb_shop_store.apply_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getApplyId() {
        return applyId;
    }

    /**
     * 开店请求受理成功后返回的支付宝流水ID，根据此ID调用接口 alipay.offline.market.applyorder.batchquery，能够获取当前开店请求审核状态、驳回原因等信息。 <p/>
     * This method sets the value of the database column tb_shop_store.apply_id
     *
     * @param applyId the value for tb_shop_store.apply_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    /**
     * 门店审核状态，对于系统商而言，只有三个状态，AUDITING：审核中，AUDIT_FAILED：审核驳回，AUDIT_SUCCESS：审核通过。第一次审核通过会触发门店上架 <p/>
     * This method returns the value of the database column tb_shop_store.audit_status
     *
     * @return the value of tb_shop_store.audit_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 门店审核状态，对于系统商而言，只有三个状态，AUDITING：审核中，AUDIT_FAILED：审核驳回，AUDIT_SUCCESS：审核通过。第一次审核通过会触发门店上架 <p/>
     * This method sets the value of the database column tb_shop_store.audit_status
     *
     * @param auditStatus the value for tb_shop_store.audit_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    /**
     * 门店审核状态描述，如果审核驳回则有相关的驳回理由 <p/>
     * This method returns the value of the database column tb_shop_store.audit_desc
     *
     * @return the value of tb_shop_store.audit_desc
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getAuditDesc() {
        return auditDesc;
    }

    /**
     * 门店审核状态描述，如果审核驳回则有相关的驳回理由 <p/>
     * This method sets the value of the database column tb_shop_store.audit_desc
     *
     * @param auditDesc the value for tb_shop_store.audit_desc
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc == null ? null : auditDesc.trim();
    }

    /**
     * 是否有无烟区，T表示有无烟区，F表示没有无烟区，不传在客户端不展示。 <p/>
     * This method returns the value of the database column tb_shop_store.no_smoking
     *
     * @return the value of tb_shop_store.no_smoking
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getNoSmoking() {
        return noSmoking;
    }

    /**
     * 是否有无烟区，T表示有无烟区，F表示没有无烟区，不传在客户端不展示。 <p/>
     * This method sets the value of the database column tb_shop_store.no_smoking
     *
     * @param noSmoking the value for tb_shop_store.no_smoking
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setNoSmoking(String noSmoking) {
        this.noSmoking = noSmoking == null ? null : noSmoking.trim();
    }

    /**
     * 门店是否有包厢，T表示有，F表示没有，不传在客户端不作展示。 <p/>
     * This method returns the value of the database column tb_shop_store.box
     *
     * @return the value of tb_shop_store.box
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getBox() {
        return box;
    }

    /**
     * 门店是否有包厢，T表示有，F表示没有，不传在客户端不作展示。 <p/>
     * This method sets the value of the database column tb_shop_store.box
     *
     * @param box the value for tb_shop_store.box
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setBox(String box) {
        this.box = box == null ? null : box.trim();
    }

    /**
     * 是否在其他平台开店，T表示有开店，F表示未开店。 <p/>
     * This method returns the value of the database column tb_shop_store.is_operating_online
     *
     * @return the value of tb_shop_store.is_operating_online
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getIsOperatingOnline() {
        return isOperatingOnline;
    }

    /**
     * 是否在其他平台开店，T表示有开店，F表示未开店。 <p/>
     * This method sets the value of the database column tb_shop_store.is_operating_online
     *
     * @param isOperatingOnline the value for tb_shop_store.is_operating_online
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setIsOperatingOnline(String isOperatingOnline) {
        this.isOperatingOnline = isOperatingOnline == null ? null : isOperatingOnline.trim();
    }

    /**
     * 门店是否上架，T表示上架,F表示未上架，第一次门店审核通过后会触发上架。 <p/>
     * This method returns the value of the database column tb_shop_store.is_online
     *
     * @return the value of tb_shop_store.is_online
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getIsOnline() {
        return isOnline;
    }

    /**
     * 门店是否上架，T表示上架,F表示未上架，第一次门店审核通过后会触发上架。 <p/>
     * This method sets the value of the database column tb_shop_store.is_online
     *
     * @param isOnline the value for tb_shop_store.is_online
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline == null ? null : isOnline.trim();
    }

    /**
     * 门店是否在客户端显示，T表示显示，F表示隐藏。 <p/>
     * This method returns the value of the database column tb_shop_store.is_show
     *
     * @return the value of tb_shop_store.is_show
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 门店是否在客户端显示，T表示显示，F表示隐藏。 <p/>
     * This method sets the value of the database column tb_shop_store.is_show
     *
     * @param isShow the value for tb_shop_store.is_show
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    /**
     * 门店创建时间 <p/>
     * This method returns the value of the database column tb_shop_store.gmt_shop_create
     *
     * @return the value of tb_shop_store.gmt_shop_create
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getGmtShopCreate() {
        return gmtShopCreate;
    }

    /**
     * 门店创建时间 <p/>
     * This method sets the value of the database column tb_shop_store.gmt_shop_create
     *
     * @param gmtShopCreate the value for tb_shop_store.gmt_shop_create
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setGmtShopCreate(String gmtShopCreate) {
        this.gmtShopCreate = gmtShopCreate == null ? null : gmtShopCreate.trim();
    }

    /**
     * 门店修改时间 <p/>
     * This method returns the value of the database column tb_shop_store.gmt_shop_modified
     *
     * @return the value of tb_shop_store.gmt_shop_modified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getGmtShopModified() {
        return gmtShopModified;
    }

    /**
     * 门店修改时间 <p/>
     * This method sets the value of the database column tb_shop_store.gmt_shop_modified
     *
     * @param gmtShopModified the value for tb_shop_store.gmt_shop_modified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setGmtShopModified(String gmtShopModified) {
        this.gmtShopModified = gmtShopModified == null ? null : gmtShopModified.trim();
    }

    /**
     * 门店状态：OPEN（营业）、PAUSED（暂停）、INIT（初始）、FREEZE（冻结）、CLOSED（关店） <p/>
     * This method returns the value of the database column tb_shop_store.status
     *
     * @return the value of tb_shop_store.status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * 门店状态：OPEN（营业）、PAUSED（暂停）、INIT（初始）、FREEZE（冻结）、CLOSED（关店） <p/>
     * This method sets the value of the database column tb_shop_store.status
     *
     * @param status the value for tb_shop_store.status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shop_store.created
     *
     * @return the value of tb_shop_store.created
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shop_store.created
     *
     * @param created the value for tb_shop_store.created
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shop_store.modified
     *
     * @return the value of tb_shop_store.modified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Date getModified() {
        return modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shop_store.modified
     *
     * @param modified the value for tb_shop_store.modified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_shop_store.enable_status
     *
     * @return the value of tb_shop_store.enable_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Boolean getEnableStatus() {
        return enableStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_shop_store.enable_status
     *
     * @param enableStatus the value for tb_shop_store.enable_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setEnableStatus(Boolean enableStatus) {
        this.enableStatus = enableStatus;
    }
}