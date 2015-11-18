
package calendar.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "hebDayName", namespace = "http://service.calendar/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hebDayName", namespace = "http://service.calendar/")
public class HebDayName {

	@XmlElement(name = "arg0", namespace = "")
	private int arg0;

	public int getArg0() {
		return arg0;
	}

	public void setArg0(int iarg0) {
		arg0 = iarg0;
	}

}
