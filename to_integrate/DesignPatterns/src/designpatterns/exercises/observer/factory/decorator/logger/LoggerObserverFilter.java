package designpatterns.exercises.observer.factory.decorator.logger;

public class LoggerObserverFilter implements LoggerObserver {
	private int priorityLevel;
	private LoggerObserver reference;

	public LoggerObserverFilter(LoggerObserver ireference, int ipriorityLevel) {
		super();
		reference = ireference;
		priorityLevel = ipriorityLevel;
	}

	public void onLogRequest(int priority, String messageLine) {
		if (priority >= priorityLevel) {
			reference.onLogRequest(priority, messageLine);
		}
	}

	public static void main(String[] args) {
	}
}
