/*
 * Created on Jan 25, 2006
 */
package dp.proxy;

public class DoableAction implements Doable
{

	public DoableAction()
	{
		super();
	}

	public void doIt()
	{
		//System.out.println("Doing it...");
	}

	public void doItAgain(String how)
	{
		System.out.println("Doing it again (" + how + ")...");
	}

}
