/*
 * Created on Jan 24, 2006
 */
package dp.factory.pool2;

import java.util.LinkedList;
import java.util.List;

/**
 * A minimal object pool. This pool is a factory which manages the creation of
 * DataRecord objects.
 * Locking is provided.
 * Flyweight is used to allow for multiple objects creation, no arguments needed.
 * @author shlomi
 */
public class DataRecordPool
{
	private static DataRecordPool instance = new DataRecordPool();
	private int minSize;
	private int maxSize;
	private LinkedList<DataRecord> pool;

	private DataRecordPool()
	{
		pool = new LinkedList<DataRecord>();
		// a maxSize of 0 means "unlimited"
		maxSize = Integer.parseInt(System.getProperty("datarecord.pool.maxsize", "0"));
		minSize = Integer.parseInt(System.getProperty("datarecord.pool.minsize", "0"));

		ensureCapacity();
	}

	public static DataRecordPool getInstance()
	{
		return instance;
	}

	private synchronized void ensureCapacity()
	{
		int missingElements = minSize - pool.size();
		for (int i = 0; i < missingElements; ++i)
			release(createNewDataRecord());
	}

	private DataRecord createNewDataRecord()
	{
		System.out.println("creating new object");
		return new DataRecord();
	}

	public synchronized DataRecord getDataRecord()
	{
		if (pool.isEmpty())
			return createNewDataRecord();

		System.out.println("+ returning cached object");
		DataRecord record = pool.removeFirst();
		return record;
	}

	public List createDataRecords(int amount) // Should we add 'synchronized' ?
	{
		List<DataRecord> recordsList = new LinkedList<DataRecord>();
		for (int i = 0; i < amount; ++i)
			recordsList.add(getDataRecord());
		return recordsList;
	}

	public synchronized void release(DataRecord record)
	{
		record.reset();
		// There should be a safety check: perhaps this record is already in the pool?
		if ((maxSize == 0) || (pool.size() < maxSize))
			pool.add(record);
		ensureCapacity();
	}

}
