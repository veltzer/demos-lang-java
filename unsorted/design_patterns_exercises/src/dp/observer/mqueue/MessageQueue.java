/*
 * Created on Feb 10, 2006
 */
package dp.observer.mqueue;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class MessageQueue extends Observable
{

	private LinkedList<Object> queue;

	private class QueueCleaner extends Thread
	{
		public void run()
		{
			while (true)
			{
				synchronized (queue)
				{
					while (queue.isEmpty())
					{
						try
						{
							queue.wait();
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
				Object message = queue.removeFirst();
				setChanged();
				notifyObservers(message);
			}
		}
	}

	public MessageQueue()
	{
		super();
		queue = new LinkedList<Object>();
		new QueueCleaner().start();
	}

	public void addMessage(Object message)
	{
		queue.addLast(message);
		synchronized (queue)
		{
			queue.notify();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			MessageQueue messageQueue = new MessageQueue();
			messageQueue.addObserver(new Observer()
			{
				public void update(Observable o, Object arg)
				{
					System.err.println("Oh, no! There is a message: " + arg);
				}
			});
			messageQueue.addObserver(new Observer()
			{
				public void update(Observable o, Object arg)
				{
					System.out.println("Good! There is a message: " + arg);
				}
			});
			for (int i = 0; i < 10; ++i)
			{
				messageQueue.addMessage("mgs #" + i);
			}
			System.out.println("Done");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
