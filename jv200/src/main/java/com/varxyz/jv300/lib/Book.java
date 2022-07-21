package com.varxyz.jv300.lib;

public class Book {
	private int serial;
	private String bookName;
	
	public Book(String bookName, int serial) {
		this.bookName = bookName;
		this.serial = serial;
	}
	
	public String getSerial() {
		return Integer.toString(serial);
	}
	
	public String getBookName() {
		return bookName;
	}
	
	
	
	
}
