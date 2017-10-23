package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductType implements ListsInterface {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	private String productsTypes[][]= new String[10][2];
	private ResultSet myRs = null;
	private String commandSQL="SELECT tag, MIN(opis) AS opis FROM produkty GROUP BY tag";
	
	public ResultSet selectMethod(Statement myStmt) throws SQLException {
		
		myRs=myStmt.executeQuery(commandSQL);
		int i=0;
		while (myRs.next()){
			productsTypes[i][0]=myRs.getString("tag");
			productsTypes[i][1]=myRs.getString("opis");
			log.debug(productsTypes[i][0]+": "+productsTypes[i][1]);
			i++;
		}
		return myRs;
	}

	public String[][] getProductsTypes() {
		return productsTypes;
	}
	
}
