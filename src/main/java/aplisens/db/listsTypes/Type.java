package aplisens.db.listsTypes;

public class Type {

	private String tag, opis;

	public Type(String tag, String opis) {
		this.tag = tag;
		this.opis = opis;
	}

	public String getTag() {
		return tag;
	}

	public String getOpis() {
		return opis;
	}

	@Override
	public String toString() {
		return "Typ urządzenia:  tag: " + tag + ", opis: " + opis;
	}

}
