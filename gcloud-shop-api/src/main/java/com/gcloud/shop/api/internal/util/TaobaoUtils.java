package com.gcloud.shop.api.internal.util;

import com.gcloud.shop.api.ApiException;
import com.gcloud.shop.api.TaobaoResponse;
import com.gcloud.shop.api.internal.dns.*;
import com.gcloud.shop.api.internal.parser.json.ObjectJsonParser;
import com.gcloud.shop.api.internal.util.json.JSONValidatingReader;
import com.gcloud.shop.api.internal.util.json.JSONWriter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.*;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TaobaoUtils
 * @Package com.gcloud.shop.api.internal.util
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:44
 */
public class TaobaoUtils {
    private static String localIp;

    private TaobaoUtils() {
    }

    public static String signTopRequest(RequestParametersHolder requestHolder, String secret) throws IOException {
        Map params = requestHolder.getAllParams();
        String[] keys = (String[])params.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        StringBuilder query = new StringBuilder(secret);
        String[] bytes = keys;
        int len$ = keys.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String key = bytes[i$];
            String value = (String)params.get(key);
            if(StringUtils.areNotEmpty(new String[]{key, value})) {
                query.append(key).append(value);
            }
        }

        byte[] var10 = encryptMD5(query.toString());
        return byte2hex(var10);
    }

    public static String signTopRequestNew(RequestParametersHolder requestHolder, String secret, boolean isHmac) throws IOException {
        return signTopRequestNew(requestHolder.getAllParams(), secret, isHmac);
    }

    public static String signTopRequestNew(Map<String, String> params, String secret, boolean isHmac) throws IOException {
        String[] keys = (String[])params.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        StringBuilder query = new StringBuilder();
        if(!isHmac) {
            query.append(secret);
        }

        String[] bytes = keys;
        int len$ = keys.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String key = bytes[i$];
            String value = (String)params.get(key);
            if(StringUtils.areNotEmpty(new String[]{key, value})) {
                query.append(key).append(value);
            }
        }

        byte[] var10;
        if(isHmac) {
            var10 = encryptHMAC(query.toString(), secret);
        } else {
            query.append(secret);
            var10 = encryptMD5(query.toString());
        }

        return byte2hex(var10);
    }

    private static byte[] encryptHMAC(String data, String secret) throws IOException {
        Object bytes = null;

        try {
            SecretKeySpec gse = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacMD5");
            Mac msg1 = Mac.getInstance(gse.getAlgorithm());
            msg1.init(gse);
            byte[] bytes1 = msg1.doFinal(data.getBytes("UTF-8"));
            return bytes1;
        } catch (GeneralSecurityException var5) {
            String msg = getStringFromException(var5);
            throw new IOException(msg);
        }
    }

    private static String getStringFromException(Throwable e) {
        String result = "";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        e.printStackTrace(ps);

        try {
            result = bos.toString("UTF-8");
        } catch (IOException var5) {
            ;
        }

        return result;
    }

    public static byte[] encryptMD5(String data) throws IOException {
        return encryptMD5(data.getBytes("UTF-8"));
    }

    public static byte[] encryptMD5(byte[] data) throws IOException {
        Object bytes = null;

        try {
            MessageDigest gse = MessageDigest.getInstance("MD5");
            byte[] bytes1 = gse.digest(data);
            return bytes1;
        } catch (GeneralSecurityException var4) {
            String msg = getStringFromException(var4);
            throw new IOException(msg);
        }
    }

    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();

        for(int i = 0; i < bytes.length; ++i) {
            String hex = Integer.toHexString(bytes[i] & 255);
            if(hex.length() == 1) {
                sign.append("0");
            }

            sign.append(hex.toUpperCase());
        }

        return sign.toString();
    }

    public static boolean verifyTopResponse(String topParams, String topSession, String topSign, String appKey, String appSecret) throws IOException {
        StringBuilder result = new StringBuilder();
        result.append(appKey).append(topParams).append(topSession).append(appSecret);
        byte[] bytes = encryptMD5(result.toString());
        return Base64.encodeToString(bytes, false).equals(topSign);
    }

    public static Map<String, String> decodeTopParams(String topParams) throws IOException {
        return decodeTopParams(topParams, "GBK");
    }

    public static Map<String, String> decodeTopParams(String topParams, String charset) throws IOException {
        if(StringUtils.isEmpty(topParams)) {
            return null;
        } else {
            byte[] buffer = Base64.decode(WebUtils.decode(topParams).getBytes());
            String originTopParams = new String(buffer, charset);
            return WebUtils.splitUrlQuery(originTopParams);
        }
    }

    public static String getFileSuffix(byte[] bytes) {
        return bytes != null && bytes.length >= 10?(bytes[0] == 71 && bytes[1] == 73 && bytes[2] == 70?"GIF":(bytes[1] == 80 && bytes[2] == 78 && bytes[3] == 71?"PNG":(bytes[6] == 74 && bytes[7] == 70 && bytes[8] == 73 && bytes[9] == 70?"JPG":(bytes[0] == 66 && bytes[1] == 77?"BMP":null)))):null;
    }

    public static String getMimeType(byte[] bytes) {
        String suffix = getFileSuffix(bytes);
        String mimeType;
        if("JPG".equals(suffix)) {
            mimeType = "image/jpeg";
        } else if("GIF".equals(suffix)) {
            mimeType = "image/gif";
        } else if("PNG".equals(suffix)) {
            mimeType = "image/png";
        } else if("BMP".equals(suffix)) {
            mimeType = "image/bmp";
        } else {
            mimeType = "application/octet-stream";
        }

        return mimeType;
    }

    public static <V> Map<String, V> cleanupMap(Map<String, V> map) {
        if(map != null && !map.isEmpty()) {
            HashMap result = new HashMap(map.size());
            Set entries = map.entrySet();
            Iterator i$ = entries.iterator();

            while(i$.hasNext()) {
                Map.Entry entry = (Map.Entry)i$.next();
                if(entry.getValue() != null) {
                    result.put(entry.getKey(), entry.getValue());
                }
            }

            return result;
        } else {
            return null;
        }
    }

    public static Map<?, ?> parseJson(String body) {
        JSONValidatingReader jr = new JSONValidatingReader();
        Object obj = jr.read(body);
        return obj instanceof Map?(Map)obj:null;
    }

    public static Map<?, ?> parseJson(Object body) {
        JSONValidatingReader jr = new JSONValidatingReader();
        JSONWriter writer = new JSONWriter();
        Object obj = jr.read(writer.write(body));
        return obj instanceof Map?(Map)obj:null;
    }

    public static DNSConfig parseConfig(String body) throws Exception {
        try {
            JSONValidatingReader e = new JSONValidatingReader();
            Object obj = e.read(body);
            if(obj instanceof Map) {
                DNSConfig config = new DNSConfig();
                Map result = (Map)obj;
                Iterator i$ = result.keySet().iterator();

                while(i$.hasNext()) {
                    String key = (String)i$.next();
                    Map value = parseJson(result.get(key));
                    Map api;
                    if(key.equals("env")) {
                        api = parseEnvNode(value);
                        config.setEnv(api);
                    } else if(key.equals("api")) {
                        api = parseApiNode(value);
                        config.setApi(api);
                    } else if(key.equals("user")) {
                        config.setUser(value);
                    } else if(key.equals("config")) {
                        config.setConfig(value);
                    }
                }

                return config;
            } else {
                return null;
            }
        } catch (Exception var9) {
            throw var9;
        }
    }

    private static Map<String, List<EnvConfig>> parseEnvNode(Map<?, ?> value) {
        HashMap env = new HashMap();
        Set keySet = value.keySet();
        Iterator i$ = keySet.iterator();

        while(i$.hasNext()) {
            String envkey = (String)i$.next();
            List envList = parseDomainNode(value, envkey);
            env.put(envkey, envList);
        }

        return env;
    }

    private static List<EnvConfig> parseDomainNode(Map<?, ?> value, String envkey) {
        ArrayList envList = new ArrayList();
        Map apiValue = (Map)value.get(envkey);
        Iterator i$ = apiValue.keySet().iterator();

        while(i$.hasNext()) {
            String domain = (String)i$.next();
            EnvConfig envConfig = new EnvConfig();
            envConfig.setHost(domain);
            DomainConfig domainConfig = new DomainConfig();
            Map domainMap = (Map)apiValue.get(domain);
            List rules = (List)domainMap.get("vip");
            List vipRules = parseVIPRulesNode(rules);
            domainConfig.setVip(vipRules);
            domainConfig.setProto((String)domainMap.get("proto"));
            envConfig.setDomain(domainConfig);
            envList.add(envConfig);
        }

        return envList;
    }

    private static List<VIPRule> parseVIPRulesNode(List<String> rules) {
        ArrayList vipRules = new ArrayList();
        Double lastPercent = Double.valueOf(0.0D);
        Iterator i$ = rules.iterator();

        while(i$.hasNext()) {
            String rule = (String)i$.next();
            VIPRule vipRule = new VIPRule();
            String[] splits = rule.split("\\|");
            vipRule.setVip(splits[0]);
            vipRule.setStartPower(lastPercent);
            if(splits.length == 2) {
                vipRule.setEndPower(Double.valueOf(lastPercent.doubleValue() + Double.valueOf(splits[1]).doubleValue()));
            } else {
                vipRule.setEndPower(Double.valueOf(1.0D));
            }

            lastPercent = vipRule.getEndPower();
            vipRules.add(vipRule);
        }

        return vipRules;
    }

    private static Map<String, ApiConfig> parseApiNode(Map<?, ?> value) {
        HashMap api = new HashMap();
        Set keySet = value.keySet();
        Iterator i$ = keySet.iterator();

        while(i$.hasNext()) {
            String apikey = (String)i$.next();
            ApiConfig apiConfig = new ApiConfig();
            Map apiValue = (Map)value.get(apikey);
            List rules = (List)apiValue.get("rule");
            ArrayList apiRules = new ArrayList();
            Double lastPercent = Double.valueOf(0.0D);

            ApiRule apiRule;
            for(Iterator i$1 = rules.iterator(); i$1.hasNext(); lastPercent = apiRule.getEndPower()) {
                String rule = (String)i$1.next();
                apiRule = new ApiRule();
                String[] splits = rule.split("\\|");
                apiRule.setName(splits[0]);
                apiRule.setStartPower(lastPercent);
                if(splits.length == 2) {
                    apiRule.setEndPower(Double.valueOf(lastPercent.doubleValue() + Double.valueOf(splits[1]).doubleValue()));
                } else {
                    apiRule.setEndPower(Double.valueOf(1.0D));
                }

                apiRules.add(apiRule);
            }

            apiConfig.setRule(apiRules);
            apiConfig.setUser((String)apiValue.get("user"));
            api.put(apikey, apiConfig);
        }

        return api;
    }

    public static <T extends TaobaoResponse> T parseResponse(String json, Class<T> clazz) throws ApiException {
        ObjectJsonParser parser = new ObjectJsonParser(clazz);
        TaobaoResponse rsp = parser.parse(json);
        rsp.setBody(json);
        //mod by chenjin return rsp;
        return (T)rsp;
    }

    public static String getLocalNetWorkIp() {
        if(localIp != null) {
            return localIp;
        } else {
            try {
                Enumeration e = NetworkInterface.getNetworkInterfaces();
                InetAddress ip = null;

                label47:
                do {
                    NetworkInterface ni;
                    do {
                        do {
                            if(!e.hasMoreElements()) {
                                break label47;
                            }

                            ni = (NetworkInterface)e.nextElement();
                        } while(ni.isLoopback());
                    } while(ni.isVirtual());

                    Enumeration addresss = ni.getInetAddresses();

                    while(addresss.hasMoreElements()) {
                        InetAddress address = (InetAddress)addresss.nextElement();
                        if(address instanceof Inet4Address) {
                            ip = address;
                            break;
                        }
                    }
                } while(ip == null);

                if(ip != null) {
                    localIp = ip.getHostAddress();
                } else {
                    localIp = "127.0.0.1";
                }
            } catch (Exception var5) {
                localIp = "127.0.0.1";
            }

            return localIp;
        }
    }
}
