import java.lang.reflect.Constructor;

import javax.xml.parsers.*;
import org.w3c.dom.*;


public class Loader {
	
	private Document doc;
	
	public Loader(String xmlFile) throws Exception{
		//loading & parsing XML file
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);
		dbf.setIgnoringElementContentWhitespace(true);
		DocumentBuilder db=dbf.newDocumentBuilder();
		doc=db.parse(xmlFile);
	}
	
	
	public Object load() throws Exception{
		//getting root class name
		Element currClass=doc.getDocumentElement();		
		return instantiate(currClass);
	}
	
	private Object instantiate (Element currClass) throws Exception{
		Object[] params=null; //holds all values in objects and wrapper objects
		Class [] paramsTypes=null;  //holds all types in class format including oprimitives like int.class
		String className=currClass.getAttribute("name");
		//getting constructor parameters

		//enter text here
	}
}
