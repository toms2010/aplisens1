package toms.aplisens1;

import java.sql.*;

public class BazaConect {
	
	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
	private String adres="baza.txt";
	
	
	String getAdres() {
		return adres;
	}

	void setAdres(String adres) {
		this.adres = adres;
	}

	// ��czenie z baz� (argumenty z zewn�trz)
	public Statement connect (String dbUrl, String user, String pass){
		try {
			myConn=DriverManager.getConnection(dbUrl, user, pass);
			myStmt=myConn.createStatement();
		}
		catch (SQLException exc){
			System.out.println("Błąd połączenia z bazą SQL");
		}
		return myStmt;
	}
	
// ��czenie z baz� (argumenty z pliku)
	public Statement connect () {
		AdresBazy plik = new AdresBazy();
		plik.wczytaj(adres);
		try {
			myConn=DriverManager.getConnection(plik.getDbUrl(), plik.getUser(), plik.getUser());
			myStmt=myConn.createStatement();
		}
		catch (SQLException exc){
			System.out.println("Błąd połczenia z bazą SQL");
		}
		return myStmt;
	}

	// Roz��cz z baz�
	public void rozlaczSql(Statement myStmt) throws SQLException{
		if (myStmt != null) {
			myStmt.close();
		}
		if (myConn != null) {
			myConn.close();
		}
	}
	
}


