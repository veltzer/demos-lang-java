package dp.templatemethod;

import java.util.Date;

public abstract class AbstractLogger
{

	public AbstractLogger()
	{
		super();
	}

	public void logMessage(String header, String body)
	{
		Date currentDate = new Date();
		String messageLine = currentDate.toString() + "," + header + "," + body;
		logMessageLine(messageLine);
	}

	protected abstract void logMessageLine(String messageLine);

	public static void main(String[] args)
	{
		try
		{
			AbstractLogger logger = new ConsoleLogger();
			logger.logMessage("alert", "memory is low");
			logger.logMessage("info", "logger is active");
			System.out.println("Done");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
