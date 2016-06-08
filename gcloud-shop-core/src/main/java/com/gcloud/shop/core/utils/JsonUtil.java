package com.gcloud.shop.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: JsonUtil
 * @Package com.gcloud.shop.core.utils
 * @Description: Json处理工具类
 * @date 2016/6/8 17:43
 */
public class JsonUtil {

    /**
     * response请求参数转成map
     * @param params
     * @return
     */
    public static Map<String, String> jsonToMap(JSONObject params) {

        Map<String, String> paramsMap = new HashMap<String, String>();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            paramsMap.put(key, params.getString(key));
        }
        return paramsMap;
    }

    /**
     * object转成json
     * @param object
     * @return
     */
    public static String objToJson(Object object){
        return null != object ? String.valueOf(JSON.toJSON(object)) : "";
    }
}
