package com.gcloud.shop.api;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TaobaoClient
 * @Package com.gcloud.shop.api
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:16
 */
public interface TaobaoClient {

    <T extends TaobaoResponse> T execute(TaobaoRequest<T> var1) throws ApiException;

    <T extends TaobaoResponse> T execute(TaobaoRequest<T> var1, String var2) throws ApiException;
}
