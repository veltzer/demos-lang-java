/*
 * Created on Jan 24, 2006
 */
package dp.factory.pool2;

public class DataRecord
{
	private int id;
	private String data;

	boolean isAvailable;

	public DataRecord()
	{
		this.id = 0;
		this.data = null;
	}

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

	/**
	 * @param data The data to set.
	 */
	public void setData(String data)
	{
		this.data = data;
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void reset()
	{
		this.data = null ;
		this.id = 0 ;
		
	}

}
