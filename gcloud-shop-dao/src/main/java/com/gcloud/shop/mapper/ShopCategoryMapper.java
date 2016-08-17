package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.ShopCategory;

public interface ShopCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopCategory record);

    int insertSelective(ShopCategory record);

    ShopCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopCategory record);

    int updateByPrimaryKey(ShopCategory record);
}