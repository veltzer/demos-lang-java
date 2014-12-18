/*
 * Created on Feb 24, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package daos;

import javax.sql.DataSource;


/**
 * A factory for obtaining bookstore DAO's.  <br>
 * Current implementation simply returns a DAO implementation which
 * relies on sql92.
 */
public class BookstoreDaoFactory {
	public static BookstoreDAO getDAO(DataSource dataSource){
		return new SQL92BookstoreDAO(dataSource);
	}
}
