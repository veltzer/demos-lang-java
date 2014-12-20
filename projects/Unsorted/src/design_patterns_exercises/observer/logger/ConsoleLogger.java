package design_patterns_exercises.observer.logger;

public class ConsoleLogger implements LoggerObserver
{

	public ConsoleLogger()
	{
		super();
	}

	public void onLogRequest(String messageLine)
	{
		System.out.println(messageLine);
	}

}
