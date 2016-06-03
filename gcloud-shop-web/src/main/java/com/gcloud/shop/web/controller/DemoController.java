package com.gcloud.shop.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaController
 * @Package com.gcloud.demo.web.controller
 * @Description: Demo
 * @date 2016/6/1 13:53
 */
@Controller
@RequestMapping("/service/demo")
public class DemoController {

    private static final Logger log = LogManager.getLogger(DemoController.class);

    @RequestMapping(value = "/loginDemo", method = RequestMethod.GET)
    @ResponseBody
    public Object loginDemo (HttpServletRequest request, HttpServletResponse response) {
        if( null != request.getParameter("username")){
            log.debug("Test Log4j2 ");
            log.debug(request.getParameter("username"));
        }
        return null;
    }

}