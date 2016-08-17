package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.AlipayUser;

public interface AlipayUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AlipayUser record);

    int insertSelective(AlipayUser record);

    AlipayUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AlipayUser record);

    int updateByPrimaryKey(AlipayUser record);
}