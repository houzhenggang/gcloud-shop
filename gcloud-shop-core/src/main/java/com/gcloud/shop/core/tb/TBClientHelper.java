package com.gcloud.shop.core.tb;

import com.gcloud.shop.api.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TBClientHelper
 * @Package com.gcloud.shop.core.tb
 * @Description: 访问淘宝SDK的客户端类
 * @date 2016/6/8 16:26
 */
@Service("tbClientHelper")
public class TBClientHelper {

    final static Logger logger = LogManager.getLogger(TBClientHelper.class);

    private String appKey = TBConstant.APPKEY;

    private String appSecret = TBConstant.APPSECRET;

    private String sessionId;

    /**
     * 是否使用沙箱环境，默认为正式环境
     */
    private boolean useSandBox = false;

    /**
     * 重试次数。当访问淘宝接口失败时，将会重试，直到重试次数超过设置的数量
     */
    private int retryCount = 5;

    /**
     * 重试间隔
     */
    private long retryInterval = 1000;

    public TBClientHelper(){

    }

    public TBClientHelper(String appKey, String appSecret, String sessionId) {
        init(appKey, appSecret, sessionId);
    }

    public TBClientHelper(String sessionId) {

        if (System.getProperty("taobao.sandbox") != null && "true".equals(System.getProperty("taobao.sandbox"))) {
            useSandBox = true;
            init(TBConstant.SANDBOX_APPKEY,TBConstant.SANDBOX_APPSECRET, sessionId);
        } else {
            // TODO 测试用
            if (sessionId.equals("620091624ef10c408c0bd465ZZ09b8b5a5eefe316ca8183381696371")) {
                init("12011554", "a6b35e3cff015ed3bf93ba587d68e77c", sessionId);
            } else {
                init(null, null, sessionId);
            }
        }
    }
    /**
     * 初始化taobao API 配置信息
     * @param appKey
     * @param appSecret
     * @param sessionId
     */
    private void init(String appKey, String appSecret, String sessionId) {

        if (!StringUtils.isEmpty(appKey)){
            this.appKey = appKey;
        }
        if (!StringUtils.isEmpty(appSecret)){
            this.appSecret = appSecret;
        }
        this.sessionId = sessionId;
    }

    /**
     * 重试次数。当访问淘宝接口失败时，将会重试，直到重试次数超过设置的数量
     *
     * @return
     */
    public int getRetryCount() {
        return retryCount;
    }

    /**
     * 重试次数。当访问淘宝接口失败时，将会重试，直到重试次数超过设置的数量
     *
     * @param retryCount
     */
    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    /**
     * 重试间隔
     *
     * @return
     */
    public long getRetryInterval() {
        return retryInterval;
    }

    /**
     * 重试间隔
     *
     * @param retryInterval
     */
    public void setRetryInterval(long retryInterval) {
        this.retryInterval = retryInterval;
    }

    /**
     * 是否使用沙箱环境，默认为正式环境
     *
     * @return
     */
    public boolean isUseSandBox() {
        return useSandBox;
    }

    /**
     * 是否使用沙箱环境，默认为正式环境
     *
     * @param useSandBox
     */
    public void setUseSandBox(boolean useSandBox) {
        this.useSandBox = useSandBox;
    }

    /**
     * 获取淘宝授权码URL
     * @return
     */
    public String getTaoBaoAuthorizeUrl() {
        return this.useSandBox ? TBConstant.SDK_SANDBOX_AUTHORIZE_URL: TBConstant.SDK_AUTHORIZE_URL;
    }

    /**
     * 获取淘宝授权令牌URL
     * @return
     */
    public String getTaoBaoTokenUrl() {
        return this.useSandBox ? TBConstant.SDK_SANDBOX_TOKEN_URL : TBConstant.SDK_TOKEN_URL;
    }

    /**
     * 获取淘宝SDK URL
     * @return
     */
    public String getTaoBaoSdkUrl() {
        return this.useSandBox ? TBConstant.SDK_SANDBOX_URL : TBConstant.SDK_FORMAL_URL;
    }

    /**
     * 不处理异常的单个请求
     *
     * @param request
     * @return
     * @throws ApiException
     */
    protected TaobaoResponse requestNoHandle(TaobaoClient client, TaobaoRequest<?> request) throws ApiException {
        if (sessionId == null) {
            return client.execute(request);
        }
        return client.execute(request, sessionId);
    }

    /**
     * 访问淘宝API
     * @param request
     * @param <T>
     * @return
     * @throws TBAccessException
     */
    public <T extends TaobaoResponse> T request(TaobaoRequest<T> request) throws TBAccessException {
        TaobaoClient client = null;
        try {
            client = new ClusterTaobaoClient(this.getTaoBaoSdkUrl(), appKey, appSecret);
        } catch (Exception e) {
            throw new TBAccessException(e);
        }
        ApiException exce = null;
        TaobaoResponse rsp = null;
        for (int i = 0; i <= retryCount; i++) {
            try {
                rsp = requestNoHandle(client, request);
                if (!checkExceptionAndRetry(rsp)){
                    return (T) rsp;
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (ApiException e) {
                exce = e;
                logger.error(" request " + e.getMessage());
            }
        }
        if(null != rsp){
            throw new TBAccessException(TBAccessException.toConvertMsg(rsp),rsp);
        }
        if (null == exce){
            throw new TBAccessException("Access taobao server error");
        }
        throw new TBAccessException(exce);
    }

    /**
     * 判断错误类型，如果是因为淘宝方出错继续调用，否则直接返回
     *
     * @return 如果返回true表示需要retry
     * @throws TBAccessException
     */
    private boolean checkExceptionAndRetry(TaobaoResponse response) throws TBAccessException {
        if (null != response && response.isSuccess()){
            return false;
        }
        if (TBConstant.INVALID_SESSION.equals(response.getErrorCode())) {
            throw new TBAccessException(response);
        }
        if ("user-not-exist".equals(response.getMsg())) {
            throw new TBAccessException(response);
        }
        if (StringUtils.contains(response.getMsg(), "App Call Limited")){
            return true;
        }
        if (response != null && response.getSubCode() != null) {
            String subCode = response.getSubCode();
            if (isRetryError(subCode))
                return true;
        }
        if (!StringUtils.isEmpty(response.getErrorCode())) {
            throw new TBAccessException(TBAccessException.toConvertMsg(response),response);
        }

        return false;
    }

    /**
     * 检查是否错误
     * @param subCode
     * @return
     */
    private boolean isRetryError(String subCode) {

        if (subCode.contains("service-unavailable")){
            return true;
        }
        if (subCode.contains("remote-service-error")){
            return true;
        }
        if (subCode.contains("remote-service-timeout")){
            return true;
        }
        if (subCode.contains("remote-connection-error")){
            return true;
        }
        if (subCode.contains("top-remote-connection-timeout")){
            return true;
        }
        if (subCode.contains("top-remote-connection-error")){
            return true;
        }
        if (subCode.contains("unknown-error")){
            return true;
        }
        return false;

    }
}

