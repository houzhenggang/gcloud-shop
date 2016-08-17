package com.gcloud.shop.sync;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: MqException
 * @Package com.gcloud.shop.mq
 * @Description: Servcie异常类
 * @date 2016/7/19 16:54
 */
public class SyncException extends Exception {

    private static final long serialVersionUID = 1473300564326643798L;

    /**
     * 异常对应的返回码
     */
    private String msgCode;

    /**
     * 异常对应的描述信息
     */
    private String msgDesc;

    public SyncException() {
        super();
    }

    public SyncException(Throwable throwable) {
        super(throwable);
    }

    public SyncException(String message) {
        super(message);
        msgDesc = message;
    }

    public SyncException(String msgCode, String msgDesc) {
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
