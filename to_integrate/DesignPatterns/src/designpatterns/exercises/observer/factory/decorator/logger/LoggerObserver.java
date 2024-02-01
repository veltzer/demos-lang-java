package designpatterns.exercises.observer.factory.decorator.logger;

public interface LoggerObserver {
	void onLogRequest(int priority, String messageLine);
}
