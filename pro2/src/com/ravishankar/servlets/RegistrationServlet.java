package com.ravishankar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String uemail = request.getParameter("uemail");
		String umobile = request.getParameter("umobile");
		
		UserServices userService = new UserServices();
		String status = userService.registration(uname,upwd,uemail,umobile);
		
		out.println("<html>");
		out.println("<body bgcolor = 'lightblue'>");
		out.println("<br><br><br>");
		out.println("<font color='red' size='6'>");
		out.println("<b>");
		if(status.equals("success")) {
			out.println("<center>");
			out.println("Registration Success");
			out.println("</center>");
		}
		if(status.contentEquals("failure")) {
			out.println("<center>");
			out.println("Registration Failure");
			out.println("</center>");
		}
		if(status.contentEquals("Existed")) {
			out.println("<center>");
			out.println("User Existed Already");
			out.println("</center>");
		}
		out.println("</b></font></center></body></html>");
	}
}