/*
 * Created on Jan 24, 2006
 */
package dp.factory.pool3;

import java.util.LinkedList;
import java.util.List;

/**
 * A minimal object pool. This pool is a factory which manages the creation of
 * DataRecord objects.
 * Locking is provided. Minimal capacity ensurance is provided using an external thread. 
 * @author shlomi
 */
public class DataRecordPool
{
	private static DataRecordPool instance = new DataRecordPool();
	private int minSize;
	private int maxSize;
	private LinkedList<DataRecord> pool;

	private int numRequests;

	private class CapacityManager implements Runnable
	{
		public void run()
		{
			synchronized (pool)
			{
				int missingElements = minSize - pool.size();
				for (int i = 0; i < missingElements; ++i)
					release(createNewDataRecord());
			}
		}
	}

	private DataRecordPool()
	{
		pool = new LinkedList<DataRecord>();
		// a maxSize of 0 means "unlimited"
		maxSize = Integer.parseInt(System.getProperty("datarecord.pool.maxsize", "0"));
		minSize = Integer.parseInt(System.getProperty("datarecord.pool.minsize", "0"));
		numRequests = 0;

		ensureCapacity();
	}

	public static DataRecordPool getInstance()
	{
		return instance;
	}

	private void ensureCapacity()
	{
		new Thread(new CapacityManager()).start();
	}

	private DataRecord createNewDataRecord()
	{
		System.out.println("creating new object");
		return new DataRecord();
	}

	public DataRecord createDataRecord()
	{
		synchronized (pool)
		{
			++numRequests;

			if (pool.isEmpty())
				return createNewDataRecord();

			System.out.println("+ returning cached object");
			DataRecord record = pool.removeFirst();
			return record;
		}
	}

	public List createDataRecords(int amount)
	{
		synchronized (pool)
		{
			List<DataRecord> recordsList = new LinkedList<DataRecord>();
			for (int i = 0; i < amount; ++i)
				recordsList.add(createDataRecord());
			return recordsList;
		}
	}

	public void release(DataRecord record)
	{
		synchronized (pool)
		{
			if ((maxSize == 0) || (pool.size() < maxSize))
				pool.add(record);
			ensureCapacity();
		}
	}

	public int size()
	{
		return pool.size();
	}

	public int getNumRequests()
	{
		return numRequests;
	}
}
