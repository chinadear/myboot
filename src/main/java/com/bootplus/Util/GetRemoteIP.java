package com.bootplus.Util;

import java.io.File;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import sun.net.util.IPAddressUtil;
/**
 * ip地址操作类
 * @author ll
 * @date 2016-08-09
 * 20160809
 */
public class GetRemoteIP {
	/**
	 * 获取请求用户的ip地址
	 * @param request
	 * @return
	 */
	public static String getRequestUserIpAddr(HttpServletRequest request) {  
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }
      //这里主要是获取本机的ip,可有可无  
        if (ip.equals("127.0.0.1")  
                || ip.endsWith("0:0:0:0:0:0:1")) {  
            // 根据网卡取本机配置的IP  
            InetAddress inet = null;  
            try {  
                inet = InetAddress.getLocalHost();  
            } catch (UnknownHostException e) {  
                e.printStackTrace();  
            }  
            ip = inet.getHostAddress();  
        }  
        return ip;  
    }  
	  /**
     * 模糊IP地址，安全起见不暴露访者的地址xx.*.*.xx;
     * @param ip
     * @return
     */
    public static final String vague(HttpServletRequest request) {
    	String ip=null;
    	String ipaddr="*.*.*.*";
		try {
			ip = getRequestUserIpAddr(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(StringUtils.hasText(ip)) {
    		String[] vip=ip.split("\\.");
    		ipaddr=vip[0]+".*.*."+vip[3];
    	}
    	return ipaddr;
    }
	/**
	 * 地址判断，是否是内网地址
	 * return true 是；return flase 否
	 * @param ip ipv4
	 * @return
	 */
	public static boolean validateRequestIpAddr(String ip) {
	    byte[] addr = IPAddressUtil.textToNumericFormatV4(ip);
	    return internalIp(addr);
	}
	/**
	 * 判断该地址是否是内网地址
	 * @param addr
	 * @return
	 */
	public static boolean internalIp(byte[] addr) {
	    final byte b0 = addr[0];
	    final byte b1 = addr[1];
	    //10.x.x.x/8
	    final byte SECTION_1 = 0x0A;
	    //172.16.x.x/12
	    final byte SECTION_2 = (byte) 0xAC;
	    final byte SECTION_3 = (byte) 0x10;
	    final byte SECTION_4 = (byte) 0x1F;
	    //192.168.x.x/16
	    final byte SECTION_5 = (byte) 0xC0;
	    final byte SECTION_6 = (byte) 0xA8;
	    switch (b0) {
	        case SECTION_1:
	            return true;
	        case SECTION_2:
	            if (b1 >= SECTION_3 && b1 <= SECTION_4) {
	                return true;
	            }
	        case SECTION_5:
	            switch (b1) {
	                case SECTION_6:
	                    return true;
	            }
	        default:
	            return false;
	    }
	}
	/**
	 * 获取请求域名
	 * @param request
	 * @return
	 */
	public static String getRequestDomain(HttpServletRequest request){
//		return request.getHeader("Referer");
		return request.getServerName();
	}
	/**
	 * 域名解析，将域名解析为IP地址
	 * @param domainName
	 * @return
	 */
	public static String getRequestServerIpAddr(String domainName) {
		try {
			return InetAddress.getByName(domainName).getHostAddress();
		} catch (UnknownHostException e) {
			return null;
		}
	}
	/**
	 * 判断是否是公网地址
	 * return true 内网
	 * return false 公网
	 * @param request
	 * @return
	 */
	public static boolean isInternalIPAddr(HttpServletRequest request){
		String requestHostAddr=getRequestServerIpAddr(getRequestDomain(request));
		String validateAddr=null;
		if(StringUtils.hasText(requestHostAddr)){
			validateAddr=requestHostAddr;
		}else{//如果请求域名无法解析，使用请求用户地址来判断是否内外网
			validateAddr=getRequestUserIpAddr(request);
		}
		
		return validateRequestIpAddr(validateAddr);
	}
}
