package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 根据店铺ID+用户ID
     * @param params
     * @return
     */
    UserInfo selectByUserId(Map<String, Object> params);

    /**
     * 查询用户信息
     * @param params
     * @return
     */
    List<UserInfo> queryUserInfo(Map<String, Object> params);
}