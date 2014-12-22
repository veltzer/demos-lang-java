package ejbwl.exercises.solutions.source.hello;

import javax.ejb.EJBHome;

public interface GreetHome extends EJBHome {
	Greet create();
}
