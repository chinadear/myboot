package com.bootplus.Util;

import java.util.ArrayList;
import java.util.List;

import com.huaban.analysis.jieba.JiebaSegmenter;
/**
 * 分词工具类
 * @author angle
 *
 */
public class SplitWordUtil {
	/**
	 * 中文分词
	 * 规则去掉标点符号，空格不计在内，分出的词长度要大于2
	 * @param words
	 * @return
	 */
	public static List<String> split(String words){
		JiebaSegmenter segmenter = new JiebaSegmenter();
		List<String> list=segmenter.sentenceProcess(words);
		List<String> r=new ArrayList<String>();
		for(String s:list) {
			if(s.trim().length()>=2) {
				r.add(s);
			}
		}
		return r;
	}
}
