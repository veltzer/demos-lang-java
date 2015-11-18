package ejb.exercises.exercises.source.bookstore;

/**
 * Bean implementation class for Enterprise Bean: BookstoreAdmin (For details,
 * please consult the documentation of mehtods)
 */
public class BookstoreAdminBean {
	public void ejbCreate() {
		// initialize the DAO here as this method is called when the bean
		// instance is created. Use JNDI lookup to find the Datasource and
		// use the method BookstoreDaoFactory.getDAO(DataSource ds)
	}
}
