package design_patterns_exercises.observer.factory.decorator.logger;

public class StdErrorLogger implements LoggerObserver
{

	public StdErrorLogger()
	{
		super();
	}

	public void onLogRequest(int priority, String messageLine)
	{
		System.err.println(messageLine);
	}

}
