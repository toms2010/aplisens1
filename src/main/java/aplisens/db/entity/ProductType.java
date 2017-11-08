package aplisens.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produkty")
public class ProductType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pr")
	private int id;

	@Column(name = "tag")
	private String tag;

	@Column(name = "opis")
	private String description;
	
	public ProductType() {
	}

	public ProductType(String tag, String description) {
		this.tag = tag;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getTag() {
		return tag;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "ProductType [id=" + id + ", tag=" + tag + ", description=" + description + "]";
	}

}
