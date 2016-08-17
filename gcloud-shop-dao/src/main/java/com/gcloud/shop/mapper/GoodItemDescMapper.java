package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.GoodItemDesc;

public interface GoodItemDescMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodItemDesc record);

    int insertSelective(GoodItemDesc record);

    GoodItemDesc selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodItemDesc record);

    int updateByPrimaryKey(GoodItemDesc record);
}