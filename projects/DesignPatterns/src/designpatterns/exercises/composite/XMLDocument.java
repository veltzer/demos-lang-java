package designpatterns.exercises.composite;

public class XMLDocument
{
	private String version;
	private XMLElement rootElement;

	public XMLDocument(XMLElement rootElement)
	{
		super();
		this.rootElement = rootElement;
	}

	public XMLElement getRootElement()
	{
		return rootElement;
	}

	/**
	 * @return Returns the version.
	 */
	public String getVersion()
	{
		return version;
	}

	/**
	 * @param version The version to set.
	 */
	public void setVersion(String version)
	{
		this.version = version;
	}
}
