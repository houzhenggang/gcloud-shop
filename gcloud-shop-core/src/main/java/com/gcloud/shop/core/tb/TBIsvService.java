package com.gcloud.shop.core.tb;

import com.gcloud.shop.core.IsvService;
import com.gcloud.shop.domain.user.Shop;
import com.gcloud.shop.domain.user.User;
import org.springframework.stereotype.Service;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TBIsvService
 * @Package com.gcloud.shop.core.tb
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 17:36
 */
@Service("tbIsvService")
public class TBIsvService implements IsvService {

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
