package toms.aplisens1;

import java.sql.*;

public class Produkt extends Abstrakcyjna{
	
	ResultSet myRs = null;
	String wybr;
	int indeks;
	
	
	public void wyswietlProdukt(Statement myStmt, String grupa) throws SQLException{
		
		String polecenieSQL="SELECT * FROM "+grupa;
		System.out.println("Lista "+grupa+": ");
		listaSQL(myStmt, polecenieSQL);
	}
}
