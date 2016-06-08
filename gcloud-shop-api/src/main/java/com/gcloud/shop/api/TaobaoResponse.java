package com.gcloud.shop.api;

import com.gcloud.shop.api.internal.mapping.ApiField;

import java.io.Serializable;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TaobaoResponse
 * @Package com.gcloud.shop.api
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:23
 */
public abstract class TaobaoResponse implements Serializable {

    private static final long serialVersionUID = -7038701009792223717L;

    @ApiField("code")
    private String errorCode;
    @ApiField("msg")
    private String msg;
    @ApiField("sub_code")
    private String subCode;
    @ApiField("sub_msg")
    private String subMsg;
    @ApiField("top_forbidden_fields")
    private String topForbiddenFields;
    private String body;
    private Map<String, String> params;

    public TaobaoResponse() {
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSubCode() {
        return this.subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return this.subMsg;
    }

    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public boolean isSuccess() {
        return this.errorCode == null && this.subCode == null;
    }

    public String getTopForbiddenFields() {
        return this.topForbiddenFields;
    }

    public void setTopForbiddenFields(String topForbiddenFields) {
        this.topForbiddenFields = topForbiddenFields;
    }
}

