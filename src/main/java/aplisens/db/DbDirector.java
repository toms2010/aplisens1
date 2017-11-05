package aplisens.db;

import java.sql.Statement;

import aplisens.db.read.ProductModelSelect;
import aplisens.db.read.ProductVersionsSelect;
import aplisens.db.read.ProductParametersSelect;
import aplisens.db.read.ProductTypeSelect;
import aplisens.db.read.ReadFromDb;

public class DbDirector {
	private static final String FILE_NAME = "src/main/resources/baza.txt";

	private DbAdress adress = new DbAdress();
	private DbConnect connect = new DbConnect();
	private Statement myStmt;
	private ReadFromDb read = new ReadFromDb();

	private ProductTypeSelect type = new ProductTypeSelect();
	private ProductModelSelect model = new ProductModelSelect();
	private ProductParametersSelect parameters = new ProductParametersSelect();
	private ProductVersionsSelect versions = new ProductVersionsSelect();

	public DbDirector() {
		adress.getDbAdress(FILE_NAME);
	}

	public ProductTypeSelect readType() {
		myStmt = connect.getStatement(adress);
		read.readFromDb(myStmt, type);
		connect.dbDisconnect(myStmt);
		return type;
	}

	public ProductModelSelect readModel() {
		myStmt = connect.getStatement(adress);
		read.readFromDb(myStmt, model);
		connect.dbDisconnect(myStmt);
		return model;
	}

	public ProductParametersSelect readParameters() {
		myStmt = connect.getStatement(adress);
		read.readFromDb(myStmt, parameters);
		connect.dbDisconnect(myStmt);
		return parameters;
	}

	public ProductVersionsSelect readVersion() {
		myStmt = connect.getStatement(adress);
		read.readFromDb(myStmt, versions);
		connect.dbDisconnect(myStmt);
		return versions;
	}
}
