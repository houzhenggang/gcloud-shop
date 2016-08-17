package com.gcloud.shop.web.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.gcloud.shop.core.Constant;

import java.io.Serializable;

public class ResponseEntity implements Serializable {

    @JSONField(name = "status")
    private String status = Constant.API_CALL_SUCCESS;

    @JSONField(name = "message")
    private String message = Constant.API_CALL_SUCCESS;

    @JSONField(name = "api")
    private String api;

    @JSONField(name = "result")
    private Object result = "";

    @JSONField(name = "sign")
    private Object sign = "";

    @JSONField(name = "secret")
    private Object secret = "";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getSign() {
        return sign;
    }

    public void setSign(Object sign) {
        this.sign = sign;
    }

    public Object getSecret() {
        return secret;
    }

    public void setSecret(Object secret) {
        this.secret = secret;
    }
}
