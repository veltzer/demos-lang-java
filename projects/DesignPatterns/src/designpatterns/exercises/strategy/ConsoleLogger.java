package designpatterns.exercises.strategy;

public class ConsoleLogger implements LoggerStrategy
{

	public ConsoleLogger()
	{
		super();
	}

	public void logMessageLine(String messageLine)
	{
		System.out.println(messageLine);
	}

}
