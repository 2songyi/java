package com.varxyz.jv300.mod004;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/mod004/file_upload.do")
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2,  // 2MB  , 이 크기보다 커지면 메모리에 올려두지않고 바로 저장
	maxFileSize = 1024 * 1024 * 10,	      // 10MB , 업로드할 수 있는 최대 파일 크기
	maxRequestSize = 1024 * 1024 * 50)    // 50MB , 첨부파일을 합친 총합 사이즈 (멀티파트의 전체 파일 사이즈) -1주면 무한대사이즈

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "C:/temp"; //여기에 받아온 파일을 저장하겠다

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		File saveDir = new File(SAVE_DIR);
		if (!saveDir.exists())  { // exists() 이 dir이 존재하는지
			saveDir.mkdir(); // 폴더 만들어라
		}
		for (Part part : request.getParts()) {
			// C:/path + \ + eclipse.ini -> C:\path\eclipse.ini
			part.write(saveDir.getPath() + File.separator + extractFileName(part)); // 위에 정의한 temp를 가리킴 + + file이름
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>Upload has been done sucessfully.</h3>");
		out.println("</body></html>");
		out.close();
		
		/*Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()) {
			String header = en.nextElement();
			System.out.println(header + " = " + request.getHeader(header)); // 헤더값 출력
		} */
	}
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("Content-Disposition");
		System.out.println("Content-Disposition " + contentDisp);
		for (String s : contentDisp.split(";")) {
			if (s.contains(File.separator)) {
				return s.substring(s.lastIndexOf(File.separator) + 1).replace("\"", "");
			} else {
				return s.substring("filename=".length()+1).replace("\"", "");
			}
		}
		return "";
	}

}
