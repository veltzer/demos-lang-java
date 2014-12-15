/*
 * Created on Jan 25, 2006
 */
package dp.factory.reflection;

public class SoundSignaller implements Signaller
{

	public SoundSignaller()
	{
		super();
	}

	public void signal()
	{
		System.out.println("beeping");
	}

}
