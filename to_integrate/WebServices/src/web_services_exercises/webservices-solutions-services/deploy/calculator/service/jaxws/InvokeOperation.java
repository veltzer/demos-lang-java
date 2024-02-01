
package calculator.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "invokeOperation", namespace = "http://service.calculator/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invokeOperation", namespace = "http://service.calculator/", propOrder = {
		"arg0", "arg1"
})
public class InvokeOperation {
	@XmlElement(name = "arg0", namespace = "")
	private calculator.service.StatefulCalculator.Operation arg0;
	@XmlElement(name = "arg1", namespace = "")
	private float arg1;

	public calculator.service.StatefulCalculator.Operation getArg0() {
		return arg0;
	}

	public void setArg0(calculator.service.StatefulCalculator.Operation iarg0) {
		arg0 = iarg0;
	}

	public float getArg1() {
		return arg1;
	}

	public void setArg1(float iarg1) {
		arg1 = iarg1;
	}

}
