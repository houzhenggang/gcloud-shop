package com.gcloud.shop.domain.user;

import java.io.Serializable;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TradeQueryTab
 * @Package com.gcloud.domain.SubUser
 * @Description: 订单查询卡盘
 * @date 2016/6/1 13:53
 */
public class TradeQueryTab implements Serializable {

	/**
	 * 查询条件编号
	 */
	private Long id;
	
	/**
	 * 查询名称，例如待付款、已发货、快递单未打印
	 */
	private String name;
	
	/**
	 * 是否是系统查询卡盘
	 */
	private Boolean isSys;
	
	/**
	 * 是否隐藏
	 */
	private Boolean isHide;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsSys() {
		return isSys;
	}

	public void setIsSys(Boolean isSys) {
		this.isSys = isSys;
	}

	public Boolean getIsHide() {
		return isHide;
	}

	public void setIsHide(Boolean isHide) {
		this.isHide = isHide;
	}
}
