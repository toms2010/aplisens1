package aplisens.db;

import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbAdress {

	private final Logger log = LoggerFactory.getLogger(getClass());
	private String dbUrl;
	private String user;
	private String pass;
	File file;
	RandomAccessFile raf = null;

	DbAdress getDbAdress(String fileName) {

		file = new File(fileName);

		try {
			raf = new RandomAccessFile(file, "r");
		} catch (FileNotFoundException e) {
			log.error("Brak pliku!: " + fileName);
		}

		try {
			this.dbUrl = raf.readLine();
			this.user = raf.readLine();
			this.pass = raf.readLine();
		} catch (IOException e) {
			log.error("Błąd wczytywania pliku: " + fileName);
		}

		checkRead();
		return new DbAdress();
	}

	private void checkRead() {
		if (this.dbUrl.length() < 1 | this.user.length() < 1) {
			throw new RuntimeException("Nie udało się odczytać adresu bazy lub nazwy użytkownika z pliku");
		}
	}

	@Override
	public String toString() {
		return "Adres bazy danych: [dbUrl=" + dbUrl + ", user=" + user + ", pass=" + pass + "]";
	}

	String getDbUrl() {
		return dbUrl;
	}

	String getUser() {
		return user;
	}

	String getPass() {
		return pass;
	}
}
