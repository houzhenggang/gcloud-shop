package com.gcloud.shop.session.simple;

import com.gcloud.shop.domain.UserInfo;
import com.gcloud.shop.session.AbstractRefSession;
import com.gcloud.shop.session.SessionException;

import java.io.Serializable;
import java.util.Set;

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
public class SimpleRefSession extends AbstractRefSession {

	protected final SimpleSession session;
	
	public SimpleRefSession(HttpServletRequest req, HttpServletResponse rsp, String sessionId) {
		super(req, rsp, sessionId);
		session = new SimpleSession(sessionId);
	}
	
	@Override
	public Serializable getAttribute(String attrName) throws SessionException {
		return session.getAttribute(attrName);
	}

	@Override
	public <T extends Serializable> T getAttribute(String attrName,
												   Class<T> type) throws SessionException {
		return session.getAttribute(attrName, type);
	}

	@Override
	public boolean removeAttribute(String attrName) throws SessionException {
		return session.removeAttribute(attrName);
	}

	@Override
	public boolean containAttributeName(String attrName) {
		return session.containAttributeName(attrName);
	}

	@Override
	public void setAttribute(String attrName, Serializable value)
			throws SessionException {
		session.setAttribute(attrName, value);
	}

	@Override
	@Deprecated
	public void setAttribute(String attrName, Serializable value, int expiryTime)
			throws SessionException {
		session.setAttribute(attrName, value, expiryTime);
	}

	@Override
	public Set<String> getAllAttributeKeys() throws SessionException {
		return session.getAllAttributeKeys();
	}

	@Override
	public UserInfo getUser() throws SessionException {
		return session.getUser();
	}

	@Override
	public void setUser(UserInfo userInfo) throws SessionException {
		session.setUser(userInfo);
	}

	@Override
	public void logout(UserInfo userInfo, HttpServletRequest req, HttpServletResponse rsp) throws SessionException {
		session.logout(userInfo, req, rsp);
	}

}
