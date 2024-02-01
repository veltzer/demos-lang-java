package designpatterns.exercises.bridge;

public class NormalDBTable extends AbstractDBTable {
	public NormalDBTable(DataMap dataMapImpl) {
		super(dataMapImpl);
	}

	public void insert(int id, String data) {
		Integer key = Integer.valueOf(id);
		getImpl().put(key, data);
	}

	public void update(int id, String data) {
		Integer key = Integer.valueOf(id);
		if (getImpl().keyExists(key)) {
			getImpl().put(key, data);
		}
	}

	public String select(int id) {
		return (String) getImpl().get(Integer.valueOf(id));
	}
}
