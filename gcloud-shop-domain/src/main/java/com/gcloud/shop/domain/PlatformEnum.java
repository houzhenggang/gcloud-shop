package com.gcloud.shop.domain;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: PlatformEnum
 * @Package com.gcloud.domain
 * @Description: 平台枚举
 * @date 2016/6/1 13:53
 */
public enum PlatformEnum {

    PLATFORM_JD("JD","京东"),
    PLATFORM_TB("TB","淘宝");

    PlatformEnum(String code, String name){
        this.code = code;
        this.name = name;
    }
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
