package com.gcloud.shop.core.impl;

import com.gcloud.shop.core.IAreaService;
import com.gcloud.shop.dao.IAreaDao;
import com.gcloud.shop.domain.Area;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaServiceImpl
 * @Package com.gcloud.api
 * @Description: 地址Service
 * @date 2016/6/1 13:53
 */
@Service("areaService")
public class AreaServiceImpl implements IAreaService {

    private static final Logger log = LogManager.getLogger(AreaServiceImpl.class);

    @Resource
    IAreaDao areaDao;

    @Override
    public List<Area> queryAreaList(Map<String, Object> condition) {

        log.info("===================== queryAreaList ==============================");
        return areaDao.queryAreaList(condition);
    }

}
