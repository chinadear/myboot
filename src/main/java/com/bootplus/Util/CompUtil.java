package com.bootplus.Util;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 组件工具类
 * @author liulu
 * @version v1.0
 * 2013-8-23
 */
public class CompUtil {
	/**
	 * Array与json的转换
	 * @param obj
	 * @return
	 */
	public static String array2Json(Object obj){
		return collection2Json(obj);
	}
	@SuppressWarnings("unchecked")
	public static Object json2Array(String json,Class c){
		return JSONArray.parseArray(json, c);
	}
	/**
	 * List与json的转化
	 * @param obj
	 * @return
	 */
	public static String list2Json(Object obj){
		return collection2Json(obj);
	}
	@SuppressWarnings("rawtypes")
	public static List json2List(String json){
		return (List)json2Collection(json);
	}
	/**
	 * Map与json的转化
	 * @param obj
	 * @return
	 */
	public static String map2Json(Object obj){
		return JSONObject.toJSON(obj).toString();
	}
	public static Map<String,String> json2Map(String json){
		Map<String,String> map=new HashMap<String, String>();
		JSONObject jsonObj=JSONObject.parseObject(json);
		for(Object k: jsonObj.keySet()){
			 Object v= jsonObj.get(k);
			 map.put(k.toString(),v.toString());
		}
		return map;
	}
	/**
	 * 集合与json的转化
	 * @param obj
	 * @return
	 */
	public static String collection2Json(Object obj){
		JSONArray jsonArray = (JSONArray) JSONArray.toJSON(obj);
		return jsonArray.toString();
	}
	public static Collection json2Collection(String json){
		return (Collection)JSONArray.parse(json);
	}
	 /**
	 * 组织机构选择组件设置值,返回json树格式字符串
	 * @param treeList
	 * @return
	 */
	 public static String treeSetValues(List<TreeBean> treeList){
		return list2Json(treeList);
	 }
	 /**
	 * 处理url中的变量
	 * 用于将url中【=】等号后面的变量填充
	 * @param url，链接例如：abc/bcd/aa/dealUrl.do?id=&name=&age=&.........
	 * @param var,对应的变量值，字符串数组形式，可以罗列如：dealUrl(url,"asd","fds"...) 
	 * 			     也可以dealUrl(url,String[n] var)
	 * @return url
	 */
	public static String dealUrl(String url,String...var){
		return dealString("=", url, var);
	}
	/**
	 * 处理字符串，在指定的内容后面追加内容
	 * @param regex,指定的内容可以匹配正则
	 * @param str,待处理的字符串
	 * @param var,插入的内容
	 * @return
	 */
	public static String dealString(String regex,String str,String...var){
		StringBuffer sstr = new StringBuffer(str);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sstr.toString());
		int i=0;
		int length=0;
		if(var.length>0){
			while(m.find()){
				if(i>0){
					if(var.length>i){
						length=length+var[i-1].length();
						sstr.insert((m.start()+length+1),var[i]);
					}
				}else{
					sstr.insert((m.start()+1),var[i]);
				}
				i++;
			}
		}
		return sstr.toString();
	}
	public static String getCurDateDir() {
		return DateUtil.getCurYear()+File.separator+DateUtil.getCurMonth()+File.separator+DateUtil.getCurDay()+File.separator;
	}
	/**
	 * 无头有尾
	 * a/b/c/
	 * @return
	 */
	public static String formatDir(String path) {
		if(!"".equals(path)){
			String firstChar = path.substring(0,1);
			String lastChar = path.substring(path.length()-1,path.length());
			if("/".equals(firstChar)||"\\".equals(firstChar)){
				path=path.substring(1);
			}
			if(!"/".equals(lastChar)&&!"\\".equals(lastChar)) {
				path=path+File.separator;
			}
		}
		return path;
	}
}
