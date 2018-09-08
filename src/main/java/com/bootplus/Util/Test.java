package com.bootplus.Util;

import java.io.IOException;
import java.util.regex.Pattern;

import com.bootplus.thread.task.ThreadTaskManager;

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
		ThreadTaskManager.start();
		ThreadTaskManager.start("a1");
		ThreadTaskManager.start("a2");
		Thread.sleep(5000);
		System.out.println("tid"+ThreadTaskManager.isRunning());
		System.out.println("a1"+ThreadTaskManager.isRunning("a1"));
		System.out.println("a2"+ThreadTaskManager.isRunning("a2"));
		System.out.println("tid is stopped");
		ThreadTaskManager.stop();
		Thread.sleep(5000);
		System.out.println("tid"+ThreadTaskManager.isRunning());
		System.out.println("a1"+ThreadTaskManager.isRunning("a1"));
		System.out.println("a2"+ThreadTaskManager.isRunning("a2"));
		System.out.println("a2 is stopped");
		ThreadTaskManager.stop("a2");
		Thread.sleep(5000);
		System.out.println("tid"+ThreadTaskManager.isRunning());
		System.out.println("a1"+ThreadTaskManager.isRunning("a1"));
		System.out.println("a2"+ThreadTaskManager.isRunning("a2"));
		System.out.println("a1 is stopped");
		ThreadTaskManager.stop("a1");
		Thread.sleep(2000);
		System.out.println("tid"+ThreadTaskManager.isRunning());
		System.out.println("a1"+ThreadTaskManager.isRunning("a1"));
		System.out.println("a2"+ThreadTaskManager.isRunning("a2"));
		Thread.sleep(5000);
		System.out.println("===============================");
		System.out.println("tid"+ThreadTaskManager.isRunning());
		System.out.println("a1"+ThreadTaskManager.isRunning("a1"));
		System.out.println("a2"+ThreadTaskManager.isRunning("a2"));
	}
	
	public static boolean q(String a) {
		return Pattern.matches("(0\\.\\d)|(0\\.[0-9][1-9])", a);
	}

}
