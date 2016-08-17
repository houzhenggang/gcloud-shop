package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.TradeRoyalty;

public interface TradeRoyaltyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TradeRoyalty record);

    int insertSelective(TradeRoyalty record);

    TradeRoyalty selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TradeRoyalty record);

    int updateByPrimaryKey(TradeRoyalty record);
}