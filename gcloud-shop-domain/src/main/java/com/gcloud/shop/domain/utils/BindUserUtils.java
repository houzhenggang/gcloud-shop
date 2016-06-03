package com.gcloud.shop.domain.utils;

import com.gcloud.shop.domain.user.User;

import java.util.List;
import java.util.Set;

/**
 * 多店铺绑定用户的工具类
 * @author chenjin
 * @since 2016年03月18日 上午11:35:28
 **/
public class BindUserUtils {

	/**
	 * 判断此用户是否是多店铺的主账户
	 * @param user
	 * @return
	 */
	public static boolean isBindUser(User user){
		return user.getMasterUser() != null && user.getMasterUser() == 1 && user.getBindUsers().size() > 0;
	}

	/**
	 * 判断此用户是否是多店铺的主账户并且是糅合模式
	 * @param user
	 * @return
	 */
	public static boolean isBindUserMixModel(User user){
		return isBindUser(user) && user.getUserConf().getMmb() != null && user.getUserConf().getMmb() == 1;
	}
	
	/**
	 * 如果user是绑定用户，那么将会迭代每一个绑定的用户，执行handler方法，如果不是绑定用户，那么将会执行一次
	 * @param user
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	public static Object iterateHandle(User user, Handler handler){
		if(!isBindUser(user)){
			try{
				return handler.handle(user);
			}catch(Exception e){
				handler.exceptionHandle(user, e);
				return null;
			}
		}
		
		Set<Long> taobaoIds = user.getBindUsers().keySet();
		for(Long taobaoId : taobaoIds){
			User __bindUser = user.getBindUsers().get(taobaoId);
			if(user.getTaobaoId().longValue() != __bindUser.getTaobaoId()){
				__bindUser.setMasterUserData(user);
			}
			try{
				handler.handle(__bindUser);
			}catch(Exception e){
				handler.exceptionHandle(__bindUser, e);
			}
		}
		return null;		
	}
	
	/**
	 * 找到主店铺用户
	 * @param bindUsers
	 * @return
	 */
	public static User findMasterUser(List<User> bindUsers){
		for(User bindUser : bindUsers){
			if(bindUser.getMasterUser() != null && bindUser.getMasterUser() == 1)
				return bindUser;
		}
		return null;
	}
	
	public static interface Handler{
		
		public Object handle(User user) throws Exception;
		
		/**
		 * 异常处理
		 * @param user
		 * @param e
		 * @return 如果返回true，则继续后面的绑定用户的操作，如果返回false，则暂停执行后面的操作
		 */
		public boolean exceptionHandle(User user, Exception e);
	}
}
