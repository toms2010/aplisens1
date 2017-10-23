package aplisens.db.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductSpecialVersions implements  ListsInterface{

	protected final Logger log = LoggerFactory.getLogger(getClass());
	private ResultSet myRs = null;
	private String productStandard[][]= new String[10][3];
	private String productType="PC";
	private String productModel="PC28";
	private String commandSQL="select nazwa, cena, opis FROM wykonania_"
			+productType+" WHERE wystepowanie LIKE '%"
			+productModel+"%'";
	
	public ResultSet selectMethod(Statement myStmt) throws SQLException {
		myRs=myStmt.executeQuery(commandSQL);
		int i=0;
		while (myRs.next()){
			productStandard[i][0]=myRs.getString("nazwa");
			productStandard[i][1]=myRs.getString("cena");
			productStandard[i][2]=myRs.getString("opis");
			log.debug(productStandard[i][0]+": "+productStandard[i][1]);
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
	
	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String[][] getProductStandard() {
		return productStandard;
	}
	
}
