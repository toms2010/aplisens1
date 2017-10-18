package aplisens.db;

import java.sql.*;

public class DbConnect {
	
	private Connection myConn = null;
	private Statement myStmt = null;

// Łączenie z bazą (argumenty z pliku)
	
	public Statement connect (DbAdress file) {
		try {
			myConn=DriverManager.getConnection(file.getDbUrl(), file.getUser(), file.getUser());
			myStmt=myConn.createStatement();
			System.out.println("Połączono!");
		}
		catch (SQLException exc){
			System.out.println("Błąd połczenia z bazą SQL");
		}
		return myStmt;
	}

// Rozłącz z bazą
	public void dbDisconnect(Statement myStmt) {
		if (myStmt != null) {
			try {
				myStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Zamknięto stmt");
		}
		if (myConn != null) {
			try {
				myConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Zamknięto połączenie");
		}
	}
	
}


