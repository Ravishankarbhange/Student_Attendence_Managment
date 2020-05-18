package com.ravishankar.servlets;

import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class UserServices {
	
	public static String uid ="";
	String status="";
	Connection con;
	Statement st;
	ResultSet rs;
	public UserServices() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ravishankar","root","ravishankar");
			st =  con.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String checkLogin(String uname,String upwd) {
		uid=uname;
		try {
			rs = st.executeQuery("select * from reg_Users where uname='"+uname+"' and upwd='"+upwd+"'");
			boolean b = rs.next();
			if(b==true) {
				status="success";
			}
			else {
				status="failure";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public String registration(String uname,String upwd,String uemail,String umobile) {
		try {
			rs= st.executeQuery("select * from reg_Users where uname='"+uname+"'");
			boolean b = rs.next();
			if(b==true) {
				status = "Existed";
			}
			else {
				String s1="0";
				String s2="0";
				String s3="0";
				String s4="0";
				String s5="0";
				String TotalAtt="0";
				st.executeUpdate("insert into reg_Users values('"+uname+"','"+upwd+"','"+uemail+"','"+umobile+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+TotalAtt+"')");
				status="success";
			}
		}
		catch(Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}
	public String attendence() {
		String uname=uid;
		return uname;
	}
}