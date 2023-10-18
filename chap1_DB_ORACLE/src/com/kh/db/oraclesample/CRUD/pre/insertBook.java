package com.kh.db.oraclesample.CRUD.pre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class insertBook {
	   public static void main(String[] args) {
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String user = "khcafe";
	      String password = "KH1234";
	      try {
	         Connection con = DriverManager.getConnection(url, user, password);
	         String insertSQL = "INSERT INTO BOOK (BOOK_ID, TITLE, AUTHOR, PUBLICATION_YEAR, ISBN, GENRE, DESCRIPTION, PRICE, PUBLICATION_DATE, UPDATED_DATE, IS_AVAILABLE)"
	               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	         PreparedStatement ps = con.prepareStatement(insertSQL);
	         insertBook(ps, 14, "오만과 편견", "제인 오스틴", 2003,  "978-8937460883", "Romance", "인간관계 속 편협한 사고방식을 극복하자는 메시지를 전한다.", 16.99,  Date.valueOf("2003-05-12"), Date.valueOf("2023-10-18"), "Y");
	
	         ps.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   static void insertBook(PreparedStatement ps, int book_id, String title, String author, int publication_year, String isbn, String genre, String description, double price, Date publication_date, Date updated_date, String is_avaliable) throws SQLException{
	     
		  ps.setInt(1, book_id);
	      ps.setString(2, title);
	      ps.setString(3, author);
	      ps.setInt(4, publication_year);
	      ps.setString(5, isbn);
	      ps.setString(6, genre);
	      ps.setString(7, description);
	      ps.setDouble(8, price);
	      ps.setDate(9, publication_date);
	      ps.setDate(10, updated_date);
	      ps.setString(11, is_avaliable);
	      int a = ps.executeUpdate();
	      System.out.println(a);
	   }
	



public static void insertALLTwo() {
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "khcafe";
    String password = "kh1234";
    String insertSQL = "INSERT INTO cafes (cname, address, phone_number, operating_hours) VALUES (?, ?, ?, ?)";

   
    try {
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

        insertCafe(preparedStatement, "카페써울", "주소 1", "전화번호 1", "영업 시간 1");
        insertCafe(preparedStatement, "카페강남", "주소 2", "전화번호 2", "영업 시간 2");
        insertCafe(preparedStatement, "카페서초", "주소 3", "전화번호 3", "영업 시간 3");
        insertCafe(preparedStatement, "카페역삼", "주소 4", "전화번호 4", "영업 시간 4");
        insertCafe(preparedStatement, "카페논현", "주소 5", "전화번호 5", "영업 시간 5");

        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public static void insertCafe(PreparedStatement preparedStatement, String name, String address, String phone, String hours) throws SQLException {

    preparedStatement.setString(1, name);
    preparedStatement.setString(2, address);
    preparedStatement.setString(3, phone);
    preparedStatement.setString(4, hours);

    // 데이터 삽입
    preparedStatement.executeUpdate();

}
}
