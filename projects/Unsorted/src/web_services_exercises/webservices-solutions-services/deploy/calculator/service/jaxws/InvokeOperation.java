
package calculator.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "invokeOperation", namespace = "http://service.calculator/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invokeOperation", namespace = "http://service.calculator/", propOrder = {
	"arg0",
	"arg1"
})
public class InvokeOperation {

	@XmlElement(name = "arg0", namespace = "")
	private calculator.service.StatefulCalculator.Operation arg0;
	@XmlElement(name = "arg1", namespace = "")
	private float arg1;

	/**
	 *
	 * @return
	 *	 returns Operation
	 */
	public calculator.service.StatefulCalculator.Operation getArg0() {
		return this.arg0;
	}

	/**
	 *
	 * @param arg0
	 *	 the value for the arg0 property
	 */
	public void setArg0(calculator.service.StatefulCalculator.Operation arg0) {
		this.arg0 = arg0;
	}

	/**
	 *
	 * @return
	 *	 returns float
	 */
	public float getArg1() {
		return this.arg1;
	}

	/**
	 *
	 * @param arg1
	 *	 the value for the arg1 property
	 */
	public void setArg1(float arg1) {
		this.arg1 = arg1;
	}

}
