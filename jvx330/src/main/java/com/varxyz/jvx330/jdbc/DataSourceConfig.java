package com.varxyz.jvx330.jdbc;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.jvx330.jdbc.example1.AddCustomerDao;
import com.varxyz.jvx330.jdbc.example1.AddCustomerDataSourceDao;
import com.varxyz.jvx330.jdbc.example1.CustomerDao;

@Configuration
public class DataSourceConfig {
	// 공통적인거는 이 config에 두고 개별적으로 필요한건 개별로 만들어서 사용
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul");
		ds.setUsername("jv250");
		ds.setPassword("jv250");
		ds.setInitialSize(2); 	// 커넥션 풀 초기화시 생성할 초기 커넥션 개수(default = 10)
		ds.setMaxActive(10);  	// 풀에서 가져올 수 있는 최대 커넥션 개수(default = 100)
		ds.setMaxIdle(10); 		// 풀에 유지할 수 있는 최대 커넥션 수(default = maxActive)
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() { //스프링에서 제공하는 jdbc 템플릿
		return new JdbcTemplate(dataSource()); // 계속 호출해도 싱글톤이라 동일한 템플릿 사용하게됨
	}
	
	@Bean
	public AddCustomerDataSourceDao addCustomerDataSourceDao() {
		return new AddCustomerDataSourceDao(dataSource());
	}
	// 의존관계가 필요할 때 bean으로 선언된 dataSource를 호출함으로써 의존성을 주입할 수 있다.
	// component대신 bean을 사용하면 객체를 반환하는 메소드 작성한 후 bean어노테이션을 부여하면 된다.
	// annotaion을 기반으로 bean을 등록하면 annotaionConfigApplicationContext객체 생성하고
	// 매개변수로 configuration 어노테이션 부여한 클래스를 넘겨주고 getBean을 쓰면 된다.
	
	@Bean
	public AddCustomerDao addCustomerDao() {
		return new AddCustomerDao(dataSource());
	}
	
	@Bean
	public CustomerDao customerDao() {
		return new CustomerDao(dataSource());
	}
	

}
