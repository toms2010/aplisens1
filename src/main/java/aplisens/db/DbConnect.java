package aplisens.db;

import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DbConnect {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	private Connection myConn = null;
	private Statement myStmt = null;

// Łączenie z bazą (argumenty z pliku)
	
	public Statement connect (DbAdress file) {
		try {
			myConn=DriverManager.getConnection(file.getDbUrl(), file.getUser(), file.getUser());
			myStmt=myConn.createStatement();
			log.info("Połączono!");
		}
		catch (SQLException exc){
			log.error("Błąd połczenia z bazą SQL");
		}
		return myStmt;
	}

// Rozłącz z bazą
	public void dbDisconnect(Statement myStmt) {
		if (myStmt != null) {
			try {
				myStmt.close();
			} catch (SQLException e) {
				log.error("Błąd podczas zamykania Statement");
			}
			log.info("Zamknięto Statement");
		}
		if (myConn != null) {
			try {
				myConn.close();
			} catch (SQLException e) {
				log.error("Błąd podczas zamykania połączenia");
			}
			log.info("Zamknięto połączenie");
		}
	}
	
}


