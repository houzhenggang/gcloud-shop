package com.gcloud.shop.api.internal.dns;

import com.gcloud.shop.api.exception.GcloudRuleException;
import com.gcloud.shop.api.request.GcloudRequest;
import com.gcloud.shop.api.utils.GcloudHashMap;

import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: HttpdnsGetRequest
 * @Package com.gcloud.shop.api.internal.dns
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 13:42
 */
public class HttpdnsGetRequest implements GcloudRequest<HttpdnsGetResponse> {

    private Map<String, String> headerMap = new GcloudHashMap();
    private GcloudHashMap udfParams;
    private Long timestamp;

    public HttpdnsGetRequest() {
    }

    @Override
    public String getMethodName() {
        return null;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getApiMethodName() {
        return "taobao.httpdns.get";
    }

    public Map<String, String> getTextParams() {
        GcloudHashMap txtParams = new GcloudHashMap();
        if(this.udfParams != null) {
            txtParams.putAll(this.udfParams);
        }

        return txtParams;
    }

    public void putOtherTextParam(String key, String value) {
        if(this.udfParams == null) {
            this.udfParams = new GcloudHashMap();
        }

        this.udfParams.put(key, value);
    }

    public Class<HttpdnsGetResponse> getResponseClass() {
        return HttpdnsGetResponse.class;
    }

    public void check() throws GcloudRuleException {
    }

    public Map<String, String> getHeaderMap() {
        return this.headerMap;
    }
}
