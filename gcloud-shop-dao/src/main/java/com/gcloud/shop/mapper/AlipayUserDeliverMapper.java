package com.gcloud.shop.mapper;

import com.gcloud.shop.domain.AlipayUserDeliver;

public interface AlipayUserDeliverMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AlipayUserDeliver record);

    int insertSelective(AlipayUserDeliver record);

    AlipayUserDeliver selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AlipayUserDeliver record);

    int updateByPrimaryKey(AlipayUserDeliver record);
}