package ejbwl.exercises.solutions.source.book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.ObjectNotFoundException;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ejbwl.exercises.solutions.source.daos.BookstoreDAO;
import ejbwl.exercises.solutions.source.daos.BookstoreDaoFactory;
import ejbwl.exercises.solutions.source.dtos.BookDTO;

@SuppressWarnings("serial")
public class BookBean implements EntityBean {
	private double price;
	private String author;
	private String title;
	private BookstoreDAO dao;
	private EntityContext ctx;

	public void setEntityContext(EntityContext ictx) {
		ctx = ictx;
		try {
			InitialContext nctx = new InitialContext();
			DataSource dataSource =
				(DataSource) nctx.lookup("java:comp/env/jdbc/MyDS");
			dao = BookstoreDaoFactory.getDAO(dataSource);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void unsetEntityContext() {
		ctx = null;
	}

	public String ejbCreate(String ititle, String iauthor, double iprice) {
		dao.insertBook(ititle, iauthor, iprice);
		setTitle(ititle);
		setAuthor(iauthor);
		setPrice(iprice);
		return title;
	}

	public void ejbPostCreate(String ititle, String iauthor, double iprice) {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void ejbRemove() {
		dao.deleteBook((String) ctx.getPrimaryKey());
	}

	public void ejbLoad() {
		BookDTO book = dao.selectBook((String) ctx.getPrimaryKey());
		setTitle(book.getTitle());
		setAuthor(book.getAuthor());
		setPrice(book.getPrice());
	}

	public void ejbStore() {
		dao.updateBook(getTitle(), getAuthor(), getPrice());
	}

	public String ejbFindByPrimaryKey(String ititle) {
		if (dao.selectBook(ititle) != null) {
			return ititle;
		}
		throw new RuntimeException(new ObjectNotFoundException("Cannot find PK"));
	}

	public Collection<String> ejbFindAllBooks() {
		List<BookDTO> books = dao.selectBooks();
		Collection<String> result = new ArrayList<String>();
		Iterator<BookDTO> it = books.iterator();
		while (it.hasNext()) {
			BookDTO book = (BookDTO) it.next();
			result.add(book.getTitle());
		}
		return result;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String ititle) {
		title = ititle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String iauthor) {
		author = iauthor;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double iprice) {
		price = iprice;
	}

}
