package designpatterns.exercises.bridge;

public class ReadOnlyDBTable extends AbstractDBTable {
	private static final String ERR_STRING1 = "read only";
	public ReadOnlyDBTable(DataMap dataMapImpl) {
		super(dataMapImpl);
	}
	public void insert(int id, String data) {
		throw new RuntimeException(ERR_STRING1);
	}
	public void update(int id, String data) {
		throw new RuntimeException(ERR_STRING1);
	}
	public String select(int id) {
		return (String) getImpl().get(new Integer(id));
	}
}
