package designpatterns.exercises.composite;

public interface XMLBuilder {
	void buildVersion(String xmlVersion);
	void build(XMLElement element);
	String getFormattedXML();
}
