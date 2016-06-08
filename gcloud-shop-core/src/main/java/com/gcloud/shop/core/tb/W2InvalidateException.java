package com.gcloud.shop.core.tb;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: W2InvalidateException
 * @Package com.gcloud.shop.core.tb
 * @Description: 淘宝的W2权限失效的异常
 * @date 2016/6/8 16:28
 */
public class W2InvalidateException extends RuntimeException {

    public W2InvalidateException(){
        super();
    }

    public W2InvalidateException(String msg){
        super(msg);
    }

}
