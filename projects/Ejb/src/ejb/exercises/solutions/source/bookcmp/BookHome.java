package ejb.exercises.solutions.source.bookcmp;

import javax.ejb.EJBLocalHome;

public interface BookHome extends EJBLocalHome {
	Book create(String title, String author, double price);

	Book findByPrimaryKey(String bookTitle);
}
