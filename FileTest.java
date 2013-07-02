package com.filetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class FileTest {

	//
	public static void print(File f) {
		if (f != null) {
			if (f.isDirectory()) {
				File[] fileArray = f.listFiles();
				if (fileArray != null) {
					for (File file : fileArray) {
						print(file);
					}
				}
			} else {
				System.out.println(f.getAbsolutePath());
			}
		}
	}

	//
	public static void writeToFile() {
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		RandomAccessFile demo;
		try {
			demo = new RandomAccessFile(f, "rw");
			demo.writeBytes("asdsad");
			demo.writeInt(12);
			demo.writeBoolean(true);
			demo.writeChar('A');
			demo.writeFloat(1.21f);
			demo.writeDouble(12.123);
			demo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static void writingString() {
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		try {
			OutputStream out = new FileOutputStream(f);
			String str = "你好";
			byte[] b = str.getBytes();
			out.write(b);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static void nextLine() {
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		try {
			OutputStream out = new FileOutputStream(f, true);
			String str = "Rollen";
			// String str="\r\nRollen";
			byte[] b = str.getBytes();
			out.write(b);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static void readFile() {
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		InputStream in;
		try {
			in = new FileInputStream(f);
			byte[] b = new byte[1024];
			in.read(b);
			in.close();
			System.out.println(new String(b));// length 1016
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static void getContent() {
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		InputStream in;
		try {
			in = new FileInputStream(f);
			byte[] b = new byte[1024];
			int len = in.read(b);
			in.close();
			System.out.println("读入长度为："+len);
	        System.out.println(new String(b,0,len));//length 16
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//
	public static void getContentRight(){
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		InputStream in;
		try {
			in = new FileInputStream(f);
			byte[] b = new byte[(int) f.length()];
			in.read(b);
			in.close();
			System.out.println("读入长度为："+f.length());
	        System.out.println(new String(b));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//
	public static void getContentToEnd(){
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		InputStream in;
		try {
			in = new FileInputStream(f);
			byte[] b = new byte[1024];
			int count = 0;
			int temp = 0;
			while ((temp = in.read())!=(-1)) {
				b[count++] = (byte) temp;
			}
			in.close();
	        System.out.println(new String(b));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		/*
		 * File f = new File(File.separator + "home" + File.separator +
		 * "silicon" + File.separator + "AndroidBook"); print(f);
		 */
		// writingString();
		// nextLine();
		//readFile();
		//getContentRight();
		//getContentToEnd();
	}
}
