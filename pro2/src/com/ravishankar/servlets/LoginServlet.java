package com.ravishankar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		UserServices userService = new UserServices();
		String status = userService.checkLogin(uname,upwd);
		out.println("<html>");
		out.println("<body bgcolor = 'lightblue'>");
		out.println("<br><br><br>");
		out.println("<font color='red' size='6'>");
		out.println("<b>");
		if(status.equals("success")) {
			out.println("<center>");
			out.println("<h1>Login Success</h1>");
			out.println("<a href='./attendence.html'>Student Attendence</a>");
			out.println("<br><br>");
		}
		if(status.contentEquals("failure")) {
			out.println("Login Failure");
		}
		out.println("</b></font></center></body></html>");
	}
}