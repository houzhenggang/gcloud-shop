package com.gcloud.shop.domain.utils;

/**
 * 将字符串类型
 * @author chenjin
 * @since 2016年03月18日 上午11:35:28
 **/
public class ArrayUtils {
	
	public static final String DEFAULT_SEPERATOR = ",";

	/**
	 * 将字符串"1,2,3,4"，分割成整形数组
	 * @param s
	 * @param seperator 分割符号，默认为','
	 * @return
	 */
	public static Integer[] toIntegerArray(String s, String seperator){
		String[] array = toStringArray(s, seperator);
		if(null == array)
			return null;
		Integer[] results = new Integer[array.length];
		int index = 0;
		for(String e : array){
			results[index++] = Integer.parseInt(e.trim());
		}
		return results;
	}
	
	/**
	 * 将字符串"1,2,3,4"，分割成整形数组
	 * @param s
	 * @return
	 */
	public static Integer[] toIntegerArray(String s){
		return toIntegerArray(s, DEFAULT_SEPERATOR);
	}
	
	public static Long[] toLongArray(String s, String seperator){
		String[] array = toStringArray(s, seperator);
		if(null == array)
			return null;
		Long[] results = new Long[array.length];
		int index = 0;
		for(String e : array){
			results[index++] = Long.parseLong(e);
		}
		return results;
	}
	
	public static Long[] toLongArray(String s){
		return toLongArray(s, DEFAULT_SEPERATOR);
	}
	
	/**
	 * 将"xxx,222,5444,555"，这样的字符窜转换为字符串数组
	 * @param s
	 * @param seperator 分割符号，默认为','
	 * @return
	 */
	public static String[] toStringArray(String s, String seperator){	
		if(null == s || "".equals(s))
			return null;	
		return s.split(seperator);
	}
	
	public static String[] toStringArray(String s){
		return toStringArray(s, DEFAULT_SEPERATOR);
	}
	
	public static Long[] toLongArray(String[] s){
		if(null == s)
			return null;
		Long[] a = new Long[s.length];
		int index = 0;
		for(String str : s){
			a[index++] = Long.parseLong(str);
		}
		return a;
	}
}
