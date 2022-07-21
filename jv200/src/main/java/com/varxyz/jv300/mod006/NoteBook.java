package com.varxyz.jv300.mod006;

public class NoteBook extends Product {
	
	// 생성자
	public NoteBook(String name) {
		super(name);
	}
	
	// 오버라이딩
	public double getPrice() {
		return 25000.0;
	}
}
