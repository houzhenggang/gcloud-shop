package com.gcloud.shop.cache;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: CacheException
 * @Package com.gcloud.shop.cache
 * @Description: Servcie异常类
 * @date 2016/7/19 16:54
 */
public interface ICacheManger {

    /**
     * 根据sessionId获取相应的会话对象
     * @param  object
     * @return
     * @throws CacheException
     */
    public ICache createCache(Object object) throws CacheException;

    /**
     * 创建Session
     * @param sessionId
     * @return
     * @throws CacheException
     */
    public ICache getCache(String sessionId) throws CacheException;

    /**
     * 获取cache配置
     * @return
     * @throws CacheException
     */
    public CacheConfig getCacheConfig() throws CacheException;

    /**
     * 获取cache配置
     * @return
     * @throws CacheException
     */
    public CacheConfig setCacheConfig(CacheConfig cacheConfig) throws CacheException;

}
