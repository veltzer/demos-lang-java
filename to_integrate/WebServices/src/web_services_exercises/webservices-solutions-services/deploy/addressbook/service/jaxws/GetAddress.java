
package addressbook.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAddress", namespace = "http://service.addressbook/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAddress", namespace = "http://service.addressbook/")
public class GetAddress {

	@XmlElement(name = "arg0", namespace = "")
	private String arg0;

	public String getArg0() {
		return arg0;
	}

	public void setArg0(String iarg0) {
		arg0 = iarg0;
	}

}
