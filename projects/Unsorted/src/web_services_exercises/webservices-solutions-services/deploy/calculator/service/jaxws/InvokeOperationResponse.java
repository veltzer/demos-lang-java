
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
	private float _return;

	/**
	 *
	 * @return
	 *	 returns float
	 */
	public float get_return() {
		return this._return;
	}

	/**
	 *
	 * @param _return
	 *	 the value for the _return property
	 */
	public void set_return(float _return) {
		this._return = _return;
	}

}
