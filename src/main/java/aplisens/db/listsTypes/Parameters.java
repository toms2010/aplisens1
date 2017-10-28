package aplisens.db.listsTypes;

public class Parameters {
	private String nazwa, wartosc;

	public Parameters(String nazwa, String wartosc) {
		this.nazwa = nazwa;
		this.wartosc = wartosc;
	}

	public String getNazwa() {
		return nazwa;
	}

	public String getWartosc() {
		return wartosc;
	}

	@Override
	public String toString() {
		return "Parametry urządzenia:  nazwa parametru: " + nazwa + ", wartosc=" + wartosc;
	}

}
