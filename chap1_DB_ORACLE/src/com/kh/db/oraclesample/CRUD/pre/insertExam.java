package com.kh.db.oraclesample.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//cafes insert 작성해서 여러 카페 추가하기

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
			
			insertCafes(ps, 20, "이디야", "서울시 강남구", "02-555-5555", "매일: 09:00-20:00");
			insertCafes(ps, 21, "메가커피", "서울시 한남동", "02-444-4444", "월-금: 08:00-20:30, 주말: 09:00-19:00");
			insertCafes(ps, 22, "빽다방", "서울시 경복궁로", "02-333-3333", "월-금: 08:30-19:30, 주말: 09:00-18:00");
			
			System.out.println(" row 추가됨");
		
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
