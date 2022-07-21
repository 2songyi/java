package com.varxyz.jv300.lib;

public class Library {
	private static Library lib = new Library();
	
	private Library() {
		// 도서관을 한번만 생성할 수 있게 생성자에 private걸기
	}
	
	public static Library getLibrary() {
		return lib;
	}
	
	private static int listLeng = 100; //저장소내 책의 최대 개수
	private static String[][] bookList = new String[listLeng][2];
	private static int bookIndex = 0;
	private String giveBook = "";
	
	
	public void addBook(Book book) {
		if (bookIndex >= listLeng) {
			listLeng *= 2;
			String[][] copy = bookList;
			bookList = new String[listLeng][2];
			System.arraycopy(copy, 0, bookList, 0, copy.length);
		}
		bookList[bookIndex][0] = book.getBookName();
		bookList[bookIndex][1] = book.getSerial();
		bookIndex++;
	}
	
	public String getBook(int serial) {
		for(int i = 0; i < bookList.length; i++) { //저장된 책의 인덱스 개수만큼 검사
			if (Integer.toString(serial).equals(bookList[i][1])) { 
				giveBook = bookList[i][0];
			}
		}
		return giveBook; 
	}
	
}
