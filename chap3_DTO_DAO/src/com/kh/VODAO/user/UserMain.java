package com.kh.VODAO.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		um.selectScanner();
	}

	public boolean checkId(int userId) throws SQLException {
		//1.DB 연결
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "KH1234";
	
		Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		
		//2.SQL
		String sql = "SELECT * FROM USERINFO WHERE user_id = ?";
		PreparedStatement ps = cc.prepareStatement(sql);
		ps.setInt(1, userId);
		
		//3.If활용해서 Result.next() 
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int id = rs.getInt(1);
			return id > 0; //0이상이면 true
		}
		return false; //일치하지 않을 때	
	}
	public boolean checkEmail(String userEmail) throws SQLException {
		//1.DB 연결
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "KH1234";
	
		Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		
		//2.SQL
		String sql = "SELECT * FROM USERINFO WHERE email = ?";
		PreparedStatement ps = cc.prepareStatement(sql);
		ps.setString(1, userEmail);
		
		//3.If활용해서 Result.next() 
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int id = rs.getInt(1);
			return id > 0; //0이상이면 true
		}
		return false; //일치하지 않을 때	
	}
	
	public void selectScanner() {
		//1. DB 연결 URL, USERNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "KH1234";
		
		try {
		Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("User ID 입력해주세요.");
			System.out.println("종료하고싶다면 특수문자 제외 [e] 입력");
			String input = sc.nextLine();
			
			//만약에 e를 입력했다면
			//if("e"==input || "E" == input) {
			if("e".equalsIgnoreCase(input)) {
				System.out.println("종료하겠습니다.");
				break; 
				//break가 없으면 종료되지 않음 종료하겠습니다 만 출력됨
			}
			
			int userId = Integer.parseInt(input);
			System.out.println("이메일을 입력 : ");
			String email = sc.nextLine();
			//select 문 출력하기 
			
			String sql = "SELECT * FROM USERINFO WHERE user_id = ? AND email = ?";
			PreparedStatement st = cc.prepareStatement(sql);
			st.setInt(1, userId);
			st.setString(2, email);
			ResultSet rs = st.executeQuery();
			
			//selectOne if
			if(rs.next()) {
				System.out.println("user ID : " + rs.getInt("user_id"));
				System.out.println("userName : " + rs.getString("user_name"));
				System.out.println("Email : " + rs.getString("email"));
				System.out.println("Registration Date : " + rs.getString("seg_date"));
				System.out.println();
				
			} else {
				boolean idTrue = checkId(userId);
				boolean emailTrue = checkEmail(email);
					if(!idTrue && emailTrue) {
						System.out.println("일치하지 않는 User ID 입니다.");
						System.out.println();
					} else if(idTrue && !emailTrue) {
						System.out.println("일치하지 않는 User Email 입니다.");
						System.out.println();
					} else {
						System.out.println("일치하는 User ID와 Email을 찾을 수가 없습니다.");
						System.out.println();
					}
				System.out.println("User를 찾을 수 없습니다.");
				
			}
			
			
		}
		
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	


	public void selectAll() {
		//1. DB 연결 URL, USERNAME, PASSWORD
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "KH1234";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDAO = new UserDAO(connection);
			
			List<UserVO> users = userDAO.getAllUsers();
			
			for(UserVO u : users) {
			System.out.println("User ID : " + u.getUserId());
			System.out.println("User Name : " + u.getUserName());
			System.out.println("User Email : " + u.getEmail());
			System.out.println("Registration Date : "+u.getRegDate());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void insertRun() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "kh1234";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("User ID : ");
			int userId = sc.nextInt();
			
			System.out.println("아이디를 입력 해주세요 : ");
			String userName = sc.next();
			
			System.out.println("회원가입이 거의다 끝났습니다.");
			System.out.println("마지막으로 이메일 작성해주세요. : ");
			String email = sc.next();
			
			Date regDate = new Date(); //현재 날짜와 시간을 사용한다는 의미
			
			//DB에 담기 위해 인스턴스 생성 후 작성받은 정보 저장하기
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			//데이터가 정상적으로 들어갔는지 확인 boolean을 사용해서 확인
			if(userDao.createUser(newUser)) { //true
				System.out.println("유저가 성공적으로 등록되었습니다.");
			} else {						  //false
				System.out.println("유저 등록에 실패하였습니다.");
			}
			
			//연결 닫기
			connection.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}