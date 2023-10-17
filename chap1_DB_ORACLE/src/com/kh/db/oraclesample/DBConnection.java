package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {


	public static void main(String[] args) {	
		//selectbank();
		//selectcafe();
		selectIf();

}

	static void selectbank() {
		// 1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸� 
				String driver = "oracle.jdbc.driver.OracleDriver";
				//2. ����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ���� ����
				//                              ���� IP�ּ�:port��ȣ
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "khbank";
				String password = "kh1234";
				Connection con = null;
				try {
					//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ���� 
					con = DriverManager.getConnection(url, user, password);
					System.out.println("�����ͺ��̽� ���� ����!");
					
					//SELECT ����
					String selectQuery = "SELECT * FROM BANK";
					PreparedStatement selectState = con.prepareStatement(selectQuery);
					ResultSet result = selectState.executeQuery();
					//result.next() : result ��ü���� ���� ��(row)���� �̵�
					//���� ���� ������ true ��ȯ, �׷��� ������ false
					while(result.next()) {
						//khbank�� �ִ� bank ���̺� ������տ��� account_id�� ������
						int accountID = result.getInt("account_id");
						
						//1. �Բ� �غ��� : accountNumber
						double accountNumber = result.getDouble("account_number");
						
						String accountName = result.getString("account_name");
						double balance = result.getDouble("balance");
						
						//2. �Բ� �غ��� : branchName
						String branchName = result.getString("branch_name");
						
						//3. �Բ� �غ���java.sql import Date lastTransactionDate �������� 
						Date lastTransactionDate = result.getDate("last_transaction_date");
						
						System.out.println("ACCOUNT_ID : " + accountID);
						System.out.println("ACCOUNT_NAME : " + accountName);
						System.out.println("BALANCE: " + balance);
						System.out.println("BRANCH_NAME: " + branchName);
						System.out.println("LAST_TRANSACTION_DATE : " + lastTransactionDate);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
	
	static void selectcafe() {
		// 1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸� 
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ���� ����
		//                              ���� IP�ּ�:port��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "KH1234";
		Connection con = null;
		try {
			//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ���� 
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
			
			//SELECT ����
			String selectQuery = "SELECT * FROM CAFES";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			//result.next() : result ��ü���� ���� ��(row)���� �̵�
			//���� ���� ������ true ��ȯ, �׷��� ������ false
			while(result.next()) {
				//khcafe�� �ִ� cafes ���̺� ������տ��� cafe_id�� ������
				int cafeID = result.getInt("cafe_id");
				
				String cafeName = result.getString("name");
				
				String cafeAddress = result.getString("address");
				
				String phoneNumber = result.getString("phone_number");
				
				String operatingHours = result.getString("operating_hours");
				
				
				System.out.println("CAFE_ID : " + cafeID);
				System.out.println("CAFE_NAME : " + cafeName);
				System.out.println("CAFE_ADDRESS: " + cafeAddress);
				System.out.println("PHONE_NUMBER: " + phoneNumber);
				System.out.println("OPERATING_HOURS : " + operatingHours);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	static void selectIf() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "kh1234";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			//where�� ����Ͽ� �����߰� 
			String selectQuery = "SELECT * FROM BANK WHERE account_number=?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
//			String[] targetAN = {"1234567890", "5555666777"};
//			selectState.setString(1, targetAN[0]);
//			selectState.setString(2, targetAN[1]);
			
			
			//���⿡ ���ϴ� ������ account_id ����
			int targetID = 1;
			
			//���� ���� 
			selectState.setInt(1, targetID);
			
			ResultSet result = selectState.executeQuery();
			
			
			
			if (result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getDouble("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				
				System.out.println("ACCOUNT_ID : " + a);
				System.out.println("ACCOUNT_NUMBER : " + b);
				System.out.println("ACCOUNT_NAME : " + c);
				System.out.println("BALANCE: " + d);
				System.out.println("BRANCH_NAME: " + e);
				System.out.println("LAST_TRANSACTION_DATE : " + f);
			} else {
				System.out.println("���ǿ� �ش��ϴ� �����Ͱ� �����ϴ�.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}	
