package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TextJdbc {

	public static void main(String[] args) {

		String jdbcUrl="jdbc:mysql://127.0.0.1:3306/hb-01-one-to-one-uni?useSSL=false&allowPublicKeyRetrieval=true";
		String user= "hbstudent1";
		String pass = "hbstudent1";
		try{
			System.out.println("Connecting to jdbc :" + jdbcUrl);
			
			Connection myConnection = DriverManager.getConnection(jdbcUrl,user,pass.trim());
			
			
			System.out.println("Connection sucessfull");
		}
		
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
