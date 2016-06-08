package com.gcloud.shop.api.response;

import com.gcloud.shop.api.TaobaoResponse;
import com.gcloud.shop.api.domain.Area;
import com.gcloud.shop.api.internal.mapping.ApiField;
import com.gcloud.shop.api.internal.mapping.ApiListField;
import com.sun.tools.javac.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreasGetResponse
 * @Package com.gcloud.shop.api.response
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:46
 */
public class AreasGetResponse extends TaobaoResponse {

    private static final long serialVersionUID = -4297589920174859505L;

    @ApiListField("areas")
    @ApiField("area")
    private List<Area> areas;

    public AreasGetResponse() {
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public List<Area> getAreas() {
        return this.areas;
    }
}
