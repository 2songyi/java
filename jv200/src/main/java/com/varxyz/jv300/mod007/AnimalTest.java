package com.varxyz.jv300.mod007;

public class AnimalTest {

	public static void main(String[] args) {
		Animal animal = new Dog(); //추상클래스는 객체를 만들 수 없다.
		animal.makeSound(); //오바라이딩한 자식 객체가 출력
		
	}

}
