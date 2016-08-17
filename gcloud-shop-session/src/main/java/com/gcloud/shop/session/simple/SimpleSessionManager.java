package com.gcloud.shop.session.simple;

import com.gcloud.shop.session.*;
import com.gcloud.shop.session.util.SessionIdGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

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
@Repository
public class SimpleSessionManager implements ISessionManager {

	private final Map<String, ISession> sessions;

	private SessionConfig sessionConfig;

	public static final String cookie4SessionName = "auth";
	
	/**
	 * 默认的cookie的session的存货时间，默认为7天
	 */
	public static final int defaultCookieSessionAge = 1;

	public SimpleSessionManager() {
		sessions = Collections.synchronizedMap(new HashMap<String, ISession>());
	}
	
	@Override
	public ISession createSession(String sessionId, HttpServletRequest request, HttpServletResponse response) throws SessionException {

		SimpleRefSession session = new SimpleRefSession(request, response, SessionIdGenerator.generate());
		sessions.put(sessionId, session);
		Cookie cookie = new Cookie(cookie4SessionName, sessionId);
		cookie.setPath(getSessionConfig().getSessionRootHost());
		cookie.setMaxAge(defaultCookieSessionAge * 24 * 3600);
		response.addCookie(cookie);
		return session;
	}

	@Override
	public ISession getSession(String sessionId, HttpServletRequest request, HttpServletResponse response) throws SessionException {
		if(StringUtils.isEmpty(sessionId)){
			Cookie[] cookies = request.getCookies();
			if(null == cookies || cookies.length == 0){
				throw new SessionException(Constant.API_CALL_ERROR_CODE, "用户会话已过期");
			}
			for(Cookie cookie : cookies){
				if(cookie4SessionName.equals(cookie.getName())){
					sessionId = cookie.getValue();
				}
			}
			if(StringUtils.isEmpty(sessionId)){
				throw new SessionException(Constant.API_CALL_ERROR_CODE, "用户会话已过期");
			}
		}
		ISession session = sessions.get(sessionId);
		if(null == session){
			throw new SessionException(Constant.API_CALL_ERROR_CODE, "用户会话已过期");
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

	public void setSessionConfig(SessionConfig config) {
		sessionConfig = config;
	}

	@Override
	public boolean isCentralSession() {
		return false;
	}
}
