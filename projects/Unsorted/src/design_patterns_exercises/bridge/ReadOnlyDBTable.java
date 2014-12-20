package design_patterns_exercises.bridge;

public class ReadOnlyDBTable extends AbstractDBTable {
	public ReadOnlyDBTable(DataMap dataMapImpl) {
		super(dataMapImpl);
	}
	public void insert(int id, String data) {
		throw new RuntimeException("Read only!");
	}
	public void update(int id, String data) {
		throw new RuntimeException("Read only!");
	}
	public String select(int id) {
		return (String)getImpl().get(new Integer(id));
	}
}
