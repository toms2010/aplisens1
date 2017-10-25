package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aplisens.db.listsTypes.Type;
import toms.aplisens1.Tag;

public class ProductType implements ListsInterface {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	private List<Type> dbList = new ArrayList<>();
	private ResultSet myRs = null;
	private String[][] dbTable;
	private String[] tabLable= {"tag", "opis"};

	
	public ResultSet selectMethod(Statement myStmt, Tag tag) throws SQLException {
		String commandSQL="SELECT tag, MIN(opis) AS opis FROM produkty GROUP BY tag";
		myRs=myStmt.executeQuery(commandSQL);
		while (myRs.next()){
			dbList.add(new Type(myRs.getString("tag"),myRs.getString("opis")));
		}
		log.debug(dbList.toString());
		return myRs;
	}
		 
	
	
	public String[][] getTable() {
		dbTable = new String[dbList.size()][2];
		for(int i=0; i<dbList.size(); i++) {
			dbTable[i][0]=dbList.get(i).getTag();
			dbTable[i][1]=dbList.get(i).getOpis();
		}
		return dbTable;
	}
	
	public String[] getTabLabel() {
		return tabLable;
	}
		
	public List<Type> getDbList() {
		return dbList;
	}
		
}
