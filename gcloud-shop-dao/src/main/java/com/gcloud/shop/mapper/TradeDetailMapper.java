package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.TradeDetail;

public interface TradeDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TradeDetail record);

    int insertSelective(TradeDetail record);

    TradeDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TradeDetail record);

    int updateByPrimaryKey(TradeDetail record);
}