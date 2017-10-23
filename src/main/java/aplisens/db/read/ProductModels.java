package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductModels implements ListsInterface {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	private ResultSet myRs = null;
	private String productsModels[][]= new String[10][3];
	private String productType="PC";
	private String commandSQL="SELECT nazwa, opis, cena , dok_opis FROM produkty WHERE tag LIKE '"+productType+"'";
	
	public ResultSet selectMethod(Statement myStmt) throws SQLException {
		myRs=myStmt.executeQuery(commandSQL);
		int i=0;
		while (myRs.next()){
			productsModels[i][0]=myRs.getString("nazwa");
			productsModels[i][1]=myRs.getString("dok_opis");
			productsModels[i][2]=myRs.getString("cena");
			log.debug(productsModels[i][0]+": "+productsModels[i][1]+" cena: "+productsModels[i][2]);
			i++;
		}
		return myRs;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String[][] getProductsModels() {
		return productsModels;
	}
	
	
}
