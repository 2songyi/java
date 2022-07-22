package com.varxyz.jvx330.lifecycle.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import com.varxyz.jvx330.lifecycle.AppConfig;

public class Goat {
	private static int count;
	
	//goat의 빈을 여러개 만든다. count가 1이면된다. -> singleTon
	
	public Goat() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	
	public static void main(String[] args) {

		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);
		System.out.println("Goat count : " + Goat.getCount());
		// goat를 여러번 생성해도 count는 1이다.
		context.close();
	}
	
}
