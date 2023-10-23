package com.kh.VODAO.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectDAO {
private Connection connection;
	

	public void SelectDAO(Connection connection) {
		this.connection = connection;
	}
	public SelectDAO(Connection connection) {
		
	}
	public boolean createUser(UserVO user) {
		public void getAllUsers() {
			List<SelectDAO> userinfo = new ArrayList<>();
			String sql = "SELECT * FROM USERINFO";
			PreparedStatement st = connection.prepareStatement(sql);
			
			
		}
	
	
	}
	

}

