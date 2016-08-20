package com.gcloud.shop.core.utils;

import com.alipay.api.*;
import com.gcloud.shop.core.Constant;
import com.gcloud.shop.core.ServiceException;
import org.apache.logging.log4j.LogManager;

/**
 * @author chenjin
 * @version V1.0
 * @Title: AlipayUtil
 * @Package com.gcloud.shop.core.utils
 * @Description: 支付宝请求接口
 * @date 16-8-20 上午9:28
 */
public class AlipayUtil {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(AlipayUtil.class);

    /**
     * 私有化构造函数
     */
    private AlipayUtil (){

    }

    /**
     * 内部类处理，多线程安全
     */
    private static class AlipayUtilHandler {
        public static AlipayUtil alipayUtil = new AlipayUtil();
    }

    /**
     * 单例获取AlipayUtil
     * @return
     */
    public static AlipayUtil getInstance(){
        return AlipayUtilHandler.alipayUtil;
    }

    /**
     * 請求支付接口
     * @param request
     */
    public AlipayResponse excute(AlipayRequest request) throws ServiceException {

        AlipayResponse alipayResponse = null;
        try {

            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID,
                    AlipayConfig.RSA_RRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY);
            alipayResponse = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            throw new ServiceException(Constant.API_CALL_ERROR, "调用支付接口出错!" + e.getErrMsg());
        }
        return alipayResponse;
    }

}
