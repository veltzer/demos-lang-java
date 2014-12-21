
package helloworld.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "sayHelloResponse", namespace = "http://service.helloworld/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sayHelloResponse", namespace = "http://service.helloworld/")
public class SayHelloResponse {

	@XmlElement(name = "return", namespace = "")
	private String vreturn;

	/**
	 *
	 * @return
	 *	 returns String
	 */
	public String getReturn() {
		return vreturn;
	}

	/**
	 *
	 * @param vreturn
	 *	 the value for the _return property
	 */
	public void setReturn(String ireturn) {
		vreturn = ireturn;
	}

}
