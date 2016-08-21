package com.gcloud.shop.core.event;

import com.gcloud.event.core.CommonEventSource;
import com.gcloud.event.core.EventSourceBase;
import com.gcloud.event.core.IEventListener;
import com.gcloud.event.core.annotation.EventBind;
import com.gcloud.shop.domain.AreaInfo;
import com.gcloud.shop.solr.SolrUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
public class AreaQueryEvent implements IEventListener {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Resource
    private HttpSolrClient solrClient;

    @Override
    public void onObserved(EventSourceBase source) {

        try{

            CommonEventSource evt = (CommonEventSource) source;
            List<AreaInfo> areaInfoList = evt.getArgList(0, AreaInfo.class);
            List<SolrInputDocument> solrInputDocumentList = SolrUtil.getInstance().getSolrInputDocument(areaInfoList);
            SolrUtil.getInstance().addSolrDoc(solrClient, solrInputDocumentList);
            logger.info("gcloud.shop.area.query.onObserved: areaInfoList" + areaInfoList.toString());
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}