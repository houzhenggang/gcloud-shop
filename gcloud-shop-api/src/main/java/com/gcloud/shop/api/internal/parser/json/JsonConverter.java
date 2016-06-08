package com.gcloud.shop.api.internal.parser.json;

import com.gcloud.shop.api.ApiException;
import com.gcloud.shop.api.TaobaoResponse;
import com.gcloud.shop.api.internal.mapping.Converter;
import com.gcloud.shop.api.internal.mapping.Converters;
import com.gcloud.shop.api.internal.mapping.Reader;
import com.gcloud.shop.api.internal.util.json.ExceptionErrorListener;
import com.gcloud.shop.api.internal.util.json.JSONValidatingReader;

import java.util.*;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: JsonConverter
 * @Package com.gcloud.shop.api.internal.parser.json
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:35
 */
public class JsonConverter implements Converter {

    public JsonConverter() {

    }

    public <T extends TaobaoResponse> T toResponse(String rsp, Class<T> clazz) throws ApiException {
        JSONValidatingReader reader = new JSONValidatingReader(new ExceptionErrorListener());
        Object rootObj = reader.read(rsp);
        if(rootObj instanceof Map) {
            Map rootJson = (Map)rootObj;
            Collection values = rootJson.values();
            Iterator i$ = values.iterator();

            while(i$.hasNext()) {
                Object rspObj = i$.next();
                if(rspObj instanceof Map) {
                    Map rspJson = (Map)rspObj;
                    //mod by chenjin return (TaobaoResponse)this.fromJson(rspJson, clazz);
                    return (T)this.fromJson(rspJson, clazz);
                }
            }
        }

        return null;
    }

    public <T> T fromJson(final Map<?, ?> json, Class<T> clazz) throws ApiException {
        return Converters.convert(clazz, new Reader() {
            public boolean hasReturnField(Object name) {
                return json.containsKey(name);
            }

            public Object getPrimitiveObject(Object name) {
                return json.get(name);
            }

            public Object getObject(Object name, Class<?> type) throws ApiException {
                Object tmp = json.get(name);
                if(tmp instanceof Map) {
                    Map map = (Map)tmp;
                    return JsonConverter.this.fromJson(map, type);
                } else {
                    return null;
                }
            }

            public List<?> getListObjects(Object listName, Object itemName, Class<?> subType) throws ApiException {
                ArrayList listObjs = null;
                Object listTmp = json.get(listName);
                if(listTmp instanceof Map) {
                    Map jsonMap = (Map)listTmp;
                    Object itemTmp = jsonMap.get(itemName);
                    if(itemTmp == null && listName != null) {
                        String tmpList = listName.toString();
                        itemTmp = jsonMap.get(tmpList.substring(0, tmpList.length() - 1));
                    }

                    if(itemTmp instanceof List) {
                        listObjs = new ArrayList();
                        List tmpList1 = (List)itemTmp;
                        Iterator i$ = tmpList1.iterator();

                        while(i$.hasNext()) {
                            Object subTmp = i$.next();
                            if(subTmp instanceof Map) {
                                Map subMap = (Map)subTmp;
                                Object subObj = JsonConverter.this.fromJson(subMap, subType);
                                if(subObj != null) {
                                    listObjs.add(subObj);
                                }
                            } else if(!(subTmp instanceof List)) {
                                listObjs.add(subTmp);
                            }
                        }
                    }
                }

                return listObjs;
            }
        });
    }
}
