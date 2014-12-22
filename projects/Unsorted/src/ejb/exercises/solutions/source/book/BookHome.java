package ejb.exercises.solutions.source.book;

import java.util.Collection;
import javax.ejb.EJBLocalHome;

public interface BookHome extends EJBLocalHome {
	Book create(String title, String author, double price);
	Book findByPrimaryKey(String bookTitle);
	Collection<Book> findAllBooks();
}
