package com.hibernate.view.controller;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

public class Sechdule {

	public static void main(String[] args) throws InterruptedException {
		int i = 0; 
		while(true){
			if(i>500) { 
				break; 
			}
			String r=get();
			if(StringUtils.hasText(r)) {
				Document document = Jsoup.parse(r, "UTF-8");
				Elements elements = document.getElementsByClass("read-count");
				String[] s=elements.html().split("：");
				if(s.length>1) {
					r=s[1];
				}
			}
		    Thread.sleep(300001); 
			i++; 
		}
	}

	public static String get() {
		String re=null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try { // 创建httpget.
			HttpGet httpget = new HttpGet("https://blog.csdn.net/kimheesunliulu/article/details/81909162");
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				// 打印响应状态
//				System.out.println(response.getStatusLine()); 
				if (entity != null) {
					// 打印响应内容长度
					// System.out.println("Response content length: " + entity.getContentLength());
					// 打印响应内容
					re=EntityUtils.toString(entity);
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return re;
	}
}
