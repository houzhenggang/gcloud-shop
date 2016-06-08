package com.gcloud.shop.api.internal.dns;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ApiRule
 * @Package com.gcloud.shop.api.internal.dns
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:26
 */
public class ApiRule {

    private String name;
    private Double endPower;
    private Double startPower;

    public ApiRule() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
