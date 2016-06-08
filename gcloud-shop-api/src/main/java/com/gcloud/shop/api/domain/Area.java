package com.gcloud.shop.api.domain;

import com.gcloud.shop.api.TaobaoObject;
import com.gcloud.shop.api.internal.mapping.ApiField;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: Area
 * @Package com.gcloud.shop.api.domain
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/6/8 15:25
 */
public class Area extends TaobaoObject {

    private static final long serialVersionUID = 7997392486199611460L;

    @ApiField("id")
    private Long id;
    @ApiField("name")
    private String name;
    @ApiField("parent_id")
    private Long parentId;
    @ApiField("type")
    private Long type;
    @ApiField("zip")
    private String zip;

    public Area() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getType() {
        return this.type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}