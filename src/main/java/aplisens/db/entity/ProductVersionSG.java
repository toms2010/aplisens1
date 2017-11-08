package aplisens.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wykonania_SG")
public class ProductVersionSG {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_parametry")
	private int id;

	@Column(name = "nazwa")
	private String name;

	@Column(name = "opis")
	private String description;

	@Column(name = "cena")
	private float price;
	
	@Column(name = "wystepowanie")
	private String temp;


	public ProductVersionSG() {
	}

	public ProductVersionSG(String name, String description, float price) {
		this.price = price;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
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
		return "ProductVersionSG [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ "]";
	}

}
