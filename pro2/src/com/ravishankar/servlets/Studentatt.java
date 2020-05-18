package com.ravishankar.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Studentatt {
	String s1="";
	static String s2="";
	static String s3="";
	static String s4="";
	static String s5="";
	static String sematt="";
	String status="";
	Connection con;
	Statement st;
	ResultSet rs;
	public Studentatt() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ravishankar","root","ravishankar");
			st =  con.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String m1(String uid) {
		try {
			rs = st.executeQuery("select * from reg_Users");
			while (rs.next()) 
            {  
                String n = rs.getString("uname");
                if(n.equals(uid)) {
                	s1=rs.getString("eid221");
                	s2=rs.getString("eid222");
                	s3=rs.getString("eid223");
                	s4=rs.getString("eid224");
                	s5=rs.getString("eid225");
                	sematt=rs.getString("TotalAtt");
                }
            }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s1;		
	}
	public String m2() {
		return s2;		
	}
	public String m3() {
		return s3;		
	}
	public String m4() {
		return s4;		
	}
	public String m5() {
		return s5;
	}
	public String m6() {
		return sematt;
	}
}