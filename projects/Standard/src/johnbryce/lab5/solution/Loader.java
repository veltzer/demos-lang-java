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
		Object[] params=null;
		Class [] paramsTypes=null;
		String className=currClass.getAttribute("name");
		//getting constructor parameters
		NodeList paramList=currClass.getChildNodes();
		if(paramList.getLength()==0){return Class.forName(className).newInstance();}
		params=new Object[paramList.getLength()];
		paramsTypes=new Class[paramList.getLength()];
		Element currParam=null;
		String type=null;
		for(int i=0;i<params.length;i++){
			currParam=(Element)paramList.item(i);
			type=currParam.getAttribute("type");
			if(type.equals("int")){
				params[i]= Integer.parseInt(currParam.getFirstChild().getNodeValue());
				paramsTypes[i]=int.class;
			}else if(type.equals("short")){
				params[i]= Short.parseShort(paramList.item(i).getFirstChild().getNodeValue());
				paramsTypes[i]=short.class;
			}else if(type.equals("byte")){
				params[i]= Byte.parseByte(paramList.item(i).getFirstChild().getNodeValue());
				paramsTypes[i]=byte.class;
			}else if(type.equals("long")){
				params[i]= Long.parseLong(paramList.item(i).getFirstChild().getNodeValue());
				paramsTypes[i]=long.class;
			}else if(type.equals("boolean")){
				params[i]= Boolean.parseBoolean(paramList.item(i).getFirstChild().getNodeValue());
				paramsTypes[i]=boolean.class;
			}else if(type.equals("float")){
				params[i]= Float.parseFloat(paramList.item(i).getFirstChild().getNodeValue());
				paramsTypes[i]=float.class;
			}else if(type.equals("double")){
				params[i]= Double.parseDouble(paramList.item(i).getFirstChild().getNodeValue());
				paramsTypes[i]=double.class;
			}else if(type.equals("string")){
				params[i]= paramList.item(i).getFirstChild().getNodeValue();
				paramsTypes[i]=String.class;
			}else if(type.equals("object")){
				params[i]= instantiate((Element)(currParam.getElementsByTagName("class").item(0)));
				paramsTypes[i]=params[i].getClass();
			}
		}
		Constructor c=Class.forName(className).getConstructor(paramsTypes);
		return c.newInstance(params);
	}
}
