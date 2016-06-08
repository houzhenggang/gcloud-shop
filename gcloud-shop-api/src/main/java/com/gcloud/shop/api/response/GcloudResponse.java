package com.gcloud.shop.api.response;

import com.gcloud.shop.api.internal.mapping.ApiField;

import java.io.Serializable;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GcloudResponse
 * @Package com.gcloud.shop.web.response
 * @Description: response父类
 * @date 2016/6/8 10:29
 */
public abstract class GcloudResponse implements Serializable{

    private static final long serialVersionUID = -6198219289887199562L;

    public GcloudResponse(){

    }

    @ApiField("code")
    private String errorCode;
    @ApiField("msg")
    private String errorMessage;
    @ApiField("sub_code")
    private String errorSubCode;
    @ApiField("sub_msg")
    private String errorSubMessage;
    @ApiField("top_forbidden_fields")
    private String topForbiddenFields;

    private String body;
    private Map<String, String> params;

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorSubCode() {
        return errorSubCode;
    }

    public void setErrorSubCode(String errorSubCode) {
        this.errorSubCode = errorSubCode;
    }

    public String getErrorSubMessage() {
        return errorSubMessage;
    }

    public void setErrorSubMessage(String errorSubMessage) {
        this.errorSubMessage = errorSubMessage;
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
        return this.errorCode == null && this.errorSubCode == null;
    }

    public String getTopForbiddenFields() {
        return this.topForbiddenFields;
    }

    public void setTopForbiddenFields(String topForbiddenFields) {
        this.topForbiddenFields = topForbiddenFields;
    }
}
