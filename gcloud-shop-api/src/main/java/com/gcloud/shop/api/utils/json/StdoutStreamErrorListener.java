package com.gcloud.shop.api.utils.json;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: StdoutStreamErrorListener
 * @Package com.gcloud.shop.api.utils.json
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 11:51
 */
public class StdoutStreamErrorListener extends BufferErrorListener {

    public StdoutStreamErrorListener() {

    }

    public void end() {
        System.out.print(this.buffer.toString());
    }
}
