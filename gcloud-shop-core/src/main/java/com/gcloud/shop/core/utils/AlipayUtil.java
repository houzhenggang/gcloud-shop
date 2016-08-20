package com.gcloud.shop.core.utils;

import com.alibaba.druid.sql.visitor.functions.Concat;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.alipay.api.DefaultAlipayClient;
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

    private static final String ALIPAY_URL = "https://openapi.alipay.com/gateway.do";

    private static final String ALIPAY_APP_ID = "2016070201575604";

    private static final String ALIPAY_APP_PRIVAIDE_KEY = "your private_key";

    private static final String ALIPAY_APP_PUBLIC_KEY = "your private_key";

    private static final String ALIPAY_APP_DAA_YPE = "json";

    private static final String ALIPAY_APP_CAHRSE= "GBK";

    /**
     * 私有化构造函数
     */
    private AlipayUtil (){

    }

    private static class AlipayUtilHandler {
        public static AlipayUtil alipayUtil = new AlipayUtil();
    }

    public static AlipayUtil getInstance(){
        return AlipayUtilHandler.alipayUtil;
    }

    /**
     * 請求支付接口
     * @param request
     */
    public void excute(AlipayRequest request) throws ServiceException {

        try {

            AlipayClient alipayClient = new DefaultAlipayClient(ALIPAY_URL, ALIPAY_APP_ID,
                    ALIPAY_APP_PRIVAIDE_KEY, ALIPAY_APP_DAA_YPE, ALIPAY_APP_CAHRSE, ALIPAY_APP_PUBLIC_KEY);

            logger.info(request);
            alipayClient.execute(request);
        } catch (AlipayApiException e) {
            throw new ServiceException(Constant.API_CALL_ERROR, "调用支付接口出错!" + e.getErrMsg());
        }
    }

}
