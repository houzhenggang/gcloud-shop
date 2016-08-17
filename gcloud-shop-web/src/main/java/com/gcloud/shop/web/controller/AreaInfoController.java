package com.gcloud.shop.web.controller;

import com.gcloud.shop.core.Constant;
import com.gcloud.shop.core.ServcieException;
import com.gcloud.shop.core.IAreaInfoService;
import com.gcloud.shop.domain.AreaInfo;
import com.gcloud.shop.web.bean.ResponseEntity;
import com.gcloud.shop.web.request.AreaInfoReq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaController
 * @Package com.gcloud.demo.web.controller
 * @Description: 地区信息
 * @date 2016/6/1 13:53
 */
@Controller
@RequestMapping("/data/area")
public class AreaInfoController {

    private static final Logger logger = LogManager.getLogger(AreaInfoController.class);

    @Autowired
    IAreaInfoService areaInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity skuList(AreaInfoReq areaInfoReq) {

        ResponseEntity responseEntity = new ResponseEntity();
        try {
            List<AreaInfo> AreaInfoList = areaInfoService.queryAreaInfo(null);
            responseEntity.setResult(AreaInfoList);
        } catch (ServcieException e){
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