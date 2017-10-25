package aplisens.db.listsTypes;

public class Version {
	private float cena;
	private String nazwa,opis;
	private boolean order;
	
	public Version(float cena, String nazwa, String opis, boolean order) {
		this.cena = cena;
		this.nazwa = nazwa;
		this.opis = opis;
		this.order = order;
	}

	
	public float getCena() {
		return cena;
	}



	public String getNazwa() {
		return nazwa;
	}



	public String getOpis() {
		return opis;
	}



	public boolean isOrder() {
		return order;
	}



	@Override
	public String toString() {
		return "Product version  [cena=" + cena + ", nazwa=" + nazwa + ", opis=" + opis + ", order=" + order + "]";
	}

	public void setOrder(boolean order) {
		this.order = order;
	}
	

}
