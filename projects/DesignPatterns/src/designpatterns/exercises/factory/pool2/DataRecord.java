package designpatterns.exercises.factory.pool2;

public class DataRecord {
	private int id;
	private String data;

	public DataRecord() {
		this.id = 0;
		this.data = null;
	}

	public DataRecord(int iid, String idata) {
		this.id = iid;
		this.data = idata;
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

	/**
	 * @param data The data to set.
	 */
	public void setData(String idata) {
		this.data = idata;
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(int iid) {
		this.id = iid;
	}

	public void reset() {
		this.data = null;
		this.id = 0;
	}

}
