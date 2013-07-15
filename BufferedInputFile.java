package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {

	private static String PATH = "D:" + File.separator + "test.note";

	private static String read(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = br.readLine()) != null)
			sb.append(s + "\n");
		br.close();
		return sb.toString();
	}

	public static void main(String[] args) {

		try {
			System.out.print(read(PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
