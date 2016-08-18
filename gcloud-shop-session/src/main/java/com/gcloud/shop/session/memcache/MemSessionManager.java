package com.gcloud.shop.session.memcache;

import com.gcloud.shop.session.*;
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
public class MemSessionManager implements ISessionManager {

	private SessionConfig sessionConfig;

	/**
	 *
	 * @param sessionId
	 * @param reqest
	 * @param response
	 * @return
	 * @throws SessionException
     */
	@Override
	public ISession createSession(String sessionId, HttpServletRequest reqest, HttpServletResponse response) throws SessionException {
		try {
			return new MemSession(reqest, response, sessionId);
		} catch(SessionException e){
			throw new SessionException(Constant.API_CALL_ERROR, "创建Session失败!");
		} catch (Exception e) {
			throw new SessionException(Constant.API_CALL_ERROR, e.getMessage());
		}
	}

	/**
	 *
	 * @param sessionId
	 * @param reqest
	 * @param response
	 * @return
	 * @throws SessionException
     */
	@Override
	public ISession getSession(String sessionId, HttpServletRequest reqest, HttpServletResponse response) throws SessionException {
		try {
			return new MemSession(reqest, response, sessionId);
		} catch(SessionException e){
			throw new SessionException(Constant.API_CALL_ERROR, "获取Session失败!");
		} catch (Exception e) {
			throw new SessionException(Constant.API_CALL_ERROR, e.getMessage());
		}
	}

	/**
	 *
	 * @param sessionId
	 * @param reqest
	 * @param response
	 * @return
	 * @throws SessionException
     */
	@Override
	public ISession delSession(String sessionId, HttpServletRequest reqest, HttpServletResponse response) throws SessionException {
		try {
			return new MemSession(reqest, response, sessionId);
		} catch(SessionException e){
			throw new SessionException(Constant.API_CALL_ERROR, "删除Session失败!");
		} catch (Exception e) {
			throw new SessionException(Constant.API_CALL_ERROR, e.getMessage());
		}
	}

	@Override
	public SessionConfig getSessionConfig() throws SessionException {
		if (null == sessionConfig) {
			sessionConfig = new SessionConfig();
		}
		return sessionConfig;
	}

	@Override
	public void setSessionConfig(SessionConfig config){
		sessionConfig = config;
	}

}
