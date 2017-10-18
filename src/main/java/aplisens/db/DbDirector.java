package aplisens.db;

import java.sql.Statement;

import aplisens.db.read.ProductModels;
import aplisens.db.read.ProductSpecialVersions;
import aplisens.db.read.ProductStandardParameters;
import aplisens.db.read.ProductType;
import aplisens.db.read.Read;

public class DbDirector{
	
	private String fileName="baza.txt";
	
	DbAdress adress = new DbAdress();
	DbConnect connect = new DbConnect();
	Statement myStmt;
	
	Read czytanko= new Read();	
	ProductType cos= new ProductType();
	ProductModels cos1= new ProductModels();
	ProductStandardParameters cos2= new ProductStandardParameters();
	ProductSpecialVersions cos3= new ProductSpecialVersions();
	
	public void odczyt(){
		adress.read(fileName);
		System.out.println(adress.toString()); 
		myStmt=connect.connect(adress);
		
		czytanko.read(myStmt, cos);	
		czytanko.read(myStmt, cos1);		
		czytanko.read(myStmt, cos2);
		czytanko.read(myStmt, cos3);	
		
		connect.dbDisconnect(myStmt);
	}
}
