package com.varxyz.jvx330.di.example2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
	private String name;	
	private Dept dept; //부서
	private double salary;
	private Date regDate;
	
	public Employee(String name, Dept dept, double salary, Date regDate) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.regDate = regDate;
	}
	
	public String getDetails() {
		return "Name : " + name + "\nDept : " + dept.getDeptName() + "\nSalary " + salary
				+ "\nRegDate : " + regDate;
	}
	
	
}
