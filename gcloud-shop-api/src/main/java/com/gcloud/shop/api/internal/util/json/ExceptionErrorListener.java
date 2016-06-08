package com.gcloud.shop.api.internal.util.json;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ExceptionErrorListener
 * @Package com.gcloud.shop.api.internal.util.json
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:38
 */
public class ExceptionErrorListener extends BufferErrorListener {

    public ExceptionErrorListener() {

    }

    public void error(String type, int col) {
        super.error(type, col);
        throw new IllegalArgumentException(this.buffer.toString());
    }
}
