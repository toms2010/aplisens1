package aplisens.db;

import java.sql.Statement;

import aplisens.db.read.ProductModels;
import aplisens.db.read.ProductSpecialVersions;
import aplisens.db.read.ProductStandardParameters;
import aplisens.db.read.ProductType;
import aplisens.db.read.Read;
import toms.aplisens1.Logic;

public class DbDirector {
	// pomyśleć nad tą klasą

	private String fileName = "src/main/resources/baza.txt";

	DbAdress adress = new DbAdress();
	DbConnect connect = new DbConnect();
	Statement myStmt;

	Read reading = new Read();
	ProductType type = new ProductType();
	ProductModels models = new ProductModels();
	ProductStandardParameters parameters = new ProductStandardParameters();
	ProductSpecialVersions version = new ProductSpecialVersions();
	Logic logic = new Logic();

	// public void połączenie() {
	// adress.read(fileName);
	// myStmt=connect.connect(adress);
	// }

	public ProductType odczytType() {
		adress.getDbAdress(fileName);
		myStmt = connect.getStatement(adress);
		reading.read(myStmt, type, logic.getTags());
		connect.dbDisconnecting(myStmt);
		return type;
	}

	public ProductModels odczytModel() {
		reading.read(myStmt, models, logic.getTags());
		return models;
	}

	public ProductStandardParameters odczytParameters() {
		reading.read(myStmt, parameters, logic.getTags());
		return parameters;
	}

	public ProductSpecialVersions odczytVersion() {
		reading.read(myStmt, version, logic.getTags());
		return version;
	}

	// public void rozlacz() {
	// connect.dbDisconnect(myStmt);
	// }
}
