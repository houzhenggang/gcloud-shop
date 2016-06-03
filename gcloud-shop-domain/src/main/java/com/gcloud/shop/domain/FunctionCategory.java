package com.gcloud.shop.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: FunctionCategory
 * @Package com.gcloud.domain
 * @Description: 功能类目，例如系统设置功能、交易管理功能，每个功能分为两级，第一级是主类目，例如，系统设置时主类目，交易管理是主类目。
 * 					第二级是功能点，例如交易管理下面包含了订单处理，订单查询等等功能。
 * @date 2016/6/1 13:53
 */
public class FunctionCategory implements Serializable {


	private Integer id;
	
	private String name;
	
	private String description;
	
	/**
	 * 如果是第一级那么parentId为-1，第二级则为父类的一级类目
	 */
	private Integer parentId;
	
	/**
	 * 父级类目的名称，这个不用做存储，只是为了前端展示用
	 */
	private String parentName;
	
	/**
	 * 如果parentId为-1，那么表示一级类目，下面会有第二级子类目，这个属性在业务层中进行处理
	 */
	private List<FunctionCategory> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public List<FunctionCategory> getChildren() {
		return children;
	}

	public void setChildren(List<FunctionCategory> children) {
		this.children = children;
	}
}
