package com.gcloud.shop.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Administrator
 * @version V1.0
 * @Title: EventProcessor
 * @Package com.gcloud.shop.annotation
 * @Description: Event×¢½âÉ¨ÃèÆ÷
 * @date 2016/9/8 17:25
 */
public class EventProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return null;
    }
}
