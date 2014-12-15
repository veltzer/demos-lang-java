/*
 * Created on Feb 10, 2006
 */
package dp.strategy;

public class ConsoleLogger implements LoggerStrategy
{

	public ConsoleLogger()
	{
		super();
	}

	public void logMessageLine(String messageLine)
	{
		System.out.println(messageLine);
	}

}
