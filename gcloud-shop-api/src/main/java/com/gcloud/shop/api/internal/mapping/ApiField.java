package com.gcloud.shop.api.internal.mapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ApiField
 * @Package com.gcloud.shop.api.internal.mapping
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:33
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ApiField {

    String value() default "";
}