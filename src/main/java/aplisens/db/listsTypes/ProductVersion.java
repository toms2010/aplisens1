package aplisens.db.listsTypes;

public class ProductVersion {
	private float price;
	private String name, description;
	private boolean order;

	public ProductVersion(String name, String description, float price, boolean order) {
		this.price = price;
		this.name = name;
		this.description = description;
		this.order = order;
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

	public boolean isOrder() {
		return order;
	}
	
	public void setOrder(boolean order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Wersje produktu:   nazwa: " + name + ", opis=" + description + ", cena:" + price + " zł, order=" + order;
	}



}
