package com.gcloud.shop.api.utils.json;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: JSONErrorListener
 * @Package com.gcloud.shop.api.utils.json
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 11:48
 */
public interface JSONErrorListener {

    void start(String var1);

    void error(String var1, int var2);

    void end();
}
