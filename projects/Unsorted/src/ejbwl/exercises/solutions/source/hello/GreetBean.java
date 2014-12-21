package ejbwl.exercises.solutions.source.hello;


/**
 * Bean implementation class for Greet
 *
 */
public class GreetBean implements javax.ejb.SessionBean {

	private javax.ejb.SessionContext mySessionCtx;

	public void setSessionContext(javax.ejb.SessionContext ctx)
	{
		mySessionCtx = ctx;
		System.out.println(this.getClass().getName() + ".setSessionContext() was invoked...");
	}

	public void ejbCreate() throws javax.ejb.CreateException
	{
		System.out.println(this.getClass().getName() + ".ejbCreate() was invoked...");
	}

	public void ejbActivate()
	{
		System.out.println(this.getClass().getName() + ".ejbActivate() was invoked...");
	}

	public void ejbPassivate()
	{
		System.out.println(this.getClass().getName() + ".ejbPassivate() was invoked...");
	}

	public void ejbRemove()
	{
		System.out.println(this.getClass().getName() + ".ejbRemove() was invoked...");
	}

	/**
	* Method implementation:
	*/
	public String getHelloMessage(String name)
	{
		return "Hello [" + name + "] from a Session Bean";
	}
}
