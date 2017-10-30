package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.listsTypes.ProductModel;
import toms.aplisens1.Tag;

public class ProductModelSelect implements ListsInterface {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	private ResultSet myRs = null;
	private List<ProductModel> dbList;

	public ResultSet selectMethod(Statement myStmt) throws SQLException {
		dbList = new ArrayList<>();
		String commandSQL = "SELECT nazwa, opis, cena , dok_opis FROM produkty WHERE tag LIKE '"
				+ Tag.productTypeTag + "'";
		myRs = myStmt.executeQuery(commandSQL);
		while (myRs.next()) {
			dbList.add(new ProductModel(myRs.getString("nazwa"), myRs.getString("dok_opis"), myRs.getFloat("cena")));
		}
		log.debug(dbList.toString());
		return myRs;
	}

	public List<ProductModel> getDbList() {
		return dbList;
	}

}
