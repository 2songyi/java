package com.varxyz.jvx330.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.varxyz.jvx330.lifecycle.example1.Dog;
import com.varxyz.jvx330.lifecycle.example2.Eagle;
import com.varxyz.jvx330.lifecycle.example3.Goat;
import com.varxyz.jvx330.lifecycle.example4.Horse;

@Configuration //설정정보를 담았다.
public class AppConfig {
	/**
	 * <bean name="dog" class="com.varxyz.jvx330.lifecycle.example1.Dog">
	 * <constructor-arg index=0 type="java.lang.String" value="플루토"/>
	 * <property name="name" value="볼트"/>
	 * </bean>
	 * @return
	 */
	// 인터페이스를 오버라이딩해서 init, destroy작업
	@Bean
	public Dog dog() {
		Dog d = new Dog("플루토");
		d.setName("볼트");
		return d;
	}
	
	// 인터페이스 사용하지 않고.
	@Bean(initMethod = "attachWings", destroyMethod = "detachWings")
	public Eagle eagle() {
		Eagle e = new Eagle();
		e.setName("에디");
		return e;
	}
	
	// afterPropertieSet이 호출 된 뒤 initMethod가 호출됨.
	
	@Bean
	@Scope("singleton")
	public Goat goat() {
		return new Goat();
	}
	
	@Bean
	@Scope("prototype")
	public Horse horse() {
		return new Horse();
	}
	
	

}
