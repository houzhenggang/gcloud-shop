package com.gcloud.shop.core.event;

import com.alipay.api.request.AlipayMobilePublicInfoQueryRequest;
import com.alipay.api.response.AlipayMobilePublicInfoQueryResponse;
import com.gcloud.event.core.CommonEventSource;
import com.gcloud.event.core.EventSourceBase;
import com.gcloud.event.core.IEventListener;
import com.gcloud.event.core.annotation.EventBind;
import com.gcloud.shop.core.utils.AlipayUtil;
import com.gcloud.shop.domain.AreaInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaQueryEvent
 * @Package com.gcloud.goods.core.event
 * @Description: 区域查询事件
 * @date 2016/6/13 14:12
 */
@Component
@EventBind("gcloud.shop.area.query")
public class AreaQueryEvent2 implements IEventListener {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void onObserved(EventSourceBase source) {

        try{

            CommonEventSource evt = (CommonEventSource) source;
            List<AreaInfo> areaInfoList = evt.getArgList(0, AreaInfo.class);
            logger.info("gcloud.shop.area.query.onObserved: areaInfoList" + areaInfoList.toString());

            AlipayMobilePublicInfoQueryRequest request = new AlipayMobilePublicInfoQueryRequest();
            AlipayMobilePublicInfoQueryResponse alipayResponse = (AlipayMobilePublicInfoQueryResponse) AlipayUtil.getInstance().excute(request);
            logger.info("gcloud.shop.area.query.onObserved: alipayResponse" + alipayResponse.toString());
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}