package com.gcloud.shop.session.simple;

import com.gcloud.shop.domain.UserInfo;
import com.gcloud.shop.session.AbstractSession;
import com.gcloud.shop.session.SessionException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: MemSession
 * @Package com.gcloud.api
 * @Description: 地址Service
 * @date 2016/6/1 13:53
 */
public class SimpleSession extends AbstractSession {

	protected final Map<String, Serializable> session;

	public SimpleSession(String sessionId) {
		super(sessionId);
		session = Collections.synchronizedMap(new HashMap<String, Serializable>());
	}

	@Override
	public Serializable getAttribute(String attrName) throws SessionException {
		return session.get(getKey(attrName));
	}

	@Override
	public <T extends Serializable> T getAttribute(String attrName,
												   Class<T> type) throws SessionException {
		Serializable s = session.get(getKey(attrName));
		if (null == s)
			return null;
		return type.cast(s);
	}

	@Override
	public boolean removeAttribute(String attrName) throws SessionException {
		return session.remove(getKey(attrName)) == null ? false : true;
	}

	@Override
	public boolean containAttributeName(String attrName) {
		return session.containsKey(getKey(attrName));
	}
	
	private String getKey(String attrName){
		return new StringBuilder(this.sessionId.toLowerCase()).append("_").append(attrName).toString();
	}

	@Override
	public void setAttribute(String attrName, Serializable value)
			throws SessionException {
		session.put(getKey(attrName), value);
	}

	/**
	 * 
	 * @deprecated 此实现咱不支持属性的有效期控制
	 */
	@Override
	@Deprecated
	public void setAttribute(String attrName, Serializable value, int expiryTime)
			throws SessionException {
		setAttribute(getKey(attrName), value);
	}

	@Override
	public Set<String> getAllAttributeKeys() throws SessionException {
		return session.keySet();
	}

	@Override
	public UserInfo getUser() throws SessionException {
		return getAttribute("userInfo", UserInfo.class);
	}

	@Override
	public void setUser(UserInfo userInfo) throws SessionException {
		setAttribute("user", userInfo);
	}

	@Override
	public void logout(UserInfo userInfo, HttpServletRequest req, HttpServletResponse rsp) throws SessionException {

		removeAttribute("userInfo");
		Cookie cookie = new Cookie(SimpleSessionManager.cookie4SessionName, "");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		rsp.addCookie(cookie);
	}

}
