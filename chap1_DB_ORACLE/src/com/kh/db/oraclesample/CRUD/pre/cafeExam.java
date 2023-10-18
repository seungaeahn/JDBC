package com.kh.db.oraclesample.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class cafeExam {

	public static void main(String[] args) throws SQLException {
		//cafe1();
		//cafe2();
		//cafe3();
		//cafe4();
		//cafe5();
		//cafe6();
		//cafe7();
		cafe8();
		

	}
	
	static void cafe1() throws SQLException {
		//1. 모든 카페 목록 가져오기
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	    String username = "khcafe";
	    String password = "KH1234";
	    String insertSQL = "SELECT * FROM CAFES";
	    
	    Connection con = DriverManager.getConnection(jdbcUrl, username, password);
		Statement st1 = con.createStatement();
		ResultSet result1 = st1.executeQuery(insertSQL);
		
		while(result1.next()) {
			int cafeID = result1.getInt("cafe_id");
			String cafeName = result1.getString("name");
			String cafeAddress = result1.getString("address");
			String phoneNumber = result1.getString("phone_number");
			String operatingHours = result1.getString("operating_hours");
				
			System.out.println("CAFE_ID : " + cafeID);
			System.out.println("CAFE_NAME : " + cafeName);
			System.out.println("CAFE_ADDRESS: " + cafeAddress);
			System.out.println("PHONE_NUMBER: " + phoneNumber);
			System.out.println("OPERATING_HOURS : " + operatingHours);
		}
		
	}
	//2. 특정 카페의 메뉴 가져오기 
	static void cafe2() throws SQLException {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	    String username = "khcafe";
	    String password = "KH1234";
	    String selectSQL = "SELECT * FROM MENU WHERE cafe_id = ?";
	    
	    Connection con = DriverManager.getConnection(jdbcUrl, username, password);
		//Statement st1 = con.createStatement();
		
		PreparedStatement selectPs = con.prepareStatement(selectSQL);
		
		selectPs.setInt(1, 2);
		
		
		ResultSet result2 = selectPs.executeQuery();
		while(result2.next()) {
			int menuID = result2.getInt("menu_id");
			int cafeID = result2.getInt("cafe_id");
			String menuName = result2.getString("menu_name");
			int price = result2.getInt("price");
			String description = result2.getString("description");
				
			System.out.println("MENU_ID : " + menuID);
			System.out.println("CAFE_ID : " + cafeID);
			System.out.println("MENU_NAME: " + menuName);
			System.out.println("PRICE: " + price);
			System.out.println("DESCRIPTION : " + description);
			
		}
	    
	}
	//3. 새로운 카페 추가하기
	static void cafe3() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			//insert문 작성해보기 
			String insertQuery = "INSERT INTO CAFES(cafe_id, name, address, phone_number, operating_hours)" 
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 30);
			insertState.setString(2, "승애카페");
			insertState.setString(3, "수원시 광교동");
			insertState.setString(4, "031-1515-5156");
			insertState.setString(5, "매일: 09:00-20:00");
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + " row 추가됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//4. 특정 카페의 메뉴가격 변경 
	static void cafe4() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			String updateQuery = "UPDATE MENU SET price = ? WHERE cafe_id = ?";
			PreparedStatement updatePs = con.prepareStatement(updateQuery);
			updatePs.setDouble(1, 6.00);
			updatePs.setInt(2, 1);
			int rowsUpdate = updatePs.executeUpdate();
			System.out.println(rowsUpdate + "업데이트 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//5. 특정 카페의 정보 수정하기
	static void cafe5() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			String updateQuery = "UPDATE CAFES SET name = ? WHERE cafe_id = ?";
			PreparedStatement updatePs = con.prepareStatement(updateQuery);
			updatePs.setString(1, "석카페");
			updatePs.setInt(2, 24);
			int rowsUpdate = updatePs.executeUpdate();
			System.out.println(rowsUpdate + "업데이트 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//6. 특정 카페의 정보 삭제하기 
	static void cafe6() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			String deleteQuery = "DELETE CAFES WHERE cafe_id = ?";
			PreparedStatement deletePs = con.prepareStatement(deleteQuery);
			deletePs.setDouble(1, 24);
			int rowsDelete = deletePs.executeUpdate();
			System.out.println(rowsDelete + " 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//7. 특정 카페의 메뉴 수 가져오기 
	static void cafe7() throws SQLException {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "KH1234";
		String selectSQL = "SELECT COUNT(*) AS menu_id FROM MENU WHERE cafe_id = ?";
	    
	    Connection con = DriverManager.getConnection(jdbcUrl, username, password);
		//Statement st1 = con.createStatement();
		
		PreparedStatement selectPs = con.prepareStatement(selectSQL);
		
		selectPs.setInt(1, 2);
		
		
		ResultSet result = selectPs.executeQuery();
		while(result.next()) {
			String rowCount = result.getString("menu_id"); // cafe_id가 2인 행의 개수를 가져옴
	        System.out.println("메뉴 개수: " + rowCount);
			
		}
		
	}
	//8. 특정 가격 범위 내의 모든 메뉴 가져오기
	static void cafe8() throws SQLException {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "KH1234";
		String selectSQL = "SELECT * FROM MENU WHERE price BETWEEN ? AND ?";
		
		Connection con = DriverManager.getConnection(jdbcUrl, username, password);
		
		
		PreparedStatement selectPs = con.prepareStatement(selectSQL);
		
		selectPs.setInt(1, 2);
		selectPs.setInt(2, 5);
		
		ResultSet result = selectPs.executeQuery();
//		while(result.next()) {
//			String rowCount = result.getString("menu_id"); 
//			
//			/*
//			 1. String rowCount = result.getString("menu_id"); 
//			 2.  String rowCount = result.getString("COUNT(*)"); 
//			 3. int rowCount = result.getInt(1); 
//			 * */
//			
//	        System.out.println("메뉴 개수: " + rowCount);
//			
//		}
		while(result.next()) {
			int menuID = result.getInt("menu_id");
			int cafeID = result.getInt("cafe_id");
			String menuName = result.getString("menu_name");
			int price = result.getInt("price");
			String description = result.getString("description");
				
			System.out.println("MENU_ID : " + menuID);
			System.out.println("CAFE_ID : " + cafeID);
			System.out.println("MENU_NAME: " + menuName);
			System.out.println("PRICE: " + price);
			System.out.println("DESCRIPTION : " + description);
			
		}
	
	}
	//9. 특정 메뉴 정보 가져오기 
	
		
		
		
		
	
	
	
	

}
