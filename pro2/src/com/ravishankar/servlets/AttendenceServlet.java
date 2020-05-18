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

public class AttendenceServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1="";
		String s2="";
		String s3="";
		String s4="";
		String s5="";
		String att="";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname="";
		UserServices userService = new UserServices();
		uname=userService.attendence();
		Studentatt sc = new Studentatt();
		s1=sc.m1(uname);
		s2=sc.m2();
		s3=sc.m3();
		s4=sc.m4();
		s5=sc.m5();
		try {
				out.println("<html>");
				out.println("<body bgcolor = 'lightblue'>");
				out.println("<br><br><br>");
				out.println("<font color='red' size='6'>");
				out.println("");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>EID221   (JAVA)</th><td>"+s1+"</td></tr>");
				out.println("<tr><th>EID222   (OS)</th><td>"+s2+"</td></tr>");
				out.println("<tr><th>EID223   (CN)</th><td>"+s3+"</td></tr>");
				out.println("<tr><th>EID224   (MATHS)</th><td>"+s4+"</td></tr>");
				out.println("<tr><th>EID225   (ENGILSH)</th><td>"+s5+"</td></tr>");
				out.println("</table></font></center></body></html>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}