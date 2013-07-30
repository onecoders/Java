package com.filetest;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileSort {

	static class SortFileName implements Comparator<File> {

		@Override
		public int compare(File f1, File f2) {
			return f1.getName().compareTo(f2.getName());
		}
	}

	static class SortFolder implements Comparator<File> {

		@Override
		public int compare(File f1, File f2) {
			if ((f1.isDirectory() && f2.isDirectory())
					|| (!f1.isDirectory() && !f2.isDirectory()))
				return 0;
			else if (f1.isDirectory() && !f2.isDirectory())
				return -1;
			else
				return 1;
		}
	}

	public static void main(String[] args) {
		File dir = new File("/home/silicon");
		File[] directoryList = dir.listFiles();
		if (directoryList != null) {
			Arrays.sort(directoryList, new SortFileName());
			Arrays.sort(directoryList, new SortFolder());
		}
		for (File file : directoryList) {
			System.out.println(file.getName());
		}
	}

}
