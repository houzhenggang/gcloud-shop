package com.gcloud.shop.session.redis;

import com.gcloud.shop.domain.UserInfo;
import com.gcloud.shop.session.AbstractRefSession;
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
public class RedisSession extends AbstractRefSession {

	private static final Logger logger = LogManager.getLogger(RedisSession.class);

	//12个小时
	protected static final int defauiltSessionTime = 60*60*12;

	protected final Long storeId;

	/**
	 * 这个会话实现，SessionId可有可无
	 * @param req
	 * @param rsp
	 * @param sessionId
	 * @throws Exception
	 */
	public RedisSession(HttpServletRequest req, HttpServletResponse rsp, String sessionId, Long storeId) throws Exception {

		super(req, rsp, sessionId);
		Long __storeId = storeId;
		if(null == __storeId){
//			__storeId = (Long)memSessionHandle.getObj(req, "storeId");
		}else{
//			memSessionHandle.setObj(request, response, "storeId", __storeId, __storeId);
		}
		
		if(null == __storeId)
			throw new SessionException("会话已失效");
		this.storeId = __storeId;
	}

	@Override
	public Serializable getAttribute(String attrName) throws SessionException {
		try {
			return null; //memSessionHandle.getObj(request, attrName);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SessionException(e);
		}
	}

	@Override
	public <T extends Serializable> T getAttribute(String attrName,
												   Class<T> type) throws SessionException {
		if(null == type)
			throw new NullPointerException("type参数为空");
		return type.cast(getAttribute(attrName));
	}

	@Override
	public boolean removeAttribute(String attrName) throws SessionException {
		try {
//			trymemSessionHandle.removeObj(request, attrName);
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SessionException(e);
		}
	}

	@Override
	public boolean containAttributeName(String attrName) throws SessionException {
		try {
			return true; // memSessionHandle.hasObj(request, attrName);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SessionException(e);
		}
	}

	@Override
	public void setAttribute(String attrName, Serializable value) throws SessionException {
		try {
			if( null == value){
				logger.warn("value is not allow null!");
				throw new SessionException("value is not allow null!");
			}
//			memSessionHandle.setObj(request, response, attrName, storeId, value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SessionException(e);
		}
	}

	@Override
	public void setAttribute(String attrName, Serializable value, int expiryTime)
			throws SessionException {
		try {
			if(null == value){
				logger.warn("value is not allow null!");
				throw new SessionException("value is not allow null!");
			}
			//memSessionHandle.setObj(request, response, attrName, storeId, expiryTime, value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SessionException(e);
		}
	}

	@Override
	public Set<String> getAllAttributeKeys() throws SessionException {
		throw new SessionException("getAllAttributeKeys此方法实现不了");
	}

	@Override
	public UserInfo getUser() throws SessionException {
		return getAttribute("userInfo", UserInfo.class);
	}

	@Override
	public void setUser(UserInfo userInfo) throws SessionException {
		userInfo.setConf(null);
		setAttribute("user", userInfo, 86400);
	}

	@Override
	public void logout(UserInfo userInfo, HttpServletRequest req, HttpServletResponse rsp) throws SessionException {

		removeAttribute("user");
		Cookie cookie = new Cookie("memSessionId","");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		rsp.addCookie(cookie);
	}

}
