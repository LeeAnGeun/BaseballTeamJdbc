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
		
		System.out.print("���� ��ȣ�� �Է��ϼ��� : ");
		int p_id = sc.nextInt();
		System.out.print("���� �̸��� �Է��ϼ��� : ");
		String p_name = sc.next();
		System.out.print("���� ���̸� �Է��ϼ��� : ");
		int p_age = sc.nextInt();
		System.out.print("���� �������� �Է��ϼ��� : ");
		String position = sc.next();
		System.out.print("���� ����ȣ�� �Է��ϼ��� : ");
		int t_id = sc.nextInt();
		
		String sql = " INSERT INTO PLAYERS( PLAYER_ID, NAME, AGE, POSITION, TEAM_ID )"
				+ " VALUES( " + p_id + ",'" + p_name + "'," + p_age + ",'" + position + "'," + t_id + ") ";
		
		System.out.println(sql);
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			System.out.println("���� ������ �Է� �Ǿ����ϴ�. ");
			
		} catch (SQLException e) {
			System.out.println("�Է��� �߸� �Ǿ����ϴ�. ������ �ٽ� Ȯ���ϼ���. ");
			pInsert();
		} finally {
			DBClose.close(conn, stmt, null);
		}
	}
}
