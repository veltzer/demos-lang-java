package designpatterns.exercises.bridge;

public class UniqueKeyDBTable extends AbstractDBTable
{

	public UniqueKeyDBTable(DataMap dataMapImpl)
	{
		super(dataMapImpl);
	}

	public void insert(int id, String data)
	{
		Integer key = new Integer(id);
		if (select(id) != null)
			throw new RuntimeException("Key " + id + " already exists!");
		getImpl().put(key, data);
	}

	public void update(int id, String data)
	{
		Integer key = new Integer(id);
		if (getImpl().keyExists(key))
			getImpl().put(key, data);
	}

	public String select(int id)
	{
		return (String) getImpl().get(new Integer(id));
	}

}
