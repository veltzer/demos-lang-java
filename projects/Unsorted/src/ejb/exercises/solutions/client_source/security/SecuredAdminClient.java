package ejb.exercises.solutions.client_source.security;

//import java.security.*;
//import java.util.*;

//import javax.naming.*;
//import javax.rmi.*;
//import javax.security.auth.*;
//import javax.security.auth.login.*;

import ejb.exercises.solutions.source.bookstore.BookstoreAdmin;
import ejb.exercises.solutions.source.bookstore.BookstoreAdminHome;
import ejb.exercises.solutions.source.dtos.CustomerDTO;

public abstract class SecuredAdminClient {

	public static void main(String[] args) {
		String username = null;
		String password = null;
		String url = "t3://localhost:7001";

		// Define the location of the configuration file
		Properties props = System.getProperties();
		props.put("java.security.auth.login.config", "weblogic_jaas.config");

		LoginContext loginContext = null;
		try {
			// Create LoginContext; specify username/password login module
			loginContext = new LoginContext("AdminClient", new WeblogicCallbackHandler(username, password, url));
		} catch (SecurityException se) {
			se.printStackTrace();
			System.exit(-1);
		} catch (LoginException le) {
			le.printStackTrace();
			System.exit(-1);
		}

		/**
		 * Attempt authentication
		 */
		try {
			loginContext.login();
		} catch (LoginException e) {
			System.out.println("Authentication Failed!\n" + e.getMessage());
			System.exit(-1);
		}

		/**
		 * Retrieve authenticated subject, perform AdminClientAction as Subject
		 */
		Subject subject = loginContext.getSubject();
		System.out.println(subject.getPrincipals() + " has logged in successfully.");

		AdminClientAction adminAction = new AdminClientAction();
		Subject.doAs(subject, adminAction);

	}

	/**
	 * Inner class representing the PrivilegedAction
	 */
	private static class AdminClientAction implements PrivilegedAction<Object> {

		public Object run() {
			try {
				callBookstoreAdmin();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		public void callBookstoreAdmin() throws Exception {
			// Lookup:
			InitialContext ictx = new InitialContext();
			Object obj = ictx.lookup("ejb/admin/BookstoreAdminHome");
			BookstoreAdminHome adminHome = (BookstoreAdminHome) PortableRemoteObject.narrow(obj, BookstoreAdminHome.class);
			BookstoreAdmin admin = adminHome.create();

			// view all customers:
			System.out.println("All registered customers:");
			List<CustomerDTO> customers = admin.showCustomers();
			for (Iterator<CustomerDTO> it = customers.iterator(); it.hasNext();) {
				CustomerDTO customer = it.next();
				System.out.println(customer);
			}

			// release resources:
			admin.remove();

		}
	}
}
