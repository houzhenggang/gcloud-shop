package com.gcloud.shop.cache.ocs;

import com.gcloud.shop.cache.CacheException;
import com.gcloud.shop.cache.ICache;

/**
 * @author chenjin
 * @version V1.0
 * @Title: OcsCache
 * @Package com.gcloud.shop.cache.ocs
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 16-8-17 下午9:51
 */
public class OcsCache implements ICache {

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
