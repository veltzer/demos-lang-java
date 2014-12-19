package dp.observer.factory.decorator.logger;

public interface LoggerObserver
{
	public void onLogRequest(int priority, String messageLine);
}
