package dp.observer.factory.decorator.logger;

public class ConsoleLogger implements LoggerObserver
{

	public ConsoleLogger()
	{
		super();
	}

	public void onLogRequest(int priority, String messageLine)
	{
		System.out.println(messageLine);
	}

}
