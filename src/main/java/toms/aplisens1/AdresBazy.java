package toms.aplisens1;

import java.io.*;

public class AdresBazy {
	
	private String dbUrl;
	private String user;		
	private String pass;
	private String nazwaPliku="baza.txt";
	
	String getDbUrl() {
		return dbUrl;
	}

	String getUser() {
		return user;
	}

	String getPass() {
		return pass;
	}
	
	String getNazwaPliku() {
		return nazwaPliku;
	}

	void setNazwaPliku(String nazwaPliku) {
		this.nazwaPliku = nazwaPliku;
	}

// Wczytaj adres bazy z pliku podanego domy�lny	
	public AdresBazy wczytaj(){
		File file= new File(nazwaPliku);
		RandomAccessFile raf=null;
		try{
			raf = new RandomAccessFile(file, "r");		
			}
		catch(FileNotFoundException e){
			System.out.println("Brak pliku!: "+nazwaPliku);
			}
		AdresBazy adres= new AdresBazy();
		try{
			this.dbUrl=raf.readLine();
			this.user=raf.readLine();
			this.pass=raf.readLine();
			}
		catch(IOException e){
			System.out.println("Błąd wczytywania pliku: "+file);
			}
		sprawdz();
		System.out.println("Łączenie z bazą (adres): "+ this.dbUrl+ "\nUser: "+ this.user+ "\nPass: "+this.pass+ "\n");
		return adres;
	}	
	
// Wczytaj adres bazy z pliku podanego z zewn�trz	
	public AdresBazy wczytaj(String nazwa){
		
		File file= new File(nazwa);
		RandomAccessFile raf=null;
		try{
			raf = new RandomAccessFile(file, "r");		
			}
		catch(FileNotFoundException e){
			System.out.println("Brak pliku!: "+nazwa);
			}
		AdresBazy adres= new AdresBazy();
		try{
			this.dbUrl=raf.readLine();
			this.user=raf.readLine();
			this.pass=raf.readLine();
			}
		catch(IOException e){
			System.out.println("Błąd wczytywania pliku: "+file);
			}
		sprawdz();
		System.out.println("łączenie z bazą (adres): "+ this.dbUrl+ "\nUser: "+ this.user+ "\nPass: "+this.pass+ "\n");
		return adres;
	}
	
	public void sprawdz(){
		if (this.dbUrl.length()<1 | this.user.length()<1){
			throw new RuntimeException("Nie udało się odczytać adresu bazy lub nazwy użytkownika z pliku");
		}
	}
}

// fajnie jakby metoda sprawdz nie konczy�a dzia�ania aplikacji tylko wyswietla�a w oknie oplikacji to informacje

// 3 wersja ktora zwraca�a by obiekt klasy AdresBazy 
