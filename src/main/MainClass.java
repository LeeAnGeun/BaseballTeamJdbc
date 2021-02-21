package main;

import db.DBConnection;
import players.PlayerInsert;
import players.PlayerSelect;
import team.TeamInsert;

public class MainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();
		
	//	TeamInsert tIn = new TeamInsert();
		
	//	tIn.tInsert();
		
	//	PlayerInsert pIn = new PlayerInsert();
		
	//	pIn.pInsert();
		
		PlayerSelect pse = new PlayerSelect();
		pse.pSelect();
	}

}
