package com.gcloud.shop.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;
import java.util.Set;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AutoRetryTaobaoClient
 * @Package com.gcloud.shop.api
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:14
 */
public class AutoRetryTaobaoClient extends DefaultTaobaoClient {
    private static final Log log = LogFactory.getLog(AutoRetryTaobaoClient.class);
    private static final ApiException RETRY_FAIL = new ApiException("sdk.retry-call-fail", "API调用重试失败");
    private int maxRetryCount = 3;
    private long retryWaitTime = 100L;
    private boolean throwIfOverMaxRetry = false;
    private Set<String> retryErrorCodes;

    public AutoRetryTaobaoClient(String serverUrl, String appKey, String appSecret) {
        super(serverUrl, appKey, appSecret);
    }

    public AutoRetryTaobaoClient(String serverUrl, String appKey, String appSecret, String format) {
        super(serverUrl, appKey, appSecret, format);
    }

    public AutoRetryTaobaoClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout) {
        super(serverUrl, appKey, appSecret, format, connectTimeout, readTimeout);
    }

    public AutoRetryTaobaoClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout, String signMethod) {
        super(serverUrl, appKey, appSecret, format, connectTimeout, readTimeout, signMethod);
    }

    public <T extends TaobaoResponse> T execute(TaobaoRequest<T> request) throws ApiException {
        return this.execute(request, (String)null);
    }

    public <T extends TaobaoResponse> T execute(TaobaoRequest<T> request, String session) throws ApiException {
        TaobaoResponse rsp = null;
        ApiException exp = null;

        for(int i = 0; i <= this.maxRetryCount; ++i) {
            if(i > 0) {
                if((rsp == null || (rsp.getSubCode() == null || !rsp.getSubCode().startsWith("isp.")) && (this.retryErrorCodes == null || !this.retryErrorCodes.contains(rsp.getSubCode()))) && exp == null) {
                    break;
                }

                this.sleepWithoutInterrupt(this.retryWaitTime);
                log.warn(this.buildRetryLog(request.getApiMethodName(), request.getTextParams(), i));
            }

            try {
                rsp = super.execute(request, session);
                if(rsp.isSuccess()) {
                    //mod by chenjin return rsp;
                    return (T)rsp;
                }

                if(i == this.maxRetryCount && this.throwIfOverMaxRetry) {
                    throw RETRY_FAIL;
                }
            } catch (ApiException var7) {
                if(exp == null) {
                    exp = var7;
                }
            }
        }

        if(exp != null) {
            throw exp;
        } else {
            //mod by chenjin return rsp;
            return (T)rsp;
        }
    }

    private String buildRetryLog(String apiName, Map<String, String> params, int retryCount) {
        StringBuilder sb = new StringBuilder();
        sb.append(apiName).append(" retry call ").append(retryCount);
        params.remove("fields");
        sb.append(" times, params=").append(params);
        return sb.toString();
    }

    public void setMaxRetryCount(int maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    public void setRetryWaitTime(long retryWaitTime) {
        this.retryWaitTime = retryWaitTime;
    }

    public void setThrowIfOverMaxRetry(boolean throwIfOverMaxRetry) {
        this.throwIfOverMaxRetry = throwIfOverMaxRetry;
    }

    public void setRetryErrorCodes(Set<String> retryErrorCodes) {
        this.retryErrorCodes = retryErrorCodes;
    }

    private void sleepWithoutInterrupt(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException var4) {
            Thread.currentThread().interrupt();
        }

    }
}