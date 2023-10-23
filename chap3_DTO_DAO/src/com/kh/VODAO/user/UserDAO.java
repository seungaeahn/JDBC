package com.kh.VODAO.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private Connection connection;
	
	public UserDAO(Connection connection) {
		this.connection = connection;
	}
	public boolean createUser(UserVO user) {
		String sql = "INSERT INTO USERINFO (user_id, user_name, email, seg_date)"
				+ "VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, user.getUserId());
			st.setString(2, user.getUserName());
			st.setString(3, user.getEmail());
			st.setDate(4, new Date(user.getRegDate().getTime()));
			
			int rows = st.executeUpdate();
			return rows > 0; //값이 들어오면 0보다 커지므로 true가 됨
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public List<UserVO> getAllUsers() throws SQLException {
		List<UserVO> users = new ArrayList<>();
		String sql = "SELECT * FROM USERINFO";
		// try - with - resources
		// 데이터베이스 리소스를 안전하게 사용하고 자동으로 닫아주기 위해서 사용되는 방법
		try (PreparedStatement st = connection.prepareStatement(sql)) {
			ResultSet rs = st.executeQuery();
			//selectOne-If selectAll-while
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setRegDate(rs.getDate("reg_date"));
				users.add(user);
			}
		} 
		return users;
		}
	
}
