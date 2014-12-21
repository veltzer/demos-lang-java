package designpatterns.exercises.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XMLElement {

	private String name;
	private String data;
	private List<XMLElement> children;

	private class ChildrenIterator implements Iterator<XMLElement> {
		private Iterator<XMLElement> elementsIterator;
		private String elementName;
		private XMLElement currentElement;

		public ChildrenIterator(String ielementName) {
			elementName = ielementName;
			elementsIterator = getChildren();
			findNext();
		}

		public boolean hasNext() {
			return (currentElement != null);
		}

		public XMLElement next() {
			XMLElement result = currentElement;
			findNext();
			return result;
		}

		private void findNext() {
			currentElement = null;
			while (elementsIterator.hasNext()) {
				XMLElement element = (XMLElement) elementsIterator.next();
				if (element.getName().equals(elementName)) {
					currentElement = element;
					return;
				}
			}
		}

		public void remove() {
			throw new UnsupportedOperationException("Operation not supported");
		}
	}

	public XMLElement(String iname) {
		name = iname;
		children = new ArrayList<XMLElement>();
	}

	public Iterator<XMLElement> getChildren() {
		return children.iterator();
	}

	public Iterator<XMLElement> getChildren(String iname) {
		return new ChildrenIterator(iname);
	}

	public XMLElement addElement(XMLElement element) {
		children.add(element);
		return this;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Returns the data.
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data The data to set.
	 */
	public XMLElement setData(String idata) {
		data = idata;
		return this;
	}

	public String toString() {
		return "[XML Element: name=" + getName() + ", data=" + getData() + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
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

			for (Iterator<XMLElement> i = root.getChildren(); i.hasNext();) {
				System.out.println(i.next());
			}
			System.out.println("Done");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
