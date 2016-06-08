package com.gcloud.shop.api;

import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TaobaoUploadRequest
 * @Package com.gcloud.shop.api
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:24
 */
public interface TaobaoUploadRequest <T extends TaobaoResponse> extends TaobaoRequest<T> {
    Map<String, FileItem> getFileParams();
}
