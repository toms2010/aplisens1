package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.listsTypes.ProductVersion;
import toms.aplisens1.Tag;

public class ProducVersionsSelect implements ListsInterface {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	private ResultSet myRs = null;
	private List<ProductVersion> dbList = new ArrayList<>();

	public ResultSet selectMethod(Statement myStmt) throws SQLException {
		String commandSQL = "select nazwa, cena, opis FROM wykonania_" + Tag.productTypeTag
				+ " WHERE wystepowanie LIKE '%" + Tag.productModelTag + "%'";
		myRs = myStmt.executeQuery(commandSQL);
		while (myRs.next()) {
			dbList.add(new ProductVersion(myRs.getString("nazwa"), myRs.getString("opis"), myRs.getFloat("cena"), false));
		}
		log.debug(dbList.toString());
		return myRs;
	}

	public List<ProductVersion> getDbList() {
		return dbList;
	}

}