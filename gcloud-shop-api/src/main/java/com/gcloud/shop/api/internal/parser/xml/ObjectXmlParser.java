package com.gcloud.shop.api.internal.parser.xml;

import com.gcloud.shop.api.ApiException;
import com.gcloud.shop.api.TaobaoParser;
import com.gcloud.shop.api.TaobaoResponse;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ObjectXmlParser
 * @Package com.gcloud.shop.api.internal.parser.xml
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:37
 */
public class ObjectXmlParser<T extends TaobaoResponse> implements TaobaoParser<T> {
    private Class<T> clazz;

    public ObjectXmlParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T parse(String rsp) throws ApiException {
        XmlConverter converter = new XmlConverter();
        return converter.toResponse(rsp, this.clazz);
    }

    public Class<T> getResponseClass() {
        return this.clazz;
    }
}
