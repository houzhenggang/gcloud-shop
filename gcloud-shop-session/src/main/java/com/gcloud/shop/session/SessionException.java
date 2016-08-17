package com.gcloud.shop.session;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: MemSession
 * @Package com.gcloud.api
 * @Description: 读取缓存时抛出的异常
 * @date 2016/6/1 13:53
 */
public class SessionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6867165720650881604L;

	public SessionException(String msg) {
		super(msg);
	}
	
	public SessionException(Exception e){
		super(e);
	}
}
