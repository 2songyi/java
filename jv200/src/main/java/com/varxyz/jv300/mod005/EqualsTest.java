package com.varxyz.jv300.mod005;

/**
 * 이 회사의 사원은 이름과 생일이 같다면 같은 시원으로 인식되도록
 * equals() 메소드를 재정의 하시오
 * @author LeeSongYi
 *
 */
public class EqualsTest {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("유비");
		e.setSalary(1000.0);
		e.setBirthDate(new MyDate(10, 4, 2000));
		
		Employee e2 = new Employee();
		e2.setName("유비");
		e2.setSalary(1000.0);
		e2.setBirthDate(new MyDate(10, 4, 2000));
		
		System.out.println(e == e2); //false
		// == 사용 시 메모리의 주소값을 비교하기때문에 false가 출력된다.
		System.out.println(e.equals(e2)); //false -> true
	}
}

//string, date 비교
// string의 경우 이미 override된 상탱

// mydate, string, employee