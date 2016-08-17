package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.AreaInfo;

import java.util.List;
import java.util.Map;

public interface AreaInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AreaInfo record);

    int insertSelective(AreaInfo record);

    AreaInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AreaInfo record);

    int updateByPrimaryKey(AreaInfo record);

    /**
     * 查询区域信息
     * @param params
     * @return
     */
    List<AreaInfo> queryAreaInfo(Map<String, Object> params);
}