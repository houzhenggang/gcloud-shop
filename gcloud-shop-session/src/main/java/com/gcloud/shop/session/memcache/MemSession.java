package com.gcloud.shop.session.memcache;

import com.gcloud.shop.domain.UserInfo;
import com.gcloud.shop.session.AbstractRefSession;
import com.gcloud.shop.session.Constant;
import com.gcloud.shop.session.SessionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Set;

/**
 * 这个会话使用memcached-session-util中的库进行处理
 * @author JackyLIU
 *
 */
public class MemSession extends AbstractRefSession {

	private static final Logger logger = LogManager.getLogger(MemSession.class);

	//12个小时
	protected static final int defauiltSessionTime = 60*60*12;

	/**
	 * 这个会话实现，SessionId可有可无
	 * @param req
	 * @param rsp
	 * @param sessionId
	 * @throws Exception
	 */
	public MemSession(HttpServletRequest req, HttpServletResponse rsp, String sessionId) throws Exception {
		super(req, rsp, sessionId);
	}

	@Override
	public Serializable getAttribute(String attrName) throws SessionException {
		try {
			return null; //memSessionHandle.getObj(request, attrName);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SessionException(Constant.API_CALL_ERROR_CODE, e.getMessage());
		}
	}

	@Override
	public <T extends Serializable> T getAttribute(String attrName, Class<T> type) throws SessionException {
		if(null == type){
			throw new SessionException(Constant.API_CALL_ERROR_CODE, "type参数为空");
		}
		return type.cast(getAttribute(attrName));
	}

	@Override
	public boolean removeAttribute(String attrName) throws SessionException {
		try {
//			trymemSessionHandle.removeObj(request, attrName);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SessionException(Constant.API_CALL_ERROR_CODE, e.getMessage());
		}
	}

	@Override
	public boolean containAttributeName(String attrName) throws SessionException {
		try {
			return true; // memSessionHandle.hasObj(request, attrName);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SessionException(Constant.API_CALL_ERROR_CODE, e.getMessage());
		}
	}

	@Override
	public void setAttribute(String attrName, Serializable value) throws SessionException {
		try {
			if( null == value){
				logger.warn("value is not allow null!");
				throw new SessionException(Constant.API_CALL_ERROR_CODE, "value is not allow null!");
			}
//			memSessionHandle.setObj(request, response, attrName, storeId, value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SessionException(Constant.API_CALL_ERROR_CODE, e.getMessage());
		}
	}

	@Override
	public void setAttribute(String attrName, Serializable value, int expiryTime) throws SessionException {
		try {
			if(null == value){
				logger.warn("value is not allow null!");
				throw new SessionException(Constant.API_CALL_ERROR_CODE, "value is not allow null!");
			}
			//memSessionHandle.setObj(request, response, attrName, storeId, expiryTime, value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SessionException(Constant.API_CALL_ERROR_CODE, e.getMessage());
		}
	}

	@Override
	public Set<String> getAllAttributeKeys() throws SessionException {
		throw new SessionException(Constant.API_CALL_ERROR_CODE, "getAllAttributeKeys此方法实现不了!");
	}

	@Override
	public UserInfo getUser() throws SessionException {
		return getAttribute(Constant.LOGIN_USER_KEY, UserInfo.class);
	}

	@Override
	public void setUser(UserInfo userInfo) throws SessionException {
		userInfo.setConf(null);
		setAttribute(Constant.LOGIN_USER_KEY, userInfo, 86400);
	}

	@Override
	public void logout(UserInfo userInfo, HttpServletRequest req, HttpServletResponse rsp) throws SessionException {

		removeAttribute(Constant.LOGIN_USER_KEY);
		Cookie cookie = new Cookie("memSessionId","");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		rsp.addCookie(cookie);
	}

}
