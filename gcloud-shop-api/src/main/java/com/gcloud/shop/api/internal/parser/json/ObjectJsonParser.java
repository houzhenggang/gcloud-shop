package com.gcloud.shop.api.internal.parser.json;

import com.gcloud.shop.api.ApiException;
import com.gcloud.shop.api.TaobaoParser;
import com.gcloud.shop.api.TaobaoResponse;
import com.gcloud.shop.api.internal.mapping.Converter;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ObjectJsonParser
 * @Package com.gcloud.shop.api.internal.parser.json
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:36
 */
public class ObjectJsonParser<T extends TaobaoResponse> implements TaobaoParser<T> {

    private Class<T> clazz;
    private boolean simplify;

    public ObjectJsonParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    public ObjectJsonParser(Class<T> clazz, boolean simplify) {
        this.clazz = clazz;
        this.simplify = simplify;
    }

    public T parse(String rsp) throws ApiException {
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
