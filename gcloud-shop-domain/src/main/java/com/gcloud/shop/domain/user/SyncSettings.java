package com.gcloud.shop.domain.user;

import java.io.Serializable;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: SyncSettings
 * @Package com.gcloud.domain.SubUser
 * @Description: 订单同步设置
 * @date 2016/6/1 13:53
 */
public class SyncSettings implements Serializable {

	/**
	 * 是否每次登陆后，自动同步一次订单
	 */
	private boolean syncAfterLogin = true;
	
	/**
	 * 同步的订单是否合并订单
	 */
	private boolean mergeAfterSync = true;
	
	/**
	 * Time to Auto Sync，自动同步的时间，默认为空，表示不自动同步，值为0-23
	 */
	private Integer t2as;
	
	/**
	 * 选择要同步的店铺的卖家的淘宝编号，如果这个参数为空，那么表示同步所有的店铺
	 */
	private Long taobaoId;
	
	/**
	 * 是否每次登陆后，自动同步一次出售中的商品
	 */
	private boolean itemOnSaleSAL = true;
	
	/**
	 * 是否每次登陆后，自动同步一次下架的商品
	 */
	private boolean itemInventorySAL = true;
	
	/**
	 * Item Time to Auto Sync,自动不同商品的时间，默认为空，表示不自动同步，值为0-23
	 */
	private Integer it2as;
	
	/**
	 * 订单类型
	 * <pre>
	 * 0	待付款订单
	 * 1	待发货订单
	 * 2	已发货订单
	 * 3	交易成功订单
	 * 4	交易关闭订单
	 * 5	货到付款订单
	 * 6	分销订单
	 * 7	淘宝预售订单
	 * </pre>
	 */
	/*private Integer[] tradeType;*/

	public boolean isSyncAfterLogin() {
		return syncAfterLogin;
	}

	public void setSyncAfterLogin(boolean syncAfterLogin) {
		this.syncAfterLogin = syncAfterLogin;
	}

	public boolean isMergeAfterSync() {
		return mergeAfterSync;
	}

	public void setMergeAfterSync(boolean mergeAfterSync) {
		this.mergeAfterSync = mergeAfterSync;
	}

	public Integer getT2as() {
		return t2as;
	}

	public void setT2as(Integer t2as) {
		this.t2as = t2as;
	}

	public Long getTaobaoId() {
		return taobaoId;
	}

	public void setTaobaoId(Long taobaoId) {
		this.taobaoId = taobaoId;
	}

	public boolean isItemOnSaleSAL() {
		return itemOnSaleSAL;
	}

	public void setItemOnSaleSAL(boolean itemOnSaleSAL) {
		this.itemOnSaleSAL = itemOnSaleSAL;
	}

	public boolean isItemInventorySAL() {
		return itemInventorySAL;
	}

	public void setItemInventorySAL(boolean itemInventorySAL) {
		this.itemInventorySAL = itemInventorySAL;
	}

	public Integer getIt2as() {
		return it2as;
	}

	public void setIt2as(Integer it2as) {
		this.it2as = it2as;
	}
}
