package com.gcloud.shop.domain.user;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: TbAuth
 * @Package com.gcloud.domain.SubUser
 * @Description: 有关淘宝授权的信息
 * @date 2016/6/1 13:53
 */
public class TbAuth implements Serializable {

	/**
	 *
	 */
	private Long reExpiresIn;

	/**
	 *
	 */
	private Long expiresIn;

	/**
	 *
	 */
	private Long r1ExpiresIn;

	/**
	 *
	 */
	private Long r2ExpiresIn;

	/**
	 *
	 */
	private Long w1ExpiresIn;

	/**
	 *
	 */
	private Long w2ExpiresIn;

	/**
	 *
	 */
	private String refreshToken;
	
	/**
	 * 授权时间
	 */
	private Date auth;

	public Long getReExpiresIn() {
		return reExpiresIn;
	}

	public void setReExpiresIn(Long reExpiresIn) {
		this.reExpiresIn = reExpiresIn;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Long getR1ExpiresIn() {
		return r1ExpiresIn;
	}

	public void setR1ExpiresIn(Long r1ExpiresIn) {
		this.r1ExpiresIn = r1ExpiresIn;
	}

	public Long getR2ExpiresIn() {
		return r2ExpiresIn;
	}

	public void setR2ExpiresIn(Long r2ExpiresIn) {
		this.r2ExpiresIn = r2ExpiresIn;
	}

	public Long getW1ExpiresIn() {
		return w1ExpiresIn;
	}

	public void setW1ExpiresIn(Long w1ExpiresIn) {
		this.w1ExpiresIn = w1ExpiresIn;
	}

	public Long getW2ExpiresIn() {
		return w2ExpiresIn;
	}

	public void setW2ExpiresIn(Long w2ExpiresIn) {
		this.w2ExpiresIn = w2ExpiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Date getAuth() {
		return auth;
	}

	public void setAuth(Date auth) {
		this.auth = auth;
	}

	/**
	 * 从授权的响应结果构建
	 * @param resp
	 * @return
	 */
	public static TbAuth valueOf(Map<String, String> resp, Date auth){
		TbAuth tbAuth = new TbAuth();
		if(resp.containsKey("re_expires_in")){
			tbAuth.setReExpiresIn(Long.parseLong(resp.get("re_expires_in")));
		}
		if(resp.containsKey("expires_in")){
			tbAuth.setExpiresIn(Long.parseLong(resp.get("expires_in")));
		}
		if(resp.containsKey("r1_expires_in")){
			tbAuth.setR1ExpiresIn(Long.parseLong(resp.get("r1_expires_in")));
		}
		if(resp.containsKey("r2_expires_in")){
			tbAuth.setR2ExpiresIn(Long.parseLong(resp.get("r2_expires_in")));
		}
		if(resp.containsKey("w1_expires_in")){
			tbAuth.setW1ExpiresIn(Long.parseLong(resp.get("w1_expires_in")));
		}
		if(resp.containsKey("w2_expires_in")){
			tbAuth.setW2ExpiresIn(Long.parseLong(resp.get("w2_expires_in")));
		}
		if(resp.containsKey("refresh_token")){
			tbAuth.setRefreshToken(resp.get("refresh_token"));
		}
		tbAuth.setAuth(auth);
		return tbAuth;
	}
}
