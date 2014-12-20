package dp.factory.pool3;

import java.util.Iterator;
import java.util.List;

public class PoolTester implements Runnable
{
	private DataRecordPool recordPool;

	public PoolTester()
	{
		recordPool = DataRecordPool.getInstance();
	}

	public void run()
	{
		for (int counter = 0; counter < 5; ++counter)
		{
			int amount = (int) (Math.random() * 10);
			List records = recordPool.createDataRecords(amount);
			try
			{
				Thread.sleep((int) (Math.random() * 3000));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			for (Iterator i = records.iterator(); i.hasNext();)
			{
				DataRecord record = (DataRecord) i.next();
				recordPool.release(record);
			}
			// ....
			for (Iterator i = records.iterator(); i.hasNext();)
			{
				DataRecord record = (DataRecord) i.next();
				record.setData("abc") ;
			}

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			Thread[] testers = new Thread[10];
			for (int i = 0; i < testers.length; ++i)
			{
				testers[i] = new Thread(new PoolTester());
				testers[i].start();
			}
			for (int i = 0; i < testers.length; ++i)
				testers[i].join();

			System.out.println("Total pool size: " + DataRecordPool.getInstance().size() + ", numRequests="
					+ DataRecordPool.getInstance().getNumRequests());
			System.out.println("Done");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
