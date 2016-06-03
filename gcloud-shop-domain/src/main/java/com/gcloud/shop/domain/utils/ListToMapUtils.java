package com.gcloud.shop.domain.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * List转Map工具类
 * @author chenjin
 * @since 2016年03月18日 上午11:35:28
 **/
public class ListToMapUtils<T> {
    public static <T> Map<String, List<T>> toListObject(List<T> tradeList, String... x) {
        Map<String, List<T>> a = new HashMap<String, List<T>>((int) Math.ceil(tradeList.size() / 0.7));
        for (T t : tradeList) {
            String key = toMapKey(t, x);
            if (a.get(key) != null) {
                a.get(key).add(t);
            } else {
                LinkedList<T> ts = new LinkedList<T>();
                ts.add(t);
                a.put(key, ts);
            }
        }
        return a;
    }

    public static <T> Map<String, T> toObejct(List<T> tradeList, String... x) {
        Map<String, T> a = new HashMap<String, T>((int) Math.ceil(tradeList.size() / 0.7));
        for (T t : tradeList) {
            String key = toMapKey(t, x);
            if (!a.containsKey(key)) a.put(key, t);
        }
        return a;
    }


    private static <T> String toMapKey(T t, String... x) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            try {
                stringBuilder.append(BeanUtils.getProperty(t, x[i]));
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException("参数异常!", e);
            } catch (InvocationTargetException e) {
                throw new IllegalArgumentException("参数异常!", e);
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("参数异常!", e);
            }
            if (i != x.length - 1) stringBuilder.append("_");
        }
        return stringBuilder.toString();
    }


}
