package com.varxyz.jv300.mod009;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod009/list_course_contents.do")
public class ListCourseContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private static List<String[]> contentList; // String[] 쓰면 jsp에서 중첩문 돌려야함
	private static List<String> textLines;
	
	@SuppressWarnings("unchecked")
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		List<String[]>contentList = (List<String[]>)context.getAttribute("contentList");
		textLines = tapToSpace(contentList); // tap
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("textLines", textLines);
		req.getRequestDispatcher("list_course_contents.jsp").forward(req, resp);
	}
	
	private List<String> tapToSpace(List<String[]> contentList) {
		List<String> lineList = new ArrayList<>();
		if (contentList.size() > 0) {
			for (String[] contents : contentList) {
				// emptyLine처리
				if (isEmptyLine(contents)) {
					continue;
				}
				for (int i = 0; i < contents.length; i++) {
					if (contents[i].length() == 0) { // tab이 들어간 경우
						// contents[i] = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						// contents[i] = "<span style='margin-left:40px'></span>";
						contents[i] = "<span class=\"tab\">";
						contents[contents.length - 1] = contents[contents.length - 1] + "</span>";
					}
				}
			}
		} else {
			lineList.add("-No Data-");
		}	
		
		String line="";
		for (String[] contents : contentList) {
			
			for(String s : contents) {
				line += s;
			}
			lineList.add(line);
			line="";
		}
		
		return lineList;
	}

	private boolean isEmptyLine(String[] contents) {
		if (contents != null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	

	
	
	
}
