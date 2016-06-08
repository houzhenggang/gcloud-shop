package com.gcloud.shop.api.internal.dns;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: EnvConfig
 * @Package com.gcloud.shop.api.internal.dns
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 13:42
 */
public class EnvConfig {

    private String host;
    private DomainConfig domain;

    public EnvConfig() {
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public DomainConfig getDomain() {
        return this.domain;
    }

    public void setDomain(DomainConfig domain) {
        this.domain = domain;
    }
}
