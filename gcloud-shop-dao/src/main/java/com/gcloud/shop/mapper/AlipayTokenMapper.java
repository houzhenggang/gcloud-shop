package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.AlipayToken;

public interface AlipayTokenMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AlipayToken record);

    int insertSelective(AlipayToken record);

    AlipayToken selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AlipayToken record);

    int updateByPrimaryKey(AlipayToken record);
}