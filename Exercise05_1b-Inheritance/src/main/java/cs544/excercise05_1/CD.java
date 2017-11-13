package cs544.excercise05_1;

import javax.persistence.Entity;

@Entity
public class CD extends Product{
	
	public String artist;

	public CD() {
		// TODO Auto-generated constructor stub
	}
	

	public CD(String name, String description, String artist) {
		super(name, description);
		this.artist = artist;
	}
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}


	@Override
	public String toString() {
		return "CD [artist=" + artist + ", id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	

}
