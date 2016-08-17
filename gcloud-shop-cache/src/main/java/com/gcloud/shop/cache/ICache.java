package com.gcloud.shop.cache;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: CacheException
 * @Package com.gcloud.shop.cache
 * @Description: Servcie异常类
 * @date 2016/7/19 16:54
 */
public interface ICache {

    /**
     * 保存数据
     * @return
     * @throws CacheException
     */
    public void putObject(String key, Object object) throws CacheException;

    /**
     * 获取数据
     * @return
     * @throws CacheException
     */
    public Object getObject(String key) throws CacheException;

    /**
     * 删除数据
     * @return
     * @throws CacheException
     */
    public Object delObject(String key) throws CacheException;

    /**
     * 修改数据
     * @return
     * @throws CacheException
     */
    public Object modObject(String key) throws CacheException;

    /**
     * 检查数据是否存在
     * @return
     * @throws CacheException
     */
    public boolean hasObject(String key) throws CacheException;

}
