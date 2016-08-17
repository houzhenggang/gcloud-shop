package com.gcloud.shop.session.util;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: MemSession
 * @Package com.gcloud.api
 * @Description: 地址Service
 * @date 2016/6/1 13:53
 */
public class SessionIdGenerator {

	private static final IdGenerator idGenerator = new IdGenerator();
	
	/**
	 * 会话ID的长度
	 */
	public static int length = 20;
	
	public static String generate(){
		return idGenerator.generateId(length).toLowerCase();
	}
}
