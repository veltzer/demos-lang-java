package design_patterns_exercises.observer.factory.logger;

public class StdErrorLogger implements LoggerObserver
{

	public StdErrorLogger()
	{
		super();
	}

	public void onLogRequest(String messageLine)
	{
		System.err.println(messageLine);
	}

}
