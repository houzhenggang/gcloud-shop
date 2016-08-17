package com.gcloud.shop.session.ocs;

import com.gcloud.shop.session.ISession;
import com.gcloud.shop.session.ISessionManager;
import com.gcloud.shop.session.SessionConfig;
import com.gcloud.shop.session.SessionException;
import com.gcloud.shop.session.util.SessionIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
@Repository
public class OcsSessionManager implements ISessionManager {

	private SessionConfig sessionConfig;

	/**
	 * sessionId可有可无
	 */
	@Override
	public ISession getSession(String sessionId, HttpServletRequest reqest,
							   HttpServletResponse response) throws SessionException {
		try {
			return new OcsSession(reqest, response, sessionId, null);
		} catch(SessionException e){
			throw e;
		} catch (Exception e) {
			throw new SessionException(e);
		}
	}

	@Override
	public ISession createSession(Long storeId, HttpServletRequest reqest,  HttpServletResponse response) throws SessionException {
		try {
			return new OcsSession(reqest, response, SessionIdGenerator.generate(), storeId);
		} catch(SessionException e){
			throw e;
		} catch (Exception e) {
			throw new SessionException(e);
		}
	}

	@Override
	public SessionConfig getSessionConfig() throws SessionException {
		if (null == sessionConfig) {
			sessionConfig = new SessionConfig();
		}
		return sessionConfig;
	}
	
	@Autowired(required=false)
	public void setSessionConfig(SessionConfig config){
		sessionConfig = config;
	}
	
	@Override
	public boolean isCentralSession() {
		return true;
	}

}
