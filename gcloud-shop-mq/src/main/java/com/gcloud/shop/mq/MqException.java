package com.gcloud.shop.mq;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: MqException
 * @Package com.gcloud.shop.mq
 * @Description: Servcie异常类
 * @date 2016/7/19 16:54
 */
public class MqException extends Exception {

    private static final long serialVersionUID = -7675525277660530847L;

    /**
     * 异常对应的返回码
     */
    private String msgCode;

    /**
     * 异常对应的描述信息
     */
    private String msgDesc;

    public MqException() {
        super();
    }

    public MqException(Throwable throwable) {
        super(throwable);
    }

    public MqException(String message) {
        super(message);
        msgDesc = message;
    }

    public MqException(String msgCode, String msgDesc) {
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
