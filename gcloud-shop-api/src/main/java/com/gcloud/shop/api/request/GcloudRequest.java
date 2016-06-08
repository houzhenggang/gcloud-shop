package com.gcloud.shop.api.request;

import com.gcloud.shop.api.exception.GcloudRuleException;
import com.gcloud.shop.api.response.GcloudResponse;

import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GcloudRequest
 * @Package com.gcloud.shop.web.request
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 10:26
 */
public interface GcloudRequest<T extends GcloudResponse> {

    /**
     * 接口名称
     * @return
     */
    String getMethodName();

    /**
     * 获取时间戳
     * @return
     */
    Long getTimestamp();

    /**
     * 获取时间戳
     * @param timestamp
     */
    void setTimestamp(Long timestamp);

    /**
     * 检查
     * @throws GcloudRuleException
     */
    void check() throws GcloudRuleException;

    /**
     * 获取参数
     * @return
     */
    Map<String, String> getTextParams();

    /**
     * 设置参数
     * @param key
     * @param value
     */
    void putOtherTextParam(String key, String value);

    /**
     * 获取头信息
     * @return
     */
    Map<String, String> getHeaderMap();

    /**
     *
     * @return
     */
    Class<T> getResponseClass();
}
