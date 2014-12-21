package designpatterns.exercises.strategy;

public class StdErrLogger implements LoggerStrategy {
	public StdErrLogger() {
		super();
	}
	public void logMessageLine(String messageLine) {
		System.err.println(messageLine);
	}
}
