package com.gcloud.shop.api;

import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TaobaoRequest
 * @Package com.gcloud.shop.api
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:22
 */
public interface TaobaoRequest<T extends TaobaoResponse> {

    String getApiMethodName();

    Map<String, String> getTextParams();

    Long getTimestamp();

    void setTimestamp(Long var1);

    Class<T> getResponseClass();

    void check() throws ApiRuleException;

    Map<String, String> getHeaderMap();

    void putOtherTextParam(String var1, String var2);
}
