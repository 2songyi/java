package com.varxyz.jvx330.di.example3;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class AppMain {

	public static void main(String[] args) {
//		String config = "com/varxyz/jvx330/di/example3/beans.xml";
//		GenericApplicationContext context = new GenericXmlApplicationContext(config);

		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService ms = context.getBean("memberService", MemberService.class);
		ms.getAllMember().forEach(member -> System.out.println(member)); //람다식
		/* 
		List<Member> list = ms.getAllMember();
		for (Member member : list) {
			System.out.println(member);
		} 
		*/
		
		context.close();

	}

}
