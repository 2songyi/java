package com.varxyz.jvx330.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc	// 스프링 MVC 설정에 대한 기본 구성 제공
@ComponentScan(basePackages = "com.varxyz.jvx330.mvc")
public class WebMVCConfig implements WebMvcConfigurer {
// 프로젝트당 하나
//	AnnotationConfigApplicationContext
//	CharacterEncodingFilter
	/**
	 * DispatcherServlet의 매핑 경로를 "/"로 주었을 때, JSP/HTML/CSS 등을 바르게 처리하도록 한다.
	 * <mvc:default-servlet-handler>
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	/**
	 * 컨트롤러의 처리 결과를 jsp로 표시하기 위한 설정
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry resistry) {
		resistry.jsp("/WEB-INF/views/", ".jsp"); // WEB-INF밖에 있었는데 안쪽에 다 넣음. 컨트롤러를 거쳐 jsp를 호출함.
	}
	
	/**
	 * src/main/webapp/resources 위치의 정적 리소스를 설정 (css, js..)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	
}