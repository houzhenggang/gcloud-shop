package com.gcloud.shop.api.internal.dns;

import com.gcloud.shop.api.response.GcloudResponse;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: HttpdnsGetResponse
 * @Package com.gcloud.shop.api.internal.dns
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 13:43
 */
public class HttpdnsGetResponse extends GcloudResponse {

    private static final long serialVersionUID = 52907500325908892L;

    //    @ApiField("result")
    private String result;

    public HttpdnsGetResponse() {
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}
