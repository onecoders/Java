package com.filetest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWrite {

	static final byte[] BYTE = "China Dream!中国梦!\n".getBytes();

	private static String pathFormat(int i) {
		return File.separator + "home" + File.separator + "silicon" + "/path"
				+ i + ".data";
	}

	private static void write1(String path, byte[] buff) {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(path));
			bos.write(buff);
			bos.write(buff);
			bos.write(buff);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void write2(String path, byte[] buff) {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(path));
			bos.write(buff);
			bos.close();
			bos = new BufferedOutputStream(new FileOutputStream(path));
			bos.write(buff);
			bos.close();
			bos = new BufferedOutputStream(new FileOutputStream(path));
			bos.write(buff);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void write3(String path, byte[] buff) {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(path));
			bos.write(buff, 0, buff.length);
			bos.write(buff, 0, 10);
			bos.write(buff);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void write4(String path) {
		byte[] buff = "不管你信不信，反正我信了!".getBytes();
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(path));
			bos.write(buff, 0, buff.length);
			bos.write(buff);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		write1(pathFormat(1), BYTE);
		write2(pathFormat(2), BYTE);
		write3(pathFormat(3), BYTE);
		write4(pathFormat(4));
		System.out.println("s".getBytes().length);// 1
		System.out.println("如".getBytes().length);// 3
		System.out.println("！".getBytes().length);// 3 Zh ！
		System.out.println("!".getBytes().length);// 1 En !
	}

}
