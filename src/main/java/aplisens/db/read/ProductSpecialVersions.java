package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.listsTypes.Version;
import toms.aplisens1.Tag;

public class ProductSpecialVersions implements ListsInterface {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	private ResultSet myRs = null;
	private List<Version> dbList = new ArrayList<>();
	private String[][] dbTable;
	private String[] tabLable = { "nazwa", "opis", "cena" };

	public ResultSet selectMethod(Statement myStmt, Tag tag) throws SQLException {
		String commandSQL = "select nazwa, cena, opis FROM wykonania_" + tag.getProductTypeTag()
				+ " WHERE wystepowanie LIKE '%" + tag.getProductModelTag() + "%'";
		myRs = myStmt.executeQuery(commandSQL);
		while (myRs.next()) {
			dbList.add(new Version(myRs.getString("nazwa"), myRs.getString("opis"), myRs.getFloat("cena"), false));
		}
		log.debug(dbList.toString());
		return myRs;
	}

	public String[][] getTable() {
		dbTable = new String[dbList.size()][3];
		for (int i = 0; i < dbList.size(); i++) {
			dbTable[i][0] = dbList.get(i).getNazwa();
			dbTable[i][1] = dbList.get(i).getOpis();
			float temp = dbList.get(i).getCena();
			dbTable[i][2] = String.valueOf(temp);
		}
		return dbTable;
	}

	public String[] getTabLabel() {
		return tabLable;
	}

	public List<Version> getDbList() {
		return dbList;
	}

}
