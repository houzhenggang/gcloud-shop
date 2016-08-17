package com.gcloud.shop.cache.memcache;

import com.gcloud.shop.cache.CacheException;
import com.gcloud.shop.cache.ICache;

/**
 * @author chenjin
 * @version V1.0
 * @Title: MemCache
 * @Package com.gcloud.shop.cache.memcache
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 16-8-17 下午9:52
 */
public class MemCache implements ICache {

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
