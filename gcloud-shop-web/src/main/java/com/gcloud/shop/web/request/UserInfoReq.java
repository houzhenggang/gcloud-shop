package com.gcloud.shop.web.request;

/**
* 【请求】订单支付请求参数<br/>
* mainCode = 1<br/>
* subCode = 1<br/>
* <p/>
* Created by game tools.
*/
public class UserInfoReq extends BaseRequest {

    private Long userId;

    private Long storeId;

    private String userName;

    private String passWord;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}