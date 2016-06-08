package com.gcloud.shop.api.response;

import com.gcloud.shop.domain.Area;

import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreasGetResponse
 * @Package com.gcloud.shop.api.response
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 11:07
 */
public class AreasGetResponse extends GcloudResponse {

    private static final long serialVersionUID = 5851371248926479165L;

    public AreasGetResponse(){

    }

    public List<Area> getAreaList() {
        return areaList;
    }

    private List<Area> areaList;

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

}
