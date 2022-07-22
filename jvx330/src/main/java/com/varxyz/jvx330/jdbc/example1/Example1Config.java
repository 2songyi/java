package com.varxyz.jvx330.jdbc.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.varxyz.jvx330.jdbc.DataSourceConfig;

@Configuration
@Import(DataSourceConfig.class) //여기서 이 dataSource가 필요해서 임포트해줌
public class Example1Config {
	
//	@Bean
//	public AddCustomerDataSourceDao addCustomerDataSourceDao() {
//		return new AddCustomerDataSourceDao(dataSource());
//	}
	
}
