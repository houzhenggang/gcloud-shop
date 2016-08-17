package com.gcloud.shop.solr;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: SolrException
 * @Package com.gcloud.pay.core
 * @Description: Servcie异常类
 * @date 2016/7/19 16:54
 */
public class SolrException extends Exception {

    private static final long serialVersionUID = -3930179588948221379L;

    /**
     * 异常对应的返回码
     */
    private String msgCode;

    /**
     * 异常对应的描述信息
     */
    private String msgDesc;

    public SolrException() {
        super();
    }

    public SolrException(Throwable throwable) {
        super(throwable);
    }

    public SolrException(String message) {
        super(message);
        msgDesc = message;
    }

    public SolrException(String msgCode, String msgDesc) {
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
