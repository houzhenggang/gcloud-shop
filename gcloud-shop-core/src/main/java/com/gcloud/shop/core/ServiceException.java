package com.gcloud.shop.core;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ServiceException
 * @Package com.gcloud.shop.core
 * @Description: Servcie异常类
 * @date 2016/7/19 16:54
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = -8113101052534916105L;

    /**
     * 异常对应的返回码
     */
    private String msgCode;

    /**
     * 异常对应的描述信息
     */
    private String msgDesc;

    public ServiceException() {
        super();
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }

    public ServiceException(String message) {
        super(message);
        msgDesc = message;
    }

    public ServiceException(String msgCode, String msgDesc) {
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
