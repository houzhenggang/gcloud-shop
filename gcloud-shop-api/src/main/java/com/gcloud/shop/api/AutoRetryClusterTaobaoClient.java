package com.gcloud.shop.api;

import com.gcloud.shop.api.internal.dns.ClusterUtils;
import com.gcloud.shop.api.internal.dns.DNSConfig;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AutoRetryClusterTaobaoClient
 * @Package com.gcloud.shop.api
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:13
 */
public class AutoRetryClusterTaobaoClient  extends AutoRetryTaobaoClient {

    public AutoRetryClusterTaobaoClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout, String signMethod) throws ApiException {
        super(serverUrl, appKey, appSecret, format, connectTimeout, readTimeout, signMethod);
        this.startConfigThread();
    }

    public AutoRetryClusterTaobaoClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout) throws ApiException {
        super(serverUrl, appKey, appSecret, format, connectTimeout, readTimeout);
        this.startConfigThread();
    }

    public AutoRetryClusterTaobaoClient(String serverUrl, String appKey, String appSecret, String format) throws ApiException {
        super(serverUrl, appKey, appSecret, format);
        this.startConfigThread();
    }

    public AutoRetryClusterTaobaoClient(String serverUrl, String appKey, String appSecret) throws ApiException {
        super(serverUrl, appKey, appSecret);
        this.startConfigThread();
    }

    public <T extends TaobaoResponse> T execute(TaobaoRequest<T> request, String session) throws ApiException {
        String host = null;
        String nextVipUrl = null;
        DNSConfig config = this.getDNSConfig();
        if(config != null && !config.isDisable()) {
            host = ClusterUtils.transferServerUrlToIp(this.getServerUrl(), request.getApiMethodName(), session, config);
            nextVipUrl = this.transferServerUrl(host);
        }

        this.startConfigThread();
        TaobaoResponse response = null;

        try {
            response = super.execute(request, session, nextVipUrl);
        } catch (ApiException var8) {
            if(host != null) {
                ClusterUtils.addErrorCount(host);
            }
        }
        //mod by chenjin return response;
        return (T)response;
    }
}