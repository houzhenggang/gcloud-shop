package com.gcloud.shop.api.internal.parser;

import com.gcloud.shop.api.exception.GcloudException;
import com.gcloud.shop.api.response.GcloudResponse;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GcloudParser
 * @Package com.gcloud.shop.api.internal.parser
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 13:59
 */
public interface GcloudParser<T extends GcloudResponse> {

    T parse(String var1) throws GcloudException;

    Class<T> getResponseClass() throws GcloudException;
}
