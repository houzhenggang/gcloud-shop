package com.gcloud.shop.core.utils;

import java.math.BigDecimal;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: UserServiceImpl
 * @Package com.gcloud.api
 * @Description: 价格辅助类
 * @date 2016/6/1 13:53
 */
public class PriceUtils {

	/**
	 * 将长整型的价格，例如100表示1.00，转换为字符串
	 * @param price
	 * @return
	 */
	public static String toPriceString(Long price){
		return new BigDecimal(price*0.01).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}
}
