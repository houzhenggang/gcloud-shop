package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.ShopWindow;

public interface ShopWindowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopWindow record);

    int insertSelective(ShopWindow record);

    ShopWindow selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopWindow record);

    int updateByPrimaryKey(ShopWindow record);
}