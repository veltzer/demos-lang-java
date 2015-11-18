package designpatterns.exercises.factory.pool1;

import java.util.LinkedList;

/**
 * A minimal object pool. This pool is a factory which manages the creation of
 * DataRecord objects. No locking is provided. The pool may hava a max-size
 * limit.
 */
public final class DataRecordPool {
	private static DataRecordPool instance = new DataRecordPool();
	private int maxSize;
	private LinkedList<DataRecord> pool;

	private DataRecordPool() {
		pool = new LinkedList<DataRecord>();
		// a maxSize of 0 means "unlimited"
		maxSize = Integer
				.parseInt(System.getProperty("datarecord.pool.size", "0"));
	}

	public static DataRecordPool getInstance() {
		return instance;
	}

	public DataRecord createDataRecord(int id, String data) {
		if (pool.isEmpty()) {
			System.out.println("creating new object");
			return new DataRecord(id, data);
		}

		System.out.println("+ returning cached object");
		DataRecord record = pool.removeFirst();
		return record;
	}

	public void release(DataRecord record) {
		// There should be a safety check: perhaps this record is already in the
		// pool?
		if ((maxSize == 0) || (pool.size() < maxSize)) {
			pool.add(record);
		}
	}

	public static void main(String[] args) {
		try {
			DataRecordPool dataRecordPool = DataRecordPool.getInstance();
			DataRecord[] buffer = new DataRecord[10];
			for (int i = 0; i < buffer.length; ++i) {
				buffer[i] = dataRecordPool.createDataRecord(i, "a");
			}
			int releaseCount = buffer.length / 2;
			for (int i = 0; i < releaseCount; ++i) {
				dataRecordPool.release(buffer[i]);
			}
			for (int i = 0; i < releaseCount; ++i) {
				buffer[i] = dataRecordPool.createDataRecord(i, "a");
			}
			System.out.println("Done");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
