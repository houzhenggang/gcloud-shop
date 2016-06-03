package com.gcloud.shop.domain.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: Shop
 * @Package com.gcloud.domain.user
 * @Description: 店铺信息
 * @date 2016/6/1 13:53
 */
public class Shop implements Serializable {


    private Long id;

    /**
     * 卖家的淘宝编号
     */
    private Long taobaoId;

    /**
     * 卖家的昵称
     */
    private String nick;

    /**
     * 卖家的名称
     */
    private String name;

    /**
     * 淘宝的店铺编号
     */
    private Long sid;

    /**
     * 淘宝的店铺类目
     */
    private Long cid;

    /**
     * 店铺标题
     */
    private String title;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 店铺备注
     */
    private String remark;
    
    /**
     * 发货联系人编号，也就是淘宝的地址库的编号
     */
    private Long sendContactId;

    /**
     * 发货地址
     */
    private String sendAddress;

    /**
     * 发货省
     */
    private String sendState;

    /**
     * 发货市
     */
    private String sendCity;

    /**
     * 发货区县
     */
    private String sendDistrict;

    /**
     * 发货联系人
     */
    private String sendContact;

    /**
     * 发货地址的邮编
     */
    private String sendPost;

    /**
     * 发货人的手机号码
     */
    private String sendMobile;

    /**
     * 发货人的电话号码
     */
    private String sendPhone;
    
    /**
     * 退款联系人编号，也就是淘宝的地址编号
     */
    private Long refundContactId;

    /**
     * 退货地址
     */
    private String refundAddress;
    
    /**
     * 退货省
     */
    private String refundState;
    
    /**
     * 退货城市
     */
    private String refundCity;
    
    /**
     * 退货区县
     */
    private String refundDistrict;

    /**
     * 退货联系人
     */
    private String refundContact;

    /**
     * 退货地址的邮编
     */
    private String refundPost;

    /**
     * 退货人的手机号码
     */
    private String refundMobile;

    /**
     * 退货人的电话号码
     */
    private String refundPhone;

    /**
     * 店铺标示，例如，淘1，淘2等等
     */
    private String flag;

    /**
     * 序列号
     */
    private String bindCode;
    
    /**
     * 店铺网址
     */
    private String url;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date modified;

    /**
     * 数据的可用状态，0表示不可用，1表示可用
     */
    private Integer enableStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaobaoId() {
        return taobaoId;
    }

    public void setTaobaoId(Long taobaoId) {
        this.taobaoId = taobaoId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getSendContactId() {
        return sendContactId;
    }

    public void setSendContactId(Long sendContactId) {
        this.sendContactId = sendContactId;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public String getSendState() {
        return sendState;
    }

    public void setSendState(String sendState) {
        this.sendState = sendState;
    }

    public String getSendCity() {
        return sendCity;
    }

    public void setSendCity(String sendCity) {
        this.sendCity = sendCity;
    }

    public String getSendDistrict() {
        return sendDistrict;
    }

    public void setSendDistrict(String sendDistrict) {
        this.sendDistrict = sendDistrict;
    }

    public String getSendContact() {
        return sendContact;
    }

    public void setSendContact(String sendContact) {
        this.sendContact = sendContact;
    }

    public String getSendPost() {
        return sendPost;
    }

    public void setSendPost(String sendPost) {
        this.sendPost = sendPost;
    }

    public String getSendMobile() {
        return sendMobile;
    }

    public void setSendMobile(String sendMobile) {
        this.sendMobile = sendMobile;
    }

    public String getSendPhone() {
        return sendPhone;
    }

    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone;
    }

    public Long getRefundContactId() {
        return refundContactId;
    }

    public void setRefundContactId(Long refundContactId) {
        this.refundContactId = refundContactId;
    }

    public String getRefundAddress() {
        return refundAddress;
    }

    public void setRefundAddress(String refundAddress) {
        this.refundAddress = refundAddress;
    }

    public String getRefundState() {
        return refundState;
    }

    public void setRefundState(String refundState) {
        this.refundState = refundState;
    }

    public String getRefundCity() {
        return refundCity;
    }

    public void setRefundCity(String refundCity) {
        this.refundCity = refundCity;
    }

    public String getRefundDistrict() {
        return refundDistrict;
    }

    public void setRefundDistrict(String refundDistrict) {
        this.refundDistrict = refundDistrict;
    }

    public String getRefundContact() {
        return refundContact;
    }

    public void setRefundContact(String refundContact) {
        this.refundContact = refundContact;
    }

    public String getRefundPost() {
        return refundPost;
    }

    public void setRefundPost(String refundPost) {
        this.refundPost = refundPost;
    }

    public String getRefundMobile() {
        return refundMobile;
    }

    public void setRefundMobile(String refundMobile) {
        this.refundMobile = refundMobile;
    }

    public String getRefundPhone() {
        return refundPhone;
    }

    public void setRefundPhone(String refundPhone) {
        this.refundPhone = refundPhone;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getBindCode() {
        return bindCode;
    }

    public void setBindCode(String bindCode) {
        this.bindCode = bindCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }
}
