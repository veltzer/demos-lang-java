package designpatterns.exercises.factory.pool1;

public class DataRecord {
	private int id;
	private String data;

	public DataRecord(int iid, String idata) {
		id = iid;
		data = idata;
	}

	/**
	 * @return Returns the data.
	 */
	public String getData() {
		return data;
	}

	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}
}
