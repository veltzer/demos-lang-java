package ejb_exercises.exercises.source.bookstore;

import javax.ejb.CreateException;
//import daos.BookstoreDAO;

/**
 * Bean implementation class for Enterprise Bean: BookstoreAdmin
 * (For details, please consult the documentation of mehtods)
 */
public class BookstoreAdminBean
{
	//declare a class member
	//private BookstoreDAO dao = null;

	public void ejbCreate() throws CreateException {
		//initialize the DAO here as this method is called when the bean
		//instance is created. Use JNDI lookup to find the Datasource and
		//use the method BookstoreDaoFactory.getDAO(DataSource ds)
	}
}
