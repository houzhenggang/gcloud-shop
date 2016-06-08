package com.gcloud.shop.api.internal.dns;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: VIPRule
 * @Package com.gcloud.shop.api.internal.dns
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:33
 */
public class VIPRule {

    private String vip;
    private Double endPower;
    private Double startPower;

    public VIPRule() {
    }

    public String getVip() {
        return this.vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public Double getEndPower() {
        return this.endPower;
    }

    public void setEndPower(Double endPower) {
        this.endPower = endPower;
    }

    public Double getStartPower() {
        return this.startPower;
    }

    public void setStartPower(Double startPower) {
        this.startPower = startPower;
    }
}
