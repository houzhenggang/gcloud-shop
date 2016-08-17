package com.gcloud.shop.session;

import com.gcloud.shop.domain.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Set;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: MemSession
 * @Package com.gcloud.api
 * @Description: 地址Service
 * @date 2016/6/1 13:53
 */
public interface ISession {
	
	/**
	 * 获取会话ID
	 * @return
	 * @throws SessionException
	 */
	public String getSessionId();
	
	/**
	 * 登出会话
	 * @throws SessionException
	 */
	public void logout(UserInfo userInfo, HttpServletRequest req, HttpServletResponse rsp) throws SessionException;
	
	/**
	 * 获取会话中的用户数据
	 * @return
	 * @throws SessionException
	 */
	public UserInfo getUser() throws SessionException;
	
	/**
	 * 设置用户数据到会话中
	 * @param userInfo
	 * @throws SessionException
	 */
	public void setUser(UserInfo userInfo) throws SessionException;

	/**
	 * 获取会话的属性
	 * @param attrName
	 * @return
	 * @throws SessionException
	 */
	public Serializable getAttribute(String attrName) throws SessionException;
	
	/**
	 * 可以通过设置返回类型，而获取属性
	 * @param attrName
	 * @param type
	 * @return
	 * @throws SessionException
	 */
	public <T extends Serializable> T getAttribute(String attrName, Class<T> type) throws SessionException;
	
	/**
	 * 删除会话的属性
	 * @param attrName
	 * @return
	 * @throws SessionException
	 */
	public boolean removeAttribute(String attrName) throws SessionException;
	
	/**
	 * 是否包含某个属性
	 * @param attrName
	 * @return
	 */
	public boolean containAttributeName(String attrName) throws SessionException;
	
	/**
	 * 设置属性，会话的属性都有有效期，这个方法将使用系统默认的有效期设置
	 * @param attrName
	 * @param value
	 * @throws SessionException
	 */
	public void setAttribute(String attrName, Serializable value) throws SessionException;
	
	/**
	 * 设置属性，并设置会话的有效期时间，单位为秒
	 * @param attrName
	 * @param value
	 * @param expiryTime
	 * @throws SessionException
	 */
	public void setAttribute(String attrName, Serializable value, int expiryTime) throws SessionException;
	
	/**
	 * 获取会话中所有的属性名称
	 * @return
	 * @throws SessionException
	 */
	public Set<String> getAllAttributeKeys() throws SessionException;

}
