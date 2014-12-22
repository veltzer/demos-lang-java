package ejb.exercises.solutions.client_source.clients;
import java.rmi.RemoteException;

import javax.ejb.RemoveException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import ejb.exercises.solutions.source.hello.Greet;
import ejb.exercises.solutions.source.hello.GreetHome;

/**
 * A test client for our Greet bean.
 *
 * This simple test obtains a Greet stub and invokes its method(s).
 */
public abstract class HelloClient {
	public static void main(String[] args) {
		// Lookup - here we lookup the Greet session bean home and create a new bean instance:
		try {
			InitialContext ictx = new InitialContext();
			Object obj = ictx.lookup("ejb/hello/GreetHome");
			GreetHome gHome = (GreetHome) PortableRemoteObject.narrow(obj, GreetHome.class);
			Greet greet = gHome.create();

			// Invoke methods - here we invoke the desired method:
			String str = greet.getHelloMessage("danny");
			System.out.println("Received reply from bean: " + str);

			// release resources - here we remove the client reference to the bean:
			greet.remove();
		} catch (RemoteException e) {
			// This exception is thrown when there are network problems or a
			// low level error in the application server (such as database connection
			// failure)
			throw new RuntimeException(e);
		} catch (NamingException e) {
			// This exception is thrown when the looked up name does not exist on
			// the server
			throw new RuntimeException(e);
		} catch (RemoveException e) {
			throw new RuntimeException(e);
		}
	}
}
