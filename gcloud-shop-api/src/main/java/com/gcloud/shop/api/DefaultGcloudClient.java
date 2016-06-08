package com.gcloud.shop.api;

import com.gcloud.shop.api.exception.GcloudException;
import com.gcloud.shop.api.exception.GcloudRuleException;
import com.gcloud.shop.api.internal.dns.AutoUpdateConfigThread;
import com.gcloud.shop.api.internal.dns.ClusterUtils;
import com.gcloud.shop.api.internal.dns.DNSConfig;
import com.gcloud.shop.api.internal.parser.GcloudParser;
import com.gcloud.shop.api.internal.parser.ObjectJsonParser;
import com.gcloud.shop.api.internal.parser.xml.ObjectXmlParser;
import com.gcloud.shop.api.request.AreasGetRequest;
import com.gcloud.shop.api.request.GcloudRequest;
import com.gcloud.shop.api.response.GcloudResponse;
import com.gcloud.shop.api.utils.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: DefaultGcloudClient
 * @Package com.gcloud.shop.api
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 14:08
 */
public class DefaultGcloudClient implements GcloudClient {

    private static final String APP_KEY = "app_key";
    private static final String FORMAT = "format";
    private static final String METHOD = "method";
    private static final String TIMESTAMP = "timestamp";
    private static final String VERSION = "v";
    private static final String SIGN = "sign";
    private static final String SIGN_METHOD = "sign_method";
    private static final String PARTNER_ID = "partner_id";
    private static final String SESSION = "session";
    private static final String SIMPLIFY = "simplify";
    private static final String TARGETAPPKEK = "target_app_key";
    
    private String serverUrl;
    private String appKey;
    private String appSecret;
    private String format;
    private String signMethod;
    private int connectTimeout;
    private int readTimeout;
    private boolean needCheckRequest;
    private boolean needEnableParser;
    private boolean useSimplifyJson;
    private boolean useGzipEncoding;
    private AutoUpdateConfigThread autoConfigThread;
    private String targetAppKey;

    public DefaultGcloudClient(){

    }

    public DefaultGcloudClient(String serverUrl, String appKey, String appSecret) {
        this.format = "json";
        this.signMethod = "hmac";
        this.connectTimeout = 3000;
        this.readTimeout = 15000;
        this.needCheckRequest = true;
        this.needEnableParser = true;
        this.useSimplifyJson = false;
        this.useGzipEncoding = false;
        this.autoConfigThread = null;
        this.targetAppKey = null;
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.serverUrl = serverUrl;
    }

    public DefaultGcloudClient(String serverUrl, String appKey, String appSecret, String format) {
        this(serverUrl, appKey, appSecret);
        this.format = format;
    }

