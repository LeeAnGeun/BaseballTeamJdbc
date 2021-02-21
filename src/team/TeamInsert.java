package team;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DBClose;
import db.DBConnection;

public class TeamInsert {
	public TeamInsert() {
	}
	
	public void tInsert() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�� ��ȣ�� �Է��ϼ��� : ");
		int teamId = sc.nextInt();
		System.out.print("�� �̸��� �Է��ϼ��� : ");
		String teamName = sc.next();
		System.out.print("�� ������ �Է��ϼ��� : ");
		String local = sc.next();
		
		String sql = " INSERT INTO TEAMS(TEAM_ID, TEAM_NAME, TEAM_LOCAL)"
				+ " VALUES ( " + teamId + ", '" + teamName + "', '" + local + "') ";
		
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			System.out.println("�� ������ �ԷµǾ����ϴ�.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, null);
		}
	}
}
