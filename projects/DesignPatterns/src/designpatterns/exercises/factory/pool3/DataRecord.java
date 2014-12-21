package designpatterns.exercises.factory.pool3;

public class DataRecord {
	private int id;
	private String data;

	public DataRecord() {
		id = 0;
		data = null;
	}
	public DataRecord(int iid, String idata) {
		id = iid;
		data = idata;
	}
	public String getData() {
		return data;
	}
	public int getId() {
		return id;
	}
	public void setData(String idata) {
		data = idata;
	}
	public void setId(int iid) {
		id = iid;
	}
}
