package designpatterns.exercises.bridge;

public class UniqueKeyDBTable extends AbstractDBTable {
	private static final String ERR_STRING1 = "key exists";

	public UniqueKeyDBTable(DataMap dataMapImpl) {
		super(dataMapImpl);
	}

	public void insert(int id, String data) {
		Integer key = Integer.valueOf(id);
		if (select(id) != null) {
			throw new RuntimeException(ERR_STRING1);
		}
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
