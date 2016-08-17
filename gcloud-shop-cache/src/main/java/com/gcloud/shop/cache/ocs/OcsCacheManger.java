package com.gcloud.shop.cache.ocs;

import com.gcloud.shop.cache.CacheConfig;
import com.gcloud.shop.cache.CacheException;
import com.gcloud.shop.cache.ICache;
import com.gcloud.shop.cache.ICacheManger;

/**
 * @author chenjin
 * @version V1.0
 * @Title: OcsCacheManger
 * @Package com.gcloud.shop.cache.ocs
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 16-8-17 下午9:52
 */
public class OcsCacheManger implements ICacheManger {

    @Override
    public ICache createCache(Object object) throws CacheException {
        return null;
    }

    @Override
    public ICache getCache(String sessionId) throws CacheException {
        return null;
    }

    @Override
    public CacheConfig getCacheConfig() throws CacheException {
        return null;
    }

    @Override
    public CacheConfig setCacheConfig(CacheConfig cacheConfig) throws CacheException {
        return null;
    }
}
