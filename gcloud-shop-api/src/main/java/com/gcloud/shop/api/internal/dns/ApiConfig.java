package com.gcloud.shop.api.internal.dns;

import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ApiConfig
 * @Package com.gcloud.shop.api.internal.dns
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:26
 */
public class ApiConfig {

    private List<ApiRule> rule;
    private String user;

    public ApiConfig() {
    }

    public List<ApiRule> getRule() {
        return this.rule;
    }

    public void setRule(List<ApiRule> rule) {
        this.rule = rule;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
