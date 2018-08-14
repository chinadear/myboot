package com.bootplus.Util;


public class HqlEscapeUtil {

	private static final String[] characters={"%","_"};
	
	/**
	 * 需要增加转换方法
	 * @param likeStr
	 * @return
	 */
	public static boolean IsNeedEscape(String likeStr){
		for(String s: characters){
			if(likeStr.indexOf(s)>-1)
				return true;
		}
			
		return false;
	} 
	
	/**
	 * 进行转换
	 * @param likeStr
	 * @return
	 */
	public static String escape(String likeStr) {
		likeStr = likeStr.replace("_", HqlEscapeUtil.HQL_ESCAPE_KEY+"_");
		likeStr = likeStr.replace("%", HqlEscapeUtil.HQL_ESCAPE_KEY+"%");
        return likeStr;
    }
	
	public static final String HQL_ESCAPE_KEY="№";
	public static final String HQL_ESCAPE=new StringBuffer(" escape '").append(HQL_ESCAPE_KEY).append("' ").toString();
	
}
