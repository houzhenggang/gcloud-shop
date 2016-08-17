package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.GoodsVoucherPeriod;

public interface GoodsVoucherPeriodMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsVoucherPeriod record);

    int insertSelective(GoodsVoucherPeriod record);

    GoodsVoucherPeriod selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsVoucherPeriod record);

    int updateByPrimaryKey(GoodsVoucherPeriod record);
}