package com.gcloud.shop.domain;

import java.io.Serializable;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: Sort
 * @Package com.gcloud.domain
 * @Description: 排序信息
 * @date 2016/6/1 13:53
 */
public class Sort implements Serializable {

    public Sort() {

    }

	/**
	 * 
	 */
	private static final long serialVersionUID = 2825768923925394827L;

	/**
	 * 排序字段名称
	 */
	private String field;
	
	/**
	 * 是否是降序排序，默认使用降序排序
	 */
	private String order;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
