/*
 * Created on Feb 10, 2006
 */
package dp.templatemethod;

public class ConsoleLogger extends AbstractLogger
{

	public ConsoleLogger()
	{
		super();
	}

	protected void logMessageLine(String messageLine)
	{
		System.out.println(messageLine);
	}

}
