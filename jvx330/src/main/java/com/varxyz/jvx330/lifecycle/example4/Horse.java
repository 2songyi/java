package com.varxyz.jvx330.lifecycle.example4;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;

public class Horse implements InitializingBean, DisposableBean {
	private static int count;
	
	public Horse() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	@PostConstruct // 객체가 만들어진 후에 호출하게 됨(class안에서 초기화끝낼 수 있음)
	public void initMethodData() {
		
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("horse destroy 호출");
		// singleTon은 destroy를 호출하지만 prototype은 destroy를 호출하지 않는다.
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("horse afterPropertiesSet 호출" + count);
	}
	
	public static void main(String[] args) {
		
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		System.out.println("Horse count : " + Horse.getCount());
		context.close();
	}
}
