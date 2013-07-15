package com.stream;

import java.io.File;

public class FileCopyTest {
	
	static String copyFromStr = "/home/silicon/hello.txt";
	static String toStr1 = "/home/silicon/copyTo/To1/hello";
	static String toStr2 = "/home/silicon/copyTo/To2/hello";

	public static void main(String[] args) {
		File from = new File(copyFromStr);
		File to;
		long currentTime1 = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			String copyToStr1 = (toStr1 + i + ".txt");
			to = new File(copyToStr1);
			try {
				StreamTest.copy(from, to);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long currentTime2 = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			String copyToStr2 = (toStr2 + i + ".txt");
			to = new File(copyToStr2);
			try {
				StreamTest.copy2(from, to);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long currentTime3 = System.currentTimeMillis();
		System.out.println(currentTime2 - currentTime1);//16
		System.out.println(currentTime3 - currentTime2);//25
	}

}
