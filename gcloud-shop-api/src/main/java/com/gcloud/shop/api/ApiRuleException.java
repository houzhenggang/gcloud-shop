package com.gcloud.shop.api;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ApiRuleException
 * @Package com.gcloud.shop.api
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:13
 */
public class ApiRuleException extends ApiException {

    private static final long serialVersionUID = 4900626920354481875L;

    public ApiRuleException(String errCode, String errMsg) {
        super(errCode, errMsg);
    }
}
