package com.gcloud.shop.core;

import com.gcloud.shop.domain.user.Shop;
import com.gcloud.shop.domain.user.User;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: IsvService
 * @Package com.gcloud.shop.core
 * @Description: ISV操作接口
 * @date 2016/6/8 16:20
 */
public interface IsvService {

    /**
     * 获取店铺信息
     * @param nick
     * @param sessionId
     * @return
     */
    public Shop queryShop(String nick, String sessionId);

    /**
     * 用户第一次使用软件
     * @param nick
     * @param sessionId
     */
    public User firstInit(String nick, String sessionId);

    /**
     * 用户自定义初始化软件
     * @param nick
     * @param sessionId
     */
    public User nextInit(String nick, String sessionId);
}
