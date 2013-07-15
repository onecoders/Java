package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest {

	private static String PATH = "D:" + File.separator + "test.pdf";

	private static void save(String str) {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(new File(PATH)));
			bos.write(str.getBytes());
		} catch (Exception e) {
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

	private static void load() {
		BufferedInputStream bis = null;
		byte[] buffer = new byte[1024];
		try {
			bis = new BufferedInputStream(
					new FileInputStream(new File(PATH)));
			int byteRead = 0;
			while ((byteRead = bis.read(buffer)) != -1) {
				String str = new String(buffer, 0, byteRead);
				System.out.println(str + byteRead);
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
	}

	public static void main(String[] args) {
		String str = "this is a test!";
		save(str);
		load();
	}

}
