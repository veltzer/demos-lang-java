package ejb.exercises.solutions.source.book;

import javax.ejb.EJBLocalObject;

public interface Book extends EJBLocalObject {
	String getTitle();

	String getAuthor();

	void setAuthor(String author);

	double getPrice();

	void setPrice(double price);
}
