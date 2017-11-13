package cs544.excercise05_1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

	@Id
	@GeneratedValue
	int id;
	String name;
	String description;
	
	public Product() {
		super();
	}

	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + " ProductType: " + this.getClass().getSimpleName() + "]";
	}

}
