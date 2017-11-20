package cs544.excercise03_2.part5;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cs544.excercise03_2.part2.Publisher;
@Entity
public class Book1 {
@Id
@GeneratedValue
private int id;
private String title;
//@Column(nullable=false)
private String ISBN;
private String author;
private double price;
private java.util.Date publish_date;
@OneToMany(mappedBy="book")
private List<Reservation1> reservations;


@Override
public String toString() {
	return "Book [title=" + title + ", ISBN=" + ISBN + ", author=" + author + ", price=" + price + ", publish_date="
			+ publish_date + "]";
}
public Book1(String title, String iSBN, String author, double price, Date publish_date) {
	super();
	
	this.title = title;
	ISBN = iSBN;
	this.author = author;
	this.price = price;
	this.publish_date = publish_date;
}
Book1(){
	
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getISBN() {
	return ISBN;
}
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public java.util.Date getPublish_date() {
	return publish_date;
}
public void setPublish_date(java.util.Date publish_date) {
	this.publish_date = publish_date;
}

}
