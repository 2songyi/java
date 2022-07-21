package com.varxyz.jvx330.intro;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		
		String config = "com/varxyz/jvx330/intro/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config); // 스프링 컨테이너
		Hello hello = context.getBean("helloBean", Hello.class); // 캐스팅대신 Hello타입으로 받겠다
		
//		Hello h = new HelloBeanEn();
		System.out.println(hello.sayHello("Spring"));
		context.close(); // close하기전까지는 getBean을 여러개 계속 쓸 수 있음
		
		// 객체를 가져왔지만 new해서 가져온건 없음
		
	}

}
