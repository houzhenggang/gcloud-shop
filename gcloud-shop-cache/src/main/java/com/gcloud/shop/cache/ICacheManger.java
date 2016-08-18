package com.gcloud.shop.cache;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ICacheManger
 * @Package com.gcloud.shop.cache
 * @Description: cache缓存管理类
 * @date 2016/7/19 16:54
 */
public interface ICacheManger {

    /**
     * 创建session
     * @param  object
     * @return
     * @throws CacheException
     */
    public ICache createCache(String sessionKey, Object object) throws CacheException;

    /**
     * 获取Session
     * @param sessionKey
     * @return
     * @throws CacheException
     */
    public ICache getCache(String sessionKey) throws CacheException;

    /**
     * 删除Session
     * @param sessionKey
     * @return
     * @throws CacheException
     */
    public ICache delCache(String sessionKey) throws CacheException;

    /**
     * 修改Session
     * @param sessionKey
     * @return
     * @throws CacheException
     */
    public ICache modCache(String sessionKey) throws CacheException;

}
