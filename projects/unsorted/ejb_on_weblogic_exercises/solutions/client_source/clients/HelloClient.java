package clients;
import java.rmi.RemoteException;

import hello.Greet;
import hello.GreetHome;

import javax.ejb.CreateException;
import javax.ejb.RemoveException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

/**
 * A test client for our Greet bean.
 *
 * This simple test obtains a Greet stub and invokes its method(s).
 */
public class HelloClient
{
	public static void main(String[] args)
	{
		// Lookup - here we lookup the Greet session bean home and create a new bean instance:
		try
		{
			InitialContext ictx=new InitialContext();
			Object obj=ictx.lookup("ejb/hello/GreetHome");
			GreetHome gHome=(GreetHome)PortableRemoteObject.narrow(obj,GreetHome.class );
			Greet greet=gHome.create();

			// Invoke methods - here we invoke the desired method:
			String str=greet.getHelloMessage("danny");
			System.out.println("Received reply from bean: " + str);

			// release resources - here we remove the client reference to the bean:
			greet.remove();
		}
		catch (RemoteException e)
		{
			// This exception is thrown when there are network problems or a
			// low level error in the application server (such as database connection
			// failure)
			e.printStackTrace();
		}
		catch (NamingException e)
		{
			// This exception is thrown when the looked up name does not exist on
			// the server
			e.printStackTrace();
		}
		catch (CreateException e)
		{
			// This exception is thrown when EJB creation fails
			e.printStackTrace();
		}
		catch (RemoveException e)
		{
			e.printStackTrace();
		}

	}
}
