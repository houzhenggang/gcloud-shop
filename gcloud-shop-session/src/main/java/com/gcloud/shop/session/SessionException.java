package com.gcloud.shop.session;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: MqException
 * @Package com.gcloud.shop.mq
 * @Description: Servcie异常类
 * @date 2016/7/19 16:54
 */
public class SessionException extends Exception {

    private static final long serialVersionUID = -5623408920329210928L;

    /**
     * 异常对应的返回码
     */
    private String msgCode;

    /**
     * 异常对应的描述信息
     */
    private String msgDesc;

    public SessionException() {
        super();
    }

    public SessionException(Throwable throwable) {
        super(throwable);
    }

    public SessionException(String message) {
        super(message);
        msgDesc = message;
    }

    public SessionException(String msgCode, String msgDesc) {
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
