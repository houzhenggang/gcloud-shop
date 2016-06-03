package com.gcloud.shop.domain;

import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: Configurable
 * @Package com.gcloud.domain
 * @Description: 可以配置化接口
 * @date 2016/6/1 13:53
 */
public interface Configurable {

	/**
	 * 根据属性的名称获取属性的配置数据
	 * @param key
	 * @return
	 */
	public String getProperty(String key);
	
	/**
	 * 设置或者更新属性值, Object应该为String类型，或者基本类型，否则其他类型统一使用toString方式序列化
	 * @param key
	 * @param value
	 * @return
	 */
	public void setProperty(String key, Object value);
	
	public String getProperty(String key, String defaultValue);
	
	public boolean getBoolean(String key, boolean defaultValue);
	
	public int getInteger(String key, int defaultValue);
	
	public double getDouble(String key, double defaultValue);
	
	public long getLong(String key, long defaultValue);
	
	public float getFloat(String key, float defaultValue);
	
	/**
	 * 获取日期，默认的日期格式为yyyy-MM-dd HH:mm:ss
	 * @param key
	 * @return
	 */
	public Date getDate(String key) throws ParseException;
	
	public Date getDate(String key, String format) throws ParseException;
	
	/**
	 * 获取所有的属性
	 * @return
	 */
	public Properties getProperties();
}
