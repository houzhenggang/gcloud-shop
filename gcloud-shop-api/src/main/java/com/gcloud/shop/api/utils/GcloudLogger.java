package com.gcloud.shop.api.utils;

import com.gcloud.shop.api.response.GcloudResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: GcloudLogger
 * @Package com.gcloud.shop.api.utils
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 11:44
 */
public class GcloudLogger {

    public GcloudLogger() {

    }

    private static final Log clog = LogFactory.getLog("sdk.comm.err");
    private static final Log blog = LogFactory.getLog("sdk.biz.err");
    private static String osName = System.getProperties().getProperty("os.name");
    private static String ip = null;
    private static boolean needEnableLogger = true;

    public static void setNeedEnableLogger(boolean needEnableLogger) {
        needEnableLogger = needEnableLogger;
    }

    public static String getIp() {
        if(ip == null) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (Exception var1) {
                var1.printStackTrace();
            }
        }

        return ip;
    }

    public static void setIp(String ip) {
        ip = ip;
    }

    public static void logCommError(Exception e, HttpURLConnection conn, String appKey, String method, byte[] content) {
        if(needEnableLogger) {
            String contentString = null;

            try {
                contentString = new String(content, "UTF-8");
                logCommError(e, conn, appKey, method, contentString);
            } catch (Exception var7) {
                var7.printStackTrace();
            }

        }
    }

    public static void logCommError(Exception e, String url, String appKey, String method, byte[] content) {
        if(needEnableLogger) {
            String contentString = null;

            try {
                contentString = new String(content, "UTF-8");
                logCommError(e, url, appKey, method, contentString);
            } catch (UnsupportedEncodingException var7) {
                var7.printStackTrace();
            }

        }
    }

    public static void logCommError(Exception e, HttpURLConnection conn, String appKey, String method, Map<String, String> params) {
        if(needEnableLogger) {
            _logCommError(e, conn, (String)null, appKey, method, params);
        }
    }

    public static void logCommError(Exception e, String url, String appKey, String method, Map<String, String> params) {
        if(needEnableLogger) {
            _logCommError(e, (HttpURLConnection)null, url, appKey, method, params);
        }
    }

    private static void logCommError(Exception e, HttpURLConnection conn, String appKey, String method, String content) {
        Map params = parseParam(content);
        _logCommError(e, conn, (String)null, appKey, method, params);
    }

    private static void logCommError(Exception e, String url, String appKey, String method, String content) {
        Map params = parseParam(content);
        _logCommError(e, (HttpURLConnection)null, url, appKey, method, params);
    }

    private static void _logCommError(Exception e, HttpURLConnection conn, String url, String appKey, String method, Map<String, String> params) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String sdkName = "top-sdk-java-20150906";
        String urlStr = null;
        String rspCode = "";
        if(conn != null) {
            try {
                urlStr = conn.getURL().toString();
                rspCode = "HTTP_ERROR_" + conn.getResponseCode();
            } catch (IOException var11) {
                ;
            }
        } else {
            urlStr = url;
            rspCode = "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(df.format(new Date()));
        sb.append("^_^");
        sb.append(method);
        sb.append("^_^");
        sb.append(appKey);
        sb.append("^_^");
        sb.append(getIp());
        sb.append("^_^");
        sb.append(osName);
        sb.append("^_^");
        sb.append(sdkName);
        sb.append("^_^");
        sb.append(urlStr);
        sb.append("^_^");
        sb.append(rspCode);
        sb.append("^_^");
        sb.append((e.getMessage() + "").replaceAll("\r\n", " "));
        clog.error(sb.toString());
    }

    private static Map<String, String> parseParam(String contentString) {
        HashMap params = new HashMap();
        if(contentString != null && !contentString.trim().equals("")) {
            String[] paramsArray = contentString.split("\\&");
            if(paramsArray != null) {
                String[] arr$ = paramsArray;
                int len$ = paramsArray.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    String param = arr$[i$];
                    String[] keyValue = param.split("=");
                    if(keyValue != null && keyValue.length == 2) {
                        params.put(keyValue[0], keyValue[1]);
                    }
                }
            }

            return params;
        } else {
            return params;
        }
    }

    public static void logBizError(String rsp) {
        if(needEnableLogger) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            StringBuilder sb = new StringBuilder();
            sb.append(df.format(new Date()));
            sb.append("^_^");
            sb.append(rsp);
            blog.error(sb.toString());
        }
    }

    public static void logErrorScene(RequestParametersHolder context, GcloudResponse tRsp, String appSecret) {
        if(needEnableLogger) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            StringBuilder sb = new StringBuilder();
            sb.append("ErrorScene");
            sb.append("^_^");
            sb.append(tRsp.getErrorCode());
            sb.append("^_^");
            sb.append(tRsp.getErrorSubCode());
            sb.append("^_^");
            sb.append("appSecret***");
            sb.append("^_^");
            sb.append(ip);
            sb.append("^_^");
            sb.append(osName);
            sb.append("^_^");
            sb.append(df.format(new Date()));
            sb.append("^_^");
            sb.append("ProtocalMustParams:");
            appendLog(context.getProtocalMustParams(), sb);
            sb.append("^_^");
            sb.append("ProtocalOptParams:");
            appendLog(context.getProtocalOptParams(), sb);
            sb.append("^_^");
            sb.append("ApplicationParams:");
            appendLog(context.getApplicationParams(), sb);
            sb.append("^_^");
            sb.append("Body:");
            sb.append(context.getResponseBody());
            blog.error(sb.toString());
        }
    }

    private static void appendLog(GcloudHashMap map, StringBuilder sb) {
        boolean first = true;
        Set set = map.entrySet();

        Map.Entry entry;
        for(Iterator i$ = set.iterator(); i$.hasNext(); sb.append((String)entry.getKey()).append("=").append((String)entry.getValue())) {
            entry = (Map.Entry)i$.next();
            if(!first) {
                sb.append("&");
            } else {
                first = false;
            }
        }

    }
}
