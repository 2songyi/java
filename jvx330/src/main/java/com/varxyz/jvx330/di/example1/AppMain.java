package com.varxyz.jvx330.di.example1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		
		String config = "com/varxyz/jvx330/di/example1/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);

//		Bar bar = new Bar(); 기존방식
//		Foo foo = new Foo(bar);
		
		Foo foo = context.getBean("foo", Foo.class);
//		Foo foo = (Foo) context.getBean("foo");
		System.out.println(foo);
		
		Foo foo2 = context.getBean("foo2", Foo.class);
		System.out.println(foo2); 
		// bean이 하나만 등록되어있는 경우 해시코드값이 같음. 동일객체. 객체를 재사용중(bean쓰는거 만으로도 싱글톤)
		// bean 두개등록시 두개의 값이 나옴. 
		//컨테이너가 객체 생성중. 
		
		context.close();
		

		
		
	}

}
