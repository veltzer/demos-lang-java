package designpatterns.exercises.observer.factory.decorator.logger;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class Logger {
	private String name;
	private Set<LoggerObserver> observers;

	private static Map<String, Logger> loggers = new HashMap<String, Logger>();

	private Logger(String iname) {
		name = iname;
		observers = new HashSet<LoggerObserver>();
	}

	public static Logger getLogger(String name) {
		Logger logger = loggers.get(name);
		if (logger == null) {
			logger = new Logger(name);
			loggers.put(name, logger);
		}
		return logger;
	}

	public void addObserver(LoggerObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(LoggerObserver observer) {
		observers.remove(observer);
	}

	public void logMessage(int priority, String header, String body) {
		Date currentDate = new Date();
		String messageLine = currentDate.toString() + "," + name + "," + header
				+ "," + body;
		for (Iterator<LoggerObserver> i = observers.iterator(); i.hasNext();) {
			LoggerObserver observer = i.next();
			observer.onLogRequest(priority, messageLine);
		}
	}

	public static void main(String[] args) {
		try {
			Logger logger = Logger.getLogger("default");
			logger.addObserver(new ConsoleLogger());
			logger.addObserver(
					new LoggerObserverFilter(new StdErrorLogger(), 3));
			logger.logMessage(3, "alert", "memory is low");
			logger.logMessage(2, "info", "logger is active");
			System.out.println("Done");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
