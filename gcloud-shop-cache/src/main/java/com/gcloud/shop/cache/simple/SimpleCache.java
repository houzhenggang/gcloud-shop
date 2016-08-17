package com.gcloud.shop.cache.simple;

import com.gcloud.shop.cache.CacheException;
import com.gcloud.shop.cache.ICache;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: CacheException
 * @Package com.gcloud.shop.cache
 * @Description: Servcie异常类
 * @date 2016/7/19 16:54
 */
public class SimpleCache implements ICache {

    @Override
    public void putObject(String key, Object object) throws CacheException {

    }

    @Override
    public Object getObject(String key) throws CacheException {
        return null;
    }

    @Override
    public Object delObject(String key) throws CacheException {
        return null;
    }

    @Override
    public Object modObject(String key) throws CacheException {
        return null;
    }

    @Override
    public boolean hasObject(String key) throws CacheException {
        return true;
    }
}
