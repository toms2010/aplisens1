package aplisens.db.listsTypes;

public class Model {
	private String nazwa, dokOpis;
	private float cena;

	public Model(String nazwa, String dokOpis, float cena) {
		this.nazwa = nazwa;
		this.dokOpis = dokOpis;
		this.cena = cena;
	}

	public String getNazwa() {
		return nazwa;
	}

	public String getDokOpis() {
		return dokOpis;
	}

	public float getCena() {
		return cena;
	}

	@Override
	public String toString() {
		return "Model produktu:  nazwa: " + nazwa + ", opis: " + dokOpis + ", cena: " + cena + " zł";
	}

}
