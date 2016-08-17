package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.GoodsItem;

public interface GoodsItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodsItem record);

    int insertSelective(GoodsItem record);

    GoodsItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsItem record);

    int updateByPrimaryKeyWithBLOBs(GoodsItem record);

    int updateByPrimaryKey(GoodsItem record);
}