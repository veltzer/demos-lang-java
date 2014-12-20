package design_patterns_exercises.templatemethod;

public class ConsoleLogger extends AbstractLogger
{

	public ConsoleLogger()
	{
		super();
	}

	protected void logMessageLine(String messageLine)
	{
		System.out.println(messageLine);
	}

}
