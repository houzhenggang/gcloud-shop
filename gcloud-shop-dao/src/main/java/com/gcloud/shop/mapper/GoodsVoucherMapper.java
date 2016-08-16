package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.GoodsVoucher;

public interface GoodsVoucherMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsVoucher record);

    int insertSelective(GoodsVoucher record);

    GoodsVoucher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsVoucher record);

    int updateByPrimaryKey(GoodsVoucher record);
}