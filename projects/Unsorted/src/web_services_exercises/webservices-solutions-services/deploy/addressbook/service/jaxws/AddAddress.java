
package addressbook.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "addAddress", namespace = "http://service.addressbook/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addAddress", namespace = "http://service.addressbook/", propOrder = {
	"arg0",
	"arg1"
})
public class AddAddress {

	@XmlElement(name = "arg0", namespace = "")
	private String arg0;
	@XmlElement(name = "arg1", namespace = "")
	private addressbook.service.Address arg1;

	public String getArg0() {
		return arg0;
	}
	public void setArg0(String iarg0) {
		arg0 = iarg0;
	}
	public addressbook.service.Address getArg1() {
		return arg1;
	}
	public void setArg1(addressbook.service.Address iarg1) {
		arg1 = iarg1;
	}

}
