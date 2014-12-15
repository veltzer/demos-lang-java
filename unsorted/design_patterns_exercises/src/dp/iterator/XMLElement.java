/*
 * Created on Jan 29, 2006
 */
package dp.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XMLElement
{
	private String name;
	private String data;
	private List<XMLElement> children;

	private class ChildrenIterator implements Iterator
	{
		private Iterator elementsIterator;
		private String elementName;
		private XMLElement currentElement;

		public ChildrenIterator(String elementName)
		{
			this.elementName = elementName;
			elementsIterator = getChildren();
			findNext();
		}

		public boolean hasNext()
		{
			return (currentElement != null);
		}

		public Object next()
		{
			XMLElement result = currentElement;
			findNext();
			return result;
		}

		private void findNext()
		{
			currentElement = null;
			while (elementsIterator.hasNext())
			{
				XMLElement element = (XMLElement) elementsIterator.next();
				if (element.getName().equals(elementName))
				{
					currentElement = element;
					return;
				}
			}
		}

		public void remove()
		{
			throw new UnsupportedOperationException("Operation not supported");
		}
	}

	public XMLElement(String name)
	{
		this.name = name;
		children = new ArrayList<XMLElement>();
	}

	public Iterator getChildren()
	{
		return children.iterator();
	}

	public Iterator getChildren(String name)
	{
		return new ChildrenIterator(name);
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

	public String toString()
	{
		return "[XML Element: name=" + getName() + ", data=" + getData() + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			XMLElement root = new XMLElement("Root");
			XMLElement courseElement = new XMLElement("Course");
			courseElement.addElement(new XMLElement("name").setData("Design Patterns"));
			courseElement.addElement(new XMLElement("duration").setData("4 days"));
			root.addElement(courseElement);
			root.addElement(new XMLElement("dummy"));

			courseElement = new XMLElement("Course");
			courseElement.addElement(new XMLElement("name").setData("Java Programming"));
			courseElement.addElement(new XMLElement("duration").setData("5 days"));
			root.addElement(courseElement);

			for (Iterator i = root.getChildren(); i.hasNext();)
			{
				System.out.println(i.next());
			}
			System.out.println("Done");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
