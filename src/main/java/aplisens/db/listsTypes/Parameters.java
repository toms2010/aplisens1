package aplisens.db.listsTypes;

public class Parameters {
	private String nazwa;
	private String wartosc;

	
	public Parameters(String nazwa, String wartosc) {
		this.wartosc = wartosc;
		this.nazwa = nazwa;
	}

	
	
	public String getNazwa() {
		return nazwa;
	}



	public String getWartosc() {
		return wartosc;
	}



	@Override
	public String toString() {
		return "Parameters [nazwa=" + nazwa + ", wartosc=" + wartosc + "]";
	}


}
