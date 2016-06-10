package com.gcloud.shop.web.controller;

import com.gcloud.shop.core.IOAuthService;
import com.gcloud.shop.core.enums.PlatformEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: OAuthController
 * @Package com.gcloud.shop.web.controller
 * @Description: 授权控制层
 * @date 2016/6/8 17:29
 **/
@Controller
@RequestMapping("/index/auth")
public class OAuthController {

    @Autowired
    IOAuthService tbAuthService;

    @Autowired
    IOAuthService jdAuthService;

    @RequestMapping(value = "/tbAuthorizeUrl", method = RequestMethod.GET)
    public String tbAuthorizeUrl(HttpServletRequest request) {
        String state = request.getParameter("state");
        return tbAuthService.authorizeUrl(state);
    }

    @RequestMapping(value = "/jdAuthorizeUrl", method = RequestMethod.GET)
    public String jdAuthorizeUrl(HttpServletRequest request) {
        String state = request.getParameter("state");
        return jdAuthService.authorizeUrl(state);
    }

    @RequestMapping(value = "/tbAuthorize", method = RequestMethod.GET)
    @ResponseBody
    public String tbAuthorize(HttpServletRequest request) {
        String state = request.getParameter("state");
        return tbAuthService.authorize(state);
    }

    @RequestMapping(value = "/jdAuthorize", method = RequestMethod.GET)
    @ResponseBody
    public String jdAuthorize(HttpServletRequest request) {
        String state = request.getParameter("state");
        return jdAuthService.authorize(state);
    }

    @RequestMapping(value = "/auth2", method = RequestMethod.GET)
    public String auth2(HttpServletRequest request, Model model) {

        String result;
        try{
            String platform = request.getParameter("platform");
            if( null != platform && platform.equals(PlatformEnum.PLATFORM_JD.getCode()) ){
                result = jdAuth2(request, model);
            } else {
                result = tbAuth2(request, model);
            }
            return result;
        } catch (Exception ex){
            return "index_failure";
        }
    }

    @RequestMapping(value = "/tbAuth2", method = RequestMethod.GET)
    public String tbAuth2(HttpServletRequest request, Model model) {

        String code = request.getParameter("code");
        String error = request.getParameter("error");
        String error_desc = request.getParameter("error_description");
        if (null == code || "access_denied".equals(error)
                || "authorize reject".equals(error_desc)) {
            return "auth2_cancel";
        }
        return tbAuthService.oAuth2(model, code);
    }

    @RequestMapping(value = "/jdAuth2", method = RequestMethod.GET)
    public String jdAuth2(HttpServletRequest request, Model model) {

        String code = request.getParameter("code");
        String error = request.getParameter("error");
        String error_desc = request.getParameter("error_description");
        if (null == code || "access_denied".equals(error)
                || "authorize reject".equals(error_desc)) {
            return "auth2_cancel";
        }
        return jdAuthService.oAuth2(model, code);
    }
}
