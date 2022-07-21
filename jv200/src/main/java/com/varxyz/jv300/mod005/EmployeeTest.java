package com.varxyz.jv300.mod005;

//import java.util.Date; //date사용하기 위해 import

public class EmployeeTest {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "길동"; //name private이라서 에러
		e.salary = 200;
//		e.birthDate = new Date(); 
		//ref type은 new해줘야한다.
		String detail = e.getDetails();
		System.out.println(detail);
		System.out.println(e.birthDate);
		
		Manager m = new Manager();
		m.department = "영업부"; //오버라이딩 되어서 결과 나옴
		m.name = "철수";
		m.salary = 300;
		System.out.println(m.getDetails());
	}

}
