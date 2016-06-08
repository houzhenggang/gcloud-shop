package com.gcloud.shop.api;

import com.gcloud.shop.api.request.GcloudRequest;
import com.gcloud.shop.api.response.GcloudResponse;

import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GcloudUploadRequest
 * @Package com.gcloud.shop.api
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 14:24
 */
public interface GcloudUploadRequest <T extends GcloudResponse> extends GcloudRequest<T> {

    Map<String, FileItem> getFileParams();
}
