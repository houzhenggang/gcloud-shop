package com.gcloud.shop.domain.utils;


/**
 * 偏移地区工具包
 * @author chenjin
 * @since 2016年03月18日 上午11:35:28
 **/
public class BacklandUtils {

	public static final String[] BACKLAND_KEYS = new String[]{"寺","庙","旗","盟","组","乡","村","镇","自治","军区","部队"};
	
	/**
	 * 获取地址中第一个包含偏僻地区关键字，并返回这个关键字，如果不包含，则返回""空字符串
	 * @param address
	 * @return
	 */
	public static String getFirstBacklandKey(String address){
		return getFirstBacklandKey(new DefaultWordAnalyzer(), address);
	}
	
	public static String getFirstBacklandKey(IWordAnalyzer analyzer, String address){
		String[] words = analyzer.splitWords(address);
		
		for(String word : words){
			for(String key : BACKLAND_KEYS){
				if(word.contains(key))
					return key;
			}
		}
		
		return "";
	}
	
	/**
	 * 分词器，默认的实现是不分词的
	 * @author JackyLIU
	 *
	 */
	public static interface IWordAnalyzer{
		
		public String[] splitWords(String content);
	}
	
	public static class DefaultWordAnalyzer implements IWordAnalyzer{

		@Override
		public String[] splitWords(String content) {
			return new String[]{content};
		}
		
	}
}
