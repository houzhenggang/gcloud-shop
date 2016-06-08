package com.gcloud.shop.api.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: RequestParametersHolder
 * @Package com.gcloud.shop.api.utils
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 11:40
 */
public class RequestParametersHolder {

    private String requestUrl;
    private String responseBody;
    private GcloudHashMap protocalMustParams;
    private GcloudHashMap protocalOptParams;
    private GcloudHashMap applicationParams;

    public RequestParametersHolder() {
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public GcloudHashMap getProtocalMustParams() {
        return this.protocalMustParams;
    }

    public void setProtocalMustParams(GcloudHashMap protocalMustParams) {
        this.protocalMustParams = protocalMustParams;
    }

    public GcloudHashMap getProtocalOptParams() {
        return this.protocalOptParams;
    }

    public void setProtocalOptParams(GcloudHashMap protocalOptParams) {
        this.protocalOptParams = protocalOptParams;
    }

    public GcloudHashMap getApplicationParams() {
        return this.applicationParams;
    }

    public void setApplicationParams(GcloudHashMap applicationParams) {
        this.applicationParams = applicationParams;
    }

    public Map<String, String> getAllParams() {
        HashMap params = new HashMap();
        if(this.protocalMustParams != null && !this.protocalMustParams.isEmpty()) {
            params.putAll(this.protocalMustParams);
        }

        if(this.protocalOptParams != null && !this.protocalOptParams.isEmpty()) {
            params.putAll(this.protocalOptParams);
        }

        if(this.applicationParams != null && !this.applicationParams.isEmpty()) {
            params.putAll(this.applicationParams);
        }
        return params;
    }
}
