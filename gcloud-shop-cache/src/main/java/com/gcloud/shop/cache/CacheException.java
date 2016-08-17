package com.gcloud.shop.cache;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: CacheException
 * @Package com.gcloud.shop.cache
 * @Description: Servcie异常类
 * @date 2016/7/19 16:54
 */
public class CacheException extends Exception {

    private static final long serialVersionUID = 4071152502804969080L;

    /**
     * 异常对应的返回码
     */
    private String msgCode;

    /**
     * 异常对应的描述信息
     */
    private String msgDesc;

    public CacheException() {
        super();
    }

    public CacheException(Throwable throwable) {
        super(throwable);
    }

    public CacheException(String message) {
        super(message);
        msgDesc = message;
    }

    public CacheException(String msgCode, String msgDesc) {
        super(msgDesc);
        this.msgCode = msgCode;
        this.msgDesc = msgDesc;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public String getMsgDesc() {
        return msgDesc;
    }
}
