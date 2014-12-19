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
