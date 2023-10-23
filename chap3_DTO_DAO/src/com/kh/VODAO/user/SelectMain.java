package com.kh.VODAO.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SelectMain {

	public static void main(String[] args) {
		SelectMain um = new SelectMain();
		um.selectAll();	
	}
	public void selectAll() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "KH1234";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			SelectDAO selectDao = new SelectDAO(connection);
			
			List<SelectVO> users = SelectDAO.getAllUsers();
			
			for(SelectVO u : users) {
				System.out.println("User ID : " + u.getUserId());
				System.out.println("User Name : " + u.getUserName());
				System.out.println("User Email : " + u.getEmail());
				System.out.println("Registration Date : " + u.getRegDate());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

}
