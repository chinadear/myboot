package com.bootplus.Util;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.mysql.fabric.xmlrpc.base.Array;

public class Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//		ImageProcessingComp img=new ImageProcessingComp("D:\\log\\1.png", "D:\\log\\1-2.png");
//		img.compressByQality("0.5");
//		img.compressByHeight(0);
//		img.compressByWidth(60);
//		System.out.println(q("0.99"));
		/*ThreadTaskManager.start();
		Thread.sleep(5000);
		ThreadTaskManager.stop();
		Thread.sleep(5000);
		ThreadTaskManager.interrupt();*/
		                     //水印字体
       /* String srcImgPath="E:\\桌面\\opensrc\\17springboot\\图片素材\\0-1躲坑1000x179mh.png"; //源图片地址
        String tarImgPath="E:\\ttt.png"; //待存储的地址
        String waterMarkContent="https://www.bootplus.com.cn";  //水印内容
                                      //水印图片色彩以及透明度
        ImageProcessingComp.addWaterMark(srcImgPath, tarImgPath, waterMarkContent);*/
		/*String words = "中国;是;世.界。四——大【】文明！古国   @之一，有  着{悠久的}历、史,history sprngboot";
		words=words.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……;*（）——+|{}【】‘；：”“’。，、？|-]", "");
		System.out.println(words);
		JiebaSegmenter segmenter = new JiebaSegmenter();
		List<String> list=segmenter.sentenceProcess(words);
		List<String> r=new ArrayList<String>();
		for(String s:list) {
			if(s.trim().length()>=2) {
				r.add(s);
				System.out.println(s+":"+s.trim().length());
			}
		}
        System.out.println(r.get(1).length());*/
		List<PieData> list=new ArrayList<PieData>();
		List<String> list2=new ArrayList<String>();
		List<Integer> list3=new ArrayList<Integer>();
		for(int i=0;i<6;i++) {
			PieData m1=new PieData();
			m1.setName("name_"+i);
			m1.setValue(i);
			list.add(m1);
		}
		for(int i=0;i<6;i++) {
			list2.add("name_"+i);
		}
		for(int i=0;i<6;i++) {
			list3.add(i);
		}
		StringBuffer sb=new StringBuffer();
		sb.append(CompUtil.array2Json(list)).append(";").append(CompUtil.array2Json(list2)).append(";").append(CompUtil.array2Json(list3));
		System.out.println(sb.toString());
		String[] s=sb.toString().split(";");
		for(String ss:s) {
			System.out.println(ss);
		}
		
	}
	
	public static boolean q(String a) {
		return Pattern.matches("(0\\.\\d)|(0\\.[0-9][1-9])", a);
	}

}

class PieData{
	private int value;
	private String name;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
