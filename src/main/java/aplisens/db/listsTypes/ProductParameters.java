package aplisens.db.listsTypes;

public class ProductParameters {
	private String name, value;

	public ProductParameters(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Parametry urządzenia:  nazwa parametru: " + name + ", wartosc=" + value+"\n";
	}

}
