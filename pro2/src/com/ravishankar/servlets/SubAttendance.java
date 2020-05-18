package com.ravishankar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubAttendance extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sematt="";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname="";
		UserServices userService = new UserServices();
		uname=userService.attendence();
		Studentatt sc = new Studentatt();
		sematt=sc.m6();
		try {
				out.println("<html>");
				out.println("<body bgcolor = 'lightblue'>");
				out.println("<br><br><br>");
				out.println("<font color='red' size='6'>");
				out.println("");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>Semester Attendance</th><td>"+sematt+"</td></tr>");
				out.println("</table></font></center></body></html>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}