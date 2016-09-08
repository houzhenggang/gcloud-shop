package com.gcloud.shop.annotation;

import java.lang.annotation.*;

/**
 * @author  ChenJin
 * @version V1.0
 * @Title:  EventName
 * @Package com.gcloud.shop.annotation
 * @Description: ÊÂ¼þÃû³Æ
 * @date 2016/9/8 17:23
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EventName {

    String value() default "";

}
