package com.gcloud.shop.api.internal.parser.xml;

import com.gcloud.shop.api.exception.GcloudException;
import com.gcloud.shop.api.internal.parser.GcloudParser;
import com.gcloud.shop.api.response.GcloudResponse;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ObjectXmlParser
 * @Package com.gcloud.shop.api.internal.parser.xml
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 14:10
 */
public class ObjectXmlParser <T extends GcloudResponse> implements GcloudParser<T> {

    private Class<T> clazz;

    public ObjectXmlParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T parse(String rsp) throws GcloudException {
        XmlConverter converter = new XmlConverter();
        return converter.toResponse(rsp, this.clazz);
    }

    public Class<T> getResponseClass() {
        return this.clazz;
    }
}
