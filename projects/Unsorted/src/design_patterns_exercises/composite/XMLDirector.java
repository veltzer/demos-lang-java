package design_patterns_exercises.src.dp.composite;

public class XMLDirector
{
	private XMLBuilder xmlBuilder;

	public XMLDirector(XMLBuilder xmlBuilder)
	{
		super();
		this.xmlBuilder = xmlBuilder;
	}

	public void build(XMLDocument xmlDocument)
	{
		xmlBuilder.buildVersion(xmlDocument.getVersion());
		xmlBuilder.build(xmlDocument.getRootElement());
	}

	public void printXML()
	{
		System.out.println(xmlBuilder.getFormattedXML());
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

			courseElement = new XMLElement("Course");
			courseElement.addElement(new XMLElement("name").setData("Java Programming"));
			courseElement.addElement(new XMLElement("duration").setData("5 days"));
			root.addElement(courseElement);

			XMLDocument xmlDocument = new XMLDocument(root);
			xmlDocument.setVersion("1.0");

			XMLDirector xmlDirector = new XMLDirector(new FormattedXMLBuilder());
			xmlDirector.build(xmlDocument);
			xmlDirector.printXML();

			System.out.println("Done");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
