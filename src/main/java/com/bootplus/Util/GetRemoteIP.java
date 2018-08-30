package com.bootplus.Util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class GetRemoteIP {

	/**
     * 获取访问用户的客户端IP（适用于公网与局域网）.
     */
    public static final String get(final HttpServletRequest request)throws Exception {
        if (request == null) {
            throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
        }
        String ipString = request.getHeader("x-forwarded-for");
        if (StringUtils.hasText(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.hasText(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.hasText(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getRemoteAddr();
        }
     
        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ipString.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ipString = str;
                break;
            }
        }
        return ipString;
    }
    /**
     * 模糊IP地址，安全起见不暴露访者的地址xx.*.*.xx;
     * @param ip
     * @return
     */
    public static final String vague(final HttpServletRequest request) {
    	String ip=null;
    	String ipaddr="*.*.*.*";
		try {
			ip = get(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(StringUtils.hasText(ip)) {
    		String[] vip=ip.split(".");
    		ipaddr=vip[0]+"*.*"+vip[3];
    	}
    	return ipaddr;
    }
    
}
