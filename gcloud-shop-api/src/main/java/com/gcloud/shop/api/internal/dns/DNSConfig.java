package com.gcloud.shop.api.internal.dns;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: DNSConfig
 * @Package com.gcloud.shop.api.internal.dns
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:30
 */
public class DNSConfig implements Serializable {


    private static final Log log = LogFactory.getLog(DNSConfig.class);
    private static final long serialVersionUID = 6310378492830911768L;

    private Boolean isDisable = null;
    private Double precision = Double.valueOf(10000.0D);
    private Random random = new Random();
    private Map<String, List<EnvConfig>> env;
    private Map<String, ApiConfig> api;
    private Map<String, Map<String, List<String>>> user;
    private Map<String, String> config;

    public DNSConfig() {
    }

    public Map<String, List<EnvConfig>> getEnv() {
        return this.env;
    }

    public void setEnv(Map<String, List<EnvConfig>> env) {
        this.env = env;
    }

    public Map<String, ApiConfig> getApi() {
        return this.api;
    }

    public void setApi(Map<String, ApiConfig> api) {
        this.api = api;
    }

    public Map<String, Map<String, List<String>>> getUser() {
        return this.user;
    }

    public void setUser(Map<String, Map<String, List<String>>> user) {
        this.user = user;
    }

    public Map<String, String> getConfig() {
        return this.config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    private List<VIPRule> getVipFromUserFlag(String apiConf, String serverUrl, String flag) {
        if(flag != null) {
            Iterator i$ = this.user.keySet().iterator();

            while(i$.hasNext()) {
                String key = (String)i$.next();
                if(this.user.get(apiConf) != null && ((Map)this.user.get(apiConf)).get(key) != null && ((List)((Map)this.user.get(apiConf)).get(key)).contains(flag)) {
                    return this.getVIPRuleList(serverUrl, (List)this.env.get(key));
                }
            }
        }

        return null;
    }

    public String getVipFromApiNameAndUserFlag(String serverUrl, String apiName, String flag) {
        ApiConfig apiConfig = (ApiConfig)this.api.get(apiName);
        if(this.config.get("precision") != null && ((String)this.config.get("precision")).length() > 0) {
            try {
                this.precision = Double.valueOf((String)this.config.get("precision"));
            } catch (Exception var9) {
                this.precision = Double.valueOf(10000.0D);
            }
        }

        if(apiConfig != null) {
            List vipList = null;
            if(apiConfig.getUser() != null && apiConfig.getUser().length() > 0) {
                vipList = this.getVipFromUserFlag(apiConfig.getUser(), serverUrl, flag);
            } else {
                Double randDouble = Double.valueOf((double)this.generateRandomNumber(this.precision.intValue()) / this.precision.doubleValue());
                Iterator i$ = apiConfig.getRule().iterator();

                while(i$.hasNext()) {
                    ApiRule rule = (ApiRule)i$.next();
                    if(rule.getEndPower().doubleValue() > randDouble.doubleValue() && rule.getStartPower().doubleValue() <= randDouble.doubleValue()) {
                        vipList = this.getVIPRuleList(serverUrl, (List)this.env.get(rule.getName()));
                    }
                }
            }

            if(vipList != null) {
                return this.getWeightVIP(vipList);
            }
        }

        return this.getDefaultVip(serverUrl);
    }

    public String getDefaultVip(String serverUrl) {
        if(this.config == null && this.config.get("def_env") == null) {
            return null;
        } else {
            String defaultTartget = (String)this.config.get("def_env");
            List vipList = this.getVIPRuleList(serverUrl, (List)this.env.get(defaultTartget));
            return this.getWeightVIP(vipList);
        }
    }

    private String getWeightVIP(List<VIPRule> vipList) {
        if(vipList == null) {
            return null;
        } else {
            Double randDouble = Double.valueOf((double)this.generateRandomNumber(this.precision.intValue()) / this.precision.doubleValue());
            Iterator i$ = vipList.iterator();

            VIPRule rule;
            do {
                if(!i$.hasNext()) {
                    return null;
                }

                rule = (VIPRule)i$.next();
            } while(rule.getEndPower().doubleValue() < randDouble.doubleValue() || rule.getStartPower().doubleValue() > randDouble.doubleValue());

            return rule.getVip();
        }
    }

    public List<String> getAllVipListAndHostList() {
        ArrayList result = new ArrayList();
        Iterator i$ = this.env.keySet().iterator();

        while(i$.hasNext()) {
            String key = (String)i$.next();
            result.addAll(this.getVipList((List)this.env.get(key)));
        }

        return result;
    }

    public int generateRandomNumber(int length) {
        return this.random.nextInt(length);
    }

    public List<String> getVipList(List<EnvConfig> configList) {
        ArrayList list = new ArrayList();
        Iterator i$ = configList.iterator();

        while(i$.hasNext()) {
            EnvConfig config = (EnvConfig)i$.next();
            list.addAll(config.getDomain().getVipList());
        }

        return list;
    }

    public List<VIPRule> getVIPRuleList(String serverUrl, List<EnvConfig> configList) {
        ArrayList list = new ArrayList();

        URI uri;
        try {
            uri = new URI(serverUrl);
        } catch (URISyntaxException var7) {
            log.error("Server Url parse ERROR,please check!");
            return null;
        }

        Iterator i$ = configList.iterator();

        while(i$.hasNext()) {
            EnvConfig envConfig = (EnvConfig)i$.next();
            if(envConfig.getHost().equals(uri.getHost()) && envConfig.getDomain().getProto().contains(uri.getScheme())) {
                list.addAll(envConfig.getDomain().getVip());
            }
        }

        return list;
    }

    public boolean isDisable() {
        if(this.isDisable == null) {
            this.isDisable = Boolean.valueOf((String)this.config.get("degrade"));
        }

        return this.isDisable.booleanValue();
    }

    public void setDisable(Boolean isDisable) {
        this.isDisable = isDisable;
    }
}