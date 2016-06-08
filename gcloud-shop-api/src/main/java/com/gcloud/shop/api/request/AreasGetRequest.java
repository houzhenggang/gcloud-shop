package com.gcloud.shop.api.request;

import com.gcloud.shop.api.exception.GcloudRuleException;
import com.gcloud.shop.api.response.AreasGetResponse;
import com.gcloud.shop.api.utils.GcloudHashMap;

import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreasGetRequest
 * @Package com.gcloud.shop.api.request
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 11:07
 */
public class AreasGetRequest implements GcloudRequest<AreasGetResponse> {

    /**
     *
     */
    private Map<String, String> headerMap = new GcloudHashMap();

    /**
     *
     */
    private GcloudHashMap udfParams;

    /**
     *
     */
    private Long timestamp;

    /**
     *
     */
    private String fields;

    @Override
    public String getMethodName() {
        return "gcloud.areas.get";
    }

    @Override
    public Long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public void check() throws GcloudRuleException {

    }

    @Override
    public Map<String, String> getTextParams() {
        return null;
    }

    @Override
    public void putOtherTextParam(String var1, String var2) {

    }

    @Override
    public Map<String, String> getHeaderMap() {
        return null;
    }

    @Override
    public Class<AreasGetResponse> getResponseClass() {
        return AreasGetResponse.class;
    }

}
