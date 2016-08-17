package com.gcloud.shop.session.simple;

import com.gcloud.shop.session.ISession;
import com.gcloud.shop.session.ISessionManager;
import com.gcloud.shop.session.SessionConfig;
import com.gcloud.shop.session.SessionException;
import com.gcloud.shop.session.util.SessionIdGenerator;
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
	public ISession createSession(Long userId, HttpServletRequest request,
								  HttpServletResponse response) throws SessionException {

		SimpleRefSession session = new SimpleRefSession(request, response, SessionIdGenerator.generate());
		sessions.put(session.getSessionId(), session);
		// 将会话编号设置到response中的cookie里
		Cookie cookie = new Cookie(cookie4SessionName, session.getSessionId());
		cookie.setPath(getSessionConfig().getSessionRootHost());
		//cookie.setMaxAge(defaultCookieSessionAge * 24 * 3600);
		response.addCookie(cookie);
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
	public ISession getSession(String sessionId, HttpServletRequest request,
							   HttpServletResponse response) throws SessionException {
		if(null == sessionId || "".equals(sessionId.trim())){
			// 从request的cookie中获取
			Cookie[] cookies = request.getCookies();
			if(null == cookies || cookies.length == 0){
				throw new SessionException("用户会话已过期");
			}
			for(Cookie cookie : cookies){
				if(cookie4SessionName.equals(cookie.getName())){
					sessionId = cookie.getValue();
				}
			}
			if(null == sessionId || "".equals(sessionId.trim())){
				throw new SessionException("用户会话已过期");
			}
		}
		ISession session = sessions.get(sessionId);
		if(null == session)
			throw new SessionException("用户会话已过期");
		return session;
	}
	
	@Override
	public boolean isCentralSession() {
		return false;
	}
}
