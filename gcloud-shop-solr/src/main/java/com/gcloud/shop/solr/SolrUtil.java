package com.gcloud.shop.solr;

import com.gcloud.shop.domain.AreaInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: sd
 * @Package com.gcloud.shop.solr.util
 * @Description: Solr 操作工具类(单例模式)
 * @date 2016/8/17 14:07
 */
public class SolrUtil {

    private static final Logger logger = LogManager.getLogger(SolrUtil.class);

    private SolrUtil(){

    }

    private static class SolrUtilHandler{
        public static SolrUtil solrUtil = new SolrUtil();
    }

    /**
     * 实例化当前类
     * @return
     */
    public static SolrUtil getInstance(){
        return SolrUtilHandler.solrUtil;
    }

    /**
     * Solr查询
     * @param solrParam
     * @return
     */
    public QueryResponse query(HttpSolrClient solrClient, Map<String, String> solrParam){

        QueryResponse queryResponse = null;
        try {
            getInstance();
            solrParam.put("q", " *:* ");
            solrParam.put("start", String.valueOf(1));
            solrParam.put("rows",  String.valueOf(100));
            SolrParams solrParams = initSolrParams(solrParam);
            queryResponse = solrClient.query(solrParams);
        } catch (SolrServerException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return queryResponse;
    }

    /**
     * 初始化Solr参数
     * @param paramMap
     * @return
     */
    public SolrParams initSolrParams(Map<String, String> paramMap){
        return new MapSolrParams(paramMap);
    }

    /**
     * 创建索引
     * @param param
     * @return
     */
    public int delSolrDocByQuery(HttpSolrClient solrClient, Map<String, Object> param){
        int delSize =0;
        try {
            solrClient.deleteByQuery(null);
            solrClient.commit();
        } catch (SolrServerException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return delSize;
    }

    /**
     * 创建索引
     * @param idList
     * @return
     */
    public int delSolrDocById(HttpSolrClient solrClient, List<String> idList){
        int delSize =0;
        try {
            solrClient.deleteById(idList);
            solrClient.commit();
        } catch (SolrServerException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return delSize;
    }

    /**
     * 创建索引
     * @param solrInputDocumentList
     * @return
     */
    public int addSolrDoc(HttpSolrClient solrClient, List<SolrInputDocument> solrInputDocumentList){

        int addSize =0;
        try {
            solrClient.add(solrInputDocumentList);
            solrClient.optimize();
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addSize;
    }

    /**
     * 封装区域SolrInputDocument
     * @param areaInfoList
     * @return
     */
    public List<SolrInputDocument> getSolrInputDocument(List<AreaInfo> areaInfoList){

        List<SolrInputDocument> solrInputDocumentList = new ArrayList<SolrInputDocument>();
        for(AreaInfo areaInfo : areaInfoList) {
            SolrInputDocument solrInputDocument = new SolrInputDocument();
            solrInputDocument.addField("id", areaInfo.getId());
            solrInputDocument.addField("area_id", areaInfo.getId());
            solrInputDocument.addField("area_name", areaInfo.getName());
            solrInputDocument.addField("area_type", areaInfo.getType());
            solrInputDocument.addField("area_parent_id", areaInfo.getParentId());
            solrInputDocument.addField("area_zip", areaInfo.getZip());
            solrInputDocumentList.add(solrInputDocument);
        }
        return solrInputDocumentList;
    }
}
