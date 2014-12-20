package designpatterns.exercises.observer.logger;

public class StdErrorLogger implements LoggerObserver {
	public StdErrorLogger() {
		super();
	}
	public void onLogRequest(String messageLine) {
		System.out.println("ERROR>>> " + messageLine);
	}
}