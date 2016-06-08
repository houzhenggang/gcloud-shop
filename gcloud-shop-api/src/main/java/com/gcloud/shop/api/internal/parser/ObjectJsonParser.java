package com.gcloud.shop.api.internal.parser;

import com.gcloud.shop.api.exception.GcloudException;
import com.gcloud.shop.api.internal.mapping.Converter;
import com.gcloud.shop.api.response.GcloudResponse;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ObjectJsonParser
 * @Package com.gcloud.shop.api.internal.parser
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 13:57
 */
public class ObjectJsonParser<T extends GcloudResponse> implements GcloudParser<T> {
    private Class<T> clazz;
    private boolean simplify;

    public ObjectJsonParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    public ObjectJsonParser(Class<T> clazz, boolean simplify) {
        this.clazz = clazz;
        this.simplify = simplify;
    }

    public T parse(String rsp) throws GcloudException {
        Object converter;
        if(this.simplify) {
            converter = new SimplifyJsonConverter();
        } else {
            converter = new JsonConverter();
        }

        return ((Converter)converter).toResponse(rsp, this.clazz);
    }

    public Class<T> getResponseClass() {
        return this.clazz;
    }
}