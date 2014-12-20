package design_patterns_exercises.observer.factory.decorator.logger;

public interface LoggerObserver
{
	public void onLogRequest(int priority, String messageLine);
}
