package com.gcloud.shop.session;

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
public abstract class AbstractRefSession extends AbstractSession {

	protected final HttpServletRequest request;
	
	protected final HttpServletResponse response;
	
	public AbstractRefSession(HttpServletRequest req, HttpServletResponse rsp, String sessionId) {
		super(sessionId);
		this.request = req;
		this.response = rsp;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

}
