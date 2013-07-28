package com.compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compress {

	private static final int BUFFER = 2048;

	private String[] _files;
	private String _zipFile;

	public Compress(String[] files, String zipFile) {
		_files = files;
		_zipFile = zipFile;
	}

	public void zip() {
		BufferedInputStream origin = null;
		FileOutputStream dest = null;
		ZipOutputStream out = null;
		try {
			dest = new FileOutputStream(_zipFile);
			out = new ZipOutputStream(new BufferedOutputStream(dest));
			byte[] data = new byte[BUFFER];
			for (int i = 0; i < _files.length; i++) {
				FileInputStream fi = new FileInputStream(_files[i]);
				origin = new BufferedInputStream(fi, BUFFER);
				ZipEntry entry = new ZipEntry(_files[i].substring(_files[i]
						.lastIndexOf("/") + 1));
				out.putNextEntry(entry);
				int count;
				while ((count = origin.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (origin != null) {
				try {
					origin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] files = new String[]{"D:/TCPClient.java", "D:/TCPServer.java"};
		String dest = "D:/TCP.zip";
		new Compress(files, dest).zip();
 	}

}
