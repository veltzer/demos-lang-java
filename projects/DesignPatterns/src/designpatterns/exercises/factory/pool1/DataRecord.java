package design_patterns_exercises.factory.pool1;

public class DataRecord
{
	private int id;
	private String data;

	public DataRecord(int id, String data)
	{
		this.id = id;
		this.data = data;
	}

	/**
	 * @return Returns the data.
	 */
	public String getData()
	{
		return data;
	}

	/**
	 * @return Returns the id.
	 */
	public int getId()
	{
		return id;
	}

}
