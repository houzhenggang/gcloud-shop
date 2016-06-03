package com.gcloud.shop.domain;

import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: IPageable
 * @Package com.gcloud.domain
 * @Description: 可分页的查询结果集对象，例如订单列表模型，
 * 其中订单列表中会包含，当前结果集列表，查询总数，查询的页码和每页的最大显示行数
 * @date 2016/6/1 13:53
 */
public interface IPageable<T> {

	/**
	 * 分页信息
	 * @return
	 */
	public Page getPage();
	
	/**
	 * 排序信息
	 * @return
	 */
	public Sort getSort();
	
	/**
	 * 结果集总数
	 * @return
	 */
	public Long getTotal();
	
	/**
	 * 当前结果集列表
	 * @return
	 */
	public List<T> getList();
}
