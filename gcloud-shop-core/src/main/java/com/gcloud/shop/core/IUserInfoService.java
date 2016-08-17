package com.gcloud.shop.core;

import com.gcloud.shop.domain.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaServiceImpl
 * @Package com.gcloud.api
 * @Description: 地址IService
 * @date 2016/6/1 13:53
 */
public interface IUserInfoService {

    int deleteByPrimaryKey(Long id) throws ServiceException;

    int insert(UserInfo record) throws ServiceException;

    int insertSelective(UserInfo record) throws ServiceException;

    UserInfo selectByPrimaryKey(Long id) throws ServiceException;

    int updateByPrimaryKeySelective(UserInfo record) throws ServiceException;

    int updateByPrimaryKey(UserInfo record) throws ServiceException;

    /**
     * 根据店铺ID+用户ID
     * @param storeId
     * @param userId
     * @return
     * @throws ServiceException
     */
    UserInfo selectByUserId(Long storeId, Long userId) throws ServiceException;

    /**
     * 查询用户信息
     * @param params
     * @return
     */
    List<UserInfo> queryUserInfo(Map<String, Object> params) throws ServiceException;
}
