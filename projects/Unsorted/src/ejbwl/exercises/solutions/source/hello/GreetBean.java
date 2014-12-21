package ejbwl.exercises.solutions.source.hello;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;
/**
 * Bean implementation class for Greet
 *
 */
public class GreetBean implements SessionBean {

	private javax.ejb.SessionContext mySessionCtx;

	public void setSessionContext(SessionContext ctx) {
		mySessionCtx = ctx;
		System.out.println(getClass().getName() + ".setSessionContext() was invoked...");
	}

	public void ejbCreate() throws CreateException {
		System.out.println(getClass().getName() + ".ejbCreate() was invoked...");
	}

	public void ejbActivate() {
		System.out.println(getClass().getName() + ".ejbActivate() was invoked...");
	}

	public void ejbPassivate() {
		System.out.println(getClass().getName() + ".ejbPassivate() was invoked...");
	}

	public void ejbRemove() {
		System.out.println(getClass().getName() + ".ejbRemove() was invoked...");
	}

	/**
	* Method implementation:
	*/
	public String getHelloMessage(String name) {
		return "Hello [" + name + "] from a Session Bean";
	}
}
