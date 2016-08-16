package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.AreaInfo;

public interface AreaInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AreaInfo record);

    int insertSelective(AreaInfo record);

    AreaInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AreaInfo record);

    int updateByPrimaryKey(AreaInfo record);
}