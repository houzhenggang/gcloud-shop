package com.gcloud.shop.solr.util;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: sd
 * @Package com.gcloud.shop.solr.util
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2016/8/17 14:07
 */
public class HighlightUtils {

	/**
	 * 高亮方法，将一串original的字符串，根据keyWords进行高亮，高亮的标签使用pre和post进行封装。
	 * keyWords中如果有空格，将会根据空格分隔多个字符串进行匹配高亮
	 * @param original 匹配的字符串
	 * @param keyWords 匹配的关键词，多个关键词使用空格隔开
	 * @param pre 高亮的前置标签
	 * @param post 高亮的后置标签
	 * @return
	 */
	public static HighlightInfo highlight(String original, String keyWords, String pre, String post){
		if(StringUtils.isEmpty(keyWords)){
			return HighlightInfo.buildNonHighlight();
		}
		
		return highlight(original, filterSameWords(StringUtils.split(keyWords.trim(), " ")), pre, post);
	}
	
	/**
	 * 这个方法传入的keyWords，尽可能的不要重复，如果它有可能重复，调用之前，先对这个参数过滤掉重复标签,可以参考{@link #filterSameWords(String[])}
	 * 方法
	 * @param original
	 * @param keyWords
	 * @param pre
	 * @param post
	 * @return
	 */
	public static HighlightInfo highlight(String original, String[] words, String pre, String post){
		HighlightInfo info = new HighlightInfo().setContent(original);
		// 遍历每个关键词进行高亮匹配
		for(String word : words){
			__highlight(info, word, pre, post);
		}
		
		return info;
	}
	
	/**
	 * 过滤掉相同的词，过滤之后再按照字符串的长度，由小到大进行排序
	 * @param words
	 * @return
	 */
	public static String[] filterSameWords(final String[] words){
		if(words.length == 1)
			return words;
		if(words.length == 2){
			if(words[0].equals(words[1]))
				return new String[]{words[0]};
			return words;
		}
		
		Map<String, Integer> keys = new HashMap<String, Integer>();
		// 遍历以便，并设置到keys中
		for(String word : words){
			keys.put(word, 1);
		}
		
		return keys.keySet().toArray(new String[keys.size()]);
	}
	
	/**
	 * 对单独的一个词进行匹配
	 * @param info
	 * @param singleWord
	 * @param pre
	 * @param post
	 */
	private static void __highlight(final HighlightInfo info, String singleWord, String pre, String post){
		int index = StringUtils.indexOf(info.getContent(), singleWord);
		// 未匹配到此字符串
		if(index == -1){
			return ;
		}
		
		List<Integer> indexs = new ArrayList<Integer>();
		String replaceWord = new StringBuilder(pre).append(singleWord).append(post).toString();
		int offset = 0;
		do{
			indexs.add(index + offset);
			index = StringUtils.indexOf(info.getContent(), singleWord, index+1);
			offset += replaceWord.length() - singleWord.length();
		}while(index != -1);
		
		for(Integer __index : indexs){
			info.setContent(StringUtils.overlay(info.getContent(), replaceWord, __index, __index + singleWord.length()));
		}
		
		info.setHighlighting(true);
	}
	
	public static class HighlightInfo implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 8494322322626508446L;
		
		/**
		 * 高亮后的内容，如果highlighting为false，则content为null
		 */
		private String content;
		
		/**
		 * 是否有高亮内容
		 */
		private boolean highlighting;

		public String getContent() {
			return content;
		}

		public HighlightInfo setContent(String content) {
			this.content = content;
			return this;
		}

		public boolean isHighlighting() {
			return highlighting;
		}

		public HighlightInfo setHighlighting(boolean highlighting) {
			this.highlighting = highlighting;
			return this;
		}
		
		public static HighlightInfo buildNonHighlight(){
			return new HighlightInfo().setContent(null).setHighlighting(false);
		}
	}
}
