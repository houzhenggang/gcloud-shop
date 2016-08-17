package com.gcloud.shop.core;

import com.gcloud.shop.domain.AreaInfo;

import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaServiceImpl
 * @Package com.gcloud.api
 * @Description: 地址IService
 * @date 2016/6/1 13:53
 */
public interface IAreaInfoService {

    int deleteByPrimaryKey(Long id) throws ServcieException;

    int insert(AreaInfo record) throws ServcieException;

    int insertSelective(AreaInfo record) throws ServcieException;

    AreaInfo selectByPrimaryKey(Long id) throws ServcieException;

    int updateByPrimaryKeySelective(AreaInfo record) throws ServcieException;

    int updateByPrimaryKey(AreaInfo record) throws ServcieException;

    /**
     * 查询区域信息
     * @param params
     * @return
     */
    List<AreaInfo> queryAreaInfo(Map<String, Object> params) throws ServcieException;
}
