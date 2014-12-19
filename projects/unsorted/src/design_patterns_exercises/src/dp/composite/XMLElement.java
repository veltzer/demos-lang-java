package dp.composite;

import java.util.ArrayList;
import java.util.List;

public class XMLElement
{
	private String name;
	private String data;
	private List<XMLElement> children;

	public XMLElement(String name)
	{
		this.name = name;
		children = new ArrayList<XMLElement>();
	}

	public List getChildren()
	{
		return children;
	}

	public XMLElement addElement(XMLElement element)
	{
		children.add(element);
		return this;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @return Returns the data.
	 */
	public String getData()
	{
		return data;
	}

	/**
	 * @param data The data to set.
	 */
	public XMLElement setData(String data)
	{
		this.data = data;
		return this;
	}
}
