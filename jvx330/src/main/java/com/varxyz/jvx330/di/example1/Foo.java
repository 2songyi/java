package com.varxyz.jvx330.di.example1;

public class Foo {
	private Bar bar;
	
	public Foo() {
		System.out.println("Foo() constructor is called.");
		//setter를 쓸때는 기본생성자를 만들어둬야함
	}
	
	// Foo는 Bar를 필요로 하는 의존관계 성립
	public Foo(Bar bar) {
		this.bar = bar;
		System.out.println("Foo(bar) constructor is called.");
	}
	
	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("setBar() is called.");
	}
	
	public String toString() {
		return "[Foo : " + hashCode() + "]";
	}
	
}
