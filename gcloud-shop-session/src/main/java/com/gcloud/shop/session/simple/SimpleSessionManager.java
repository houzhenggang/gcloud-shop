package com.gcloud.shop.session.simple;

import com.gcloud.shop.session.*;
import com.gcloud.shop.session.util.SessionIdGenerator;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: MemSession
 * @Package com.gcloud.api
 * @Description: 地址Service
 * @date 2016/6/1 13:53
 */
public class SimpleSessionManager implements ISessionManager {

	private final Map<String, ISession> sessions;

	private SessionConfig sessionConfig;

	public SimpleSessionManager() {
		sessions = Collections.synchronizedMap(new HashMap<String, ISession>());
	}

	public SimpleSessionManager(SessionConfig sessionConfig) {
		sessions = Collections.synchronizedMap(new HashMap<String, ISession>());
		this.sessionConfig = sessionConfig;
	}

	/**
	 *
	 * @param sessionId
	 * @param request
	 * @param response
	 * @return
	 * @throws SessionException
     */
	@Override
	public ISession createSession(String sessionId, HttpServletRequest request, HttpServletResponse response) throws SessionException {

		SimpleRefSession session = null;
		try {

			session = new SimpleRefSession(request, response, SessionIdGenerator.generate());
			sessions.put(sessionId, session);
			Cookie cookie = new Cookie(sessionConfig.getSecret(), sessionId);
			cookie.setPath(getSessionConfig().getSessionRootHost());
			cookie.setMaxAge(sessionConfig.getDefaultExpiryTime() * 24 * 3600);
			response.addCookie(cookie);
		} catch(SessionException e){
			throw new SessionException(Constant.API_CALL_ERROR, "创建Session失败!");
		} catch (Exception e) {
			throw new SessionException(Constant.API_CALL_ERROR, e.getMessage());
		}
		return session;
	}

	/**
	 *
	 * @param sessionId
	 * @param request
	 * @param response
	 * @return
	 * @throws SessionException
     */
	@Override
	public ISession getSession(String sessionId, HttpServletRequest request, HttpServletResponse response) throws SessionException {

		ISession session = null;
		try {
			if(StringUtils.isEmpty(sessionId)){
				Cookie[] cookies = request.getCookies();
				if( null != cookies && cookies.length > 0 ){
					for(Cookie cookie : cookies){
						if(sessionConfig.getSecret().equals(cookie.getName())){
							sessionId = cookie.getValue();
							if(StringUtils.isNotEmpty(sessionId)){
								session = sessions.get(sessionId);
							}
							return session;
						}
					}
				}
			}
		} catch (Exception e) {
			throw new SessionException(Constant.API_CALL_ERROR, e.getMessage());
		}
		return session;
	}

	/**
	 *
	 * @param sessionId
	 * @param request
	 * @param response
	 * @return
	 * @throws SessionException
     */
	@Override
	public ISession delSession(String sessionId, HttpServletRequest request, HttpServletResponse response) throws SessionException {

		ISession session = null;
		try {
			session = sessions.remove(sessionId);
		} catch (Exception e) {
			throw new SessionException(Constant.API_CALL_ERROR, e.getMessage());
		}
		return session;
	}

	@Override
	public SessionConfig getSessionConfig() throws SessionException {
		if (null == sessionConfig) {
			sessionConfig = new SessionConfig();
		}
		return sessionConfig;
	}

	@Override
	public void setSessionConfig(SessionConfig config) {
		sessionConfig = config;
	}

}
