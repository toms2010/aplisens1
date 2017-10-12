package toms.aplisens1;

import java.sql.*;

public abstract class Abstrakcyjna {
	
	ResultSet myRs = null;
	int indeks;
	private Object tablica1[][]= new Object[3][4];
	
	Object[][] getTablica1() {
		return tablica1;
	}

	abstract public void wyswietlProdukt(Statement myStmt, String grupa) throws SQLException;
	
	public void listaSQL (Statement myStmt,String polecenieSql) throws SQLException{
		try {
			myRs=myStmt.executeQuery(polecenieSql);
			int i=0;
			while (myRs.next()){
				tablica1[i][0]=myRs.getString("id_pr");
				tablica1[i][1]=myRs.getString("opis");
				tablica1[i][2]=myRs.getString("nazwa");
				System.out.println(tablica1[i][1]+": "+tablica1[i][2]);
				i++;
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
		}
	}
	
	public void parametrySQL (Statement myStmt,String wybr, String wybrStary) throws SQLException{
		String polecenieSql1="SELECT * FROM "+wybrStary;
		String polecenieSql2="SELECT * FROM parametry_"+wybrStary;
		try {
			myRs=myStmt.executeQuery(polecenieSql1);
			int i=0;
			while (myRs.next()){
				if (wybr.equals(myRs.getString("nazwa"))){
					indeks=myRs.getInt("id_pr");
					tablica1[0][i]=myRs.getString("opis");
					tablica1[1][i]=myRs.getString("nazwa");
					System.out.println(tablica1[0][i]+": "+tablica1[1][i]);
					i++;
				}	
			}
			myRs=myStmt.executeQuery(polecenieSql2);
			while (myRs.next()){
				if (indeks==myRs.getInt("id_pr")){
					tablica1[0][i]=myRs.getString("zakres_st");
					tablica1[1][i]=myRs.getString("sygnal_wy");
					System.out.println("Parametry:");
					System.out.println("zakres standardowy: "+ tablica1[0][i] + " sygnal_wy: " 
							+  tablica1[1][i]);
//					System.out.println("zakres standardowy: "+ myRs.getString("zakres_st") + " sygnal_wy: " 
//					+ myRs.getString("sygnal_wy"));
					
				}	
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
		}
	}
}
