package com.gcloud.shop.core.jd;

import com.gcloud.shop.core.IOAuthService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: JDAuthService
 * @Package com.gcloud.shop.core.jd
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 16:20
 */
@Service("jdAuthService")
public class JDAuthService implements IOAuthService {

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
