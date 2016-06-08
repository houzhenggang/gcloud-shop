package com.gcloud.shop.api;

import com.gcloud.shop.api.exception.GcloudException;
import com.gcloud.shop.api.request.GcloudRequest;
import com.gcloud.shop.api.response.GcloudResponse;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GcloudClient
 * @Package com.gcloud.shop.api
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 1*/
public interface GcloudClient {

    <T extends GcloudResponse> T execute(GcloudRequest<T> var1) throws GcloudException;

    <T extends GcloudResponse> T execute(GcloudRequest<T> var1, String var2) throws GcloudException;
}
