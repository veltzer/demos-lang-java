package designpatterns.exercises.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XMLElement {
	private String name;
	private String data;
	private List<XMLElement> children;

	public XMLElement(String iname) {
		name = iname;
		children = new ArrayList<XMLElement>();
	}

	public Iterator<XMLElement> getChildren() {
		return children.iterator();
	}

	public XMLElement addElement(XMLElement element) {
		children.add(element);
		return this;
	}

	public String getName() {
		return name;
	}

	public String getData() {
		return data;
	}

	public XMLElement setData(String idata) {
		data = idata;
		return this;
	}

	public void accept(XMLVisitor visitor) {
		visitor.visit(this);
		for (Iterator<XMLElement> i = getChildren(); i.hasNext();) {
			XMLElement child = i.next();
			child.accept(visitor);
		}
	}

	public String toString() {
		return "[XML Element: name=" + getName() + ", data=" + getData() + "]";
	}

	public static void main(String[] args) {
		try {
			XMLElement root = new XMLElement("Root");
			XMLElement courseElement = new XMLElement("Course");
			courseElement.addElement(
					new XMLElement("name").setData("Design Patterns"));
			courseElement
					.addElement(new XMLElement("duration").setData("4 days"));
			root.addElement(courseElement);
			root.addElement(new XMLElement("dummy"));

			courseElement = new XMLElement("Course");
			courseElement.addElement(
					new XMLElement("name").setData("Java Programming"));
			courseElement
					.addElement(new XMLElement("duration").setData("5 days"));
			root.addElement(courseElement);

			root.accept(new XMLVisitor() {
				public void visit(XMLElement element) {
					if (element.getName().equals("name")) {
						System.out.println("course name: " + element.getData());
					}
				}
			});

			TagsCountVisitor tagsCountVisitor = new TagsCountVisitor();
			root.accept(tagsCountVisitor);
			System.out.println(
					"Number of tags: " + tagsCountVisitor.getCountTags());
			System.out.println("Done");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
