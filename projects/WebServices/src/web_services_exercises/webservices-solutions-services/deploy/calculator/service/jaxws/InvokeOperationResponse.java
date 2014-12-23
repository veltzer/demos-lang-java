
package calculator.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "invokeOperationResponse", namespace = "http://service.calculator/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invokeOperationResponse", namespace = "http://service.calculator/")
public class InvokeOperationResponse {

	@XmlElement(name = "return", namespace = "")
	private float vreturn;

	/**
	 *
	 * @return
	 *	 returns float
	 */
	public float getReturn() {
		return vreturn;
	}

	/**
	 *
	 * @param vreturn
	 *	 the value for the vreturn property
	 */
	public void setReturn(float ireturn) {
		vreturn = ireturn;
	}

}
