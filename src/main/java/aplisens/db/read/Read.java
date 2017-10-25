package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import toms.aplisens1.Tag;

public class Read{

	protected final Logger log = LoggerFactory.getLogger(getClass());
	private ResultSet myRs = null;
	
	
	public void read(Statement myStmt, ListsInterface list, Tag tag){
		try {
			myRs=list.selectMethod(myStmt,tag);
		}
		catch (Exception exc){
			log.error("Błąd podczas odczytu z bazy danych");
		}
		finally {
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
