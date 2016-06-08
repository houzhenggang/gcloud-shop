package com.gcloud.shop.api.internal.mapping;

import com.gcloud.shop.api.ApiException;

import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: Reader
 * @Package com.gcloud.shop.api.internal.mapping
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:35
 */
public interface Reader {

    boolean hasReturnField(Object var1);

    Object getPrimitiveObject(Object var1);

    Object getObject(Object var1, Class<?> var2) throws ApiException;

    List<?> getListObjects(Object var1, Object var2, Class<?> var3) throws ApiException;
}
