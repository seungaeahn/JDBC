package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertAll {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertQuery = "INSERT INTO products( product_id, product_name, category, price, stock_quantity)"
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			//"products"테이블에 데이터 삽입
			insertProducts(ps, 6, "스마트워치", "전자제품", 350.99, 10);
			insertProducts(ps, 7, "냉장고", "가전제품", 799.99, 20);
			insertProducts(ps, 8, "원피스", "의류", 40.99, 40);
			insertProducts(ps, 9, "마우스", "휴대기기", 79.99, 30);
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	static void insertProducts(PreparedStatement ps, int product_id, String product_name, String category, double price, int stock_quantity) throws SQLException {
		ps.setInt(1, product_id);
		ps.setString(2, product_name);
		ps.setString(3, category);
		ps.setDouble(4, price);
		ps.setInt(5, stock_quantity);
		ps.executeUpdate();
	}

}

