    public DefaultGcloudClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout) {
        this(serverUrl, appKey, appSecret, format);
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    public DefaultGcloudClient(String serverUrl, String appKey, String appSecret, String format, int connectTimeout, int readTimeout, String signMethod) {
        this(serverUrl, appKey, appSecret, format, connectTimeout, readTimeout);
        this.signMethod = signMethod;
    }

    public <T extends GcloudResponse> T execute(GcloudRequest<T> request) throws GcloudException {
        return this.execute(request, (String)null);
    }

    public <T extends GcloudResponse> T execute(GcloudRequest<T> request, String session) throws GcloudException {
        Object parser = null;
        if(this.needEnableParser) {
            if("xml".equals(this.format)) {
                parser = new ObjectXmlParser(request.getResponseClass());
            } else {
                parser = new ObjectJsonParser(request.getResponseClass(), this.useSimplifyJson);
            }
        }

        return (T)this._execute(request, (GcloudParser)parser, session, (String)null);
    }

    public <T extends GcloudResponse> T execute(GcloudRequest<T> request, String session, String nextVipUrl) throws GcloudException {
        Object parser = null;
        if(this.needEnableParser) {
            if("xml".equals(this.format)) {
                parser = new ObjectXmlParser(request.getResponseClass());
            } else {
                parser = new ObjectJsonParser(request.getResponseClass(), this.useSimplifyJson);
            }
        }

        return (T)this._execute(request, (GcloudParser)parser, session, nextVipUrl);
    }

    public <T extends GcloudResponse> T updateExecute(GcloudRequest<T> request, String host) throws GcloudException {
        if(host == null) {
            host = ClusterUtils.transferServerUrlToIp(this.serverUrl, request.getMethodName(), (String)null, this.autoConfigThread.getConfig());
        }

        if(host != null) {
            this.transferServerUrl(host);
        }

        return this.execute(request);
    }

    public String transferServerUrl(String host) {
        try {
            URI uri = new URI(this.getServerUrl());
            if(!uri.getPath().startsWith("/top")) {
                host = host + "/top";
            }

            return uri.getScheme() + "://" + host + uri.getPath();
        } catch (URISyntaxException var4) {
            return null;
        }
    }

    public void startConfigThread() throws GcloudException {
        if(this.autoConfigThread == null || !this.autoConfigThread.isAlive()) {
            this.autoConfigThread = AutoUpdateConfigThread.getInstance("TOP-HTTPDNS", this);
            if(!this.autoConfigThread.isAlive()) {
                this.autoConfigThread.start();
            }
        }

    }

    private <T extends GcloudResponse> T _execute(GcloudRequest<T> request, GcloudParser<T> parser, String session, String nextVipUrl) throws GcloudException {
        GcloudResponse tRsp;
        if(this.needCheckRequest) {
            try {
                request.check();
            } catch (GcloudRuleException var11) {
                tRsp = null;

                try {
                    tRsp = (GcloudResponse)request.getResponseClass().newInstance();
                } catch (Exception var8) {
                    throw new GcloudException(var8);
                }

                tRsp.setErrorCode(var11.getErrorCode());
                tRsp.setErrorMessage(var11.getErrorMessage());
                return (T)tRsp;
            }
        }

        RequestParametersHolder context = this.doPost(request, session, nextVipUrl);
        tRsp = null;
        if(this.needEnableParser) {
            try {
                tRsp = parser.parse(context.getResponseBody());
                tRsp.setBody(context.getResponseBody());
            } catch (RuntimeException var10) {
                GcloudLogger.logBizError(context.getResponseBody());
                throw var10;
            }
        } else {
            try {
                tRsp = (GcloudResponse)request.getResponseClass().newInstance();
                tRsp.setBody(context.getResponseBody());
            } catch (Exception var9) {
                ;
            }
        }

        tRsp.setParams(context.getApplicationParams());
        if(!tRsp.isSuccess()) {
            GcloudLogger.logErrorScene(context, tRsp, this.appSecret);
        }

        return (T)tRsp;
    }

    public <T extends GcloudResponse> RequestParametersHolder doPost(GcloudRequest<T> request, String session) throws GcloudException {
        return this.doPost(request, session, (String)null);
    }

    public <T extends GcloudResponse> RequestParametersHolder doPost(GcloudRequest<T> request, String session, String nextVipUrl) throws GcloudException {
        RequestParametersHolder requestHolder = new RequestParametersHolder();
        GcloudHashMap appParams = new GcloudHashMap(request.getTextParams());
        requestHolder.setApplicationParams(appParams);
        GcloudHashMap protocalMustParams = new GcloudHashMap();
        protocalMustParams.put("method", request.getMethodName());
        protocalMustParams.put("v", "2.0");
        protocalMustParams.put("app_key", this.appKey);
        Long timestamp = request.getTimestamp();
        if(timestamp == null) {
            timestamp = Long.valueOf(System.currentTimeMillis());
        }

        protocalMustParams.put("timestamp", new Date(timestamp.longValue()));
        requestHolder.setProtocalMustParams(protocalMustParams);
        GcloudHashMap protocalOptParams = new GcloudHashMap();
        protocalOptParams.put("format", this.format);
        protocalOptParams.put("sign_method", this.signMethod);
        protocalOptParams.put("session", session);
        protocalOptParams.put("partner_id", "top-sdk-java-20150906");
        if(this.targetAppKey != null) {
            protocalOptParams.put("target_app_key", this.targetAppKey);
        }

        if(this.useSimplifyJson) {
            protocalOptParams.put("simplify", Boolean.TRUE.toString());
        }

        requestHolder.setProtocalOptParams(protocalOptParams);

        try {
            if("md5".equals(this.signMethod)) {
                protocalMustParams.put("sign", GcloudUtils.signTopRequestNew(requestHolder, this.appSecret, false));
            } else if("hmac".equals(this.signMethod)) {
                protocalMustParams.put("sign", GcloudUtils.signTopRequestNew(requestHolder, this.appSecret, true));
            } else {
                protocalMustParams.put("sign", GcloudUtils.signTopRequest(requestHolder, this.appSecret));
            }
        } catch (IOException var15) {
            throw new GcloudException(var15);
        }

        StringBuffer reqUrl = null;
        boolean userHttpDns = false;
        if(nextVipUrl == null) {
            reqUrl = new StringBuffer(this.serverUrl);
        } else {
            userHttpDns = true;
            reqUrl = new StringBuffer(nextVipUrl);
        }

        String rsp;
        try {
            rsp = WebUtils.buildQuery(requestHolder.getProtocalMustParams(), "UTF-8");
            String e = WebUtils.buildQuery(requestHolder.getProtocalOptParams(), "UTF-8");
            if(reqUrl.indexOf("?") != -1) {
                reqUrl.append("&");
            } else {
                reqUrl.append("?");
            }

            reqUrl.append(rsp);
            if(e != null & e.length() > 0) {
                reqUrl.append("&").append(e);
            }

            requestHolder.setRequestUrl(reqUrl.toString());
        } catch (IOException var16) {
            throw new GcloudException(var16);
        }

        rsp = null;

        try {
            if(this.useGzipEncoding) {
                request.getHeaderMap().put("Accept-Encoding", "gzip");
            }

            if(request instanceof GcloudUploadRequest) {
                GcloudUploadRequest e1 = (GcloudUploadRequest)request;
                Map fileParams = GcloudUtils.cleanupMap(e1.getFileParams());
                rsp = WebUtils.doPost(reqUrl.toString(), appParams, fileParams, "UTF-8", this.connectTimeout, this.readTimeout, request.getHeaderMap(), userHttpDns);
            } else {
                rsp = WebUtils.doPost(reqUrl.toString(), appParams, "UTF-8", this.connectTimeout, this.readTimeout, request.getHeaderMap(), userHttpDns);
            }

            requestHolder.setResponseBody(rsp);
            return requestHolder;
        } catch (Exception var14) {
            throw new GcloudException(var14);
        }
    }

    public void setNeedCheckRequest(boolean needCheckRequest) {
        this.needCheckRequest = needCheckRequest;
    }

    public void setNeedEnableParser(boolean needEnableParser) {
        this.needEnableParser = needEnableParser;
    }

    public void setUseSimplifyJson(boolean useSimplifyJson) {
        this.useSimplifyJson = useSimplifyJson;
    }

    public void setNeedEnableLogger(boolean needEnableLogger) {
        GcloudLogger.setNeedEnableLogger(needEnableLogger);
    }

    public void setIgnoreSSLCheck(boolean ignore) {
        WebUtils.setIgnoreSSLCheck(ignore);
    }

    public void setUseGzipEncoding(boolean useGzipEncoding) {
        this.useGzipEncoding = useGzipEncoding;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public void setTargetAppKey(String targetAppKey) {
        this.targetAppKey = targetAppKey;
    }

    public DNSConfig getDNSConfig() {
        return this.autoConfigThread.getConfig();
    }

    public void setMaxKeepAliveConnections(int amount) {
        System.setProperty("http.maxConnections", String.valueOf(amount));
    }

    protected String doPost(String url, Map<String, String> params, String charset, int connectTimeout, int readTimeout, Map<String, String> headerMap) throws Exception {
        return WebUtils.doPost(url, params, charset, connectTimeout, readTimeout, headerMap);
    }

    protected String doPost(String url, Map<String, String> params, Map<String, FileItem> fileParams, String charset, int connectTimeout, int readTimeout, Map<String, String> headerMap) throws IOException {
        return WebUtils.doPost(url, params, fileParams, charset, connectTimeout, readTimeout, headerMap);
    }

    public static void main(String[] args) throws GcloudException {

        DefaultGcloudClient defaultGcloudClient = new DefaultGcloudClient();
        AreasGetRequest areasGetRequest = new AreasGetRequest();
        defaultGcloudClient.execute(areasGetRequest);
    }
}

