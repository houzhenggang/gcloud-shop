package com.gcloud.shop.api.exception;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GcloudApiRuleException
 * @Package com.gcloud.shop.api.exception
 * @Description: 系统授权异常类
 * @date 2016/6/8 11:00
 */
public class GcloudRuleException extends GcloudException {

    private static final long serialVersionUID = 1258253811529294385L;

    public GcloudRuleException(String errorCode, String errorMessage){
        super(errorCode, errorMessage);
    }
}
