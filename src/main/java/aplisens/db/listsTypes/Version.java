package aplisens.db.listsTypes;

public class Version {
	private float cena;
	private String nazwa, opis;
	private boolean order;

	public Version(String nazwa, String opis, float cena, boolean order) {
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
	
	public void setOrder(boolean order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Wersje produktu:   nazwa: " + nazwa + ", opis=" + opis + ", cena:" + cena + " zł, order=" + order;
	}



}
