package cs544.excercise05_1;

import javax.persistence.Entity;

@Entity
public class DVD extends Product{

	public String genre;
	
	public DVD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DVD(String genre) {
		super();
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
