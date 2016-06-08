package com.gcloud.shop.api.internal.dns;

import com.gcloud.shop.api.ApiRuleException;
import com.gcloud.shop.api.TaobaoRequest;
import com.gcloud.shop.api.internal.util.TaobaoHashMap;

import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: HttpdnsGetRequest
 * @Package com.gcloud.shop.api.internal.dns
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:31
 */
public class HttpdnsGetRequest implements TaobaoRequest<HttpdnsGetResponse> {

    private Map<String, String> headerMap = new TaobaoHashMap();
    private TaobaoHashMap udfParams;
    private Long timestamp;

    public HttpdnsGetRequest() {
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
        TaobaoHashMap txtParams = new TaobaoHashMap();
        if(this.udfParams != null) {
            txtParams.putAll(this.udfParams);
        }

        return txtParams;
    }

    public void putOtherTextParam(String key, String value) {
        if(this.udfParams == null) {
            this.udfParams = new TaobaoHashMap();
        }

        this.udfParams.put(key, value);
    }

    public Class<HttpdnsGetResponse> getResponseClass() {
        return HttpdnsGetResponse.class;
    }

    public void check() throws ApiRuleException {
    }

    public Map<String, String> getHeaderMap() {
        return this.headerMap;
    }
}