package com.kh.db.oraclesample.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//cafes insert �ۼ��ؼ� ���� ī�� �߰��ϱ�

public class insertExam {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "KH1234";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO CAFES(cafe_id, name, address, phone_number, operating_hours)" 
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			insertCafes(ps, 20, "�̵��", "����� ������", "02-555-5555", "����: 09:00-20:00");
			insertCafes(ps, 21, "�ް�Ŀ��", "����� �ѳ���", "02-444-4444", "��-��: 08:00-20:30, �ָ�: 09:00-19:00");
			insertCafes(ps, 22, "���ٹ�", "����� �溹�÷�", "02-333-3333", "��-��: 08:30-19:30, �ָ�: 09:00-18:00");
			
			System.out.println(" row �߰���");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	static void insertCafes(PreparedStatement ps, int cafe_id, String name, String address, String phone_number, String operating_hours) throws SQLException {
		ps.setInt(1, cafe_id);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setString(4, phone_number);
		ps.setString(5, operating_hours);
		ps.executeUpdate();
		
		
	}
	

}
