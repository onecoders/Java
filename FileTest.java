package com.filetest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

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
			System.out.println("读入长度为：" + len);
			System.out.println(new String(b, 0, len));// length 16
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static void getContentRight() {
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		InputStream in;
		try {
			in = new FileInputStream(f);
			byte[] b = new byte[(int) f.length()];
			in.read(b);
			in.close();
			System.out.println("读入长度为：" + f.length());
			System.out.println(new String(b));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static void getContentToEnd() {
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		InputStream in;
		try {
			in = new FileInputStream(f);
			byte[] b = new byte[1024];
			int count = 0;
			int temp = 0;
			while ((temp = in.read()) != (-1)) {
				b[count++] = (byte) temp;
			}
			in.close();
			System.out.println(new String(b));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static void writer() {
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		try {
			Writer out = new FileWriter(f, true); // true or none
			String str = "\r\nhello";
			out.write(str);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static void reader() {
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		char[] ch = new char[100];
		try {
			Reader read = new FileReader(f);
			int count = read.read(ch);
			read.close();
			System.out.println("读入的长度为：" + count);
			System.out.println("内容为：" + new String(ch, 0, count));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static void readers() {
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		char[] ch = new char[100];
		try {
			Reader read = new FileReader(f);
			int temp = 0;
			int count = 0;
			while ((temp = read.read()) != (-1)) {
				ch[count++] = (char) temp;
			}
			read.close();
			System.out.println("内容为：" + new String(ch, 0, count));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static void copy() {
		File file1 = new File(File.separator + "home" + File.separator
				+ "silicon" + File.separator + "hello.txt");
		File file2 = new File(File.separator + "home" + File.separator
				+ "silicon" + File.separator + "hellocopy.txt");
		if (!file1.exists()) {
			System.exit(1);
		}
		try {
			InputStream input = new FileInputStream(file1);
			OutputStream output = new FileOutputStream(file2);
			if ((input != null) && (output != null)) {
				int temp = 0;
				while ((temp = input.read()) != (-1)) {
					output.write(temp);
				}
			}
			input.close();
			output.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static void writerConvert() {
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		try {
			Writer out = new OutputStreamWriter(new FileOutputStream(f));
			out.write("hello world");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public static void readerConvert() {
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		try {
			Reader read = new InputStreamReader(new FileInputStream(f));
			char[] b = new char[100];
			int len = read.read(b);
			System.out.println(new String(b, 0, len));
			read.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	private static void upercaseToLowercase() {
		String str = "ROLLENHOLT";
		ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int temp = 0;
		while ((temp = input.read()) != (-1)) {
			char ch = (char) temp;
			output.write(Character.toLowerCase(ch));
		}
		String outStr = output.toString();
		try {
			output.close();
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(outStr);
	}

	//
	private static void printStreamTest() {
		try {
			PrintStream print = new PrintStream(new File(File.separator
					+ "home" + File.separator + "silicon" + File.separator
					+ "hello.txt"));
			print.println(true);//write to file 2
			print.println("Rollen");
			print.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//
	private static void printStreamTest2(){
		try {
			PrintStream print = new PrintStream(new FileOutputStream(new File(File.separator
						+ "home" + File.separator + "silicon" + File.separator
						+ "hello.txt")));
			String name = "Rollen";
			int age = 20;
			print.printf("姓名：%s. 年龄：%d.", name,age);
			print.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//
	private static void printScreen(){
		OutputStream out = System.out;
		try {
			out.write("hello".getBytes());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//
	private static void forwardToFile(){
		System.out.println("hello baby 2");
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		try {
			System.setOut(new PrintStream(new FileOutputStream(f)));//
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("those content can be seen in the file");//write 2 file
	}
	
	//
	private static void forwardError2File(){
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		System.err.println("show in console");
		try {
			System.setErr(new PrintStream(new FileOutputStream(f)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("those can be seen in the file");
	}
	
	//
	private static void systemIn(){
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		if (!f.exists()) {
			return;
		} else {
			try {
				System.setIn(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] bytes = new byte[1024];
			int len = 0;
			try {
				len = System.in.read(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("the file content is :" + new String(bytes, 0, len));
		}
	}
	
	//
	private static void bufferedReaderDemo(){
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.println("please enter the content");
		try {
			str = buf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("what you typed is:" + str);
	}
	
	//
	private static void scannerDemo(){
		File f = new File(File.separator + "home" + File.separator + "silicon"
				+ File.separator + "hello.txt");
		Scanner sca = null;
		try {
			sca = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = sca.next();
		System.out.println("the content retrieved is " + str);
	}

	public static void main(String[] args) {
		/*
		 * File f = new File(File.separator + "home" + File.separator +
		 * "silicon" + File.separator + "AndroidBook"); print(f);
		 */
		// writingString();
		// nextLine();
		// readFile();
		// getContentRight();
		// getContentToEnd();
		//upercaseToLowercase();
		//printStreamTest();
		//printStreamTest2();
		//printScreen();
		//forwardToFile();
		//forwardError2File();
		//systemIn();
		//bufferedReaderDemo();
		scannerDemo();
	}
}
