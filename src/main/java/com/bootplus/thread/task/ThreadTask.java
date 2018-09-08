package com.bootplus.thread.task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import com.bootplus.Util.HttpUtil;

public class ThreadTask extends Thread {
	private int num=0;
	private boolean stat=true;//运行状态
	private String newViewCount=null;
	public ThreadTask(String name) {
		super(name);
	}
	public ThreadTask() {
		super();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(stat){
			String r=HttpUtil.get("https://blog.csdn.net/kimheesunliulu/article/details/81909162");
			if(StringUtils.hasText(r)) {
				Document document = Jsoup.parse(r, "UTF-8");
				Elements elements = document.getElementsByClass("read-count");
				String[] s=elements.html().split("：");
				if(s.length>1) {
					newViewCount=s[1];
					System.out.println(newViewCount);
				}
			}
		    try {
				this.sleep(300001);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			} 
			num++;
		}
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public boolean isStat() {
		return stat;
	}
	public void setStat(boolean stat) {
		this.stat = stat;
	}
	public String getNewViewCount() {
		return newViewCount;
	}
	public void setNewViewCount(String newViewCount) {
		this.newViewCount = newViewCount;
	}

}
