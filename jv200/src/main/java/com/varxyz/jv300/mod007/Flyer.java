package com.varxyz.jv300.mod007;

/**
 * -. abstract메소드의 집합. 상수(public)
 * -. 인스턴스 생성 불가
 * -. 다중 상속 지원 
 * @author Administrator
 *
 */
public interface Flyer {
	public void fly(); //인터페이스에는 abstract키워드 생략, public생략(default아님)
	public void takeOff();
	public void land();
	

}
