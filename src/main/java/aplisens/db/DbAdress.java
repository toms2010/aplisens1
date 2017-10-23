package aplisens.db;

import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbAdress {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	private String dbUrl;
	private String user;		
	private String pass;
	private File file;
	
	String getDbUrl() {
		return dbUrl;
	}
	String getUser() {
		return user;
	}
	String getPass() {
		return pass;
	}	
	
	
	public DbAdress read(String fileName) {
		
		file= new File(fileName);
		RandomAccessFile raf=null;

		try {
			raf = new RandomAccessFile(file, "r");		
			}
		catch(FileNotFoundException e) {
			log.error("Brak pliku!: "+fileName);
			}
		
		try {
			this.dbUrl=raf.readLine();
			this.user=raf.readLine();
			this.pass=raf.readLine();
			}
		catch(IOException e) {
			log.error("Błąd wczytywania pliku: "+fileName);
			}
		
		checkRead();
		return new DbAdress();
	}
	
	
	public void checkRead() {
		if (this.dbUrl.length()<1 | this.user.length()<1) {
			throw new RuntimeException("Nie udało się odczytać adresu bazy lub nazwy użytkownika z pliku");
		}
	}

	@Override
	public String toString() {
		return "DbAdress [dbUrl=" + dbUrl + ", user=" + user + ", pass=" + pass + "]";
	}
	
	
}


