package ejbwl.exercises.solutions.source.book;

import java.util.Collection;

import javax.ejb.EJBLocalHome;

import ejbwl.exercises.solutions.source.dtos.BookDTO;

public interface BookHome extends EJBLocalHome {
	Book create(String title, String author, double price);
	Book findByPrimaryKey(String bookTitle);
	Collection<BookDTO> findAllBooks();
}
