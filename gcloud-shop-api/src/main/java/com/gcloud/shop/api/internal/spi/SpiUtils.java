package com.gcloud.shop.api.internal.spi;

import com.gcloud.shop.api.internal.util.StringUtils;
import com.gcloud.shop.api.internal.util.TaobaoUtils;
import com.gcloud.shop.api.internal.util.WebUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.*;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: SpiUtils
 * @Package com.gcloud.shop.api.internal.spi
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:37
 */
public class SpiUtils {

    private static final Logger logger = LogManager.getLogger(SpiUtils.class);
    private static final String TOP_SIGN_LIST = "top_sign_list";
    private static final String TOP_FIELD_SIGN = "sign";
    private static final String TOP_FIELD_TS = "timestamp";
    private static final String[] HEADER_FIELDS_IP = new String[]{"X-Real-IP", "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR"};

    public SpiUtils() {
    }

    public static boolean checkSign4FormRequest(HttpServletRequest request, String secret) throws IOException {
        String charset = WebUtils.getResponseCharset(request.getContentType());
        return checkSign(request, (Map)null, (String)null, secret, charset);
    }

    public static boolean checkSign4TextRequest(HttpServletRequest request, String body, String secret) throws IOException {
        String charset = WebUtils.getResponseCharset(request.getContentType());
        return checkSign(request, (Map)null, body, secret, charset);
    }

    public static boolean checkSign4FileRequest(HttpServletRequest request, Map<String, String> form, String secret) throws IOException {
        String charset = WebUtils.getResponseCharset(request.getContentType());
        return checkSign(request, form, (String)null, secret, charset);
    }

    private static boolean checkSign(HttpServletRequest request, Map<String, String> form, String body, String secret, String charset) throws IOException {
        HashMap params = new HashMap();
        Map headerMap = getHeaderMap(request, charset);
        params.putAll(headerMap);
        Map queryMap = getQueryMap(request, charset);
        params.putAll(queryMap);
        if(form == null && body == null) {
            Map remoteSign = getFormMap(request, queryMap);
            params.putAll(remoteSign);
        } else if(form != null) {
            params.putAll(form);
        }

        String remoteSign1 = (String)queryMap.get("sign");
        String localSign = sign(params, body, secret, charset);
        if(localSign.endsWith(remoteSign1)) {
            return true;
        } else {
            String paramStr = getParamStrFromMap(params);
            logger.error("checkTopSign error^_^remoteSign=" + remoteSign1 + "^_^localSign=" + localSign + "^_^paramStr=" + paramStr + "^_^body=" + body);
            return false;
        }
    }

    public static Map<String, String> getHeaderMap(HttpServletRequest request, String charset) throws IOException {
        HashMap headerMap = new HashMap();
        String signList = request.getHeader("top_sign_list");
        if(!StringUtils.isEmpty(signList)) {
            String[] keys = signList.split(",");
            String[] arr$ = keys;
            int len$ = keys.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String key = arr$[i$];
                String value = request.getHeader(key);
                if(StringUtils.isEmpty(value)) {
                    headerMap.put(key, "");
                } else {
                    headerMap.put(key, value);
                }
            }
        }

        return headerMap;
    }

    public static Map<String, String> getQueryMap(HttpServletRequest request, String charset) throws IOException {
        HashMap queryMap = new HashMap();
        String queryString = request.getQueryString();
        String[] params = queryString.split("&");

        for(int i = 0; i < params.length; ++i) {
            String[] kv = params[i].split("=");
            String key;
            if(kv.length == 2) {
                key = URLDecoder.decode(kv[0], charset);
                String value = URLDecoder.decode(kv[1], charset);
                queryMap.put(key, value);
            } else if(kv.length == 1) {
                key = URLDecoder.decode(kv[0], charset);
                queryMap.put(key, "");
            }
        }

        return queryMap;
    }

    public static Map<String, String> getFormMap(HttpServletRequest request, Map<String, String> queryMap) throws IOException {
        HashMap formMap = new HashMap();
        Set keys = request.getParameterMap().keySet();
        Iterator i$ = keys.iterator();

        while(i$.hasNext()) {
            Object tmp = i$.next();
            String key = String.valueOf(tmp);
            if(!queryMap.containsKey(key)) {
                String value = request.getParameter(key);
                if(StringUtils.isEmpty(value)) {
                    formMap.put(key, "");
                } else {
                    formMap.put(key, value);
                }
            }
        }

        return formMap;
    }

    public static String getStreamAsString(InputStream stream, String charset) throws IOException {
        return WebUtils.getStreamAsString(stream, charset);
    }

    private static String sign(Map<String, String> params, String body, String secret, String charset) throws IOException {
        StringBuilder sb = new StringBuilder(secret);
        sb.append(getParamStrFromMap(params));
        if(body != null) {
            sb.append(body);
        }

        sb.append(secret);
        byte[] bytes = TaobaoUtils.encryptMD5(sb.toString().getBytes(charset));
        return TaobaoUtils.byte2hex(bytes);
    }

    private static String getParamStrFromMap(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if(params != null && !params.isEmpty()) {
            String[] keys = (String[])params.keySet().toArray(new String[0]);
            Arrays.sort(keys);

            for(int i = 0; i < keys.length; ++i) {
                String name = keys[i];
                if(!"sign".equals(name)) {
                    sb.append(name);
                    sb.append((String)params.get(name));
                }
            }
        }

        return sb.toString();
    }

    public static boolean checkTimestamp(HttpServletRequest request) {
        String ts = request.getParameter("timestamp");
        if(ts != null) {
            long remote = StringUtils.parseDateTime(ts).getTime();
            long local = Calendar.getInstance().getTime().getTime();
            return local - remote <= 300000L;
        } else {
            return false;
        }
    }

    public static boolean checkRemoteIp(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        String[] arr$ = HEADER_FIELDS_IP;
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String ipHeader = arr$[i$];
            String realIp = request.getHeader(ipHeader);
            if(!StringUtils.isEmpty(realIp) && !"unknown".equalsIgnoreCase(realIp)) {
                ip = realIp;
                break;
            }
        }

        return ip.startsWith("140.205.144.") || ip.startsWith("40.205.145.");
    }
}
