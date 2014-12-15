/*
 * Created on Jan 29, 2006
 */
package dp.composite;

import java.util.List;

public class FormattedXMLBuilder implements XMLBuilder
{
	private StringBuffer formattedXML;

	public FormattedXMLBuilder()
	{
		super();
		formattedXML = new StringBuffer();
	}

	public void buildVersion(String xmlVersion)
	{
		formattedXML.append("<xml version=\"").append(xmlVersion).append("\">\n");
	}

	private void indent(int level)
	{
		for (int i = 0; i < level; ++i)
		{
			formattedXML.append("  ");
		}
	}

	public void build(XMLElement element, int level)
	{
		indent(level);
		formattedXML.append("<").append(element.getName()).append(">").append("\n");
		List children = element.getChildren();
		for (int i = 0; i < children.size(); ++i)
		{
			build((XMLElement) children.get(i), level + 1);
		}
		if (element.getData() != null)
		{
			indent(level + 1);
			formattedXML.append(element.getData()).append("\n");
		}
		indent(level);
		formattedXML.append("</").append(element.getName()).append(">").append("\n");
	}

	public void build(XMLElement element)
	{
		build(element, 0);
	}

	public String getFormattedXML()
	{
		return formattedXML.toString();
	}
}
