package com.gcloud.shop.api.internal.dns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: DomainConfig
 * @Package com.gcloud.shop.api.internal.dns
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:31
 */
public class DomainConfig {

    private List<VIPRule> vip;
    private String proto;

    public DomainConfig() {
    }

    public List<VIPRule> getVip() {
        return this.vip;
    }

    public void setVip(List<VIPRule> vip) {
        this.vip = vip;
    }

    public String getProto() {
        return this.proto;
    }

    public void setProto(String proto) {
        this.proto = proto;
    }

    public List<String> getVipList() {
        ArrayList vipList = new ArrayList();
        Iterator i$ = this.vip.iterator();

        while(i$.hasNext()) {
            VIPRule rule = (VIPRule)i$.next();
            vipList.add(rule.getVip());
        }

        return vipList;
    }
}
