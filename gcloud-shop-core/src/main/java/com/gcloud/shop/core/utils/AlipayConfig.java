package com.gcloud.shop.core.utils;

import java.io.Serializable;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AlipayConfig
 * @Package com.gcloud.shop.core.utils
 * @Description: 支付宝配置信息
 * @date 2016/6/1 13:53
 */
public class AlipayConfig implements Serializable {

    // 接口请求网关，固定值
    public static final String URL = "https://openapi.alipay.com/gateway.do";
    // 商户应用APPID，只要您的应用中包含服务窗接口且是开通状态，就可以用此应用对应的appid。开发者可登录开放平台-管理中心-对应应用中查看
    public static final String APPID = "2016070201575604";
    // 编码字符集。默认 utf-8
    public static final String CHARSET = "utf-8";
    // 返回格式。默认json
    public static final String FORMAT = "json";
    // 支付宝公钥，用于获取同步返回信息后进行验证，验证是否是支付宝发送的信息。
    public static final String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";

    // 开发者应用私钥。java配置PKCS8格式，PHP/.Net语言配置rsa_private_key.pem文件中原始私钥。
    public static final String RSA_RRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANRO9uIp5RY9ug/p9G4V0F09AYMT12PgYV2bzlbAdsNRSpXx+ABBSFUmQF4pJHPKuv1P1CMoEwuo6UGl+8gE21ovCmCm7aiMIGz3j42ojguf61PM/u5kNKhPh3rgnTU0vsbARXsn58E8UzTJ2VLH1hJFtpHpXGKlEBYB55X8RJgrAgMBAAECgYB2MM938GK8Evj1ywRsFHC+tyuUUQNjcpJBjm88FEEJUsP23ZF2cuFVpcnHoZfNblrSkhJC0BhqMUpJZaHZI/sIIPeuLThDFq0GOcM9hEGezbzOdIuB2s6ehcXcE90Y218buLCFuqXQ9eMk5Yqji+vGsdSVZJiI/CU5jPR8m6YOwQJBAP7Gu0N2onvBkTqrNB1Pk2ZR01dY7tsthtbIXCvmKXB4Gi+6SSjEd5adYYvzsRQIaiWyNQVzK4wqhfpalR7WUVkCQQDVVAPiVtQcqcNbJu4UGvF6t9AawN6f19QPUuiGOkhcO0kDFXcE+p8HjSoayc88v1or5P1B5Ojs9MqIura18yEjAkEArw0Su462oztjMqFRJFZ5m1LbV+eV7ehA/jAaDFuO22TZ8TMYczdSR50I2eTtJSuG6zGfdogkQqEw/svgK5jruQJAEcXSHQVG3qx2Dh4ML7ie7a5qtA/lfEOq8yvhG223oZd+2bbsF4oZvbNRErJFhbYbeRS21MqRbUxno0SK/FWpKQJBANhql4fsWTmoEc0PBnUeaShBovB+ybzZFE2dHE+clP2tMrwAm13GdJ52KptvpmIdhWD2F/8Y+Tp/EVUL4nlMBO0=";
    // 开发者应用私钥。java配置PKCS8格式，PHP/.Net语言配置rsa_private_key.pem文件中原始私钥。
    public static final String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDUTvbiKeUWPboP6fRuFdBdPQGDE9dj4GFdm85WwHbDUUqV8fgAQUhVJkBeKSRzyrr9T9QjKBMLqOlBpfvIBNtaLwpgpu2ojCBs94+NqI4Ln+tTzP7uZDSoT4d64J01NL7GwEV7J+fBPFM0ydlSx9YSRbaR6VxipRAWAeeV/ESYKwIDAQAB";
}
