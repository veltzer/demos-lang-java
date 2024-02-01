package designpatterns.exercises.composite;

public class XMLDocument {
	private String version;
	private XMLElement rootElement;

	public XMLDocument(XMLElement irootElement) {
		super();
		rootElement = irootElement;
	}

	public XMLElement getRootElement() {
		return rootElement;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String iversion) {
		version = iversion;
	}
}
