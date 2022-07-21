package com.varxyz.jv300.mod010;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int totalBytes = 0;
		try {
			try {
				fis = new FileInputStream("test.txt"); // 상대주소
				fos = new FileOutputStream("test_copy.txt"); // 카피파일
				for (int readByte; (readByte = fis.read()) != -1;) {
//					System.out.write(readByte);
					fos.write(readByte);
					totalBytes++; //총 읽어낸 수
				}
			} finally {
				fos.close();
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n전체 바이트 수 : " + totalBytes + "bytes.");
	}

}
