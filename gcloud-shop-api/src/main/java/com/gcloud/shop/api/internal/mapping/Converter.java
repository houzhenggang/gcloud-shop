package com.gcloud.shop.api.internal.mapping;

import com.gcloud.shop.api.exception.GcloudException;
import com.gcloud.shop.api.response.GcloudResponse;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: Converter
 * @Package com.gcloud.shop.api.internal.mapping
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 13:49
 */
public interface Converter {

    <T extends GcloudResponse> T toResponse(String var1, Class<T> var2) throws GcloudException;
}
