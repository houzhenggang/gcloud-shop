package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.StoreInfo;
import com.gcloud.shop.domain.StoreInfoWithBLOBs;

public interface StoreInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StoreInfoWithBLOBs record);

    int insertSelective(StoreInfoWithBLOBs record);

    StoreInfoWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StoreInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(StoreInfoWithBLOBs record);

    int updateByPrimaryKey(StoreInfo record);
}