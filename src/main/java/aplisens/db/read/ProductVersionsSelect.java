package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.listsTypes.ProductVersion;
import aplisens.logic.Properties;

public class ProductVersionsSelect implements ListsInterface {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private ResultSet myRs = null;
	private List<ProductVersion> dbList;
	private Properties properties = Properties.getInstance();

	public ResultSet selectMethod(Statement myStmt) throws SQLException {
		dbList = new ArrayList<>();
		String commandSQL = "select nazwa, cena, opis FROM wykonania_" + properties.getTypeTag().get()
				+ " WHERE wystepowanie LIKE '%" + properties.getModelTag().get() + "%'";
		log.info(commandSQL);
		myRs = myStmt.executeQuery(commandSQL);
		while (myRs.next()) {
			dbList.add(new ProductVersion(myRs.getString("nazwa"), myRs.getString("opis"), myRs.getFloat("cena")));
		}
		log.debug(dbList.toString());
		return myRs;
	}

	public List<ProductVersion> getDbList() {
		return dbList;
	}

}
