package aplisens.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produkty")
public class ProductModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pr")
	private int id;

	@Column(name = "nazwa")
	private String name;

	@Column(name = "dok_opis")
	private String description;

	@Column(name = "cena")
	private float price;
	
	public ProductModel() {
	}

	public ProductModel(String name, String description, float price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
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
		return "ProductModel [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
}
