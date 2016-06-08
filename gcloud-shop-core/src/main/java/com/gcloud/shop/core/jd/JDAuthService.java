package com.gcloud.shop.core.jd;

import com.gcloud.shop.core.IOAuthService;
import org.springframework.ui.Model;

import javax.annotation.Resource;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: JDAuthService
 * @Package com.gcloud.shop.core.jd
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 16:20
 */
public class JDAuthService implements IOAuthService {

    @Resource
    private JDIsvService jdIsvService;

    @Override
    public String authorize(String state) {
        return null;
    }

    @Override
    public String authorizeUrl(String state) {
        return null;
    }

    @Override
    public String oAuth2(Model model, String code) {
        return null;
    }
}
