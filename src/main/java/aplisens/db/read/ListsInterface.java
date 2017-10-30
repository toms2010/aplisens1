package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public interface ListsInterface {

	ResultSet selectMethod(Statement myRs) throws SQLException;

}
