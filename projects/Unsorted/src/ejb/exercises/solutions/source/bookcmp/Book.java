package ejb.exercises.solutions.source.bookcmp;

import javax.ejb.*;

public interface Book extends EJBLocalObject {
	public String getTitle();
	public String getAuthor();
	public void setAuthor(String author);
	public double getPrice();
	public void setPrice(double price);
}
