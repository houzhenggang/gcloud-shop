package com.gcloud.shop.api.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GcloudHashMap
 * @Package com.gcloud.shop.api.utils
 * @Description:  HashMap工具类
 * @date 2016/6/8 11:22
 */
public class GcloudHashMap extends HashMap<String, String> {

    private static final long serialVersionUID = 2976225757557214415L;

    public GcloudHashMap(){

    }

    public GcloudHashMap(Map<? extends String, ? extends String> map) {
        super(map);
    }

    public String put(String key, Object value) {
        String strValue;
        if(value == null) {
            strValue = null;
        } else if(value instanceof String) {
            strValue = (String)value;
        } else if(value instanceof Integer) {
            strValue = ((Integer)value).toString();
        } else if(value instanceof Long) {
            strValue = ((Long)value).toString();
        } else if(value instanceof Float) {
            strValue = ((Float)value).toString();
        } else if(value instanceof Double) {
            strValue = ((Double)value).toString();
        } else if(value instanceof Boolean) {
            strValue = ((Boolean)value).toString();
        } else if(value instanceof Date) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            strValue = format.format((Date)value);
        } else {
            strValue = value.toString();
        }

        return this.put(key, strValue);
    }

    public String put(String key, String value) {
        return StringUtils.areNotEmpty(new String[]{key, value}) ? (String)super.put(key, value) : null;
    }
}
