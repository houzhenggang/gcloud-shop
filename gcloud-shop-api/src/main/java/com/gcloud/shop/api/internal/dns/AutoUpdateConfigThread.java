package com.gcloud.shop.api.internal.dns;

import com.gcloud.shop.api.DefaultGcloudClient;
import com.gcloud.shop.api.exception.GcloudException;
import com.gcloud.shop.api.utils.GcloudUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AutoUpdateConfigThread
 * @Package com.gcloud.shop.api.internal.dns
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 13:40
 */
public class AutoUpdateConfigThread extends Thread {

    private static final Log log = LogFactory.getLog(AutoUpdateConfigThread.class);
    private Integer interval = Integer.valueOf(10);
    private Random random = new Random();
    private HttpdnsGetRequest request = new HttpdnsGetRequest();
    private static DNSConfig config = null;
    private DefaultGcloudClient client = null;
    private static AutoUpdateConfigThread thread = null;

    public static AutoUpdateConfigThread getInstance(String name, DefaultGcloudClient client) throws GcloudException {
        if(thread == null || !thread.isAlive()) {
            config = ClusterUtils.init();
            thread = new AutoUpdateConfigThread(name, client);
        }

        return thread;
    }

    public static AutoUpdateConfigThread getInstance() {
        return thread;
    }

    private AutoUpdateConfigThread(String name, DefaultGcloudClient client) {
        super(name);
        this.client = client;
    }

    public void run() {
        while(true) {
            while(true) {
                try {
                    HttpdnsGetResponse e = null;
                    List retryHostList = null;
                    Iterator hostIte = null;
                    String nextHost = null;
                    if(config != null) {
                        retryHostList = config.getAllVipListAndHostList();
                        hostIte = retryHostList.iterator();
                    }

                    while(true) {
                        try {
                            e = (HttpdnsGetResponse)this.client.updateExecute(this.request, nextHost);
                            break;
                        } catch (Exception var16) {
                            if(hostIte == null) {
                                break;
                            }

                            nextHost = (String)hostIte.next();
                            if(!hostIte.hasNext()) {
                                break;
                            }
                        }
                    }

                    if(e != null) {
                        this.updateConfig(GcloudUtils.parseConfig(e.getResult()));
                        ClusterUtils.saveToFile(e.getResult());
                        if(config != null) {
                            this.interval = Integer.valueOf((String)config.getConfig().get("interval"));
                        }

                        log.warn("update http dns config success.");
                    }
                } catch (Exception var17) {
                    log.error("Update top http dns failed!", var17);
                } finally {
                    try {
                        Thread.sleep((long)((this.interval.intValue() + this.random.nextInt(6) - 3) * 60 * 1000));
                        String e1 = ClusterUtils.errorMsg();
                        if(e1 != null) {
                            log.warn("top vip access statistics:" + e1);
                        }
                    } catch (InterruptedException var15) {
                        ;
                    }

                }
            }
        }
    }

    public void updateConfig(DNSConfig newConfig) {
        if(newConfig != null) {
            if(config == null) {
                config = new DNSConfig();
            }

            config.setApi(newConfig.getApi());
            config.setConfig(newConfig.getConfig());
            config.setEnv(newConfig.getEnv());
            config.setUser(newConfig.getUser());
            config.setDisable((Boolean)null);
        }

    }

    public DNSConfig getConfig() {
        return config;
    }
}
