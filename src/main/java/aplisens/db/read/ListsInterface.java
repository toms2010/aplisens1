package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import toms.aplisens1.Tag;


public interface ListsInterface {
	
	ResultSet selectMethod(Statement myRs, Tag tag) throws SQLException;
	
}
