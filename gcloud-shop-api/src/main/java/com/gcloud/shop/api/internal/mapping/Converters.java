package com.gcloud.shop.api.internal.mapping;

import com.gcloud.shop.api.ApiException;
import com.gcloud.shop.api.TaobaoResponse;
import com.gcloud.shop.api.internal.util.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: Converters
 * @Package com.gcloud.shop.api.internal.mapping
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:34
 */
public class Converters {

    public static boolean isCheckJsonType = false;
    private static final Set<String> baseFields = new HashSet();
    private static final Map<String, Field> fieldCache = new ConcurrentHashMap();

    private Converters() {
    }

    public static <T> T convert(Class<T> clazz, Reader reader) throws ApiException {
        Object rsp = null;

        try {
            rsp = clazz.newInstance();
            BeanInfo e = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] pds = e.getPropertyDescriptors();
            PropertyDescriptor[] arr$ = pds;
            int len$ = pds.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                PropertyDescriptor pd = arr$[i$];
                Method method = pd.getWriteMethod();
                if(method != null) {
                    String itemName = pd.getName();
                    String listName = null;
                    Field field;
                    if(baseFields.contains(itemName) && TaobaoResponse.class.isAssignableFrom(clazz)) {
                        field = getField(TaobaoResponse.class, pd);
                    } else {
                        field = getField(clazz, pd);
                    }

                    ApiField jsonField = (ApiField)field.getAnnotation(ApiField.class);
                    if(jsonField != null) {
                        itemName = jsonField.value();
                    }

                    ApiListField jsonListField = (ApiListField)field.getAnnotation(ApiListField.class);
                    if(jsonListField != null) {
                        listName = jsonListField.value();
                    }

                    if(reader.hasReturnField(itemName) || listName != null && reader.hasReturnField(listName)) {
                        Class typeClass = field.getType();
                        Object obj;
                        if(String.class.isAssignableFrom(typeClass)) {
                            obj = reader.getPrimitiveObject(itemName);
                            if(obj instanceof String) {
                                method.invoke(rsp, new Object[]{obj.toString()});
                            } else {
                                if(isCheckJsonType && obj != null) {
                                    throw new ApiException(itemName + " is not a String");
                                }

                                if(obj != null) {
                                    method.invoke(rsp, new Object[]{obj.toString()});
                                } else {
                                    method.invoke(rsp, new Object[]{""});
                                }
                            }
                        } else if(Long.class.isAssignableFrom(typeClass)) {
                            obj = reader.getPrimitiveObject(itemName);
                            if(obj instanceof Long) {
                                method.invoke(rsp, new Object[]{(Long)obj});
                            } else {
                                if(isCheckJsonType && obj != null) {
                                    throw new ApiException(itemName + " is not a Number(Long)");
                                }

                                if(StringUtils.isNumeric(obj)) {
                                    method.invoke(rsp, new Object[]{Long.valueOf(obj.toString())});
                                }
                            }
                        } else if(Integer.class.isAssignableFrom(typeClass)) {
                            obj = reader.getPrimitiveObject(itemName);
                            if(obj instanceof Integer) {
                                method.invoke(rsp, new Object[]{(Integer)obj});
                            } else {
                                if(isCheckJsonType && obj != null) {
                                    throw new ApiException(itemName + " is not a Number(Integer)");
                                }

                                if(StringUtils.isNumeric(obj)) {
                                    method.invoke(rsp, new Object[]{Integer.valueOf(obj.toString())});
                                }
                            }
                        } else if(Boolean.class.isAssignableFrom(typeClass)) {
                            obj = reader.getPrimitiveObject(itemName);
                            if(obj instanceof Boolean) {
                                method.invoke(rsp, new Object[]{(Boolean)obj});
                            } else {
                                if(isCheckJsonType && obj != null) {
                                    throw new ApiException(itemName + " is not a Boolean");
                                }

                                if(obj != null) {
                                    method.invoke(rsp, new Object[]{Boolean.valueOf(obj.toString())});
                                }
                            }
                        } else if(Double.class.isAssignableFrom(typeClass)) {
                            obj = reader.getPrimitiveObject(itemName);
                            if(obj instanceof Double) {
                                method.invoke(rsp, new Object[]{(Double)obj});
                            } else if(isCheckJsonType && obj != null) {
                                throw new ApiException(itemName + " is not a Double");
                            }
                        } else if(Number.class.isAssignableFrom(typeClass)) {
                            obj = reader.getPrimitiveObject(itemName);
                            if(obj instanceof Number) {
                                method.invoke(rsp, new Object[]{(Number)obj});
                            } else if(isCheckJsonType && obj != null) {
                                throw new ApiException(itemName + " is not a Number");
                            }
                        } else if(Date.class.isAssignableFrom(typeClass)) {
                            SimpleDateFormat var23 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            var23.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                            Object paramType = reader.getPrimitiveObject(itemName);
                            if(paramType instanceof String) {
                                method.invoke(rsp, new Object[]{var23.parse(paramType.toString())});
                            }
                        } else if(List.class.isAssignableFrom(typeClass)) {
                            Type var24 = field.getGenericType();
                            if(var24 instanceof ParameterizedType) {
                                ParameterizedType var22 = (ParameterizedType)var24;
                                Type[] genericTypes = var22.getActualTypeArguments();
                                if(genericTypes != null && genericTypes.length > 0 && genericTypes[0] instanceof Class) {
                                    Class subType = (Class)genericTypes[0];
                                    List listObjs = reader.getListObjects(listName, itemName, subType);
                                    if(listObjs != null) {
                                        method.invoke(rsp, new Object[]{listObjs});
                                    }
                                }
                            }
                        } else {
                            obj = reader.getObject(itemName, typeClass);
                            if(obj != null) {
                                method.invoke(rsp, new Object[]{obj});
                            }
                        }
                    }
                }
            }

            return (T)rsp; //mod by chenjin
        } catch (Exception var21) {
            throw new ApiException(var21);
        }
    }

    private static Field getField(Class<?> clazz, PropertyDescriptor pd) throws Exception {
        String key = clazz.getName() + "_" + pd.getName();
        Field field = (Field)fieldCache.get(key);
        if(field == null) {
            field = clazz.getDeclaredField(pd.getName());
            fieldCache.put(key, field);
        }

        return field;
    }

    static {
        baseFields.add("errorCode");
        baseFields.add("msg");
        baseFields.add("subCode");
        baseFields.add("subMsg");
        baseFields.add("body");
        baseFields.add("params");
        baseFields.add("success");
        baseFields.add("topForbiddenFields");
    }
}

