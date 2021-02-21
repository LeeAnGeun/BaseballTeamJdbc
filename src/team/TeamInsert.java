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
		
		System.out.print("팀 번호를 입력하세요 : ");
		int teamId = sc.nextInt();
		System.out.print("팀 이름을 입력하세요 : ");
		String teamName = sc.next();
		System.out.print("팀 지역을 입력하세요 : ");
		String local = sc.next();
		
		String sql = " INSERT INTO TEAMS(TEAM_ID, TEAM_NAME, TEAM_LOCAL)"
				+ " VALUES ( " + teamId + ", '" + teamName + "', '" + local + "') ";
		
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			System.out.println("팀 정보가 입력되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, null);
		}
	}
}
