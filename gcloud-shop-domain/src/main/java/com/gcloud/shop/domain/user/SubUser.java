package com.gcloud.shop.domain.user;

import java.io.Serializable;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: SubUser
 * @Package com.gcloud.domain.SubUser
 * @Description: 子用户
 * @date 2016/6/1 13:53
 */
public class SubUser implements Serializable {

	private Long taobaoId;
	
	private String nick;
	
	private String sessionId;

	public Long getTaobaoId() {
		return taobaoId;
	}

	public void setTaobaoId(Long taobaoId) {
		this.taobaoId = taobaoId;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
