package com.gcloud.shop.api.internal.util.json;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: StdoutStreamErrorListener
 * @Package com.gcloud.shop.api.internal.util.json
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:41
 */
public class StdoutStreamErrorListener extends BufferErrorListener {

    public StdoutStreamErrorListener() {

    }

    public void end() {
        System.out.print(this.buffer.toString());
    }
}
