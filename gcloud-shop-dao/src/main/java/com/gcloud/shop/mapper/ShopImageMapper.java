package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.ShopImage;

public interface ShopImageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopImage record);

    int insertSelective(ShopImage record);

    ShopImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopImage record);

    int updateByPrimaryKeyWithBLOBs(ShopImage record);

    int updateByPrimaryKey(ShopImage record);
}