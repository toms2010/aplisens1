package aplisens.db.listsTypes;

public class ProductModel {
	private String name, description;
	private float price;

	public ProductModel(String name, String description, float price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Model produktu:  \n nazwa: " + name + ", \n opis: " + description + ", \n cena: " + price + " zł \n";
	}

}
