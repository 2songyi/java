package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Multiply extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		String pageTitle = "Multiply";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		int i;
		int j;
		int multiply;
		
		for (i = 1; i < 10; i++) {
			for (j = 2; j < 10; j++) {
				multiply = i*j;
				out.print(j + "*" + i +"=" + multiply + "\t");
			}
			out.println();
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
