package com.kh.db.oraclesample.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteSample {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khbank";
		String password = "kh1234";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			String deleteQuery = "DELETE BANK WHERE account_number = ?";
			PreparedStatement deletePs = con.prepareStatement(deleteQuery);
			deletePs.setDouble(1, 2);
			int rowsDelete = deletePs.executeUpdate();
			System.out.println(rowsDelete + " 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
