package ejbwl.exercises.solutions.source.hello;

import javax.ejb.EJBHome;
import javax.ejb.CreateException;
import java.rmi.RemoteException;

public interface GreetHome extends EJBHome {
	Greet create() throws CreateException, RemoteException;
}
