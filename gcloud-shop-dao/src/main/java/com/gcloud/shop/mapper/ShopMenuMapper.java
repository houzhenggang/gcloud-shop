package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.ShopMenu;

public interface ShopMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopMenu record);

    int insertSelective(ShopMenu record);

    ShopMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopMenu record);

    int updateByPrimaryKey(ShopMenu record);
}