package com.filetest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest {

	private static void save(String str, String path) {
		BufferedOutputStream bos = null;
		File to = new File(path);
		try {
			if (!to.exists()) {
				to.createNewFile();
			}
			bos = new BufferedOutputStream(new FileOutputStream(to));
			bos.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static String load(String path) {
		BufferedInputStream bis = null;
		File from = new File(path);
		if (!from.exists()) {
			return null;
		}
		try {
			bis = new BufferedInputStream(new FileInputStream(from));
			byte[] buffer = new byte[bis.available()];
			int byteRead = 0;
			while ((byteRead = bis.read(buffer)) != -1) {
				String str = new String(buffer, 0, byteRead);
				return str;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	private static void copy(String from, String to){
		save(load(from), to);
	}

	public static void main(String[] args) {
		String to = File.separator + "home" + File.separator
				+ "silicon" + File.separator + "file.test";
		String from = File.separator + "home" + File.separator
				+ "silicon" + File.separator + "hello.txt";
		copy(from, to);
	}

}
