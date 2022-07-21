package com.varxyz.jvx330.di.example4.ex2;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.varxyz.jvx330.di.example4.ex1.ByNameClient;

public class ByTypeClient {
	private NamingService service;
	
	//이런 경우는 JMS인지 DMS인지 이름으로는 알수없음. 클래스타입으로 구분
	//jms, dns는 namingService타입임. xml에서 namingservice타입인걸 연결하는데 jms, dns둘다 저 타입이라 하나만 남겨둬야 에러안남
	// byname보다 type을 많이 씀. 이렇게 타입이 두개이상이면 타입지정가능
	public NamingService getNamingService() {
		return service;
	}
	
	public void setNamingService(NamingService service) {
		this.service = service;
	}
	
	public void service(String name) {
		Object o = service.lookup(name);
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example4/ex2/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		ByTypeClient client = context.getBean("byTypeClient", ByTypeClient.class);
		client.service("myQueue");
		context.close();
	}
}
