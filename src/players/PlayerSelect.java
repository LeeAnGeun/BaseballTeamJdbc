package players;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DBClose;
import db.DBConnection;

public class PlayerSelect {
	public PlayerSelect() {
	}
	
	public void pSelect() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력하려는 선수 이름을 입력하세요 : ");
		String name = sc.next();
		
		String sql = " SELECT * "
				+ " FROM PLAYERS P, TEAMS T "
				+ " WHERE P.TEAM_ID = T.TEAM_ID "
				+ " AND P.NAME = '" + name + "' ";
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int pid = rs.getInt("player_id");
				String pname = rs.getString("name");
				int age = rs.getInt("age");
				String position = rs.getString("position");
				int tid = rs.getInt("team_id");
				String tname = rs.getString("team_name");
				String local = rs.getString("team_local");
				
				System.out.println( pid+ ", " + pname + ", " + age + ", " + position + ", " + tid + ", " + tname + ", " + local);
			}
		} catch (SQLException e) {
			System.out.println("선수를 찾을 수 없습니다. 다시 입력하세요 ");
			pSelect();
		} finally {
			DBClose.close(conn, stmt, rs);
		}
	}
}









