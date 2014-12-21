package designpatterns.exercises.strategy;

import java.util.Date;

public class Logger {
	private LoggerStrategy strategy;

	public Logger(LoggerStrategy istrategy) {
		strategy = istrategy;
	}

	public void logMessage(String header, String body) {
		Date currentDate = new Date();
		String messageLine = currentDate.toString() + "," + header + "," + body;
		strategy.logMessageLine(messageLine);
	}

	public void setLoggerStrategy(LoggerStrategy istrategy) {
		strategy = istrategy;
	}

	public static void main(String[] args) {
		try {
			Logger logger = new Logger(new ConsoleLogger());
			logger.logMessage("alert", "memory is low");
			logger.logMessage("info", "logger is active");
			logger.setLoggerStrategy(new StdErrLogger());
			logger.logMessage("info", "logger is active");
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
