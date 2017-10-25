package aplisens.db.listsTypes;

public class Model {
	private float cena;
	private String nazwa, dokOpis;
	
	public Model(float cena, String nazwa, String dokOpis) {
		this.cena = cena;
		this.nazwa = nazwa;
		this.dokOpis = dokOpis;
	}

	
	public float getCena() {
		return cena;
	}


	public String getNazwa() {
		return nazwa;
	}


	public String getDokOpis() {
		return dokOpis;
	}


	@Override
	public String toString() {
		return "Model Produktu  [cena=" + cena + "zł , nazwa=" + nazwa + ", dokOpis=" + dokOpis + "]";
	}
	
	

}
