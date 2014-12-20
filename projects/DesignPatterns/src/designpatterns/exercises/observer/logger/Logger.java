package design_patterns_exercises.observer.logger;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Logger
{
	private Set<LoggerObserver> observers;

	public Logger()
	{
		observers = new HashSet<LoggerObserver>();
	}

	public void addObserver(LoggerObserver observer)
	{
		observers.add(observer);
	}

	public void removeObserver(LoggerObserver observer)
	{
		observers.remove(observer);
	}

	public void logMessage(String header, String body)
	{
		Date currentDate = new Date();
		String messageLine = currentDate.toString() + "," + header + "," + body;
		for (Iterator<LoggerObserver> i = observers.iterator(); i.hasNext();)
		{
			LoggerObserver observer = i.next();
			observer.onLogRequest(messageLine);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{

			Logger logger = new Logger();
			LoggerObserver consoleLogger = new ConsoleLogger();
			logger.addObserver(consoleLogger);
			logger.logMessage("info", "added console logger");
			logger.addObserver(new StdErrorLogger());
			logger.logMessage("alert", "added error logger");
			logger.logMessage("info", "loggers are active");
			logger.removeObserver(consoleLogger);
			logger.logMessage("info", "removed console logger");
			System.out.println("Done");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
