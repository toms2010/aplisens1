package aplisens.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parametry_SG")
public class ProductParametersSG {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_parametry")
	private int id;

	@Column(name = "nazwa")
	private String name;

	@Column(name = "wartosc")
	private String value;

	@Column(name = "wystepowanie")
	private String temp;
	
	public ProductParametersSG() {
	}

	public ProductParametersSG(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "ProductParametersSG [id=" + id + ", name=" + name + ", value=" + value + "]";
	}

}
