package calendar.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "hebDayOfWeekResponse", namespace = "http://service.calendar/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hebDayOfWeekResponse", namespace = "http://service.calendar/")
public class HebDayOfWeekResponse {

	@XmlElement(name = "return", namespace = "")
	private String vreturn;

	public String getReturn() {
		return vreturn;
	}

	public void setReturn(String ireturn) {
		vreturn = ireturn;
	}

}
