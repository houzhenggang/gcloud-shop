package com.gcloud.shop.domain.utils;


import com.gcloud.shop.domain.user.TbAuth;
import com.gcloud.shop.domain.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户工具类
 * @author chenjin
 * @since 2016年03月18日 上午11:35:28
 **/
public class UserUtils {

  static final Logger logger = LogManager.getLogger(UserUtils.class);

  public static Map<Long, User> toAllUserWithMmb(User user) {
    Map<Long, User> users = new HashMap<Long, User>();
    users.put(user.getTaobaoId(), user);
    if (user.getUserConf().getMmb() == 0) {
      return users;
    } else if (user.getUserConf().getMmb() == 1) {
      return toAllUser(user);
    }
    return users;
  }

  public static Map<Long, User> toAllUser(User user) {
    Map<Long, User> users = new HashMap<Long, User>();
    users.put(user.getTaobaoId(), user);
    if (user.getMasterUser() == null
        || user.getMasterUser() == 0) {
      return users;
    } else if (user.getMasterUser() == 1
               && user.getBindUsers() != null
               && user.getBindUsers().size() > 0) {
      users.putAll(user.getBindUsers());
      return users;
    }
    return users;
  }

  /**
   * 判断用户的w2权限是否有效，主要判断TbAuth中的属性
   */
  public static boolean isW2Validate(User user) {
    if (user.getUserConf().getTbAuth() == null) {
      return false;
    }

    TbAuth tbAuth = user.getUserConf().getTbAuth();
    if (tbAuth.getAuth() == null || tbAuth.getW2ExpiresIn() == null) {
      return false;
    }

    Date now = new Date();
    long interval = now.getTime() - tbAuth.getAuth().getTime();
    return (tbAuth.getW2ExpiresIn() * 1000 - interval) > 0;        // w2的有效期（单位秒）是否大于（距离上次授权时间间隔）
  }

  /**
   * 判断用户是否已经到期了，并且到期是否过了7天
   */
  public static boolean isDeadlineOff(User user) {
    if (user.getDeadline() == null) {
      return false;
    }
    //Date c = DateUtils.addDays(user.getDeadline(), 7);
    Date c = user.getDeadline();        // 直接判断用户是否到期
    return c.before(new Date());
  }

  /**
   * 判断是否是切换模式
   */
  public static boolean isSwichMode(User user) {
    //单店铺
    if (isMutiShopMode(user)) {
      if (user.getUserConf().getMmb() == null || user.getUserConf().getMmb() == 0) {
        return true;
      } else if (user.getUserConf().getMmb() == 1) {
        return false;
      }
    }
    return false;
  }

  /**
   * 判断是否是混合模式
   */
  public static boolean isMixedMode(User user) {
    //单店铺
    if (isMutiShopMode(user)) {
      if (user.getUserConf().getMmb() == null || user.getUserConf().getMmb() == 0) {
        return false;
      } else if (user.getUserConf().getMmb() == 1) {
        return true;
      }
    }
    return false;
  }

  /**
   * 判断是否是多店铺模式
   */
  public static boolean isMutiShopMode(User user) {
    //单店铺
    if (user.getAssociationId() == null || user.getAssociationId() == -1) {
      return false;
    } else if (user.getAssociationId() > 0) {
      return true;
    }
    return false;
  }


  public static boolean isSandBoxUser(User user) {
    return user.getNick().equals("yukilovesummer")
           || user.getNick().equals("magican18");
  }

}
