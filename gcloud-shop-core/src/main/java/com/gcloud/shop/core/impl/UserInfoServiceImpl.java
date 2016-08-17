package com.gcloud.shop.core.impl;

import com.gcloud.shop.core.Constant;
import com.gcloud.shop.core.IUserInfoService;
import com.gcloud.shop.core.ServiceException;
import com.gcloud.shop.domain.UserInfo;
import com.gcloud.shop.mapper.UserInfoMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: UserServiceImpl
 * @Package com.gcloud.api
 * @Description: 地址Service
 * @date 2016/6/1 13:53
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    private static final Logger logger = LogManager.getLogger(UserInfoServiceImpl.class);

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) throws ServiceException {
        int result = 0;
        try {
            result = userInfoMapper.deleteByPrimaryKey(id);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "删除用户信息报错!");
        }
        return result;
    }

    @Override
    public int insert(UserInfo record) throws ServiceException {
        int result = 0;
        try {
            result = userInfoMapper.insert(record);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "添加用户信息报错!");
        }
        return result;
    }

    @Override
    public int insertSelective(UserInfo record) throws ServiceException {
        int result = 0;
        try {
            result = userInfoMapper.insertSelective(record);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "添加用户信息报错!");
        }
        return result;
    }

    @Override
    public UserInfo selectByPrimaryKey(Long id) throws ServiceException {
        UserInfo UserInfo = null;
        try {
            UserInfo = userInfoMapper.selectByPrimaryKey(id);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "查询用户信息报错!");
        }
        return UserInfo;
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) throws ServiceException {
        int result = 0;
        try {
            result = userInfoMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "修改用户信息报错!");
        }
        return result;
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) throws ServiceException {
        int result = 0;
        try {
            result = userInfoMapper.updateByPrimaryKey(record);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "修改用户信息报错!");
        }
        return result;
    }

    @Override
    public UserInfo selectByUserId(Long storeId, Long userId) throws ServiceException {
        UserInfo userInfo = null;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("storeId", storeId);
            params.put("userId", userId);
            userInfo = userInfoMapper.selectByUserId(params);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "查询用户信息报错!");
        }
        return userInfo;
    }

    @Override
    public List<UserInfo> queryUserInfo(Map<String, Object> params) throws ServiceException {
        List<UserInfo> userInfoList = null;
        try {

            userInfoList = userInfoMapper.queryUserInfo(params);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "查询用户信息报错!");
        }
        return userInfoList;
    }
}
