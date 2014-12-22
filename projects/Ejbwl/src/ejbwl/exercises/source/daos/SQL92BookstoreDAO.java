package ejbwl.exercises.source.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import ejbwl.exercises.solutions.source.dtos.CustomerDTO;
import ejbwl.exercises.source.dtos.BookDTO;
import ejbwl.exercises.source.dtos.OrderDetailsDTO;


/**
 * A simple SQL implementation of BookstoreDAO. <br>
 *
 * For more information, please refer to the documentation of
 * interface BookstoreDAO.
 */
public class SQL92BookstoreDAO implements BookstoreDAO {

	/** This dao will obtain DB connections from this pool */
	private DataSource datasource;

	/** Book record: title, author, price */
	private String insertBookSql = "insert into BOOKS values(?,?,?)";

	/** Customer record: id, name, email, address */
	private String insertCustomerSql = "insert into CUSTOMERS values(?,?,?,?)";

	/** Order details : orderId, timestamp , customerId*/
	private String insertOrderSql = "insert into ORDERS values(?,?,?)";

	/** order-item: orderId, bookTitle */
	private String insertOrderItemSql = "insert into ORDER_ITEMS values(?,?)";

	/** select all books in inventory */
	private String selectBooksSql = "select * from BOOKS";

	/** select all customers in inventory */
	private String selectCustomersSql = "select * from CUSTOMERS";

	/** Select book by its title */
	private String selectBookByTitleSql = "select * from BOOKS where TITLE=?";

	/** Select customer by id */
	private String selectCustomerByIdSql = "select * from CUSTOMERS where ID=?";

	/** Select orders by orderId */
	private String selectOrdersById = "select * from ORDERS where ID=?";

	/** Select items by orderId */
	private String selectItemsByOrder = "select * from ORDER_ITEMS where ORDER_ID=?";

	/** delete order by orderId */
	private String deleteOrder = "delete from ORDERS where ID=?";

	/** delete orderItems by orderId */
	private String deleteOrderItems = "delete from ORDER_ITEMS where ORDER_ID=?";

	/**
	 * Constructs a DAO that would use the given datasource.
	 */
	public SQL92BookstoreDAO(DataSource idatasource) {
		datasource = idatasource;
	}

	public void insertBook(String title, String author, double price) {
		Connection con = null;
		try {
			con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(insertBookSql);
			stmt.setString(1, title);
			stmt.setString(2, author);
			stmt.setDouble(3, price);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public List<BookDTO> selectBooks() {
		Connection con = null;
		try {
			con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(selectBooksSql);
			ResultSet rs = stmt.executeQuery();
			List<BookDTO> books = new LinkedList<BookDTO>();
			while (rs.next()) {
				BookDTO book = new BookDTO(
					rs.getString("TITLE"), rs.getString("AUTHOR"),
					rs.getDouble("PRICE"));
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void insertCustomer(String id, String name, String email, String address) {
		Connection con = null;
		try {
			con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(insertCustomerSql);
			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.setString(3, email);
			stmt.setString(4, address);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public List<CustomerDTO> selectCustomers() {
		Connection con = null;
		try {
			con = datasource.getConnection();
			List<CustomerDTO> customers = new LinkedList<CustomerDTO>();
			PreparedStatement stmt = con.prepareStatement(selectCustomersSql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				CustomerDTO cust = new CustomerDTO(
					rs.getString("ID"), rs.getString("NAME"),
					rs.getString("EMAIL"), rs.getString("ADDRESS"));
				customers.add(cust);
			}
			return customers;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void insertOrder(String orderId, String customerId, long timestamp, List<String> bookTitles) {
		Connection con = null;
		try {
			con = datasource.getConnection();

			// Insert order information:
			PreparedStatement orderStmt = con.prepareStatement(insertOrderSql);
			orderStmt.setString(1, orderId);
			orderStmt.setLong(2, timestamp);
			orderStmt.setString(3, customerId);
			orderStmt.executeUpdate();

			// Insert order items:
			PreparedStatement itemStmt = con.prepareStatement(insertOrderItemSql);
			itemStmt.setString(1, orderId);
			for (Iterator<String> it = bookTitles.iterator(); it.hasNext();) {
				String title = it.next();
				itemStmt.setString(2, title);
				itemStmt.executeUpdate();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}


	public OrderDetailsDTO selectOrder(String orderId) {
		Connection con = null;
		try {
			con = datasource.getConnection();
			OrderDetailsDTO order = new OrderDetailsDTO();

			// Get order information (id, customerId, timestamp):
			PreparedStatement orderStmt = con.prepareStatement(selectOrdersById);
			orderStmt.setString(1, orderId);
			ResultSet orderRs = orderStmt.executeQuery();
			if (!orderRs.next()) {
				return null;
			}
			order.setId(orderRs.getString("ID"));
			order.setCustomerId(orderRs.getString("CUSTOMER_ID"));
			order.setTimestamp(orderRs.getLong("ORDER_TIME"));

			// Get items for this order:
			List<String> bookTitles = new LinkedList<String>();
			PreparedStatement itemStmt = con.prepareStatement(selectItemsByOrder);
			itemStmt.setString(1, orderId);
			ResultSet itemsRs = itemStmt.executeQuery();
			while (itemsRs.next()) {
				String title = itemsRs.getString("BOOK_TITLE");
				bookTitles.add(title);
			}
			order.setBookTitles(bookTitles);
			return order;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public BookDTO selectBook(String title) {
		Connection con = null;
		try {
			con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(selectBookByTitleSql);
			stmt.setString(1, title);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()) {
				return null;
			}
			BookDTO book = new BookDTO(
				rs.getString("TITLE"), rs.getString("AUTHOR"),
				rs.getDouble("PRICE"));
			return book;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public CustomerDTO selectCustomer(String customerId) {
		Connection con = null;
		try {
			con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(selectCustomerByIdSql);
			stmt.setString(1, customerId);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()) {
				return null;
			}
			CustomerDTO customer = new CustomerDTO(
				rs.getString("ID"), rs.getString("NAME"),
				rs.getString("EMAIL"), rs.getString("ADDRESS"));
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public boolean cancelOrder(String orderId) {
		Connection con = null;
		int count;
		try {
			con = datasource.getConnection();

			// Delete order (return false if record not found):
			PreparedStatement stmt = con.prepareStatement(deleteOrder);
			stmt.setString(1, orderId);
			count = stmt.executeUpdate();
			if (count == 0) {
				return false;
			}

			// Cascade-delete:
			stmt = con.prepareStatement(deleteOrderItems);
			stmt.setString(1, orderId);
			count = stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
