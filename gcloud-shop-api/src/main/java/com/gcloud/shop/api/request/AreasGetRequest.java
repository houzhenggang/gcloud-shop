package com.gcloud.shop.api.request;

import com.gcloud.shop.api.ApiRuleException;
import com.gcloud.shop.api.TaobaoRequest;
import com.gcloud.shop.api.internal.util.RequestCheckUtils;
import com.gcloud.shop.api.internal.util.TaobaoHashMap;
import com.gcloud.shop.api.response.AreasGetResponse;

import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreasGetRequest
 * @Package com.gcloud.shop.api.request
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:46
 */
public class AreasGetRequest implements TaobaoRequest<AreasGetResponse> {

    public AreasGetRequest() {

    }

    private Map<String, String> headerMap = new TaobaoHashMap();
    private TaobaoHashMap udfParams;
    private Long timestamp;
    private String fields;

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getFields() {
        return this.fields;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getApiMethodName() {
        return "taobao.areas.get";
    }

    public Map<String, String> getTextParams() {
        TaobaoHashMap txtParams = new TaobaoHashMap();
        txtParams.put("fields", this.fields);
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

    public Class<AreasGetResponse> getResponseClass() {
        return AreasGetResponse.class;
    }

    public void check() throws ApiRuleException {
        RequestCheckUtils.checkNotEmpty(this.fields, "fields");
    }

    public Map<String, String> getHeaderMap() {
        return this.headerMap;
    }
}
