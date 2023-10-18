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
			
			//"products"���̺� ������ ����
			insertProducts(ps, 6, "����Ʈ��ġ", "������ǰ", 350.99, 10);
			insertProducts(ps, 7, "�����", "������ǰ", 799.99, 20);
			insertProducts(ps, 8, "���ǽ�", "�Ƿ�", 40.99, 40);
			insertProducts(ps, 9, "���콺", "�޴���", 79.99, 30);
			
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

















