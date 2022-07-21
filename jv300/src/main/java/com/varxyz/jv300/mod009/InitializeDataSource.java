package com.varxyz.jv300.mod009;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeDataSource implements ServletContextListener {
	/*
	 * 1.파일읽기 (jdbc.proporties) 2. dataSource (1 불러오기) 3.
	 * servletContext.setAttribute("",); service 변하지 않는 서비스들, 그 외 SERVLET에서 처리
	 * SERVLET에서 JDBC정보들 가져오고 싱글톤으로 만들어두고 getInstance()처럼 불러서 쓰기
	 */
	private static final String JDBC_FILE_PATH = "/WEB-INF/classes/jdbc.properties"; // 읽어올위치

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		 System.out.println("contextInitialized() method called");
		
		// dataSource불러오기
		ServletContext context = sce.getServletContext();
		InputStream is = null;
		
		try {
			is = context.getResourceAsStream(JDBC_FILE_PATH);
			Properties prop = new Properties();
			prop.load(is);
			
			String jdbcDriver = prop.getProperty("jdbc.driver");
			String jdbcUrl = prop.getProperty("jdbc.url");
			String jdbcName = prop.getProperty("jdbc.name");
			String passwd = prop.getProperty("jdbc.passwd");
			
			//dataSource만들기
			DataSource dataSource = new DataSource(jdbcDriver, jdbcUrl, jdbcName, passwd); // 예전에 만든거는 dataSourceManager
			
			NamingService namingService = NamingService.getInstance();
			namingService.setAttribute("dataSource", dataSource);
			
			System.out.println("DataSource has been init");
			// 이 데이터소스를 필요로 하는걸 전달
			// context.setAttribute("dataSource", dataSource); 
			// 이렇게 안하고 전담으로 해주는 namingService클래스를 하나 만든다,
			// dao ->db관련된거만 하려고하는데 이런게 넘어가면 web도 가지게 됨
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
