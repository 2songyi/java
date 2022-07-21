package com.varxyz.jv300.mod010;

import java.io.File;

public class FileTest {
	private static final String SAVE_DIR = "C:\\temp"; // /==\\
	
	public static void main(String[] args) {
		
		File saveDir = new File(SAVE_DIR);
		System.out.println(saveDir.getPath());
		System.out.println("Window : " + File.separator); // platform independent하게 해줌 \,/통일
		
	}
}
