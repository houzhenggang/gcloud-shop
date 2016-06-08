package com.gcloud.shop.api;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TaobaoParser
 * @Package com.gcloud.shop.api
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:51
 */
public interface TaobaoParser<T extends TaobaoResponse> {

    T parse(String var1) throws ApiException;

    Class<T> getResponseClass() throws ApiException;
}
