package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.listsTypes.ProductType;


public class ProductTypeSelect implements ListsInterface {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	private List<ProductType> dbList = new ArrayList<>();
	private ResultSet myRs = null;

	public ResultSet selectMethod(Statement myStmt) throws SQLException {
		String commandSQL = "SELECT tag, opis, MIN(id_pr) FROM produkty GROUP BY tag";
		myRs = myStmt.executeQuery(commandSQL);
		while (myRs.next()) {
			dbList.add(new ProductType(myRs.getString("tag"), myRs.getString("opis")));
		}
		log.debug(dbList.toString());
		return myRs;
	}

	public List<ProductType> getDbList() {
		return dbList;
	}

}
