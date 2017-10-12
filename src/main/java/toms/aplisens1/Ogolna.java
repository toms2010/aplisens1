package toms.aplisens1;

import java.sql.*;

public class Ogolna extends Abstrakcyjna{

	ResultSet myRs = null;
	String wybr;
	String grupa="produkty";
	
	public void wyswietlProdukt(Statement myStmt, String grupa) throws SQLException{
		String grupa1="produkty";
		System.out.println("Lista produktów: ");
		String polecenieSql="SELECT * FROM "+grupa1;
		listaSQL(myStmt, polecenieSql);
	}
	
}
