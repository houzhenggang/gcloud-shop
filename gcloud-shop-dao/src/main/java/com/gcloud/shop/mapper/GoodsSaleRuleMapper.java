package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.GoodsSaleRule;

public interface GoodsSaleRuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsSaleRule record);

    int insertSelective(GoodsSaleRule record);

    GoodsSaleRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsSaleRule record);

    int updateByPrimaryKey(GoodsSaleRule record);
}