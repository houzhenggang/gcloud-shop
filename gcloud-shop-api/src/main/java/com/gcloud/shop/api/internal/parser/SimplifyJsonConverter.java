package com.gcloud.shop.api.internal.parser;

import com.gcloud.shop.api.exception.GcloudException;
import com.gcloud.shop.api.internal.mapping.Converter;
import com.gcloud.shop.api.internal.mapping.Converters;
import com.gcloud.shop.api.internal.mapping.Reader;
import com.gcloud.shop.api.response.GcloudResponse;
import com.gcloud.shop.api.utils.json.ExceptionErrorListener;
import com.gcloud.shop.api.utils.json.JSONValidatingReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: SimplifyJsonConverter
 * @Package com.gcloud.shop.api.internal.parser
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 14:00
 */
public class SimplifyJsonConverter implements Converter {

    public SimplifyJsonConverter() {

    }

    public <T extends GcloudResponse> T toResponse(String rsp, Class<T> clazz) throws GcloudException {
        JSONValidatingReader reader = new JSONValidatingReader(new ExceptionErrorListener());
        Object rootObj = reader.read(rsp);
        if(rootObj instanceof Map) {
            Map rootJson = (Map)rootObj;
            Object errorJson = rootJson.get("error_response");
            return errorJson instanceof Map ? (T)this.fromJson((Map)errorJson, clazz) : (T)this.fromJson(rootJson, clazz);//mod by chenjin
        } else {
            return null;
        }
    }

    public <T> T fromJson(final Map<?, ?> json, Class<T> clazz) throws GcloudException {
        return Converters.convert(clazz, new Reader() {
            public boolean hasReturnField(Object name) {
                return json.containsKey(name);
            }

            public Object getPrimitiveObject(Object name) {
                return json.get(name);
            }

            public Object getObject(Object name, Class<?> type) throws GcloudException {
                Object tmp = json.get(name);
                if(tmp instanceof Map) {
                    Map map = (Map)tmp;
                    return SimplifyJsonConverter.this.fromJson(map, type);
                } else {
                    return null;
                }
            }

            public List<?> getListObjects(Object listName, Object itemName, Class<?> subType) throws GcloudException {
                ArrayList listObjs = null;
                Object jsonList = json.get(listName);
                if(jsonList instanceof List) {
                    listObjs = new ArrayList();
                    List listObj = (List)jsonList;
                    Iterator i$ = listObj.iterator();

                    while(i$.hasNext()) {
                        Object tmp = i$.next();
                        if(tmp instanceof Map) {
                            Map subMap = (Map)tmp;
                            Object subObj = SimplifyJsonConverter.this.fromJson(subMap, subType);
                            if(subObj != null) {
                                listObjs.add(subObj);
                            }
                        } else if(!(tmp instanceof List)) {
                            listObjs.add(tmp);
                        }
                    }
                }

                return listObjs;
            }
        });
    }
}
