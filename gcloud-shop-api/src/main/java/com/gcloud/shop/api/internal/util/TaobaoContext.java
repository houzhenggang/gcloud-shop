package com.gcloud.shop.api.internal.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TaobaoContext
 * @Package com.gcloud.shop.api.internal.util
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:43
 */
public class TaobaoContext {

    public static final String APPKEY = "top_appkey";
    public static final String SESSION = "top_session";
    public static final String SIGNATURE = "top_sign";
    public static final String PARAMETERS = "top_parameters";
    public static final String USER_ID = "visitor_id";
    public static final String USER_NICK = "visitor_nick";
    private Map<String, String> parameters = new HashMap();
    private String callbackUrl;

    public TaobaoContext() {
    }

    public String getAppKey() {
        return this.getParameter("top_appkey");
    }

    public String getSessionKey() {
        return this.getParameter("top_session");
    }

    public String getSignature() {
        return this.getParameter("top_sign");
    }

    public Long getUserId() {
        String userId = this.getParameter("visitor_id");
        return StringUtils.isEmpty(userId)?null:Long.valueOf(userId);
    }

    public String getUserNick() {
        return this.getParameter("visitor_nick");
    }

    public String getParameter(String key) {
        return (String)this.parameters.get(key);
    }

    public void addParameters(Map<String, String> parameters) {
        if(parameters != null && !parameters.isEmpty()) {
            this.parameters.putAll(parameters);
        }

    }

    public void addParameter(String key, String value) {
        this.parameters.put(key, value);
    }

    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
}
