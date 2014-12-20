package dp.observer.factory.logger;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Logger
{
	private String name;
	private Set<LoggerObserver> observers;

	private static Map<String,Logger> loggers = new HashMap<String,Logger>();

	private Logger(String name)
	{
		this.name = name;
		observers = new HashSet<LoggerObserver>();
	}

	public static Logger getLogger(String name)
	{
		Logger logger = loggers.get(name);
		if (logger == null)
		{
			logger = new Logger(name);
			loggers.put(name, logger);
		}
		return logger;
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
		String messageLine = currentDate.toString() + "," + name + "," + header + "," + body;
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
			Logger logger = Logger.getLogger("default");
			logger.addObserver(new ConsoleLogger());
			logger.addObserver(new StdErrorLogger());
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
