package toms.aplisens1;

import java.sql.*;
import aplisens.db.DbDirector;

public class Main {
	public static void main(String args[])throws SQLException {

		DbDirector myStmt= new DbDirector();
		Window w = new Window();
//		myStmt.połączenie();
		myStmt.odczytType();
//		myStmt.odczytModel();
//		myStmt.odczytParameters();
//		myStmt.odczytVersion();

		w.oknoTabeli(null, null);
	}
}



// konstruktory
/* funkcje:
 * -lista wszystkich urz�dzen z mozliwosci� wyszukiwania
 * - mozliwos� otworzenia pliku z baz� danych
 * - mozliwosc dodawania nowcyh produkt�w
 * */
//	cos tam
