package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductModels implements ListsInterface {
	
	private ResultSet myRs = null;
	private String productsModels[][]= new String[10][3];
	private String productType="PC";
	
	String getProductType() {
		return productType;
	}

	void setProductType(String productType) {
		this.productType = productType;
	}

	private String commandSQL="SELECT nazwa, opis, cena , dok_opis FROM produkty WHERE tag LIKE '"+productType+"'";
	
	public ResultSet selectMethod(Statement myStmt) throws SQLException {
		myRs=myStmt.executeQuery(commandSQL);
		int i=0;
		while (myRs.next()){
			productsModels[i][0]=myRs.getString("nazwa");
			productsModels[i][1]=myRs.getString("dok_opis");
			productsModels[i][2]=myRs.getString("cena");
			System.out.println(productsModels[i][0]+": "+productsModels[i][1]+" cena: "+productsModels[i][2]);
			i++;
		}
		return myRs;
	}
}
