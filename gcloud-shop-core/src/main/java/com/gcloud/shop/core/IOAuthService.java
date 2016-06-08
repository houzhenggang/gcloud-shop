package com.gcloud.shop.core;

import org.springframework.ui.Model;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: IOAuthService
 * @Package com.gcloud.shop.core
 * @Description: OAuth授权接口
 * @date 2016/6/8 16:18
 */
public interface IOAuthService {

    /**
     * oAuth获取授权Code
     * @param state 状态码
     * @return
     */
    public String authorize(String state);

    /**
     * oAuth获取授权Code URL
     * @param state
     * @return
     */
    public String authorizeUrl(String state);

    /**
     * oAuth授权token
     * @param model 请求参数
     * @param code 授权码
     * @return
     */
    public String oAuth2(Model model, String code);

}
