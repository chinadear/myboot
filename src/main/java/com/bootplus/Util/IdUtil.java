package com.bootplus.Util;

import org.hibernate.id.UUIDHexGenerator;

public class IdUtil {
	/**
	 * 获取uuid字符串
	 * @return
	 */
	public static String getUUIDHEXStr(){
		UUIDHexGenerator u=new UUIDHexGenerator();
		return (String) u.generate(null, null);
	}
	
}
