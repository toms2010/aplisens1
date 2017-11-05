package aplisens.db.listsTypes;

public class ProductType {

	private String tag, description;

	public ProductType(String tag, String description) {
		this.tag = tag;
		this.description = description;
	}

	public String getTag() {
		return tag;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Typ urządzenia:  tag: " + tag + ", opis: " + description+"\n";
	}

}
