package designpatterns.exercises.composite;

public interface XMLBuilder {
	public void buildVersion(String xmlVersion);
	public void build(XMLElement element);
	public String getFormattedXML();
}
