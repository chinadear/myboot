package com.bootplus.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.huaban.analysis.jieba.JiebaSegmenter;

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
		String words = "中国;是;世.界。四——大【】文明！古国   @之一，有  着{悠久的}历、史,history sprngboot";
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
        System.out.println(r.get(1).length());
	}
	
	public static boolean q(String a) {
		return Pattern.matches("(0\\.\\d)|(0\\.[0-9][1-9])", a);
	}

}
