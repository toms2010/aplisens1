package aplisens.db;

import java.sql.Statement;

import aplisens.db.read.ProductModelSelect;
import aplisens.db.read.ProducVersionsSelect;
import aplisens.db.read.ProductParametersSelect;
import aplisens.db.read.ProductTypeSelect;
import aplisens.db.read.ReadFromDb;

public class DbDirector {
	private static final String FILE_NAME = "src/main/resources/baza.txt";

	DbAdress adress = new DbAdress();
	DbConnect connect = new DbConnect();
	Statement myStmt;
	ReadFromDb read = new ReadFromDb();

	ProductTypeSelect type = new ProductTypeSelect();
	ProductModelSelect models = new ProductModelSelect();
	ProductParametersSelect parameters = new ProductParametersSelect();
	ProducVersionsSelect version = new ProducVersionsSelect();

	public DbDirector() {
		adress.getDbAdress(FILE_NAME);
	}

	public ProductTypeSelect odczytType() {
		myStmt = connect.getStatement(adress);
		read.readFromDb(myStmt, type);
		connect.dbDisconnecting(myStmt);
		return type;
	}

	public ProductModelSelect odczytModel() {
		myStmt = connect.getStatement(adress);
		read.readFromDb(myStmt, models);
		connect.dbDisconnecting(myStmt);
		return models;
	}

	public ProductParametersSelect odczytParameters() {
		myStmt = connect.getStatement(adress);
		read.readFromDb(myStmt, parameters);
		connect.dbDisconnecting(myStmt);
		return parameters;
	}

	public ProducVersionsSelect odczytVersion() {
		myStmt = connect.getStatement(adress);
		read.readFromDb(myStmt, version);
		connect.dbDisconnecting(myStmt);
		return version;
	}
}
