package designpatterns.exercises.bridge;

public abstract class AbstractDBTable {
	private DataMap dataMapImpl;

	public AbstractDBTable(DataMap idataMapImpl) {
		super();
		dataMapImpl = idataMapImpl;
	}

	protected DataMap getImpl() {
		return dataMapImpl;
	}

	public abstract void insert(int id, String data);

	public abstract void update(int id, String data);

	public abstract String select(int id);

	public static void main(String[] args) {
		try {
			DataMap map = new HashDataMap();
			AbstractDBTable table = new NormalDBTable(map);
			//AbstractDBTable table = new ReadOnlyDBTable(map);
			table.insert(1, "a");
			table.insert(2, "b");
			table.insert(2, "c");
			System.out.println("data at 1: " + table.select(1));
			System.out.println("data at 2: " + table.select(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
