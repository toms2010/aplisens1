package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadFromDb {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private ResultSet myRs = null;

	public void readFromDb(Statement myStmt, ListsInterface list) {
		try {
			myRs = list.selectMethod(myStmt);
		} catch (Exception exc) {
			log.error("Błąd podczas odczytu z bazy danych");
		} finally {
			if (myRs != null) {
				try {
					myRs.close();
					log.info("Zamknięto ResultSet");
				} catch (SQLException e) {
					log.error("Błąd podczas zamykania ResultSet");
				}
			}
		}
	}
}
