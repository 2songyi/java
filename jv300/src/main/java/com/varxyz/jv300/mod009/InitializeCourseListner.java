package com.varxyz.jv300.mod009;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeCourseListner implements ServletContextListener {
	
	@Override
    public void contextInitialized(ServletContextEvent event)  {
		System.out.println("contextInitialized() method called");
	
		
		ServletContext context = event.getServletContext();
		InputStream is = null;
		BufferedReader reader = null; // buffer 내장 스트림
		List<String[]> contentList = new ArrayList<String[]>();
		
		try {
			is = context.getResourceAsStream("/WEB-INF/classes/course_contents.txt");
			reader = new BufferedReader(new InputStreamReader(is)); // is(inputStream)를 받아서 inputStreamreader로 만듦
			String record = null;
			// inputStream / inputStreamreader / bufferReader 쌓은 형태-> decorate pattern
			
			while((record = reader.readLine()) != null) {
				record = escapeHtml(record);
				String[] fields = record.split("\t");
				contentList.add(fields);
			}
			context.setAttribute("contentList", contentList); // 서버 shutdown될때까지 저장
			context.log("The course contents has been loaded");
		} catch (Exception e) { // IO관련된 예외 발생
			e.printStackTrace();
		}
    }
	
	private String escapeHtml(String line) {
		if (line.length() == 0) {
			return line;
		}
		
		return line.replace("<", "&lt;").replace(">", "&gt;");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event)  {
		System.out.println("contextDestroyed() method called");
	}
	
}
