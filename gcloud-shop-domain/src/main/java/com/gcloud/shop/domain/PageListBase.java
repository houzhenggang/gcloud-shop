package com.gcloud.shop.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: PageListBase
 * @Package com.gcloud.domain
 * @Description: 可分页的结果集类
 * @date 2016/6/1 13:53
 */
public abstract class PageListBase<T> implements IPageable<T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4854389014120920864L;

	/**
	 *
	 */
	protected Page page;

	/**
	 *
	 */
	protected Sort sort;

	/**
	 *
	 */
	protected Long total;

	/**
	 *
	 */
	protected List<T> list;

	/**
	 * 前端最多显示每页的条数
	 */
	protected Integer showMaxPageSize;
	
	@Override
	public Page getPage() {
		return page;
	}

	@Override
	public Sort getSort() {
		return sort;
	}

	@Override
	public Long getTotal() {
		return total;
	}

	@Override
	public List<T> getList() {
		return list;
	}

	public PageListBase<T> setPage(Page page) {
		this.page = page;
		return this;
	}

	public PageListBase<T> setSort(Sort sort) {
		this.sort = sort;
		return this;
	}

	public PageListBase<T> setTotal(Long total) {
		this.total = total;
		return this;
	}

	public PageListBase<T> setList(List<T> list) {
		this.list = list;
		return this;
	}

	public Integer getShowMaxPageSize() {
		return showMaxPageSize;
	}

	public void setShowMaxPageSize(Integer showMaxPageSize) {
		this.showMaxPageSize = showMaxPageSize;
	}
}
