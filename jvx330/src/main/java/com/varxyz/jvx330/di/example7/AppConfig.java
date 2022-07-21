package com.varxyz.jvx330.di.example7;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.varxyz.jvx330.di.example7"}) //이안에있는 클래스 알아서 찾아서 빈 등록
public class AppConfig {
	
}
