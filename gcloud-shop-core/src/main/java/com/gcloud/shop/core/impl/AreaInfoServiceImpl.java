package com.gcloud.shop.core.impl;

import com.gcloud.shop.core.Constant;
import com.gcloud.shop.core.IAreaInfoService;
import com.gcloud.shop.core.ServiceException;
import com.gcloud.shop.domain.AreaInfo;
import com.gcloud.shop.mapper.AreaInfoMapper;
import com.gcloud.shop.solr.SolrUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaServiceImpl
 * @Package com.gcloud.api
 * @Description: 地址Service
 * @date 2016/6/1 13:53
 */
@Service("areaInfoService")
public class AreaInfoServiceImpl implements IAreaInfoService {

    private static final Logger logger = LogManager.getLogger(AreaInfoServiceImpl.class);

    @Resource
    private AreaInfoMapper areaInfoMapper;

    @Resource
    private HttpSolrClient solrClient;

    @Override
    public int deleteByPrimaryKey(Long id) throws ServiceException {
        int result = 0;
        try {
            result = areaInfoMapper.deleteByPrimaryKey(id);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "删除区域信息报错!");
        }
        return result;
    }

    @Override
    public int insert(AreaInfo record) throws ServiceException {
        int result = 0;
        try {
            result = areaInfoMapper.insert(record);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "添加区域信息报错!");
        }
        return result;
    }

    @Override
    public int insertSelective(AreaInfo record) throws ServiceException {
        int result = 0;
        try {
            result = areaInfoMapper.insertSelective(record);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "添加区域信息报错!");
        }
        return result;
    }

    @Override
    public AreaInfo selectByPrimaryKey(Long id) throws ServiceException {
        AreaInfo areaInfo = null;
        try {
            areaInfo = areaInfoMapper.selectByPrimaryKey(id);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "查询区域信息报错!");
        }
        return areaInfo;
    }

    @Override
    public int updateByPrimaryKeySelective(AreaInfo record) throws ServiceException {
        int result = 0;
        try {
            result = areaInfoMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "修改区域信息报错!");
        }
        return result;
    }

    @Override
    public int updateByPrimaryKey(AreaInfo record) throws ServiceException {
        int result = 0;
        try {
            result = areaInfoMapper.updateByPrimaryKey(record);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "修改区域信息报错!");
        }
        return result;
    }

    @Override
    public List<AreaInfo> queryAreaInfo(Map<String, Object> params) throws ServiceException {
        List<AreaInfo> areaInfoList = null;
        try {

            areaInfoList = areaInfoMapper.queryAreaInfo(params);
            List<SolrInputDocument> solrInputDocumentList = SolrUtil.getInstance().getSolrInputDocument(areaInfoList);
            SolrUtil.getInstance().addSolrDoc(solrClient, solrInputDocumentList);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new ServiceException(Constant.API_CALL_ERROR, "查询区域信息报错!");
        }
        return areaInfoList;
    }
}
