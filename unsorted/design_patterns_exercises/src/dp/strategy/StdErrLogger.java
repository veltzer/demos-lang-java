/*
 * Created on Feb 10, 2006
 */
package dp.strategy;

public class StdErrLogger implements LoggerStrategy
{

	public StdErrLogger()
	{
		super();
	}

	public void logMessageLine(String messageLine)
	{
		System.err.println(messageLine);
	}

}
