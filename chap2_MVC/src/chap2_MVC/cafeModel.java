package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "KH1234";
	public void insertCafe(String name, String address, String phone_number, String operating_hours) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("연결성공!");
			String sql = "INSERT INTO CAFES (name, address, phone_number, operating_hours)"
					+ "VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phone_number);
			ps.setString(4, operating_hours);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateMenu(String description, int menu_id, int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE MENU SET description = ? WHERE menu_id = ? AND cafe_id =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, description);
			st.setInt(2, menu_id);
			st.setInt(3, cafe_id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
	//카페 운영시간 수정하기 
	public void updateCafe(int cafe_id, String operating_hours) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE CAFES SET operating_hours = ? WHERE cafe_id =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, operating_hours);
			st.setInt(2, cafe_id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteCafe(int cafeId) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM CAFES WHERE cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cafeId);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteMenu(int menu_id) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM MENU WHERE menu_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, menu_id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
