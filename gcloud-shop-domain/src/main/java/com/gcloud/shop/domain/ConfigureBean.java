package com.gcloud.shop.domain;

import java.io.Serializable;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: ConfigureBean
 * @Package com.gcloud.domain
 * @Description: 配置信息
 * @date 2016/6/1 13:53
 */
public class ConfigureBean implements Serializable {

	private int id;
	
	private String key;
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
