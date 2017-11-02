package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.listsTypes.ProductParameters;
import aplisens.view.controllers.Properties;

public class ProductParametersSelect implements ListsInterface {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	private ResultSet myRs = null;
	private List<ProductParameters> dbList;
	private Properties proper = Properties.getInstance();

	public ResultSet selectMethod(Statement myStmt) throws SQLException {
		dbList = new ArrayList<>();
		String commandSQL = "select nazwa, wartosc FROM parametry_" + proper.getProductTag().get()
				+ " WHERE wystepowanie LIKE '%" + proper.getModelTag().get() + "%'";
		log.info(commandSQL);
		myRs = myStmt.executeQuery(commandSQL);
		while (myRs.next()) {
			dbList.add(new ProductParameters(myRs.getString("nazwa"), myRs.getString("wartosc")));

		}
		log.debug(dbList.toString());
		return myRs;
	}

	public List<ProductParameters> getDbList() {
		return dbList;
	}

}
