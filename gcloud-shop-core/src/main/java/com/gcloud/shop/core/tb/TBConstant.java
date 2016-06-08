package com.gcloud.shop.core.tb;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TBConstant
 * @Package com.gcloud.shop.core.tb
 * @Description: 淘宝常量类
 * @date 2016/6/8 16:27
 */
public class TBConstant {

    /**
     * Invalid Session
     */
    public static final String INVALID_SESSION = "27";

    /**
     * 淘宝的正式环境
     */
    public static final String SDK_FORMAL_URL = "http://gw.api.taobao.com/router/rest";

    /**
     * 淘宝的沙箱环境
     */
    public static final String SDK_SANDBOX_URL = "http://gw.api.tbsandbox.com/router/rest";

    /**
     * 获取授权码(code)URL
     */
    public static final String SDK_AUTHORIZE_URL = "https://oauth.taobao.com/authorize";

    /**
     * 获取授权码(code)URL(沙箱)
     */
    public static final String SDK_SANDBOX_AUTHORIZE_URL = "https://oauth.tbsandbox.com/authorize";

    /**
     * 获取访问令牌(token)URL
     */
    public static final String SDK_TOKEN_URL = "https://oauth.taobao.com/token";

    /**
     * 获取访问令牌(token)URL(沙箱)
     */
    public static final String SDK_SANDBOX_TOKEN_URL = "https://oauth.tbsandbox.com/token";

    /**
     * 系统授权URL
     */
    public static final String SHOP_AUTH_URL = "http://shop.gcloud.com/auth2.do";

    /**
     * 系统跳转URL
     */
    public static final String SHOP_FORWARD_URL = "http://shop.gcloud.com/forward.do";

    /**
     * 沙箱环境 App Key
     */
    public static final String SANDBOX_APPKEY = "1012001121";

    /**
     * 沙箱环境 App Secret
     */
    public static final String SANDBOX_APPSECRET = "sandboxb289050d1b2ddb265c5cfe40a";

    /**
     * 正式环境 App Key
     */
    public static final String APPKEY = "12001121";//"12011554";

    /**
     * 正式环境 App Secret
     */
    public static final String APPSECRET = "157257cb289050d1b2ddb265c5cfe40a";//"a6b35e3cff015ed3bf93ba587d68e77c";

    /**
     * App Artical code
     */
    public static final String ARTICAL_CODE = "appstore-10316";
}
