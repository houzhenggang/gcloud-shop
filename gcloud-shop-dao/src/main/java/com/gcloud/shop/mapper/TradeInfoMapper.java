package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.TradeInfo;

public interface TradeInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TradeInfo record);

    int insertSelective(TradeInfo record);

    TradeInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TradeInfo record);

    int updateByPrimaryKey(TradeInfo record);
}