package toms.aplisens1;

import java.sql.*;
import aplisens.db.DbDirector;

public class Main {
	public static void main(String args[])throws SQLException {

		DbDirector myStmt= new DbDirector();
		myStmt.odczyt();
	}
}



// konstruktory
/* funkcje:
 * -lista wszystkich urz�dzen z mozliwosci� wyszukiwania
 * - mozliwos� otworzenia pliku z baz� danych
 * - mozliwosc dodawania nowcyh produkt�w
 * */
//	cos tam
