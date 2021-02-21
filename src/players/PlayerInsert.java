package players;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DBClose;
import db.DBConnection;

public class PlayerInsert {
	public PlayerInsert() {
	}
	
	public void pInsert() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("선수 번호를 입력하세요 : ");
		int p_id = sc.nextInt();
		System.out.print("선수 이름을 입력하세요 : ");
		String p_name = sc.next();
		System.out.print("선수 나이를 입력하세요 : ");
		int p_age = sc.nextInt();
		System.out.print("선수 포지션을 입력하세요 : ");
		String position = sc.next();
		System.out.print("선수 팀번호를 입력하세요 : ");
		int t_id = sc.nextInt();
		
		String sql = " INSERT INTO PLAYERS( PLAYER_ID, NAME, AGE, POSITION, TEAM_ID )"
				+ " VALUES( " + p_id + ",'" + p_name + "'," + p_age + ",'" + position + "'," + t_id + ") ";
		
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			System.out.println("선수 정보가 입력 되었습니다. ");
			
		} catch (SQLException e) {
			System.out.println("입력이 잘못 되었습니다. 정보를 다시 확인하세요. ");
			pInsert();
		} finally {
			DBClose.close(conn, stmt, null);
		}
	}
}
