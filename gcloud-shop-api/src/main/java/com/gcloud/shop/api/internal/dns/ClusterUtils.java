package com.gcloud.shop.api.internal.dns;

import com.gcloud.shop.api.ApiException;
import com.gcloud.shop.api.internal.util.TaobaoUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ClusterUtils
 * @Package com.gcloud.shop.api.internal.dns
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:30
 */
public class ClusterUtils {
    public static Map<String, DNSConfig> configMap = new HashMap();
    public static Map<String, AtomicInteger> callErrorMap = new ConcurrentHashMap();
    private static String dnsConfigFilePath;

    public ClusterUtils() {
    }

    public static void saveToFile(String config) throws ApiException, IOException {
        FileOutputStream fos = null;
        BufferedWriter bws = null;

        try {
            File dnsFile = new File(dnsConfigFilePath);
            if(!dnsFile.exists()) {
                (new File(System.getProperty("user.dir") + File.separator + "TOPDNSConfig")).mkdirs();
                dnsFile.createNewFile();
            }

            fos = new FileOutputStream(dnsConfigFilePath);
            bws = new BufferedWriter(new OutputStreamWriter(fos));
            if(bws != null) {
                bws.write(config);
            }
        } finally {
            if(bws != null) {
                bws.close();
            }

            if(fos != null) {
                fos.close();
            }

        }

    }

    public static DNSConfig init() throws ApiException {
        if(configMap.size() != 0) {
            return (DNSConfig)configMap.get("httpdns");
        } else {
            File dnsFile = new File(dnsConfigFilePath);
            FileInputStream fis = null;
            BufferedReader bis = null;
            DNSConfig config = null;

            label147: {
                StringBuffer e;
                try {
                    if(dnsFile.exists()) {
                        fis = new FileInputStream(dnsFile);
                        bis = new BufferedReader(new InputStreamReader(fis));
                        e = new StringBuffer();
                        String Stringtmp = null;

                        while((Stringtmp = bis.readLine()) != null) {
                            e.append(Stringtmp);
                        }

                        if(e.length() > 0) {
                            config = TaobaoUtils.parseConfig(e.toString());
                        }
                        break label147;
                    }

                    e = null;
                } catch (Exception var15) {
                    throw new ApiException(var15);
                } finally {
                    try {
                        if(bis != null) {
                            bis.close();
                        }

                        if(fis != null) {
                            fis.close();
                        }
                    } catch (IOException var14) {
                        ;
                    }

                }
//                return e;//mod by chenjin
            }

            if(config != null) {
                configMap.put("httpdns", config);
            }

            return config;
        }
    }

    public static String transferServerUrlToIp(String serverUrl, String apiName, String session, DNSConfig config) throws ApiException {
        String userFlag = null;
        if(session != null && session.length() > 5) {
            if(!session.startsWith("6") && !session.startsWith("7")) {
                if(session.startsWith("5") || session.startsWith("8")) {
                    userFlag = String.valueOf(session.charAt(5));
                }
            } else {
                userFlag = String.valueOf(session.charAt(session.length() - 1));
            }
        }

        if(config != null) {
            String vip = config.getVipFromApiNameAndUserFlag(serverUrl, apiName, userFlag);
            if(vip != null) {
                return vip;
            }
        }

        return null;
    }

    public static Map<String, AtomicInteger> getErrorMaps() {
        return callErrorMap;
    }

    public static Integer addErrorCount(String vip) {
        AtomicInteger count = (AtomicInteger)callErrorMap.get(vip);
        if(count == null) {
            count = new AtomicInteger(0);
        }

        int result = count.addAndGet(1);
        callErrorMap.put(vip, count);
        return Integer.valueOf(result);
    }

    public static String errorMsg() {
        if(callErrorMap.size() > 0) {
            StringBuffer sb = new StringBuffer();
            Map var1 = callErrorMap;
            synchronized(callErrorMap) {
                String vip;
                for(Iterator i$ = callErrorMap.keySet().iterator(); i$.hasNext(); sb.append(vip + "::" + callErrorMap.get(vip))) {
                    vip = (String)i$.next();
                    if(sb.length() > 0) {
                        sb.append("||");
                    }
                }

                callErrorMap.clear();
                return sb.toString();
            }
        } else {
            return null;
        }
    }

    static {
        dnsConfigFilePath = System.getProperty("user.dir") + File.separator + "TOPDNSConfig" + File.separator + "config.cnf";
    }
}

