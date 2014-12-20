package designpatterns.exercises.observer;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class PanicAttack extends Observable
{
	private static final String[] PANIC_MESSAGES =
	{ "Lunch is over", "Another design pattern!", "I have to go to the dentist", "Where's my Bamba?", };

	public PanicAttack()
	{
		Timer timer = new Timer();
		TimerTask task = new TimerTask()
		{
			public void run()
			{
				generatePanicAlert();
			}
		};
		timer.schedule(task, 5000, 5000);
	}

	private void generatePanicAlert()
	{
		int messageIndex = (int) (Math.random() * PANIC_MESSAGES.length);
		String message = PANIC_MESSAGES[messageIndex];
		setChanged();
		notifyObservers(message);
	}
}
