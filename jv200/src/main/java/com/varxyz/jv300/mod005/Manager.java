package com.varxyz.jv300.mod005;

public class Manager extends Employee {
	protected String department;
	
	// 오버라이딩
	public String getDetails() {
		return super.getDetails() + "\ndepartment:" + department;
	}

}
