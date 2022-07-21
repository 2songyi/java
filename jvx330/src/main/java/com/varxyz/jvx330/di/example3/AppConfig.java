package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	// 설정관련된 클래스
	
	@Bean
	public MemberService memberService() { //이 메서드 이름 = bean 이름
		return new MemberService(memberDao());
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	

}
