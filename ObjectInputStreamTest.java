package com.filetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputStreamTest {

	private static Object read(File from) {
		ObjectInputStream ois = null;
		Object result = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(from));
			result = ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static void write(File to, Object obj) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(to));
			oos.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		String path = File.separator + "home" + File.separator + "silicon"
				+ File.separator + "my.data";
		List<String> strList = new ArrayList<String>();
		strList.add("silicon");
		strList.add("is");
		strList.add("me");
		File to = new File(path);
		write(to, strList);
		File from = new File(path);
		List<String> list = (List<String>) read(from);
		for (String string : list) {
			System.out.println(string);
		}
	}

}
