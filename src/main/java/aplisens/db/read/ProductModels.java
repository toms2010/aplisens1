package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.listsTypes.Model;
import toms.aplisens1.Tag;

public class ProductModels implements ListsInterface {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	private ResultSet myRs = null;
	private List<Model> dbList = new ArrayList<>();
	private String[][] dbTable;
	private String[] tabLable = { "nazwa", "dokładny opis", "cena" };

	public ResultSet selectMethod(Statement myStmt, Tag tag) throws SQLException {
		String commandSQL = "SELECT nazwa, opis, cena , dok_opis FROM produkty WHERE tag LIKE '"
				+ tag.getProductTypeTag() + "'";
		myRs = myStmt.executeQuery(commandSQL);
		while (myRs.next()) {
			dbList.add(new Model(myRs.getString("nazwa"), myRs.getString("dok_opis"), myRs.getFloat("cena")));
		}
		log.debug(dbList.toString());
		return myRs;
	}

	public String[][] getTable() {
		dbTable = new String[dbList.size()][3];
		for (int i = 0; i < dbList.size(); i++) {
			dbTable[i][0] = dbList.get(i).getNazwa();
			dbTable[i][1] = dbList.get(i).getDokOpis();
			float temp = dbList.get(i).getCena();
			dbTable[i][2] = String.valueOf(temp);
		}
		return dbTable;
	}

	public String[] getTabLabel() {
		return tabLable;
	}

	public List<Model> getDbList() {
		return dbList;
	}

}
