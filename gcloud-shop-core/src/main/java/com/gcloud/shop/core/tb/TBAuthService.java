package com.gcloud.shop.core.tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gcloud.shop.api.internal.util.WebUtils;
import com.gcloud.shop.core.IOAuthService;
import com.gcloud.shop.core.utils.JsonUtil;
import com.gcloud.shop.domain.user.User;
import org.apache.commons.collections.MapUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TBAuthService
 * @Package com.gcloud.shop.core.tb
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 17:36
 */
@Service("tbAuthService")
public class TBAuthService implements IOAuthService {

    final static Logger logger = LogManager.getLogger(TBAuthService.class);

    /**
     * 连接超时时间
     */
    final static int CONNECT_TIMEOUT = 30000;

    /**
     * 读取超时时间
     */
    final static int READ_TIMEOUT = 30000;

    /**
     * R1授权时效
     */
    final static int EXPIRES_IN_R1 = 1800;

    @Resource
    private TBClientHelper tbClientHelper;

    @Resource
    private TBIsvService tbIsvService;

    @Override
    public String authorize(String state) {

        String result;
        try {
            result = URLDecoder.decode(WebUtils.doPost(tbClientHelper.getTaoBaoAuthorizeUrl(), initAuthorizeProps(state), CONNECT_TIMEOUT, READ_TIMEOUT), "UTF-8");
        } catch (IOException e) {
            logger.error("TBAuthService authorize ERROR " + e.getMessage());
            result = "index_validate";
        }
        return result;
    }

    @Override
    public String authorizeUrl(String state) {
        return "redirect:https://oauth.taobao.com/authorize?response_type=code&client_id=" + TBConstant.APPKEY + "&redirect_uri=http://shop.gcloud.com/auth2.do&state=" + state + "&view=web";
    }

    @Override
    public String oAuth2(Model model, String code) {

        try {

            String result = WebUtils.doPost(tbClientHelper.getTaoBaoTokenUrl(), initAuthProps(code), CONNECT_TIMEOUT, READ_TIMEOUT);
            JSONObject params = JSON.parseObject(result);
            // 校验R1会话时间，如果会话时间小于半个小时，也就是1800秒，那么就跳转到登录会话
            Long r1ExiresIn = params.getLong("r1_expires_in");
            if (null == r1ExiresIn || r1ExiresIn < EXPIRES_IN_R1) {
                return "auth2_forward";
            }
            initCallBackProps(model, params);
        } catch (IOException e) {
            logger.error("TBAuthService oAuth2 ERROR " + e.getMessage());
            return "index_validate";
        }
        return "index_validate";
    }

    /**
     * 初始化Authorize参数
     *
     * @param state 状态码
     * @return
     */
    private Map<String, String> initAuthorizeProps(String state) {

        Map<String, String> props = new HashMap<String, String>();
        props.put("response_type", "code");
        props.put("client_id", TBConstant.APPKEY);
        props.put("client_secret", TBConstant.APPSECRET);
        props.put("redirect_uri", TBConstant.SHOP_AUTH_URL);
        props.put("state", state);
        props.put("view", "web");
        return props;
    }

    /**
     * 初始化Auth参数
     *
     * @param code
     * @return
     */
    private Map<String, String> initAuthProps(String code) {

        Map<String, String> props = new HashMap<String, String>();
        props.put("grant_type", "authorization_code");
        props.put("code", code);
        props.put("client_id", TBConstant.APPKEY);
        props.put("client_secret", TBConstant.APPSECRET);
        props.put("redirect_uri", TBConstant.SHOP_FORWARD_URL);
        props.put("view", "web");
        return props;
    }

    /**
     * 设置回调处理
     *
     * @param model
     * @param params
     */
    private void initCallBackProps(Model model, JSONObject params) {

        Map<String, String> paramsMap = JsonUtil.jsonToMap(params);
        String visitor_nick = MapUtils.getString(paramsMap, "taobao_user_nick");
        String visitor_id = MapUtils.getString(paramsMap, "taobao_user_id");
        paramsMap.put("visitor_nick", visitor_nick);
        paramsMap.put("visitor_id", visitor_id);
        paramsMap.put("source", (String) model.asMap().get("source"));
        User user = tbIsvService.firstInit(visitor_nick, visitor_id);
        model.addAttribute("params", params);
        model.addAttribute("top_parameters", paramsMap);
        model.addAttribute("user", user);
    }
}