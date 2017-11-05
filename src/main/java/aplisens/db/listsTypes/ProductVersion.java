package aplisens.db.listsTypes;

public class ProductVersion {
	private float price;
	private String name, description;

	public ProductVersion(String name, String description, float price) {
		this.price = price;
		this.name = name;
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Wersje produktu:   nazwa: " + name + ", opis=" + description + ", cena:" + price + " zł, \n";
	}



}
