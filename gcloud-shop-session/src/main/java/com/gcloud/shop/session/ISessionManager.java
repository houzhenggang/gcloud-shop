package com.gcloud.shop.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: MemSession
 * @Package com.gcloud.api
 * @Description: 地址Service
 * @date 2016/6/1 13:53
 */
public interface ISessionManager {

	/**
	 * 创建Session
	 * @param sessionId
	 * @param reqest
	 * @param response
	 * @return
	 * @throws SessionException
     */
	public ISession createSession(String sessionId, HttpServletRequest reqest, HttpServletResponse response) throws SessionException;

	/**
	 * 根据sessionId获取相应的会话对象
	 * @param sessionId
	 * @return
	 * @throws SessionException
	 */
	public ISession getSession(String sessionId, HttpServletRequest reqest, HttpServletResponse response) throws SessionException;

	/**
	 * 根据sessionId删除相应的会话对象
	 * @param sessionId
	 * @return
	 * @throws SessionException
	 */
	public ISession delSession(String sessionId, HttpServletRequest reqest, HttpServletResponse response) throws SessionException;

	/**
	 * 获取会话配置
	 * @return
	 * @throws SessionException
	 */
	public SessionConfig getSessionConfig() throws SessionException;

	/**
	 * 保存会话配置
	 * @return
	 * @throws SessionException
	 */
	public void setSessionConfig(SessionConfig sessionConfig) throws SessionException;

}
