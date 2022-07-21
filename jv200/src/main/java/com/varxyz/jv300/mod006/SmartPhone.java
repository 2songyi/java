package com.varxyz.jv300.mod006;

public class SmartPhone extends Product {
	private boolean apple = false;
	
	//생성자
	public SmartPhone(String name) {
		super(name);
		if (getName().startsWith("Apple")) {
			apple = true;
		}
	}
	
	//오버라이딩
	public double getPrice() {
		if(apple) {
			return 1500.0;
		} else {
			return 1000.0;			
		}
	}
	
	// 부모클래스에 없는 메서드
	public String getPlatform() {
		if (apple) {
			return "Apple";
		} else {
			return "Android";
		}
	}
}
