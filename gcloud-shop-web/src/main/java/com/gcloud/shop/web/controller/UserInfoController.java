package com.gcloud.shop.web.controller;

import com.gcloud.shop.core.Constant;
import com.gcloud.shop.core.IUserInfoService;
import com.gcloud.shop.core.ServiceException;
import com.gcloud.shop.core.utils.SecretUtil;
import com.gcloud.shop.domain.UserInfo;
import com.gcloud.shop.session.ISessionManager;
import com.gcloud.shop.web.bean.ResponseEntity;
import com.gcloud.shop.web.request.UserInfoReq;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaController
 * @Package com.gcloud.demo.web.controller
 * @Description: 地区信息
 * @date 2016/6/1 13:53
 */
@Controller
@RequestMapping("/shop/user")
public class UserInfoController {

    private static final Logger logger = LogManager.getLogger(UserInfoController.class);

    @Autowired
    IUserInfoService userInfoService;

    @Resource
    ISessionManager sessionManager;

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity loginIn(UserInfoReq userInfoReq, HttpServletRequest request, HttpServletResponse response) {

        ResponseEntity responseEntity = new ResponseEntity();
        try {

            UserInfo userInfo = userInfoService.selectByPrimaryKey(userInfoReq.getUserId());
            String sessionId = userInfo.getStoreId() + userInfo.getUserId();
            sessionManager.createSession(sessionId, request, response).setUser(userInfo);
            responseEntity.setResult(userInfo);
            responseEntity.setSecret(SecretUtil.secretPassWord(userInfo.getPhone()));
        } catch (ServiceException e){
            responseEntity.setStatus(e.getMsgCode());
            responseEntity.setMessage(e.getMsgDesc());
            logger.error(e.getMessage());
        } catch (Exception e){
            responseEntity.setStatus(Constant.API_CALL_ERROR);
            responseEntity.setMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return responseEntity;
    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity loginOut(UserInfoReq userInfoReq) {

        ResponseEntity responseEntity = new ResponseEntity();
        try {

            UserInfo userInfo = userInfoService.selectByUserId(userInfoReq.getStoreId(), userInfoReq.getUserId());
            responseEntity.setResult(userInfo);
        } catch (ServiceException e){
            responseEntity.setStatus(e.getMsgCode());
            responseEntity.setMessage(e.getMsgDesc());
            logger.error(e.getMessage());
        } catch (Exception e){
            responseEntity.setStatus(Constant.API_CALL_ERROR);
            responseEntity.setMessage(e.getMessage());
            logger.error(e.getMessage());
        }
        return responseEntity;
    }

}