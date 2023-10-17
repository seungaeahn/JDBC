package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
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
				
				System.out.println("ACCOUNT_ID : " + accountID);
				System.out.println("ACCOUNT_NAME : " + accountName);
				System.out.println("BALANCE: " + balance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}