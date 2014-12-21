package designpatterns.exercises.composite;

import java.util.ArrayList;
import java.util.List;

public class XMLElement {
	private String name;
	private String data;
	private List<XMLElement> children;

	public XMLElement(String iname) {
		name = iname;
		children = new ArrayList<XMLElement>();
	}
	public List<XMLElement> getChildren() {
		return children;
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
}
