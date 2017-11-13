package cs544.excercise05_1;

import javax.persistence.Entity;

@Entity
public class Book extends Product {

	public String title;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}

