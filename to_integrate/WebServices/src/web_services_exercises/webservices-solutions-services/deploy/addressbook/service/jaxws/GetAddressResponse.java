package addressbook.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAddressResponse", namespace = "http://service.addressbook/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAddressResponse", namespace = "http://service.addressbook/")
public class GetAddressResponse {

	@XmlElement(name = "return", namespace = "")
	private addressbook.service.Address vreturn;

	public addressbook.service.Address getReturn() {
		return vreturn;
	}

	public void setReturn(addressbook.service.Address ivreturn) {
		vreturn = ivreturn;
	}
}
