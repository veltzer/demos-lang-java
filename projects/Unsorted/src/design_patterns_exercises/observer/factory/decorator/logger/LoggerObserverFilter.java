package design_patterns_exercises.observer.factory.decorator.logger;

public class LoggerObserverFilter implements LoggerObserver
{
	private int priorityLevel;
	private LoggerObserver reference;

	public LoggerObserverFilter(LoggerObserver reference, int priorityLevel)
	{
		super();
		this.reference = reference;
		this.priorityLevel = priorityLevel;
	}

	public void onLogRequest(int priority, String messageLine)
	{
		if (priority >= priorityLevel)
			reference.onLogRequest(priority, messageLine);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
