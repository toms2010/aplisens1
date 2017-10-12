package toms.aplisens1;

import java.sql.*;

public class Main {
	public static void main(String args[])throws SQLException {

		String polecenieSql="SELECT * FROM produkty";
		
		BazaConect baza=new BazaConect();
		Statement myStmt=baza.connect();
		Window okienko = new Window();
		Ogolna abc=new Ogolna();
		abc.listaSQL(myStmt, polecenieSql);
		okienko.oknoTabeli(abc.getTablica1(),myStmt);

//		baza.rozlaczSql(myStmt);

	}
}



// konstruktory
/* funkcje:
 * -lista wszystkich urz�dzen z mozliwosci� wyszukiwania
 * - mozliwos� otworzenia pliku z baz� danych
 * - mozliwosc dodawania nowcyh produkt�w
 * */

