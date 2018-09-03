package com.bootplus.Util;

import java.io.IOException;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ImageProcessingComp img=new ImageProcessingComp("D:\\log\\1.png", "D:\\log\\1-2.png");
//		img.compressByQality("0.5");
//		img.compressByHeight(0);
		img.compressByWidth(60);
//		System.out.println(q("0.99"));
	}
	
	public static boolean q(String a) {
		return Pattern.matches("(0\\.\\d)|(0\\.[0-9][1-9])", a);
	}

}
