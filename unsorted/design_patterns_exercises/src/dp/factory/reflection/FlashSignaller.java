/*
 * Created on Jan 25, 2006
 */
package dp.factory.reflection;

public class FlashSignaller implements Signaller
{

	public FlashSignaller()
	{
		super();
	}

	public void signal()
	{
		System.out.println("flashing");
	}

}
