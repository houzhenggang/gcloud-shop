package com.gcloud.shop.domain;

import java.util.Date;

public class AlipayUser {
    /**
     * 主键 <p/>
     * This field corresponds to the database column tb_alipay_user.id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Long id;

    /**
     * 授权商户的user_id  <p/>
     * This field corresponds to the database column tb_alipay_user.user_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String userId;

    /**
     * 用户头像 <p/>
     * This field corresponds to the database column tb_alipay_user.avatar
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String avatar;

    /**
     * 用户类型（1/2） 1代表公司账户2代表个人账户  <p/>
     * This field corresponds to the database column tb_alipay_user.user_type_value
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String userTypeValue;

    /**
     * 用户状态（Q/T/B/W）。 Q代表快速注册用户 T代表已认证用户 B代表被冻结账户 W代表已注册，未激活的账户  <p/>
     * This field corresponds to the database column tb_alipay_user.user_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String userStatus;

    /**
     * 公司名称（用户类型是公司类型时公司名称才有此字段）。  <p/>
     * This field corresponds to the database column tb_alipay_user.firm_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String firmName;

    /**
     * 用户的真实姓名 <p/>
     * This field corresponds to the database column tb_alipay_user.real_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String realName;

    /**
     * 用户支付宝账号绑定的邮箱地址 <p/>
     * This field corresponds to the database column tb_alipay_user.email
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String email;

    /**
     * 证件号码 <p/>
     * This field corresponds to the database column tb_alipay_user.cert_no
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String certNo;

    /**
     * 性别（F：女性；M：男性） <p/>
     * This field corresponds to the database column tb_alipay_user.gender
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String gender;

    /**
     * 电话号码 <p/>
     * This field corresponds to the database column tb_alipay_user.phone
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String phone;

    /**
     * 手机号码 <p/>
     * This field corresponds to the database column tb_alipay_user.mobile
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String mobile;

    /**
     * 是否通过实名认证。T是通过 F是没有实名认证 <p/>
     * This field corresponds to the database column tb_alipay_user.is_certified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String isCertified;

    /**
     * T为是银行卡认证，F为非银行卡认证。 <p/>
     * This field corresponds to the database column tb_alipay_user.is_bank_auth
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String isBankAuth;

    /**
     * T为是身份证认证，F为非身份证认证。 <p/>
     * This field corresponds to the database column tb_alipay_user.is_id_auth
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String isIdAuth;

    /**
     * T为是手机认证，F为非手机认证。  <p/>
     * This field corresponds to the database column tb_alipay_user.is_mobile_auth
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String isMobileAuth;

    /**
     * T为通过营业执照认证，F为没有通过 <p/>
     * This field corresponds to the database column tb_alipay_user.is_licence_auth
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String isLicenceAuth;

    /**
     * 0:身份证 1:护照 2:军官证 3:士兵证 4:回乡证 5:临时身份证 6:户口簿 7:警官证 8:台胞证 9:营业执照 10其它证件  <p/>
     * This field corresponds to the database column tb_alipay_user.cert_type_value
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String certTypeValue;

    /**
     * 收货地址的联系人固定电话0517-28888888 <p/>
     * This field corresponds to the database column tb_alipay_user.deliver_phone
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String deliverPhone;

    /**
     * 收货地址的联系人移动电话131XXXXXXXX <p/>
     * This field corresponds to the database column tb_alipay_user.deliver_mobile
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String deliverMobile;

    /**
     * 收货人全名  <p/>
     * This field corresponds to the database column tb_alipay_user.deliver_fullname
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String deliverFullname;

    /**
     * 是否默认收货地址 <p/>
     * This field corresponds to the database column tb_alipay_user.default_deliver_address
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String defaultDeliverAddress;

    /**
     * 省份名称 <p/>
     * This field corresponds to the database column tb_alipay_user.province
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String province;

    /**
     * 市名称 <p/>
     * This field corresponds to the database column tb_alipay_user.city
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String city;

    /**
     * 区县名称 <p/>
     * This field corresponds to the database column tb_alipay_user.area
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String area;

    /**
     * 地址 <p/>
     * This field corresponds to the database column tb_alipay_user.address
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String address;

    /**
     * 邮政编码 <p/>
     * This field corresponds to the database column tb_alipay_user.zip
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String zip;

    /**
     * 收货人所在省份 <p/>
     * This field corresponds to the database column tb_alipay_user.deliver_province
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String deliverProvince;

    /**
     * 收货人所在城市 <p/>
     * This field corresponds to the database column tb_alipay_user.deliver_city
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String deliverCity;

    /**
     * 收货人所在区县 <p/>
     * This field corresponds to the database column tb_alipay_user.deliver_area
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String deliverArea;

    /**
     * 区域编码 <p/>
     * This field corresponds to the database column tb_alipay_user.address_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String addressCode;

    /**
     * 是否是学生 T为是手机认证，F为非手机认证。  <p/>
     * This field corresponds to the database column tb_alipay_user.is_student_certified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String isStudentCertified;

    /**
     * T：表示A类实名认证；F：表示非A类实名认证  <p/>
     * This field corresponds to the database column tb_alipay_user.is_certify_grade_a
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String isCertifyGradeA;

    /**
     * 支付宝用户ID  <p/>
     * This field corresponds to the database column tb_alipay_user.alipay_user_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String alipayUserId;

    /**
     * 用户生日(19900918) <p/>
     * This field corresponds to the database column tb_alipay_user.birthday
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String birthday;

    /**
     * 用户昵称 <p/>
     * This field corresponds to the database column tb_alipay_user.nick_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String nickName;

    /**
     * 姓氏，取的是realName中的首个字符，对非中文、中文复姓支持较差。 <p/>
     * This field corresponds to the database column tb_alipay_user.family_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String familyName;

    /**
     * 生日的月和日，MMdd格式 <p/>
     * This field corresponds to the database column tb_alipay_user.reduced_birthday
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String reducedBirthday;

    /**
     * T--被冻结；F--未冻结 <p/>
     * This field corresponds to the database column tb_alipay_user.is_balance_frozen
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String isBalanceFrozen;

    /**
     * 注意】当is_balance_frozen为“F”时，改字段不会返回.  <p/>
     * This field corresponds to the database column tb_alipay_user.balance_freeze_type
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private String balanceFreezeType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_alipay_user.created
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_alipay_user.modified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Date modified;

    /**
     * 0否 1是 <p/>
     * This field corresponds to the database column tb_alipay_user.enable_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    private Boolean enableStatus;

    /**
     * 主键 <p/>
     * This method returns the value of the database column tb_alipay_user.id
     *
     * @return the value of tb_alipay_user.id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键 <p/>
     * This method sets the value of the database column tb_alipay_user.id
     *
     * @param id the value for tb_alipay_user.id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 授权商户的user_id  <p/>
     * This method returns the value of the database column tb_alipay_user.user_id
     *
     * @return the value of tb_alipay_user.user_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 授权商户的user_id  <p/>
     * This method sets the value of the database column tb_alipay_user.user_id
     *
     * @param userId the value for tb_alipay_user.user_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 用户头像 <p/>
     * This method returns the value of the database column tb_alipay_user.avatar
     *
     * @return the value of tb_alipay_user.avatar
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 用户头像 <p/>
     * This method sets the value of the database column tb_alipay_user.avatar
     *
     * @param avatar the value for tb_alipay_user.avatar
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 用户类型（1/2） 1代表公司账户2代表个人账户  <p/>
     * This method returns the value of the database column tb_alipay_user.user_type_value
     *
     * @return the value of tb_alipay_user.user_type_value
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getUserTypeValue() {
        return userTypeValue;
    }

    /**
     * 用户类型（1/2） 1代表公司账户2代表个人账户  <p/>
     * This method sets the value of the database column tb_alipay_user.user_type_value
     *
     * @param userTypeValue the value for tb_alipay_user.user_type_value
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setUserTypeValue(String userTypeValue) {
        this.userTypeValue = userTypeValue == null ? null : userTypeValue.trim();
    }

    /**
     * 用户状态（Q/T/B/W）。 Q代表快速注册用户 T代表已认证用户 B代表被冻结账户 W代表已注册，未激活的账户  <p/>
     * This method returns the value of the database column tb_alipay_user.user_status
     *
     * @return the value of tb_alipay_user.user_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 用户状态（Q/T/B/W）。 Q代表快速注册用户 T代表已认证用户 B代表被冻结账户 W代表已注册，未激活的账户  <p/>
     * This method sets the value of the database column tb_alipay_user.user_status
     *
     * @param userStatus the value for tb_alipay_user.user_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    /**
     * 公司名称（用户类型是公司类型时公司名称才有此字段）。  <p/>
     * This method returns the value of the database column tb_alipay_user.firm_name
     *
     * @return the value of tb_alipay_user.firm_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getFirmName() {
        return firmName;
    }

    /**
     * 公司名称（用户类型是公司类型时公司名称才有此字段）。  <p/>
     * This method sets the value of the database column tb_alipay_user.firm_name
     *
     * @param firmName the value for tb_alipay_user.firm_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setFirmName(String firmName) {
        this.firmName = firmName == null ? null : firmName.trim();
    }

    /**
     * 用户的真实姓名 <p/>
     * This method returns the value of the database column tb_alipay_user.real_name
     *
     * @return the value of tb_alipay_user.real_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 用户的真实姓名 <p/>
     * This method sets the value of the database column tb_alipay_user.real_name
     *
     * @param realName the value for tb_alipay_user.real_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 用户支付宝账号绑定的邮箱地址 <p/>
     * This method returns the value of the database column tb_alipay_user.email
     *
     * @return the value of tb_alipay_user.email
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getEmail() {
        return email;
    }

    /**
     * 用户支付宝账号绑定的邮箱地址 <p/>
     * This method sets the value of the database column tb_alipay_user.email
     *
     * @param email the value for tb_alipay_user.email
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 证件号码 <p/>
     * This method returns the value of the database column tb_alipay_user.cert_no
     *
     * @return the value of tb_alipay_user.cert_no
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * 证件号码 <p/>
     * This method sets the value of the database column tb_alipay_user.cert_no
     *
     * @param certNo the value for tb_alipay_user.cert_no
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    /**
     * 性别（F：女性；M：男性） <p/>
     * This method returns the value of the database column tb_alipay_user.gender
     *
     * @return the value of tb_alipay_user.gender
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getGender() {
        return gender;
    }

    /**
     * 性别（F：女性；M：男性） <p/>
     * This method sets the value of the database column tb_alipay_user.gender
     *
     * @param gender the value for tb_alipay_user.gender
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 电话号码 <p/>
     * This method returns the value of the database column tb_alipay_user.phone
     *
     * @return the value of tb_alipay_user.phone
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话号码 <p/>
     * This method sets the value of the database column tb_alipay_user.phone
     *
     * @param phone the value for tb_alipay_user.phone
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 手机号码 <p/>
     * This method returns the value of the database column tb_alipay_user.mobile
     *
     * @return the value of tb_alipay_user.mobile
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号码 <p/>
     * This method sets the value of the database column tb_alipay_user.mobile
     *
     * @param mobile the value for tb_alipay_user.mobile
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 是否通过实名认证。T是通过 F是没有实名认证 <p/>
     * This method returns the value of the database column tb_alipay_user.is_certified
     *
     * @return the value of tb_alipay_user.is_certified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getIsCertified() {
        return isCertified;
    }

    /**
     * 是否通过实名认证。T是通过 F是没有实名认证 <p/>
     * This method sets the value of the database column tb_alipay_user.is_certified
     *
     * @param isCertified the value for tb_alipay_user.is_certified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setIsCertified(String isCertified) {
        this.isCertified = isCertified == null ? null : isCertified.trim();
    }

    /**
     * T为是银行卡认证，F为非银行卡认证。 <p/>
     * This method returns the value of the database column tb_alipay_user.is_bank_auth
     *
     * @return the value of tb_alipay_user.is_bank_auth
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getIsBankAuth() {
        return isBankAuth;
    }

    /**
     * T为是银行卡认证，F为非银行卡认证。 <p/>
     * This method sets the value of the database column tb_alipay_user.is_bank_auth
     *
     * @param isBankAuth the value for tb_alipay_user.is_bank_auth
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setIsBankAuth(String isBankAuth) {
        this.isBankAuth = isBankAuth == null ? null : isBankAuth.trim();
    }

    /**
     * T为是身份证认证，F为非身份证认证。 <p/>
     * This method returns the value of the database column tb_alipay_user.is_id_auth
     *
     * @return the value of tb_alipay_user.is_id_auth
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getIsIdAuth() {
        return isIdAuth;
    }

    /**
     * T为是身份证认证，F为非身份证认证。 <p/>
     * This method sets the value of the database column tb_alipay_user.is_id_auth
     *
     * @param isIdAuth the value for tb_alipay_user.is_id_auth
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setIsIdAuth(String isIdAuth) {
        this.isIdAuth = isIdAuth == null ? null : isIdAuth.trim();
    }

    /**
     * T为是手机认证，F为非手机认证。  <p/>
     * This method returns the value of the database column tb_alipay_user.is_mobile_auth
     *
     * @return the value of tb_alipay_user.is_mobile_auth
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getIsMobileAuth() {
        return isMobileAuth;
    }

    /**
     * T为是手机认证，F为非手机认证。  <p/>
     * This method sets the value of the database column tb_alipay_user.is_mobile_auth
     *
     * @param isMobileAuth the value for tb_alipay_user.is_mobile_auth
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setIsMobileAuth(String isMobileAuth) {
        this.isMobileAuth = isMobileAuth == null ? null : isMobileAuth.trim();
    }

    /**
     * T为通过营业执照认证，F为没有通过 <p/>
     * This method returns the value of the database column tb_alipay_user.is_licence_auth
     *
     * @return the value of tb_alipay_user.is_licence_auth
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getIsLicenceAuth() {
        return isLicenceAuth;
    }

    /**
     * T为通过营业执照认证，F为没有通过 <p/>
     * This method sets the value of the database column tb_alipay_user.is_licence_auth
     *
     * @param isLicenceAuth the value for tb_alipay_user.is_licence_auth
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setIsLicenceAuth(String isLicenceAuth) {
        this.isLicenceAuth = isLicenceAuth == null ? null : isLicenceAuth.trim();
    }

    /**
     * 0:身份证 1:护照 2:军官证 3:士兵证 4:回乡证 5:临时身份证 6:户口簿 7:警官证 8:台胞证 9:营业执照 10其它证件  <p/>
     * This method returns the value of the database column tb_alipay_user.cert_type_value
     *
     * @return the value of tb_alipay_user.cert_type_value
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getCertTypeValue() {
        return certTypeValue;
    }

    /**
     * 0:身份证 1:护照 2:军官证 3:士兵证 4:回乡证 5:临时身份证 6:户口簿 7:警官证 8:台胞证 9:营业执照 10其它证件  <p/>
     * This method sets the value of the database column tb_alipay_user.cert_type_value
     *
     * @param certTypeValue the value for tb_alipay_user.cert_type_value
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setCertTypeValue(String certTypeValue) {
        this.certTypeValue = certTypeValue == null ? null : certTypeValue.trim();
    }

    /**
     * 收货地址的联系人固定电话0517-28888888 <p/>
     * This method returns the value of the database column tb_alipay_user.deliver_phone
     *
     * @return the value of tb_alipay_user.deliver_phone
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getDeliverPhone() {
        return deliverPhone;
    }

    /**
     * 收货地址的联系人固定电话0517-28888888 <p/>
     * This method sets the value of the database column tb_alipay_user.deliver_phone
     *
     * @param deliverPhone the value for tb_alipay_user.deliver_phone
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setDeliverPhone(String deliverPhone) {
        this.deliverPhone = deliverPhone == null ? null : deliverPhone.trim();
    }

    /**
     * 收货地址的联系人移动电话131XXXXXXXX <p/>
     * This method returns the value of the database column tb_alipay_user.deliver_mobile
     *
     * @return the value of tb_alipay_user.deliver_mobile
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getDeliverMobile() {
        return deliverMobile;
    }

    /**
     * 收货地址的联系人移动电话131XXXXXXXX <p/>
     * This method sets the value of the database column tb_alipay_user.deliver_mobile
     *
     * @param deliverMobile the value for tb_alipay_user.deliver_mobile
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setDeliverMobile(String deliverMobile) {
        this.deliverMobile = deliverMobile == null ? null : deliverMobile.trim();
    }

    /**
     * 收货人全名  <p/>
     * This method returns the value of the database column tb_alipay_user.deliver_fullname
     *
     * @return the value of tb_alipay_user.deliver_fullname
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getDeliverFullname() {
        return deliverFullname;
    }

    /**
     * 收货人全名  <p/>
     * This method sets the value of the database column tb_alipay_user.deliver_fullname
     *
     * @param deliverFullname the value for tb_alipay_user.deliver_fullname
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setDeliverFullname(String deliverFullname) {
        this.deliverFullname = deliverFullname == null ? null : deliverFullname.trim();
    }

    /**
     * 是否默认收货地址 <p/>
     * This method returns the value of the database column tb_alipay_user.default_deliver_address
     *
     * @return the value of tb_alipay_user.default_deliver_address
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getDefaultDeliverAddress() {
        return defaultDeliverAddress;
    }

    /**
     * 是否默认收货地址 <p/>
     * This method sets the value of the database column tb_alipay_user.default_deliver_address
     *
     * @param defaultDeliverAddress the value for tb_alipay_user.default_deliver_address
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setDefaultDeliverAddress(String defaultDeliverAddress) {
        this.defaultDeliverAddress = defaultDeliverAddress == null ? null : defaultDeliverAddress.trim();
    }

    /**
     * 省份名称 <p/>
     * This method returns the value of the database column tb_alipay_user.province
     *
     * @return the value of tb_alipay_user.province
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省份名称 <p/>
     * This method sets the value of the database column tb_alipay_user.province
     *
     * @param province the value for tb_alipay_user.province
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 市名称 <p/>
     * This method returns the value of the database column tb_alipay_user.city
     *
     * @return the value of tb_alipay_user.city
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getCity() {
        return city;
    }

    /**
     * 市名称 <p/>
     * This method sets the value of the database column tb_alipay_user.city
     *
     * @param city the value for tb_alipay_user.city
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 区县名称 <p/>
     * This method returns the value of the database column tb_alipay_user.area
     *
     * @return the value of tb_alipay_user.area
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getArea() {
        return area;
    }

    /**
     * 区县名称 <p/>
     * This method sets the value of the database column tb_alipay_user.area
     *
     * @param area the value for tb_alipay_user.area
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 地址 <p/>
     * This method returns the value of the database column tb_alipay_user.address
     *
     * @return the value of tb_alipay_user.address
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址 <p/>
     * This method sets the value of the database column tb_alipay_user.address
     *
     * @param address the value for tb_alipay_user.address
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 邮政编码 <p/>
     * This method returns the value of the database column tb_alipay_user.zip
     *
     * @return the value of tb_alipay_user.zip
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getZip() {
        return zip;
    }

    /**
     * 邮政编码 <p/>
     * This method sets the value of the database column tb_alipay_user.zip
     *
     * @param zip the value for tb_alipay_user.zip
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    /**
     * 收货人所在省份 <p/>
     * This method returns the value of the database column tb_alipay_user.deliver_province
     *
     * @return the value of tb_alipay_user.deliver_province
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getDeliverProvince() {
        return deliverProvince;
    }

    /**
     * 收货人所在省份 <p/>
     * This method sets the value of the database column tb_alipay_user.deliver_province
     *
     * @param deliverProvince the value for tb_alipay_user.deliver_province
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setDeliverProvince(String deliverProvince) {
        this.deliverProvince = deliverProvince == null ? null : deliverProvince.trim();
    }

    /**
     * 收货人所在城市 <p/>
     * This method returns the value of the database column tb_alipay_user.deliver_city
     *
     * @return the value of tb_alipay_user.deliver_city
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getDeliverCity() {
        return deliverCity;
    }

    /**
     * 收货人所在城市 <p/>
     * This method sets the value of the database column tb_alipay_user.deliver_city
     *
     * @param deliverCity the value for tb_alipay_user.deliver_city
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setDeliverCity(String deliverCity) {
        this.deliverCity = deliverCity == null ? null : deliverCity.trim();
    }

    /**
     * 收货人所在区县 <p/>
     * This method returns the value of the database column tb_alipay_user.deliver_area
     *
     * @return the value of tb_alipay_user.deliver_area
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getDeliverArea() {
        return deliverArea;
    }

    /**
     * 收货人所在区县 <p/>
     * This method sets the value of the database column tb_alipay_user.deliver_area
     *
     * @param deliverArea the value for tb_alipay_user.deliver_area
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setDeliverArea(String deliverArea) {
        this.deliverArea = deliverArea == null ? null : deliverArea.trim();
    }

    /**
     * 区域编码 <p/>
     * This method returns the value of the database column tb_alipay_user.address_code
     *
     * @return the value of tb_alipay_user.address_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getAddressCode() {
        return addressCode;
    }

    /**
     * 区域编码 <p/>
     * This method sets the value of the database column tb_alipay_user.address_code
     *
     * @param addressCode the value for tb_alipay_user.address_code
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode == null ? null : addressCode.trim();
    }

    /**
     * 是否是学生 T为是手机认证，F为非手机认证。  <p/>
     * This method returns the value of the database column tb_alipay_user.is_student_certified
     *
     * @return the value of tb_alipay_user.is_student_certified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getIsStudentCertified() {
        return isStudentCertified;
    }

    /**
     * 是否是学生 T为是手机认证，F为非手机认证。  <p/>
     * This method sets the value of the database column tb_alipay_user.is_student_certified
     *
     * @param isStudentCertified the value for tb_alipay_user.is_student_certified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setIsStudentCertified(String isStudentCertified) {
        this.isStudentCertified = isStudentCertified == null ? null : isStudentCertified.trim();
    }

    /**
     * T：表示A类实名认证；F：表示非A类实名认证  <p/>
     * This method returns the value of the database column tb_alipay_user.is_certify_grade_a
     *
     * @return the value of tb_alipay_user.is_certify_grade_a
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getIsCertifyGradeA() {
        return isCertifyGradeA;
    }

    /**
     * T：表示A类实名认证；F：表示非A类实名认证  <p/>
     * This method sets the value of the database column tb_alipay_user.is_certify_grade_a
     *
     * @param isCertifyGradeA the value for tb_alipay_user.is_certify_grade_a
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setIsCertifyGradeA(String isCertifyGradeA) {
        this.isCertifyGradeA = isCertifyGradeA == null ? null : isCertifyGradeA.trim();
    }

    /**
     * 支付宝用户ID  <p/>
     * This method returns the value of the database column tb_alipay_user.alipay_user_id
     *
     * @return the value of tb_alipay_user.alipay_user_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getAlipayUserId() {
        return alipayUserId;
    }

    /**
     * 支付宝用户ID  <p/>
     * This method sets the value of the database column tb_alipay_user.alipay_user_id
     *
     * @param alipayUserId the value for tb_alipay_user.alipay_user_id
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setAlipayUserId(String alipayUserId) {
        this.alipayUserId = alipayUserId == null ? null : alipayUserId.trim();
    }

    /**
     * 用户生日(19900918) <p/>
     * This method returns the value of the database column tb_alipay_user.birthday
     *
     * @return the value of tb_alipay_user.birthday
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 用户生日(19900918) <p/>
     * This method sets the value of the database column tb_alipay_user.birthday
     *
     * @param birthday the value for tb_alipay_user.birthday
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 用户昵称 <p/>
     * This method returns the value of the database column tb_alipay_user.nick_name
     *
     * @return the value of tb_alipay_user.nick_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 用户昵称 <p/>
     * This method sets the value of the database column tb_alipay_user.nick_name
     *
     * @param nickName the value for tb_alipay_user.nick_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 姓氏，取的是realName中的首个字符，对非中文、中文复姓支持较差。 <p/>
     * This method returns the value of the database column tb_alipay_user.family_name
     *
     * @return the value of tb_alipay_user.family_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * 姓氏，取的是realName中的首个字符，对非中文、中文复姓支持较差。 <p/>
     * This method sets the value of the database column tb_alipay_user.family_name
     *
     * @param familyName the value for tb_alipay_user.family_name
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName == null ? null : familyName.trim();
    }

    /**
     * 生日的月和日，MMdd格式 <p/>
     * This method returns the value of the database column tb_alipay_user.reduced_birthday
     *
     * @return the value of tb_alipay_user.reduced_birthday
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getReducedBirthday() {
        return reducedBirthday;
    }

    /**
     * 生日的月和日，MMdd格式 <p/>
     * This method sets the value of the database column tb_alipay_user.reduced_birthday
     *
     * @param reducedBirthday the value for tb_alipay_user.reduced_birthday
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setReducedBirthday(String reducedBirthday) {
        this.reducedBirthday = reducedBirthday == null ? null : reducedBirthday.trim();
    }

    /**
     * T--被冻结；F--未冻结 <p/>
     * This method returns the value of the database column tb_alipay_user.is_balance_frozen
     *
     * @return the value of tb_alipay_user.is_balance_frozen
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getIsBalanceFrozen() {
        return isBalanceFrozen;
    }

    /**
     * T--被冻结；F--未冻结 <p/>
     * This method sets the value of the database column tb_alipay_user.is_balance_frozen
     *
     * @param isBalanceFrozen the value for tb_alipay_user.is_balance_frozen
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setIsBalanceFrozen(String isBalanceFrozen) {
        this.isBalanceFrozen = isBalanceFrozen == null ? null : isBalanceFrozen.trim();
    }

    /**
     * 注意】当is_balance_frozen为“F”时，改字段不会返回.  <p/>
     * This method returns the value of the database column tb_alipay_user.balance_freeze_type
     *
     * @return the value of tb_alipay_user.balance_freeze_type
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public String getBalanceFreezeType() {
        return balanceFreezeType;
    }

    /**
     * 注意】当is_balance_frozen为“F”时，改字段不会返回.  <p/>
     * This method sets the value of the database column tb_alipay_user.balance_freeze_type
     *
     * @param balanceFreezeType the value for tb_alipay_user.balance_freeze_type
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setBalanceFreezeType(String balanceFreezeType) {
        this.balanceFreezeType = balanceFreezeType == null ? null : balanceFreezeType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_alipay_user.created
     *
     * @return the value of tb_alipay_user.created
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_alipay_user.created
     *
     * @param created the value for tb_alipay_user.created
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_alipay_user.modified
     *
     * @return the value of tb_alipay_user.modified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Date getModified() {
        return modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_alipay_user.modified
     *
     * @param modified the value for tb_alipay_user.modified
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * 0否 1是 <p/>
     * This method returns the value of the database column tb_alipay_user.enable_status
     *
     * @return the value of tb_alipay_user.enable_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public Boolean getEnableStatus() {
        return enableStatus;
    }

    /**
     * 0否 1是 <p/>
     * This method sets the value of the database column tb_alipay_user.enable_status
     *
     * @param enableStatus the value for tb_alipay_user.enable_status
     *
     * @mbggenerated Tue Aug 16 23:58:39 CST 2016
     */
    public void setEnableStatus(Boolean enableStatus) {
        this.enableStatus = enableStatus;
    }
}