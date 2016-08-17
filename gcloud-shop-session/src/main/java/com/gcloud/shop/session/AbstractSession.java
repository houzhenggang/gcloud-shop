package com.gcloud.shop.session;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: MemSession
 * @Package com.gcloud.api
 * @Description: 地址Service
 * @date 2016/6/1 13:53
 */
public abstract class AbstractSession implements ISession {

	protected final String sessionId;
	
	public AbstractSession(String sessionId){
		this.sessionId = sessionId;
	}
	
	@Override
	public String getSessionId() {
		return sessionId;
	}
}
