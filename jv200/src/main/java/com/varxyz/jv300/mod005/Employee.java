package com.varxyz.jv300.mod005;

//import java.util.Date;
//외부의 데이터를 끌어와서 사용할 때 import (date는 jdk깔면서 따라온거)

public class Employee {
	protected String name; //private String name;
	protected double salary;
	public MyDate birthDate;
	
	public String getDetails() {
		return "Name:" + name + "\nSalary:" + salary;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}
	
	// equals 오버라이딩
	//대상 name과 mydate인데 mydate는 만들었고 name은 string클래스에서 이미 만들어짐 그래서 같은지만 확인
	
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			Employee e = (Employee)obj;
			if (e.getName().equals(name) && e.getBirthDate().equals(birthDate)) {
				return true;				
			}
		}
		return false;
	}
}
