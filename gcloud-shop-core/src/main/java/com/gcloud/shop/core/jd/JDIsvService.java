package com.gcloud.shop.core.jd;

import com.gcloud.shop.core.IsvService;
import com.gcloud.shop.domain.user.Shop;
import com.gcloud.shop.domain.user.User;
import org.springframework.stereotype.Service;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: JDIsvService
 * @Package com.gcloud.shop.core.jd
 * @Description: 京东ISV操作类
 * @date 2016/6/8 16:22
 */
@Service("jdIsvService")
public class JDIsvService implements IsvService {

    @Override
    public Shop queryShop(String nick, String sessionId) {
        return null;
    }

    @Override
    public User firstInit(String nick, String sessionId) {
        return null;
    }

    @Override
    public User nextInit(String nick, String sessionId) {
        return null;
    }

}